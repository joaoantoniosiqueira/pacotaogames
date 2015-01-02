package br.com.pacotaogames.faces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.pacotaogames.daos.ClienteDAO;
import br.com.pacotaogames.daos.ParcelaDAO;
import br.com.pacotaogames.daos.VendaDao;
import br.com.pacotaogames.daos.VendaItemDAO;
import br.com.pacotaogames.entities.Cliente;
import br.com.pacotaogames.entities.Game;
import br.com.pacotaogames.entities.Parcela;
import br.com.pacotaogames.entities.Venda;
import br.com.pacotaogames.entities.VendaItem;

@ManagedBean
@SessionScoped
public class ClienteLogadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<VendaItem> carrinho;
	private Venda venda;
	private int quantidade;
	private String login;
	private String senha;
	
	@PostConstruct
	public void init(){	
		carrinho = new ArrayList<VendaItem>();
		venda = new Venda();
	}
	
	public String criarItemEAdd(Game game){
		
		VendaItem item = new VendaItem();
		item.setGame(game);
		item.setQuantidade(1);
		item.setTotal(item.calculaTotal(game));
		
		addCarrinho(item);	
		
		return "gotoCarrinho";
	}
	
	public void removerItem(VendaItem item){
		
		if(carrinho.contains(item)){
			carrinho.remove(item);
		}
	}
	
	public String logar(){
		
		cliente = new ClienteDAO().getClienteByLoginAndPassword(login, senha);
		
		if(cliente == null){
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos.", "Login ou senha inválidos.");
			context.addMessage(null, msg);
			
			return "refresh";
		}
		
		else{
			return "gotoIndex";
		}
	}
	
	public String procederCheckout(){
		
		venda.calculaTotal(carrinho);
		
		return "gotoCheckout";
	}
	
	private void addCarrinho(VendaItem item){
		
		getCarrinho().add(item);
	}
	
	public String concluirCompra(){
		
		venda.setCliente(cliente);
	
		//Cria a venda
		new VendaDao().salvar(venda);
		
		//Gera salvar os itens da venda
		for (VendaItem vendaItem : carrinho) {
			
			vendaItem.setVenda(venda);
			new VendaItemDAO().salvar(vendaItem);
		}
		
		//Gera as parcelas
		ParcelaDAO parcelaDAO = new ParcelaDAO();
		for (int i = 0; i < quantidade; i++) {
			
			Parcela parcela = new Parcela();
			parcela.setValor(venda.getTotal() / quantidade);
			parcela.setPago(false);
			parcela.setVenda(venda);
			parcela.setDataVencimento(Calendar.getInstance());
			
			parcelaDAO.salvar(parcela);
		}
		
		return "sucesso?faces-redirect=true";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public List<VendaItem> getCarrinho() {
		return carrinho;
	}
	public Venda getVenda() {
		return venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

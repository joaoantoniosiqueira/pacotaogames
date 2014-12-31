package br.com.pacotaogames.faces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.pacotaogames.entities.Cliente;
import br.com.pacotaogames.entities.Game;
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
	
	@PostConstruct
	public void init(){	
		carrinho = new ArrayList<VendaItem>();
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
	
	private void addCarrinho(VendaItem item){
		
		getCarrinho().add(item);
	}
	
	public String concluirCompra(){
		
		return "sucesso?faces-redirect=true";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<VendaItem> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<VendaItem> carrinho) {
		this.carrinho = carrinho;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}

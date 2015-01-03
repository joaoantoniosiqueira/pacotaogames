package br.com.pacotaogames.daos;

import java.util.ArrayList;
import java.util.List;

import br.com.pacotaogames.entities.Cliente;
import br.com.pacotaogames.entities.Parcela;

public class ClienteDAO extends GenericDAO<Cliente> {

	public void salvar(Cliente cliente){
		
		persist(cliente);
	}
	
	public Cliente getClienteByLoginAndPassword(String login, String password){
		
		return getPojo("getClienteByLoginAndPassword", login, password);
	}
	
	public List<Cliente> getClientesInadimplentes(){
		
		List<Parcela> parcelas = new ParcelaDAO().getParcelasNaoPagas();
		List<Cliente> inadimplentes = new ArrayList<Cliente>();
		
		for (Parcela parcela : parcelas) {
			if(!inadimplentes.contains(parcela.getVenda().getCliente())){
				inadimplentes.add(parcela.getVenda().getCliente());
			}
		}
		
		for (Cliente cliente : inadimplentes) {
			for (Parcela parcela : parcelas) {
				if(parcela.getVenda().getCliente().getId() == cliente.getId()){
					cliente.setTotalDevedor(cliente.getTotalDevedor() + parcela.getValor());
				}
			}
		}

		return inadimplentes;
	}
}

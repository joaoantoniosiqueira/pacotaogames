package br.com.pacotaogames.daos;

import br.com.pacotaogames.entities.Venda;

public class VendaDao extends GenericDAO<Venda> {

	public void salvar(Venda venda){
		
		persist(venda);
	}
}

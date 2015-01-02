package br.com.pacotaogames.daos;

import br.com.pacotaogames.entities.VendaItem;

public class VendaItemDAO extends GenericDAO<VendaItem> {

	public void salvar(VendaItem item){
		
		persist(item);
	}
}

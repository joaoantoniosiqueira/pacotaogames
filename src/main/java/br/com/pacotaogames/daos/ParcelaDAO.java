package br.com.pacotaogames.daos;

import br.com.pacotaogames.entities.Parcela;

public class ParcelaDAO extends GenericDAO<Parcela> {

	public void salvar(Parcela parcela){
		
		persist(parcela);
	}
}

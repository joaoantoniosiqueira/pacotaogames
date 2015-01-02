package br.com.pacotaogames.daos;

import java.util.List;

import br.com.pacotaogames.entities.Parcela;

public class ParcelaDAO extends GenericDAO<Parcela> {

	public void salvar(Parcela parcela){
		
		persist(parcela);
	}
	
	public List<Parcela> getParcelasNaoPagas(){
		
		return listar("getParcelasNaoPagas");
	}
}

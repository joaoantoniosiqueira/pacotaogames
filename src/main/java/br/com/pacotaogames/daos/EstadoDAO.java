package br.com.pacotaogames.daos;

import java.util.List;

import br.com.pacotaogames.entities.Estado;

public class EstadoDAO extends GenericDAO<Estado> {

	public List<Estado> getEstados(){
		
		return listar("getTodosEstados");
	}
}

package br.com.pacotaogames.daos;

import java.util.List;

import br.com.pacotaogames.entities.Cidade;
import br.com.pacotaogames.entities.Estado;

public class CidadeDAO extends GenericDAO<Cidade> {

	public List<Cidade> getCidadeByEstado(Estado estado){
		
		return listar("getCidadeByEstado", estado);
	}
}

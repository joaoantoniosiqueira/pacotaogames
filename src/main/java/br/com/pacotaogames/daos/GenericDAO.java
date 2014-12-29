package br.com.pacotaogames.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pacotaogames.utils.JPAUtil;

public abstract class GenericDAO<T> {

	protected EntityManager getEntityManager(){
		
		return JPAUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> listar(String queryName){
		
		Query query = getEntityManager().createNamedQuery(queryName);
		return query.getResultList();
	}
}

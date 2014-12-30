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
	protected List<T> listar(String queryName, Object... params){
		
		Query query = getEntityManager().createNamedQuery(queryName);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i+1, params[i]);
		}
		return query.getResultList();
	}
	
	protected void persist(T t){
		
		getEntityManager().persist(t);
	}
}

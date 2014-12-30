package br.com.pacotaogames.daos;

import br.com.pacotaogames.entities.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {

	public void salvar(Cliente cliente){
		
		persist(cliente);
	}
}

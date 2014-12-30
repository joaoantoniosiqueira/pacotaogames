package br.com.pacotaogames.faces.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pacotaogames.daos.ClienteDAO;
import br.com.pacotaogames.entities.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	
	@PostConstruct
	public void init(){		
		cliente = new Cliente();
	}
	
	public String salvar(){
		
		new ClienteDAO().salvar(cliente);
		return "sucesso?faces-redirect=true";
	}
	
	public Cliente getCliente(){
		return cliente;
	}
}

package br.com.pacotaogames.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.pacotaogames.daos.ClienteDAO;
import br.com.pacotaogames.entities.Cliente;

@Path("/clientes")
public class ClienteRest {

	@GET
	@Path("/inadimplentes")
	@Produces("application/json; charset=UTF-8")
	public List<Cliente> listAll(
			@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {		
		 
		final List<Cliente> clientes = new ClienteDAO().getClientesInadimplentes();
		return clientes;
	}
}

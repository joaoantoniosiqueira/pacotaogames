package pacotaogames;

import br.com.pacotaogames.daos.ClienteDAO;

import br.com.pacotaogames.entities.Cliente;

public class SingleResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente cliente = new ClienteDAO().getClienteByLoginAndPassword("joao", "12345");
		
		System.out.println(cliente);
	}

}

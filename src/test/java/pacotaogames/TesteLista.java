package pacotaogames;

import java.util.List;

import br.com.pacotaogames.daos.CidadeDAO;
import br.com.pacotaogames.daos.EstadoDAO;
import br.com.pacotaogames.entities.Cidade;
import br.com.pacotaogames.entities.Estado;

public class TesteLista {

	public static void main(String[] args) {
		
		List<Estado> estados = new EstadoDAO().getEstados();
		
		List<Cidade> cidades = new CidadeDAO().getCidadeByEstado(estados.get(9));
		
		int i = 0;
		for (Estado estado : estados) {
			
			i++;
			System.out.println("id = " + i + " " + estado.getDescricao());
		}
		
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getDescricao());
		}
	}

}

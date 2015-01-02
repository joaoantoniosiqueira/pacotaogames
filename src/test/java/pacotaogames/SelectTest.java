package pacotaogames;

import java.util.List;

import br.com.pacotaogames.daos.ClienteDAO;
import br.com.pacotaogames.daos.ParcelaDAO;
import br.com.pacotaogames.entities.Cliente;
import br.com.pacotaogames.entities.Parcela;

public class SelectTest {

	public static void main(String[] args) {
		
		List<Cliente> inadimplentes = new ClienteDAO().getClientesInadimplentes();
		List<Parcela> parcelasNaoPagas = new ParcelaDAO().getParcelasNaoPagas();
		
		for (Parcela parcela : parcelasNaoPagas) {
			System.out.println(parcela);
		}
		
		for (Cliente cliente : inadimplentes) {
			System.out.println(cliente.getNome());
		}
	}

}

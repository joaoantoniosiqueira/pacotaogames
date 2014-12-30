package pacotaogames;

import java.util.List;

import br.com.pacotaogames.daos.GameDAO;
import br.com.pacotaogames.entities.Game;
import br.com.pacotaogames.entities.enums.GeneroType;

public class TesteLista {

	public static void main(String[] args) {
		
		System.out.println(GeneroType.AVENTURA.getLabel());
		
		List<Game> games = new GameDAO().getGameByGenero(GeneroType.AVENTURA);
		for (Game game : games) {
			System.out.println(game);
		}
		
	}

}

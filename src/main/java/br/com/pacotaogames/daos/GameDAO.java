package br.com.pacotaogames.daos;

import java.util.List;

import br.com.pacotaogames.entities.Game;
import br.com.pacotaogames.entities.enums.GeneroType;

public class GameDAO extends GenericDAO<Game> {

	public void salvar(Game game){
		
		persist(game);
	}
	
	public List<Game> getGames(){
		
		return listar("getTodosGames");
	}
	
	public List<Game> getGameByGenero(GeneroType generoType){
		
		return listar("getGameByGenero", generoType.getLabel());
	}
}

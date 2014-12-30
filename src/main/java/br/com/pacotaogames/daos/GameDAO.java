package br.com.pacotaogames.daos;

import br.com.pacotaogames.entities.Game;

public class GameDAO extends GenericDAO<Game> {

	public void salvar(Game game){
		
		persist(game);
	}
}

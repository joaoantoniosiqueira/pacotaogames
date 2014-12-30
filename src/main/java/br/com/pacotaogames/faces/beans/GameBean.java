package br.com.pacotaogames.faces.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pacotaogames.daos.GameDAO;
import br.com.pacotaogames.entities.Game;

@ManagedBean
@ViewScoped
public class GameBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	@PostConstruct
	public void init(){
		game = new Game();
	}

	public String salvar(){
		
		game.setDescricao(game.getDescricao().toUpperCase());
		
		new GameDAO().salvar(game);
		return "sucesso?faces-redirect=true";
	}
	
	public Game getGame(){
		return game;
	}
}

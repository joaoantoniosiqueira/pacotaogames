package br.com.pacotaogames.faces.beans;

import java.io.Serializable;

import br.com.pacotaogames.entities.Game;
import br.com.pacotaogames.entities.Venda;

public class VendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Game game;
	private Venda venda;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}

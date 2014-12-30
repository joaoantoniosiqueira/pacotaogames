package br.com.pacotaogames.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries(value={
		@NamedQuery(name="getTodosGames", query="select g from Game g order by g.descricao"),
		@NamedQuery(name="getGameByGenero", query="select g from Game g where g.genero = ?1 order by g.descricao")
})
@Entity
@Table(name="game")
public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gam_id")
	private Integer id;
	
	@Size(min=5, max=255, message="O nome do jogo deve ter entre 5 a 255 caracteres.")
	@NotNull(message="Informe o nome do jogo")
	@Column(name="gam_nome", length=255, nullable=false)
	private String descricao;
	
	@NotNull(message="Selecione o genero do jogo.")
	@Column(name="gam_genero", nullable=false)
	private String genero;
	
	@Column(name="gam_preco", nullable=false)
	private Double preco;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

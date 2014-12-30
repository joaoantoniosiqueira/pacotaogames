package br.com.pacotaogames.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="getTodosEstados", query="select e from Estado e order by e.descricao")
@Entity
@Table(name="estado")
public class Estado implements Serializable, BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="est_id", length=2)
	private String id;
	
	@Column(name="est_nome", length=25)
	private String descricao;
	
	@Column(name="est_regiao")
	private String regiao;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	@Override
	public String toString() {
		return descricao;
	}

}

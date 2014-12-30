package br.com.pacotaogames.faces.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pacotaogames.daos.CidadeDAO;
import br.com.pacotaogames.daos.EstadoDAO;
import br.com.pacotaogames.entities.Cidade;
import br.com.pacotaogames.entities.Estado;

@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Estado> estados;
	private List<Cidade> cidades;
	
	private Estado estado;
	
	@PostConstruct
	public void init(){
		estado = null;
	}
	
	public void quandoMudarEstado(){
		
		System.out.println("Sabia que eu tinha que botar essa porra!");
		if(estado != null){
			System.out.println("Chamou o metodo");
			cidades = new CidadeDAO().getCidadeByEstado(estado);
		}	
	}

	public List<Estado> getEstados() {
		
		if(estados == null){
			estados = new EstadoDAO().getEstados();
		}
		return estados;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}

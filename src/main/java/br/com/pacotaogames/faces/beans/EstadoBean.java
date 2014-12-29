package br.com.pacotaogames.faces.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pacotaogames.daos.EstadoDAO;
import br.com.pacotaogames.entities.Estado;

@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Estado> estados;

	public List<Estado> getEstados() {
		
		if(estados == null){
			estados = new EstadoDAO().getEstados();
		}
		return estados;
	}

}

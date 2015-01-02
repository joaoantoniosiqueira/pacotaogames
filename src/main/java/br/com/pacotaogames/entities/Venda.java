package br.com.pacotaogames.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="venda")
public class Venda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ven_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ven_cliente", nullable=false)
	private Cliente cliente;
	
	@Column(name="ven_total", nullable=false)
	private Double total;
	
	@Column(name="ven_tipoPagamento", nullable=false)
	private String tipoPagamento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void calculaTotal(List<VendaItem> items){
		
		Double total = new Double(0);
		for (VendaItem item : items) {
			
			total = item.getTotal() + total;
		}
		
		this.setTotal(total);
	}
}

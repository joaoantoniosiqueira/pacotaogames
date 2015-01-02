package br.com.pacotaogames.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@NamedQueries(value={
		@NamedQuery(name="getClienteByLoginAndPassword", query="select c from Cliente c where c.login = ?1 and c.senha = ?2")
})
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id")
	private Integer id;
	
	@NotNull(message="Informe o nome do cliente")
	@Size(min=5, max=255, message="O nome do cliente deve ter entre 5 a 255 caracteres.")
	@Column(name="cli_nome", length=255)
	private String nome;
	
	@NotNull(message="Selecione a cidade")
	@ManyToOne
	@JoinColumn(name="cli_cidade", nullable=false)
	private Cidade cidade;
	
	@NotNull(message="Informe o bairro do cliente")
	@Size(min=5, max=45, message="O nome do bairro deve ter entre 5 a 45 caracteres.")
	@Column(name="cli_bairro", nullable=false, length=45)
	private String bairro;
	
	@NotNull(message="Informe o CEP do cliente")
	@Column(name="cli_cep", nullable=false)
	private String cep;
	
	@NotNull(message="Informe o endere√ßo do cliente")
	@Size(min=5, max=255, message="O endere√ßo do cliente deve ter entre 5 a 255 caracteres.")
	@Column(name="cli_endereco", nullable=false, length=255)
	private String endereco;
	
	@Size(min=9, max=14, message="Informe um n√∫mero de telefone v√°lido")
	@Column(name="cli_fone")
	private String fone;
	
	@Email(message="Informe um endereÁo de e-mail v·lido.")
	@Column(name="cli_email")
	private String email;
	
	@NotNull(message="Informe o login do usu·rio.")
	@Column(name="cli_login", length=45)
	private String login;
	
	@NotNull(message="Insira a senha do usu·rio.")
	@Column(name="cli_senha", length=45)
	private String senha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return nome;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

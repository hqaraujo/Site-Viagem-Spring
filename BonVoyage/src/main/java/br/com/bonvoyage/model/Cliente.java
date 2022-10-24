package br.com.bonvoyage.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;

	@Column(nullable = false)
	private String cpf_cliente;

	
	@Column(nullable = false)
	private String nome_cliente;
	
	@Column(nullable = false)
	private String email_cliente;
	
	@ManyToOne
	@JoinColumn(name = "Id_login")
	private Login login;


	
	public Cliente() {
	}

	public Cliente(Long id_cliente, String cpf_cliente, String nome_cliente, String email_cliente, Login login) {
		super();
		this.id_cliente = id_cliente;
		this.cpf_cliente = cpf_cliente;
		this.nome_cliente = nome_cliente;
		this.email_cliente = email_cliente;
		this.login = login;
	}



	
	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(cpf_cliente, email_cliente, id_cliente, login, nome_cliente);
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
		return Objects.equals(cpf_cliente, other.cpf_cliente) && Objects.equals(email_cliente, other.email_cliente)
				&& Objects.equals(id_cliente, other.id_cliente) && Objects.equals(login, other.login)
				&& Objects.equals(nome_cliente, other.nome_cliente);
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", cpf_cliente=" + cpf_cliente + ", nome_cliente=" + nome_cliente
				+ ", email_cliente=" + email_cliente + ", login=" + login + "]";
	}

	

}

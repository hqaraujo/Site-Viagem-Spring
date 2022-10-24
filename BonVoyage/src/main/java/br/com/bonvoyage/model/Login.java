package br.com.bonvoyage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_login;

	@Column(nullable = false)
	private String tipo_login;

	public Login() {
	}

	public Login(Long id_login, String tipo_login) {
		this.id_login = id_login;
		this.tipo_login = tipo_login;

	}

	
	public Long getId_login() {
		return id_login;
	}

	public void setId_login(Long id_login) {
		this.id_login = id_login;
	}

	public String getTipo_login() {
		return tipo_login;
	}

	public void setTipo_login(String tipo_login) {
		this.tipo_login = tipo_login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((id_login == null) ? 0 : id_login.hashCode());
		result = prime * result + ((tipo_login == null) ? 0 : tipo_login.hashCode());

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
		Login other = (Login) obj;

		if (id_login == null) {
			if (other.id_login != null)
				return false;
		} else if (!id_login.equals(other.id_login))
			return false;
		if (tipo_login == null) {
			if (other.tipo_login != null)
				return false;
		} else if (!tipo_login.equals(other.tipo_login))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return " [id_login=" + id_login + ",  tipo_login=" + tipo_login + "]";
	}

}

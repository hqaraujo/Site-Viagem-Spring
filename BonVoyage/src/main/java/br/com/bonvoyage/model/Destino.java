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
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_destino;

	@Column(nullable = false)
	private String pais;

	@Column(nullable = false)
	private String cidade;
	
	@ManyToOne
	@JoinColumn(name = "Id_pacote")
	private Pacotes pacotes;
	
	public Destino() {
	}

	public Destino(Long id_destino, String pais, String cidade, Pacotes pacotes) {
		this.id_destino = id_destino;
		this.pais = pais;
		this.cidade = cidade;
		this.pacotes = pacotes;
	}

	public Long getId_destino() {
		return id_destino;
	}

	public void setId_destino(Long id_destino) {
		this.id_destino = id_destino;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Pacotes getPacotes() {
		return pacotes;
	}

	public void setPacotes(Pacotes pacotes) {
		this.pacotes = pacotes;
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(cidade, id_destino, pacotes, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(id_destino, other.id_destino)
				&& Objects.equals(pacotes, other.pacotes) && Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "Destino [id_destino=" + id_destino + ", pais=" + pais + ", cidade=" + cidade + ", pacotes=" + pacotes
				+ "]";
	}

	
	
	

}

package br.com.bonvoyage.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;




@Entity
@Table
public class Pacotes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pacote;

	@Column(nullable = false)
	private String origem;

	@Column(nullable = false)
	private double promocao;

	public Pacotes() {
	}

	public Pacotes(Long id_pacote, String origem, double promocao) {
		this.id_pacote = id_pacote;
		this.origem = origem;
		this.promocao = promocao;
	}

	public Long getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(Long id_pacote) {
		this.id_pacote = id_pacote;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public double getPromocao() {
		return promocao;
	}

	public void setPromocao(double promocao) {
		this.promocao = promocao;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_pacote, origem, promocao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacotes other = (Pacotes) obj;
		return Objects.equals(id_pacote, other.id_pacote) && Objects.equals(origem, other.origem)
				&& Double.doubleToLongBits(promocao) == Double.doubleToLongBits(other.promocao);
	}

	@Override
	public String toString() {
		return "Pacotes [id_pacote=" + id_pacote + ", origem=" + origem + ", promocao=" + promocao + "]";
	}

}

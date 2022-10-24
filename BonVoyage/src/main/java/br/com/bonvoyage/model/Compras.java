package br.com.bonvoyage.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Compras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compras;

	@Column(nullable = false)
	private String forma_pagamento;

	@Column(nullable = false, name = "data_compras")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_compras;

	@Column(nullable = false)
	private double valor;
	
	@Column(nullable = false)
	private double valor_total;
	
	@ManyToOne
	@JoinColumn(name = "Id_cliente")
	private Cliente clientes;
	
	@ManyToOne
	@JoinColumn(name = "Id_destino")
	private Destino destino;
	
	
	



	public Compras() {
	}

	public Compras(Long id_compras, String forma_pagamento, LocalDate data_compras, double valor, double valor_total, Cliente clientes, Destino destino) {
		this.id_compras = id_compras;
		this.forma_pagamento = forma_pagamento;
		this.data_compras = data_compras;
		this.valor = valor;
		this.valor_total = valor_total;
		this.clientes = clientes;
		this.destino = destino;
	}

	

	public Long getId_compras() {
		return id_compras;
	}

	public void setId_compras(Long id_compras) {
		this.id_compras = id_compras;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public LocalDate getData_compras() {
		return data_compras;
	}

	public void setData_compras(LocalDate data_compras) {
		this.data_compras = data_compras;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(clientes, data_compras, destino, forma_pagamento, id_compras, valor, valor_total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compras other = (Compras) obj;
		return Objects.equals(clientes, other.clientes) && Objects.equals(data_compras, other.data_compras)
				&& Objects.equals(destino, other.destino) && Objects.equals(forma_pagamento, other.forma_pagamento)
				&& Objects.equals(id_compras, other.id_compras)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor)
				&& Double.doubleToLongBits(valor_total) == Double.doubleToLongBits(other.valor_total);
	}

	@Override
	public String toString() {
		return "Compras [id_compras=" + id_compras + ", forma_pagamento=" + forma_pagamento + ", data_compras="
				+ data_compras + ", valor=" + valor + ", valor_total=" + valor_total + ", clientes=" + clientes
				+ ", destino=" + destino + "]";
	}

	

}

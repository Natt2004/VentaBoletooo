package org.VentaBoleto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Boleto")
public class Boleto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long ID;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	
	@ManyToOne
	@JoinColumn
	private Aerolinea aerolinea;


	public Boleto() {
		super();
	}


	public Boleto(Long iD, Usuario usuario, Cliente cliente, Aerolinea aerolinea) {
		super();
		this.ID = iD;
		this.usuario = usuario;
		this.cliente = cliente;
		this.aerolinea = aerolinea;
	}


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Aerolinea getAerolinea() {
		return aerolinea;
	}


	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	
	
	
}

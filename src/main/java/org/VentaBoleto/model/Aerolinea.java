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
@Table(name = "Aerolinea")
public class Aerolinea {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@Column(name="telefono")
	private int telefono;
	@Column(name="correo")
	private String correo;
	
	
	@ManyToOne
	@JoinColumn
	private Destino NombreDestino;


	public Aerolinea() {
		super();
	}


	public Aerolinea(int id, String nombre, String direccion, int telefono, String correo, Destino nombreDestino) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		NombreDestino = nombreDestino;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Destino getNombreDestino() {
		return NombreDestino;
	}


	public void setNombreDestino(Destino nombreDestino) {
		NombreDestino = nombreDestino;
	}
	
	
}

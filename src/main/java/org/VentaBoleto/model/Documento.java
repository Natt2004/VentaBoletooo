package org.VentaBoleto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Documento")
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int idDoc;
	@Column(name="nombre")
	private String nombre;
	public Documento() {
		super();
	}
	public Documento(int idDoc, String nombre) {
		super();
		this.idDoc = idDoc;
		this.nombre = nombre;
	}
	public int getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}

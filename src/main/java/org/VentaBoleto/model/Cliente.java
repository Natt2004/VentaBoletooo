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
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Cliente")
	private int idCliente;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="Direccion")
	private String direccion;
	@Column(name="correo")
	private String correo;
	
	
	@ManyToOne
	@JoinColumn
	private Documento NombreDoc;
	
	
	@Column(name="Nro_Doc")
	private int nro_documento;


	public Cliente() {
		super();
	}


	public Cliente(int idCliente, String nombre, String apellido, String direccion, String correo, Documento nombre2,
			int nro_documento) {
		
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correo = correo;
		NombreDoc = nombre2;
		this.nro_documento = nro_documento;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Documento getNombreDoc() {
		return NombreDoc;
	}


	public void setNombreDoc(Documento nombreDoc) {
		NombreDoc = nombreDoc;
	}


	public int getNro_documento() {
		return nro_documento;
	}


	public void setNro_documento(int nro_documento) {
		this.nro_documento = nro_documento;
	}
	
	
	
}

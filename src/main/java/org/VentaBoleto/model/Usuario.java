package org.VentaBoleto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_usuario")
	private int idUsuario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="correo")
	private String correo;
	@Column(name="password")
	private String password;
	@Column(name="telefono")
	private int telefono;
	public Usuario() {
		super();
	}
	public Usuario(int idUsuario, String nombre, String correo, String password, int telefono) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.telefono = telefono;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	

}

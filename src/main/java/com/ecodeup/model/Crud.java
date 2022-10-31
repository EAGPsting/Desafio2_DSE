package com.ecodeup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crud")
public class Crud {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcrud;
	@Column
	private String Nombre;
	@Column
	private String Apellido;
	@Column
	private String Telefono;
	@Column
	private String Pais;
	@Column
	private String Ciudad;
	@Column
	private String Carnet;
	
	
	public Long getId() {
		return idcrud;
	}
	public void setId(Long id) {
		this.idcrud = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		this.Pais = pais;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		this.Ciudad = ciudad;
	}
	public String getCarnet() {
		return Carnet;
	}
	public void setCarnet(String carnet) {
		this.Carnet = carnet;
	}
	@Override
	public String toString() {
		return "crud [idcrud=" + idcrud + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Telefono=" + Telefono + ", Pais=" + Pais + ", Ciudad=" + Ciudad + ", Carnet=" + Carnet + "]";
	}
	
}
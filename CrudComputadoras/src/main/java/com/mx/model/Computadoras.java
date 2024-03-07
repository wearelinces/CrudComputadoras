/**
 * 
 */
package com.mx.model;

/**
 * @author ofici
 *
 */
public class Computadoras {

	private int id;
	private String serie;
	private int precio;
	private int ram;
	private String tipo_disco;
	
	public Computadoras() {
	}

	public Computadoras(int id) {
		this.id = id;
	}

	public Computadoras(int id, String serie, int precio, int ram, String tipo_disco) {
	
		this.id = id;
		this.serie = serie;
		this.precio = precio;
		this.ram = ram;
		this.tipo_disco = tipo_disco;
	}

	@Override
	public String toString() {
		return "Computadora [id=" + id + ", serie=" + serie + ", precio=" + precio + ", ram=" + ram + ", tipo_disco="
				+ tipo_disco + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getTipo_disco() {
		return tipo_disco;
	}

	public void setTipo_disco(String tipo_disco) {
		this.tipo_disco = tipo_disco;
	}
	
	
}

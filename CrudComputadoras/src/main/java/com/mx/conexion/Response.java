/**
 * 
 */
package com.mx.conexion;

import com.mx.model.Computadoras;

/**
 * @author ofici
 *
 */
public class Response {
	private String mensaje;
	 private int estatus;
	 Computadoras computadoras;
	public Response() {
		 
	}
	public Response(String mensaje, int estatus, Computadoras computadoras) {
		super();
		this.mensaje = mensaje;
		this.estatus = estatus;
		this.computadoras = computadoras;
	}
	@Override
	public String toString() {
		return "Response [mensaje=" + mensaje + ", estatus=" + estatus + ", computadoras=" + computadoras + "]";
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public Computadoras getComputadoras() {
		return computadoras;
	}
	public void setComputadoras(Computadoras computadoras) {
		this.computadoras = computadoras;
	}
	 
	 
}
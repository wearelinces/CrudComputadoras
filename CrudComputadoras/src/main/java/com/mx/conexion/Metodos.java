/**
 * 
 */
package com.mx.conexion;

import java.util.List;

import com.mx.model.Computadoras;

/**
 * @author ofici
 *
 */
public interface Metodos {
	public String guardad (Computadoras computadoras);
	public List<Computadoras> listar();
	public Computadoras buscar(Computadoras computadoras);
	public String editar (Computadoras computadoras);
	public String eliminar(Computadoras computadoras);
}

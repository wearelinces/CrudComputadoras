/**
 * 
 */
package com.mx.controller;

import com.mx.dao.Implementacion;
import com.mx.model.Computadoras;

/**
 * @author ofici
 *
 */
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Implementacion imp = new Implementacion();
		
		// guardar
		Computadoras computadoras = new Computadoras(1, "123kjh2h3j4",25000,64,"M.2");
		imp.guardad(computadoras);
		
		// listar
		System.out.println(imp.listar());
		
		// buscar
		computadoras = new Computadoras(2);
		computadoras = imp.buscar(computadoras);
		System.out.println("SE ENCONTRO " + computadoras);
		
		
		//para editar hay que buscar
				computadoras = new Computadoras(2);
				computadoras= imp.buscar(computadoras);
				System.out.println("se encontro la computadora a editar" + computadoras.getSerie());
				
				//actualizar
				computadoras.setPrecio(19000);
				imp.editar(computadoras);
				
				//eliminar
				Computadoras empleadoEliminar = new Computadoras(3); 
				String estatusEliminacion = imp.eliminar(empleadoEliminar);
				System.out.println("Computadora eliminado: " + estatusEliminacion);
			
		
}
}

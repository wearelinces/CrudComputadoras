/**
 * 
 */
package com.mx.webService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.conexion.Response;
import com.mx.dao.Implementacion;
import com.mx.model.Computadoras;

/**
 * @author ofici
 *
 */
@Path("ComputadorasWs")

public class ComputadorasWs {
	// Formar la url  utilizando protocolo htpps  web service de tipo rest json
		//url erl_servidor local + nombre de blojecto en minusculas mas path clase + path metodo tal cual como esta realizado
		//http://localhost:7080/CrudComputadoras/crudComputadoras/ComputadorasWs/listar
		
		
		// instancia de clase // en donde  se encuentra la logica de los metodos 
		Implementacion imp = new Implementacion();
		
		// peticion de listar
		@Path("listar")
		@GET
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		public List<Computadoras> listar() {
			return imp.listar();			
			}
		//peticion guardar
		// http://localhost:7080/CrudComputadoras/crudComputadoras/ComputadorasWs/guardar
		@Path("guardar")
		@POST
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		
		public Response guardar (Computadoras computadoras){
			
			Response rsp = new Response();	
			String objGuardado = imp.guardad(computadoras);
			
			
			if (objGuardado.equals("guardado")) {
				rsp.setMensaje("se guardo el empleado");
				rsp.setEstatus(1);
				rsp.setComputadoras(computadoras);
			}else {
				rsp.setMensaje("No se guardo el empleado");
				rsp.setEstatus(0);
			}
			return rsp;
	}
		//// http://localhost:7080/CrudComputadoras/crudComputadoras/ComputadorasWs/buscar
		@Path("buscar")
		@POST
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		public Computadoras buscar(Computadoras computadoras) {
			return imp.buscar(computadoras);
		}
		
		
		//http://localhost:9000/CrudLibros/crudLibros/LibrosWs/editar
		@Path("editar")
		@POST
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		
		public Response editar (Computadoras computadoras){
			
			Response rsp = new Response();	
			String updateObj = imp.editar(computadoras);
			
			
			if (updateObj.equals("si")) {
				rsp.setMensaje("se edito correctamente");
				rsp.setEstatus(1);
				rsp.setComputadoras(computadoras);
			}else if (updateObj.equals("no")){
				rsp.setMensaje("No se guardo el empleado");
				rsp.setEstatus(0);
			}
			return rsp;
		}
		
		//http://localhost:7080/CrudComputadoras/crudComputadoras/ComputadorasWs/eliminar
		@Path("eliminar")
		@POST
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		
		public Response eliminar (Computadoras computadoras){
			
			Response rsp = new Response();	
			String deletObj = imp.eliminar(computadoras);
			
			
			if (deletObj.equals("eliminado")) {
				rsp.setMensaje("se elimino correctamente");
				rsp.setEstatus(1);
				rsp.setComputadoras(computadoras);
			}else {
				rsp.setMensaje("no eliminado");
				rsp.setEstatus(0);
			}
			return rsp;
		}
}

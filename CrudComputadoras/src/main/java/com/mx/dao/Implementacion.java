package com.mx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mx.conexion.ConexionBd;
import com.mx.conexion.Metodos;
import com.mx.model.Computadoras;

/**
 * @author ofici
 *
 */
public class Implementacion implements Metodos {

	ConexionBd bd = new ConexionBd();
	
	@Override
	public String guardad(Computadoras computadoras) {
		// TODO Auto-generated method stub
		// delcaracion de bariables
		Connection conexion;
		PreparedStatement pst;
		String query = "INSERT INTO COMPUTADORAS VALUES (?,?,?,?,?)";
		String estatus = null;
		try {
	        // Cargar el driver de conexión
	        Class.forName(bd.getDriver());
	        // Realizar la conexión
	        conexion = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPass());
	        
	        // Verificar si la serie ya existe en la base de datos
	        String verificarQuery = "SELECT SERIE FROM COMPUTADORAS WHERE SERIE = ?";
	        pst = conexion.prepareStatement(verificarQuery);
	        pst.setString(1, computadoras.getSerie());
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            System.out.println("La serie ya existe en la base de datos.");
	            estatus = "no guardado";
	            return estatus;
	        }
	        
	        // Preparar conexión y ejecutar
	        pst = conexion.prepareStatement(query);
	        pst.setInt(1, computadoras.getId());
	        pst.setString(2, computadoras.getSerie());
	        pst.setInt(3, computadoras.getPrecio());
	        pst.setInt(4, computadoras.getRam());
	        pst.setString(5, computadoras.getTipo_disco());
	        // Finaliza la ejecución de la query
	        int insertObj = pst.executeUpdate();

	        // Condición para saber si se guardó
	        if (insertObj > 0) {
	            System.out.println("Se guardó exitosamente.");
	            estatus = "guardado";
	        } else {
	            System.out.println("No se guardó, verifica la información.");
	            estatus = "no guardado";
	        }
	    } catch (Exception e) {
	        // Manejar excepciones
	        System.out.println("Error al guardar: " + e.getMessage());
	        estatus = "error";
	    } 
	    return estatus;
	}

	@Override
	public List<Computadoras> listar() {
		// TODO Auto-generated method stub
		// declarar lista
		List<Computadoras> lista = new ArrayList<Computadoras>();

		// declarar las variables
		Connection conexion; // creauna conexion mediante el objeto connection
		PreparedStatement pst; // prepara la conecion
		// declaracion de sentencia de codigo sql -- listas
		String query = "SELECT * FROM COMPUTADORAS";
		// RECIBIR RESPUESTA
		ResultSet rs = null; // metodo de java para apuntar a la fila actual

		try {
			// cargar el controlador
			Class.forName(bd.getDriver());
			// conexion
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPass());
			// ejecutar query
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				lista.add(new Computadoras(rs.getInt("ID"), rs.getString("SERIE"), rs.getInt("PRECIO"),
						rs.getInt("RAM"), rs.getString("TIPO_DISCO")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL LISTAR" + e.getMessage());
		}

		return lista;
	}

	@Override
	public Computadoras buscar(Computadoras computadoras) {
		// TODO Auto-generated method stub
		// recepcion de respuesta
		Computadoras comp = null;

		// declarar las variables
		Connection conexion; // creauna conexion mediante el objeto connection
		PreparedStatement pst; // prepara la conecion
		// declaracion de sentencia de codigo sql -- listas
		String query = "SELECT * FROM COMPUTADORAS WHERE ID =" + computadoras.getId();
		// RECIBIR RESPUESTA
		ResultSet rs = null; // metodo de java para apuntar a la fila actual

		try {
			Class.forName(bd.getDriver());
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPass());
			pst = conexion.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs.next()) {
				comp = new Computadoras(rs.getInt("ID"), rs.getString("SERIE"), rs.getInt("PRECIO"),
						rs.getInt("RAM"), rs.getString("TIPO_DISCO"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return comp;
	}
	@Override
	public String editar(Computadoras computadoras) {
		// TODO Auto-generated method stub
		Connection conexion;
		PreparedStatement pst;
		String query = "UPDATE COMPUTADORAS SET SERIE = ?, PRECIO = ?, RAM = ?, TIPO_DISCO= ? WHERE ID = ?";

		String estatus = null;

		try {
			Class.forName(bd.getDriver());
			conexion = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPass());
			pst = conexion.prepareStatement(query);
			// pasar los datos de la query

			
			
			pst.setString(1, computadoras.getSerie());
			pst.setInt(2, computadoras.getPrecio());
			pst.setInt(3, computadoras.getRam());
			pst.setString(4, computadoras.getTipo_disco());
			pst.setInt(5, computadoras.getId());
			int updateObj = pst.executeUpdate();

			if (updateObj > 0) {
				System.out.println("Se edito correctamente");
				estatus = "si";
			} else {
				System.out.println("No se edito");
				estatus = "no";
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al editar " + e.getMessage());
		}

		return estatus;
	}


	@Override
	public String eliminar(Computadoras computadoras) {
		// TODO Auto-generated method stub
		Connection conexion = null;
	    PreparedStatement pst = null;
	    String estatus = null;
	    
	    try {
	        // Cargar el controlador
	        Class.forName(bd.getDriver());
	        
	        // Establecer la conexión
	        conexion = DriverManager.getConnection(bd.getUrl(), bd.getUser(), bd.getPass());
	        
	        // Crear la sentencia SQL para eliminar
	        String query = "DELETE FROM COMPUTADORAS WHERE ID = ?";
	        pst = conexion.prepareStatement(query);
	        
	        // Establecer el parámetro ID para la eliminación
	        pst.setInt(1, computadoras.getId());
	        
	        // Ejecutar la eliminación
	        int deleteObj = pst.executeUpdate();
	        
	        // Verificar si se eliminó correctamente
	        if (deleteObj > 0) {
	            System.out.println("Se eliminó correctamente");
	            estatus = "eliminado";
	        } else {
	            System.out.println("No se eliminó el registro");
	            estatus = "no eliminado";
	        }
	    } catch (ClassNotFoundException cnfe) {
	        // Capturar excepción de clase no encontrada
	        System.out.println("No se encontró el controlador: " + cnfe.getMessage());
	        estatus = "error";
	    } catch (SQLException sqle) {
	        // Capturar excepción de SQL
	        System.out.println("Error SQL: " + sqle.getMessage());
	        estatus = "error";
	    } finally {
	        // Cerrar recursos en el bloque finally
	        if (pst != null) {
	            try {
	                pst.close();
	            } catch (SQLException sqle) {
	                System.out.println("Error al cerrar PreparedStatement: " + sqle.getMessage());
	            }
	        }
	        if (conexion != null) {
	            try {
	                conexion.close();
	            } catch (SQLException sqle) {
	                System.out.println("Error al cerrar Connection: " + sqle.getMessage());
	            }
	        }
	    }

	    return estatus;
	}


}

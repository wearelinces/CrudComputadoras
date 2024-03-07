/**
 * 
 */
package com.mx.conexion;

/**
 * @author ofici
 *
 */
public class ConexionBd {
	// Atributos
				private String driver;
				private String url;
				private String user;
				private String pass;
			public ConexionBd() {
				driver ="oracle.jdbc.OracleDriver";
				url = "jdbc:oracle:thin:@localhost:1521:xe";
				user ="System";
				pass = "linx";
				
			}
			public String getDriver() {
				return driver;
			}
			public void setDriver(String driver) {
				this.driver = driver;
			}
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
			public String getUser() {
				return user;
			}
			public void setUser(String user) {
				this.user = user;
			}
			public String getPass() {
				return pass;
			}
			public void setPass(String pass) {
				this.pass = pass;
			}
}

package ar.jluque.hibernate.pruebaconexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConection {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false", "root", "1234");
			con.close();
			System.out.println("||||| PRUEBA DE CONEXION CON BASE DE DATOS EXITOSA...");
			
		} catch (Exception e) {
			System.out.println("XXXXX NO SE PUDO ESTABLECER LA CONEXION CON LA BASE DE DATOS. \n");
			e.printStackTrace();
		}
		
	}

}

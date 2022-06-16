package com.parameta.prueba.ws.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	//Credenciales BD
	private static final String JDBC_URL = "Jdbc:mysql://localhost:3306/ingreso";
	private static final String JDBC_USER ="root";
	private static final String JDBC_PASS ="";
	private static final String JDBC_NAME ="com.mysql.cj.jdbc.Driver";
	
	
	//Conectar a la BD
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_NAME);
			System.out.println("Conexión a la BD OK");
		} catch (Exception e) {
			System.out.println("Falló la carga del controlador");
		}
		try {
			conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BD");
		}
		return conn;
	}
	
	//Cerrar conexión a la BD
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void close(PreparedStatement rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	public static void close(Connection rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}

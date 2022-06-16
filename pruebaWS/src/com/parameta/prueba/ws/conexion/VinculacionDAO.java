package com.parameta.prueba.ws.conexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.parameta.prueba.ws.interfaz.VinculacionInterface;
import com.parameta.prueba.ws.modelo.Vinculacion;

public class VinculacionDAO implements VinculacionInterface{

	private Conexion conn = new Conexion();
	
	//Constantes SQL
	private static final String SQL_INSERT="INSERT INTO vinculacion (persona_id, fecha_nacimiento, fecha_vinculacion, cargo, salario) VALUES (?,?,?,?,?)";
	
	@Override
	public int guardar(Vinculacion vinculacion) {
		Connection con = null;
		PreparedStatement ps = null;
		int rows=0;
		try {
			con = conn.getConnection();
			ps = con.prepareStatement(SQL_INSERT);
			ps.setInt(1,vinculacion.getpersona_id().getId());
			ps.setDate(2, (Date) vinculacion.getfecha_nacimiento());
			ps.setDate(3, (Date) vinculacion.getfecha_vinculacion());
			ps.setString(4, vinculacion.getCargo());
			ps.setDouble(5, vinculacion.getSalario());
			
			rows = ps.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace(System.out);
		}finally {
			conn.close(con);
			conn.close(ps);
		}
		return rows;
	}

}

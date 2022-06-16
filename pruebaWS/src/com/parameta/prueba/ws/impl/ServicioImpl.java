package com.parameta.prueba.ws.impl;

import javax.jws.WebService;

import com.parameta.prueba.ws.conexion.VinculacionDAO;
import com.parameta.prueba.ws.interfaz.VinculacionInterface;
import com.parameta.prueba.ws.modelo.Vinculacion;

@WebService(endpointInterface = "com.parameta.prueba.ws.interfaz.VinculacionInterface")
public class ServicioImpl implements VinculacionInterface{
	private VinculacionInterface vinculacionInterface = new VinculacionDAO();

	@Override
	public int guardar(Vinculacion vinculacion) {
		return vinculacionInterface.guardar(vinculacion);
	}

}

package com.parameta.prueba.ws.interfaz;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.parameta.prueba.ws.modelo.Vinculacion;

@WebService
public interface VinculacionInterface {

	@WebMethod
	public int guardar(Vinculacion vinculacion);
}

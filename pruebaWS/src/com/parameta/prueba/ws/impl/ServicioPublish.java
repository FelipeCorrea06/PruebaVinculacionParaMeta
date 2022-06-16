package com.parameta.prueba.ws.impl;

import javax.xml.ws.Endpoint;

public class ServicioPublish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:2022/ws/servicio", new ServicioImpl());
		System.out.println("Servicio en ejecución...");
	}

}

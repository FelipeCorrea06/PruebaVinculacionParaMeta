package com.parameta.prueba.model;

public class RespuestaRest {

	private Boolean respuesta;
	private String mensaje;
	private String error;
	public Boolean getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public RespuestaRest(Boolean respuesta, String mensaje, String error) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
		this.error = error;
	}
	public RespuestaRest() {
		super();
	}
}

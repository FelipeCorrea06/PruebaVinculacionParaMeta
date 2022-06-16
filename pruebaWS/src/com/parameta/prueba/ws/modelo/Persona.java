package com.parameta.prueba.ws.modelo;


public class Persona {

	private Integer id;
	private String nombres;
	private String apellidos;
	private String numero_documento;
    private TipoDocumento tipo_documento_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getnumero_documento() {
		return numero_documento;
	}

	public void setnumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public TipoDocumento gettipo_documento_id() {
		return tipo_documento_id;
	}

	public void settipo_documento_id(TipoDocumento tipo_documento_id) {
		this.tipo_documento_id = tipo_documento_id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", numero_documento="
				+ numero_documento + ", tipo_documento_id=" + tipo_documento_id + "]";
	}

	public Persona(Integer id, String nombres, String apellidos, String numero_documento,
			TipoDocumento tipo_documento_id) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.numero_documento = numero_documento;
		this.tipo_documento_id = tipo_documento_id;
	}

	public Persona() {
		super();
	}
	
}

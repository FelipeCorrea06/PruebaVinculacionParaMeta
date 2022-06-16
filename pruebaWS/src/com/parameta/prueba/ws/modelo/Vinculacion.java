package com.parameta.prueba.ws.modelo;



import java.util.Date;

public class Vinculacion {

	private Integer id;
    private Persona persona_id;
	private Date fecha_nacimiento;
	private Date fecha_vinculacion;
	private String cargo;
	private double salario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getpersona_id() {
		return persona_id;
	}

	public void setpersona_id(Persona persona_id) {
		this.persona_id = persona_id;
	}

	public Date getfecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setfecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getfecha_vinculacion() {
		return fecha_vinculacion;
	}

	public void setfecha_vinculacion(Date fecha_vinculacion) {
		this.fecha_vinculacion = fecha_vinculacion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Vinculacion(Integer id, Persona persona_id, Date fecha_nacimiento, Date fecha_vinculacion, String cargo,
			double salario) {
		super();
		this.id = id;
		this.persona_id = persona_id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_vinculacion = fecha_vinculacion;
		this.cargo = cargo;
		this.salario = salario;
	}

	public Vinculacion() {
		super();
	}

	@Override
	public String toString() {
		return "Vinculacion [id=" + id + ", persona_id=" + persona_id + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", fecha_vinculacion=" + fecha_vinculacion + ", cargo=" + cargo + ", salario=" + salario + "]";
	}
}

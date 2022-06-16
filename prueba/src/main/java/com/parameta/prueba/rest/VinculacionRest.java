package com.parameta.prueba.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.Gson;
import com.parameta.prueba.dao.VinculacionDAO;
import com.parameta.prueba.model.RespuestaRest;
import com.parameta.prueba.model.Vinculacion;

@RestController
@RequestMapping("vinculacion")
public class VinculacionRest {

	@Autowired
	private VinculacionDAO vinculacionDAO;

	@PostMapping("/vincular") // localhost/8090/vinculacion/vincular
	public RespuestaRest vincular(@RequestBody Vinculacion vinculacion) {
		RespuestaRest respuestaRest = new RespuestaRest();
		// Validación de campos vacios
		boolean resVacios = camposVacios(vinculacion);
		if (resVacios) {
			if (resVacios) {
				// Validación de formatos de fechas
				boolean resFormato = false;
				resFormato = validateDate(vinculacion.getfecha_nacimiento().toString());
				if (resFormato) {
					resFormato = validateDate(vinculacion.getfecha_vinculacion().toString());
					if (!resFormato) {
						respuestaRest.setRespuesta(false);
						respuestaRest.setError("Formato de fecha nacimiento erroneo");
						return respuestaRest;
					}
				} else {
					respuestaRest.setRespuesta(false);
					respuestaRest.setError("Formato de fecha nacimiento erroneo");
					return respuestaRest;
				}
			}
		}else {
			respuestaRest.setRespuesta(false);
			respuestaRest.setError("Campos vacios");
			return respuestaRest;
		}
		// validación mayor de edad
		Period period = validateEdad(vinculacion.getfecha_nacimiento().toString());
		if (period.getYears()<18) {
			respuestaRest.setRespuesta(false);
			respuestaRest.setError("El empleado es menor de edad");
			return respuestaRest;
		}else {
			//invocación al clienteWS
			
			
			//construcción de respuesta final en JSON
			Period periodVin = validateEdad(vinculacion.getfecha_vinculacion().toString());
			respuestaRest.setMensaje("Tiempo de Vinculación a la compañía:  "+periodVin.getYears()+" años, "+periodVin.getMonths()+" meses y "+periodVin.getDays()+" días y la "
					+ "Edad actual del empleado: "+period.getYears()+" años, "+period.getMonths()+" meses y "+period.getDays()+" días");
			respuestaRest.setRespuesta(true);
			
			
			return respuestaRest;
		}
	}

	public boolean camposVacios(Vinculacion vinculacion) {
		if (vinculacion.getId() < 0 || vinculacion.getpersona_id().getNombres().trim().equals("")
				|| vinculacion.getpersona_id().getApellidos().trim().equals("")
				|| vinculacion.getpersona_id().gettipo_documento_id().getDescripcion().trim().equals("")
				|| vinculacion.getpersona_id().getnumero_documento().trim().equals("")
				|| vinculacion.getfecha_nacimiento().toString().trim().equals("")
				|| vinculacion.getfecha_vinculacion().toString().trim().equals("")
				|| vinculacion.getCargo().toString().trim().equals("")
				|| vinculacion.getSalario()<0) {
			return false;
		}
		return true;
	}

	public boolean validateDate(String strDate) {
		if (strDate.trim().equals("")) {
			return false;
		} else {
			try {
				DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd HH:mm:ss z uuuu" , Locale.US );
				ZonedDateTime zdt = ZonedDateTime.parse( strDate , f );
				System.out.println(strDate + " is valid date format");
			} catch (Exception e) {
				System.out.println(strDate + " is Invalid Date format");
				return false;
			}
			return true;
		}
	}
	
	public Period validateEdad(String strDate) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd HH:mm:ss z uuuu" , Locale.US );
		LocalDate fechaNac = LocalDate.parse(strDate, f);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s días",
		                    periodo.getYears(), periodo.getMonths(), periodo.getDays());
		return periodo;
		
	}

	@GetMapping("/listar") // localhost/8090/vinculacion/listar
	public List<Vinculacion> listar() {
		System.out.println("Ingreso GET");
		return vinculacionDAO.findAll();
	}

}

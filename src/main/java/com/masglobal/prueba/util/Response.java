package com.masglobal.prueba.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

/**
* Clase para manejar el Response de los Controllers con una respuesta standard
*
* @author  David Luna
* @version 1.0
* @since   2021-03-05 
*/
@Getter
@Setter
public class Response {

	private String code;
	private String message;
	private ResponseType type;
	private Long date;
	private ResponseEntity<?> data;
	private static final String DOUBLE_QUOTES = "'";
    
    /**
    * Constructor para la clase Response
    * @param cod  Código de la respuesta
    * @param msg  mensaje de la Respuesta
    * @param dat  ResponseEntity con la data a devolver
    * @param type Tipo de Respuesta
    * @param time Hora del envío de la respuesta
    */       
    public Response(String cod, String msg, ResponseEntity<?> dat, ResponseType type, Long time) {
	this.type = type;
	this.code = cod;
	this.message = msg;
	this.data = dat;
	this.date = time;
    }
}

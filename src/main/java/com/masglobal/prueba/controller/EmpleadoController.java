package com.masglobal.prueba.controller;

import com.masglobal.prueba.dao.EmpleadoDAO;
import com.masglobal.prueba.modelo.Empleado;
import com.masglobal.prueba.util.Response;
import com.masglobal.prueba.util.ResponseType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
* Clase Para construir el Controller con los Endpoints para los Empleados
*
* @author  David Luna
* @version 1.0
* @since   2021-03-06 
*/
@RestController
@RequestMapping("/api")
@Api(tags = { "Empleados" })
@SwaggerDefinition(tags = {
		@Tag(name = "Empleados", description = "Permite trabajar con los Empleados") })
@CrossOrigin(origins = "*")
public class EmpleadoController {
    @Autowired
    private EmpleadoDAO trabajadorDAO;
    
    private static final String GET_EMPLOYEES = "/empleados";
    private static final String GET_EMPLOYEE_BY_ID = "/empleados/{id}";    
    private static final String JSON_FORMAT = "application/json";

    public static final int CODE_NRO_OK = 200;
    public static final String CODE_OK = "200";
    public static final String CODE_BAD_REQUEST = "400";    
    public static final String RESPONSE_OK = "OK";
    public static final int CODE_NRO_BAD_REQUEST = 400;
    public static final String RESPONSE_BAD_REQUEST = "Bad Request";
    public static final int CODE_NRO_ERROR = 500;
    public static final String CODE_ERROR = "500";    
    public static final String RESPONSE_ERROR = "Ocurrió un error en el servidor";
    private String EMPTY = "";
    private  Empleado trabajador = null;

    
    /**
    * Método para crear el Endpoint para obtener el empleado por ID
    * @param id ID del Empleado a buscar
    * @return Response con los datos del Empleado
    */        
    @GetMapping(value = GET_EMPLOYEE_BY_ID, produces = JSON_FORMAT)
	@ApiOperation("Permite obtener la lista de Empleados")
	@ApiResponses(value = { @ApiResponse(code = CODE_NRO_OK, message = RESPONSE_OK),
			@ApiResponse(code = CODE_NRO_BAD_REQUEST, message =  RESPONSE_BAD_REQUEST),
			@ApiResponse(code = CODE_NRO_ERROR, message =  RESPONSE_ERROR) })

    public Response  getEmployeeById(@ApiParam(value = "Id del Empleado", required = true)@PathVariable int id) {
        trabajador = null;
        trabajadorDAO.get(id).ifPresent(entity -> trabajador = entity);
        if(trabajador != null){
         ResponseEntity data = new ResponseEntity<>(trabajador, HttpStatus.OK);
         Response answer = new Response(CODE_OK,
					"Se consiguió al Trabajador" + id , data, ResponseType.OK,
					new Date().getTime());
         return answer;
        }else{
         ResponseEntity data = new ResponseEntity<>(EMPTY, HttpStatus.BAD_REQUEST);
         Response answer = new Response(CODE_BAD_REQUEST,
					"No existe el Trabajador con el ID " + id , data, ResponseType.OK,
					new Date().getTime());
         return answer;
                
        }
    }


    /**
    * Método para crear el Endpoint para obtener los Empleados
    * @return Response con los datos de la lista de Empleados
    */        
    @GetMapping(value = GET_EMPLOYEES, produces = JSON_FORMAT)
	@ApiOperation("Permite obtener la lista de Empleados")
	@ApiResponses(value = { @ApiResponse(code = CODE_NRO_OK, message = RESPONSE_OK),
			@ApiResponse(code = CODE_NRO_BAD_REQUEST, message =  RESPONSE_BAD_REQUEST),
			@ApiResponse(code = CODE_NRO_ERROR, message =  RESPONSE_ERROR) })

    public Response  getEmployees() {
        List<Empleado> trabajadores = trabajadorDAO.getAll();
         ResponseEntity data = new ResponseEntity<>(trabajadores, HttpStatus.OK);
         Response answer = new Response(CODE_OK,
					"Se consiguieron " + trabajadores.size() + " empleados", data, ResponseType.OK,
					new Date().getTime());
        return answer;
    }
    
    /**
     *
     * @param ex
     * @return
     */
        @ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
		return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

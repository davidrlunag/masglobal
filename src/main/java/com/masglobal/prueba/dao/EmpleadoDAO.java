package com.masglobal.prueba.dao;

import com.masglobal.prueba.dto.EmpleadoDTO;
import com.masglobal.prueba.dto.EmpleadoMapper;
import com.masglobal.prueba.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
* Clase Para construir el DAO (Capa de Datos) de la clase Empleado
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04 
*/

@Component
public class EmpleadoDAO implements Dao<Empleado> {

    private static List<Empleado> trabajadores = new ArrayList();
    private List<EmpleadoDTO> trabajadoresList = new ArrayList<>();
    private final RestTemplate restTemplate;
    
    /**
    * Constructor para crear el DAO y asignar elRestTemplate
    * @param restTemplateBuilder Instancia de RestTemplateBuilder
    */   
   public EmpleadoDAO(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
    * Método  para obtener el empleado por ID
    * @param id ID del Empleado a buscar
    * @return Optional con los datos del Empleado
    */       
   @Override
    public Optional<Empleado> get(int id) {
        String url = "http://masglobaltestapi.azurewebsites.net/api/employees";
        EmpleadoDTO[] trabajadoresDTO = this.restTemplate.getForObject(url, EmpleadoDTO[].class);
        trabajadores = EmpleadoMapper.trabajadorDTO(trabajadoresDTO);
        return  trabajadores
                        .stream()
                        .filter(data -> data.getId()==id)
                        .collect(Collectors.reducing((a, b) -> null));
                        
    }
    

    /**
    * Método para obtener los Empleados
    * @return La lista de Empleados
    */           
    @Override
    public List<Empleado> getAll() {
        String url = "http://masglobaltestapi.azurewebsites.net/api/employees";
        EmpleadoDTO[] trabajadoresDTO = this.restTemplate.getForObject(url, EmpleadoDTO[].class);
        trabajadores = EmpleadoMapper.trabajadorDTO(trabajadoresDTO);
        return trabajadores;
    }
}
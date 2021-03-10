/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masglobal.prueba.service;

import com.masglobal.prueba.dao.Dao;
import com.masglobal.prueba.modelo.Empleado;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
* Clase Para construir el Servicio para los Empleados
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04 
*/
@Scope(value = "session")
@Component(value = "trabajadorService")
public class EmpleadoService {

    @Autowired
    private Dao<Empleado> trabajadorDao;

    /**
    * Método para obtener los Empleados
    * @return La lista de Empleados
    */  
    public Collection<Empleado> getAllTodo() {
        return trabajadorDao.getAll();
    }
    
    /**
    * Método para el empleado por ID
    * @param id ID del Empleado a buscar
    * @return Response con los datos del Empleado
    */        
    public Optional<Empleado> getTrabajadorById(int id){
        return trabajadorDao.get(id);
    }

}
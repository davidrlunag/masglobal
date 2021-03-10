package com.masglobal.prueba.dao;
import java.util.List;
import java.util.Optional;

/**
* Interface para la creación de los DAOS del proyecto
*
* @author  David Luna
* @version 1.0
 * @param <T>
* @since   2021-03-04 
*/

public interface Dao<T> {

    /**
     *
     * @param id
     * @return Optional con la clase destino
     */
    Optional<T> get(int id);

    /**
     * 
     * @return La Lista de Objetos de la clase destino
     */
    List<T> getAll();
   
}
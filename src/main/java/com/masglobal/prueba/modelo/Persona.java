package com.masglobal.prueba.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* Clase Abstracta Persona
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04 
*/
@Getter
@Setter
@ApiModel(description="Para la clase Persona - Abstracción")  
public abstract class Persona {
    
    @ApiModelProperty(notes="ID de la persona")  
    private int id;
    @ApiModelProperty(notes="Nombre de la persona")  
    private String name;

    /**
    * Constructor para la clase Persona
    * @param id   ID del rol
    * @param name Nombre del rol
    */
    public Persona(int id, String name){
        this.id = id;
        this.name = name;
    }
}

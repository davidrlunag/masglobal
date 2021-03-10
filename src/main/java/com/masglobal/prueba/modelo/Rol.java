package com.masglobal.prueba.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Clase para el manejo de los Roles de los Usuarios
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04 
*/
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description="Para el manejo de los Roles")  
public class Rol {

    @ApiModelProperty(notes="ID del Rol")  
    private int idRol;
    @ApiModelProperty(notes="Nombre del Rol")  
    private String roleName;
    @ApiModelProperty(notes="Descripción del Rol")  
    private String roleDescription;

    /**
    * Constructor para la clase Rol
    * @param id   ID del rol
    * @param name Nombre del rol
    * @param des  Descripción del rol
    */
    public Rol(int id, String name, String des){
        this.idRol = id;
        this.roleName = name;
        this.roleDescription = des;
    }
}

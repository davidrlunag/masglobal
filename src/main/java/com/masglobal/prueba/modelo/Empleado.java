package com.masglobal.prueba.modelo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* Clase para el manejo de los Empleados
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04 
*/
@Getter
@Setter
@ApiModel(description="Para el manejo de los Empleados")  
public class Empleado extends Persona{

    @ApiModelProperty(notes="Tipo de contrato del Trabajador")  
    private String contractTypeName;
    @ApiModelProperty(notes="Rol del Trabajador")  
    private Rol rol;
    @ApiModelProperty(notes="Salario x Hora")  
    private float hourlySalary;
    @ApiModelProperty(notes="Salario mensual")  
    private float monthlySalary;
    @ApiModelProperty(notes="Salario anual")     
    private float annualSalary;
    
    /**
    * Constructor para la clase Empleado
    * @param id            ID del rol
    * @param nombre        Nombre del Empleado
    * @param type          Tipo de contrato del Empleado
    * @param rol           Rol del Empleado
    * @param hourlySalary  Precio por hora del Empleado
    * @param monthlySalary Precio por mes del Empleado
    */
    public Empleado(int id, String nombre, String type, Rol rol, float hourlySalary, float monthlySalary){
        super(id, nombre);
        this.contractTypeName = type;
        this.rol = new Rol(rol.getIdRol(), rol.getRoleName(), rol.getRoleDescription());
        this.hourlySalary = hourlySalary;
        this.monthlySalary = monthlySalary;
    }
 
    /**
    * Método para calcular el salario del empleado dependiendo del tipo
    * @return Salario Anual del Empleado
    */
    public float getAnnualSalary(){
          annualSalary = contractTypeName.equals("HourlySalaryEmployee") ? (120 * hourlySalary * 12) : (monthlySalary * 12);
          return annualSalary;
       }

}

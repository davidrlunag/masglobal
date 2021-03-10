package com.masglobal.prueba.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
* Clase para el DTO de la clase Trabajador
*
* @author  David Luna
* @version 1.0
* @since   2021-03-04 
*/
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpleadoDTO {

    private int id;
    private String name; 
    private String contractTypeName; 
    private int roleId;
    private String roleName;
    private String roleDescription;
    private float hourlySalary;
    private float monthlySalary;   
    private float annualSalary;
    
        /**
    * Constructor para la clase Empleado
    * @param id              ID del rol
    * @param nombre          Nombre del Empleado
    * @param type            Tipo de contrato del Empleado
    * @param rolId           Id del Rol del Empleado
     * @param roleName
     * @param roleDes
    * @param hourlySalary    Precio por hora del Empleado
    * @param monthlySalary   Precio por mes del Empleado
    */
   public EmpleadoDTO(int id, String nombre, String type, int rolId, String roleName, String roleDes, float hourlySalary, float monthlySalary){
        this.id = id;
        this.name = nombre;
        this.contractTypeName = type;
        this.roleId = rolId;
        this.roleName = roleName;
        this.roleDescription = roleDes;
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

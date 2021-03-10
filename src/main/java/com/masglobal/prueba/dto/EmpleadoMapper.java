package com.masglobal.prueba.dto;

import com.masglobal.prueba.modelo.Rol;
import com.masglobal.prueba.modelo.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
* Clase para el Manejo del DTO de Empleados
*
* @author  David Luna
* @version 1.0
* @since   2021-03-06 
*/
public class EmpleadoMapper {
 
    /**
    * Método para transformar una instancia de Empleado a DTO
    * @param user Instancia de Empleado a pasar a DTO
    * @return DTO con los datos del Empleado
    */    
    public static EmpleadoDTO toTrabajadorDTO(Empleado user) {
        return new EmpleadoDTO()
                .setId(user.getId())
                .setName(user.getName())
                .setRoleId(user.getRol().getIdRol())
                .setRoleName(user.getRol().getRoleName())
                .setRoleDescription(user.getRol().getRoleDescription())
                .setHourlySalary(user.getHourlySalary())
                .setMonthlySalary(user.getMonthlySalary());
    }
    
    /**
    * Método para transformar la lista de DTO a una Lista de Empleados
    * @param trabajadoresDTO Arreglo de Empleados para pasarlos a DTO
    * @return Lista de Empleados
    */    
    public static List<Empleado> trabajadorDTO(EmpleadoDTO[] trabajadoresDTO){
        List<Empleado> trabajadores = new ArrayList();
        for(EmpleadoDTO dto : trabajadoresDTO){
             Rol rol = new Rol (dto.getRoleId(), dto.getRoleName(), dto.getRoleDescription());
             trabajadores.add(new Empleado(dto.getId(), dto.getName(), dto.getContractTypeName(), rol, dto.getHourlySalary(), dto.getMonthlySalary()));
        }
        return trabajadores;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masglobal.prueba.controller;

import com.masglobal.prueba.modelo.Rol;
import com.masglobal.prueba.modelo.Empleado;
import com.masglobal.prueba.service.EmpleadoService;
import com.masglobal.prueba.util.TestUtil;
import java.util.Arrays;
import java.util.List;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.google.gson.reflect.TypeToken;
import net.minidev.json.parser.JSONParser;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import static org.mockito.BDDMockito.given;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters

@DisplayName("Integration tests: HTTP reponses - EmpleadoController")
@Tag("functional-requirement")
public class EmpleadoControllerTest {
    
    JSONParser parser = new JSONParser();
    private final static String URI = "/api/empleados";
    @Autowired
    MockMvc mvc;
    @MockBean
    EmpleadoService service;
    
    public EmpleadoControllerTest() {
    }
     /**
    * Método para crear el test que obtiene la lista de los Empleados
    */           
    @Test
    void testGetAllAtributos() throws Exception {
        List<Empleado> empleados = buildEmployeesList();
        when(service.getAllTodo()).thenReturn(empleados);
        ResultActions result=
                mvc.perform(MockMvcRequestBuilders.get(URI)
                       .contentType(MediaType.APPLICATION_JSON)
                       .accept(MediaType.APPLICATION_JSON)
		       .content(TestUtil.objectToJson(empleados)))
		       .andExpect(status().isOk());
					
		JSONObject resJson = (JSONObject) parser.parse(result.andReturn().getResponse().getContentAsString());
		JSONObject data = (JSONObject) resJson.get("data");
		String status = data.get("statusCodeValue").toString();
                TypeToken<List<Empleado>> token = new TypeToken<List<Empleado>>() {
					};
		@SuppressWarnings("unchecked")
		List<Empleado> empListResult = TestUtil.jsonToList(result.andReturn().getResponse().getContentAsString(), token);
                        assertEquals(HttpStatus.OK.value(), Integer.parseInt(status), "Incorrect Response Status");
			assertNotEquals(empleados, null);
			assertEquals(empleados.size(), empListResult.size(), "Incorrect valitaions list");
    }
    
    /**
    * Método para crear la lista de los Empleados
    * @return La lista de Empleados
    */           
    public List<Empleado> buildEmployeesList(){
                  Rol rol1 = new Rol(1, "Administrator", "");
                  Rol rol2 = new Rol(1, "Contractor", "");
		  Empleado tra1 = new Empleado(1, "Andrea", "HourlySalaryEmployee",rol1, 10000.0f,50000.0f);
		  Empleado tra2 = new Empleado(2, "Tony", "MonthlySalaryEmployee",rol2, 12000.0f,60000.0f);
                  List<Empleado> trabajadores = Arrays.asList(tra1, tra2);
		  return trabajadores;
		  
	  }

    
}

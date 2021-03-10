package com.masglobal.prueba.util;

import java.lang.reflect.Type;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
* Clase Utilitaria para realizar la transformación de json a Lista y de Lista a Json
* Para ser utilizada en el controller
*
* @author  David Luna
* @version 1.0
* @since   2021-03-05 
*/
public class TestUtil {

        /**
        * Método para transformar el Json de Respuesta al TypeToken seleccionado
        * @param json   El json de la respuesta
        * @param token  El tipo del objeto a transformar la respuesta
        * @return Lista de objetos devueltos por el JSON
        */
	@SuppressWarnings("rawtypes")
	public static List jsonToList(String json, TypeToken token) {
		Gson gson = new Gson();
		JSONParser parser = new JSONParser();
		try {
			JSONObject resJson = (JSONObject) parser.parse(json);
			JSONObject data=(JSONObject) resJson.get("data");
			JSONArray body = (JSONArray)data.get("body");
			String dataJson = body.toString();
			return gson.fromJson(dataJson, token.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

        /**
        * Método para transformar el Json de Respuesta al TypeToken seleccionado
        * @param json   El json de la respuesta
        * @param token  El tipo del objeto a transformar la respuesta
        * @return Lista de objetos devueltos por el JSON
        */
        @SuppressWarnings("rawtypes")
	public static List jsonToList(String json, Type token) {
		Gson gson = new Gson();
		JSONParser parser = new JSONParser();
		try {
			JSONObject resJson = (JSONObject) parser.parse(json);
			JSONObject data=(JSONObject) resJson.get("data");
			JSONArray body = (JSONArray)data.get("body");
			String dataJson = body.toString();
			return gson.fromJson(dataJson, token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        
         /**
        * Método para transformar un Objeto a Json
        * @param obj   El objeto a transformar
        * @return El JSON con el objeto convertido
        */
	public static String objectToJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

        /**
        * Método para transformar el Json de Respuesta al TypeToken seleccionado
        * @param json   El json de la respuesta
        * @param <T> Clase a transformar el JSON
        * @return El Objeto con la data del 
        */
	public static <T> T jsonToObject(String json, Class<T> classOf) {
		Gson gson = new Gson();
		return gson.fromJson(json, classOf);
	}
}
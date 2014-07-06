//    
//    This file is part of the DeportesUGR App.
//
//    Copyright (C) 2014  Luis Carlos Casanova Aranda, Juan J. Ramos-Munoz <jjramosapps@gmail.com>
//
//    DeportesUGR is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    DeportesUGR is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
package es.ugr.deportesugrapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import es.ugr.deportesugrapp.torneos.Equipo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;

public class GestorPreferencias {

	private ObjectMapper mapper;
	private SharedPreferences preferencias;

	static final String MIS_EQUIPOS="misEquiposs";

	public GestorPreferencias(ActionBarActivity activity) {
		preferencias=PreferenceManager.getDefaultSharedPreferences(activity);
		
		mapper=new ObjectMapper(); 
		// Para que no falle aunque no tenga un constructtor vacío, ni getter y setters públicos:
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
	
	public int guardarMisEquipos(List<Equipo> listaElegidos){
		int error=0;
	// Guardamos las preferencias
	
	SharedPreferences.Editor editor = preferencias.edit();
					
	/////////////////jjramos/////////////////////////
	// Creamos un string con los equipos::
	String equiposElegidosString=preferencias.getString(MIS_EQUIPOS, "*");
	
	// listaElegidos=mezclarListaEquipos(deserializarListaEquipos(equiposElegidosString),listaElegidos);
	
	equiposElegidosString=serializaListaEquipos(listaElegidos);
	editor.putString(MIS_EQUIPOS,equiposElegidosString);
	editor.commit();
	
	
	/////////////////////////////
	return error;
	}
	
	String serializaListaEquipos(List<Equipo> listaEquipos){
		String json="";
		 try {
			json=mapper.writeValueAsString(listaEquipos);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public List<Equipo> getListaEquiposEscogidos() {
		List<Equipo> lista=null;
		
		String serializado=preferencias.getString(MIS_EQUIPOS, "");
		
		try {
			
			if(serializado!=null&&serializado.compareTo("")!=0){
				lista= mapper.readValue(serializado, new TypeReference<List<Equipo>>() {});
			}
			
			// Devolvemos una lista vacía:
			if(lista==null){
				lista=new ArrayList<Equipo>();
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}

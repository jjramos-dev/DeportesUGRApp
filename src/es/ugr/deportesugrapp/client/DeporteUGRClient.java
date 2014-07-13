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
package es.ugr.deportesugrapp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ugr.deportesugrapp.noticias.Noticia;
import es.ugr.deportesugrapp.reservas.PistaReservable;
import es.ugr.deportesugrapp.torneos.DatosCategoria;
import es.ugr.deportesugrapp.torneos.Deporte;
import es.ugr.deportesugrapp.torneos.Equipo;
import es.ugr.deportesugrapp.torneos.Fase;

/**
 * Clase que permite leer las url, y realizar otra serie de tareas
 */
public class DeporteUGRClient {

	// String baseURL="http://oberon.ugr.es:8080";
	String baseURL = Global.baseURLServidorNice;

	/**
	 * Metodo constructor
	 */
	public DeporteUGRClient() {

	}

	/**
	 * Metodo que nos permite leer la URL de la pagina de interes
	 * @param url String que contendra la direccion URL sobre la que trabajaremos
	 * @return String que devuelve la respuesta linea a linea
	 */
	public String leerURL(String url) {
		String respuesta = "";
		URL servicio;
		// Hacemos una petici�n HTTP GET... Esto s�lo sirve para cosultar! de
		// momento no modificamos nada:

		try {
			servicio = new URL(url);

			URLConnection conexion = servicio.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conexion.getInputStream()));

			// Recibimos la respuesta l�nea a l�nea (el JSON):
			respuesta = "";
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				// System.out.println(inputLine);
				respuesta = respuesta + inputLine;
			}
			in.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return respuesta;
	}

	/**
	 * Metodo que nos permite obtener la lista de pistas reservables
	 * @return Devuelve una Lista con las pistas reservables
	 */
	public List<PistaReservable> obtenerListaPistasReservables() {
		List<PistaReservable> listaPistasReservables = null;

		try {
			String respuesta = "";
			String url = baseURL + "/reservas/pistas";

			// Leemos y almacenamos la respuesta:
			respuesta = leerURL(url);

			// Interpretamos la respuesta JSON:
			ObjectMapper mapper = new ObjectMapper();
			// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
			// false);
			// Ejemplo para recibir una lista de objetos:
			listaPistasReservables = mapper.readValue(respuesta,
					new TypeReference<List<PistaReservable>>() {
					});

		} catch (IOException ex) {
			Logger.getLogger(DeporteUGRClient.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		return listaPistasReservables;
	}

	
	
	/**
	 * Metodo que nos permite obtener la tabla de reservas de la pista en cuestion y para una fecha determinada
	 * @param codigo String que contiene el codigo de la pista en la que estamos interesados
	 * @param titulo String que contiene el nombre de la pista en la que estamos interesados
	 * @param fecha String que contiene la fecha en la que estamos interesados
	 * @return Devuelve un String con los datos sobre la disponibilidad de la pista deseada
	 */
	
	public String obtenerTablaReservasFecha(String codigo, String titulo,
			String fecha) {
		String tablaHTML = null;

		try {
			String respuesta = "";
			String url = baseURL + "/reservas/pistas/" + codigo + "/fecha/"
					+ fecha + "";

			// Leemos y almacenamos la respuesta:
			respuesta = leerURL(url);

			// Interpretamos la respuesta JSON:
			ObjectMapper mapper = new ObjectMapper();
			// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
			// false);
			// Ejemplo para recibir una lista de objetos:

			tablaHTML = mapper.readValue(respuesta,
					new TypeReference<String>() {
					});

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

		return tablaHTML;
	} 

	/**
	 * Metodo que nos permite obtener la disponibilidad de una pista en funcion de su fecha
	 * @param codigo String que contiene el codigo de identificacion de la pista deseada
	 * @param dia String que contiene el dia que queremos reservar la pista
	 * @param mes String que contiene el dia que queremos reservar la pista
	 * @param anio String que contiene el dia que queremos reservar la pista
	 * @return Devuelve un String con los datos sobre la disponibilidad de la pista deseada
	 */
	public String obtenerTablaReservasFecha(String codigo, String dia,
			String mes, String anio) {
		String tablaHTML = null;
		try {

			String respuesta = "";
			String url = baseURL + "/reservas/pistas/" + codigo + "/fecha/"
					+ dia + "-" + mes + "-" + anio + "";

			// Leemos y almacenamos la respuesta:
			respuesta = leerURL(url);

			// Interpretamos la respuesta JSON:
			ObjectMapper mapper = new ObjectMapper();
			// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
			// false);
			// Ejemplo para recibir una lista de objetos:
			tablaHTML = mapper.readValue(respuesta,
					new TypeReference<String>() {
					});

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ex) {
			Logger.getLogger(DeporteUGRClient.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return tablaHTML;
	}

	/**
	 * Metodo que nos permite leer la informacion de una noticia dada
	 * @param tablon String que forma parte de la URL de la noticia
	 * @param noticiaId String que indica la identificacion de una noticia determinada
	 * @return Devuelve la informacion contenida clase Noticia (Url, titulo, contenido)
	 */
	public Noticia obtenerNoticia(String tablon, String noticiaId) {
		Noticia noticia = null;

		String respuesta = "";
		// URL del servicio Restlet
		String url = baseURL + "/noticias/" + noticiaId + "/tablones/" + tablon;

		// Leemos y almacenamos la respuesta:
		respuesta = leerURL(url);

		// Interpretamos la respuesta JSON:
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		// Interpreta la cadena de la noticia en objeto:
		try {
			noticia = mapper.readValue(respuesta, new TypeReference<Noticia>() {
			});
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

		return noticia;
	}

	/**
	 * Metodo que permite obtener una lista de equipos ordenada alfabeticamente
	 * @param trofeoId String que contiene la competicion a la que pertenecen los equipos que se mostraran en la lista
	 * @param deporteId String que contiene el deporte al que pertenecen los equipos que se mostraran en la lista
	 * @return Devuelve una lista con los equipos ordenados alfabeticamente
	 */
	public List<Equipo> obtenerEquipo(String trofeoId, String deporteId) {
		List<Equipo> listaEquipos = null;

		String respuesta = "";
		// URL del servicio Restlet
		String url = baseURL + "/categorias/" + trofeoId + "/deportes/"
				+ deporteId + "/equipos";

		// Leemos y almacenamos la respuesta:
		respuesta = leerURL(url);

		// Interpretamos la respuesta JSON:
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		try {
			// Miramos los equipos:
			listaEquipos = mapper.readValue(respuesta,
					new TypeReference<List<Equipo>>() {
					});

			// /////////// 26/06/2014
			if (listaEquipos != null) {
				// Los ordenamos:
				Collections.sort(listaEquipos, new Comparator<Equipo>() {

					@Override
					// Comparamos las cadenas de caracteres de los nombres de
					// los equipos:
					public int compare(Equipo o1, Equipo o2) {
						return o2.getNombre().compareTo(o1.getNombre());
					}
				});
				for (Equipo equipo : listaEquipos) {
					System.out.println(" " + equipo.getNombre() + " -> "
							+ equipo.getUrl());
				}

			} else {
				listaEquipos = new ArrayList<Equipo>();
			}

		} catch (IOException ex) {
			// Mostrar error!!!!!!

		}

		return listaEquipos;
	}

	/**
	 * Metodo que permite obtener las competiciones existentes para un año en concreto
	 * @param anio String que contiene el año del que se cargaran las competiciones
	 * @return Devuelve una lista con las diferentes competiciones existentes en el año introducido
	 */
	public List<DatosCategoria> obtenerTorneos(String anio) {
		List<DatosCategoria> listaCategorias = null;

		try {

			String respuesta = "";

			// -------------------------------
			// Aquí hay que cambiar:
			String url = baseURL + "/torneos/" + anio;

			respuesta = leerURL(url);
			// ---------------------------
			// Aquí hay que cambiar
			// Intentamos interpertarlo con jackson:
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);

			// Ejemplo para recibir una lista de objetos:
			listaCategorias = mapper.readValue(respuesta,
					new TypeReference<List<DatosCategoria>>() {
					});

		} catch (IOException ex) {
			Logger.getLogger(DeporteUGRClient.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return listaCategorias;
	}

	//
	//
	/**
	 * Metodo que permite obtener una lista con los deportes pertenecientes a una competicion en concreto
	 * @param id String que contiene la competicion de la cual queremos cargar los deportes existentes
	 * @return Devuelve una lista con los deportes obtenidos para dicha competicion
	 */
	public List<Deporte> obtenerDeportes(String id) {
		List<Deporte> listaDeportes = null;

		try {

			String respuesta = "";

			// -------------------------------
			// Aquí hay que cambiar:
			String url = baseURL + "/categorias/" + id + "/deportes";

			respuesta = leerURL(url);
			// ---------------------------
			// Aquí hay que cambiar
			// Intentamos interpertarlo con jackson:
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);

			// Ejemplo para recibir una lista de objetos:
			listaDeportes = mapper.readValue(respuesta,
					new TypeReference<List<Deporte>>() {
					});

			if (listaDeportes == null) {
				listaDeportes = new ArrayList<Deporte>();
			}

		} catch (IOException ex) {
			Logger.getLogger(DeporteUGRClient.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return listaDeportes;

	}

	//
	//
	/**
	 * Metodo que nos permite obtener el calendario de un determinado deporte y competicion
	 * @param categoriaId String que contiene la competicion sobre la que queremos obtener el calendario
	 * @param deporteId String que contiene el deporte sobre el que queremos obtener el calendario
	 * @return Devuelve una lista de fases (calendario) para la competicion y deporte introducidos
	 */
	public List<Fase> obtenerFases(String categoriaId, String deporteId) {
		List<Fase> listaFases = null;

		try {

			String respuesta = "";

			// -------------------------------
			// Aquí hay que cambiar:
			String url = baseURL + "/categorias/" + categoriaId + "/deportes/"
					+ deporteId + "/calendarios";

			respuesta = leerURL(url);
			// ---------------------------
			// Aquí hay que cambiar
			// Intentamos interpertarlo con jackson:
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);

			// Ejemplo para recibir una lista de objetos:
			listaFases = mapper.readValue(respuesta,
					new TypeReference<List<Fase>>() {
					});
			if (listaFases == null) {
				listaFases = new ArrayList<Fase>();
			}

		} catch (IOException ex) {
			Logger.getLogger(DeporteUGRClient.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return listaFases;

	}
}

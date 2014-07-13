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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.deportesugrapp.torneos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite obtener informacion sobre la categoria
 *
 */
public class Categoria {
	String titulo;
	private String url;
	private String urlNormativa = null;
	private List<Deporte> listaDeportes;
	private List<Clasificaciones> listaClasificaciones;
	private String id;
	private String anio;

	/**
	 * Constructor de la clase con argumentos
	 * @param url String de la URL donde esta la informacion
	 */
	public Categoria(String url) {
		this.url = url;
		listaDeportes = new ArrayList<Deporte>();
		listaClasificaciones = new ArrayList<Clasificaciones>();
	}

	/**
	 * Metodo para obtener la ID de la competicion
	 * @return Devuelve la ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo para asignar la ID de la acompeticion
	 * @param id ID de la competicion
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo que muestra informacion sobre la competicion seleccionada
	 */
	void mostrar() {

		System.out.println("Normativa: " + this.urlNormativa);
		System.out.println("URL: " + this.url);
		System.out.println("Nombre: " + this.titulo);
		System.out.println("Año: " + this.getAnio());

		for (Deporte deporte : listaDeportes) {
			System.out.println("\t" + deporte.getTitulo() + " -> "
					+ deporte.getUrl());

			// Buscamos las clasificaciones de cada deporte. Esto es
			// súperineficiente!!!!! cambiar!!!
			for (Clasificaciones clasificaciones : listaClasificaciones) {
				// Sólo si es la clasificación para este deporte, lo mostramos:
				if (deporte == clasificaciones.getDeporte()) {
					// Por cada fase,
					for (Fase fase : clasificaciones.getFases()) {

						System.out.println("\t\t" + fase.getTitulo());
						for (Ronda ronda : fase.getRondas()) {
							System.out.println("\t\t\t" + ronda.getTitulo());

							for (Partido partido : ronda.getPartidos()) {
								System.out.println("\t\t\t\tEl "
										+ partido.getFechaString() + " a las "
										+ partido.getHoraString() + " en "
										+ partido.getLugar() + ", "
										+ partido.getEquipo1().getNombre()
										+ " vs "
										+ partido.getEquipo2().getNombre()
										+ " (" + partido.getEstado() + ") "
										+ partido.getResultadoEquipo1() + "-"
										+ partido.getResultadoEquipo2());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Metodo para obtener la URL de la competicion
	 * @return Devuelve la URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para asignar la URL
	 * @param url URL de la competicion
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Metodo para obtener la URL de la normativa de la competicion
	 * @return Devuelve la URL de la normativa
	 */
	public String getUrlNormativa() {
		return urlNormativa;
	}

	/**
	 * Metodo para asignar la URL de la normativa de la competicion
	 * @param urlNormativa URL de la normativa
	 */
	public void setUrlNormativa(String urlNormativa) {
		this.urlNormativa = urlNormativa;
	}

	/**
	 * Metodo para obtner la lista de deporte de la competicion
	 * @return Devuelve la lista de deportes de dicha competicion
	 */
	public List<Deporte> getListaDeportes() {
		return listaDeportes;
	}

	/**
	 * Metodo para asignar la lista de deportes de la competicion
	 * @param listaDeportes Variable que contiene la lista de deportes
	 */
	public void setListaDeportes(List<Deporte> listaDeportes) {
		this.listaDeportes = listaDeportes;
	}

	/**
	 * Metodo para obtener las listas clasificaciones
	 * @return Devuelve las listas de clasificaciones
	 */
	public List<Clasificaciones> getListaClasificaciones() {
		return listaClasificaciones;
	}

	/**
	 * Metodo para asignar la lista de clasificaciones
	 * @param listaClasificaciones Lista de clasificaciones
	 */
	public void setListaClasificaciones(
			List<Clasificaciones> listaClasificaciones) {
		this.listaClasificaciones = listaClasificaciones;
	}

	/**
	 * Metodo para obtener el Titulo de la competicion
	 * @return Devuelve el titulo de la competicion
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que permite obtener las fases de un deporte dado
	 * @param deporteId Deporte del que queremos obtener las fases
	 * @return Devuelve las fases
	 */
	public List<Fase> getFases(String deporteId) {

		List<Fase> fases = null;

		// Buscamos las clasificaciones de cada deporte. Esto es
		// súperineficiente!!!!! cambiar!!!
		for (Clasificaciones clasificaciones : listaClasificaciones) {
			// Sólo si es la clasificación para este deporte, lo mostramos:
			if (deporteId.compareTo(clasificaciones.getDeporte().getId()) == 0) {
				// Por cada fase,
				fases = clasificaciones.getFases();
			}
		}

		return fases;
	}

	/**
	 * Metodo para asignar el titulo de la competicion
	 * @param text Titulo de la competicion
	 */
	void setTitulo(String text) {
		titulo = text;
	}

	/**
	 * Metodo para asignar el año de la competicion
	 * @param anio Año de la competicion
	 */
	void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * Metodo para obtener el año de la competicion
	 * @return Devuelve el año de la competicion
	 */
	public String getAnio() {
		return anio;
	}

}

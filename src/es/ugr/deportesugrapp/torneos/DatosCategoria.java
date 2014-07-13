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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ugr.deportesugrapp.torneos;

/**
 * Clase que permite obtener informacion sobre las categorias
 *
 */
public class DatosCategoria {

	String titulo;
	private String url;
	private String urlNormativa = null;
	private String id;
	private String anio;

	/**
	 * Constructor de la clase
	 */
	public DatosCategoria() {

	}

	/**
	 * Constructor de la clase con argumentos
	 * @param id ID de la competicion
	 * @param titulo Titulo de la competicion
	 * @param url URL de la competicion
	 * @param urlNormativa URL de la normativa de la competicion
	 * @param anio Año de la competicion
	 */
	public DatosCategoria(String id, String titulo, String url,
			String urlNormativa, String anio) {
		this.id = id;
		this.titulo = titulo;
		this.url = url;
		this.urlNormativa = urlNormativa;
		this.anio = anio;
	}

	/**
	 * Metodo para obtener el titulo de la competicion
	 * @return DEvuelve el titulo de la competicion
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo para asignar el titulo de la competicion
	 * @param titulo Titulo de la competicion
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo para obtener la URL de la competicion
	 * @return Devuelve la URL de la competicion
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para asignar la URL de la competicion
	 * @param url URL de la competicion
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Metodo para obtener la URL de la nomrativa de la competicion
	 * @return Devuelve la URL de la normativa de la competicion
	 */
	public String getUrlNormativa() {
		return urlNormativa;
	}

	/**Metodo para asignar la URL de la normativa de la competicion
	 * @param urlNormativa URL de la normativa de la competicion
	 */
	public void setUrlNormativa(String urlNormativa) {
		this.urlNormativa = urlNormativa;
	}

	/**
	 * Metodo para obtener la ID de la competicion
	 * @return Devuelve la ID de la competicion
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo para asignar la ID de la competicion
	 * @param id ID de la competicion
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo para obtener el año de la competicion
	 * @return Devuelve el año de la competicion
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * Metodo para asignar el año de la competicion
	 * @param anio Año de la competicion
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

}

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

/**
 * Clase que permite obtener informacion sobre los deportes
 *
 */
public class Deporte {
	private String titulo;
	private String url;
	private String id;

	/**
	 * Constructor de la clase
	 */
	public Deporte() {

	}

	/**
	 * Constructor de la clase con argumentos
	 * @param titulo Nombre del deporte
	 * @param url URL del deporte
	 */
	public Deporte(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;

		// Como identificador le ponemos la última parte de la url:
		String[] id_ = url.split("/");
		// System.out.println(url);
		if (id_.length > 1) {
			id = id_[id_.length - 1];
		} else {
			id = "";

		}

		System.out.println("Deporte: " + titulo + " -> " + id);
	}

	/**
	 * Metodo para obtener el nombre del deporte
	 * @return Devuelve el nombre del deporte
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo para obtener la URL del deporte
	 * @return Devuelve la URL del deporte
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para obtener la ID del deporte
	 * @return Devuelve la ID del deporte
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo para asignar la ID del deporte
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

}

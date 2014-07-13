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
 * Clase que permite obtener informacion sobre los equipos
 *
 */
public class Equipo {
	private String nombre;
	private String url;

	/**
	 * Constructor de la clase
	 */
	Equipo() {

	}

	/**
	 * Constructor de la clase con argumentos
	 * @param nombre Nombre del equipo
	 * @param url URL asociada al equipo
	 */
	public Equipo(String nombre, String url) {
		this.nombre = nombre;
		this.url = url;
	}

	/**
	 * Metodo para obtener el nombre del equipo
	 * @return Devuelve el nombre del equipo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para obtener la URL asociada al equipo
	 * @return Devuelve la URL asociada
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para asignar el nombre al equipo
	 * @param nombre Nombre del equipo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo para asignar la URL al equipo
	 * @param url URL del equipo
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}

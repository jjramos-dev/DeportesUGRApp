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
 * Clase que permite obtener informacion sobre las clasificaciones
 *
 */
public class Clasificaciones {
	String url;
	private Deporte deporte;
	List<Fase> fases;

	/**
	 * Constructor de la clase con argumentos
	 * @param url URL que contiene la informacion
	 */
	Clasificaciones(String url) {
		this.url = url;
		fases = new ArrayList<Fase>();
	}

	/**
	 * Metodo para asignar el deporte
	 * @param deporte Deporte a asignar
	 */
	void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	/**
	 * Metodo para obtener el deporte
	 * @return Devuelve el deporte
	 */
	Deporte getDeporte() {
		return deporte;
	}

	/**
	 * Metodo para obtener las fases
	 * @return Devuelve las fases
	 */
	List<Fase> getFases() {
		return fases;
	}

	/**
	 * Metodo para obtener la URL
	 * @return Devuelve la URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para asignar la URL 
	 * @param url URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}

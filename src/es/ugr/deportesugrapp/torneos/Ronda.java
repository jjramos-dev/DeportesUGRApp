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

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite obtener informacion sobre las rondas
 *
 */
public class Ronda {
	private String titulo;
	private List<Partido> partidos;

	/**
	 * Constructor de la clase
	 */
	Ronda() {

	}

	/**
	 * Constructor de la clase con argumentos
	 * @param text Nombre
	 */
	Ronda(String text) {
		this.titulo = text;
		this.partidos = new ArrayList<Partido>();
	}

	/**
	 * Metodo para añadir un partido dentro de una ronda
	 * @param partido Partido a añadir
	 */
	void add(Partido partido) {
		partidos.add(partido);
	}

	/**
	 * Metodo para obtener el nombre de la ronda
	 * @return Devuelve el nombre de la ronda
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo para obtener la lista de partidos de la ronda
	 * @return Devuelve la lista de partidos de la ronda
	 */
	public List<Partido> getPartidos() {
		return partidos;
	}

	/**
	 * Metodo para asignar el nombre de la ronda
	 * @param titulo Nombre de la ronda
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo para asignar la lista de partidos de la ronda
	 * @param partidos Lista de partidos
	 */
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

}

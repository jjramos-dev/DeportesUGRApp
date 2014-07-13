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

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite obtener informacion sobre las fases
 *
 */
public class Fase {
	private String titulo;
	// private List<Partido> partidos;
	private List<Ronda> rondas;

	/**
	 * Constructor de la clase
	 */
	Fase() {

	}

	/**
	 * Constructor de la clase con argumentos
	 * @param fase Fase de la competicion y deporte seleccionado
	 */
	public Fase(String fase) {
		this.titulo = fase;
		// this.partidos=new ArrayList<Partido>();
		this.rondas = new ArrayList<Ronda>();
	}

	// void addPartido(Partido partido) {
	// partidos.add(partido);
	// }

	// public List<Partido> getPartidos() {
	// return partidos;
	// }

	/**
	 * Metodo para añadir una ronda a la fase
	 * @param ronda Ronda de la fase
	 */
	void addRonda(Ronda ronda) {
		rondas.add(ronda);
	}

	/**
	 * Metodo para obtener el nombre de la fase
	 * @return Devuelve el nombre de la fase
	 */
	public String getTitulo() {
		return titulo;
	}

	/** 
	 * Metodo para obtener la lista de rondas disponibles
	 * @return Devuelve la lista de rondas disponibles
	 */
	public List<Ronda> getRondas() {
		return rondas;
	}
}

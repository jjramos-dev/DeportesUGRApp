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
package es.ugr.deportesugrapp.reservas;

/**
 * Clase que contiene informacion de la pista
 *
 */
public class Pista2 {
	String pistaId;
	int numero = 13;
	String nombre;
	// String descripcion;
	float precioPorHora;

	/**
	 * Constructor de la clase
	 */
	public Pista2() {
		pistaId = "";
	}

	/** 
	 * Constructor de la clase con argumentos
	 * @param pistaId Identificacion de la pista
	 * @param numero Numero de la pista
	 * @param nom Nombre de la pista
	 * @param pre Precio de la pista
	 */
	public Pista2(String pistaId, int numero, String nom, float pre) {
		this.pistaId = pistaId;
		this.numero = numero;
		this.nombre = nom;
		this.precioPorHora = pre;

	}

	/**
	 * Metodo que nos permite obtener la ID de la pista
	 * @return Devuelve la ID de la pista
	 */
	public String getPistaId() {
		return pistaId;
	}

	/**
	 * Metodo que permite obtener el numero de la pista
	 * @return Devuelve el numero de la pista
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Metodo que permite obtener el nombre de la pista
	 * @return Devuelve el nombre de la pista
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite obtener el precio de de la pista
	 * @return
	 */
	public float getPrecio() {
		return precioPorHora;
	}
}

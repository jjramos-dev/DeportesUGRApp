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
 * 
 * @author jjramos
 */
public class Pista2 {
	String pistaId;
	int numero = 13;
	String nombre;
	// String descripcion;
	float precioPorHora;

	public Pista2() {
		pistaId = "";
	}

	public Pista2(String pistaId, int numero, String nom, float pre) {
		this.pistaId = pistaId;
		this.numero = numero;
		this.nombre = nom;
		this.precioPorHora = pre;

	}

	public String getPistaId() {
		return pistaId;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precioPorHora;
	}
}

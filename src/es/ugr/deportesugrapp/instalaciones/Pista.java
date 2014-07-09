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
package es.ugr.deportesugrapp.instalaciones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author jjramos
 */
public class Pista {
	String pistaId = null;
	// int numero=13;
	String nombre = "padel";
	// String descripcion;
	float precioUniSinLuz = 1;
	float precioUniLuz = 2;
	float precioNoUniSinLuz = 3;
	float precioNoUniLuz = 4;
	float precioPeñaUniSinLuz = 5;
	float precioPeñaUniLuz = 6;
	float precioPeñaNoUniSinLuz = 7;
	float precioPeñaNoUniLuz = 8;

	public Pista() {

	}

	public void setPistaId(String id) {
		this.pistaId = id;
	}

	/*
	 * public void setNumero(int numero){ this.numero=numero; }
	 */

	public Pista(String pistaId, String nom, float preUniSinLuz,
			float preUniLuz, float preNoUniSinLuz, float preNoUniLuz,
			float prePeñaUniSinLuz, float prePeñaUniLuz,
			float prePeñaNoUniSinLuz, float prePeñaNoUniLuz) {
		this.pistaId = pistaId;
		// this.numero=numero;
		this.nombre = nom;
		this.precioUniSinLuz = preUniSinLuz;
	}

	public String getPistaId() {
		return pistaId;
	}

	/*
	 * public int getNumero(){ return numero; }
	 */

	public String getNombre() {
		return nombre;
	}

	public float getPrecioUniversitarioSinLuz() {
		return precioUniSinLuz;
	}

	public float getPrecioUniversitarioLuz() {
		return precioUniLuz;
	}

	public float getPrecioNoUniversitarioSinLuz() {
		return precioNoUniSinLuz;
	}

	public float getPrecioNoUniversitarioLuz() {
		return precioNoUniLuz;
	}

	public float getPrecioPeñaUniversitarioSinLuz() {
		return precioPeñaUniSinLuz;
	}

	public float getPrecioPeñaUniversitarioLuz() {
		return precioPeñaUniLuz;
	}

	public float getPrecioPeñaNoUniversitarioSinLuz() {
		return precioPeñaNoUniSinLuz;
	}

	public float getPrecioPeñaNoUniversitarioLuz() {
		return precioPeñaUniLuz;
	}

}

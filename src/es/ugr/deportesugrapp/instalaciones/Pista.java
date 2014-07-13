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


public class Pista {
	String pistaId = null;
	// int numero=13;
	String nombre = "padel";
	// String descripcion;
	float precioUniSinLuz = 1;
	float precioUniLuz = 2;
	float precioNoUniSinLuz = 3;
	float precioNoUniLuz = 4;
	float precioPeniaUniSinLuz = 5;
	float precioPeniaUniLuz = 6;
	float precioPeniaNoUniSinLuz = 7;
	float precioPeniaNoUniLuz = 8;

	public Pista() {

	}

	public void setPistaId(String id) {
		this.pistaId = id;
	}

	

	public Pista(String pistaId, String nom, float preUniSinLuz,
			float preUniLuz, float preNoUniSinLuz, float preNoUniLuz,
			float prePeniaUniSinLuz, float prePeniaUniLuz,
			float prePeniaNoUniSinLuz, float prePeniaNoUniLuz) {
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

	public float getPrecioPeniaUniversitarioSinLuz() {
		return precioPeniaUniSinLuz;
	}

	public float getPrecioPeniaUniversitarioLuz() {
		return precioPeniaUniLuz;
	}

	public float getPrecioPeniaNoUniversitarioSinLuz() {
		return precioPeniaNoUniSinLuz;
	}

	public float getPrecioPeniaNoUniversitarioLuz() {
		return precioPeniaUniLuz;
	}

}

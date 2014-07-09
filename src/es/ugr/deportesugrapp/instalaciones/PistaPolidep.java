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
public class PistaPolidep {
	String pistaId = null;
	// int numero=13;
	String nombre = "Polideportivas";
	// String descripcion;
	String precioUniSinLuz = "6 €";
	String precioUniLuz = "12 €";
	String precioNoUniSinLuz = "16 €";
	String precioNoUniLuz = "24 €";
	String precioPeniaUniSinLuz = "131 €";
	String precioPeniaUniLuz = "390 €";
	String precioPeniaNoUniSinLuz = "610 €";
	String precioPeniaNoUniLuz = "900 €";

	public PistaPolidep() {

	}

	public void setPistaId(String id) {
		this.pistaId = id;
	}

	/*
	 * public void setNumero(int numero){ this.numero=numero; }
	 */

	public PistaPolidep(String pistaId, String nom, String preUniSinLuz,
			String preUniLuz, String preNoUniSinLuz, String preNoUniLuz,
			String prePeniaUniSinLuz, String prePeniaUniLuz,
			String prePeniaNoUniSinLuz, String prePeniaNoUniLuz) {
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

	public String getPrecioUniversitarioSinLuz() {
		return precioUniSinLuz;
	}

	public String getPrecioUniversitarioLuz() {
		return precioUniLuz;
	}

	public String getPrecioNoUniversitarioSinLuz() {
		return precioNoUniSinLuz;
	}

	public String getPrecioNoUniversitarioLuz() {
		return precioNoUniLuz;
	}

	public String getPrecioPeniaUniversitarioSinLuz() {
		return precioPeniaUniSinLuz;
	}

	public String getPrecioPeniaUniversitarioLuz() {
		return precioPeniaUniLuz;
	}

	public String getPrecioPeniaNoUniversitarioSinLuz() {
		return precioPeniaNoUniSinLuz;
	}

	public String getPrecioPeniaNoUniversitarioLuz() {
		return precioPeniaNoUniLuz;
	}

}

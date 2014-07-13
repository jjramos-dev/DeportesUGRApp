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

/**
 * Clase que contiene la informacion de la piscina
 *
 */
public class Piscina {
	String pistaId = null;
	// int numero=13;
	String nombre = "Piscina";
	// String descripcion;
	String precioLibreUni = "2 €";
	String precioLibreNoUni = "2,5 €";
	String precioAdultosDiarioUni = "3 €";
	String precioAdultosDiarioNoUni = "5 €";
	String precioAdultosFindeUni = "4 €";
	String precioAdultosFindeNoUni = "7 €";
	String precioNiniosJubDiarioUni = "2,5 €";
	String precioNiniosJubDiarioNoUni = "4 €";
	String precioNiniosJubFindeUni = "3,5 €";
	String precioNiniosJubFindeNoUni = "6 €";

	/**
	 * Constructor
	 */
	public Piscina() {

	}

	/**
	 * Metodo para asignar una ID a la pista
	 * @param id
	 */
	public void setPistaId(String id) {
		this.pistaId = id;
	}

	/**
	 * Constructor con argumentos
	 */

	public Piscina(String pistaId, String nom, String preLibreUni,
			String preLibreNoUni, String preAdultosDiarioUni,
			String preAdultosDiarioNoUni, String preAdultosFindeUni,
			String preAdultosFindeNoUni, String preNiniosJubDiarioUni,
			String preNiniosJubDiarioNoUni, String preNiniosJubFindeUni,
			String preNiniosJubFindeNoUni) {
		this.pistaId = pistaId;
		// this.numero=numero;
		this.nombre = nom;
		this.precioLibreUni = preLibreUni;
	}

	/**
	 * Metodo para obtener la id de la pista
	 */
	public String getPistaId() {
		return pistaId;
	}

	/**
	 * Metodo para obtener el nombre de la pista
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para obtener el precio de la natacion libre para universitarios 
	 */
	public String getPrecioLibreUni() {
		return precioLibreUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion libre para no universitarios 
	 */
	public String getPrecioLibreNoUni() {
		return precioLibreNoUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa para universitarios 
	 */
	public String getPrecioAdultosDiarioUni() {
		return precioAdultosDiarioUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa para no universitarios 
	 */
	public String getPrecioAdultosDiarioNoUni() {
		return precioAdultosDiarioNoUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa findes para universitarios 
	 */
	public String getPrecioAdultosFindeUni() {
		return precioAdultosFindeUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa findes para no universitarios 
	 */
	public String getPrecioAdultosFindeNoUni() {
		return precioAdultosFindeNoUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa para niños y jubilados  de la comunidad universitaria
	 */
	public String getPrecioNiniosJubDiarioUni() {
		return precioNiniosJubDiarioUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa para niños y jubilados  de la comunidad no universitaria
	 */
	public String getPrecioNiniosJubDiarioNoUni() {
		return precioNiniosJubDiarioNoUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa para niños y jubilados findes de la comunidad universitaria
	 */
	public String getPrecioNiniosJubFindeUni() {
		return precioNiniosJubFindeUni;
	}

	/**
	 * Metodo para obtener el precio de la natacion recreativa para niños y jubilados findes de la comunidad no universitaria
	 */
	public String getPrecioNiniosJubFindeNoUni() {
		return precioNiniosJubFindeNoUni;
	}

}

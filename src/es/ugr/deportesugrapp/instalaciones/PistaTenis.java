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
 * Clase con la informacion de la pista de tenis
 */
public class PistaTenis {
	String pistaId = null;
	// int numero=13;
	String nombre = "Tenis";
	// String descripcion;
	String precioUniSinLuz = "4.5 €";
	String precioUniLuz = "5.5 €";
	String precioNoUniSinLuz = "7 €";
	String precioNoUniLuz = "11 €";
	String precioPeniaUniSinLuz = "-";
	String precioPeniaUniLuz = "-";
	String precioPeniaNoUniSinLuz = "-";
	String precioPeniaNoUniLuz = "-";

	/**
	 * Constructor
	 */
	public PistaTenis() {

	}

	/**
	 * Metodo para asignar la ID de la pista
	 */
	public void setPistaId(String id) {
		this.pistaId = id;
	}

	
	/**
	 * Constructor con argumentos
	 */

	public PistaTenis(String pistaId, String nom, String preUniSinLuz,
			String preUniLuz, String preNoUniSinLuz, String preNoUniLuz,
			String prePeniaUniSinLuz, String prePeniaUniLuz,
			String prePeniaNoUniSinLuz, String prePeniaNoUniLuz) {
		this.pistaId = pistaId;
		// this.numero=numero;
		this.nombre = nom;
		this.precioUniSinLuz = preUniSinLuz;
	}

	/**
	 * Metodo para obtener la ID de la pista
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
	 * Metodo para obtener el precio para universitarios sin luz
	 */
	public String getPrecioUniversitarioSinLuz() {
		return precioUniSinLuz;
	}

	/**
	 * Metodo para obtener el precio para universitarios con luz
	 */
	public String getPrecioUniversitarioLuz() {
		return precioUniLuz;
	}

	/**
	 * Metodo para obtener el precio para no universitarios sin luz
	 */
	public String getPrecioNoUniversitarioSinLuz() {
		return precioNoUniSinLuz;
	}

	/**
	 * Metodo para obtener el precio para nouniversitarios con luz
	 */
	public String getPrecioNoUniversitarioLuz() {
		return precioNoUniLuz;
	}

	/**
	 * Metodo para obtener el precio para penias universitarias sin luz
	 */
	public String getPrecioPeniaUniversitarioSinLuz() {
		return precioPeniaUniSinLuz;
	}

	/**
	 * Metodo para obtener el precio para penias universitarias con luz
	 */
	public String getPrecioPeniaUniversitarioLuz() {
		return precioPeniaUniLuz;
	}

	/**
	 * Metodo para obtener el precio para penias no universitarias sin luz
	 */
	public String getPrecioPeniaNoUniversitarioSinLuz() {
		return precioPeniaNoUniSinLuz;
	}

	/**
	 * Metodo para obtener el precio para penias no universitarias con luz
	 */
	public String getPrecioPeniaNoUniversitarioLuz() {
		return precioPeniaNoUniLuz;
	}

}

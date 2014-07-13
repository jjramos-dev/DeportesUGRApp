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
package es.ugr.deportesugrapp.reservas;

/**
 * Clase que contiene los datos de interes de las pistas reservables
 *
 */
public class PistaReservable {

	private String codigo = null;
	private String titulo = null;

	/**
	 * Constructor de la clase
	 */
	PistaReservable() {

	}

	/**
	 * Constructor de la clase con argumentos
	 * @param codigoPista Codigo de la pista
	 * @param pista Nombre de la pista
	 */
	PistaReservable(String codigoPista, String pista) {
		this.codigo = codigoPista;
		this.titulo = pista;
	}

	/**
	 * Metodo que nos permite obtener el codigo de la pista
	 * @return Devuelve el codigo de la pista
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que nos permite obtener el Nombre de la instalacion
	 * @return Devuelve el nombre de la pista
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que nos permite asignar el codigo de la pista
	 * @param codigo Codigo de la pista
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que nos permite asignar el nombre de la pista
	 * @param titulo Nombre de la pista
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}

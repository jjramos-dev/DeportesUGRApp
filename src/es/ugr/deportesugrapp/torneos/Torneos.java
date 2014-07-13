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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para obtener informacion sobre los torneos
 *
 */
public class Torneos {
	private String url;
	private List<Categoria> listaCategorias;

	/**
	 * Constructor de la clase con argumentos
	 * @param url URL del kla competicion
	 */
	public Torneos(String url) {
		this.url = url;
		this.listaCategorias = new ArrayList<Categoria>();
	}

	/**
	 * Metodo para obtener la URL de la competicion
	 * @return Devuelve la URL de la competicion
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para asignar la URL de la competicion
	 * @param url URL de la competicion
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Metodo para obtener la lista de competiciones disponibles
	 * @return Devuelve una lista con las competiciones disponibles
	 */
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	/**
	 * Metodo para asignar una lista de competiciones
	 * @param listaCategorias Lista de competiciones
	 */
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	/**
	 * Metodo para obtener la categoria
	 * @param categoriaId ID de la categoria
	 * @return Devuelve la categoria
	 */
	public Categoria getCategoria(String categoriaId) {
		Categoria categoria = null;
		for (Categoria categoria_ : listaCategorias) {
			if (categoriaId.compareTo(categoria_.getId()) == 0) {
				categoria = categoria_;
			}
		}

		return categoria;
	}
}

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
package es.ugr.deportesugrapp.noticias;

/**
 * Clase que contiene los datos de interes de la noticia
 */
public class NoticiasEstructura {

	private String title;
	private String link;
	private String pubDate;

	
	/**
	 * Metodo que obtiene el titulo de la noticia 
	 * @return Devuelve el titulo de la noticia
	 */
	public String getTitle() {
		return title;
	}

	
	/**
	 * Metodo que asigna el titulo
	 * @param title Titulo de la noticia
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Metodo que obtiene la URL de la noticia
	 * @return Devuelve la URL de la noticia
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Asigna la URL de la noticia
	 * @param link URL de la noticia
	 */
	public void setLink(String link) {
		this.link = link;
	}

	
	/**
	 * Metodo que asigna la fecha de publicacion de la noticia
	 * @param pubDate Fecha de publicacion de la noticia
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	
	/**
	 * Metodo que obtiene la fecha de publicacion de la noticia
	 * @return Devuleve la fecha de publicacion de la noticia
	 */
	public String getPubDate() {
		return pubDate;
	}

	
	@Override
	public String toString() {
		return title + "\n" + pubDate;
	}

}

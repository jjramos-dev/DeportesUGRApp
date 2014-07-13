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


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase para obtener datos de la noticia
 */
public class Noticia {
	String url;
	String titulo = "Sin título";
	String textoHtml;
	private String imagenURL = null;

	final static String baseURLNoticias = "http://cad.ugr.es/pages/tablon/*";

	/**
	 * Constructor
	 */
	public Noticia() {

	}

	/**
	 * Constructor con argumentos
	 */
	public Noticia(String tablon, String noticiaId) {

		if (noticiaId.startsWith("http")) {
			url = noticiaId;
		} else {
			url = baseURLNoticias + "/" + tablon + "/" + noticiaId;
		}
	}

	/**
	 * Constructor con argumentos
	 */
	private Noticia(String url, String titulo, String pagina) {
		this.url = url;
		this.titulo = titulo;
		this.textoHtml = pagina;
	}

	/**
	 * Metodo para obtener la URL de la imagen
	 */
	public String getImagenURL() {
		return imagenURL;
	}

	/**
	 * Metodo para asignar la URL de la imagen
	 */
	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}

	/**
	 * Metodo para obtener la URL de la noticia
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Metodo para asignar la URL de la noticia
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Metodo para obtener el titulo de la noticia
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo para asignar el titulo de la noticia
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo para obtener el cuerpo de la noticia
	 */
	public String getTextoHtml() {
		return textoHtml;
	}

	/**
	 * Metodo para asignar el cuerpo de la noticia
	 */
	public void setTextoHtml(String textoHtml) {
		this.textoHtml = textoHtml;
	}

}

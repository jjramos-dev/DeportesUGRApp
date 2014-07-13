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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;


/**
 * Clase Handler
 */
public class Handler extends DefaultHandler {
	
	private NoticiasEstructura estructura = new NoticiasEstructura();
	private List<NoticiasEstructura> noticiasList = new ArrayList<NoticiasEstructura>();

	StringBuffer chars = new StringBuffer();

	/**
	 * Metodo que comienza a leer
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes atts) {
		chars = new StringBuffer();

	}

	/**
	 * Metodo que finaliza de leer
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equalsIgnoreCase("title")) {
			estructura.setTitle(chars.toString());
		} else if (localName.equalsIgnoreCase("pubDate")) {

			estructura.setPubDate(chars.toString());
		} else if (localName.equalsIgnoreCase("link")) {

			estructura.setLink(chars.toString());

		}
		if (localName.equalsIgnoreCase("item")) {
			noticiasList.add(estructura);

			estructura = new NoticiasEstructura();

		}
	}

	public void characters(char ch[], int start, int length) {
		chars.append(new String(ch, start, length));
	}

	/**
	 * Metodo que obtiene las noticias publicadas
	 * @param notUrl URL sobre la que carga las noticias
	 * @return Devuelve la lista de noticias
	 */
	public List<NoticiasEstructura> obtenerNoticias(String notUrl) {
		URL url = null;
		try {

			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			url = new URL(notUrl);
			xr.setContentHandler(this);
			xr.parse(new InputSource(url.openStream()));
		} catch (IOException e) {
		} catch (SAXException e) {
		} catch (ParserConfigurationException e) {

		}

		return noticiasList;
	}

}
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jjramos
 */
public class Noticia {
    String url;
    String titulo="Sin título";
    String textoHtml;
    private String imagenURL=null;
   
    final static String baseURLNoticias="http://cad.ugr.es/pages/tablon/*";
 
    public Noticia(){
        
    }
    
    public Noticia(String tablon, String noticiaId) {
        
        if(noticiaId.startsWith("http")){
            url=noticiaId;
        } else {
            url=baseURLNoticias +"/"+tablon+"/"+noticiaId;
        } 
    }

    private Noticia(String url, String titulo, String pagina) {
        this.url=url;
        this.titulo=titulo;
        this.textoHtml=pagina;
    }
    

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTextoHtml() {
        return textoHtml;
    }

    public void setTextoHtml(String textoHtml) {
        this.textoHtml = textoHtml;
    }
    
    
}

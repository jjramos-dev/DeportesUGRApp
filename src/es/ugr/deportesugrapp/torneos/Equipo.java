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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ugr.deportesugrapp.torneos;

/**
 *
 * @author jjramos
 */
public class Equipo {
    private String nombre;
    private String url;

    Equipo(){
        
    }
    
    public Equipo(String nombre, String url) {
        this.nombre=nombre;
        this.url=url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}

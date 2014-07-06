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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jjramos
 */
public class Categoria {
    String titulo;
    private String url;
    private String urlNormativa=null;
    private List<Deporte> listaDeportes;
    private List<Clasificaciones> listaClasificaciones;
    private String id;
    private String anio;

    public Categoria(String url) {
        this.url=url;
        listaDeportes=new ArrayList<Deporte>();
        listaClasificaciones=new ArrayList<Clasificaciones>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    void mostrar() {
    
        System.out.println("Normativa: "+this.urlNormativa);
       System.out.println("URL: "+this.url);
       System.out.println("Nombre: "+this.titulo);
       System.out.println("Año: "+this.getAnio());
       
       for(Deporte deporte:listaDeportes){
           System.out.println("\t"+deporte.getTitulo()+" -> "+deporte.getUrl());
           
           // Buscamos las clasificaciones de cada deporte. Esto es súperineficiente!!!!! cambiar!!!
           for(Clasificaciones clasificaciones:listaClasificaciones){
               // Sólo si es la clasificación para este deporte, lo mostramos:
               if(deporte==clasificaciones.getDeporte()){
                   // Por cada fase,
                   for(Fase fase:clasificaciones.getFases()){
                       
                       System.out.println("\t\t"+fase.getTitulo());
                       for(Ronda ronda:fase.getRondas()){
                            System.out.println("\t\t\t"+ronda.getTitulo());
                            
                            for(Partido partido:ronda.getPartidos()){
                                System.out.println("\t\t\t\tEl "+partido.getFechaString()+
                                        " a las "+ partido.getHoraString()+
                                        " en "+ partido.getLugar()+", "+
                                        partido.getEquipo1().getNombre()+" vs "+
                                        partido.getEquipo2().getNombre()+" ("+
                                        partido.getEstado()+") "+
                                        partido.getResultadoEquipo1()+"-"+partido.getResultadoEquipo2());
                            }
                        }
                   }
               }
           }
       }   
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlNormativa() {
        return urlNormativa;
    }

    public void setUrlNormativa(String urlNormativa) {
        this.urlNormativa = urlNormativa;
    }

    public List<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(List<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    public List<Clasificaciones> getListaClasificaciones() {
        return listaClasificaciones;
    }

    public void setListaClasificaciones(List<Clasificaciones> listaClasificaciones) {
        this.listaClasificaciones = listaClasificaciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Fase> getFases(String deporteId) {
           
        List<Fase> fases=null;
        
// Buscamos las clasificaciones de cada deporte. Esto es súperineficiente!!!!! cambiar!!!
           for(Clasificaciones clasificaciones:listaClasificaciones){
               // Sólo si es la clasificación para este deporte, lo mostramos:
               if(deporteId.compareTo(clasificaciones.getDeporte().getId())==0){
                   // Por cada fase,
                   fases=clasificaciones.getFases();
               }
           }
           
           return fases;
    }

    void setTitulo(String text) {
       titulo=text;
    }

    void setAnio(String anio) {
        this.anio=anio;
    }

    public String getAnio() {
        return anio;
    }
    
}

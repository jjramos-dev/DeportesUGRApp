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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jjramos
 */
public class Piscina {
    String pistaId=null;
    //int numero=13;
    String nombre = "Piscina";
//    String descripcion;
    String precioLibreUni="2 €";
    String precioLibreNoUni="2,5 €";
    String precioAdultosDiarioUni="3 €";
    String precioAdultosDiarioNoUni="5 €";
    String precioAdultosFindeUni="4 €";
    String precioAdultosFindeNoUni="7 €";
    String precioNiniosJubDiarioUni="2,5 €";
    String precioNiniosJubDiarioNoUni="4 €";
    String precioNiniosJubFindeUni="3,5 €";
    String precioNiniosJubFindeNoUni="6 €";

    public Piscina(){

    }
    
    public void setPistaId(String id){
    	this.pistaId=id;
    }
    
    /* public void setNumero(int numero){
    	this.numero=numero;
    } */
    
    public Piscina(String pistaId, String nom, String preLibreUni, String preLibreNoUni, String preAdultosDiarioUni, String preAdultosDiarioNoUni, String preAdultosFindeUni, String preAdultosFindeNoUni, String preNiniosJubDiarioUni, String preNiniosJubDiarioNoUni, String preNiniosJubFindeUni, String preNiniosJubFindeNoUni) {
        this.pistaId=pistaId;
       // this.numero=numero;
        this.nombre=nom;
        this.precioLibreUni=preLibreUni;
    }

    public String getPistaId() {
        return pistaId;
    }
    
    /*
    public int getNumero(){
        return numero;
    }
    
    */

	public String getNombre(){
        return nombre;
    }
    
    public String getPrecioLibreUni(){
        return precioLibreUni;
    }
    
    public String getPrecioLibreNoUni(){
        return precioLibreNoUni;
    }
    
    public String getPrecioAdultosDiarioUni(){
        return precioAdultosDiarioUni;
    }
    
    public String getPrecioAdultosDiarioNoUni(){
        return precioAdultosDiarioNoUni;
    }
    
    public String getPrecioAdultosFindeUni(){
        return precioAdultosFindeUni;
    }
    
    public String getPrecioAdultosFindeNoUni(){
        return precioAdultosFindeNoUni;
    }
    
    public String getPrecioNiniosJubDiarioUni(){
        return precioNiniosJubDiarioUni;
    }
    
    public String getPrecioNiniosJubDiarioNoUni(){
        return precioNiniosJubDiarioNoUni;
    }
    
    public String getPrecioNiniosJubFindeUni(){
        return precioNiniosJubFindeUni;
    }
    
    public String getPrecioNiniosJubFindeNoUni(){
        return precioNiniosJubFindeNoUni;
    }
    
    
    
    
    
    
    
    
}

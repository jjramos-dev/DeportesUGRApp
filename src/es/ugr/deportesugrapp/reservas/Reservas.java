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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jjramos
 */
public class Reservas {
    List<Pista2> listaPistas;
    private final String urlReservasPrincipal;
    
    Reservas(String urlReservasPrincipal){
        this.urlReservasPrincipal=urlReservasPrincipal;
    }
    
    Reservas(String urlBase,String dni){
        this.urlReservasPrincipal="https://oficinavirtual.ugr.es/CarneUniversitario/TarjetasDeportes.jsp?textoXML=<xml><numero_PIU></numero_PIU><solicitud><dni>"+dni+"</dni><nia></nia><tarjeta_deportiva>1</tarjeta_deportiva><pago_viable>0</pago_viable><saldo_monedero>0</saldo_monedero></solicitud></xml>#";
    }
}

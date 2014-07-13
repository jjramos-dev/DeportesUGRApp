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

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite obtener informacion sobre los partidos
 *
 */
public class Partido {
	private Date fecha = null;
	private String fechaString = null;
	private String horaString = null;
	private Date hora = null;
	private String lugar;
	private Equipo equipo1;
	private Equipo equipo2;
	private String estado;
	private String resultadoEquipo1 = null;
	private String resultadoEquipo2 = null;

	/**
	 * Constructor de la clase
	 */
	public Partido() {
	}

	/**
	 * Metodo para obtener la fecha actual
	 * @return Devuelve la fecha actual
	 */
	public Date getFecha() {
		if (fecha == null) {

			Date thedate;
			try {
				Calendar mydate = new GregorianCalendar();

				thedate = new SimpleDateFormat("dd/MM/yyyy hh:mm",
						Locale.getDefault()).parse(fechaString + " "
						+ horaString);
				mydate.setTime(thedate);
				fecha = mydate.getTime();

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return fecha;
	}

	/**
	 * Metodo para asignar la fecha del partido
	 * @param fecha Fecha del partido
	 */
	@JsonIgnore
	void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo para obtener la fecha del partido
	 * @return Devuelve la fechad el partido
	 */
	public String getFechaString() {
		return fechaString;
	}

	/**
	 * Metodo para asignar la fecha del partido
	 * @param fechaString Fecha del partido
	 */
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	/**
	 * Metodo para obtener la hora del partido
	 * @return Devuelve la hora del partido
	 */
	public String getHoraString() {
		return horaString;
	}

	/**
	 * Metodo para asignar la hora del partido
	 * @param horaString Hora del partido
	 */
	public void setHoraString(String horaString) {
		this.horaString = horaString;
	}

	/**
	 * Metodo para obtener la hora actual
	 * @return Devuelve la hora actual
	 */
	public Date getHora() {
		return hora;
	}

	/**
	 * Metodo para asignar la hora actual
	 * @param hora Hora actual
	 */
	@JsonIgnore
	public void setHora(Date hora) {
		this.hora = hora;
	}

	/**
	 * Metodo para obtener el equipo 1
	 * @return Devuelve el equipo 1
	 */
	public Equipo getEquipo1() {
		return equipo1;
	}

	/**
	 * Metodo para asignar el equipo 1
	 * @param equipo1 Equipo 1
	 */
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	/**
	 * Metodo para obtener el equipo 2
	 * @return Devuelve el equipo 2
	 */
	public Equipo getEquipo2() {
		return equipo2;
	}

	/**
	 * Metodo para asignar el equipo 2
	 * @param equipo2
	 */
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	/**
	 * Metodo para asignar la fecha
	 * @param text String con la fecha
	 */
	void setFecha(String text) {

		this.fechaString = text;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			fecha = formatter.parse(text);

		} catch (ParseException ex) {
			// Logger.getLogger(Partido.class.getName()).log(Level.SEVERE, null,
			// ex);
			fecha = null;
		}
	}

	/**
	 * Metodo para asignar la hora
	 * @param text String con la hora
	 */
	void setHora(String text) {
		this.horaString = text;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			hora = formatter.parse(text);
		} catch (ParseException ex) {
			hora = null;
		}
	}

	/**
	 * Metodo para asignar el lugar del partido
	 * @param text String con el lugar
	 */
	public void setLugar(String text) {
		lugar = text;
	}

	/**
	 * Metodo para asignar el nombre y URL del equipo 1
	 * @param nombre Nombre del equipo 1
	 * @param url URL del equipo 1
	 */
	void setEquipo1(String nombre, String url) {
		equipo1 = new Equipo(nombre, url);
	}

	/**
	 * Metodo para asignar el nombre y URL del equipo 2
	 * @param nombre Nombre del equipo 2
	 * @param url URL del equipo 2
	 */
	void setEquipo2(String nombre, String url) {
		equipo2 = new Equipo(nombre, url);
	}

	/**
	 * Metodo para asignar el estado del partido
	 * @param text String con el estado
	 */
	void setEstado(String text) {
		estado = text;
	}

	/**
	 * Metodo para asignar el resultado del equipo 1
	 * @param string String con el resultado del equipo 1
	 */
	void setResultadoEquipo1(String string) {
		resultadoEquipo1 = string;
	}

	/**
	 * Metodo para asignar el resultado del equipo 2
	 * @param string String con el resultado del equipo 2
	 */
	void setResultadoEquipo2(String string) {
		resultadoEquipo2 = string;
	}

	/**
	 * Metodo para obtener el lugar donde se jugara el partido
	 * @return Devuelve el lugar del partido
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo para obtener el estado del partido
	 * @return Devuelve el estado del partido
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo para obtener el resultado del equipo 1
	 * @return Devuelve el resultado del equipo 1
	 */
	public String getResultadoEquipo1() {
		return resultadoEquipo1;
	}

	/**
	 * Metodo para obtener el resultado del equipo 2
	 * @return Devuelve el resultado del equipo 2
	 */
	public String getResultadoEquipo2() {
		return resultadoEquipo2;
	}

}

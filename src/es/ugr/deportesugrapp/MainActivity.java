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
package es.ugr.deportesugrapp;

import es.ugr.deportesugrapp.reservas.ReservasActivity;
import es.ugr.deportesugrapp.torneos.TorneoActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * Activity  principal, desde aqui, comienza la app.
 * 
 */

public class MainActivity extends ActionBarActivity {

	/**
	 * Metodo que crea/inicializa la activity
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("DeportesUGR");
		// actionBar.setSubtitle("");

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity con el Acerca de
	 * @param v
	 */
	public void onClickAcercaDe(View v) {
		Intent acercaDeIntent = new Intent(this, AboutActivity.class);
		startActivity(acercaDeIntent);
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity con las competiciones disponibles
	 * @param v
	 */
	public void onClickCompeticiones(View v) {
		Intent torneosIntent = new Intent(this, TorneoActivity.class);
		startActivity(torneosIntent);
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity con las noticias disponibles
	 * @param v
	 */
	public void onClickNoticias(View v) {
		Intent noticiasIntent = new Intent(this, Noticias.class);
		startActivity(noticiasIntent);
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity con las instalaciones de los diferentes campus
	 * @param v
	 */
	public void onClickInstalaciones(View v) {
		Intent instalacionesIntent = new Intent(this, Instalaciones.class);
		startActivity(instalacionesIntent);
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity con la informacion de contacto
	 * @param v
	 */
	public void onClickInfo(View v) {
		Intent infoIntent = new Intent(this, InfoContacto.class);
		startActivity(infoIntent);
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity para la eleccion de mis equipos
	 * @param v
	 */
	public void onClickMisEquipos(View v) {
		Intent perfilIntent = new Intent(this, MisEquipos.class);
		startActivity(perfilIntent);
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity para ver la disponibilidad de las instalaciones
	 * @param v
	 */
	public void onClickReservas(View v) {
		Intent reservasIntent = new Intent(this, ReservasActivity.class);
		startActivity(reservasIntent);
	}

}

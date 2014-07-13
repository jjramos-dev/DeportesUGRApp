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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Activity que muestra la lista de instalaciones por cada campus
 */
public class Instalaciones extends ActionBarActivity {

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instalaciones);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Instalaciones");
		// actionBar.setSubtitle("");

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPabellonesFuentenueva(View v) {
		Intent webPabFuente = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainPabellon.class);
		startActivity(webPabFuente);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPistasPolideportivas(View v) {
		Intent webPistasPoli = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainPistaPolidep.class);
		startActivity(webPistasPoli);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPistasVoleyPlaya(View v) {
		Intent webPlaya = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainVoleyPlaya.class);
		startActivity(webPlaya);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickFutbol11Fuente(View v) {
		Intent webFutbol11Fuente = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainFutbol11.class);
		startActivity(webFutbol11Fuente);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickCampoRugby(View v) {
		Intent webRugby = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainRugby.class);
		startActivity(webRugby);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPiscina(View v) {
		Intent webPiscina = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainPiscina.class);
		startActivity(webPiscina);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPabellonCartuja(View v) {
		Intent webPabCartuja = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainPabellon.class);
		startActivity(webPabCartuja);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPistaCesped(View v) {
		Intent webPistaCesped = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainFutsalCesped.class);
		startActivity(webPistaCesped);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickFutbol11Cartuja(View v) {
		Intent webFutbol11Cartuja = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainFutbol11.class);
		startActivity(webFutbol11Cartuja);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPistasPadel(View v) {
		Intent webPadel = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainPadel.class);
		startActivity(webPadel);

	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity que nos muestra la informacion de dicha instalacion
	 * @param v
	 */
	public void onClickPistasTenis(View v) {
		Intent webTenis = new Intent(this,
				es.ugr.deportesugrapp.instalaciones.InstaMainTenis.class);
		startActivity(webTenis);

	}

}
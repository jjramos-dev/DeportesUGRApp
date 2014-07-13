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
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Clase para la actividad "Acerca De"
 * 
 * @author Luis Carlos Casanova y Juan José Ramos
 * @mail deporteugrapp@ugr.es
 * 
 */

public class AboutActivity extends ActionBarActivity {
	// TODO:Sustituya la url del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String URL_PROMOTOR1 = "http://www.ugr.es/";
	// TODO:Sustituya la url del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String URL_PROMOTOR2 = "http://detic.ugr.es/";
	// TODO:Sustituya la url del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String URL_CODIGOFUENTE = "https://github.com/jjramos-dev/DeportesUGRApp";
	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String MAIL_PROMOTOR1 = "informa@ugr.es";
	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String MAIL_PROMOTOR2 = "pacopo@ugr.es";
	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String MAIL_NUESTRO = "deporteugrapp@ugr.es";
	// URL AppsUGR
	private final String URL_APPS_UGR = "http://apps.ugr.es";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_activity_layout);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Acerca de");
		// actionBar.setSubtitle("");

		//TextView disclaimer = (TextView) findViewById(R.id.disclaimer);
		// disclaimer.setTextSize(11);
		//disclaimer
				//.setText("DeportesUGR es una aplicación que permite acceder a la información de la página web del Centro de Actividades Deportivas de la UGR. DeportesUGR y el servidor correspondiente usan software libre (JSoup licencia MIT, Jackson licencia Apache 2.0, RESTlet licencia Apache 2.0).");
						
		
		TextView descargo = (TextView) findViewById(R.id.descargo);
		//disclaimer.setTextSize(11);
		//descargo
				//.setText("Descargo de responsabilidad: La Universidad de Granada no se hace responsable del uso de esta aplicacion. Este software se proporciona tal cual ('as-is'), sin garantia de ningun tipo, expresa o implicita. En ningun caso los autores o los titulares del copyright serán responsables de ninguna queja, daños u otra responsabilidad que surja en relacion al software, su uso, su tratamiento, o el servicio que proporciona.\n\nAgradecimientos: \nRosana Montes (CEVUG); Servicio del CAD, especialmente a Jordi Mercade, Alex Requena, Fernando S. Martinez (CAD); Antonio Muñoz (CSIRC).");

		descargo
		.setText("Descargo de responsabilidad:\n La Universidad de Granada no se hace responsable del uso de esta aplicación.\n" +
				"DeportesUGR se proporciona tal cual ('as-is'), sin garantía de ningún tipo, y bajo la licencia GPLv3 (vea los detalles en el fichero de licencia o en <http://www.gnu.org/licenses/>).\n\n" +
				"Agradecimientos: \nRosana Montes (CEVUG); Servicio del CAD, especialmente a Jordi Mercadé, Álex Requena, Fernando S. Martínez; Antonio Muñoz (CSIRC); y J.J. Merelo (OSL).\n\n" +
				"DeportesUGR y el servidor correspondiente usan software libre (JSoup licencia MIT, Jackson licencia Apache 2.0, RESTlet licencia Apache 2.0). Los iconos de Diego José Molins R. están licenciados bajo CC BY-NC-SA 4.0.\n\n");

		
	}

	
	/**
	 * e que nos permite que al pulsar el boton se abra la web del promotor1
	 * @param v
	 */
	public void onClickPromotor1(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_PROMOTOR1));
		startActivity(webBrowser);

	}

	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra el cuadro de dialogo para mandar un email al promotor1
	 * @param v
	 */
	public void onClickBotonContacto1(View v) {
		Intent enviarEmail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"
				+ MAIL_PROMOTOR1));
		startActivity(enviarEmail);

	}

	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra la web del promotor2
	 * @param v
	 */
	public void onClickPromotor2(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_PROMOTOR2));
		startActivity(webBrowser);

	}

	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra el cuadro de dialogo para mandar un email al promotor2
	 * @param v
	 */
	public void onClickBotonContacto2(View v) {
		Intent enviarEmail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"
				+ MAIL_PROMOTOR2));
		startActivity(enviarEmail);

	}

	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra la pagina web de las Apps de la UGR
	 * @param v
	 */
	public void onClickAppsUgr(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_APPS_UGR));
		startActivity(webBrowser);
	}

	/**
	 * Metodo que nos permite que al pulsar el boton se abra el fichero que contiene la licencia Apache 2.0
	 * @param v
	 */
	public void onClickLicenciaApache(View v) {
		Intent abrirLicenciaApache = new Intent(this, LicenciaApache.class);
		startActivity(abrirLicenciaApache);

	}

	/**
	 * Metodo que nos permite que al pulsar el boton se abra el fichero que contiene la licencia MIT
	 * @param v
	 */
	public void onClickLicencia2(View v) {
		Intent abrirLicencia2 = new Intent(this, Licencia2.class);
		startActivity(abrirLicencia2);

	}
	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra la pagina web que contiene el codigo fuente
	 * @param v
	 */
	public void onClickCodigoFuente(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_CODIGOFUENTE));
		startActivity(webBrowser);

	}
	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra el fichero que contiene la licencia GPLV3
	 * @param v
	 */
	public void onClickLicenciaGPLV3(View v) {
		Intent abrirLicenciaGPLV3 = new Intent(this, LicenciaGPLV3.class);
		startActivity(abrirLicenciaGPLV3);

	}
	
	/**
	 * Metodo que nos permite que al pulsar el boton se abra el cuadro de dialogo para mandar un email a los desarrolladores
	 * @param v
	 */
	public void onClickBotonContactoNuestro(View v) {
		Intent enviarEmail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"
				+ MAIL_NUESTRO));
		startActivity(enviarEmail);

	}

}

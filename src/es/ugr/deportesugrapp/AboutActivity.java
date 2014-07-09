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
 * Clase para la actividad el "Acerca De"
 * 
 * @author Namir Sayed-Ahmad Baraza
 * @mail namirsab@gmail.com
 * 
 */

public class AboutActivity extends ActionBarActivity {
	// TODO:Sustituya la url del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String URL_PROMOTOR1 = "http://cevug.ugr.es/";
	// TODO:Sustituya la url del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String URL_PROMOTOR2 = "http://csirc.ugr.es/";
	// TODO:Sustituya la url del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String URL_CODIGOFUENTE = "https://github.com/jjramos-dev/DeportesUGRApp";
	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String MAIL_PROMOTOR1 = "cevug@ugr.es";
	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String MAIL_PROMOTOR2 = "csirc@ugr.es";
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

		TextView disclaimer = (TextView) findViewById(R.id.disclaimer);
		// disclaimer.setTextSize(11);
		disclaimer
				.setText("DeportesUGR es una aplicación que permite acceder a la información de la página web del Centro de Actividades Deportivas de la UGR. DeportesUGR y el servidor correspondiente usan software libre (JSoup licencia MIT, Jackson licencia Apache 2.0, RESTlet licencia Apache 2.0).\n \n" +
						"Descargo de responsabilidad: La Universidad de Granada no se hace responsable del uso de esta aplicación. " +

						"DeportesUGR es software libre: puede redistribuirlo y/o modificarlo bajo los términos de la Licencia General Pública de GNU publicada por la Free Software Foundation, ya sea la versión 3 de la Licencia, o (a su elección) cualquier versión posterior.\n"+
						"Este programa se distribuye con la esperanza de que sea útil pero SIN NINGUNA GARANTÍA; incluso sin la garantía implícita de MERCANTIBILIDAD o CALIFICADA PARA UN PROPÓSITO EN PARTICULAR. Vea la Licencia General Pública de GNU para más detalles.\n"+
						"Usted ha debido de recibir una copia de la Licencia General Pública de GNU junto con este programa. Si no, vea <http://www.gnu.org/licenses/>.\n\n"+ 
						//"Este software se proporciona tal cual ('as-is'), sin garantía de ningún tipo, expresa o implícita. En nigún caso los autores o los titulares del copyright serán responsables de ninguna queja, daños u otra responsabilidad que surja en relación al software, su uso, su tratamiento, o el servicio que proporciona.\n\n" +
						"Autores principales de la app: Luis Carlos Casanova y Juan José Ramos\nDesarroladores del servidor: Juan José Ramos, Juan Manuel López, Jorge Navarro, Pablo Ameigeiras y Jonathan Prados\nIconografía: Diego José Molins \n \nAgradecimientos: \nRosana Montes (CEVUG); Servicio del CAD, especialmente a Jordi Mercadé, Álex Requena, Fernando S. Martínez (CAD); Antonio Muñoz (CSIRC)."
						+ "\n\nSi detecta algún error o tiene alguna sugerencia, contacte con nosotros.");

	}

	// Acción al hacer click en la imagen del promotor1. Abre la web.
	public void onClickPromotor1(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_PROMOTOR1));
		startActivity(webBrowser);

	}

	// Acción al pulsar el botón de contacto del promotor1. Abre un cuadro de
	// diálogo para enviar un email
	public void onClickBotonContacto1(View v) {
		Intent enviarEmail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"
				+ MAIL_PROMOTOR1));
		startActivity(enviarEmail);

	}

	// Acción al hacer click en la imagen del promotor1. Abre la web.
	public void onClickPromotor2(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_PROMOTOR2));
		startActivity(webBrowser);

	}

	// Acción al pulsar el botón de contacto del promotor1. Abre un cuadro de
	// diálogo para enviar un email
	public void onClickBotonContacto2(View v) {
		Intent enviarEmail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"
				+ MAIL_PROMOTOR2));
		startActivity(enviarEmail);

	}

	// Acción al hacer click en el boton "Ir a Apps UGR"
	public void onClickAppsUgr(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_APPS_UGR));
		startActivity(webBrowser);
	}

	public void onClickLicenciaApache(View v) {
		Intent abrirLicenciaApache = new Intent(this, LicenciaApache.class);
		startActivity(abrirLicenciaApache);

	}

	public void onClickLicencia2(View v) {
		Intent abrirLicencia2 = new Intent(this, Licencia2.class);
		startActivity(abrirLicencia2);

	}
	
	public void onClickCodigoFuente(View v) {
		Intent webBrowser = new Intent(Intent.ACTION_VIEW,
				Uri.parse(URL_CODIGOFUENTE));
		startActivity(webBrowser);

	}
	
	public void onClickLicenciaGPLV3(View v) {
		Intent abrirLicenciaGPLV3 = new Intent(this, LicenciaGPLV3.class);
		startActivity(abrirLicenciaGPLV3);

	}
	
	public void onClickBotonContactoNuestro(View v) {
		Intent enviarEmail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"
				+ MAIL_NUESTRO));
		startActivity(enviarEmail);

	}

}

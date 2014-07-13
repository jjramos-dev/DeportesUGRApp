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
package es.ugr.deportesugrapp.reservas;

import java.io.UnsupportedEncodingException;
import java.util.List;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.torneos.Fase;
import es.ugr.deportesugrapp.torneos.Partido;
import es.ugr.deportesugrapp.torneos.Ronda;
import es.ugr.deportesugrapp.torneos.CalendariosActivity.SolicitudCalendariosTask;

/**
 * Activity que carga y muestra la tabla de disponibilidad
 *
 */
public class DisponibilidadActivity extends ActionBarActivity {

	public String anioSt;
	public String mesSt;
	public String diaSt;
	public String nombrePista;
	public String codigoPista;
	private WebView webview;
	private DeporteUGRClient cadApi2;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// En realidad, casi todas las activities son iguales (de momento) :)
		setContentView(R.layout.activity_disponibilidad);

		ActionBar actionBar = getSupportActionBar();

		// Guardamos el layout del fondo, para aniadir luego botones o lo que
		// corresponda:
		webview = (WebView) findViewById(R.id.webView1);
		webview.setBackgroundResource(R.drawable.ugr_background);

		cadApi2 = new DeporteUGRClient();

		// Extraemos los parámetros de la llamada del intent:
		Intent intent = getIntent();
		int anio = intent.getIntExtra("com.example.activitydeportes.anio", 0);
		String mes = intent.getStringExtra("com.example.activitydeportes.mes2");
		String dia = intent.getStringExtra("com.example.activitydeportes.dia2");
		codigoPista = intent
				.getStringExtra("com.example.activitydeportes.codigoPista");
		nombrePista = intent
				.getStringExtra("com.example.activitydeportes.nombrePista");
		
		anioSt = String.valueOf(anio);
		

		mesSt = mes;
		diaSt = dia;

		actionBar.setTitle("Reservas");
		actionBar.setSubtitle(nombrePista + " Fecha: " + dia + " / " + mes
				+ " / " + anio);

		/*
		 * // Creamos el AsyncTask que pide los datos mediante el servicio Web:
		 * // Le pasamos la URL base: SolicitudDisponibilidadTask task = new
		 * SolicitudDisponibilidadTask( "http://oberon.ugr.es:8080");
		 * task.execute(codigoPista, diaSt, mesSt, anioSt);
		 */

		webview.setBackgroundColor(0x00000000);
		if (Build.VERSION.SDK_INT >= 11)
			webview.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);

		webview.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				view.setBackgroundColor(0x00000000);
				if (Build.VERSION.SDK_INT >= 11)
					view.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
			}
		});

		new CargadorFechaReserva(this, cadApi2).execute(codigoPista, diaSt,
				mesSt, anioSt);

	}

	/**
	 * Metodo que carga la informacion sobre la disponiblidad de la instalacion seleccionada para la fecha elegida
	 * @param contenido Contenido de la tabla que muestra las reservas
	 */
	public void cargarPaginaWeb(String contenido) {

		if (contenido == null) {
			contenido = "<b>Lo sentimos, no se pudo contactar con el servidor. Por favor, inténtelo de nuevo más tarde.</b>";
		}

		webview.loadDataWithBaseURL(null, contenido, "text/html", "utf-8", null);

	}

}

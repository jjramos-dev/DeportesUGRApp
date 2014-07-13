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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.Global;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Activity que carga la informacion de las pistas polideportivas
 *
 */
public class InstaMainPistaPolidep extends ActionBarActivity {

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prueba_instala);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Instalaciones");
		actionBar.setSubtitle("Pistas Polideportivas");

		// Las funciones de red hay que lanzarlas en backgronud:
		int progreso = 0;

		new SolicitudInfoPistaTask().execute(6);

	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	public class SolicitudInfoPistaTask extends
			AsyncTask<Integer, Integer, PistaPolidep> {
		PistaPolidep pista = null;
		String respuesta = "no";
		private ProgressDialog Dialog;

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(InstaMainPistaPolidep.this);
			Dialog.setMessage("Cargando información...");
			Dialog.show();

		}

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected PistaPolidep doInBackground(Integer... params) {

			int pistaId = params[0];
			// float precio=params[0];
			// int numero=params[0];

			// Hay que formar la dirección del recurso del servicio:
			String url = Global.baseURLServidorNice+"/pista/" + pistaId;

			try {
				// Hacemos una petición HTTP GET... Esto sólo sirve para
				// cosultar! de momento no modificamos nada:
				URL servicio = new URL(url);
				URLConnection conexion = servicio.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						conexion.getInputStream()));

				// Recibimos la respuesta línea a línea (el JSON):
				respuesta = "";
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					// System.out.println(inputLine);
					respuesta = respuesta + inputLine;
				}
				in.close();

				// Intentamos interpertarlo con jackson:
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(
						DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
				pista = mapper.readValue(respuesta, PistaPolidep.class);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return pista;
		}

		/**
		 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
		 */
		@Override
		protected void onPostExecute(PistaPolidep pista2) {
			// TODO Auto-generated method stub
			super.onPostExecute(pista);

			TextView nombrePista = (TextView) findViewById(R.id.nombrePista);
			TextView uniSinLuz = (TextView) findViewById(R.id.precioUniSinLuz);
			TextView uniLuz = (TextView) findViewById(R.id.precioUniLuz);
			TextView noUniSinLuz = (TextView) findViewById(R.id.precioNoUniSinLuz);
			TextView noUniLuz = (TextView) findViewById(R.id.precioNoUniLuz);
			TextView penasUniSinLuz = (TextView) findViewById(R.id.precioPenasUniSinLuz);
			TextView penasUniLuz = (TextView) findViewById(R.id.precioPenasUniLuz);
			TextView penasNoUniSinLuz = (TextView) findViewById(R.id.precioPenasNoUniSinLuz);
			TextView penasNoUniLuz = (TextView) findViewById(R.id.precioPenasNoUniLuz);

			if (pista != null) {

				// nombrePista.setText("Pistas Polideportivas");

				uniSinLuz.setText(pista.getPrecioUniversitarioSinLuz());
				uniLuz.setText(pista.getPrecioUniversitarioLuz());
				noUniSinLuz.setText(pista.getPrecioNoUniversitarioSinLuz());
				noUniLuz.setText(pista.getPrecioNoUniversitarioLuz());
				penasUniSinLuz.setText(pista
						.getPrecioPeniaUniversitarioSinLuz());
				penasUniLuz.setText(pista.getPrecioPeniaUniversitarioLuz());
				penasNoUniSinLuz.setText(pista
						.getPrecioPeniaNoUniversitarioSinLuz());
				penasNoUniLuz.setText(pista.getPrecioPeniaNoUniversitarioLuz());

			} else {
				nombrePista.setTextSize(20);
				nombrePista.setPadding(15, 20, 0, 0);
				nombrePista
						.setText("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo más tarde.");
			}

			Dialog.dismiss();
		}
	}

}

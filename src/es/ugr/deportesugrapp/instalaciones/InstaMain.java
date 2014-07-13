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
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Activity que muestra la informacion de una pista en general
 */
public class InstaMain extends Activity {

	String baseURL = Global.baseURLServidorNice;
	
	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prueba_instala);

		
		// Las funciones de red hay que lanzarlas en backgronud:
		int progreso = 0;

		new SolicitudInfoPistaTask().execute(242424);

	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	public class SolicitudInfoPistaTask extends
			AsyncTask<Integer, Integer, Pista> {
		Pista pista = null;
		String respuesta = "no";

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected Pista doInBackground(Integer... params) {

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
				pista = mapper.readValue(respuesta, Pista.class);

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
		protected void onPostExecute(Pista pista2) {
			// TODO Auto-generated method stub
			super.onPostExecute(pista);

			TextView texto = (TextView) findViewById(R.id.nombrePista);

			if (pista != null) {
				texto.setText(" El identificador de la pista es:"
						+ pista.getPistaId() + "\n Nombre: "
						+ pista.getNombre()
						+ " \n Precio Pista Universitario Sin Luz: "
						+ pista.getPrecioUniversitarioSinLuz()
						+ " \n Precio Pista Universitario Con Luz: "
						+ pista.getPrecioUniversitarioLuz()
						+ " \n Precio Pista No Universitario Sin Luz: "
						+ pista.getPrecioNoUniversitarioSinLuz()
						+ " \n Precio Pista No Universitario Con Luz: "
						+ pista.getPrecioNoUniversitarioLuz()
						+ " \n Precio Pista Penia Universitario Sin Luz: "
						+ pista.getPrecioPeniaUniversitarioSinLuz()
						+ " \n Precio Pista Penia Universitario Con Luz: "
						+ pista.getPrecioPeniaUniversitarioLuz()
						+ " \n Precio Pista Penia No Universitario Sin Luz: "
						+ pista.getPrecioPeniaNoUniversitarioSinLuz()
						+ " \n Precio Pista Penia No Universitario Con Luz: "
						+ pista.getPrecioPeniaNoUniversitarioLuz());
			} else {
				// ¿Qué tipo de error? Esto habrá que refinarlo...
				texto.setText("Error al obtener la informacion de la pista");
			}
		}
	}

}

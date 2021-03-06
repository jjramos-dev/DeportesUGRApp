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

import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import es.ugr.deportesugrapp.Noticias;
import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.client.Global;
import es.ugr.deportesugrapp.reservas.PistaReservable;

/**
 * Activity que carga la lista de pistas disponibles para alquilar
 *
 */
public class ReservasActivity extends ActionBarActivity {

	LinearLayout layout;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reservas);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Reservas");
		// actionBar.setSubtitle("");

		layout = (LinearLayout) findViewById(R.id.fondo);

		SolicitudInfoPistasTask task = new SolicitudInfoPistasTask(
				Global.baseURLServidorNice);
		task.execute("2013");
	}



	/**
	 * Metodo que nos muestra en forma de lista de botones todas las isntalaciones disponibles para su consulta de disponibilidad
	 * @param pistas Variable que contiene la informacion de las pistas
	 */
	void crearBoton(PistaReservable pistas) {

		final String codigoPista = pistas.getCodigo();
		final String nombrePista = pistas.getTitulo();

		Button boton = new Button(this);
		boton.setText(pistas.getTitulo());
		boton.setBackgroundColor(Color.argb(0, 0, 0, 0));
		boton.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.flecha_negro25prueba, 0, 0, 0);
		boton.setBackgroundResource(R.drawable.selector);
		boton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(ReservasActivity.this,
						FechasActivity.class);
				intent.putExtra("com.example.activitydeportes.nombrePista", nombrePista);
				intent.putExtra("com.example.activitydeportes.codigoPista",
						codigoPista);

				// mostrarPistaCodigo(codigoPista);

				startActivity(intent);
			}
		});

		layout.addView(boton);

		View ruler = new View(this);

		ruler.setBackgroundColor(0xFF000000);

		layout.addView

		(ruler, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				2));

	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	public class SolicitudInfoPistasTask extends
			AsyncTask<String, Integer, List<PistaReservable>> {

		String respuesta = "no";
		private ProgressDialog Dialog;
		// Objeto para hacer las peticiones web:
		private DeporteUGRClient api;

		SolicitudInfoPistasTask(String base) {
			api = new DeporteUGRClient();
		}

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(ReservasActivity.this);
			Dialog.setMessage("Cargando pistas...");
			Dialog.show();

		}

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected List<PistaReservable> doInBackground(String... arg0) {
			List<PistaReservable> pistas = null;
			// String codigo=arg0[0];

			pistas = api.obtenerListaPistasReservables();

			return pistas;
		}

		/**
		 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
		 */
		protected void onPostExecute(List<PistaReservable> pistas) {

			if (pistas != null) {

				for (PistaReservable pista : pistas) {
					// Button boton=new Button(actividad);
					//
					// boton.setText(categoria.getTitulo());
					//
					// layout.addView(boton);

					crearBoton(pista);

				}

			} else {
				mostrarError("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo más tarde.");
			}

			Dialog.dismiss();
		}
	}

	/**
	 * Metodo que permite mostrar un mensaje cuando se produce algun error (Conexion o ausencia de equipos registrados)
	 * @param string String que contendra el mensaje a mostrar
	 */
	private void mostrarError(String string) {
		TextView tv = new TextView(this);
		tv.setText(string);
		tv.setTextSize(20);
		tv.setPadding(15, 20, 0, 0);
		layout.addView(tv);
	}

}

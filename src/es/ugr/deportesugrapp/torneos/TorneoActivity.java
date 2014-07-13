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
package es.ugr.deportesugrapp.torneos;

import java.util.List;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.client.Global;
import es.ugr.deportesugrapp.reservas.ReservasActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * Activity que carga la lista de competiciones disponibles
 *
 */
public class TorneoActivity extends ActionBarActivity {

	LinearLayout layout;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_torneo);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Competiciones");
		// actionBar.setSubtitle("");

		layout = (LinearLayout) findViewById(R.id.fondo);

		SolicitudInfoTorneosTask task = new SolicitudInfoTorneosTask(
				Global.baseURLServidorNice);
		task.execute("2013");
	}

	

	/**
	 * Metodo que mostrara en forma de botones las diferentes competiciones disponibles
	 * @param categoria Variable que contiene la informacion de cada competicion
	 */
	void crearBoton(DatosCategoria categoria) {

		final String categoriaId = categoria.getId();

		Button boton = new Button(this);
		boton.setBackgroundColor(Color.argb(0, 0, 0, 0));
		boton.setText(categoria.getTitulo());
		boton.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.flecha_negro25prueba, 0, 0, 0);
		boton.setBackgroundResource(R.drawable.selector);
		boton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(TorneoActivity.this,
						DeportesActivity.class);
				intent.putExtra("com.example.activitydeportes.categoriaId",
						categoriaId);

				// mostrarCategoriaId(categoriaId);

				startActivity(intent);
			}
		});

		layout.addView(boton);

		View ruler = new View(this);

		ruler.setBackgroundColor(0xFF000000);

		layout.addView(ruler, new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT, 2));

	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	public class SolicitudInfoTorneosTask extends
			AsyncTask<String, Integer, List<DatosCategoria>> {

		String respuesta = "no";
		private ProgressDialog Dialog;
		// Objeto para hacer las peticiones web:
		private DeporteUGRClient api;

		SolicitudInfoTorneosTask(String base) {
			api = new DeporteUGRClient();
		}

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(TorneoActivity.this);
			Dialog.setMessage("Cargando torneos...");
			Dialog.show();

		}

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected List<DatosCategoria> doInBackground(String... arg0) {
			List<DatosCategoria> categorias = null;
			String anio = arg0[0];

			categorias = api.obtenerTorneos(anio);

			return categorias;
		}

		/**
		 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
		 */
		protected void onPostExecute(List<DatosCategoria> categorias) {

			if (categorias != null) {

				for (DatosCategoria categoria : categorias) {
					// Button boton=new Button(actividad);
					//
					// boton.setText(categoria.getTitulo());
					//
					// layout.addView(boton);

					crearBoton(categoria);
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

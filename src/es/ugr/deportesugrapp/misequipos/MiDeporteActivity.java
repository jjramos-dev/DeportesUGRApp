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
package es.ugr.deportesugrapp.misequipos;

import java.util.List;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.client.Global;
import es.ugr.deportesugrapp.reservas.ReservasActivity;
import es.ugr.deportesugrapp.torneos.Deporte;
import es.ugr.deportesugrapp.torneos.Equipo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Activity que nos permite elegir el deporte de mi equipo
 *
 */
public class MiDeporteActivity extends ActionBarActivity {

	private LinearLayout layout;
	private String categoriaId;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deportes);

		ActionBar actionBar = getSupportActionBar();

		layout = (LinearLayout) findViewById(R.id.fondo);

		Intent intent = getIntent();
		categoriaId = intent
				.getStringExtra("com.example.activitydeportes.categoriaId");

		actionBar.setTitle("Elegir Mi Deporte");
		actionBar.setSubtitle(categoriaId);

		SolicitudInfoDeportesTask task = new SolicitudInfoDeportesTask(
				Global.baseURLServidorNice);
		task.execute(categoriaId);

	}

	/**
	 * Metodo que carga todos los deportes disponibles  en la competicion previamente seleccionada, 
	 * en forma de boton para que selecciones uno
	 * @param deporte Variable que contiene la informacion del deporte
	 */
	void crearBoton(Deporte deporte) {
		final String deporteId = deporte.getId();

		Button boton = new Button(this);
		boton.setText(deporte.getTitulo());
		boton.setBackgroundColor(Color.argb(0, 0, 0, 0));
		boton.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.flecha_negro25prueba, 0, 0, 0);
		boton.setBackgroundResource(R.drawable.selector);
		boton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Creamos un Intent para llamar a la activity correspondiente:
				Intent intent = new Intent(MiDeporteActivity.this,
						EleccionEquipoActivity.class);
				intent.putExtra("com.example.activitydeportes.categoriaId",
						categoriaId);
				intent.putExtra("com.example.activitydeportes.deporteId",
						deporteId);

				startActivity(intent);

			}
		});

		layout.addView(boton);

		View ruler = new View(this);

		ruler.setBackgroundColor(0xFF000000);

		layout.addView

		(ruler, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				1));
	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	public class SolicitudInfoDeportesTask extends
			AsyncTask<String, Integer, List<Deporte>> {

		String respuesta = "no";
		private ProgressDialog Dialog;
		// Objeto para hacer las peticiones web:
		private DeporteUGRClient api;

		SolicitudInfoDeportesTask(String base) {
			api = new DeporteUGRClient();
		}

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(MiDeporteActivity.this);
			Dialog.setMessage("Cargando deportes...");
			Dialog.show();

		}

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected List<Deporte> doInBackground(String... arg0) {
			List<Deporte> deportes = null;
			String categoriaId = arg0[0];

			deportes = api.obtenerDeportes(categoriaId);

			return deportes;
		}

		/**
		 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
		 */
		protected void onPostExecute(List<Deporte> deportes) {

			

			if (deportes != null) {
				if (!deportes.isEmpty()) {
					for (Deporte deporte : deportes) {
						crearBoton(deporte);

					}
				} else {
					mostrarError("No se definieron deportes para este torneo.");
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
	void mostrarError(String string) {
		TextView tv = new TextView(this);
		tv.setText(string);
		tv.setTextSize(20);
		tv.setPadding(15, 20, 0, 0);
		layout.addView(tv);
	}

}

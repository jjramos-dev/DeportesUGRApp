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

import java.util.Calendar;
import java.util.List;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.client.Global;
import es.ugr.deportesugrapp.reservas.ReservasActivity;
import es.ugr.deportesugrapp.torneos.DatosCategoria;
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

public class MiTorneoActivity extends ActionBarActivity {

	LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_torneo);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Elegir Mi Competición");
		// actionBar.setSubtitle("Competiciones");

		layout = (LinearLayout) findViewById(R.id.fondo);

		SolicitudInfoTorneosTask task = new SolicitudInfoTorneosTask(
				Global.baseURLServidorNice);

		// Averiguamos el año, y solicitamos sólo los torneos definidos para ese
		// año
		// (distingue entre antes de agosto y después):
		Calendar calendar = Calendar.getInstance();
		int anioActual = calendar.get(Calendar.YEAR);
		int mesActual = calendar.get(Calendar.MONTH);
		int curso = anioActual;

		if (mesActual < 8) {
			curso = anioActual - 1;
		}

		task.execute("" + curso);
	}

	/*
	 * private void mostrarCategoriaId(String categoriaId) { TextView texto =
	 * (TextView) findViewById(R.id.texto); texto.setText(categoriaId);
	 * 
	 * }
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
				Intent intent = new Intent(MiTorneoActivity.this,
						MiDeporteActivity.class);
				intent.putExtra("com.example.activitydeportes.categoriaId",
						categoriaId);

				// mostrarCategoriaId(categoriaId);

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

	public class SolicitudInfoTorneosTask extends
			AsyncTask<String, Integer, List<DatosCategoria>> {

		String respuesta = "no";
		private ProgressDialog Dialog;
		// Objeto para hacer las peticiones web:
		private DeporteUGRClient api;

		SolicitudInfoTorneosTask(String base) {
			api = new DeporteUGRClient();
		}

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(MiTorneoActivity.this);
			Dialog.setMessage("Cargando torneos...");
			Dialog.show();

		}

		@Override
		protected List<DatosCategoria> doInBackground(String... arg0) {
			List<DatosCategoria> categorias = null;
			String anio = arg0[0];

			categorias = api.obtenerTorneos(anio);

			return categorias;
		}

		protected void onPostExecute(List<DatosCategoria> categorias) {

			if (categorias != null) {

				for (DatosCategoria categoria : categorias) {
					//
					crearBoton(categoria);
				}

			} else {

				mostrarError("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo más tarde.");
			}

			Dialog.dismiss();
		}
	}

	private void mostrarError(String string) {
		TextView tv = new TextView(this);
		tv.setText(string);
		tv.setTextSize(20);
		tv.setPadding(15, 20, 0, 0);
		layout.addView(tv);
	}

}

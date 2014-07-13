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

import java.util.ArrayList;
import java.util.List;

import es.ugr.deportesugrapp.misequipos.MiTorneoActivity;
import es.ugr.deportesugrapp.torneos.CalendariosActivityMisEquipos;
import es.ugr.deportesugrapp.torneos.DeportesActivity;
import es.ugr.deportesugrapp.torneos.EleccionActivity;
import es.ugr.deportesugrapp.torneos.Equipo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * Activity que muestra la lista de mis equipos seleccionados o nos permite añadir o quitar equipos de la lista
 *
 */
public class MisEquipos extends ActionBarActivity {

	private LinearLayout layout;
	GestorPreferencias gestorPreferencias;
	private SharedPreferences preferencias;
	private int botones;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mis_equipos);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Mis Equipos");
		// actionBar.setSubtitle("");

		gestorPreferencias = new GestorPreferencias(this);

		layout = (LinearLayout) findViewById(R.id.preferencias);

		botones = 0;
		mostrarListadoEquipos(layout);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mostrarListadoEquipos(layout);
	}

	
	/**
	 * Metodo que muestra en el layout la lista de mis equipos, en el cual al pulsar sobre cada uno me redirecciona al calendario de dicho equipo
	 * @param layout2 Variable de tipo LinearLayout para mostrar los resultados
	 */
	private void mostrarListadoEquipos(LinearLayout layout2) {
		List<Equipo> listadoEquipos = gestorPreferencias
				.getListaEquiposEscogidos();

		// Borramos los botones que había antes:
		setContentView(R.layout.mis_equipos);
		layout = (LinearLayout) findViewById(R.id.preferencias);

		if (listadoEquipos != null && !listadoEquipos.isEmpty()) {
			for (final Equipo equipo : listadoEquipos) {
				// TextView tv = new TextView(this);
				// tv.setText(equipo.getNombre());

				Button bt = new Button(this);
				bt.setText(equipo.getNombre());
				bt.setText(Html.fromHtml(equipo.getNombre()
						+ "<br><small><small>"
						+ obtenerAbrevTorneoDeporte(equipo.getUrl())
						+ "</small></small>"));
				bt.setBackgroundColor(Color.argb(0, 0, 0, 0));
				bt.setBackgroundResource(R.drawable.selector);
				bt.setCompoundDrawablesWithIntrinsicBounds(
						R.drawable.flecha_negro25prueba, 0, 0, 0);
				bt.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View arg0) {

						String deporteId = obtenerDeporteId(equipo);
						String categoriaId = obtenerTorneoId(equipo);
						// Creamos un Intent para llamar a la activity
						// correspondiente:
						Intent intent = new Intent(MisEquipos.this,
								CalendariosActivityMisEquipos.class);
						intent.putExtra(
								"com.example.activitydeportes.categoriaId",
								categoriaId);
						intent.putExtra(
								"com.example.activitydeportes.deporteId",
								deporteId);

						startActivity(intent);

					}
				});

				View ruler = new View(this);
				ruler.setBackgroundColor(0xFF000000);

				layout.addView(bt);

				layout.addView(ruler, new ViewGroup.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 1));

			}
		} else {
			mostrarError("No has seleccionado ningún equipo.");
		}
	}

	/**
	 * Metodo que permite mostrar un mensaje cuando se produce algun error (Conexion o ausencia de equipos registrados)
	 * @param string String que contendra el mensaje a mostrar
	 */
	private void mostrarError(String string) {
		TextView tv = new TextView(this);
		tv.setText(string);
		tv.setPadding(15, 20, 0, 0);
		layout.addView(tv);
	}

	/**
	 * Metodo que obtiene el deporte al que pertenece el equipo
	 * @param equipo Variable de la clase Equipo que será el equipo del que queremos obtener el deporte al que pertenece
	 * @return String que devuelve el deporte al que pertenece el equipo en cuestion
	 */
	String obtenerDeporteId(Equipo equipo) {
		String deporte = "";

		if (equipo != null) {
			String url = equipo.getUrl();

			if (url != null && url.compareTo("") != 0) {
				String[] tokens = url.split("/");
				int len = tokens.length;

				// y si termina por "/"?
				deporte = tokens[len - 3];
			}
		}
		return deporte;
	}

	/**
	 * Metodo que obtiene el torneo al que pertenece el equipo
	 * @param equipo Variable de la clase Equipo que será el equipo del que queremos obtener el torneo al que pertenece
	 * @return String que devuelve el torneo al que pertenece el equipo en cuestion
	 */
	String obtenerTorneoId(Equipo equipo) {
		String torneo = "";

		if (equipo != null) {
			String url = equipo.getUrl();

			if (url != null && url.compareTo("") != 0) {
				String[] tokens = url.split("/");
				int len = tokens.length;

				// y si termina por "/"?
				torneo = tokens[len - 4];
			}
		}
		return torneo;
	}

	/**
	 * Metodo que nos permite obtener la abreviatura a mostrar del equipo (Competicion y Deporte) que obtendremos mediante su URL
	 * @param url String a partir del cual obtenemos la abreviatura
	 * @return String que devuelve la abreviatura obtenida
	 */
	private String obtenerAbrevTorneoDeporte(String url) {
		String abrev = "";
		String trofeoId = "";
		String deporteId = "";

		if (url != null && url.compareTo("") != 0) {
			String[] tokens = url.split("/");
			int len = tokens.length;

			// y si termina por "/"?
			trofeoId = tokens[len - 4];
			deporteId = tokens[len - 3];

			abrev = "(" + abreviaId(trofeoId);
			abrev = abrev + " - " + abreviaId(deporteId) + ")";
		}
		return abrev;
	}

	/**
	 * Metodo que permite obtener por separado el deporte y la competicion a la que pertenece el equipo
	 * @param trofeoId String que hay que obtener (competicion o deporte)
	 * @return String que devuelve la informacion obtenida
	 */
	private String abreviaId(String trofeoId) {
		String abrev = "";
		String[] tokens = trofeoId.split("-");

		for (String palabra : tokens) {
			String mini = palabra.substring(1);
			if (mini == null) {
				mini = "";
			}
			abrev = abrev + ("" + palabra.charAt(0)).toUpperCase() + mini + " ";
		}

		return abrev;
	}

	/**
	 * Metodo que al pulsar el boton nos abre una nueva activity donde elegiremos el torneo al que pertenece mi equipo
	 * @param v
	 */
	public void onClickAgregarEquipo(View v) {
		Intent misEquiposIntent = new Intent(this, MiTorneoActivity.class);
		startActivity(misEquiposIntent);
	}

}

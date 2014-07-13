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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import es.ugr.deportesugrapp.GestorPreferencias;
import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.client.Global;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Activity que muestra los calendarios de mis equipos
 *
 */
public class CalendariosActivityMisEquipos extends ActionBarActivity {

	private LinearLayout layout;
	private GestorPreferencias gestorPreferencias;
	List<Equipo> listaElegidos;
	private String categoriaId;
	private String deporteId;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// En realidad, casi todas las activities son iguales (de momento) :)
		setContentView(R.layout.activity_calendarios);

		ActionBar actionBar = getSupportActionBar();

		// Guardamos el layout del fondo, para aniadir luego botones o lo que
		// corresponda:
		layout = (LinearLayout) findViewById(R.id.fondo);

		// Extraemos los parámetros de la llamada del intent:
		Intent intent = getIntent();
		categoriaId = intent
				.getStringExtra("com.example.activitydeportes.categoriaId");
		deporteId = intent
				.getStringExtra("com.example.activitydeportes.deporteId");

		actionBar.setTitle("Competiciones");
		actionBar.setSubtitle("Mi Calendario: " + categoriaId + " / "
				+ deporteId);

		gestorPreferencias = new GestorPreferencias(this);
		listaElegidos = gestorPreferencias.getListaEquiposEscogidos();

		// Creamos el AsyncTask que pide los datos mediante el servicio Web:
		// Le pasamos la URL base:
		SolicitudCalendariosTask task = new SolicitudCalendariosTask(
				Global.baseURLServidorNice);
		task.execute(categoriaId, deporteId);

	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	public class SolicitudCalendariosTask extends
			AsyncTask<String, Integer, List<Fase>> {

		private ProgressDialog Dialog;
		String respuesta = "no";

		// Objeto para hacer las peticiones web:
		private DeporteUGRClient api;

		// En el constructor creamos un objeto de la clase CadApi. Si fuera
		// posible, deberíamos pasarla como
		// argumento entre activities, quizás...
		/**
		 * Constructor con argumentos
		 * @param base 
		 */
		SolicitudCalendariosTask(String base) {
			// Objeto para hacer las solicitudes web.
			api = new DeporteUGRClient();
		}

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(CalendariosActivityMisEquipos.this);
			Dialog.setMessage("Cargando calendario...");
			Dialog.show();

		}

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected List<Fase> doInBackground(String... arg0) {
			List<Fase> fases = null;

			// Obtenemos los parámetros pasados como argumentos al lanzar la
			// tarea:
			String categoriaId = arg0[0];
			String deporteId = arg0[1];

			// Lanzamos la petición desde la API:
			fases = api.obtenerFases(categoriaId, deporteId);

			return fases;
		}

		
		// Es el método desde el que se puede cambiar cosas de la UI con
		// garantías.
		/**
		 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
		 */
		protected void onPostExecute(List<Fase> fases) {

			if (fases != null) {

				if (!fases.isEmpty()) {
					// Recorremos la lista de fases, y creamos un botón por cada
					// fase:
					for (Fase fase : fases) {
						crearBoton(fase);
					}

				} else {
					// Si no existe ninguna fase, se indica:
					mostrarError("No se han definido fases.");
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

	// Método de la Activity para aniadir más botones, por cada fase. Quizás
	// podría
	// hacerse más elegante, o con más activities... pero como mínimo, demos
	// toda la info en esta Activity:
	/**
	 * Metodo que muestra el calendario de partidos de mis equipos seleccionados en 'Mis Equipos' 
	 * @param fase Variable que contiene la informacion de las fases del calendario
	 */
	void crearBoton(Fase fase) {

		// Para comparar rápidamente los equipos:
		HashMap mapaEquipos = new HashMap<String, Equipo>();
		for (Equipo equipo : listaElegidos) {
			// Si son de este torneo y deporte (por defecto sí):
			if (equipo.getUrl().contains(categoriaId + "/" + deporteId))
				mapaEquipos.put(equipo.getUrl(), equipo);
		}

		// Creamos un TextView por cada entrada... Lo suyo será hacerlo con
		// listasa expandibles:
		// http://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/

		TextView tv = new TextView(this);
		tv.setText(Html.fromHtml(fase.getTitulo()));
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(35);
		tv.setTypeface(null, Typeface.BOLD);
		tv.setPadding(0, 30, 0, 30);
		layout.addView(tv);

		// vamos a recuperar todos los partidos que nos interesen:
		// Calculamos mis partidos:
		List<Partido> listaMisPartidos = new ArrayList<Partido>();
		for (Ronda ronda : fase.getRondas()) {

			// Buscamos nuestros partidos:
			for (Partido partido : ronda.getPartidos()) {
				Equipo equipo1 = partido.getEquipo1();
				Equipo equipo2 = partido.getEquipo2();
				boolean equipo1Presente = false, equipo2Presente = false;

				if (mapaEquipos.containsKey(equipo1.getUrl())) {
					equipo1Presente = true;
				}
				if (mapaEquipos.containsKey(equipo2.getUrl())) {
					equipo2Presente = true;
				}

				if (equipo1Presente || equipo2Presente) {
					listaMisPartidos.add(partido);
				}
			}
		}

		// Si hay partidos, los ordenamos y mostramos:
		if (!listaMisPartidos.isEmpty()) {
			// Ordenamos los partidos por fechas:
			Collections.sort(listaMisPartidos, new Comparator<Partido>() {
				@Override
				public int compare(Partido p1, Partido p2) {
					int comparacion = 0;
					Date f1 = p1.getFecha();
					Date f2 = p2.getFecha();

					if (f1 != null && f2 != null) {
						comparacion = f2.compareTo(f1);
					}

					return comparacion;
				}
			});

			// Si ha pasado el partido, lo mostramos en gris:
			Date hoy = Calendar.getInstance().getTime();
			for (Partido partido : listaMisPartidos) {
				boolean disputado = false;
				String resultado = "";

				// Mostramos la lista de partidos:
				Date fechaPartido = partido.getFecha();
				if (fechaPartido == null || hoy.after(fechaPartido)) {
					disputado = false;

					if (esNumero(partido.getResultadoEquipo1())
							&& esNumero(partido.getResultadoEquipo2())) {
						resultado = partido.getResultadoEquipo1() + " - "
								+ partido.getResultadoEquipo2();
						disputado = true;
					}
				}

				// Identificamos contra quién jugamos:
				Equipo equipoAdversario = null;
				Equipo miEquipo = null;
				String miResultado = "";
				String suResultado = "";
				Spanned html;

				if (mapaEquipos.containsKey(partido.getEquipo1().getUrl())) {
					equipoAdversario = partido.getEquipo2();
					miEquipo = partido.getEquipo1();

					if (disputado) {
						miResultado = partido.getResultadoEquipo1().trim();
						suResultado = partido.getResultadoEquipo2().trim();
					}
				} else {
					equipoAdversario = partido.getEquipo1();
					miEquipo = partido.getEquipo2();

					if (disputado) {
						miResultado = partido.getResultadoEquipo2().trim();
						suResultado = partido.getResultadoEquipo1().trim();
					}
				}

				html = Html.fromHtml(((disputado) ? "<font color=\"Gray\">"
						: "")
						+ "<b><big>Tu equipo: </b></big>"
						+ "<b>"
						+ miEquipo.getNombre()
						+ ""

						+ " - "
						+ ((disputado) ? miResultado : "")
						+ "</b>"
						+ "<br/>"
						+ "<b><big>Adversario: "
						+ "</b></big>"
						+ "<b>"

						+ equipoAdversario.getNombre()
						+ " - "
						+ ((disputado) ? suResultado : "")
						+ "</b>"
						+ "<br/>"
						+ "<b><big>Fecha: </b></big>"
						+ ((partido.getFechaString() != null) ? partido
								.getFechaString() : "")
						+ ((partido.getHoraString() != null) ? (", " + partido
								.getHoraString()) : "")
						+ "<br/>"
						+ "<b><big>Lugar: </b></big>" + partido.getLugar());

				TextView partidoTexto = new TextView(this);
				partidoTexto.setPadding(15, 20, 15, 20);

				partidoTexto.setText(html);
				layout.addView(partidoTexto);

				View ruler = new View(this);

				ruler.setBackgroundColor(0xFF000000);
				layout.addView(ruler, new ViewGroup.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 2));
			}
		} else {
			Spanned html = Html.fromHtml("<br><b>"
					+ "Su equipo no juega partidos en esta etapa." + "</b>"
					+ "<br/>");

			TextView partidoTexto = new TextView(this);
			partidoTexto.setPadding(15, 20, 15, 20);

			partidoTexto.setText(html);
			layout.addView(partidoTexto);

			View ruler = new View(this);

			ruler.setBackgroundColor(0xFF000000);
			layout.addView(ruler, new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 2));

		}
	}

	/**
	 * Metodo que permite comprobar si se ha jugado un partido
	 * @param resultadoEquipo1 Variable para comprobar si el resultado es un numero, y por tanto se ha disputado
	 * @return Devuelve si es un numero o no
	 */
	private boolean esNumero(String resultadoEquipo1) {
		boolean esNum = false;

		if (resultadoEquipo1 != null) {
			try {
				Integer.parseInt(resultadoEquipo1.trim());
				esNum = true;
			} catch (NumberFormatException ex) {
				esNum = false;
			}
		}
		return esNum;
	}
}

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
 * Activity que muestra el calendario de para la competicion y deporte seleccionado
 *
 */
public class CalendariosActivity extends ActionBarActivity {

	private LinearLayout layout;
	private GestorPreferencias gestorPreferencias;
	private List<Equipo> listaElegidos;
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
		actionBar.setSubtitle("Calendario: " + categoriaId + " / " + deporteId);

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
		SolicitudCalendariosTask(String base) {
			// Objeto para hacer las solicitudes web.
			api = new DeporteUGRClient();
		}

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(CalendariosActivity.this);
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
	 * Metodo que muestra el calendario de partidos para la competicion y el deporte seleccionado. Tambien se mostrara en rojo los 
	 * equipos que esten en 'Mis equipos'
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


		TextView tv = new TextView(this);
		tv.setText(Html.fromHtml(fase.getTitulo()));
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(35);
		tv.setTypeface(null, Typeface.BOLD);
		tv.setPadding(0, 30, 0, 30);
		layout.addView(tv);

		// Por cada ronda, aniadimos otra entrada, y los partidos
		// correspondientes:
		for (Ronda ronda : fase.getRondas()) {
			// Título de la ronda:
			TextView rondaTexto = new TextView(this);

			rondaTexto.setTextSize(27);
			rondaTexto.setTypeface(null, Typeface.BOLD);
			rondaTexto.setPadding(15, 20, 0, 20);
			rondaTexto.setText(Html.fromHtml(ronda.getTitulo()));
			layout.addView(rondaTexto);

			List<Partido> listaPartidos = ronda.getPartidos();

			// Si hay partidos, los ordenamos y mostramos:
			if (listaPartidos != null) {
				if (!listaPartidos.isEmpty()) {

					// Ordenamos los partidos por fechas:
					Collections.sort(listaPartidos, new Comparator<Partido>() {
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

					// Mostramos cada partido:
					for (Partido partido : listaPartidos) {
						Equipo equipo1 = partido.getEquipo1();
						Equipo equipo2 = partido.getEquipo2();
						boolean equipo1Presente = false, equipo2Presente = false;

						if (mapaEquipos.containsKey(equipo1.getUrl())) {
							equipo1Presente = true;
						}
						if (mapaEquipos.containsKey(equipo2.getUrl())) {
							equipo2Presente = true;
						}

						TextView partidoTexto = new TextView(this);

						partidoTexto.setPadding(15, 20, 15, 20);
						Spanned html = Html
								.fromHtml(

								"<b><big>"
										+ ((equipo1Presente) ? "<font color=\"#990000\">"
												: "")
										+ partido.getEquipo1().getNombre()
										+ ((equipo1Presente) ? "</font>" : "")
										+ "</big></b>"
										+ "<b>"
										+

										" vs "
										+ "</b>"

										+ "<b><big>"
										+ ((equipo2Presente) ? "<font color=\"#990000\">"
												: "")
										+ partido.getEquipo2().getNombre()
										+ ((equipo2Presente) ? "</font>" : "")
										+

										"</big></b>"
										+ "  "
										+ ((partido.getResultadoEquipo1() == null) ? ("<i>"
												+ partido.getEstado() + "</i> ")
												: (" ("
														+ partido
																.getResultadoEquipo1()
														+ "-"
														+ partido
																.getResultadoEquipo2() + ") "))
										+ "<br/>" + partido.getLugar()
										+ " <br/> " + partido.getFechaString()
										+ ", " + partido.getHoraString() + " ");

						partidoTexto.setText(html);
						layout.addView(partidoTexto);

						View ruler = new View(this);
						ruler.setBackgroundColor(0xFF000000);
						// ruler.setPadding(0, 0, 0, 20);

						layout.addView(ruler, new ViewGroup.LayoutParams(
								ViewGroup.LayoutParams.MATCH_PARENT, 2));

					}
				}
			}
		}

	}
}

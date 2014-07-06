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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.ugr.deportesugrapp.GestorPreferencias;
import es.ugr.deportesugrapp.MisEquipos;
import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.torneos.EleccionActivity;
import es.ugr.deportesugrapp.torneos.Equipo;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.Build;
import android.preference.PreferenceManager;

public class EleccionEquipoActivity extends ActionBarActivity {
	private DeporteUGRClient deporteUGRApi;
	LinearLayout layout;
	List<Equipo> listaEquipos;
	List<Equipo> listaElegidos;
	private TextView elegidos;
	private Button btnGuardar;
	private SharedPreferences preferencias;
	private GestorPreferencias gestorPreferencias;
	private HashMap<String, Equipo> mapaElegidos;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eleccion_misequipos);
		ActionBar actionBar = getSupportActionBar();
		String deporteId;
		String categoriaId;
		Intent intent = getIntent();
		categoriaId = intent
				.getStringExtra("com.example.activitydeportes.categoriaId");
		deporteId = intent
				.getStringExtra("com.example.activitydeportes.deporteId");
		actionBar.setTitle("Elegir Mi Equipo");
		actionBar.setSubtitle(categoriaId + " / " + deporteId);

		// Obtenemos referencias a cada elemento de la activity
		layout = (LinearLayout) findViewById(R.id.layout);
		elegidos = (TextView) findViewById(R.id.equiposRegistrados);
		
		gestorPreferencias = new GestorPreferencias(this);

		// Creamos un objeto de ayuda para realizar la llamada:
		deporteUGRApi = new DeporteUGRClient();
		
	
		cargarListaElegidos();
		
		// Cargamos la página mediante un asynctask:
		new CargadorEquipos(this, deporteUGRApi)
				.execute(categoriaId, deporteId);
	}

	public class CargadorEquipos extends
			AsyncTask<String, Integer, List<Equipo>> {

		private EleccionEquipoActivity padre;
		private DeporteUGRClient deporteUGRApi;
		private ProgressDialog Dialog;

		public CargadorEquipos(EleccionEquipoActivity actividadVistaWeb,
				DeporteUGRClient deporteUGRApi) {
			padre = actividadVistaWeb;
			this.deporteUGRApi = deporteUGRApi;
		}

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(padre);
			Dialog.setMessage("Cargando equipos...");
			Dialog.show();

		}

		@Override
		protected List<Equipo> doInBackground(String... params) {
			List<Equipo> listaEquipos = null;

			listaEquipos = deporteUGRApi.obtenerEquipo(params[0], params[1]);

			return listaEquipos;
		}

		@SuppressWarnings("unused")
		protected void onPostExecute(List<Equipo> listaEquipos) {
			// padre.cargarPaginaWeb("Downloaded " + tabla.length() + " bytes");

			if (listaEquipos != null) {
				if (!listaEquipos.isEmpty()) {
					cargarEquipos(listaEquipos);
				} else {
					mostrarError("No hay equipos inscritos.");
				}
			} else {

				mostrarError("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo más tarde.");

			}

			Dialog.dismiss();
		}

	}
	
	
	
	private List<Equipo> cargarListaElegidos() {
		// Los cargamos de las preferencias:
		List<Equipo> listaGuardada = gestorPreferencias.getListaEquiposEscogidos();
		mapaElegidos=new HashMap<String,Equipo>();
		
		// Copiamos su infomación:
		if (listaGuardada != null){
			for(Equipo equipo:listaGuardada){
				mapaElegidos.put(equipo.getUrl(), equipo);
			}
		}
		
		return null;
	}

	public void cargarEquipos(List<Equipo> listaEquipos) {

		// Si hay alguna lista:
		//if (listaEquipos.isEmpty()) {
			
				// mostramos los botones:
				for (final Equipo equipo : listaEquipos) {

					final ToggleButton boton = new ToggleButton(this);
					boton.setText(equipo.getNombre());

					boton.setBackgroundColor(Color.argb(0, 0, 0, 0));
					boton.setBackgroundResource(R.drawable.selector);
					boton.setTextOn(equipo.getNombre());
					boton.setTextOff(equipo.getNombre());


					boton.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							if (boton.isChecked()) {
								boton.setCompoundDrawablesWithIntrinsicBounds(
										R.drawable.flecha_negro25prueba, 0, 0,
										0);
							} else {
								boton.setCompoundDrawablesWithIntrinsicBounds(
										0, 0, 0, 0);
							}

							actualizarListaElegidos(equipo);
						}
					});
					
					// Si lo tenemos en la lista de elegidos, además 
					// marcamos con el icono o no...
//					for (Equipo equipoEle : listaElegidos) {
//						if (equipo.getNombre().compareTo(equipoEle.getNombre()) == 0) {
//							boton.setCompoundDrawablesWithIntrinsicBounds(
//									R.drawable.flecha_negro25prueba, 0, 0, 0);
//							boton.setChecked(true);
//						}
//					}
					if(mapaElegidos.get(equipo.getUrl())!=null){
						boton.setCompoundDrawablesWithIntrinsicBounds(
									R.drawable.flecha_negro25prueba, 0, 0, 0);
							boton.setChecked(true);
					}

				
					layout.addView(boton);
					View ruler = new View(this);
					ruler.setBackgroundColor(0xFF000000);
					layout.addView(ruler, new ViewGroup.LayoutParams(
							ViewGroup.LayoutParams.FILL_PARENT, 1));

				}
			//} else {
			//	mostrarError("Este deporte no contiene equipos registrados");
		
			//}
	}

	private void mostrarError(String string) {
		// TODO Auto-generated method stub
		TextView textoError = (TextView) findViewById(R.id.equiposRegistrados);
		textoError.setText(string);
		textoError.setTextSize(20);
		textoError.setPadding(15, 20, 0, 0);
		
	}

	public void actualizarListaElegidos(Equipo equipo) {
		String cadena = "";
		
		System.out.println("Actualizando equipo "+equipo.getUrl());
		// Si ya estaba en la lista, lo eliminamos:
		Equipo equipo_=mapaElegidos.get(equipo.getUrl());
		if(equipo_!=null){
				mapaElegidos.remove(equipo.getUrl());
		} else  {
			// O lo añadimos a la lista de elegidos....
			mapaElegidos.put(equipo.getUrl(),equipo);
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		// Lo pasamos a lista, y lo guardamos:
		listaElegidos=new ArrayList<Equipo>();
		for(Equipo equipo:mapaElegidos.values()){
			listaElegidos.add(equipo);
		}
		
		gestorPreferencias.guardarMisEquipos(listaElegidos);
	}
}
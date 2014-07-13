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

import java.util.List;

import org.json.JSONObject;

import es.ugr.deportesugrapp.noticias.LeerNoticia;
import es.ugr.deportesugrapp.noticias.NoticiasEstructura;
import es.ugr.deportesugrapp.noticias.ListAdapter;
import es.ugr.deportesugrapp.noticias.Handler;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity que carga la lista de noticias
 *
 */
public class Noticias extends ActionBarActivity {
	

	ListView listView;
	//List<JSONObject> jobs;
	List<NoticiasEstructura> notStruc;
	private ListAdapter adaptador;
	private LinearLayout layout;

	
	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_noticias);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Noticias");
		// actionBar.setSubtitle("");

		listView = (ListView) findViewById(R.id.listview1);
		layout = (LinearLayout) findViewById(R.id.fondo);

		NoticiasTask notTask = new NoticiasTask();
		notTask.execute();
	}

	/**
	 * 
	 * Clase que permite ejecutar una tarea en segundo plano
	 *
	 */
	private class NoticiasTask extends AsyncTask<String, Void, List<NoticiasEstructura>> {
		
		private ProgressDialog Dialog;
		

		/**
		 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
		 */
		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(Noticias.this);
			Dialog.setMessage("Cargando noticias...");
			Dialog.show();

		}

		/**
		 * Metodo que ejecuta la tarea en segundo plano
		 */
		@Override
		protected List<NoticiasEstructura> doInBackground(String... urls) {
			try {
				

				String url = "http://cad.ugr.es/pages/tablon/*/rss";
				Handler hand = new Handler();
				notStruc = hand.obtenerNoticias(url);
			} catch (Exception e) {
			}

			return null;

		}

		/**
		 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
		 */
		@Override
		protected void onPostExecute(List<NoticiasEstructura> result) {

			if (notStruc != null && !notStruc.isEmpty()) {
				adaptador = new ListAdapter(Noticias.this, notStruc);
				listView.setAdapter(adaptador);
				
				listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> parent, View listItemView, int pos, long idOfItem) {
								

								listItemView.setBackgroundResource(R.drawable.selector);
								Intent intent = new Intent(Noticias.this, LeerNoticia.class);
								String linkNot = notStruc.get(pos).getLink();
								intent.putExtra("linkNoticias", linkNot);

								startActivity(intent);

								
							}
						});
				

			} else {

				mostrarError("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo mas tarde.");

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
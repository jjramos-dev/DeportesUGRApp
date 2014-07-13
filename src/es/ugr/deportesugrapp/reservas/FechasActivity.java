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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.torneos.DeportesActivity;
import es.ugr.deportesugrapp.torneos.EleccionActivity;

/**
 * Activity que muestra un calendario para elegir la fecha deseada
 *
 */
public class FechasActivity extends ActionBarActivity {

	String codigoPista;
	String nombrePista;

	LinearLayout layout;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fechas);

		ActionBar actionBar = getSupportActionBar();

		// Extraemos los parámetros de la llamada del intent:
		Intent intent = getIntent();
		
		nombrePista = intent
				.getStringExtra("com.example.activitydeportes.nombrePista");
		codigoPista = intent
				.getStringExtra("com.example.activitydeportes.codigoPista");

		actionBar.setTitle("Reservas");
		actionBar.setSubtitle(nombrePista);

		final CalendarView calendario;

		calendario = (CalendarView) findViewById(R.id.calendarView);

		calendario.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int anio,
					int mes, int dia) {

				mes = mes + 1;

				
				String dia2 = String.format("%02d", dia);
				String mes2 = String.format("%02d", mes);

				Toast.makeText(
						getApplicationContext(),
						"Has seleccionado el dia: " + dia2 + "/" + mes2 + "/"
								+ anio, 0).show();

				Intent intent = new Intent(FechasActivity.this,
						DisponibilidadActivity.class);
				intent.putExtra("com.example.activitydeportes.anio", anio);
				intent.putExtra("com.example.activitydeportes.mes2", mes2);
				intent.putExtra("com.example.activitydeportes.dia2", dia2);
				intent.putExtra("com.example.activitydeportes.codigoPista",
						codigoPista);
				intent.putExtra("com.example.activitydeportes.nombrePista",
						nombrePista);

				startActivity(intent);

			}
		});
	}
}

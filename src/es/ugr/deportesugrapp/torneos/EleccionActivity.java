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

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.torneos.CalendariosActivity.SolicitudCalendariosTask;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;

public class EleccionActivity extends ActionBarActivity{
	
	
	String categoriaId;
	String deporteId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// En realidad, casi todas las activities son iguales (de momento) :)
		setContentView(R.layout.elegir_cal_o_clas);
		
		ActionBar actionBar = getSupportActionBar();
		
		

		// Extraemos los parámetros de la llamada del intent:
		Intent intent = getIntent();
		categoriaId = intent
				.getStringExtra("com.example.activitydeportes.categoriaId");
		deporteId = intent
				.getStringExtra("com.example.activitydeportes.deporteId");

		
		actionBar.setTitle("Competiciones");
		actionBar.setSubtitle(categoriaId+" / "+deporteId);
		
		
	}
	

	
	public void onClickCalendario(View arg0) {
		// Creamos un Intent para llamar a la activity correspondiente:
		Intent intent=new Intent(EleccionActivity.this,CalendariosActivity.class);
		intent.putExtra("com.example.activitydeportes.categoriaId", categoriaId);
		intent.putExtra("com.example.activitydeportes.deporteId", deporteId);
		
		startActivity(intent);

	};
	
	
	public void onClickCalendarioMisEquipos(View arg0) {
		// Creamos un Intent para llamar a la activity correspondiente:
		Intent intent=new Intent(EleccionActivity.this,CalendariosActivityMisEquipos.class);
		intent.putExtra("com.example.activitydeportes.categoriaId", categoriaId);
		intent.putExtra("com.example.activitydeportes.deporteId", deporteId);
		
		startActivity(intent);

	};
	
	
	
	public void onClickClasificacion(View arg0) {
		// Creamos un Intent para llamar a la activity correspondiente:
		Intent intent=new Intent(EleccionActivity.this,ClasificacionActivity.class);
		intent.putExtra("com.example.activitydeportes.categoriaId", categoriaId);
		intent.putExtra("com.example.activitydeportes.deporteId", deporteId);
		
		startActivity(intent);

	};
	
	
	
	
	

}

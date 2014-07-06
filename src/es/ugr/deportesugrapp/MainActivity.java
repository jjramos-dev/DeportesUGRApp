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

import es.ugr.deportesugrapp.reservas.ReservasActivity;
import es.ugr.deportesugrapp.torneos.TorneoActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Actividad principal. Esta actividad se puede cambiar completamente.
 * Sólo es obligatorio enlazar de alguna manera con la actividad "AboutActivity"
 * @author Namir Sayed-Ahmad Baraza
 * @mail namirsab@gmail.com
 */

public class MainActivity extends ActionBarActivity {
	
	Button botonAcercaDe;
	Button botonCampeonatos;
	Button botonNoticias;
	Button botonInstalaciones;
	Button botonInfo;
	Button botonMisEquipos;
	Button botonReservas;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getSupportActionBar();
		
		actionBar.setTitle("DeportesUGR");
		//actionBar.setSubtitle("");
		
		
	}
	
    
	
	public void onClickAcercaDe(View v){
		Intent acercaDeIntent = new Intent(this, AboutActivity.class);
		startActivity(acercaDeIntent);
	}

	
	public void onClickCompeticiones(View v){
		Intent torneosIntent = new Intent(this, TorneoActivity.class);
		startActivity(torneosIntent);
	} 
	
	public void onClickNoticias(View v){
		Intent noticiasIntent = new Intent(this, Noticias.class);
		startActivity(noticiasIntent);
	}
	
	public void onClickInstalaciones(View v){
		Intent instalacionesIntent = new Intent(this, Instalaciones.class);
		startActivity(instalacionesIntent);
	}
	
	public void onClickInfo(View v){
		Intent infoIntent = new Intent(this, InfoContacto.class);
		startActivity(infoIntent);
	}
	
	public void onClickMisEquipos(View v){
		Intent perfilIntent = new Intent(this, MisEquipos.class);
		startActivity(perfilIntent);
	}
	
	public void onClickReservas(View v){
		Intent reservasIntent = new Intent(this, ReservasActivity.class);
		startActivity(reservasIntent);
	}
	
	
}

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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;

public class InfoContacto extends ActionBarActivity {

	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String TEL_FUENTENUEVA1 = "958240956";

	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String TEL_FUENTENUEVA2 = "958243144";

	// TODO:Sustituya el email del promotor. Para a�adir mas promotores (si los
	// hay) siga el esquema definido
	private final String TEL_CARTUJA = "958242892";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_contacto);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Información de Contacto");
		// actionBar.setSubtitle("");

	}

	// Acción al pulsar el botón de contacto de la oficina de fuentenueva.
	// Realiza la llamada
	public void onClickBotonContactoFuentenueva(View v) {
		Intent llamarFuentenueva = new Intent(Intent.ACTION_DIAL,
				Uri.parse("tel:" + TEL_FUENTENUEVA1));
		startActivity(llamarFuentenueva);
	}

	// Acción al pulsar el botón de contacto de la oficina de fuentenueva.
	// Realiza la llamada
	public void onClickBotonContactoFuentenueva2(View v) {
		Intent llamarFuentenueva = new Intent(Intent.ACTION_DIAL,
				Uri.parse("tel:" + TEL_FUENTENUEVA2));
		startActivity(llamarFuentenueva);
	}

	// Acción al pulsar el botón de contacto de la oficina de fuentenueva.
	// Realiza la llamada
	public void onClickBotonMapFuentenueva(View v) {
		Intent mapFuentenueva = new Intent(this, MapsFuentenueva.class);
		startActivity(mapFuentenueva);
	}

	// Acción al pulsar el botón de contacto de la oficina de cartuja. Realiza
	// la llamada
	public void onClickBotonContactoCartuja(View v) {
		Intent llamarCartuja = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
				+ TEL_CARTUJA));
		startActivity(llamarCartuja);
	}

	// Acción al pulsar el botón de contacto de la oficina de fuentenueva.
	// Realiza la llamada
	public void onClickBotonMapCartuja(View v) {
		Intent mapCartuja = new Intent(this, MapsCartuja.class);
		startActivity(mapCartuja);
	}

}

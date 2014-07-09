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
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * Clase inicial puramente estetica. Muestra un splash durante 2 segundos
 * 
 * @author Namir Sayed-Ahmad Baraza
 * @mail namirsab@gmail.com
 * 
 */
public class SplashActivity extends Activity {
	// Tiempo de splash en milisegundos
	private int splashTime = 2000;

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		setContentView(R.layout.splash);
		getApplicationContext();
		new Handler().postDelayed(new Runnable() {
			public void run() {
				/* Pasados los dos segundos inicia la activity "activityApp" */
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				/* Destruye esta */
				finish();
			};

		}, splashTime);

	}

}

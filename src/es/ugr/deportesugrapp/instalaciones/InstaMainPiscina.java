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
package es.ugr.deportesugrapp.instalaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ugr.deportesugrapp.MainActivity;
import es.ugr.deportesugrapp.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

public class InstaMainPiscina extends ActionBarActivity {
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_piscina);
		
		ActionBar actionBar = getSupportActionBar();
		
		actionBar.setTitle("Instalaciones");
		actionBar.setSubtitle("Piscina Olímpica");

		
		// Las funciones de red hay que lanzarlas en backgronud:
		int progreso=0;
		
		new SolicitudInfoPistaTask().execute(8);
		
		
	}
	
	
	public void onClickMasInfoPiscina(View v){
		String url = "http://cad.ugr.es/pages/piscina";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
	

// Mirar : http://developer.android.com/reference/android/os/AsyncTask.html
//										Parámetros, unidades de progreso, resultado
public class SolicitudInfoPistaTask extends AsyncTask<Integer, Integer, Piscina>{
	Piscina pista=null;
	String respuesta="no";
	private ProgressDialog Dialog;
	
	@Override
	protected void onPreExecute() {
		Dialog = new ProgressDialog(InstaMainPiscina.this);
		Dialog.setMessage("Cargando información...");
		Dialog.show();
	
	}
	
	
@Override
protected Piscina doInBackground(Integer... params) {
	
	int pistaId=params[0];
	//float precio=params[0];
	//int numero=params[0];
	
	// Hay que formar la dirección del recurso del servicio:
	String url="http://oberon.ugr.es:8080/pista/"+pistaId;
	
	try {
		// Hacemos una petición HTTP GET... Esto sólo sirve para cosultar! de momento no modificamos nada:
		URL servicio = new URL(url);
	   URLConnection conexion = servicio.openConnection();
	   BufferedReader in = new BufferedReader(new InputStreamReader(
                                conexion.getInputStream()));
    
	   // Recibimos la respuesta línea a línea (el JSON):
    respuesta="";
    String inputLine;
    
    while ((inputLine = in.readLine()) != null){        
    	// System.out.println(inputLine);
    	respuesta=respuesta+inputLine;        
    }
    in.close();
    
    // Intentamos interpertarlo con jackson:
    ObjectMapper mapper=new ObjectMapper(); 
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    pista=mapper.readValue(respuesta, Piscina.class);
   
    
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pista;
}

@Override
		protected void onPostExecute(Piscina pista2) {
			// TODO Auto-generated method stub
			super.onPostExecute(pista);
			
			TextView nombrePista=(TextView)findViewById(R.id.nombrePista);
			TextView libreUni=(TextView)findViewById(R.id.precioLibreUni);
			TextView libreNoUni=(TextView)findViewById(R.id.precioLibreNoUni);
			TextView adultoDiarioUni=(TextView)findViewById(R.id.precioAdultosDiarioUni);
			TextView adultoDiarioNoUni=(TextView)findViewById(R.id.precioAdultoDiarioNoUni);
			TextView adultoFindeUni=(TextView)findViewById(R.id.precioAdultosFindeUni);
			TextView adultoFindeNoUni=(TextView)findViewById(R.id.precioAdultosFindeNoUni);
			TextView niniosJubDiarioUni=(TextView)findViewById(R.id.precioNiniosJubDiarioUni);
			TextView niniosJubDiarioNoUni=(TextView)findViewById(R.id.precioNiniosJubDiarioNoUni);
			TextView niniosJubFindesUni=(TextView)findViewById(R.id.precioNiniosJubFindesUni);
			TextView niniosJubFindesNoUni=(TextView)findViewById(R.id.precioNiniosJubFindesNoUni);
			
			
			if(pista!=null){
				
				
				//nombrePista.setText("Pista Pabellones Cubiertos");
				
				libreUni.setText(pista.getPrecioLibreUni());
				libreNoUni.setText(pista.getPrecioLibreNoUni());
				adultoDiarioUni.setText(pista.getPrecioAdultosDiarioUni());
				adultoDiarioNoUni.setText(pista.getPrecioAdultosDiarioNoUni());
				adultoFindeUni.setText(pista.getPrecioAdultosFindeUni());
				adultoFindeNoUni.setText(pista.getPrecioAdultosFindeNoUni());
				niniosJubDiarioUni.setText(pista.getPrecioNiniosJubDiarioUni());
				niniosJubDiarioNoUni.setText(pista.getPrecioNiniosJubDiarioNoUni());
				niniosJubFindesUni.setText(pista.getPrecioNiniosJubFindeUni());
				niniosJubFindesNoUni.setText(pista.getPrecioNiniosJubFindeNoUni());
				
				 
			} else {
				nombrePista.setTextSize(20);
				nombrePista.setPadding(15, 20, 0, 0);
				nombrePista.setText("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo más tarde.");
			}
			
			Dialog.dismiss();
		}
}

}

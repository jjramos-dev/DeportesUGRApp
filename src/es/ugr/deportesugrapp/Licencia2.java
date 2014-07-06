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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class Licencia2 extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_licencia2);
		
		ActionBar actionBar = getSupportActionBar();
		
		
		TextView tv;
		
		tv = (TextView) findViewById(R.id.tvLicencia2);
		tv.setText(readText());
		
		
		actionBar.setTitle("Licencia Jsoup");
		//actionBar.setSubtitle("");
	
	}
	
private String readText(){
		
		InputStream inputStream = getResources().openRawResource(R.raw.licencia_2);
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		int i;
		try{
			
			i = inputStream.read();
			
			while (i != -1){
				byteArrayOutputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return byteArrayOutputStream.toString();
	}
	
	
}

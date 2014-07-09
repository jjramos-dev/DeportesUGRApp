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
package es.ugr.deportesugrapp.noticias;

import es.ugr.deportesugrapp.R;
import es.ugr.deportesugrapp.client.DeporteUGRClient;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Build;

public class LeerNoticia extends ActionBarActivity {

	private TextView titulo;
	private ImageButton imagen;
	private TextView cuerpoNoticia;
	private WebView webview;
	private DeporteUGRClient deporteUGRApi;
	private String linkNot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leer_noticia);

		ActionBar actionBar = getSupportActionBar();

		// Obtenemos referencias a cada elemento de la activity de la noticia:
		titulo = (TextView) findViewById(R.id.titulo);
		// imagen=(ImageButton)findViewById(R.id.imagen);
		cuerpoNoticia = (TextView) findViewById(R.id.cuerpo);

		webview = (WebView) findViewById(R.id.webView1);
		// Creamos un objeto de ayuda para realizar la llamada:
		deporteUGRApi = new DeporteUGRClient();

		Intent intent = getIntent();
		linkNot = intent.getStringExtra("linkNoticias");

		webview.setBackgroundColor(0x00000000);
		if (Build.VERSION.SDK_INT >= 11)
			webview.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);

		webview.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				view.setBackgroundColor(0x00000000);
				if (Build.VERSION.SDK_INT >= 11)
					view.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
			}
		});

		// Ejemplo: Si nos pasan el enlace a una noticia, extrae sus elementos y
		// hace la llamda:
		String enlaceNoticia = linkNot;

		// Obtenemos el tablón y el identificador de la noticia:
		String[] tokens = enlaceNoticia.split("/");
		String tablon = tokens[tokens.length - 2];
		String noticiaId = tokens[tokens.length - 1];

		actionBar.setTitle("Noticias");
		// actionBar.setSubtitle(categoriaId);

		// Cargamos la página mediante un asynctask:
		new CargadorNoticia(this, deporteUGRApi).execute(tablon, noticiaId);
	}

	public void cargarNoticia(Noticia noticia) {
		String titulo_ = "<h1>¡Ha habido un problema!</h1>";
		String cuerpo_ = "Lo sentimos, no se puede encontrar la noticia solictada.";
		String enlace_ = "";

		// Hay que cargar la imagen y todo...
		// Mejor crear el html sobre esos datos y
		// mostrarlos como webview en lugar de imagebutton y cuerpoNoticia!!!!!!
		//
		if (noticia != null) {
			cuerpo_ = noticia.getTextoHtml();
			titulo_ = noticia.getTitulo();
			enlace_ = noticia.getUrl();
		} else {

		}

		titulo.setText(Html.fromHtml(titulo_));

		webview.loadDataWithBaseURL(null, cuerpo_, "text/html", "utf-8", null);
		// cuerpoNoticia.setText(cuerpo_+" -> "+enlace_);

	}
}

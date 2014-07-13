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
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Activity que carga en un webview la clasificacion para la competicion y deporte introducidos
 *
 */
public class ClasificacionActivity extends ActionBarActivity {

	String categoriaId;
	String deporteId;
	WebView browser;
	String URL;
	private ProgressBar progressBar;

	/**
	 * Metodo que crea/inicializa la activity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		setContentView(R.layout.activity_clasificacion);

		ActionBar actionBar = getSupportActionBar();

		// Extraemos los parámetros de la llamada del intent:
		Intent intent = getIntent();
		categoriaId = intent
				.getStringExtra("com.example.activitydeportes.categoriaId");
		deporteId = intent
				.getStringExtra("com.example.activitydeportes.deporteId");

		actionBar.setTitle("Competiciones");
		actionBar.setSubtitle("Clasificación: " + categoriaId + " / "
				+ deporteId);

		URL = "http://cad.ugr.es/static/CADManagement/*/";

		browser = (WebView) findViewById(R.id.webView1);

		// habilitamos el zoom

		browser.getSettings().setBuiltInZoomControls(true);
		browser.setInitialScale(100);

		browser.loadUrl(URL + categoriaId + "/" + deporteId);

		browser.setWebViewClient(new WebViewClient() {
			// evita que los enlaces se abran fuera nuestra app en el navegador
			// de android
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}

		});

		progressBar = (ProgressBar) findViewById(R.id.progressbar);

		browser.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int progress) {
				progressBar.setProgress(0);
				progressBar.setVisibility(View.VISIBLE);
				ClasificacionActivity.this.setProgress(progress * 1000);

				progressBar.incrementProgressBy(progress);

				if (progress == 100) {
					progressBar.setVisibility(View.GONE);
				}
			}
		});

	}

}

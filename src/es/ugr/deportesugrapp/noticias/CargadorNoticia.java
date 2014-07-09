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

import es.ugr.deportesugrapp.client.DeporteUGRClient;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class CargadorNoticia extends AsyncTask<String, Integer, Noticia> {

	private LeerNoticia padre;
	private DeporteUGRClient deporteUGRApi;
	private ProgressDialog Dialog;

	public CargadorNoticia(LeerNoticia actividadVistaWeb,
			DeporteUGRClient deporteUGRApi) {
		padre = actividadVistaWeb;
		this.deporteUGRApi = deporteUGRApi;
	}

	@Override
	protected void onPreExecute() {
		Dialog = new ProgressDialog(padre);
		Dialog.setMessage("Cargando noticia...");
		Dialog.show();

	}

	@Override
	protected Noticia doInBackground(String... params) {
		Noticia noticia = null;

		noticia = deporteUGRApi.obtenerNoticia(params[0], params[1]);

		return noticia;
	}

	protected void onPostExecute(Noticia noticia) {
		// padre.cargarPaginaWeb("Downloaded " + tabla.length() + " bytes");

		padre.cargarNoticia(noticia);

		Dialog.dismiss();
	}

}

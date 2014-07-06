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
package es.ugr.deportesugrapp.misequipos;

import java.util.List;

import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.torneos.Equipo;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class CargadorEquipos extends AsyncTask<String, Integer, List<Equipo>>{

	private EleccionEquipoActivity padre;
	private DeporteUGRClient deporteUGRApi;
	private ProgressDialog Dialog;

	public CargadorEquipos(EleccionEquipoActivity actividadVistaWeb, DeporteUGRClient deporteUGRApi) {
		padre=actividadVistaWeb;
		this.deporteUGRApi=deporteUGRApi;
	}

	
	@Override
	protected void onPreExecute() {
		Dialog = new ProgressDialog(padre);
		Dialog.setMessage("Cargando equipos...");
		Dialog.show();
	
	}	
	
	
	@Override
	protected List<Equipo> doInBackground(String... params) {
		List<Equipo> listaEquipos=null;
		
		listaEquipos= deporteUGRApi.obtenerEquipo(params[0], params[1]);
		
		return listaEquipos;
	}
	
	  protected void onPostExecute(List<Equipo> listaEquipos) {
		  //padre.cargarPaginaWeb("Downloaded " + tabla.length() + " bytes");

		  if (listaEquipos != null) {
		  
			  padre.cargarEquipos(listaEquipos);
		  
		  }
			  
			  
		  Dialog.dismiss();
	  }


}



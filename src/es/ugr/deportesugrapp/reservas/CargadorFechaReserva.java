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
package es.ugr.deportesugrapp.reservas;

import java.io.UnsupportedEncodingException;

import es.ugr.deportesugrapp.client.DeporteUGRClient;
import es.ugr.deportesugrapp.instalaciones.InstaMainFutsalCesped;
import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * 
 * Clase que permite ejecutar una tarea en segundo plano
 *
 */
public class CargadorFechaReserva extends AsyncTask<String, Integer, String> {

	private DisponibilidadActivity padre;
	private DeporteUGRClient cadApi2;

	/**
	 * Metodo que carga la disponibilidad segun la fecha
	 * @param disponibilidadActivity Activity en la que se mostrara la disponibilidad
	 * @param cadApi2 Permite cargar la informacion de la pagina web
	 */
	public CargadorFechaReserva(DisponibilidadActivity disponibilidadActivity,
			DeporteUGRClient cadApi2) {
		padre = disponibilidadActivity;
		this.cadApi2 = cadApi2;
	}

	private ProgressDialog Dialog;

	/**
	 * Metodo que se ejecuta antes de ejecutar la tarea. Muestra el mensaje de 'Cargando...'
	 */
	@Override
	protected void onPreExecute() {
		Dialog = new ProgressDialog(padre);
		Dialog.setMessage("Cargando información...");
		Dialog.show();

	}

	/**
	 * Metodo que ejecuta la tarea en segundo plano
	 */
	@Override
	protected String doInBackground(String... params) {
		String tabla = "<H1>No se pudo obtener la información</H1>";

		tabla = cadApi2.obtenerTablaReservasFecha(params[0], params[1],
				params[2], params[3]);

		return tabla;
	}

	/**
	 * Metodo que se ejecuta tras el doInBackground, recibiendo el parametro que devuelve. Realizando su tarea correspondiente
	 */
	protected void onPostExecute(String tabla) {
		// padre.cargarPaginaWeb("Downloaded " + tabla.length() + " bytes");

		padre.cargarPaginaWeb(tabla);

		Dialog.dismiss();
	}

}
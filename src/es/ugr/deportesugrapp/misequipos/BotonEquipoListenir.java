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


import es.ugr.deportesugrapp.torneos.Equipo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

public class BotonEquipoListenir implements OnClickListener {

	private String equipoId;
	private String nombre;
	private Equipo equipo;
	private List<Equipo> listaElegidos;
	private List<Equipo> listaEquipos;
	private EleccionEquipoActivity padre;
	

	public BotonEquipoListenir(Equipo equipo) {
//		this.equipoId=equipoId;
//		this.nombre=nombre;
		this.equipo=equipo;
	}

	@Override
	public void onClick(View v) {
		padre.actualizarListaElegidos(equipo);
		//padre.cargarEquipos(listaEquipos);
		//padre.actualizarBoton();
		

	}

	

	public void setPadre(EleccionEquipoActivity mainActivity) {
		padre=mainActivity;
		
	}

}

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


import java.util.List;
import es.ugr.deportesugrapp.R;

import android.app.Activity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Clase que permite adaptar a la lista la imagen y el contenido
 */
public class ListAdapter extends ArrayAdapter<NoticiasEstructura> {
	public List<NoticiasEstructura> lista = null;

	/**
	 * Metodo que adapta la lista con el contenido y la imagen
	 * @param activity Activity en la que se adaptara
	 * @param list Contenido a adaptar
	 */
	public ListAdapter(Activity activity, List<NoticiasEstructura> list) {
		super(activity, 0, list);
		lista = list;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Activity activity = (Activity) getContext();
		LayoutInflater inflater = activity.getLayoutInflater();

		View view = inflater.inflate(R.layout.adapter_noticias, null);
		TextView titulo = (TextView) view.findViewById(R.id.titulo);
		TextView fecha = (TextView) view.findViewById(R.id.fecha);
		ImageView flecha = (ImageView) view.findViewById(R.id.icono);
		
		titulo.setText(lista.get(position).getTitle());
		
		SpannableString content = new SpannableString(lista.get(position).getPubDate());
		fecha.setText(content);
		flecha.setBackgroundResource(R.drawable.flecha_negro25prueba);
		
		return view;

	}

}
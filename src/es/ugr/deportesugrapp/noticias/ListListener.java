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


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;



/**
 * Class implements a list listener
 * 
 * @author ITCuties
 *
 */
public class ListListener implements OnItemClickListener {

	// List item's reference
	List<RssFeedStructure> listItems;
	// Calling activity reference
	Activity activity;
	
	public ListListener(List<RssFeedStructure> result, Activity anActivity) {
		listItems = result;
		activity  = anActivity;
	}
	
	/**
	 * Start a browser with url from the rss item.
	 */
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		
		i.setData(Uri.parse(listItems.get(pos).getLink()));
	
		activity.startActivity(i);
		
	}
	
}

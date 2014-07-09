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

import java.util.List;

import org.json.JSONObject;

import es.ugr.deportesugrapp.noticias.LeerNoticia;
import es.ugr.deportesugrapp.noticias.RssFeedStructure;
import es.ugr.deportesugrapp.noticias.RssReaderListAdapter;
import es.ugr.deportesugrapp.noticias.XmlHandler;
import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Noticias extends ActionBarActivity {
	/** Called when the activity is first created. */

	ListView _rssFeedListView;
	List<JSONObject> jobs;
	List<RssFeedStructure> rssStr;
	private RssReaderListAdapter _adapter;
	String sorti = "";
	String mode = "";
	private LinearLayout layout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rssfeedreaderactivity);

		ActionBar actionBar = getSupportActionBar();

		actionBar.setTitle("Noticias");
		// actionBar.setSubtitle("");

		_rssFeedListView = (ListView) findViewById(R.id.rssfeed_listview);
		layout = (LinearLayout) findViewById(R.id.fondo);

		RssFeedTask rssTask = new RssFeedTask();
		rssTask.execute();
	}

	private class RssFeedTask extends
			AsyncTask<String, Void, List<RssFeedStructure>> {
		// private String Content;
		private ProgressDialog Dialog;
		String response = "";

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(Noticias.this);
			Dialog.setMessage("Cargando noticias...");
			Dialog.show();

		}

		@Override
		protected List<RssFeedStructure> doInBackground(String... urls) {
			try {
				// String feed = "http://feeds.nytimes.com/nyt/rss/HomePage";

				String feed = "http://cad.ugr.es/pages/tablon/*/rss";
				XmlHandler rh = new XmlHandler();
				rssStr = rh.getLatestArticles(feed);
			} catch (Exception e) {
			}

			return null;

		}

		@Override
		protected void onPostExecute(List<RssFeedStructure> result) {

			if (rssStr != null && !rssStr.isEmpty()) {
				_adapter = new RssReaderListAdapter(Noticias.this, rssStr);
				_rssFeedListView.setAdapter(_adapter);
				// _rssFeedListView.setOnItemClickListener(new
				// ListListener(result, local));

				_rssFeedListView
						.setOnItemClickListener(new AdapterView.OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> parent,
									View listItemView, int pos, long idOfItem) {
								// Here you put what you want to do when a
								// listItem is clicked

								// Log.d("My POSITION",""+pos);

								listItemView
										.setBackgroundResource(R.drawable.selector);
								Intent intent = new Intent(Noticias.this,
										LeerNoticia.class);
								String linkNot = rssStr.get(pos).getLink();
								intent.putExtra("linkNoticias", linkNot);

								startActivity(intent);

								// k.setData(Uri.parse(rssStr.get(pos).getLink()));

								// startActivity(k);

							}
						});
				// _rssFeedListView.setOnItemClickListener(new
				// ListListener(result, RssFeedReaderActivity.this));

			} else {

				mostrarError("No ha sido posible establecer la conexión con el servidor. Inténtelo de nuevo mas tarde.");

			}
			Dialog.dismiss();
		}
	}

	private void mostrarError(String string) {
		TextView tv = new TextView(this);
		tv.setText(string);
		tv.setTextSize(20);
		tv.setPadding(15, 20, 0, 0);
		layout.addView(tv);
	}

}
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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import es.ugr.deportesugrapp.R;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RssReaderListAdapter extends ArrayAdapter<RssFeedStructure> {
	public List<RssFeedStructure> imageAndTexts1 =null;
	
	
	
	
public RssReaderListAdapter(Activity activity, List<RssFeedStructure> imageAndTexts) {
super(activity, 0, imageAndTexts);
imageAndTexts1 = imageAndTexts;

 
}


@Override
public View getView(int position, View convertView, ViewGroup parent) {

Activity activity = (Activity) getContext();
LayoutInflater inflater = activity.getLayoutInflater();


View rowView = inflater.inflate(R.layout.rssfeedadapter_layout, null);
TextView textView = (TextView) rowView.findViewById(R.id.feed_text);
TextView timeFeedText = (TextView) rowView.findViewById(R.id.feed_updatetime);
ImageView imageView = (ImageView) rowView.findViewById(R.id.feed_image);
//TextView link = (TextView) rowView.findViewById(R.id.textViewLink);
       

// try {
        	
        	//Log.d("rssfeed", "imageAndTexts1.get(position).getImgLink() :: " +imageAndTexts1.get(position).getLink() +" :: " +imageAndTexts1.get(position).getTitle());
        	textView.setText(imageAndTexts1.get(position).getTitle());
        	SpannableString content = new SpannableString(imageAndTexts1.get(position).getPubDate());
        	content.setSpan(new UnderlineSpan(), 0, 31, 0);

        	timeFeedText.setText(content);
        	
        	//link.setText(imageAndTexts1.get(position).getLink());
        	//if(imageAndTexts1.get(position).getImgLink() !=null){
        		
       
        	//URL feedImage= new URL(imageAndTexts1.get(position).getImgLink().toString());
        	//if(!feedImage.toString().equalsIgnoreCase("null")){
        		//HttpURLConnection conn= (HttpURLConnection)feedImage.openConnection();
            	//InputStream is = conn.getInputStream();
            	//Bitmap img = BitmapFactory.decodeStream(is);
            	//imageView.setImageBitmap(img);
        	//}
        	 //else{
             	imageView.setBackgroundResource(R.drawable.flecha_negro25prueba);
             //}
        		//}
       
        	
       // } catch (MalformedURLException e) {
       
       // }
        //catch (IOException e) {
        
       // }

return rowView;

}

}
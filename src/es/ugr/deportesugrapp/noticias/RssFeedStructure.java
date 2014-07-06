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




public class RssFeedStructure {

private String title;
private String link;
private String pubDate;


/**
* @return the title
*/
public String getTitle() {
return title;
}
/**
* @param title the title to set
*/
public void setTitle(String title) {
this.title = title;
}


public String getLink() {
	return link;
}

public void setLink(String link) {
	this.link = link;
}

/**
* @param pubDate the pubDate to set
*/
public void setPubDate(String pubDate) {
this.pubDate = pubDate;
}
/**
* @return the pubDate
*/
public String getPubDate() {
return pubDate;
}

@Override
public String toString() {
	return  title + "\n" + pubDate;
}

}



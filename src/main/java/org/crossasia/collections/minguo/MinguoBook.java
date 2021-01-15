package org.crossasia.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MinguoBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-minguo/booksNew.json"));
        String books = "/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-minguo/books.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String edition ="";
            String responsibility ="";
            String url ="";
            String id ="";
            String date = "";

            String book_id = "";
            String ISBN = "";
            String title = "";
            String extent = "";

            String issued = "";

            JSONArray description = null;
            String medium = "";
            JSONArray subject = null;
            JSONArray language = null;
            String series_title = "";
            JSONArray person = null;
            JSONArray spatial = null;
            JSONArray identifier = null;
            JSONArray keywords = null;
            JSONArray author = null;
            JSONArray alternative = null;
            JSONArray note = null;
            String publisher = "";
            String publication_place = "";
            String erflink = "";
            String erf = "";
            String collection = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");

            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("series_title")) {
                series_title  = (String) booksObj.get("series_title");
            }

            if (booksObj.has("collection")) {
                collection  = (String) booksObj.get("collection");
            }

            if (booksObj.has("url")) {

                erf = (String) booksObj.get("url").toString().replace("http://", "");
                erflink = "http://erf.sbb.spk-berlin.de/han/NLCminguo/" + erf;
            }

            if (booksObj.has("responsibility")) {
                responsibility  = (String) booksObj.get("responsibility");
            }
            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");

            if (booksObj.has("publication_place")) {
                publication_place  = (String) booksObj.get("publication_place");
            }

            if (booksObj.has("publisher")) {
                publisher  = (String) booksObj.get("publisher");
            }

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();

            if (booksObj.has("extent"))
                extent =(String) booksObj.get("extent").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("language"))
                language =(JSONArray) booksObj.get("language");

            if (booksObj.has("description")) {
                description  = (JSONArray) booksObj.get("description");
            }

            if (booksObj.has("url")) {
                url  = (String) booksObj.get("url");
            }

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');
            if (title!="")
                sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+"," + '\n');
            if (series_title!="")
                sb.append(  quote + "series_title" + quote + ":" + quote+ series_title+ quote+"," + '\n');
            if (responsibility!="")
                sb.append(  quote + "responsibility" + quote + ":" + quote+ responsibility+ quote+"," + '\n');
            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +  author+ "," + '\n');
            if (publication_place!="")
                sb.append(  quote + "publication_place" + quote + ":" + quote+ publication_place+ quote+"," + '\n');
            if (publisher!="")
                sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+quote+ "," + '\n');
            if (date!="")
                sb.append(  quote + "date" + quote + ":" + quote+ date+quote+ "," + '\n');
            if (edition!="")
                sb.append(  quote + "edition" + quote + ":" + quote+ edition+quote+ "," + '\n');
            if (extent!="")
                sb.append(  quote + "extent" + quote + ":" + quote+ extent+quote+ "," + '\n');
            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" + subject+  "," + '\n');
            if (description!=null)
                sb.append(  quote + "description" + quote + ":" +   description+  "," + '\n');
            if (url!="")
                sb.append(  quote + "url" + quote + ":" + quote+  url+ quote+  "," + '\n');
            if (erflink!="")
                sb.append(  quote + "erflink" + quote + ":" + quote+  erflink+ quote+  "," + '\n');
            if (language!=null)
                sb.append(  quote + "language" + quote + ":" + language+ "," + '\n');

            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ collection + quote + "" + '\n' );

            sb.append("},");

        }
        out.println(sb);
    }
}

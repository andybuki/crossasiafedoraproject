package org.crossasia.solr.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MiguoBookDate {
    public static void main(String[] args) throws IOException {
    PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo//books_date.json"));
    String books = "/data3/solr/minguo//books.json";
    String quote = "\u005c\u0022";
    JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

    StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String edition ="";
            String responsibility ="";
            JSONArray series_title_transcription =null;
            JSONArray title_transcription =null;
        String url ="";
        String id ="";
        String date = "";

        String book_id = "";
        String ISBN = "";
            String title = "";
        String extent = "";

        String issued = "";

        JSONArray description = null;
            JSONArray temporal = null;
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
            String  thumbnail_path= "";
        JSONArray note = null;
            String publisher = "";
            String publication_place = "";
            JSONArray creator_transcription = null;
            JSONArray physical_description = null;


        JSONObject booksObj = (JSONObject) booksObject.get(i);
        id = (String) booksObj.get("id").toString();
        book_id = (String) booksObj.get("book_id").toString();
        if (booksObj.has("identifier"))
            identifier =(JSONArray) booksObj.get("identifier");

            if (booksObj.has("series_title_transcription"))
                series_title_transcription =(JSONArray) booksObj.get("series_title_transcription");
            if (booksObj.has("title_transcription"))
                title_transcription =(JSONArray) booksObj.get("title_transcription");

        if (booksObj.has("title"))
            title = (String) booksObj.get("title");

            if (booksObj.has("physical_description"))
                physical_description = (JSONArray) booksObj.get("physical_description");

        if (booksObj.has("creator_transcription"))
            creator_transcription = (JSONArray) booksObj.get("creator_transcription");

            if (booksObj.has("temporal"))
                temporal = (JSONArray) booksObj.get("temporal");

        if (booksObj.has("series_title")) {
            series_title  = (String) booksObj.get("series_title");
        }

        if (booksObj.has("responsibility")) {
            responsibility  = (String) booksObj.get("responsibility");
        }
            if (booksObj.has("thumbnail_path")) {
                thumbnail_path  = (String) booksObj.get("thumbnail_path");
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
            date =(String) booksObj.get("date").toString().replace("[","").replace("]","").replaceAll("\\?","");

        if (booksObj.has("edition"))
            edition =(String) booksObj.get("edition");

        if (booksObj.has("extent"))
            extent =(String) booksObj.get("extent").toString();

        if (booksObj.has("subject"))
            subject =(JSONArray) booksObj.get("subject");

        if (booksObj.has("description")) {
            description  = (JSONArray) booksObj.get("description");
        }

        if (booksObj.has("url")) {
            url  = (String) booksObj.get("url");
        }
        String book="Book";
        String lang ="chi";
        String collection ="Early Twentieth Century Chinese Books (1912-1949)";


            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');
            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+  title+ quote+ "," + '\n');
            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" + quote+  series_title+ quote+ "," + '\n');
            if (responsibility!=null)
                sb.append(  quote + "responsibility" + quote + ":" + quote+ responsibility+ quote+"," + '\n');
            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +  author+ "," + '\n');
            if (publication_place!=null)
                sb.append(  quote + "publication_place" + quote + ":" + quote+publication_place+ quote+"," + '\n');
            if (publisher!=null)
                sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+ quote+"," + '\n');
            if (date!=null)
                sb.append(  quote + "date" + quote + ":" + quote+ date+quote+ "," + '\n');
            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" + quote+ edition+ quote+"," + '\n');
            if (extent!=null)
                sb.append(  quote + "extent" + quote + ":" + quote+ extent+quote+ "," + '\n');
            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" + subject+  "," + '\n');
            if (description!=null)
                sb.append(  quote + "description" + quote + ":" +   description+  "," + '\n');
            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+  url.replace("\r\n","")+ quote+  "," + '\n');
            if (language!=null)
                sb.append(  quote + "language" + quote + ":" + quote+ "chi"+ quote+ "," + '\n');

            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ collection+ quote + "" + '\n' );

            sb.append("},");

    }
        out.println(sb);
}
}

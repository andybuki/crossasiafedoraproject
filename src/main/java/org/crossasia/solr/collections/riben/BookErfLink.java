package org.crossasia.solr.collections.riben;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BookErfLink {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ajax-riben/books.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-riben/books2.json"));
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String edition ="";
            String responsibility ="";
            String url ="";
            String erflink ="";

            String date = "";
            JSONArray identifier = null;
            String book_id = "";
            String id = "";
            String source = "";
            String title = "";
            String thumbnail_path = "";


            String issued = "";

            //String series_title = "";
            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            JSONArray citation = null;
            String language = "";
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray author = null;

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("thumbnail_path")) {
                thumbnail_path  = (String) booksObj.get("thumbnail_path");
            }

            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();
            if (booksObj.has("series_title"))
                series_title =(JSONArray) booksObj.get("series_title");
            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");
            if (booksObj.has("citation"))
                citation =(JSONArray) booksObj.get("citation");
            if (identifier.get(0).toString().contains("http://")) {
                url = identifier.get(0).toString();
            } else if (identifier.get(1).toString().contains("http://")) {
                url = identifier.get(1).toString();
            }
            String url2 = url.replace("http://","");
            erflink =  "http://erf.sbb.spk-berlin.de/han/ribengudianshujiku/"+url2;

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (author!=null) {
                sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
            }

            if (citation!=null) {
                sb.append(quote + "citation" + quote + ":" +  citation  + "," + '\n');
            }

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n');

            if (thumbnail_path!=null)
                sb.append(  quote + "thumbnail_path" + quote + ":" + quote+ thumbnail_path+ quote + "," + '\n');

            if (erflink!=null)
                sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n');

            if (date!=null)
                sb.append(  quote + "date" + quote + ":" +  date+  "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + title+ "," + '\n');

            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" +  edition+  "," + '\n');
            if (person!=null)
                sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');

            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" +  series_title+  "," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

            if (language!=null)
                sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "Classical Works of Japan"+ quote + "" + '\n' );

            sb.append("},");
        }

        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}

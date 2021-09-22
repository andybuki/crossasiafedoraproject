package org.crossasia.solr.collections.ccg;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PageErfLink {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/CCG/pages/books_pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/CCG/pages/books_pagesNew.json"));
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id = "";
            String book_id = "";
            String title = "";
            String bibliographicCitation = "";
            String responsibility ="";
            JSONArray author = null;
            String date = "";
            String edition ="";
            JSONArray subject = null;
            String language = "";
            JSONArray temporal = null;
            String spatial = "";
            String extent = "";
            String format = "";
            JSONArray url =null;
            String erflink ="";
            String url2 ="";
            String identifier ="";

            String volume ="";
            String position ="";
            String position_vol ="";
            String chapter_title ="";
            String text ="";
            String running_title ="";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("volume"))
                volume = (String) booksObj.get("volume").toString();

            if (booksObj.has("position"))
                position = (String) booksObj.get("position").toString();

            if (booksObj.has("position_vol"))
                position_vol = (String) booksObj.get("position_vol").toString();

            if (booksObj.has("chapter_title"))
                chapter_title = (String) booksObj.get("chapter_title").toString();

            if (booksObj.has("text"))
                text = (String) booksObj.get("text").toString();

            if (booksObj.has("running_title"))
                running_title = (String) booksObj.get("running_title").toString();



            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();

            if (booksObj.has("identifier"))
                identifier = (String) booksObj.get("identifier").toString();

            if (booksObj.has("bibliographicCitation"))
                bibliographicCitation = (String) booksObj.get("bibliographicCitation").toString();

            if (booksObj.has("responsibility")) {
                responsibility  = (String) booksObj.get("responsibility");
            }

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }

            if (booksObj.has("temporal"))
                temporal =(JSONArray) booksObj.get("temporal");

            if (booksObj.has("spatial")) {
                spatial  = (String) booksObj.get("spatial");
            }

            if (booksObj.has("extent")) {
                extent  = (String) booksObj.get("extent");
            }

            if (booksObj.has("format")) {
                format  = (String) booksObj.get("format");
            }

            if (booksObj.has("url"))
                url =(JSONArray) booksObj.get("url");



            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

            if (volume!=null)
                sb.append(  quote + "volume" + quote + ":" + quote+  volume+ quote+  "," + '\n');

            if (position!=null)
                sb.append(  quote + "position" + quote + ":" + quote+  position+ quote+  "," + '\n');

            if (position_vol!=null)
                sb.append(  quote + "position_vol" + quote + ":" + quote+  position_vol+ quote+  "," + '\n');

            if (chapter_title!=null)
                sb.append(  quote + "chapter_title" + quote + ":" + quote+  chapter_title+ quote+  "," + '\n');

            if (text!=null)
                sb.append(  quote + "text" + quote + ":" + quote+  text+ quote+  "," + '\n');

            if (running_title!=null)
                sb.append(  quote + "running_title" + quote + ":" + quote+  running_title+ quote+  "," + '\n');



            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+  title+ quote+  "," + '\n');

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" + quote+  identifier+ quote+  "," + '\n');

            if (bibliographicCitation!=null)
                sb.append(  quote + "bibliographicCitation" + quote + ":" + quote+  bibliographicCitation+ quote+  "," + '\n');

            if (responsibility!=null)
                sb.append(  quote + "responsibility" + quote + ":" + quote+  responsibility+ quote+  "," + '\n');


            if (author!=null) {
                sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
            }

            if (date!=null)
                sb.append(  quote + "date" + quote + ":" +  quote+date+ quote+ "," + '\n');

            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" + quote+ edition+ quote+ "," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');
            if (language!=null)
                sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');
            if (temporal!=null)
                sb.append(  quote + "temporal" + quote + ":" +  temporal+  "," + '\n');
            if (spatial!=null)
                sb.append(  quote + "spatial" + quote + ":" + quote+ spatial+ quote+ "," + '\n');
            if (extent!=null)
                sb.append(  quote + "extent" + quote + ":" + quote+ extent+ quote+ "," + '\n');
            if (format!=null)
                sb.append(  quote + "format" + quote + ":" + quote+ format+ quote+ "," + '\n');
            if (erflink!=null)
                sb.append(  quote + "erflink" + quote + ":" + quote+ url.get(1)+ quote + "," + '\n');

            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url.get(0)+ quote + "," + '\n');


            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "China Comprehensive Gazetteers"+ quote + "" + '\n' );

            sb.append("},");
        }

        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}

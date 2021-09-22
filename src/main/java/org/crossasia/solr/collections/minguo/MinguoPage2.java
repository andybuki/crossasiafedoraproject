package org.crossasia.solr.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MinguoPage2 {
    public static void main(String[] args) throws IOException {
        String encoding = "UTF-8";
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo/sections3.json"), Boolean.parseBoolean(encoding));
        String books = "/data3/solr/minguo/sections.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            String book_id = "";
            JSONArray identifier = null;
            JSONArray author = null;
            String position = "";
            String text = "";
            String date = "";
            String title = "";
            String chapter_title ="";
            String publication_place = "";
            JSONArray subject = null;
            String url = "";
            String language = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("identifier")) {
                identifier = (JSONArray) booksObj.get("identifier");
            }
            if (booksObj.has("author")) {
                author = (JSONArray) booksObj.get("author");
            }
            if (booksObj.has("position"))
                position = (String) booksObj.get("position").toString();
            if (booksObj.has("text"))
                text = (String) booksObj.get("text").toString().replaceAll("\",\"",  "");
            if (booksObj.has("date"))
                date = (String) booksObj.get("date").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();
            if (booksObj.has("chapter_title"))
                chapter_title = (String) booksObj.get("chapter_title").toString().replaceAll(" ","\",\"");
            if (booksObj.has("publication_place"))
                publication_place = (String) booksObj.get("publication_place").toString();
            if (booksObj.has("subject")) {
                subject = (JSONArray) booksObj.get("subject");
            }
            if (booksObj.has("url"))
                url = (String) booksObj.get("url").toString();

            String collection ="Early Twentieth Century Chinese Books (1912-1949)";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" + identifier + "," + '\n');

            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +  author+ "," + '\n');

            if (position!=null)
                sb.append(  quote + "position" + quote + ":" + quote+ position+quote+ "," + '\n');

            if (text!=null)
                sb.append(  quote + "text" + quote + ":" + quote+ text+quote+ "," + '\n');

            if (date!=null&& date!="null")
                sb.append(  quote + "date" + quote + ":" + quote+ date+quote+ "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+ title+quote+ "," + '\n');

            if (chapter_title!=null)
                sb.append(  quote + "chapter_title" + quote + ":" + "["+quote+ chapter_title+quote+ "]"+"," + '\n');

            if (publication_place!=null)
                sb.append(  quote + "publication_place" + quote + ":" + quote+publication_place+ quote+"," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" + subject+  "," + '\n');

            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url+ quote+"," + '\n');

            sb.append(  quote + "language" + quote + ":" + quote+ "chi"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ collection+ quote + "" + '\n' );

            sb.append("},");


        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

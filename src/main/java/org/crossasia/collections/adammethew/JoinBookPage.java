package org.crossasia.collections.adammethew;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JoinBookPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "D:\\SOLR-COLLECTIONS\\adm\\FINAL\\books2.json";
        String pages = "D:\\SOLR-COLLECTIONS\\adm\\FINAL\\pages2.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\adm\\FINAL\\books_pages2.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String book_id="";
            String title="";
            String language ="";

            String date ="";

            String identifier ="";

            JSONArray edition = null;
            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            JSONArray keywords = null;
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray spatial = null;


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();
            language =(String) booksObj.get("language").toString();
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();
            if (booksObj.has("spatial"))
                spatial =(JSONArray) booksObj.get("spatial");
            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");

            if (booksObj.has("identifier"))
                identifier =(String) booksObj.get("identifier").toString();
            if (booksObj.has("person"))
                person =(JSONArray) booksObj.get("person");
            if (booksObj.has("series_title"))
                series_title =(JSONArray) booksObj.get("series_title");
            if (booksObj.has("keywords"))
                keywords =(JSONArray) booksObj.get("keywords");
            if (booksObj.has("medium"))
                medium =(JSONArray) booksObj.get("medium");
            if (booksObj.has("description"))
                description =(JSONArray) booksObj.get("description");


            for (int j=0; j<pagesObject.length();j++) {
                String book_id_page="";
                String id ="";
                String image_url="";
                String position="";
                String image_file="";
                String text="";
                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();

                if (pagesObj.has("image_url"))
                    image_url = (String) pagesObj.get("image_url").toString();
                if (pagesObj.has("image_file"))
                    image_file = (String) pagesObj.get("image_file").toString();
                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();
                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString();
                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "title" + quote + ":" +   quote +title+  quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "book_id" + quote + ":" +   quote +book_id + quote + "," + '\n'
                            + quote + "language" + quote + ":" +   quote +language+ quote+  "," + '\n'
                            + quote + "description" + quote + ":" +   description +   "," + '\n'
                            + quote + "date" + quote + ":" +   quote +date +quote+ "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"Adam Matthew - Foreign Office Files China & Japan" +  quote + "," + '\n'
                            + quote + "spatial" + quote + ":" +   spatial +   "," + '\n'
                            + quote + "subject" + quote + ":" +   subject +   "," + '\n'
                            + quote + "edition" + quote + ":" +   edition +   "," + '\n'
                            + quote + "keywords" + quote + ":" +   keywords +   "," + '\n'
                            + quote + "series_title" + quote + ":" +   series_title +  "," + '\n'
                            + quote + "person" + quote + ":" +   person +  "," + '\n'
                            + quote + "medium" + quote + ":" +   medium +  "," + '\n'
                            + quote + "identifier" + quote + ":" +   quote +identifier +  quote + "," + '\n'
                            + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                            + quote + "image_url" + quote + ":" +    image_url +   "," + '\n'
                            + quote + "image_file" + quote + ":" +   quote +image_file +  quote + "," + '\n'
                            + quote + "text" + quote + ":" +   quote +text +  quote + "" + '\n'

                            +"},"
                    );
                }else {
                    System.out.println("NO: "+book_id);
                }
            }

        }//sb.deleteCharAt(sb.length() - 1);
        //out.println("["+sb.toString()+"]");

    }
}

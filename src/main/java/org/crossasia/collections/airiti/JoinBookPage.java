package org.crossasia.collections.airiti;

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
        String books = "D:\\SOLR-COLLECTIONS\\airiti\\books2.json";
        String pages = "D:\\SOLR-COLLECTIONS\\airiti\\pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\airiti\\books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String book_id="";
            String title="";
            String language ="";
            String author ="";
            String date ="";
            String spatial ="";
            String subject ="";
            String edition ="";
            String responsibility ="";
            String url ="";
            String keywords ="";
            String publisher ="";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();
            language =(String) booksObj.get("language").toString();
            if (booksObj.has("author"))
                author =(String) booksObj.get("author").toString();
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();
            if (booksObj.has("spatial"))
                spatial =(String) booksObj.get("spatial").toString();
            if (booksObj.has("subject"))
                subject =(String) booksObj.get("subject").toString();
            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();
            if (booksObj.has("responsibility"))
                responsibility =(String) booksObj.get("responsibility").toString();
            if (booksObj.has("identifier"))
                url =(String) booksObj.get("identifier").toString();
            if (booksObj.has("keywords"))
                keywords =(String) booksObj.get("keywords").toString();
            if (booksObj.has("publisher"))
                publisher =(String) booksObj.get("publisher").toString();


            for (int j=0; j<pagesObject.length();j++) {
                String book_id_page="";
                String id ="";
                //String running_title="";
                //String volume="";
                //String position_vol="";
                String position="";
                //String chapter_title="";
                String text="";
                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();
                //if (pagesObj.has("running_title"))
                //    running_title = (String) pagesObj.get("running_title").toString();
                //if (pagesObj.has("volume"))
                 //   volume = (String) pagesObj.get("volume").toString();
                //if (pagesObj.has("position_vol"))
                //    position_vol = (String) pagesObj.get("position_vol").toString();
                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();
                //if (pagesObj.has("chapter_title"))
                //    chapter_title = (String) pagesObj.get("chapter_title").toString();
                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString();
                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "title" + quote + ":" +   quote +title+  quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "book_id" + quote + ":" +   quote +book_id + quote + "," + '\n'
                            + quote + "language" + quote + ":" +   quote +language+ quote+  "," + '\n'
                            + quote + "author" + quote + ":" +   author+   "," + '\n'
                            + quote + "date" + quote + ":" +   quote +date +quote+ "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"Airiti" +  quote + "," + '\n'
                            + quote + "spatial" + quote + ":" +   quote +spatial +  quote + "," + '\n'
                            + quote + "subject" + quote + ":" +  quote + subject + quote + "," + '\n'
                            + quote + "edition" + quote + ":" +   quote +edition +  quote + "," + '\n'
                            + quote + "responsibility" + quote + ":" +   quote +responsibility +  quote + "," + '\n'
                            + quote + "url" + quote + ":" +  quote+ url +  quote+ "," + '\n'
                            + quote + "keywords" + quote + ":" +   keywords +   "," + '\n'
                            + quote + "publisher" + quote + ":" + quote+  publisher + quote+  "," + '\n'
                            //+ quote + "volume" + quote + ":" +   quote +volume +  quote + "," + '\n'
                            + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                            //+ quote + "position_vol" + quote + ":" +   quote +position_vol +  quote + "," + '\n'
                            //+ quote + "chapter_title" + quote + ":" +   quote +chapter_title +  quote + "," + '\n'
                            + quote + "text" + quote + ":" +   quote +text +  quote + "" + '\n'
                            //+ quote + "running_title" + quote + ":" +   quote +running_title +  quote  + '\n'
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

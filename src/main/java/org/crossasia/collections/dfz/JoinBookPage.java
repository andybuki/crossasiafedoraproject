package org.crossasia.collections.dfz;

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
        String books = "D:\\SOLR-COLLECTIONS\\dfz\\2\\books.json";
        String pages = "D:\\SOLR-COLLECTIONS\\dfz\\2\\pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\dfz\\2\\books_pages.json"));

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
            String admin_level_1 ="";
            String admin_level_2 ="";
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

            for (int j=0; j<pagesObject.length();j++) {
                String book_id_page="";
                String id ="";
                String running_title="";
                String volume="";
                String chapter_title="";
                String position="";
                String page_id="";
                String text="";
                String xml_file="";
                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();
                if (pagesObj.has("running_title"))
                    running_title = (String) pagesObj.get("running_title").toString();
                if (pagesObj.has("volume"))
                    volume = (String) pagesObj.get("volume").toString();
                if (pagesObj.has("chapter_title"))
                    chapter_title = (String) pagesObj.get("chapter_title").toString();
                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();
                if (pagesObj.has("page_id"))
                    page_id = (String) pagesObj.get("page_id").toString();
                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString();
                if (pagesObj.has("xml_file"))
                    xml_file = (String) pagesObj.get("xml_file").toString();
                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "title" + quote + ":" +   title+   "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "book_id" + quote + ":" +   quote +book_id + quote + "," + '\n'
                            + quote + "language" + quote + ":" +   quote +language+ quote+  "," + '\n'
                            + quote + "author" + quote + ":" +   author +   "," + '\n'
                            + quote + "date" + quote + ":" +   date + "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"Local Gazetteer (Diaolong)" +  quote + "," + '\n'
                            + quote + "spatial" + quote + ":" +   spatial +   "," + '\n'
                            + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                            + quote + "responsibility" + quote + ":" +   responsibility +   "," + '\n'
                            + quote + "url" + quote + ":" +   url +   "," + '\n'
                            + quote + "position" + quote + ":" +   quote +position +  quote + "," + '\n'
                            + quote + "chapter_title" + quote + ":" +   quote +chapter_title +  quote + "," + '\n'
                            + quote + "xml_file" + quote + ":" +   quote +xml_file +  quote + "," + '\n'
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

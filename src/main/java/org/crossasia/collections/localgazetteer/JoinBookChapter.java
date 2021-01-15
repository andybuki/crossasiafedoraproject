package org.crossasia.collections.localgazetteer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JoinBookChapter {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-loc-gaz/books2.json";
        
        String section = "/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-loc-gaz/books_chapter2.json";
        PrintStream out = new PrintStream(new FileOutputStream("/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-loc-gaz/books_chapterNew2.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray sectionObject = new JSONArray(new JSONTokener(new FileInputStream(section)));


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
            String erflink ="";

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
            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();
            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();

            for (int j=0; j<sectionObject.length();j++) {
                String book_id_section="";
                String id ="";
                String running_title="";
                String value="";
                String title_chapter="";
                String chapter_id="";
                String position="";
                String page_id="";
                String text="";
                String pageStart="";
                String pageEnd="";
                JSONObject sectionObj = (JSONObject) sectionObject.get(j);
                id = (String) sectionObj.get("id").toString();
                book_id_section = (String) sectionObj.get("book_id").toString();
                if (sectionObj.has("chapter_id"))
                    chapter_id = (String) sectionObj.get("chapter_id").toString();

                if (sectionObj.has("title"))
                    title_chapter = (String) sectionObj.get("title").toString();

                if (sectionObj.has("pageStart"))
                    pageStart = (String) sectionObj.get("pageStart").toString();

                if (sectionObj.has("pageEnd"))
                    pageEnd = (String) sectionObj.get("pageEnd").toString();

                if (sectionObj.has("value"))
                    value = (String) sectionObj.get("value").toString();


                if (book_id.equals(book_id_section)){
                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "title" + quote + ":" +   quote +title+  quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Chapter" +  quote + "," + '\n'
                            + quote + "book_id" + quote + ":" +   quote +book_id + quote + "," + '\n'
                            + quote + "language" + quote + ":" +   quote +language+ quote+  "," + '\n'
                            + quote + "author" + quote + ":" +   author +   "," + '\n'
                            + quote + "date" + quote + ":" +   quote +date +quote+ "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"Local Gazetteer" +  quote + "," + '\n'
                            + quote + "spatial" + quote + ":" +   spatial +   "," + '\n'
                            + quote + "subject" + quote + ":" +   subject +   "," + '\n'
                            + quote + "edition" + quote + ":" +   quote +edition +  quote + "," + '\n'
                            + quote + "responsibility" + quote + ":" +   quote +responsibility +  quote + "," + '\n'
                            + quote + "url" + quote + ":" +  quote+ url + quote+  "," + '\n'
                            + quote + "erflink" + quote + ":" +  quote+ erflink + quote+  "," + '\n'
                            + quote + "value" + quote + ":" +   quote +value +  quote + "," + '\n'
                            + quote + "pageStart" + quote + ":" +   quote +pageStart +  quote + "," + '\n'
                            + quote + "pageEnd" + quote + ":" +   quote +pageEnd +  quote + "," + '\n'
                            + quote + "chapter_id" + quote + ":" +    chapter_id +   "," + '\n'
                            + quote + "title_chapter" + quote + ":" +   quote +title_chapter +  quote + "" + '\n'

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

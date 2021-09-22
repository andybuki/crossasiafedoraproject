package org.crossasia.solr.collections.minguo;

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
        String books = "/data3/solr/minguo/books.json";
        String pages = "/data3/solr/minguo/minguo_new.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo/books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";

            String publication_place ="";
            String responsibility ="";
            String url ="";

            String date = "";
            JSONArray identifier = null;
            String book_id = "";

            String source = "";
            String title = "";


            String issued = "";

            //String series_title = "";
            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            String language = "";
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray author = null;

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            //id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();

            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");

            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();


            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");


            if (booksObj.has("publication_place"))
                publication_place =(String) booksObj.get("publication_place").toString();

            if (booksObj.has("url"))
                url =(String) booksObj.get("url");


            for (int j=0; j<pagesObject.length();j++) {
                String book_id_page="";
                String id ="";
                String running_title="";
                String volume="";
                String chapter_title="";
                String position="";
                String page_id="";
                String text="";
                String image_url="";
                String xml_file = "";
                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();

                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString();

                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();

                if (pagesObj.has("page_id"))
                    page_id = (String) pagesObj.get("page_id").toString();

                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

                    if (author!=null) {
                        sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
                    }

                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" + quote+ identifier+ quote + "," + '\n');
                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" +  date+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + title+ "," + '\n');

                    if (url!=null)
                        sb.append(  quote + "url" + quote + ":" +  url+  "," + '\n');

                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');

                    if (publication_place!=null)
                        sb.append(  quote + "publication_place" + quote + ":" +  publication_place+  "," + '\n');

                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');

                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Early Twentieth Century Chinese Books (1912-1949)"+ quote + "" + '\n' );

                    sb.append("},");
                }else {
                    System.out.println("NO: "+book_id);
                }
                //System.out.println(booksObj);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

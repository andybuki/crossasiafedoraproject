package org.crossasia.collections.chinatrade;

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
        String books = "D:\\SOLR-COLLECTIONS\\china-trade\\books.json";
        String pages = "D:\\SOLR-COLLECTIONS\\china-trade\\pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\china-trade\\books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";

            String edition ="";
            String responsibility ="";
            String url ="";

            String date = "";
            String identifier = "";
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
            JSONArray spatial = null;
            JSONArray keywords = null;
            String author = "";
            String publication_place = "";
            String publication_name = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }
            if (booksObj.has("publication_place")) {
                publication_place  = (String) booksObj.get("publication_place");
            }
            if (booksObj.has("publication_name")) {
                publication_name  = (String) booksObj.get("publication_name");
            }
            if (booksObj.has("spatial")) {
                spatial  = (JSONArray) booksObj.get("spatial");
            }
            if (booksObj.has("medium")) {
                medium  = (JSONArray) booksObj.get("medium");
            }
            if (booksObj.has("keywords")) {
                keywords  = (JSONArray) booksObj.get("keywords");
            }

            if (booksObj.has("author"))
                author =(String) booksObj.get("author");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();
            if (booksObj.has("series_title"))
                series_title =(JSONArray) booksObj.get("series_title");
            if (booksObj.has("identifier"))
                identifier =(String) booksObj.get("identifier").toString();

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
                String image_file = "";
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
                if (pagesObj.has("image_url"))
                    image_url = (String) pagesObj.get("image_url").toString();
                if (pagesObj.has("image_file"))
                    image_file = (String) pagesObj.get("image_file").toString();
                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
                    if (author!=null) {
                        sb.append(quote + "author" + quote + ":" + quote+ author   +quote+ "," + '\n');
                    }
                    if (chapter_title!=null) {
                        sb.append(quote + "chapter_title" + quote + ":" +  quote+ chapter_title  +quote + "," + '\n');
                    }
                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" + quote+ identifier+ quote + "," + '\n');
                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" + quote+ date+ quote+ "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+"," + '\n');

                    if (publication_name!=null)
                        sb.append(  quote + "publication_name" + quote + ":" + quote+ publication_name+ quote+"," + '\n');

                    if (publication_place!=null)
                        sb.append(  quote + "publication_place" + quote + ":" + quote+ publication_place+ quote+"," + '\n');

                    if (keywords!=null)
                        sb.append(  quote + "keywords" + quote + ":" +  keywords+ "," + '\n');

                    if (medium!=null)
                        sb.append(  quote + "medium" + quote + ":" +  medium+  "," + '\n');
                    if (person!=null)
                        sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');
                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');
                    if (image_file!=null)
                        sb.append(  quote + "image_file" + quote + ":" + quote+ image_file+ quote+ "," + '\n');
                    if (image_url!=null)
                        sb.append(  quote + "image_url" + quote + ":" + quote+ image_url+ quote+ "," + '\n');

                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');
                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (spatial!=null)
                        sb.append(  quote + "spatial" + quote + ":" +  spatial+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Adam Matthew - China Trade & Politics"+ quote + "" + '\n' );

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

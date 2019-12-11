package org.crossasia.collections.chnp_chinese;

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
        String books = "D:\\SOLR-COLLECTIONS\\CHNP2\\pagebook\\metadatatext.json";
        String pages = "D:\\SOLR-COLLECTIONS\\CHNP2\\pagebook\\pagetext.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\pagebook\\books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";

            JSONArray edition =null;
            String responsibility ="";
            String url ="";

            String date = "";

            String book_id = "";
            String ISBN = "";
            String title = "";


            String issued = "";


            String description = "";
            String medium = "";
            JSONArray subject = null;
            JSONArray language = null;
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray spatial = null;
            JSONArray keywords = null;
            JSONArray author = null;
            JSONArray alternative = null;
            JSONArray note = null;
            String publisher = "";
            String publication_place = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title");
            if (booksObj.has("responsibility"))
                responsibility = (String) booksObj.get("responsibility").toString();
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("language")) {
                language  = (JSONArray) booksObj.get("language");
            }
            if (booksObj.has("publisher")) {
                publisher  = (String) booksObj.get("publisher");
            }
            if (booksObj.has("description")) {
                description  = (String) booksObj.get("description");
            }
            if (booksObj.has("spatial")) {
                spatial  = (JSONArray) booksObj.get("spatial");
            }
            if (booksObj.has("series_title")) {
                series_title  = (JSONArray) booksObj.get("series_title");
            }
            if (booksObj.has("publication_place")) {
                publication_place  = (String) booksObj.get("publication_place");
            }
            if (booksObj.has("medium")) {
                medium  = (String) booksObj.get("medium");
            }
            if (booksObj.has("keywords")) {
                keywords  = (JSONArray) booksObj.get("keywords");
            }

            if (booksObj.has("creator"))
                author =(JSONArray) booksObj.get("creator");
            if (booksObj.has("alternative"))
                alternative =(JSONArray) booksObj.get("alternative");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");


            for (int j=0; j<pagesObject.length();j++) {
                String book_id_page="";
                String id ="";
                String running_title="";
                String image="";
                String chapter_title="";
                String position="";
                String page_id="";
                String text="";
                String identifier="";
                String image_file = "";
                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();
                if (pagesObj.has("running_title"))
                    running_title = (String) pagesObj.get("running_title").toString();
                if (pagesObj.has("image"))
                    image = (String) pagesObj.get("image").toString();
                if (pagesObj.has("chapter_title"))
                    chapter_title = (String) pagesObj.get("chapter_title").toString();
                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();
                if (pagesObj.has("page_id"))
                    page_id = (String) pagesObj.get("page_id").toString();
                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString().replaceAll("\"","");
                if (pagesObj.has("identifier"))
                    identifier = (String) pagesObj.get("identifier").toString();
                if (pagesObj.has("image_file"))
                    image_file = (String) pagesObj.get("image_file").toString();
                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" +  quote +identifier+ quote+ "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+"," + '\n');

                    if (publisher!=null)
                        sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+quote+ "," + '\n');

                    if (medium!=null)
                        sb.append(  quote + "medium" + quote + ":" + quote+ medium+ quote+ "," + '\n');

                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" + quote+ position+ quote+  "," + '\n');

                    if (description!=null)
                        sb.append(  quote + "description" + quote + ":" + quote+  description+ quote+ "," + '\n');

                    if (image!=null)
                        sb.append(  quote + "image" + quote + ":" + quote+  image+ quote+ "," + '\n');

                    if (image!=null)
                        sb.append(  quote + "image_url" + quote + ":" + quote+ "http://callisto.ggsrv.com/imgsrv/FastFetch/UBER2/"+ image.replace(".jpg","")+ quote+ "," + '\n');

                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');

                    if (publication_place!=null)
                        sb.append(  quote + "publication_place" + quote + ":" + quote+  publication_place+ quote+  "," + '\n');


                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" +  language+  "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Gale CFER"+ quote + "" + '\n' );

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

package org.crossasia.solr.collections.cnki;

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
        String books = "/data1/solr/CNKI/books/books.json";
        String pages = "/data1/solr/CNKI/pages/pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/CNKI/books_pages2.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";

            String edition ="";
            String responsibility ="";
            String url ="";

            String date = "";
            JSONArray identifier = null;
            String book_id = "";
            String ISBN = "";
            String title = "";


            String issued = "";


            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            String language = "";

            JSONArray person = null;
            JSONArray spatial = null;
            JSONArray keywords = null;
            JSONArray author = null;
            JSONArray alternative = null;
            String publisher = "";
            String publication_name = "";
            String erflink = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();
            if (booksObj.has("responsibility"))
                responsibility = (String) booksObj.get("responsibility").toString();
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }
            if (booksObj.has("publisher")) {
                publisher  = (String) booksObj.get("publisher");
            }
            if (booksObj.has("isbn")) {
                ISBN  = (String) booksObj.get("isbn");
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

            if (booksObj.has("creator"))
                author =(JSONArray) booksObj.get("creator");
            if (booksObj.has("alternative"))
                alternative =(JSONArray) booksObj.get("alternative");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();

            if (booksObj.has("identifier")) {
                identifier = (JSONArray) booksObj.get("identifier");
                if (identifier.get(0).toString().contains("http://")) {
                    url = identifier.get(0).toString();
                } else if (identifier.get(1).toString().contains("http://")) {
                    url = identifier.get(1).toString();
                }
            }
            String url2 = url.replace("http://","");
            erflink =  "http://erf.sbb.spk-berlin.de/han/cnki-books/"+url2;

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
                    text = (String) pagesObj.get("text").toString().replaceAll("\"","");
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
                        sb.append(quote + "author" + quote + ":" + author   + "," + '\n');
                    }

                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+"," + '\n');

                    if (ISBN!=null)
                        sb.append(  quote + "ISBN" + quote + ":" + quote+ ISBN+ quote+"," + '\n');
                    if (publisher!=null)
                        sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+ quote+"," + '\n');

                    if (keywords!=null)
                        sb.append(  quote + "keywords" + quote + ":" +  keywords+ "," + '\n');

                    if (medium!=null)
                        sb.append(  quote + "medium" + quote + ":" +  medium+  "," + '\n');
                    if (responsibility!=null)
                        sb.append(  quote + "responsibility" + quote + ":" +  quote+ responsibility+ quote+  "," + '\n');
                    if (person!=null)
                        sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');
                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');
                    
                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');
                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (spatial!=null)
                        sb.append(  quote + "spatial" + quote + ":" +  spatial+  "," + '\n');

                    if (alternative!=null)
                        sb.append(  quote + "alternative" + quote + ":" +  alternative+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "CNKI_eBooks"+ quote + "" + '\n' );

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

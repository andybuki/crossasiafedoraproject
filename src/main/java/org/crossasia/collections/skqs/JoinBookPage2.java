package org.crossasia.collections.skqs;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JoinBookPage2 {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        //String books = "/data1/solr/ajax-skqs/books.json";
        String pages = "/data1/solr/ajax-skqs/books_pages_NEW.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-skqs/books_pages.json"));

        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        //JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<pagesObject.length(); i++) {

            //String author ="";

            String publication_place ="";
            JSONArray responsibility =null;
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
            JSONArray edition = null;
            String language = "";
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray author = null;
            JSONArray creator = null;
            String erflink="";

            JSONObject pagesObj = (JSONObject) pagesObject.get(i);
            //id = (String) booksObj.get("id").toString();
            book_id = (String) pagesObj.get("book_id").toString();

            if (pagesObj.has("title"))
                title = (String) pagesObj.get("title").toString();

            if (pagesObj.has("identifier")) {
                identifier = (JSONArray) pagesObj.get("identifier");

                String ind0 = identifier.get(0).toString();
                String ind1 = identifier.get(1).toString();
                String ind2 = identifier.get(2).toString();

                if (ind0.contains("http://")) {
                    url=ind0.replace("type=\"CrossAsia Link\" ","");
                } else if (ind1.contains("http://")){
                    url=ind1.replace("type=\"CrossAsia Link\" ","");
                } else {
                    url=ind2.replace("type=\"CrossAsia Link\" ","");
                }
            }

            /*if (booksObj.has("identifier")) {
                identifier = (JSONArray) booksObj.get("identifier");

                String ind0 = identifier.get(0).toString();
                String ind1 = identifier.get(1).toString();
                String ind2 = identifier.get(2).toString();

                if (ind0.contains("Diaolong_skqs")) {
                    book_id=ind0.replace("type=\"Diaolong\" ","");
                } else if (ind1.contains("Diaolong_skqs")){
                    book_id=ind1.replace("type=\"Diaolong\" ","");
                } else {
                    book_id=ind2.replace("type=\"Diaolong\" ","");
                }
            }*/


            if (pagesObj.has("language")) {
                language  = (String) pagesObj.get("language");
            }

            if (pagesObj.has("erflink")) {
                erflink  = (String) pagesObj.get("erflink");
            }

            if (pagesObj.has("author"))
                author =(JSONArray) pagesObj.get("author");


            if (pagesObj.has("date"))
                date =(String) pagesObj.get("date").toString();

            if (pagesObj.has("issued"))
                issued = (String) pagesObj.get("issued").toString();


            if (pagesObj.has("subject"))
                subject =(JSONArray) pagesObj.get("subject");

            if (pagesObj.has("edition"))
                edition =(JSONArray) pagesObj.get("edition");

            if (pagesObj.has("responsibility"))
                responsibility =(JSONArray) pagesObj.get("responsibility");


            if (pagesObj.has("publication_place"))
                publication_place =(String) pagesObj.get("publication_place").toString();

            if (pagesObj.has("url"))
                url =(String) pagesObj.get("url");


            //for (int j=0; j<pagesObject.length();j++) {
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
                //JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                //id = (String) pagesObj.get("id").toString();

                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString();

                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();

                if (pagesObj.has("page_id"))
                    page_id = (String) pagesObj.get("page_id").toString();

                if (pagesObj.has("chapter_title"))
                    chapter_title = (String) pagesObj.get("chapter_title").toString();

                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id.replace(".xml","").replace("/","_")+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

                    if (author!=null) {
                        sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
                    }

                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" + identifier+  "," + '\n');
                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" +  date+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + title+ "," + '\n');

                    if (edition!=null)
                        sb.append(  quote + "edition" + quote + ":" + edition+ "," + '\n');


                    if (url!=null)
                        sb.append(  quote + "url" + quote + ":" + quote + url+ quote + "," + '\n');

                    if (erflink!=null)
                        sb.append(  quote + "erflink" + quote + ":" + quote + erflink+ quote + "," + '\n');

                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');

                    if (publication_place!=null)
                        sb.append(  quote + "publication_place" + quote + ":" +  publication_place+  "," + '\n');

                    if (chapter_title!=null)
                        sb.append(  quote + "chapter_title" + quote + ":" + quote+ chapter_title+ quote+ "," + '\n');

                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');

                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (responsibility!=null)
                        sb.append(  quote + "responsibility" + quote + ":" +  responsibility+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Siku quanshu"+ quote + "" + '\n' );

                    sb.append("},");
                }else {
                    //System.out.println("NO: "+book_id);
                }
                //System.out.println(booksObj);
          //  }
            System.out.println("NO: "+book_id);
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

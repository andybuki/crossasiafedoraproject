package org.crossasia.collections.gale;

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
        String books = "/data1/solr/ajax-gale-cfer2/books2.json";
        String pages = "/data1/solr/ajax-gale-cfer2/books_pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-gale-cfer2/books_pages2.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";


            String url ="";
            String erflink = "";
            String book_id = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();


            for (int j=0; j<pagesObject.length();j++) {
                String publisher = "";
                String book_id_page="";
                String id ="";
                String identifier="";
                String running_title="";
                String volume="";
                String chapter_title="";
                String position="";
                String page_id="";
                String text="";
                String image_url="";
                String image="";
                String image_file = "";
                String title = "";
                String edition ="";
                String responsibility ="";
                String date = "";


                String ISBN = "";


                String issued = "";


                String description = "";
                String medium = "";
                JSONArray subject = null;
                String language = "";

                JSONArray person = null;
                JSONArray spatial = null;
                JSONArray keywords = null;
                JSONArray author = null;
                JSONArray alternative = null;

                String publication_place = "";


                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();
                if (pagesObj.has("running_title"))
                    running_title = (String) pagesObj.get("running_title").toString();
                if (pagesObj.has("volume"))
                    volume = (String) pagesObj.get("volume").toString();

                if (pagesObj.has("title"))
                    title = (String) pagesObj.get("title").toString();

                if (pagesObj.has("identifier"))
                    identifier = (String) pagesObj.get("identifier").toString();


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
                if (pagesObj.has("image"))
                    image = (String) pagesObj.get("image").toString();
                if (pagesObj.has("image_file"))
                    image_file = (String) pagesObj.get("image_file").toString();
                if (pagesObj.has("publisher"))
                    publisher = (String) pagesObj.get("publisher").toString();

                if (pagesObj.has("medium"))
                    medium = (String) pagesObj.get("medium").toString();

                if (pagesObj.has("date"))
                    date = (String) pagesObj.get("date").toString();

                if (pagesObj.has("description"))
                    description = (String) pagesObj.get("description").toString();

                if (pagesObj.has("publication_place"))
                    publication_place = (String) pagesObj.get("publication_place").toString();

                if (pagesObj.has("language"))
                    language = (String) pagesObj.get("language").toString();

                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+"," + '\n');

                    if (publisher!=null)
                        sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+ quote+"," + '\n');

                    if (medium!=null)
                        sb.append(  quote + "medium" + quote + ":" +  quote+medium+ quote+ "," + '\n');

                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" +  quote+date+ quote+ "," + '\n');

                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" + quote+ position+ quote+ "," + '\n');

                    if (description!=null)
                        sb.append(  quote + "description" + quote + ":" + quote+ description+ quote+ "," + '\n');

                    if (image!=null)
                        sb.append(  quote + "image" + quote + ":" + quote+ image+ quote+"," + '\n');

                    if (image_url!=null)
                        sb.append(  quote + "image_url" + quote + ":" + quote+ image_url+ quote+"," + '\n');

                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');

                    if (publication_place!=null)
                        sb.append(  quote + "publication_place" + quote + ":" +quote+  publication_place+ quote+  "," + '\n');

                    if (url!=null)
                        sb.append(  quote + "url" + quote + ":" +quote+  url+ quote+  "," + '\n');

                    if (erflink!=null)
                        sb.append(  quote + "erflink" + quote + ":" +quote+  erflink+ quote+  "," + '\n');


                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "China and the Modern World: Records of the Maritime Customs Service of China (1854-1949)"+ quote + "" + '\n' );

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

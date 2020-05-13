package org.crossasia.collections.diaolong_yldd;

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
        String books = "/data1/solr/ajax-diaolong-yldd/books_new.json";
        String pages = "/data1/solr/ajax-diaolong-yldd/pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-diaolong-yldd/books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";

            JSONArray edition =null;
            String responsibility ="";
            String url ="";

            String date = "";
            JSONArray identifier = null;
            String book_id = "";
            String ISBN = "";
            JSONArray title = null;


            String issued = "";

            String erflink ="";
            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            JSONArray language = null;
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray spatial = null;
            JSONArray keywords = null;
            JSONArray author = null;
            JSONArray alternative = null;
            JSONArray note = null;
            JSONArray publisher = null;
            String publication_name = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("title"))
                title = (JSONArray) booksObj.get("title");
            if (booksObj.has("responsibility"))
                responsibility = (String) booksObj.get("responsibility").toString();
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("language")) {
                language  = (JSONArray) booksObj.get("language");
            }
            if (booksObj.has("publisher")) {
                publisher  = (JSONArray) booksObj.get("publisher");
            }
            if (booksObj.has("isbn")) {
                ISBN  = (String) booksObj.get("isbn");
            }

            if (booksObj.has("url")) {
                url  = (String) booksObj.get("url");
            }

            if (booksObj.has("erflink")) {
                erflink  = (String) booksObj.get("erflink");
            }

            if (booksObj.has("spatial")) {
                spatial  = (JSONArray) booksObj.get("spatial");
            }
            if (booksObj.has("series_title")) {
                series_title  = (JSONArray) booksObj.get("series_title");
            }
            if (booksObj.has("note")) {
                note  = (JSONArray) booksObj.get("note");
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
                edition =(JSONArray) booksObj.get("edition");

            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");

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
                if (pagesObj.has("xml_file"))
                    xml_file = (String) pagesObj.get("xml_file").toString();
                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id.replace(".xml","").replace("/","_").replace("YongLeDaDian-","")+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
                    if (author!=null) {
                        sb.append(quote + "author" + quote + ":" + author   + "," + '\n');
                    }

                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

                    if (series_title!=null)
                        sb.append(  quote + "series_title" + quote + ":" +  series_title+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" +  title+"," + '\n');
                    if (xml_file!="")
                        sb.append(  quote + "xml_file" + quote + ":" +  quote+xml_file+quote+"," + '\n');

                    if (publisher!=null)
                        sb.append(  quote + "publisher" + quote + ":" +  publisher+ "," + '\n');
                    if (chapter_title!="")
                        sb.append(  quote + "chapter_title" + quote + ":" + quote+ chapter_title+ quote+"," + '\n');

                    if (keywords!=null)
                        sb.append(  quote + "keywords" + quote + ":" +  keywords+ "," + '\n');

                    if (medium!=null)
                        sb.append(  quote + "medium" + quote + ":" +  medium+  "," + '\n');
                    if (edition!=null)
                        sb.append(  quote + "edition" + quote + ":" +  edition+  "," + '\n');
                    if (responsibility!=null)
                        //sb.append(  quote + "responsibility" + quote + ":" +  quote+ responsibility+ quote+  "," + '\n');
                    if (person!=null)
                        sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');
                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');

                    if (note!=null)
                        sb.append(  quote + "note" + quote + ":" +  note+  "," + '\n');
                    
                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');

                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" +  date+   "," + '\n');

                    if (url!=null)
                        sb.append(  quote + "url" + quote + ":" +quote+  url+ quote+  "," + '\n');

                    if (erflink!=null)
                        sb.append(  quote + "erflink" + quote + ":" +quote+  erflink+ quote+  "," + '\n');

                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (spatial!=null)
                        sb.append(  quote + "spatial" + quote + ":" +  spatial+  "," + '\n');

                    if (alternative!=null)
                        sb.append(  quote + "alternative" + quote + ":" +  alternative+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" +  language+  "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Yongle dadian"+ quote + "" + '\n' );

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

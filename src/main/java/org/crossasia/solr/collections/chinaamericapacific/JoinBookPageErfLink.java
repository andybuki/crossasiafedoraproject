package org.crossasia.solr.collections.chinaamericapacific;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JoinBookPageErfLink {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ChinaAmericaPacific/books_pages.json";
        //String pages = "D:\\SOLR-COLLECTIONS\\China_America_Pacific\\pages\\pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ChinaAmericaPacific/books_pages3.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        //JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String author ="";
            String id ="";
            String edition ="";
            String responsibility ="";


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
            JSONArray language = null;
            JSONArray series_title = null;
            JSONArray person = null;
            JSONArray spatial = null;

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();

            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();

            if (booksObj.has("language")) {
                language  = (JSONArray) booksObj.get("language");
            }
            JSONArray keywords  = (JSONArray) booksObj.get("keywords");

            if (booksObj.has("author"))
                author =(String) booksObj.get("author").toString();

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();
            
            if (booksObj.has("spatial"))
                spatial =(JSONArray) booksObj.get("spatial");
            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();
            if (booksObj.has("responsibility"))
                responsibility =(String) booksObj.get("responsibility").toString();
            if (booksObj.has("identifier"))
                identifier =(String) booksObj.get("identifier").toString();

            String running_title="";
            String volume="";
            String chapter_title="";
            String position="";
            String page_id="";
            String text="";
            String url="";
            String erflink="http://erf.sbb.spk-berlin.de/han/ChinaAmericaPacific/";
            String image_file = "";

            if (booksObj.has("running_title"))
                running_title = (String) booksObj.get("running_title").toString();
            if (booksObj.has("volume"))
                volume = (String) booksObj.get("volume").toString();
            if (booksObj.has("chapter_title"))
                chapter_title = (String) booksObj.get("chapter_title").toString();
            if (booksObj.has("position"))
                position = (String) booksObj.get("position").toString();
            if (booksObj.has("page_id"))
                page_id = (String) booksObj.get("page_id").toString();
            if (booksObj.has("text"))
                text = (String) booksObj.get("text").toString();
            if (booksObj.has("url"))
                url = (String) booksObj.get("url").toString();
                String url2 = url.replace("http://","");
                erflink = erflink+url2;
            if (booksObj.has("image_file"))
                image_file = (String) booksObj.get("image_file").toString();


                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
                    if (issued!=null) {
                        sb.append(quote + "issued" + quote + ":" + quote + issued + quote + "," + '\n');
                    }
                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" + quote+ date+ quote + "," + '\n');
                    if (keywords!=null)
                        sb.append(  quote + "keywords" + quote + ":" +  keywords+  "," + '\n');
                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + quote+ title+ quote+ "," + '\n');
                    if (spatial!=null)
                        sb.append(  quote + "spatial" + quote + ":" +  spatial+ "," + '\n');
                    if (edition!=null)
                        sb.append(  quote + "edition" + quote + ":" +  edition+  "," + '\n');
                    if (person!=null)
                        sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');
                    if (position!=null)
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');
                    if (image_file!=null)
                        sb.append(  quote + "image_file" + quote + ":" + quote+ image_file+ quote+ "," + '\n');
                    if (url!=null)
                        sb.append(  quote + "url" + quote + ":" + quote+ url+ quote+ "," + '\n');
                    if (erflink!=null)
                        sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote+ "," + '\n');
                    if (text!=null)
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');
                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" +  language+  "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Adam Matthew - China America Pacific"+ quote + "" + '\n' );

                    sb.append("},");

                //System.out.println(booksObj);

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

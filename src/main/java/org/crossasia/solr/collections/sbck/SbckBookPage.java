package org.crossasia.solr.collections.sbck;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SbckBookPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data/solr/ajax-sbck/books2.json";
        String pages = "/data/solr/ajax-sbck/pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-sbck/books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";

            JSONArray bibliographicCitation =null;
            JSONArray author = null;
            JSONArray creatorTranscription = null;
            JSONArray edition =null;

            JSONArray identifier = null;
            JSONArray date = null;
            String book_id = "";
            JSONArray language = null;
            JSONArray note = null;
            JSONArray publisher = null;
            JSONArray series_title = null;
            JSONArray subject = null;
            JSONArray temporal = null;
            String thumbnail_path ="";
            JSONArray title = null;
            JSONArray title_transcription = null;
            String url ="";
            String erflink ="";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            //id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("title"))
                title = (JSONArray) booksObj.get("title");

            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");

            if (booksObj.has("language"))
                language  = (JSONArray) booksObj.get("language");

            if (booksObj.has("bibliographic_citation"))
                bibliographicCitation =(JSONArray) booksObj.get("bibliographic_citation");

            if (booksObj.has("creator"))
                author =(JSONArray) booksObj.get("creator");

            if (booksObj.has("creator_transcription"))
                creatorTranscription =(JSONArray) booksObj.get("creator_transcription");

            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");

            if (booksObj.has("note")) {
                note  = (JSONArray) booksObj.get("note");
            }

            if (booksObj.has("publisher")) {
                publisher  = (JSONArray) booksObj.get("publisher");
            }

            if (booksObj.has("series_title")) {
                series_title  = (JSONArray) booksObj.get("series_title");
            }

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("temporal"))
                temporal =(JSONArray) booksObj.get("temporal");

            if (booksObj.has("thumbnail_path"))
                thumbnail_path = (String) booksObj.get("thumbnail_path");

            if (booksObj.has("title"))
                title = (JSONArray) booksObj.get("title");

            if (booksObj.has("title_transcription"))
                title_transcription = (JSONArray) booksObj.get("title_transcription");

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");

            if (booksObj.has("date"))
                date =(JSONArray) booksObj.get("date");

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("url"))
                url =(String) booksObj.get("url");

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink");

            for (int j=0; j<pagesObject.length();j++) {
                String book_id_page="";
                String id ="";
                String chapter_title="";
                String position="";
                String text="";
                String xml_file = "";
                JSONObject pagesObj = (JSONObject) pagesObject.get(j);
                id = (String) pagesObj.get("id").toString();

                if (pagesObj.has("text"))
                    text = (String) pagesObj.get("text").toString();

                if (pagesObj.has("chapter_title"))
                    chapter_title = (String) pagesObj.get("chapter_title").toString();

                if (pagesObj.has("xml_file"))
                    xml_file = (String) pagesObj.get("xml_file").toString();

                if (pagesObj.has("position"))
                    position = (String) pagesObj.get("position").toString();

                book_id_page = (String) pagesObj.get("book_id").toString();


                if (book_id.equals(book_id_page)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

                    if (author!=null) {
                        sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
                    }

                    if (edition!=null)
                        sb.append(  quote + "edition" + quote + ":" +  edition+ "," + '\n');

                    if (publisher!=null)
                        sb.append(  quote + "publisher" + quote + ":" +  publisher+ "," + '\n');

                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" +  date+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + title+ "," + '\n');

                    if (url!="")
                        sb.append(  quote + "url" + quote + ":" + quote+ url+ quote+  "," + '\n');

                    if (erflink!="")
                        sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote+  "," + '\n');

                    if (position!="")
                        sb.append(  quote + "position" + quote + ":" +  position+  "," + '\n');

                    if (text!="")
                        sb.append(  quote + "text" + quote + ":" +quote+  text+ quote+  "," + '\n');

                    if (chapter_title!="")
                    sb.append(  quote + "chapter_title" + quote + ":" +quote+  chapter_title+ quote+  "," + '\n');

                    if (xml_file!="")
                    sb.append(  quote + "xml_file" + quote + ":" +quote+  xml_file+ quote+  "," + '\n');

                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" +  language+  "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+ "Sibu congkan"+ quote + "" + '\n' );

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

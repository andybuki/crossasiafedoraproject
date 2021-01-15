package org.crossasia.collections.sbck;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SbckBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-sbck/books2.json"));
        String books = "/data/solr/ajax-sbck/books.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            JSONArray bibliographicCitation =null;
            JSONArray author = null;
            JSONArray creatorTranscription = null;
            JSONArray edition =null;
            JSONArray responsibility =null;
            String id ="";
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

            if (booksObj.has("bibliographic_citation"))
                bibliographicCitation =(JSONArray) booksObj.get("bibliographic_citation");

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");

            if (booksObj.has("responsibility"))
                responsibility =(JSONArray) booksObj.get("responsibility");

            if (booksObj.has("creator_transcription"))
                creatorTranscription =(JSONArray) booksObj.get("creator_transcription");

            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");

            id = (String) booksObj.get("id").toString();

            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");

            if (booksObj.has("issued")) {
                date  = (JSONArray) booksObj.get("issued");
            }

            if (booksObj.has("identifier")) {
                identifier = (JSONArray) booksObj.get("identifier");
                if (identifier.get(0).toString().contains("type=\"Diaolong\"")){
                    book_id = identifier.get(0).toString().replace("type=\"Diaolong\" ","");
                } else if (identifier.get(1).toString().contains("type=\"Diaolong\"")) {
                    book_id = identifier.get(1).toString().replace("type=\"Diaolong\" ","");
                } else {
                    book_id = identifier.get(2).toString().replace("type=\"Diaolong\" ","");
                }

                if (identifier.get(0).toString().startsWith("http")){
                    url = identifier.get(0).toString();
                } else if (identifier.get(1).toString().startsWith("http")) {
                    url = identifier.get(1).toString();
                } else {
                    url = identifier.get(2).toString();
                }

                if (identifier.get(0).toString().contains("type=\"CrossAsia Link\"")){
                    erflink = identifier.get(0).toString().replace("type=\"CrossAsia Link\" ","");
                } else if (identifier.get(1).toString().contains("type=\"CrossAsia Link\"")) {
                    erflink = identifier.get(1).toString().replace("type=\"CrossAsia Link\" ","");
                } else {
                    erflink = identifier.get(2).toString().replace("type=\"CrossAsia Link\" ","");
                }

            }

            if (booksObj.has("language")) {
                language  = (JSONArray) booksObj.get("language");
            }

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

            String book="Book";
            String collection ="Sibu congkan";


            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (bibliographicCitation!=null)
                sb.append(  quote + "bibliographicCitation" + quote + ":" +  bibliographicCitation+  "," + '\n');
            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +  author+ "," + '\n');
            if (creatorTranscription!=null)
                sb.append(  quote + "creator_transcription" + quote + ":" +  creatorTranscription+ "," + '\n');

            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" +  edition+ "," + '\n');

            if (responsibility!=null)
                sb.append(  quote + "responsibility" + quote + ":" +  responsibility+ "," + '\n');

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

            if (date!=null)
                sb.append(  quote + "date" + quote + ":" + date+ "," + '\n');

            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );

            if (language!=null)
                sb.append(  quote + "language" + quote + ":" + language + "," + '\n');

            if (note!=null)
                sb.append(  quote + "note" + quote + ":" + note + "," + '\n');

            if (publisher!=null)
                sb.append(  quote + "publisher" + quote + ":" +  publisher+ "," + '\n');

            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" +  series_title+ "," + '\n');
            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" + subject+  "," + '\n');
            if (temporal!=null)
                sb.append(  quote + "temporal" + quote + ":" + temporal+  "," + '\n');
            if (thumbnail_path!="")
                sb.append(  quote + "thumbnail_path" + quote + ":" + quote+ thumbnail_path+ quote + "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" +  title+ "," + '\n');
            if (title_transcription!=null)
                sb.append(  quote + "title_transcription" + quote + ":" +  title_transcription+ "," + '\n');


            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ collection+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

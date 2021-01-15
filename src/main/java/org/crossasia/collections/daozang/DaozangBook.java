package org.crossasia.collections.daozang;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class DaozangBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-daozang/booksNew.json"));
        String books = "/data/solr/ajax-daozang/books.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            JSONArray title = null;
            JSONArray identifier = null;
            String issued ="";
            JSONArray date =null;
            JSONArray note =null;
            JSONArray creator =null;
            JSONArray edition =null;
            JSONArray subject =null;
            JSONArray series_title =null;
            JSONArray creator_transcription =null;
            String medium ="";

            String publicationName ="";
            String publicationVolume ="";
            JSONArray description = null;
            JSONArray bibliographicCitation=null;
            JSONArray title_transcription=null;

            String DOI = "";
            String url ="";
            String dc_description ="";
            String erflink ="";
            String book_id = "";
            String thumbnail_path = "";
            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("bibliographicCitation"))
                bibliographicCitation =(JSONArray) booksObj.get("bibliographicCitation");

            id = (String) booksObj.get("id").toString();

            if (booksObj.has("identifier")) {
                identifier = (JSONArray) booksObj.get("identifier");

                if (identifier.get(0).toString().startsWith("type=\"Diaolong\" ")){
                    book_id =identifier.get(0).toString().replace("type=\"Diaolong\" ","");
                } else if (identifier.get(1).toString().startsWith("type=\"Diaolong\" ")) {
                    book_id =identifier.get(1).toString().replace("type=\"Diaolong\" ","");
                } else {
                    book_id =identifier.get(2).toString().replace("type=\"Diaolong\" ","");
                }
                if (identifier.get(0).toString().startsWith("http")){
                    url =identifier.get(0).toString();
                } else if (identifier.get(1).toString().startsWith("http")) {
                    url =identifier.get(1).toString();
                } else {
                    url =identifier.get(2).toString();
                }
                if (identifier.get(0).toString().startsWith("type=\"CrossAsia Link\" ")){
                    erflink =identifier.get(0).toString().replace("type=\"CrossAsia Link\" ","");
                } else if (identifier.get(1).toString().startsWith("type=\"CrossAsia Link\" ")) {
                    erflink =identifier.get(1).toString().replace("type=\"CrossAsia Link\" ","");
                } else {
                    erflink =identifier.get(2).toString().replace("type=\"CrossAsia Link\" ","");
                }
            }



            if (booksObj.has("creator")) {
                creator  = (JSONArray) booksObj.get("creator");
            }

            if (booksObj.has("title_transcription")) {
                title_transcription  = (JSONArray) booksObj.get("title_transcription");
            }

            if (booksObj.has("thumbnail_path")) {
                thumbnail_path  = (String) booksObj.get("thumbnail_path");
            }

            if (booksObj.has("note")) {
                note  = (JSONArray) booksObj.get("note");
            }
            if (booksObj.has("series_title")) {
                series_title  = (JSONArray) booksObj.get("series_title");
            }
            if (booksObj.has("edition")) {
                edition  = (JSONArray) booksObj.get("edition");
            }

            if (booksObj.has("creator_transcription")) {
                creator_transcription  = (JSONArray) booksObj.get("creator_transcription");
            }

            if (booksObj.has("date")) {
                date  = (JSONArray) booksObj.get("date");
            }

            if (booksObj.has("title"))
                title = (JSONArray) booksObj.get("title");

            if (booksObj.has("subject"))
                subject = (JSONArray) booksObj.get("subject");

            if (booksObj.has("medium"))
                medium = (String) booksObj.get("medium");

            if (booksObj.has("dc_description"))
                dc_description = (String) booksObj.get("dc_description");

            if (booksObj.has("publicationName"))
                publicationName = (String) booksObj.get("publicationName");

            if (booksObj.has("publicationVolume"))
                publicationVolume = (String) booksObj.get("publicationVolume");

            if (booksObj.has("description"))
                description = (JSONArray) booksObj.get("description");

            if (booksObj.has("DOI"))
                DOI = (String) booksObj.get("DOI");

            if (booksObj.has("url"))
                url = (String) booksObj.get("url");

            if (booksObj.has("url_erf"))
                erflink = (String) booksObj.get("url_erf");

            String book="Book";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (bibliographicCitation!=null)
                sb.append(  quote + "bibliographicCitation" + quote + ":" +   bibliographicCitation+  "," + '\n');

            if (creator!=null)
                sb.append(  quote + "creator" + quote + ":" +   creator+  "," + '\n');

            if (creator_transcription!=null)
                sb.append(  quote + "creator_transcription" + quote + ":" +   creator_transcription+  "," + '\n');

            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" +   edition+  "," + '\n');

            if (description!=null)
                sb.append(  quote + "description" + quote + ":" +   description+  "," + '\n');

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +   identifier+   "," + '\n');

            if (date!=null)
                sb.append(  quote + "date" + quote + ":" +  date+ "," + '\n');

            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" +  series_title+  "," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

            if (thumbnail_path!="")
                sb.append(  quote + "thumbnail_path" + quote + ":" + quote+ thumbnail_path+ quote+ "," + '\n');

            if (note!=null)
                sb.append(  quote + "note" + quote + ":" +  note+  "," + '\n');


            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" +    title+  "," + '\n');

            if (title_transcription!=null)
                sb.append(  quote + "title_transcription" + quote + ":" +    title_transcription+  "," + '\n');

            sb.append(  quote + "language" + quote + ":" +   quote+ "chi"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "Zhengtong Daozang"+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

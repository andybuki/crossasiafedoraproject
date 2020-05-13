package org.crossasia.collections.diaolong_yldd;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BookChange {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ajax-diaolong-yldd/books.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-diaolong-yldd/books_new.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String url ="";
            String erflink = "";
            String book_id = "";
            String books_id = "";
            String collection = "";
            JSONArray title = null;
            String date = "";
            JSONArray temporal = null;
            JSONArray note = null;
            JSONArray series_title = null;
            JSONArray subject = null;
            JSONArray creator = null;
            JSONArray title_transcription = null;
            JSONArray creator_transcription = null;
            JSONArray edition = null;
            JSONArray language = null;
            String description = "";
            String id = "";
            String source = "";
            String issued = "";
            String startDate = "";
            String endDate = "";
            String publication_name = "";
            String issue = "";
            String location = "";
            String  thumbnail_path= "";
            JSONArray bibliographicCitation = null;
            String publication_volume = "";
            String doi = "";
            JSONArray identifier = null;


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            /*book_id = (String) booksObj.get("source").toString();
            String segments[] = book_id.split("/");

            if (segments.length==3) {
                book_id = (segments[segments.length - 2]) +"_"+(segments[segments.length - 1]);
            } else if (segments.length==2) {
                book_id = (segments[segments.length - 2]) +"_"+(segments[segments.length - 1]);
            } else if (segments.length==4) {
                book_id = (segments[segments.length - 3]) +"_"+(segments[segments.length - 2])+"_"+(segments[segments.length - 1]);
            }
            else {
                System.out.println("Length is not right: "+ book_id);
            }*/


            //book_id = segments[segments.length - 1];

            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();

            if (booksObj.has("collection"))
                collection =(String) booksObj.get("collection").toString();

            if (booksObj.has("thumbnail_path"))
                thumbnail_path =(String) booksObj.get("thumbnail_path").toString();

            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");

            if (booksObj.has("note"))
                note =(JSONArray) booksObj.get("note");

            if (booksObj.has("series_title"))
                series_title =(JSONArray) booksObj.get("series_title");

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("temporal"))
                temporal =(JSONArray) booksObj.get("temporal");

            if (booksObj.has("creator"))
                creator =(JSONArray) booksObj.get("creator");

            if (booksObj.has("title_transcription"))
                title_transcription =(JSONArray) booksObj.get("title_transcription");

            if (booksObj.has("creator_transcription"))
                creator_transcription =(JSONArray) booksObj.get("creator_transcription");

            if (booksObj.has("location"))
                location =(String) booksObj.get("location").toString();

            if (booksObj.has("title"))
                title =(JSONArray) booksObj.get("title");

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("identifier")) {
                identifier = (JSONArray) booksObj.get("identifier");
                if (identifier.get(0).toString().contains("Diaolong")) {
                    book_id = identifier.get(0).toString().replace("type=\"Diaolong\" ","");
                }else if (identifier.get(1).toString().contains("Diaolong")) {
                    book_id = identifier.get(1).toString().replace("type=\"Diaolong\" ","");
                }else if (identifier.get(2).toString().contains("Diaolong")) {
                    book_id = identifier.get(2).toString().replace("type=\"Diaolong\" ","");
                }

                if (identifier.get(0).toString().contains("CrossAsia Link")) {
                    erflink = identifier.get(0).toString().replace("type=\"CrossAsia Link\" ","");
                    //url = erflink.replace("http://erf.sbb.spk-berlin.de/han/xusibucongkan","http://");
                }else if (identifier.get(1).toString().contains("CrossAsia Link")) {
                    erflink = identifier.get(1).toString().replace("type=\"CrossAsia Link\" ","");
                    //url = erflink.replace("http://erf.sbb.spk-berlin.de/han/xusibucongkan","http://");
                }else if (identifier.get(2).toString().contains("CrossAsia Link")) {
                    erflink = identifier.get(2).toString().replace("type=\"CrossAsia Link\" ","");
                    //url = erflink.replace("http://erf.sbb.spk-berlin.de/han/xusibucongkan","http://");
                }

                if (identifier.get(0).toString().startsWith("http")){
                    url = (String) identifier.get(0);
                } else if (identifier.get(1).toString().startsWith("http")){
                    url = (String) identifier.get(1);
                } else {
                    url = (String) identifier.get(2);
                }

            }

            if (booksObj.has("source"))
                source =(String) booksObj.get("source").toString();

            if (booksObj.has("bibliographic_citation"))
                bibliographicCitation =(JSONArray) booksObj.get("bibliographic_citation");

            if (booksObj.has("publication_name"))
                publication_name =(String) booksObj.get("publication_name").toString();

            if (booksObj.has("publication_volume"))
                publication_volume =(String) booksObj.get("publication_volume").toString();

            if (booksObj.has("language"))
                language =(JSONArray) booksObj.get("language");

            if (booksObj.has("doi"))
                doi =(String) booksObj.get("doi").toString();

            if (booksObj.has("issued"))
                issued =(String) booksObj.get("issued").toString();

            if (booksObj.has("issue"))
                issue =(String) booksObj.get("issue").toString();

            if (booksObj.has("startDate"))
                startDate =(String) booksObj.get("startDate").toString();

            if (booksObj.has("endDate"))
                endDate =(String) booksObj.get("endDate").toString();

            if (booksObj.has("description"))
                description =(String) booksObj.get("description").toString();



            sb.append("{" + '\n');
            sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
            sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');


            if (title != null)
                sb.append(quote + "title" + quote + ":" +  title +  "," + '\n');

            if (bibliographicCitation != null)
                sb.append(quote + "bibliographicCitation" + quote + ":" +  bibliographicCitation +  "," + '\n');

            if (source != "")
                sb.append(quote + "source" + quote + ":" + quote + source + quote + "," + '\n');

            if (date != "")
                sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');

            if (identifier != null)
                sb.append(quote + "identifier" + quote + ":" +  identifier +  "," + '\n');

            if (description != "")
                sb.append(quote + "description" + quote + ":" + quote + description + quote + "," + '\n');

            if (url != "")
                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

            if (thumbnail_path != "")
                sb.append(quote + "thumbnail_path" + quote + ":" + quote + thumbnail_path + quote + "," + '\n');

            if (edition != null)
                sb.append(quote + "edition" + quote + ":" +  edition +  "," + '\n');

            if (note != null)
                sb.append(quote + "note" + quote + ":" +  note +  "," + '\n');

            if (subject != null)
                sb.append(quote + "subject" + quote + ":" +  subject +  "," + '\n');

            if (temporal != null)
                sb.append(quote + "temporal" + quote + ":" +  temporal +  "," + '\n');

            if (title_transcription != null)
                sb.append(quote + "title_transcription" + quote + ":" +  title_transcription +  "," + '\n');

            if (creator != null)
                sb.append(quote + "creator" + quote + ":" +  creator +  "," + '\n');

            if (series_title != null)
                sb.append(quote + "series_title" + quote + ":" +  series_title +  "," + '\n');

            if (creator_transcription != null)
                sb.append(quote + "creator_transcription" + quote + ":" +  creator_transcription +  "," + '\n');

            if (doi != "")
                sb.append(quote + "doi" + quote + ":" + quote + doi + quote + "," + '\n');

            if (location != "")
                sb.append(quote + "location" + quote + ":" + quote + location + quote + "," + '\n');

            if (erflink != "")
                sb.append(quote + "erflink" + quote + ":" + quote + erflink + quote + "," + '\n');

            if (language != null)
                sb.append(quote + "language" + quote + ":" +  language + "," + '\n');

            if (issue != "")
                sb.append(quote + "issue" + quote + ":" + quote + issue + quote + "," + '\n');

            if (issued != "")
                sb.append(quote + "date" + quote + ":" +  issued +  "," + '\n');

            if (startDate != "")
                sb.append(quote + "startDate" + quote + ":" + quote + startDate + quote + "," + '\n');

            if (endDate != "")
                sb.append(quote + "endDate" + quote + ":" + quote + endDate + quote + "," + '\n');

            if (publication_name != "")
                sb.append(quote + "publication_name" + quote + ":" + quote + publication_name + quote + "," + '\n');

            if (publication_volume != "")
                sb.append(quote + "publication_volume" + quote + ":" + quote + publication_volume + quote + "," + '\n');

            //sb.append(quote + "hasModel" + quote + ":" + "[" + quote + "Book" + "," + "Issue" + quote + "]" + "," + '\n');
            sb.append(quote + "hasModel" + quote + ":" +  quote + "Book" +  quote +  "," + '\n');
            sb.append(quote + "collection" + quote + ":" + quote +  "Yongle dadian" +quote + '\n');

            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

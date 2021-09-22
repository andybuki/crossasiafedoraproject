package org.crossasia.solr.collections.brill_meao;

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
        String books = "/data1/solr/ajax-brill-meao/books.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-brill-meao/books3.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String url ="";
            String erflink = "";
            String book_id = "";
            String collection = "";
            String title = "";
            String date = "";
            String language = "";
            String description = "";
            String id = "";
            String source = "";
            String issued = "";
            String startDate = "";
            String endDate = "";
            String publication_name = "";
            String issue = "";
            String location = "";
            String bibliographicCitation = "";
            String publication_volume = "";
            String doi = "";
            String identifier = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("source").toString();
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
            }


            //book_id = segments[segments.length - 1];

            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();

            if (booksObj.has("collection"))
                collection =(String) booksObj.get("collection").toString();

            if (booksObj.has("location"))
                location =(String) booksObj.get("location").toString();

            if (booksObj.has("title"))
                title =(String) booksObj.get("title").toString();

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("identifier"))
                identifier =(String) booksObj.get("identifier").toString();

            if (booksObj.has("source"))
                source =(String) booksObj.get("source").toString();

            if (booksObj.has("bibliographicCitation"))
                bibliographicCitation =(String) booksObj.get("bibliographicCitation").toString();

            if (booksObj.has("publication_name"))
                publication_name =(String) booksObj.get("publication_name").toString();

            if (booksObj.has("publication_volume"))
                publication_volume =(String) booksObj.get("publication_volume").toString();

            if (booksObj.has("language"))
                language =(String) booksObj.get("language").toString();

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


            if (title != "")
                sb.append(quote + "title" + quote + ":" + quote + title + quote + "," + '\n');

            if (bibliographicCitation != "")
                sb.append(quote + "bibliographicCitation" + quote + ":" + quote + bibliographicCitation + quote + "," + '\n');

            if (source != "")
                sb.append(quote + "source" + quote + ":" + quote + source + quote + "," + '\n');

            if (date != "")
                sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');

            if (identifier != "")
                sb.append(quote + "identifier" + quote + ":" + quote + identifier + quote + "," + '\n');

            if (description != "")
                sb.append(quote + "description" + quote + ":" + quote + description + quote + "," + '\n');

            if (url != "")
                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

            if (doi != "")
                sb.append(quote + "doi" + quote + ":" + quote + doi + quote + "," + '\n');

            if (location != "")
                sb.append(quote + "location" + quote + ":" + quote + location + quote + "," + '\n');

            if (erflink != "")
                sb.append(quote + "erflink" + quote + ":" + quote + erflink + quote + "," + '\n');

            if (language != "")
                sb.append(quote + "language" + quote + ":" + quote + language + quote + "," + '\n');

            if (issue != "")
                sb.append(quote + "issue" + quote + ":" + quote + issue + quote + "," + '\n');

            if (issued != "")
                sb.append(quote + "issued" + quote + ":" + quote + issued + quote + "," + '\n');

            if (startDate != "")
                sb.append(quote + "startDate" + quote + ":" + quote + startDate + quote + "," + '\n');

            if (endDate != "")
                sb.append(quote + "endDate" + quote + ":" + quote + endDate + quote + "," + '\n');

            if (publication_name != "")
                sb.append(quote + "publication_name" + quote + ":" + quote + publication_name + quote + "," + '\n');

            if (publication_volume != "")
                sb.append(quote + "publication_volume" + quote + ":" + quote + publication_volume + quote + "," + '\n');

            sb.append(quote + "hasModel" + quote + ":" + "[" + quote + "Book" + "," + "Issue" + quote + "]" + "," + '\n');
            sb.append(quote + "collection" + quote + ":" + quote + collection + quote + "" + '\n');

            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

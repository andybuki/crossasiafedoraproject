package org.crossasia.collections.brill_csmo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CsmoBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-brill-csmo/books2.json"));
        String books = "/data/solr/ajax-brill-csmo/booksNew.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            String title = "";
            String identifier = "";
            String issued ="";
            String issue ="";
            String date ="";
            String medium ="";
            String subject ="";
            String publication_name ="";
            String file_location ="";
            String publication_volume ="";
            String description = "";
            String bibliographicCitation="";
            String DOI = "";
            String url ="";
            String dc_description ="";
            String erflink ="";
            String book_id = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("bibliographicCitation"))
                bibliographicCitation =(String) booksObj.get("bibliographicCitation");


            if (booksObj.has("file_location"))
                identifier =(String) booksObj.get("file_location");

            if (booksObj.has("issue"))
                issue =(String) booksObj.get("issue");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("identifier"))
                identifier =(String) booksObj.get("identifier");

            if (booksObj.has("file_location"))
                file_location =(String) booksObj.get("file_location");


            if (booksObj.has("issued")) {
                issued  = (String) booksObj.get("issued");
            }


            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("subject"))
                subject = (String) booksObj.get("subject");

            if (booksObj.has("medium"))
                medium = (String) booksObj.get("medium");



            if (booksObj.has("publication_name"))
                publication_name = (String) booksObj.get("publication_name");

            if (booksObj.has("publication_volume"))
                publication_volume = (String) booksObj.get("publication_volume");

            if (booksObj.has("description"))
                description = (String) booksObj.get("description");

            if (booksObj.has("DOI"))
                DOI = (String) booksObj.get("DOI");

            if (booksObj.has("url"))
                url = (String) booksObj.get("url");

            if (booksObj.has("erflink"))
                erflink = (String) booksObj.get("erflink");

            String book="Book";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ identifier+"_"+date+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ identifier+ quote + "," + '\n' );
            if (bibliographicCitation!="")
                sb.append(  quote + "bibliographicCitation" + quote + ":" +  quote+ bibliographicCitation+ quote+  "," + '\n');

            if (identifier!="")
                sb.append(  quote + "identifier" + quote + ":" +  quote+ identifier+ quote+  "," + '\n');

            if (date!="")
                sb.append(  quote + "date" + quote + ":" + quote+ date+ quote+ "," + '\n');

            if (issued!="")
                sb.append(  quote + "issued" + quote + ":" + quote+ issued+ quote+ "," + '\n');

            if (file_location!="")
                sb.append(  quote + "file_location" + quote + ":" + quote+ file_location+ quote+ "," + '\n');


            if (publication_name!="")
                sb.append(  quote + "publication_name" + quote + ":" + quote+ publication_name+ quote+ "," + '\n');

            if (issue!="")
                sb.append(  quote + "issue" + quote + ":" + quote+ issue+ quote+ "," + '\n');

            if (publication_volume!="")
                sb.append(  quote + "publication_volume" + quote + ":" + quote+ publication_volume+ quote+ "," + '\n');


            sb.append(  quote + "DOI" + quote + ":" + quote+ DOI+ quote + "," + '\n' );
            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );

            if (title!="")
                sb.append(  quote + "title" + quote + ":" +   quote+ title+ quote+ "," + '\n');

            sb.append(  quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "The Chinese Students’ Monthly Online"+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

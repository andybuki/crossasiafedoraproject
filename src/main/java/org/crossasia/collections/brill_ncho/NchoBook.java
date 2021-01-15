package org.crossasia.collections.brill_ncho;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class NchoBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-brill-ncho/books2.json"));
        String books = "/data/solr/ajax-brill-ncho/booksNew.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            String title = "";
            String identifier = "";
            String issued ="";
            String date ="";
            String medium ="";
            String subject ="";
            String author ="";
            String publicationName ="";
            String publicationVolume ="";
            String description = "";
            String bibliographicCitation="";
            String DOI = "";
            String url ="";
            String description2 ="";
            String erflink ="";
            String book_id = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("bibliographicCitation"))
                bibliographicCitation =(String) booksObj.get("bibliographicCitation");




            if (booksObj.has("file_location"))
                identifier =(String) booksObj.get("file_location");

            if (booksObj.has("author"))
                author =(String) booksObj.get("author");


            if (booksObj.has("issued")) {
                issued  = (String) booksObj.get("issued");
            }
            if (booksObj.has("issued")) {
                date  = (String) booksObj.get("issued").toString().substring(0,4);
            }

            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("subject"))
                subject = (String) booksObj.get("subject");

            if (booksObj.has("medium"))
                medium = (String) booksObj.get("medium");

            if (booksObj.has("description2"))
                description2 = (String) booksObj.get("description2");

            if (booksObj.has("publication_name"))
                publicationName = (String) booksObj.get("publication_name");

            if (booksObj.has("publication_volume"))
                publicationVolume = (String) booksObj.get("publication_volume");

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
            sb.append(  quote + "id" + quote + ":" + quote+ identifier.replace("PDF/NCH/","").replace("/","_")+"_"+date+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ identifier.replace("PDF/NCH/","").replace("/","_")+ quote + "," + '\n' );
            if (bibliographicCitation!="")
                sb.append(  quote + "bibliographicCitation" + quote + ":" +  quote+ bibliographicCitation+ quote+  "," + '\n');

            if (identifier!="")
                sb.append(  quote + "identifier" + quote + ":" +  quote+ identifier+ quote+  "," + '\n');

            if (date!="")
                sb.append(  quote + "date" + quote + ":" + quote+ date+ quote+ "," + '\n');

            if (issued!="")
                sb.append(  quote + "issued" + quote + ":" + quote+ issued+ quote+ "," + '\n');

            if (author!="")
                sb.append(  quote + "author" + quote + ":" + quote+ author+ quote+ "," + '\n');

            if (medium!="")
                sb.append(  quote + "medium" + quote + ":" + quote+ medium+ quote+ "," + '\n');

            if (subject!="")
                sb.append(  quote + "subject" + quote + ":" + quote+ subject+ quote+ "," + '\n');

            if (publicationName!="")
                sb.append(  quote + "publication_name" + quote + ":" + quote+ publicationName+ quote+ "," + '\n');

            if (publicationVolume!="")
                sb.append(  quote + "publication_volume" + quote + ":" + quote+ publicationVolume+ quote+ "," + '\n');

            if (description!="" || description2!="")
                sb.append(  quote + "description" + quote + ":" + "["+ quote+ description+ quote+ ","+ quote+ description2 +quote +"]" + ","+ '\n');

            sb.append(  quote + "DOI" + quote + ":" + quote+ DOI+ quote + "," + '\n' );
            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );

            if (title!="")
                sb.append(  quote + "title" + quote + ":" +   quote+ title+ quote+ "," + '\n');

            sb.append(  quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "The North China Herald Online"+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

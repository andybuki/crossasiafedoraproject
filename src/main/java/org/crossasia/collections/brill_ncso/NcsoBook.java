package org.crossasia.collections.brill_ncso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class NcsoBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-brill-ncso/books2.json"));
        String books = "/data/solr/ajax-brill-ncso/books.json";
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
            String publicationName ="";
            String publicationVolume ="";
            JSONArray description = null;
            String bibliographicCitation="";
            String DOI = "";
            String url ="";
            String erflink ="";
            String book_id = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("bibliographicCitation"))
                bibliographicCitation =(String) booksObj.get("bibliographicCitation");

            id = (String) booksObj.get("id").toString();

            if (booksObj.has("identifier"))
                identifier =(String) booksObj.get("identifier");

            if (booksObj.has("identifier"))
                book_id =(String) booksObj.get("identifier").toString().replace("PDF/","").replace("/","_");

            if (booksObj.has("issued")) {
                issued  = (String) booksObj.get("issued");
            }
            if (booksObj.has("issued")) {
                date  = (String) booksObj.get("issued").toString().substring(0,4);
            }

            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("medium"))
                medium = (String) booksObj.get("medium");

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

            if (booksObj.has("erflink"))
                erflink = (String) booksObj.get("erflink");

            String book="Book";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (bibliographicCitation!="")
                sb.append(  quote + "bibliographicCitation" + quote + ":" +  quote+ bibliographicCitation+ quote+  "," + '\n');

            if (identifier!="")
                sb.append(  quote + "identifier" + quote + ":" +  quote+ identifier+ quote+  "," + '\n');

            if (date!="")
                sb.append(  quote + "date" + quote + ":" + quote+ date+ quote+ "," + '\n');

            if (issued!="")
                sb.append(  quote + "issued" + quote + ":" + quote+ issued+ quote+ "," + '\n');

            if (medium!="")
                sb.append(  quote + "medium" + quote + ":" + quote+ medium+ quote+ "," + '\n');


            if (publicationName!="")
                sb.append(  quote + "publication_name" + quote + ":" + quote+ publicationName+ quote+ "," + '\n');


            if (publicationVolume!="")
                sb.append(  quote + "publication_volume" + quote + ":" + quote+ publicationVolume+ quote+ "," + '\n');


            if (description!=null)
                sb.append(  quote + "description" + quote + ":" +  description+ "," + '\n');

            sb.append(  quote + "DOI" + quote + ":" + quote+ DOI+ quote + "," + '\n' );
            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" +   quote+ title+ quote+ "," + '\n');

            sb.append(  quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "North China Standard Online"+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

package org.crossasia.solr.collections.brill_jpco;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JpcoBook {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/OLD/ajax-brill-jpco/NEW/booksNew.json"));
        String books = "/data/solr/OLD/ajax-brill-jpco/NEW/books.json";
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
            String publicationName ="";
            String publicationVolume ="";
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

            id = (String) booksObj.get("id").toString();


            if (booksObj.has("file_location"))
                identifier =(String) booksObj.get("file_location");

            if (booksObj.has("file_location"))
                if (booksObj.get("id").toString().split("_").length==4)
                    book_id =(String) booksObj.get("id").toString().split("_")[2]+"_"+(String) booksObj.get("id").toString().split("_")[3];
                else if (booksObj.get("id").toString().split("_").length==3)
                    book_id =(String) booksObj.get("id").toString().split("_")[1]+"_"+(String) booksObj.get("id").toString().split("_")[2];
                else
                    book_id ="_"+(String) booksObj.get("id").toString().split("_")[1];
            if (id.contains("DE")){
                book_id = "DE_"+ book_id;
            } else if (id.contains("Books")) {
                book_id = ""+ book_id;
            } else if (id.contains("KobeChronicle")) {
                book_id = "KobeChronicle_"+ book_id;
            } else if (id.contains("JapanChronicle")) {
                book_id = "JapanChronicle_"+ book_id;
            } else if (id.contains("CommercialSupplement")) {
                book_id = "CommercialSupplement_"+ book_id;
            }

            if (booksObj.has("date")) {
                issued  = (String) booksObj.get("date");
            }
            if (booksObj.has("date")) {
                date  = (String) booksObj.get("date").toString().substring(0,4);
            }

            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("subject"))
                subject = (String) booksObj.get("subject");

            if (booksObj.has("medium"))
                medium = (String) booksObj.get("medium");



            if (booksObj.has("publication_name"))
                publicationName = (String) booksObj.get("publication_name");

            if (booksObj.has("publicationVolume"))
                publicationVolume = (String) booksObj.get("publicationVolume");

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

            if (subject!="")
                sb.append(  quote + "subject" + quote + ":" + quote+ subject+ quote+ "," + '\n');

            if (publicationName!="")
                sb.append(  quote + "publication_name" + quote + ":" + quote+ publicationName+ quote+ "," + '\n');

            if (publicationVolume!="")
                sb.append(  quote + "publication_volume" + quote + ":" + quote+ publicationVolume+ quote+ "," + '\n');

            if (description!="" )
                sb.append(  quote + "description" + quote + ":" +  quote+ description+ quote+  ","+ '\n');

            sb.append(  quote + "DOI" + quote + ":" + quote+ DOI+ quote + "," + '\n' );
            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );

            if (title!="")
                sb.append(  quote + "title" + quote + ":" +   quote+ title+ quote+ "," + '\n');

            sb.append(  quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "Japan Chronicle Online"+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

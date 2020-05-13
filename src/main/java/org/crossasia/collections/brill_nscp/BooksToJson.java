package org.crossasia.collections.brill_nscp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BooksToJson {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data1/solr/ajax-brill-ncdn/books_new.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-brill-ncdn/books_json2.json"));
        for (int i=0; i<jsonArray.length();i++){

            String id ="";
            String title ="";
            String date ="";
            String wholedate ="";
            String file_location ="";
            String  medium ="";
            String  subject ="";
            String publication_name ="";
            String publication_volume ="";
            String doi ="";
            String url ="";

            String erflink ="";
            String collection ="";
            String bibliographicCitation ="";
            JSONArray descriptions =null;
            String description="";
            String description2="";


            String book_id="";

            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if (jsonObj.has("id")) {
                id = (String) jsonObj.get("id").toString();
            }

            if (jsonObj.has("title")) {
                title = (String) jsonObj.get("title").toString();
            }

            if (jsonObj.has("issued")) {
                date = (String) jsonObj.get("issued").toString().split("-")[0];
            }

            if (jsonObj.has("issued")) {
                wholedate = (String) jsonObj.get("issued").toString();
            }

            if (jsonObj.has("file_location")) {
                file_location = (String) jsonObj.get("file_location").toString();
            }

            if (jsonObj.has("medium")) {
                medium = (String) jsonObj.get("medium").toString();
            }

            if (jsonObj.has("subject")) {
                subject = (String) jsonObj.get("subject").toString();
            }

            if (jsonObj.has("publication_name")) {
                publication_name = (String) jsonObj.get("publication_name").toString();
            }

            if (jsonObj.has("publication_volume")) {
                publication_volume = (String) jsonObj.get("publication_volume").toString();
            }

            if (jsonObj.has("doi")) {
                doi = (String) jsonObj.get("doi").toString();
            }

            if (jsonObj.has("url")) {
                url = (String) jsonObj.get("url").toString();
            }

            if (jsonObj.has("erflink")) {
                erflink = (String) jsonObj.get("erflink").toString();
            }

            if (jsonObj.has("bibliographicCitation")) {
                bibliographicCitation = (String) jsonObj.get("bibliographicCitation").toString();
            }

            if (jsonObj.has("description")) {
                description = (String) jsonObj.get("description");
            }

            if (jsonObj.has("description2")) {
                description2 = (String) jsonObj.get("description2");
            }

            if (jsonObj.has("file_location")) {
                String [] book_ids = jsonObj.get("file_location").toString().split("/");
                String book_id2 = book_ids[2]+"_"+book_ids[3];
                book_id = book_id2;
            }

            sb.append("{"+ '\n');
            if (id!= "")
                sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');

            if (book_id!= "")
                sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

            if (title!= "")
                sb.append(quote + "title" + quote + ":" + quote+ title +quote + "," + '\n');

            if (date!= "")
                sb.append(quote + "date" + quote + ":" + quote+ date +quote + "," + '\n');

            if (wholedate!= "")
                sb.append(quote + "wholedate" + quote + ":" + quote+ wholedate +quote + "," + '\n');

            if (file_location!= "")
                sb.append(quote + "file_location" + quote + ":" + quote+ file_location +quote + "," + '\n');


            if (medium!= "")
                sb.append(quote + "medium" + quote + ":" + quote+ medium +quote + "," + '\n');


            if (subject!= "")
                sb.append(quote + "subject" + quote + ":" + quote+ subject +quote + "," + '\n');


            if (bibliographicCitation!= "")
                sb.append(quote + "bibliographicCitation" + quote + ":" + quote+ bibliographicCitation +quote + "," + '\n');


            if (url!= "")
                sb.append(quote + "url" + quote + ":" + quote+ url +quote + "," + '\n');


            if (erflink!= "")
                sb.append(quote + "erflink" + quote + ":" + quote+ erflink +quote + "," + '\n');

            if (doi!= "")
                sb.append(quote + "doi" + quote + ":" + quote+ doi +quote + "," + '\n');

            if (publication_name!= "")
                sb.append(quote + "publication_name" + quote + ":" + quote+ publication_name +quote + "," + '\n');

            if (publication_volume!= "")
                sb.append(quote + "publication_volume" + quote + ":" + quote+ publication_volume +quote + "," + '\n');

            if (description!= null)
                sb.append(quote + "description" + quote + ":" + "["+ quote+ description +quote +"," +quote+ description2 +quote+"]" + "," + '\n');

            sb.append(quote + "hasModel" + quote + ":" + quote + "Book" + quote + "," + '\n');
            sb.append(quote + "collection" + quote + ":" + quote + "North China Daily News" + quote + "" + '\n');

            sb.append("},");



        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

        //JsonParser parser = new JsonParser();
        //JsonObject object = (JsonObject)parser.parse(pages);


    }
}

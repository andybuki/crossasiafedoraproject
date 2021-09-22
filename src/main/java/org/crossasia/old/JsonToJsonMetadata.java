package org.crossasia.old;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class JsonToJsonMetadata {
    public static void main(String[] args) {
        try {
            String journal = "D:\\SOLR-COLLECTIONS\\adm\\books.json";
            PrintStream out = new PrintStream(new FileOutputStream( "D:\\SOLR-COLLECTIONS\\adm\\books2.json"));

            String quote = "\u005c\u0022";

            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(journal)));

            for (int k=0; k<jsonArray.length();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);
                String id = (String) book.get("id").toString();
                String hasModel = (String) book.get("hasModel");
                String nodeid = (String) book.get("nodeId").toString();
                String book_id = (String) book.get("book_id");
                String identifier = (String) book.get("identifier");
                String title = (String) book.get("title").toString().replaceAll(quote,"").replaceAll(",","; ");
                String date = (String) book.get("date").toString();
                String publication_name ="";
                if (book.has("publication_name")) {
                    publication_name = (String) book.get("publication_name").toString();
                }
                String edition = (String) book.get("edition").toString();
                String description ="";
                if (book.has("description")) {
                    description = (String) book.get("description").toString();
                }
                String medium = (String) book.get("medium").toString();
                String subject ="";
                if (book.has("subject")) {
                    subject = (String) book.get("subject").toString();
                }
                String organization ="";
                if (book.has("organization")) {
                     organization = (String) book.get("organization");
                }
                String keywords ="";
                if (book.has("keywords")) {
                    keywords = (String) book.get("keywords").toString();
                }
                String source = (String) book.get("source").toString();
                String spatial ="";
                if (book.has("spatial")) {
                    spatial = (String) book.get("spatial").toString();
                }
                String person ="";
                if (book.has("person")) {
                    person = (String) book.get("person").toString();
                }
                String series_title = (String) book.get("series_title").toString();
                String publisher = (String) book.get("publisher");

                out.println("{" + quote + "id" + quote + ":" + quote+ book_id+ quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" +  quote+  hasModel  +  quote+"," + '\n'
                        + quote + "nodeId" + quote + ":" +  quote+  nodeid + quote+ "," + '\n'
                        + quote + "book_id" + quote + ":" + quote +  book_id  + quote + "," + '\n'
                        + quote + "collection" + quote + ":" + quote+  "Adam Matthew – FO Japan"  + quote+ "," + '\n'
                        + quote + "identifier" + quote + ":" +   quote+ identifier  + quote+ "," + '\n'
                        + quote + "language" + quote + ":" +  quote+ "eng"  +quote+ "," + '\n'
                        + quote + "title" + quote + ":" +   quote+ title + quote+ "," + '\n'
                        + quote + "date" + quote + ":" +   quote+ date + quote + "," + '\n'
                        + quote + "publication_name" + quote + ":" +   publication_name  + "," + '\n'
                        + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                        + quote + "description" + quote + ":" +   description  + "," + '\n'
                        + quote + "medium" + quote + ":" +   medium  + "," + '\n'
                        + quote + "subject" + quote + ":" +   subject  + "," + '\n'
                        + quote + "organization" + quote + ":" +  quote +  organization + quote + "," + '\n'
                        + quote + "keywords" + quote + ":" +   keywords  + "," + '\n'
                        + quote + "source" + quote + ":" +  quote + source  + quote +"," + '\n'
                        + quote + "spatial" + quote + ":" +   spatial  + "," + '\n'
                        + quote + "person" + quote + ":" +   person  + "," + '\n'
                        + quote + "series_title" + quote + ":" +   series_title  + "," + '\n'
                        + quote + "publisher" + quote + ":" +  quote +  publisher  + quote + "" + '\n'
                        +"},"
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

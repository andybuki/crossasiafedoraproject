package org.crossasia.solr.collections.brill_ncso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class NcsoPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/ajax-brill-ncso/pages.json";
        String books = "/data/solr/ajax-brill-ncso/books2.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayBooks = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-brill-ncso/books_pages.json"));
        for (int i=0; i<jsonArrayBooks.length();i++){

            String id ="";

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
            JSONArray description =null;

            String book_id="";

            JSONObject jsonObjBooks = (JSONObject) jsonArrayBooks.get(i);

            if (jsonObjBooks.has("id")) {
                id = (String) jsonObjBooks.get("id").toString();
            }



            if (jsonObjBooks.has("date")) {
                date = (String) jsonObjBooks.get("date").toString().split("-")[0];
            }

            if (jsonObjBooks.has("wholedate")) {
                wholedate = (String) jsonObjBooks.get("wholedate").toString();
            }

            if (jsonObjBooks.has("file_location")) {
                file_location = (String) jsonObjBooks.get("file_location").toString();
            }

            if (jsonObjBooks.has("medium")) {
                medium = (String) jsonObjBooks.get("medium").toString();
            }

            if (jsonObjBooks.has("subject")) {
                subject = (String) jsonObjBooks.get("subject").toString();
            }

            if (jsonObjBooks.has("publication_name")) {
                publication_name = (String) jsonObjBooks.get("publication_name").toString();
            }

            if (jsonObjBooks.has("publication_volume")) {
                publication_volume = (String) jsonObjBooks.get("publication_volume").toString();
            }

            if (jsonObjBooks.has("doi")) {
                doi = (String) jsonObjBooks.get("doi").toString();
            }

            if (jsonObjBooks.has("url")) {
                url = (String) jsonObjBooks.get("url").toString();
            }

            if (jsonObjBooks.has("erflink")) {
                erflink = (String) jsonObjBooks.get("erflink").toString();
            }

            if (jsonObjBooks.has("bibliographicCitation")) {
                bibliographicCitation = (String) jsonObjBooks.get("bibliographicCitation").toString();
            }

            if (jsonObjBooks.has("description")) {
                description = (JSONArray) jsonObjBooks.get("description");
            }

            if (jsonObjBooks.has("book_id")) {
                book_id = (String) jsonObjBooks.get("book_id").toString();
            }



            for (int j=0; j<jsonArrayPages.length(); j++) {

                JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(j);
                String page_id="";
                String book_page_id ="";
                String position ="";
                String text ="";
                String title ="";

                if (jsonObjPages.has("book_id")) {
                    book_page_id = (String) jsonObjPages.get("book_id").toString();
                }

                if (jsonObjPages.has("id")) {
                    page_id = (String) jsonObjPages.get("id").toString();
                }

                if (jsonObjPages.has("position")) {
                    position = (String) jsonObjPages.get("position").toString();
                }

                if (jsonObjPages.has("title")) {
                    title = (String) jsonObjPages.get("title").toString();
                }

                if (jsonObjPages.has("text")) {
                    text = (String) jsonObjPages.get("text").toString();
                }

                if (book_id.equals(book_page_id)){

                    sb.append("{"+ '\n');
                    if (id!= "")
                        sb.append(quote + "id" + quote + ":" +quote+  page_id  + quote+"," + '\n');

                    if (book_id!= "")
                        sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

                    if (position!= "")
                        sb.append(quote + "position" + quote + ":" + quote+ position +quote + "," + '\n');

                    if (title!= "")
                        sb.append(quote + "title" + quote + ":" + quote+ title +quote + "," + '\n');

                    if (date!= "")
                        sb.append(quote + "date" + quote + ":" + quote+ date +quote + "," + '\n');


                    if (medium!= "")
                        sb.append(quote + "medium" + quote + ":" + quote+ medium +quote + "," + '\n');


                    if (text!= "")
                        sb.append(quote + "text" + quote + ":" + quote+ text +quote + "," + '\n');

                    if (publication_name!= "")
                        sb.append(quote + "publication_name" + quote + ":" + quote+ publication_name +quote + "," + '\n');

                    if (publication_volume!= "")
                        sb.append(quote + "publication_volume" + quote + ":" + quote+ publication_volume +quote + "," + '\n');


                    if (url!= "")
                        sb.append(quote + "url" + quote + ":" + quote+ url +quote + "," + '\n');


                    if (erflink!= "")
                        sb.append(quote + "erflink" + quote + ":" + quote+ erflink +quote + "," + '\n');

                    if (doi!= "")
                        sb.append(quote + "doi" + quote + ":" + quote+ doi +quote + "," + '\n');

                    sb.append(quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
                    sb.append(quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n');
                    sb.append(quote + "collection" + quote + ":" + quote + "North China Standard Online" + quote + "" + '\n');

                    sb.append("},");

                }

                else {
                    System.out.println("No" + id);
                }

            }

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");


    }
}

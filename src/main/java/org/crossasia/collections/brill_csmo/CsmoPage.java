package org.crossasia.collections.brill_csmo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CsmoPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/ajax-brill-csmo/pages.json";
        String books = "/data/solr/ajax-brill-csmo/books.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayBooks = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-brill-csmo/books_pages2.json"));
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
            String title ="";
            String erflink ="";
            String collection ="";
            String issue ="";
            String issued ="";
            String bibliographicCitation ="";
            JSONArray description =null;

            String book_id="";

            JSONObject jsonObjBooks = (JSONObject) jsonArrayBooks.get(i);

            if (jsonObjBooks.has("id")) {
                id = (String) jsonObjBooks.get("id").toString();
            }

            if (jsonObjBooks.has("date")) {
                date = (String) jsonObjBooks.get("date").toString();
            }

            if (jsonObjBooks.has("wholedate")) {
                wholedate = (String) jsonObjBooks.get("wholedate").toString();
            }

            if (jsonObjBooks.has("file_location")) {
                file_location = (String) jsonObjBooks.get("file_location").toString();
            }

            if (jsonObjBooks.has("issue")) {
                issue = (String) jsonObjBooks.get("issue").toString();
            }
            if (jsonObjBooks.has("issued")) {
                issued = (String) jsonObjBooks.get("issued").toString();
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

            if (jsonObjBooks.has("DOI")) {
                doi = (String) jsonObjBooks.get("DOI").toString();
            }

            if (jsonObjBooks.has("title")) {
                title = (String) jsonObjBooks.get("title").toString();
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
                String pages_ids ="";
                int p =0;
                String book_page_id ="";
                String position ="";
                String text ="";
                String title2 ="";


                if (jsonObjPages.has("book_id")) {
                    book_page_id = (String) jsonObjPages.get("book_id").toString();
                }



                if (jsonObjPages.has("id")) {
                    pages_ids = (String) jsonObjPages.get("id").toString();
                }

                if (jsonObjPages.has("position")) {
                    position = (String) jsonObjPages.get("position").toString();
                }

                if (jsonObjPages.has("text")) {
                    text = (String) jsonObjPages.get("text").toString();
                }

                if (jsonObjPages.has("title")) {
                    title2 = (String) jsonObjPages.get("title").toString();
                }

                if (book_id.equals(book_page_id)){

                    sb.append("{"+ '\n');
                    if (id!= "")
                        sb.append(quote + "id" + quote + ":" +quote+  pages_ids  + quote+"," + '\n');

                    if (book_id!= "")
                        sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

                    sb.append(quote + "position" + quote + ":" + quote+ position+quote + "," + '\n');

                    if (title!= "")
                        sb.append(quote + "title" + quote + ":" + "["+quote+ title +quote +"]" + "," + '\n');

                    if (date!= "")
                        sb.append(quote + "date" + quote + ":" + quote+ date +quote + "," + '\n');

                    if (issue!= "")
                        sb.append(quote + "issue" + quote + ":" + quote+ issue +quote + "," + '\n');

                    if (issued!= "")
                        sb.append(quote + "issued" + quote + ":" + quote+ issued +quote + "," + '\n');

                    if (text!= "")
                        sb.append(quote + "text" + quote + ":" + quote+ text.replaceAll("[^ .,a-zA-Z0-9]","") +quote + "," + '\n');

                    if (publication_name!= "")
                        sb.append(quote + "publication_name" + quote + ":" + quote+ publication_name +quote + "," + '\n');

                    if (publication_volume!= "")
                        sb.append(quote + "publication_volume" + quote + ":" + quote+ publication_volume +quote + "," + '\n');

                    if (url!= "")
                        sb.append(quote + "url" + quote + ":" + quote+ url +quote + "," + '\n');

                    if (erflink!= "")
                        sb.append(quote + "erflink" + quote + ":" + quote+ erflink +quote + "," + '\n');

                    if (doi!= "")
                        sb.append(quote + "DOI" + quote + ":" + quote+ doi +quote + "," + '\n');

                    sb.append(quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
                    sb.append(quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n');
                    sb.append(quote + "collection" + quote + ":" + quote + "The Chinese Students’ Monthly Online" + quote + "" + '\n');

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

package org.crossasia.solr.collections.sbb;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SbbPage {
    public static void main(String[] args) throws IOException {
    PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/sbb-digital/pages_books.json"));
    String books = "/data3/solr/sbb-digital/books.json";
    String pages = "/data3/solr/sbb-digital/pages.json";
    String quote = "\u005c\u0022";
    JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
    JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));

    StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String url_page = "";
            String url_book = "";
            String id = "";
            String book_id = "";
            String book_id2 = "";
            String title = "";
            String date = "";
            JSONArray subject = null;
            String position = "";
            JSONArray author = null;
            String language = "";
            String noOfpages="";

            String hasModel = "";
            String collection = "";
            String publication_name = "";
            String text="";

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("hasModel"))
                hasModel = (String) booksObj.get("hasModel");
                id = (String) booksObj.get("id").toString();
                book_id = (String) booksObj.get("book_id").toString();
                if (booksObj.has("title"))
                    title = (String) booksObj.get("title");
                if (booksObj.has("author"))
                    author = (JSONArray) booksObj.get("author");
                if (booksObj.has("date"))
                    date = (String) booksObj.get("date");
                if (booksObj.has("subject"))
                    subject = (JSONArray) booksObj.get("subject");
                if (booksObj.has("url"))
                    url_book = (String) booksObj.get("url");
                if (booksObj.has("collection"))
                    collection = (String) booksObj.get("collection");
                if (booksObj.has("publicationName"))
                    publication_name = (String) booksObj.get("publicationName");
                if (booksObj.has("language"))
                    language = (String) booksObj.get("language");
                if (booksObj.has("noOfpages"))
                    noOfpages = (String) booksObj.get("noOfpages");

                for (int j=0; j<pagesObject.length(); j++) {
                    JSONObject pagesObj = (JSONObject) pagesObject.get(j);

                    if (pagesObj.has("hasModel"))
                        hasModel = (String) pagesObj.get("hasModel");
                    id = (String) pagesObj.get("id").toString();
                    book_id2 = (String) pagesObj.get("book_id").toString();

                    if (pagesObj.has("url"))
                        url_page = (String) pagesObj.get("url");

                    if (pagesObj.has("position"))
                        position = (String) pagesObj.get("position");
                    if (pagesObj.has("text"))
                        text = (String) pagesObj.get("text");

                    if (book_id.equals(book_id2)) {

                        out.println("{" );
                        out.println(quote + "id" + quote + ":" + quote + id + quote + "," );
                        out.println(quote + "book_id" + quote + ":" + quote + book_id + quote + "," );
                        out.println(quote + "url_book" + quote + ":" + quote + url_book + quote + "," );
                        out.println(quote + "title" + quote + ":" + quote + title + quote + "," );
                        out.println(quote + "author" + quote + ":" + author + "," );
                        out.println(quote + "date" + quote + ":" + quote +date +  quote +"," );
                        out.println(quote + "language" + quote + ":" + quote+language +quote+ "," );
                        out.println(quote + "subject" + quote + ":" + subject + "," );
                        out.println(quote + "url_page" + quote + ":" + quote + url_page + quote + "," );
                        out.println(quote + "position" + quote + ":" + quote + position + quote + "," );
                        out.println(quote + "text" + quote + ":" + quote + text + quote + "," );
                        out.println(quote + "collection" + quote + ":" + quote + "Western language East Asia Collection (SBB Digital Collection)" + quote + "," );
                        out.println(quote + "hasModel" + quote + ":" + quote + "Page" + quote + "");
                        out.println("},");
                    }


                }

        }
        //sb.deleteCharAt(sb.length() - 1);
        //out.println("["+sb.toString()+"]");
}
}

package org.crossasia.collections.sbb;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SbbBook {
    public static void main(String[] args) throws IOException {
    PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/sbb-digital/books.json"));
    String books = "/data3/solr/sbb-digital/sbb.json";
    String quote = "\u005c\u0022";
    JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

    StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String url = "";
            String id = "";
            String book_id = "";
            String title = "";
            String date = "";
            JSONArray subject = null;
            String language = "";
            JSONArray author = null;
            String hasModel = "";
            String collection = "";
            String publication_name = "";
            String noOfpages="";

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            if (booksObj.has("hasModel"))
                hasModel = (String) booksObj.get("hasModel");
            if (hasModel.equals("Book")) {
                id = (String) booksObj.get("id").toString();
                book_id = (String) booksObj.get("book_id").toString();
                if (booksObj.has("title"))
                    title = (String) booksObj.get("title");
                if (booksObj.has("creator"))
                    author = (JSONArray) booksObj.get("creator");
                if (booksObj.has("issued"))
                    date = (String) booksObj.get("issued");
                if (booksObj.has("subject"))
                    subject = (JSONArray) booksObj.get("subject");
                if (booksObj.has("url"))
                    url = (String) booksObj.get("url");
                if (booksObj.has("collection"))
                    collection = (String) booksObj.get("collection");
                if (booksObj.has("publicationName"))
                    publication_name = (String) booksObj.get("publicationName");
                if (booksObj.has("language"))
                    language = (String) booksObj.get("language");
                if (booksObj.has("noOfpages"))
                    noOfpages = (String) booksObj.get("noOfpages");


                sb.append("{" + '\n');
                sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');
                if (title != null)
                    sb.append(quote + "title" + quote + ":" + quote + title + quote + "," + '\n');
                if (author != null)
                    sb.append(quote + "author" + quote + ":" + author + "," + '\n');
                if (publication_name != null)
                    sb.append(quote + "publication_name" + quote + ":" + quote + publication_name + quote + "," + '\n');
                if (date != null)
                    sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');
                if (subject != null)
                    sb.append(quote + "subject" + quote + ":" + subject + "," + '\n');
                if (url != null)
                    sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');
                if (language != null)
                    sb.append(quote + "language" + quote + ":" + quote + language + quote + "," + '\n');
                if (noOfpages != null)
                    sb.append(quote + "noOfpages" + quote + ":" + quote + noOfpages + quote + "," + '\n');

                sb.append(quote + "hasModel" + quote + ":" + quote + "Book" + quote + "," + '\n');
                sb.append(quote + "collection" + quote + ":" + quote + collection + quote + "" + '\n');

                sb.append("},");

            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
}
}

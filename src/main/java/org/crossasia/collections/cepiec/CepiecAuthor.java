package org.crossasia.collections.cepiec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CepiecAuthor {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-cepiec/authors.json"));
        String books = "/data/solr/ajax-cepiec/cepiec3.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            String author = "";

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("id"))
                id = (String) booksObj.get("id");

            if (booksObj.has("author"))
                author = (String) booksObj.get("author");


            if (author!="") {
                sb.append("{" + '\n');
                sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                sb.append(quote + "author" + quote + ":" + quote + author + quote + "," + '\n');
                sb.append("},");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

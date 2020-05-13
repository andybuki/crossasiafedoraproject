package org.crossasia.fedora;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FedoraRenameJson {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ajax-diaolong-yldd/books.json";

        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-diaolong-yldd/books_newTags.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            JSONObject booksObj = (JSONObject) booksObject.get(i);
            booksObj.put("hasModel", booksObj.get("has_model") );
            booksObj.remove("has_model");
        }
        out.println(booksObject);
    }
}

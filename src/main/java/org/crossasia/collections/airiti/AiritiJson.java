package org.crossasia.collections.airiti;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class AiritiJson {

    public static void main( String[] args ) throws Exception {

        String journal = "D:\\SOLR-COLLECTIONS\\airiti_pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\airiti\\airiti.json"));
        String quote = "\u005c\u0022";
        JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(journal)));
        String bookName = "";

        StringBuilder sb = new StringBuilder();

        for (int k=0; k<jsonArray.length();k++) {
            String text = "";
            JSONObject book = (JSONObject) jsonArray.get(k);
            String id = (String) book.get("id");
            String book_id = (String) book.get("book_id");
            int position = (int) book.get("position");
            if (book.has("text")){
                text = (String) book.get("text");

            }
            sb.append("{" + quote + "id" + quote + ":" + quote + id +  quote + "," + '\n'
                    + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                    + quote + "position" + quote + ":" + position + "," + '\n'
                    + quote + "hasModel" + quote + ":" +  quote +"Page" + quote + "," + '\n'
                    + quote + "collection" + quote + ":" + quote + "Airiti" + quote + "," + '\n'
                    + quote + "text" + quote + ":" + quote + text + quote + "},"
            );
        }
        out.println("["+sb.deleteCharAt(sb.length() - 1)+"]");
    }

}

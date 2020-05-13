package org.crossasia.collections.brill_nscp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TextToJson {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data3/brill.ncdn/pages4.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-brill-ncdn/pages4_json.json"));
        for (int i=0; i<jsonArray.length();i++){

            String id ="";
            String text ="";
            String book_id="";
            String position="";

            JSONObject jsonObj = (JSONObject) jsonArray.get(i);

            if (jsonObj.has("id")) {
                id = (String) jsonObj.get("id").toString();
            }

            if (jsonObj.has("id")) {
               String positions [] = jsonObj.get("id").toString().split("_");
               position = positions[positions.length-1].replaceFirst("^0+(?!$)", "");;

            }

            if (jsonObj.has("text")) {
                text = (String) jsonObj.get("text").toString();
            }

            if (jsonObj.has("id")) {
                String [] book_ids = jsonObj.get("id").toString().split("/");
                String book_id2 = book_ids[1]+"_"+book_ids[2];
                book_id = book_id2;
            }

            sb.append("{"+ '\n');
            if (id!= "")
                sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');

            if (book_id!= "")
                sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

            if (position!= "")
                sb.append(quote + "position" + quote + ":" + quote+ position +quote + "," + '\n');

            if (text!= "")
                sb.append(quote + "text" + quote + ":" + quote+ text +quote + "," + '\n');

            sb.append(quote + "hasModel" + quote + ":" + quote + "Page" + quote + "" + '\n');

            sb.append("},");



        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

        //JsonParser parser = new JsonParser();
        //JsonObject object = (JsonObject)parser.parse(pages);


    }
}

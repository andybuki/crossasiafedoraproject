package org.crossasia.solr.collections.cepiec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CepiecAuthor {
    public static void main(String[] args) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-cepiec/tjimglist_NEW.json"));
        String books = "/data/solr/ajax-cepiec/tjimglist.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            String title_id = "";
            String publication_title = "";
            String start_year = "";
            String title_url = "";
            String place = "";
            String remarks = "";
            String version = "";


            JSONObject booksObj = (JSONObject) booksObject.get(i);

            if (booksObj.has("title_id"))
                title_id = (String) booksObj.get("title_id");
            if (booksObj.has("publication_title"))
                publication_title = (String) booksObj.get("publication_title");
            if (booksObj.has("start_year"))
                start_year = (String) booksObj.get("start_year").toString();

            if (booksObj.has("title_url"))
                title_url = (String) booksObj.get("title_url");
            if (booksObj.has("Place"))
                place = (String) booksObj.get("Place");
            if (booksObj.has("Remarks"))
                remarks = (String) booksObj.get("Remarks");

            if (booksObj.has("version"))
                version = (String) booksObj.get("version");

            if (booksObj.has("title_id")) {
                id = (String) booksObj.get("title_id");

                //id = id.replace("tktj","tktj_");
                String sub_id = id.substring(11,14);
                String sub_id2 = id.substring(4,12);
                id = "tktj_" + sub_id2 +"_"+ sub_id;
            }
            //tktj 1930 0531 04
            //        tktj_19340328_101

            if (title_id!="") {
                sb.append("{" + '\n');
                sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                sb.append(quote + "title_id" + quote + ":" + quote + title_id + quote + "," + '\n');
                sb.append(quote + "publication_title" + quote + ":" + quote + publication_title + quote + "," + '\n');
                sb.append(quote + "start_year" + quote + ":" + quote + start_year + quote + "," + '\n');
                sb.append(quote + "title_url" + quote + ":" + quote + title_url + quote + "," + '\n');
                sb.append(quote + "place" + quote + ":" + quote + place + quote + "," + '\n');
                sb.append(quote + "remarks" + quote + ":" + quote + remarks + quote + "," + '\n');
                sb.append(quote + "version" + quote + ":" + quote + version + quote + "," + '\n');
                sb.append("},");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

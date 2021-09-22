package org.crossasia.solr.collections.brill_jpco;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AddBooIdToPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/OLD/ajax-brill-jpco/NEW/pages_sort2.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/OLD/ajax-brill-jpco/NEW/pages_sort_book_id2.json"));
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));

        String text ="";
        String id ="";
        String book_id="";

        for (int j=0; j<jsonArrayPages.length(); j++) {
            JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(j);

            if (jsonObjPages.has("text")) {
                text = (String) jsonObjPages.get("text").toString();
            }

            if (jsonObjPages.has("id")) {
                id = (String) jsonObjPages.get("id").toString();
            }

            if (jsonObjPages.has("id")) {

                if (jsonObjPages.has("id")) {
                    if (jsonObjPages.toString().contains("KobeChronicle")) {
                        book_id = (String) jsonObjPages.get("id").toString().split("_")[0]+"_"+jsonObjPages.get("id").toString().split("_")[1]+"_"+jsonObjPages.get("id").toString().split("_")[2];
                    } else if (jsonObjPages.toString().contains("DE_")) {
                        book_id = (String) jsonObjPages.get("id").toString().split("_")[0]+"_"+jsonObjPages.get("id").toString().split("_")[1]+"_"+jsonObjPages.get("id").toString().split("_")[2];
                    } else if (jsonObjPages.toString().contains("JapanChronicle")) {
                        book_id = (String) jsonObjPages.get("id").toString().split("_")[0]+"_"+jsonObjPages.get("id").toString().split("_")[1]+"_"+jsonObjPages.get("id").toString().split("_")[2];
                    } else if (jsonObjPages.toString().contains("Books_")) {
                        book_id = (String) jsonObjPages.get("id").toString().split("_")[0]+"_"+jsonObjPages.get("id").toString().split("_")[1];
                    } else if (jsonObjPages.toString().contains("CommercialSupplement")){
                        book_id = (String) jsonObjPages.get("id").toString().split("_")[0]+"_"+jsonObjPages.get("id").toString().split("_")[1]+"_"+jsonObjPages.get("id").toString().split("_")[2];
                    }
                    else {
                        book_id = "";
                    }

                }

                //book_id = (String) "CommercialSupplement_"+jsonObjPages.get("id").toString().split("_")[0].substring(0,4)+"_"+jsonObjPages.get("id").toString().split("_")[0];

                //book_id = (String) jsonObjPages.get("id").toString().split("_")[0]+"_"+jsonObjPages.get("id").toString().split("_")[1]+"_"+jsonObjPages.get("id").toString().split("_")[2];
            }

            sb.append("{"+ '\n');
            if (id!= "")
                sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');

            if (book_id!= "")
                sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

            if (text!= "")
                sb.append(quote + "text" + quote + ":" + quote+ text +quote + "" + '\n');

            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

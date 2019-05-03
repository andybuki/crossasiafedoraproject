package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JsonJsonPages {
    public static void main(String[] args) {
        String quote = "\u005c\u0022";
        String pages = "D:\\SOLR-COLLECTIONS\\CHNP2\\pages.json";
        String text = "D:\\SOLR-COLLECTIONS\\CHNP2\\text.json";
        try {
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\pagetext.json"));
            StringBuilder sb = new StringBuilder();
            JSONArray pagesArray = new JSONArray(new JSONTokener(new FileInputStream(pages)));
            JSONArray textArray = new JSONArray(new JSONTokener(new FileInputStream(text)));

            String id="";
            String ids="";
            String position="";
            String identifier="";
            String texts ="";
            String book_id ="";

            for (int i=0; i<pagesArray.length(); i++) {
                JSONObject pagesObj = (JSONObject) pagesArray.get(i);
                id = (String) pagesObj.get("id");
                position = (String) pagesObj.get("position");
                identifier = (String) pagesObj.get("identifier");

                for (int j=0; j<textArray.length(); j++) {
                    JSONObject textObj = (JSONObject) textArray.get(j);
                    ids = (String) textObj.get("id");
                    texts = (String) textObj.get("text");
                    book_id = (String) textObj.get("book_id");
                    String combain_id = ids+"-"+book_id;

                    if (pagesObj.get("id").equals(combain_id)){
                        out.println("{" + quote + "id" + quote + ":"   + id  + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote + ids + quote + "," + '\n'
                                + quote + "text" + quote + ":" + quote + texts + quote + "," + '\n'
                                + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "collection" + quote + ":" + quote + "Gale CFER" + quote + "," + '\n'
                                + quote + "identifier" + quote + ":"  + identifier  + "" + '\n'
                                + "},"
                        );

                    }else {
                        System.out.println("NO");
                    }
                }
            }
            //sb.deleteCharAt(sb.length() - 1);
            //out.println("["+sb.toString()+"]");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

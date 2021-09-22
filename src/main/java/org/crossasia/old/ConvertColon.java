package org.crossasia.old;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConvertColon {
    public static void main(String[] args) throws FileNotFoundException {
        String pages = "D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL6.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL7.json"));
        String quote = "\u005c\u0022";

        String id = "";
        String book_id = "";
        String book_id_section="";
        int position_section=0;
        String text = "";
        String chapter_title  = "";
        String running_title = "";
        String image_info = "";
        int volume = 0;
        String position_vol = "";
        int position = 0;
        String id2 = "";
        int count=0;
        JSONArray jsonArraypages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        for (int x =0; x<jsonArraypages.length();x++) {
            JSONObject page = (JSONObject) jsonArraypages.get(x);
            id = (String) page.get("id");
            book_id = (String) page.get("book_id");

            if (page.has("text")) {
                text = (String) page.get("text").toString().replaceAll(":","︰");
            }
            if (page.has("volume")) {
                volume = Integer.parseInt((String) page.get("volume"));
            }
            if (page.has("running_title")) {
                running_title = (String) page.get("running_title").toString().replaceAll(":","︰");
            }

            if (page.has("position_vol")) {
                position_vol = ((String) page.get("position_vol"));
            }

            if (page.has("position")) {
                position = Integer.parseInt((String) page.get("position"));
            }

            if (page.has("image_info")) {
                image_info = (String) page.get("image_info");
            }

            if (page.has("chapter_title")) {
                chapter_title = ((String) page.get("chapter_title"));
            }


            out.println("{"
                    + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                    + quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n'
                    + quote + "collection" + quote + ":" + quote + "China Comprehensive Gazetteers : 中國綜合方誌庫" + quote + "," + '\n'
                    + quote + "running_title" + quote + ":" + quote + running_title + quote + "," + '\n'
                    + quote + "volume" + quote + ":" + quote + volume + quote + "," + '\n'
                    + quote + "image_info" + quote + ":" + quote + image_info + quote + "," + '\n'
                    + quote + "position_vol" + quote + ":" + quote + position_vol + quote + "," + '\n'
                    + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                    + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "," + '\n'
                    + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                    + quote + "text" + quote + ":" + quote + text + quote + "" + '\n'
                    + "},"
            );

        }

    }
}

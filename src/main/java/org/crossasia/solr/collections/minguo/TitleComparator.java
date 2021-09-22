package org.crossasia.solr.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class TitleComparator {
    public static void main(String[] args) throws FileNotFoundException {
        String sections = "/data3/solr/minguo/books_title.json";
        String quote = "\u005c\u0022";
        String id = "";
        String identifier = "";
        String book_id_section="";
        int position_section=0;
        String text = "";

        String running_title = "";
        String image_info = "";
        int volume = 0;
        String position_vol = "";
        int position = 0;
        String id2 = "";
        int count=0;
        JSONArray jsonArraySections = new JSONArray(new JSONTokener(new FileInputStream(sections)));
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo/books_title2.json"));



        for (int x =0; x<jsonArraySections.length();x++) {
            JSONObject section = (JSONObject) jsonArraySections.get(x);




            id = (String) section.get("id");
            identifier = (String) section.get("identifier");
            if (section.has("pages")) {
                position = Integer.parseInt((String) section.get("pages"));
            }
            if (section.has("contents")) {
                text = ((String) section.get("contents"));
            }
            int position2 =0;
            String txt="";

            for (int y=1; y<jsonArraySections.length(); y++) {
                String text2="";
                JSONObject section2 = (JSONObject) jsonArraySections.get(y);
                id2 = (String) section2.get("id");
                text2 = ((String) section2.get("contents"));
                String chapter_title  = "";
                boolean equal = true;
                for (Iterator<String> iterator = section.keys(); iterator.hasNext(); ) {
                    String curKey = iterator.next();
                    if(!section.getString(curKey).equals(section2.getString(curKey))){
                        equal = false;
                        break;
                    }
                }


                if (id.equals(id2)) {
                    //System.out.println("duplicate:" + id);
                    txt = ((String) section.get("contents"));
                    chapter_title += " " + text + " " + text2;
                    out.println("{"
                            + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                            + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                            + quote + "identifier" + quote + ":" + quote + identifier + quote + "," + '\n'
                            + quote + "contents" + quote + ":" + quote + chapter_title + quote + "" + '\n'
                            + "},"
                    );
                } else {
                    //System.out.println("NOT duplicate:" + id);
                    /*txt = ((String) section.get("contents"));
                    chapter_title = txt;
                    out.println("{"
                            + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                            + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                            + quote + "identifier" + quote + ":" + quote + identifier + quote + "," + '\n'
                            + quote + "contents" + quote + ":" + quote + chapter_title + quote + "" + '\n'
                            + "},"
                    );*/
                }

            }


        }





    }
}

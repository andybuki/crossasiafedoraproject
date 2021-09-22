package org.crossasia.solr.collections.ccg;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GropSections {
    public static void main(String[] args) throws FileNotFoundException {
        String sections = "D:\\SOLR-COLLECTIONS\\CCG\\section.json";
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
        JSONArray jsonArraySections = new JSONArray(new JSONTokener(new FileInputStream(sections)));
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\group_section.json"));



       for (int x =1; x<jsonArraySections.length();x++) {
            JSONObject section = (JSONObject) jsonArraySections.get(x);

            id = (String) section.get("id");
            book_id = (String) section.get("book_id");
            if (section.has("position")) {
                position = Integer.parseInt((String) section.get("position"));
            }
            if (section.has("text")) {
                text = ((String) section.get("text"));
            }
            int position2 =0;
            String txt="";
            for (int y=x+1; y<jsonArraySections.length(); y++) {
                JSONObject section2 = (JSONObject) jsonArraySections.get(x-1);
                id2 = (String) section2.get("id");
            }

                if (id.equals(id2)) {
                    System.out.println("duplicate:"+id);
                    txt  = ((String) section.get("text"));
                    chapter_title += " "+ txt;
                        out.println("{"
                        + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                        + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                        + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "" + '\n'
                        + "},"
                    );
                }else {
                    System.out.println("NOT duplicate:"+id);
                    txt  = ((String) section.get("text"));
                    chapter_title = txt;
                    out.println("{"
                            + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                            + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                            + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "" + '\n'
                            + "},"
                    );
                }


            }





    }
}

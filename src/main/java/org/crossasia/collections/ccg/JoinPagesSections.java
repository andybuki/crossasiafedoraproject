package org.crossasia.collections.ccg;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JoinPagesSections {
    public static void main(String[] args) throws FileNotFoundException {

        String quote = "\u005c\u0022";
        String pages = "D:\\SOLR-COLLECTIONS\\CCG\\pages_SZFZ5.json";
        String sections = "D:\\SOLR-COLLECTIONS\\CCG\\group_section3.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_SZFZ6.json"));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        JSONArray jsonArraySections = new JSONArray(new JSONTokener(new FileInputStream(sections)));
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

        for (int i=0; i<jsonArrayPages.length();i++){
            JSONObject page = (JSONObject) jsonArrayPages.get(i);

            id = (String) page.get("id");
            book_id = (String) page.get("book_id");

            if (page.has("text")) {
                text = (String) page.get("text");
            }
            if (page.has("volume")) {
                volume = Integer.parseInt((String) page.get("volume"));
            }
            if (page.has("running_title")) {
                running_title = (String) page.get("running_title");
            }
            if (page.has("image_info")) {
                image_info = (String) page.get("image_info");
            }

            if (page.has("position_vol")) {
                position_vol = ((String) page.get("position_vol"));
            }

            if (page.has("position")) {
                position = Integer.parseInt((String) page.get("position"));
            }

            for (int y =0; y<jsonArraySections.length();y++) {
                JSONObject section = (JSONObject) jsonArraySections.get(y);
                book_id_section = (String) section.get("book_id");
                if (section.has("position")) {
                    position_section = Integer.parseInt((String) section.get("position"));
                }
                if (section.has("chapter_title")) {
                    chapter_title = ((String) section.get("chapter_title"));
                }
                if (book_id.equals(book_id_section) && position==position_section){
                    System.out.println("test");
                    out.println("{"
                            + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n'
                            + quote + "collection" + quote + ":" + quote + "China Comprehensive Gazetteers : 中國綜合方誌庫" + quote + "," + '\n'
                            + quote + "running_title" + quote + ":" + quote + running_title + quote + "," + '\n'
                            + quote + "image_info" + quote + ":" + quote + image_info + quote + "," + '\n'
                            + quote + "volume" + quote + ":" + quote + volume + quote + "," + '\n'
                            + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "," + '\n'
                            + quote + "position_vol" + quote + ":" + quote + position_vol + quote + "," + '\n'
                            + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                            + quote + "text" + quote + ":" + quote + text + quote + "" + '\n'
                            + "},"
                    );


                        /*if (section.has("text")) {
                            String txt ="";
                            txt  = ((String) section.get("text"));
                            if (position==position_section) {
                                chapter_title += " "+ txt;
                            } else {
                                chapter_title = txt;
                            }


                        }*/


                }


            }

        }


    }



}

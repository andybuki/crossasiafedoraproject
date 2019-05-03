package org.crossasia.collections.ccg;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConvertJsonJsonPage {
    public static void main(String[] args) {

        try {
            String pages = "D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL2.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL3.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(pages)));
            String id = "";
            String book_id = "";
            String book_id2 = "";
            String text = "";
            String running_title = "";
            String chapter_title = "";
            String image_info = "";
            int volume = 0;
            String position_vol = "";
            int position = 0;

            int count=0;
            int i,j;


            for (i = 0; i < jsonArray.length();  i++) {
                JSONObject page = (JSONObject) jsonArray.get(i);
                //JSONObject page3 = (JSONObject) jsonArray.get(i+1);
                int position2 =0;


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

                if (position==(0)){
                    JSONObject page3 = (JSONObject) jsonArray.get(i-1);
                    position = Integer.parseInt ((String) page3.get("position"));
                    position = position+1;
                    System.out.println(position);

                }

                //List<String> sample = (List<String>) Arrays.asList(boosID);
                // Add counter uncoment
                /*for (int y=i+1; y<jsonArray.length(); y++) {
                    book_id2 = (String) page3.get("book_id");
                    if (book_id.equals(book_id2)){
                        //count++;

                    } else {
                        count=0;
                    }

                }
                if (book_id.equals(book_id2)) {
                    count++;
                    position =count;


                }*/


                out.println("{"
                        + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n'
                        + quote + "collection" + quote + ":" + quote + "China Comprehensive Gazetteers : 中國綜合方誌庫" + quote + "," + '\n'
                        + quote + "running_title" + quote + ":" + quote + running_title + quote + "," + '\n'
                        + quote + "image_info" + quote + ":" + quote + image_info + quote + "," + '\n'
                        + quote + "volume" + quote + ":" + quote + volume + quote + "," + '\n'
                        + quote + "position_vol" + quote + ":" + quote + position_vol + quote + "," + '\n'
                        + quote + "position" + quote + ":" + quote + position + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                        + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "," + '\n'
                        + quote + "text" + quote + ":" + quote + text + quote + "" + '\n'
                        + "},"
                );
            }
        }

        catch(FileNotFoundException e){
        e.printStackTrace();
        }
    }
}

package org.crossasia.collections.localgazetteer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ConvertJsonToJsonPages {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("D:\\SOLR-COLLECTIONS\\LOC_GAZ\\batchII\\pages\\pages9.json"));
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\LOC_GAZ\\batchII\\pages2\\pages9.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = (JSONArray) obj;



            for (int k=0; k<jsonArray.size();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String id = (String) book.get("id").toString();
                String page_id = (String) book.get("page_id");


                String book_id = (String) book.get("book_id");
                String language = (String) book.get("language");
                Long position = (Long) book.get("position");
                String text = (String) book.get("text").toString().replaceAll("\"","'").replaceAll(quote,"'");;
                String section_id = (String) book.get("section_id");
                StringBuffer sbf = new StringBuffer();
                String [] sections = section_id.split( "," );
                if (sections.length>0) {
                    sbf.append( sections [0]);
                    for (int key=1; key<sections.length; key ++) {
                        sbf.append("\","+quote).append(sections[key] ).append("");
                    }
                }




                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" + quote + "Book"  + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" +  quote + book_id +  quote + "," + '\n'
                        + quote + "page_id" + quote + ":" +  quote + page_id +  quote + "," + '\n'
                        + quote + "language" + quote + ":" +  quote + language +  quote + "," + '\n'
                        + quote + "position" + quote + ":" +  quote + position +  quote + "," + '\n'
                        + quote + "text" + quote + ":" +  quote + text +  quote + "," + '\n'
                        + quote + "section_id" + quote + ":" +   "["+  quote +sbf.toString()+quote +"]" + "," + '\n'
                        + quote + "collection" + quote + ":" + quote+  "Local Gazetteer"  + quote+  '\n'
                        /*

                        + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                        + quote + "note" + quote + ":" +   note  + "," + '\n'
                        + quote + "medium" + quote + ":" +   medium  + "," + '\n'
                        + quote + "spatial" + quote + ":" +   spatial  + "," + '\n'
                        + quote + "thumbnail_path" + quote + ":" +   quote+ thumbnail_path + quote + "," + '\n'*/


                        +"},"
                );
            }

            //String name = (String) jsonArray.get("name");
            //System.out.println(name);

            //long age = (Long) jsonArray.get("age");
            //System.out.println(age);

            // loop array
            /*JSONArray msg = (JSONArray) jsonArray.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
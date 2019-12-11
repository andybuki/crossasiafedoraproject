package org.crossasia.collections.localgazetteer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ConvertJsonToJson {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("D:\\SOLR-COLLECTIONS\\LOC_GAZ\\batchII\\pages\\pages.json"));
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\LOC_GAZ\\batchII\\pages\\pages.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = (JSONArray) obj;



            for (int k=0; k<jsonArray.size();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String id = (String) book.get("id").toString()+"book_loc_gaz";
                String title = (String) book.get("title");

                String title_transcription="";
                String title_transcription1="";

                if (book.containsKey("title_transcription")) { title_transcription = (String) book.get("title_transcription").toString();}
                if (book.containsKey("title_transcription1")) { title_transcription1 = (String) book.get("title_transcription1").toString();}
                String book_id = (String) book.get("book_id");

                String date = (String) book.get("date");
                String issued = (String) book.get("issued");
                String admin_level_1 = (String) book.get("admin_level_1");
                String admin_level_2 = (String) book.get("admin_level_2");
                String temporal = (String) book.get("temporal");
                String responsibility = (String) book.get("responsibility");
                String author1 = (String) book.get("author1");
                String author2 = (String) book.get("author2");
                String creator_transcription = (String) book.get("creator_transcription");
                String creator_transcription1 = (String) book.get("creator_transcription1");
                String creator_transcription2 = (String) book.get("creator_transcription2");
                String creator_transcription3 = (String) book.get("creator_transcription3");
                String creator_transcription4 = (String) book.get("creator_transcription4");
                String creator_transcription5 = (String) book.get("creator_transcription5");
                String edition = (String) book.get("edition");
                String admin_type = (String) book.get("admin_type");
                String spatial = (String) book.get("spatial");
                String medium = (String) book.get("medium");
                String medium1 = (String) book.get("medium1");
                String language = (String) book.get("language");
                String url = (String) book.get("url");



                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" + quote + "Book"  + quote + "," + '\n'
                        + quote + "book_id" + quote + ":" +  quote + book_id +  quote + "," + '\n'
                        + quote + "title" + quote + ":" +  quote + title  + quote +"," + '\n'
                        + quote + "title_transcription" + quote + ":" +"["+   quote +  title_transcription + quote  + ","+ quote +title_transcription1 + quote  + "]"+ "," +'\n'
                        + quote + "responsibility" + quote + ":" +  quote + responsibility  + quote +"," + '\n'
                        + quote + "author" + quote + ":" +"["+   quote +  author1 + quote  + ","+ quote +author2 + quote +"]"+ "," +'\n'
                        + quote + "creator_transcription" + quote + ":" +"["+   quote +  creator_transcription + quote  + ","+ quote +creator_transcription1 + quote  + ","+ quote +creator_transcription2 + quote  + ","+ quote +creator_transcription3 + quote  + ","+ quote +creator_transcription4 + quote  + ","+ quote +creator_transcription5 + quote +  "]"+ "," +'\n'
                        + quote + "issued" + quote + ":" +  quote + issued  + quote +"," + '\n'
                        + quote + "date" + quote + ":" +  quote + date  + quote +"," + '\n'
                        + quote + "language" + quote + ":" +  quote + language  + quote +"," + '\n'
                        + quote + "url" + quote + ":" +  quote + url  + quote +"," + '\n'
                        + quote + "spatial" + quote + ":" +  quote + spatial  + quote +"," + '\n'
                        + quote + "admin_level_1" + quote + ":" +  quote + admin_level_1  + quote +"," + '\n'
                        + quote + "admin_level_2" + quote + ":" +  quote + admin_level_2  + quote +"," + '\n'
                        + quote + "temporal" + quote + ":" +  quote + temporal  + quote +"," + '\n'
                        + quote + "edition" + quote + ":" +  quote + edition  + quote +"," + '\n'
                        + quote + "admin_type" + quote + ":" +  quote + admin_type  + quote +"," + '\n'
                        + quote + "medium" + quote + ":" +"["+   quote +  medium + quote  + ","+ quote +medium1 + quote  +"]"+ "," +'\n'

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
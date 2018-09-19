package org.crossasia.collections.localgazetteer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ConvertJsonToJsonFedoraPages {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("D:\\SOLR-COLLECTIONS\\LOC_GAZ\\batchII\\pages2\\pages3.json"));
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\LOC_GAZ\\batchII\\pages2\\pages_fedora2.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = (JSONArray) obj;


            for (int k=0; k<jsonArray.size();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String id = (String) book.get("id").toString();
                String page_id = (String) book.get("fedora:hasModel");
                String book_id = (String) book.get("book_id");
                String language = (String) book.get("dc:language");

                String position = (String) book.get("position");
                String identifier = (String) book.get("dc:identifier");
                String text = (String) book.get("text").toString().replaceAll("\"","'").replaceAll(quote,"'").replaceAll("[\r\n]+","");

                JSONArray section_id = (JSONArray) book.get("fedora:isMemberOf");
                String [] sections = section_id.toString().split( "," );
                StringBuffer sbf = new StringBuffer();

                /*for (int key=1; key<section_id.size(); key++) {
                    sbf.append("\","+quote).append(section_id.get(key) ).append("");
                }*/

                //String [] sections = section_id.split( "," );
                if (sections.length>0) {
                    sbf.append( sections [0]);
                    for (int key=1; key<sections.length; key ++) {
                        sbf.append("\",").append(sections[key] );
                    }
                }



                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "fedora:hasModel" + quote + ":" +  quote + "Page" +  quote + "," + '\n'
                        + quote + "@type" + quote + ":" +  quote + "pcdm:Object" +  quote + "," + '\n'
                        + quote + "@id" + quote + ":" +  quote + "" +  quote + "," + '\n'
                        + quote + "book_id" + quote + ":" +  quote + book_id +  quote + "," + '\n'
                        + quote + "dc:identifier" + quote + ":" +  quote + identifier +  quote + "," + '\n'
                        + quote + "language" + quote + ":" +  quote + language +  quote + "," + '\n'
                        + quote + "position" + quote + ":" +  quote + position +  quote + "," + '\n'
                        + quote + "text" + quote + ":" +  quote + text +  quote + "," + '\n'
                        + quote + "fedora:isMemberOf" + quote + ":"  +sbf.toString()+  '\n'

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
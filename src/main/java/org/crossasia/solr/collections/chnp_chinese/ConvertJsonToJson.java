package org.crossasia.solr.collections.chnp_chinese;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ConvertJsonToJson {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        //parser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
        try {

            Object obj = parser.parse(new FileReader("D:\\SOLR-COLLECTIONS\\CHNP2\\test.json"));
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\metadata1.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = (JSONArray) obj;


            StringBuilder sb = new StringBuilder();
            for (int k=0; k<jsonArray.size();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);
                String medium ="";
                String ArchiveName = (String) book.get("ArchiveName").toString();
                String CollectionTitle = (String) book.get("CollectionTitle").toString();
                String SubCollectionTitle = (String) book.get("SubCollectionTitle").toString();

                String Title = (String) book.get("Title").toString().replaceAll("\"","");
                String date = (String) book.get("Publication Date").toString();
                if (book.containsKey("Document Type")) {
                    medium = (String) book.get("Document Type").toString();
                }

                String id = (String) book.get("DocumentID").toString();
                String extent = (String) book.get("NumberOfImages").toString();



                sb.append("{" + quote + "series-title" + quote + ":" + "["+quote+ ArchiveName+quote+","+quote+CollectionTitle+":"+SubCollectionTitle+quote+"]"  + "," + '\n'
                        + quote + "title" + quote + ":" + quote + Title  + quote +"," + '\n'
                        + quote + "date" + quote + ":" + quote + date + quote + "," + '\n'
                        + quote + "medium" + quote + ":" + quote + medium + quote + "," + '\n'
                        + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                        + quote + "extent" + quote + ":" + quote + extent+" pp" + quote  + '\n'
                        +"},");

                /*out.println("{" + quote + "series-title" + quote + ":" + "["+quote+ ArchiveName+quote+","+quote+CollectionTitle+":"+SubCollectionTitle+quote+"]"  + "," + '\n'
                        + quote + "title" + quote + ":" + quote + Title  + quote +"," + '\n'
                        + quote + "date" + quote + ":" + quote + date + quote + "," + '\n'
                        + quote + "medium" + quote + ":" + quote + medium + quote + "," + '\n'
                        + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                        + quote + "extent" + quote + ":" + quote + extent+" pp" + quote  + '\n'
                        +"},"
                );*/

            }
            sb.deleteCharAt(sb.length() - 1);
            out.println("["+sb.toString()+"]");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
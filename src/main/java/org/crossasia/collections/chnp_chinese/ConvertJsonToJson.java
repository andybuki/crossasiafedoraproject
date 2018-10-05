package org.crossasia.collections.chnp_chinese;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;

public class ConvertJsonToJson {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        //parser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
        try {

            Object obj = parser.parse(new FileReader("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\text3.json"));
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\textResult.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = (JSONArray) obj;



            for (int k=0; k<jsonArray.size();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String link = (String) book.get("link").toString();
                String text = (String) book.get("text").toString().replaceAll("[\r\n]+", " ");


                out.println("{" + quote + "link" + quote + ":" + quote+ link+ quote + "," + '\n'
                        + quote + "text" + quote + ":" + quote + text  + quote  + '\n'
                        +"},"
                );
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
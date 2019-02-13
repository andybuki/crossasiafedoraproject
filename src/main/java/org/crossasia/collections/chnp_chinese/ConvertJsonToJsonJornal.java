package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.io.*;

public class ConvertJsonToJsonJornal {

    public static void main(String[] args) {

        //JSONParser parser = new JSONParser();
        //parser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
        try {

            String journal = "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\journal\\journal.json";
            PrintStream out = new PrintStream(new FileOutputStream( "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\journal\\journalResult2.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(journal)));
            //JSONArray jsonArray = (JSONArray) obj;
            //JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream((File) obj)));

            for (int k=0; k<jsonArray.length();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String id = (String) book.get("id").toString();
                String volume_number="";
                String journal_id ="";
                String date ="";
                String url ="";
                String date_original ="";
                String publication_volume ="";
                String description ="";

                if (book.has("volume-number")) {
                    volume_number = (String) book.get("volume-number").toString();
                }

                if (book.has("PSMID")) {
                    journal_id = (String) book.get("PSMID").toString();
                }

                if (book.has("date")) {
                    if  (book.get("date").toString().length()==8) {
                        String year = (String) book.get("date").toString().substring(0,4);
                        String month = (String) book.get("date").toString().substring(4,6);
                        String day = (String) book.get("date").toString().substring(6,8);

                        if(day.equals("00")) {
                            date = year+"-"+month;
                        } else {
                             day = (String) book.get("date").toString().substring(6,8);
                            date = year+"-"+month+"-"+day;
                        }

                    } else if (book.get("date").toString().length()==6) {
                        date = (String) book.get("date").toString().substring(0,4)+"-".substring(4,6);
                    } else {
                        date = (String) book.get("date").toString();
                    }

                }
                if (book.has("url")) {
                    url = (String) book.get("url").toString();
                }
                if (book.has("date_original")) {
                    date_original = (String) book.get("date_original").toString();
                }
                if (book.has("publication-volume")) {
                    publication_volume = (String) book.get("publication-volume").toString();
                }
                if (book.has("description")) {
                    description = (String) book.get("description").toString();
                }

                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "volume-number" + quote + ":" + quote+ volume_number+ quote + "," + '\n'
                        + quote + "journal_id" + quote + ":" + quote+ journal_id+  quote + "," + '\n'
                        + quote + "date" + quote + ":" + quote+ date+ quote + "," + '\n'
                        + quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n'
                        + quote + "date-original" + quote + ":" + quote+ date_original+ quote + "," + '\n'
                        + quote + "publication-volume" + quote + ":" + quote+ publication_volume+ quote + "," + '\n'
                        + quote + "description" + quote + ":" + quote+ description+ quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" + quote + "Journal"  + quote  + '\n'
                        +"},"
                );
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
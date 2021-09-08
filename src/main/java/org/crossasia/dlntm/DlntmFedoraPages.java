package org.crossasia.dlntm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class DlntmFedoraPages {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException , IOException {
        String quote = "\u005c\u0022";
        String pages = "/data/dlmnt/fedora/manuscripts.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/fedora/pages.json"));
        JSONArray pagesArray = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<pagesArray.length(); i++) {
            String id = "";
            JSONArray uploadArray = null;
            String uploaded_file_id ="";
            String original_file_name ="";
            int position =0;

            JSONObject pagesObj = (JSONObject) pagesArray.get(i);
            if (pagesObj.has("id")) {
                id = (String) pagesObj.get("id").toString();
            }

            if (pagesObj.has("upload")) {
                uploadArray =(JSONArray) pagesObj.get("upload");
                for (int j=0; j<uploadArray.length(); j++) {
                    JSONObject uploadObj = (JSONObject) uploadArray.get(j);

                    if (uploadObj.has("uploaded_file_id")) {
                        uploaded_file_id = (String) uploadObj.get("uploaded_file_id").toString();
                    }

                    if (uploadObj.has("original_file_name")) {
                        original_file_name = (String) uploadObj.get("original_file_name").toString();
                    }

                    if (uploadObj.has("position")) {
                        position = (int) uploadObj.get("position");
                    }

                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "uploaded_file_id" + quote + ":" + quote+ uploaded_file_id+ quote + "," + '\n' );
                    sb.append(  quote + "original_file_name" + quote + ":" + quote+ original_file_name+ quote + "," + '\n' );
                    sb.append(  quote + "position" + quote + ":" + quote+ position+ quote + "" + '\n' );
                    sb.append("},");
                }

            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"}]");

    }

}



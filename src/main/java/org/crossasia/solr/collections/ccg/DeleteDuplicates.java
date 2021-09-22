package org.crossasia.solr.collections.ccg;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteDuplicates {
    public static void main(String[] args) throws IOException {
        //String sections = "D:\\SOLR-COLLECTIONS\\CCG\\SZFZ_final.json";
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL6.json"));
        //File f = new File("D:\\SOLR-COLLECTIONS\\CCG\\group_section3.json");
        String content = new String(Files.readAllBytes(Paths.get("D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL5.json")), "UTF-8");
        /*JSONArray ja2 = JSONArray.fromObject(content);

        JSONArray jArray = ja2;
        JSONArray tempArray = new JSONArray();
        Set<String> uniqueset = new HashSet<>();
        String id1="";

        for (int i = jArray.size()-1; i >0; i--) {
            JSONObject jobject = (JSONObject) jArray.get(i);
            id1 = jArray.getJSONObject(i).getString("id");

            if (uniqueset.contains(id1)) {
                continue;
            } else {
                uniqueset.add(id1);
                tempArray.add(jArray.getJSONObject(i));
            }
            //Output:[{"key1":"a"},{"key2":"b"},{"key3":"c"}]

        }
        jArray = tempArray;
        out.println(jArray);
        System.out.println(id1);*/

    }}


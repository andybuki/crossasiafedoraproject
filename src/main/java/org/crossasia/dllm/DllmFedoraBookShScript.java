package org.crossasia.dllm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class DllmFedoraBookShScript {

    public static void main(String[] argv) throws IOException, ParseException,InterruptedException {
        BufferedWriter out = null;
        try {
            String absolutePath = "/data1/dllm/pages2/";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath+"file.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"file.sh")) {
                    System.out.println("text file");
                } else {
                    String name = file.getName();
                    String changedName = "dllm_000"+file.getName();

                    //Object obj = parser.parse(new FileReader(file));

                    JSONArray pages = new JSONArray(new JSONTokener(new FileInputStream(file)));

                    JSONObject object = (JSONObject) pages.get(0);

                    JSONArray pagesArray = (JSONArray) object.get("@graph");
                    //JSONObject book = (JSONObject) booksArray.get(0);
                    JSONObject object2 = (JSONObject) pagesArray.get(0);
                    String identifier = (String) object2.get("schema:identifier").toString();
                    String image_file =(String) object2.get("schema:image").toString();
                    String [] image_file_1 = image_file.split("/");
                    String image_spliter = image_file_1[1];
                    String link = "dllm_000"+identifier;

                    //String name_cut = name.replace(".xml","");
                    //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + name + " " + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/dllm/" +  link +"/" +name.replace(".json","");
                    cURLink = "curl -i -X PUT --data-binary" + " @/mnt/fedora/raw/dllm/PLMP/" +   image_file + "" + " -H " + quote + "Content-Type: image/jpg" + quote + " -H \"Content-Disposition: attachment; filename=" + image_spliter  + "" + quote + " " + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/dllm/" + link + "/" + name.replace(".json","") + "/image";
                    //cURLink = "curl -i -X PUT --data-binary" + " @/mnt/fedora/raw/amd_fo_japan/xml/" + name + "" + " -H " + quote + "Content-Type: application/xhtml+xml" + quote + " -H \"Content-Disposition: attachment; filename=" + name  + "" + quote + " " + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/amd_fo_japan/" + name_cut+"/xml";
                    out.write(cURLink + "\r\n");
                    Thread.sleep(1);
                    //System.out.println(name + " changed to " + newName);
                }
            }
            System.out.println("conversion is done");
        } catch (IOException e) {
            System.out.println(e +"Exception ");
        } finally {
            out.close();
        }
    }

}

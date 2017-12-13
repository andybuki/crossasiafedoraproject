package org.crossasia.curlconverter.adammetthew;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PagesFedoraConverter {


    private Object obj;

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        try {
            String absolutePath = "C:\\Users\\b-ab107\\IdeaProjects\\crossasiafedoraproject\\data\\fedora2\\pages\\";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath+"\\pages.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";
            String cURLink2 = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"\\pages.sh")) {
                    System.out.println("text file");
                } else {
                    Object obj = parser.parse(new FileReader(file));

                    JSONObject object = (JSONObject) obj;

                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);
                    String book_id = (String) book.get("dcterms:isPartOf");
                    String image_Name = (String) book.get("schema:image");

                    //String sections_id = (String) book.get("dc:identifier").toString();

                    String page_id = (String) book.get("id").toString();

                    String name = file.getName();
                    String newName = book_id+"_"+ page_id +  ".json";
                    String newPath = absolutePath + "/" + newName;

                    File file2 = new File(absolutePath+"\\"+newName);

                    Path from = file.toPath(); //convert from File to Path
                    Path to = file2.toPath(); //convert from String to Path

                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

                    //file.renameTo(new File(newPath));
                    //JSONArray chapter_id = (JSONArray) book.get("fedora:hasMember");
                    //String chapter ="";
                    //for (int ch=0; ch<chapter_id.size();ch++) {
                        //chapter = (String) chapter_id.get(ch);
                        //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8081/fcrepo/rest/AD/" + book_id + "book" + "/" +page_id;
                        cURLink2 = "curl -i -X POST --data-binary" + " @" +image_Name +  " -H " + quote + "Content-Type: image/jpeg"  + quote + " -H \"Content-Disposition: attachment; filename="+image_Name + quote +" " + "http://10.46.3.100:8081/fcrepo/rest/AD/" + book_id + "book" + "/" +page_id;
                        //out.write(cURLink + "\r\n");
                        out.write(cURLink2 + "\r\n");
                    //}

                    System.out.println(name + " changed to " + newName);
                }
            }

            System.out.println("conversion is done");
        } catch (IOException e) {
            System.out.println("Exception ");

        } finally {
            out.close();
        }
    }
}

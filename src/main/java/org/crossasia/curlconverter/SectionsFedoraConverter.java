package org.crossasia.curlconverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class SectionsFedoraConverter {


    private Object obj;

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        BufferedWriter out2 = null;
        try {
            String absolutePath = "C:\\TEMP\\fedora\\data3";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath+"\\sections.sh"));
            //out2 = new BufferedWriter(new FileWriter("C:\\TEMP\\fedora\\data3\\"find.txt"));
            String cURLink = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"\\sections.sh")) {
                    System.out.println("text file");
                } else {
                    Object obj = parser.parse(new FileReader(file));

                    JSONObject object = (JSONObject) obj;

                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);
                    String book_id = (String) book.get("book_id").toString();

                    String sections_id = (String) book.get("dc:identifier").toString();

                    String name = file.getName();
                    String newName = sections_id + "section" + ".json";
                    String newPath = absolutePath + "/" + newName;

                    File file2 = new File(absolutePath+"\\"+newName);

                    Path from = file.toPath(); //convert from File to Path
                    Path to = file2.toPath(); //convert from String to Path

                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

                    //file.renameTo(new File(newPath));
                    cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8080/fcrepo/rest/Local_gazetteer/" + book_id + "book" + "/" + sections_id + "section";
                    out.write(cURLink + "\r\n");

                    System.out.println(name + " changed to " + newName);
                    //out2.write(name + " changed to " + newName + "\r\n");
                }
            }

            System.out.println("conversion is done");
        } catch (IOException e) {
            System.out.println("Exception ");

        } finally {
            out.close();
            //out2.close();
        }
    }
}

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

public class BooksFedoraConverter {
    private Object obj;

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        try {
            String absolutePath = "C:\\TEMP\\solrFinal7\\";
            String absolutePath2 = "C:\\TEMP\\fedoraFinal\\";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath2+"books.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath2+"books.sh")) {
                    System.out.println("text file");
                } else {
                    Object obj = parser.parse(new FileReader(file));
                    JSONObject object = (JSONObject) obj;

                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);
                    String books_id = (String) book.get("identifier");
                    String book_id_New = books_id.replace("http://www.archivesdirect.amdigital.co.uk/Documents/Details/","").replace("%20","_");

                    String name = file.getName();
                    String newName = book_id_New  + ".json";
                    String newPath = absolutePath + "\\" + newName;
                    File file2 = new File(absolutePath+newName);

                    Path from = file.toPath(); //convert from File to Path
                    Path to = file2.toPath(); //convert from String to Path

                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

                    cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8081/fcrepo/rest/AD/" + book_id_New + "book";

                    out.write(cURLink + "\r\n");

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

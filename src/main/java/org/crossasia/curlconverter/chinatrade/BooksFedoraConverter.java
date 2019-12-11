package org.crossasia.curlconverter.chinatrade;

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
            String absolutePath = "D:\\RAW-COLLECTIONS\\ChinaTradePolitics\\fedora\\splited_books\\";
            String absolutePath2 = "D:\\RAW-COLLECTIONS\\ChinaTradePolitics\\fedora\\splited_books2\\";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath+"xml2.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"xml2.sh")) {
                    System.out.println("text file");
                } else {
                    Object obj = parser.parse(new FileReader(file));
                    JSONObject object = (JSONObject) obj;

                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);
                    String books_id = (String) book.get("dcterms:identifier").toString().replace("http://www.china.amdigital.co.uk/Documents/Details/","");
                    String id = (String) book.get("id");
                    String book_id_New = books_id.replace("","").replace("","_");

                    String name = file.getName();
                    String newName = books_id  + ".json";
                    String newPath = absolutePath + "\\" + newName;
                    File file2 = new File(absolutePath+newName);

                    Path from = file.toPath(); //convert from File to Path
                    Path to = file2.toPath(); //convert from String to Path

                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
                     //"Content-Disposition: attachment; filename=115144_Folder_12.xml" --data-binary @115144_Folder_12.xml http://10.46.3.100:8081/fcrepo/rest/Adam_Matthew/115144_Folder_12book/file
                    cURLink = "curl -i -X PUT -H" + quote + "Content-Type: text/html"+quote+ " -H" +quote+"Content-Disposition: attachment; filename="+newName+ quote+" --data-binary @"+newName+ " "+"http://10.46.3.100:8091/fcrepo/rest/China_Trade/"+id+"/file";
                    //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8089/fcrepo/rest/China_America_Pacific/" + id;
                    //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + name + " " + "http://10.46.3.100:8091/fcrepo/rest/China_Trade/" + id;
                    /*cURLink = "curl -i -X PUT " +
                            "-H" + quote + "Content-Type: text/html" + quote + " " +
                            "-H" + quote + "Content-Disposition: attachment; filename="+ newName+ quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8087/fcrepo/rest/Meiji_Japan/" + id+"/file";*/

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

package org.crossasia.curlconverter.dfz;

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
            String absolutePath = "D:\\FEDORA-COLLECTIONS\\dfz_dev\\splitted_pages\\";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath+"\\pagesImages.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"\\pagesImages.sh")) {
                    System.out.println("text file");
                } else {
                    Object obj = parser.parse(new FileReader(file));

                    JSONObject object = (JSONObject) obj;

                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);

                    String book_id = (String) book.get("book_id").toString().replace("dfz-","");

                    //String sections_id = (String) book.get("dc:identifier").toString();

                    String page_id = (String) book.get("schema:position").toString();
                    String id = (String) book.get("id").toString().replaceAll("/","_");

                    String name = file.getName();
                    String newName = id +  ".json";
                    //String newPath = absolutePath + "/" + newName;

                    File file2 = new File(absolutePath+"\\"+newName);

                    Path from = file.toPath(); //convert from File to Path
                    Path to = file2.toPath(); //convert from String to Path
                    String imageName="";
                    int image= Integer.parseInt(page_id);
                    if (image<10) {
                        imageName = "0000"+image;
                    }else if (image>=10 && image<100) {
                        imageName = "000"+image;
                    } else if (image>=100 && image<1000) {
                        imageName = "00"+image;
                    }else if (image>=1000 && image<10000) {
                        imageName = "0" + image;
                    }else if (image>=10000 && image<100000) {
                        imageName =  ""+image;
                    }

                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

                    //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8095/fcrepo/rest/DFZ/" + book_id + "book" + "/"  +page_id;
                    //cURLink = "curl -i -X PUT --data-binary" + " @/data3/DFZ/dfz/" + book_id + "/" + "Page/ImageContent/" + imageName+".xml" + "" + " -H " + quote + "Content-Type: image/jpeg" + quote + " -H \"Content-Disposition: attachment; filename=" + imageName+".xml"  + "" + quote + " " + "http://10.46.3.100:8095/fcrepo/rest/DFZ/" + book_id + "/" + page_id + "/file";
                    cURLink = "curl -i -X PUT --data-binary" + " @/data3/DFZ/dfz/" + book_id + "/" + "Page/ImageContent/" + imageName+".tif" + "" + " -H " + quote + "Content-Type: image/jpeg" + quote + " -H \"Content-Disposition: attachment; filename=" + imageName+".tif"  + "" + quote + " " + "http://10.46.3.100:8095/fcrepo/rest/DFZ/" + book_id + "/" + page_id + "/file";
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

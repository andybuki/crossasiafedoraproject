package org.crossasia.curlconverter.chinaamericapacific;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class PagesFedoraConverter {

    private Object obj;

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        try {
            String absolutePath_Books = "D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\fedora\\splited_meta\\";
            String absolutePath_Pages = "D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\fedora\\splited_page\\";

            File dirBooks = new File(absolutePath_Books);
            File[] filesInDirBooks = dirBooks.listFiles();

            File dirPages = new File(absolutePath_Pages);
            File[] filesInDirPages = dirPages.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter("D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\fedora\\images.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";
            String cURLink2 = "";
            Object obj = null;
            Object obj2 = null;

            for (File file : filesInDirBooks) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                JSONParser parser2 = new JSONParser();
                ObjectMapper mapper2 = new ObjectMapper();
                String fileName = file.toString().replace("D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\splited_meta\\", "").replace(".json", "");
                if (fileName.equals(absolutePath_Books + "\\images.sh")) {
                    System.out.println("text file");
                } else {

                    obj = parser.parse(new FileReader(file));
                    JSONObject object = (JSONObject) obj;
                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);
                    String idBook = (String) book.get("id").toString();
                    String book_id = (String) book.get("book_id").toString();
                    try {
                        for (File file2 : filesInDirPages) {

                            obj2 = parser2.parse(new FileReader(file2));
                            JSONObject object2 = (JSONObject) obj2;

                            JSONArray pageArray = (JSONArray) object2.get("@graph");
                            JSONObject page = (JSONObject) pageArray.get(0);
                            String image_Name = (String) page.get("schema:image");

                            String page_id = (String) page.get("id").toString();
                            String book_id2 = (String) page.get("dcterms:isPartOf").toString();


                            String name = file2.getName();
                            //String newName = book_id+"_"+ page_id +  ".json";
                            String newName = page_id + ".json";
                            String newPath = absolutePath_Pages + "/" + newName;
                            String position = (String) page.get("schema:position");
                            //String id = (String) page.get("id");
                            String imageName = (String) page.get("schema:image");

                            //File file3 = new File(absolutePath + "\\" + newName);

                            //Path from = file2.toPath(); //convert from File to Path
                            //Path to = file2.toPath(); //convert from String to Path

                            //Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

                            if (book_id.equals(book_id2)) {
                                System.out.println("ok");

                                //file.renameTo(new File(newPath));
                                //JSONArray chapter_id = (JSONArray) book.get("fedora:hasMember");
                                //String chapter ="";
                                //for (int ch=0; ch<chapter_id.size();ch++) {
                                //chapter = (String) chapter_id.get(ch);

                                cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8089/fcrepo/rest/China_America_Pacific/" + idBook +  "/" +position;
                                //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8087/fcrepo/rest/Meiji_Japan/" + book_id +  "book/" +position;
                                //cURLink2 = "curl -i -X PUT --data-binary" + " @/data3/MeijiJapan/JPEGS/" + fileName + "/" + imageName + ".jpg" + " -H " + quote + "Content-Type: image/jpeg" + quote + " -H \"Content-Disposition: attachment; filename=" + imageName + ".jpg" + quote + " " + "http://10.46.3.100:8087/fcrepo/rest/Meiji_Japan/" + book_id + "book/" + position + "/file";
                                //out.write(cURLink + "\r\n");
                                out.write(cURLink + "\r\n");
                                //}
                            }
                            //System.out.println(name + " changed to " + newName);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                        continue;   // go to the top of the for loop
                    }
                    System.out.println(fileName );
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

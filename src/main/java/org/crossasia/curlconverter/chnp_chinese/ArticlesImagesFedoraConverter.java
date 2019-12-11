package org.crossasia.curlconverter.chnp_chinese;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ArticlesImagesFedoraConverter {
    private Object obj;

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        try {
            String absolutePath = "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\articles\\articleSmall\\";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            out = new BufferedWriter(new FileWriter(absolutePath+"images.sh"));
            //PrintWriter out = new PrintWriter( "/Users/andreybuchmann/Downloads/camel-to-solr-master/camelsolr/data/filename.txt" );
            String cURLink = "";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"images.sh")) {
                    System.out.println("text file");
                } else {
                    Object obj = parser.parse(new FileReader(file));
                    JSONObject object = (JSONObject) obj;

                    JSONArray booksArray = (JSONArray) object.get("@graph");
                    JSONObject book = (JSONObject) booksArray.get(0);
                    String books_id = (String) book.get("id_level1").toString();
                    String journal_id = (String) book.get("journal_id").toString();
                    String id = (String) book.get("id").toString();
                    String imageName = id.replaceAll("-[^-]*$","");
                    String [] page = book.get("schema:position").toString().split("-");
                    int pageStart = Integer.parseInt(page[0]);
                    int pageEnd = Integer.parseInt(page[1]);
                    int diff =0;
                    int imageNumber;
                    String name = file.getName();
                    String newName = id  + ".json";
                    String newPath = absolutePath + "\\" + newName;
                    File file2 = new File(absolutePath+newName);

                    Path from = file.toPath(); //convert from File to Path
                    Path to = file2.toPath(); //convert from String to Path

                    Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);


                    if (pageEnd-pageStart==0) {
                        imageNumber =diff;
                        cURLink = "curl -i -X PUT --data-binary" + " @/data3/chnp_2016_chinese/CHNPF0001-C00000/" + journal_id + "/"  + imageName+".jpg" + "" + " -H " + quote + "Content-Type: image/jpeg" + quote + " -H \"Content-Disposition: attachment; filename=" + imageName+".jpg"  + "" + quote + " " + "http://10.46.3.100:8097/fcrepo/rest/Gale-CFER/" + books_id + "/" + journal_id +"/"+id+"/image";
                        out.write(cURLink + "\r\n");
                    }else {
                        imageNumber =pageEnd-pageStart;
                        for (int t=0; t<imageNumber;t++) {
                            String jornal_idSmall= imageName.replaceAll(".json","");
                            String [] splitterJournal_Id = jornal_idSmall.split("-");
                            String split_last = splitterJournal_Id[3];
                            int split_last2 = Integer.parseInt(split_last);
                            int newImage=0;
                            if (t==0){
                                newImage = split_last2 + t+10;
                            } else {
                                newImage = split_last2 + t*10;
                            }

                            String newImageConstructor="";
                            if (newImage<100){
                                 newImageConstructor = splitterJournal_Id[0]+"-"+splitterJournal_Id[1]+"-"+splitterJournal_Id[2]+"-000"+newImage+".jpg";
                            }else if (newImage<1000) {
                                 newImageConstructor = splitterJournal_Id[0]+"-"+splitterJournal_Id[1]+"-"+splitterJournal_Id[2]+"-00"+newImage+".jpg";
                            } else {
                                newImageConstructor = splitterJournal_Id[0]+"-"+splitterJournal_Id[1]+"-"+splitterJournal_Id[2]+"-0"+newImage+".jpg";
                            }
                            cURLink = "curl -i -X PUT --data-binary" + " @/data3/chnp_2016_chinese/CHNPF0001-C00000/" + journal_id + "/"  + newImageConstructor + "" + " -H " + quote + "Content-Type: image/jpeg" + quote + " -H \"Content-Disposition: attachment; filename=" + newImageConstructor  + "" + quote + " " + "http://10.46.3.100:8097/fcrepo/rest/Gale-CFER/" + books_id + "/" + journal_id +"/"+id+"/image_"+t+1;
                            out.write(cURLink + "\r\n");
                        }
                    }


                    //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + newName + " " + "http://10.46.3.100:8097/fcrepo/rest/Gale-CGER/" + books_id+"/"+journal_id+"/"+id;



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

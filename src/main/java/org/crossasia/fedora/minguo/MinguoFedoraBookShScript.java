package org.crossasia.fedora.minguo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MinguoFedoraBookShScript {

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        try {
            String absolutePath = "/data1/fedora/ajax-minguo/p/pages_json3/";
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
                    String shortName = file.getName().substring(0,3);
                    String name_cut = name.replace(".xml","");
                    cURLink = "curl -u fedoraAdmin:fedoraAdmin -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + name + " " + "http://b-lx0005.sbb.spk-berlin.de:8081/fcrepo/rest/ajax-mingoo/" + shortName +"/" + name.replace("_","/").replace(".json","");
                    //cURLink = "curl -i -X PUT --data-binary" + " @/mnt/fedora/raw/amd_fo_japan/xml/" + name + "" + " -H " + quote + "Content-Type: application/xhtml+xml" + quote + " -H \"Content-Disposition: attachment; filename=" + name  + "" + quote + " " + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/amd_fo_japan/" + name_cut+"/xml";
                    out.write(cURLink + "\r\n");
                    //System.out.println(name + " changed to " + newName);
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

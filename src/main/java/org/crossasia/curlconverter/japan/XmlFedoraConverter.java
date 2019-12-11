package org.crossasia.curlconverter.japan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XmlFedoraConverter {
    private Object obj;

    public static void main(String[] argv) throws IOException, ParseException {
        BufferedWriter out = null;
        try {
            String absolutePath = "P:\\Crossasia FID\\AMD\\FOJapan\\xml\\";
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
                if (fileName.equals(absolutePath+"books.sh")) {
                    System.out.println("text file");
                } else {
                    String name = file.getName();
                    String name_cut = name.replace(".xml","");
                    //cURLink = "curl -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + name + " " + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/amd_fo_japan/" + name;
                    cURLink = "curl -i -X PUT --data-binary" + " @/mnt/fedora/raw/amd_fo_japan/xml/" + name + "" + " -H " + quote + "Content-Type: application/xhtml+xml" + quote + " -H \"Content-Disposition: attachment; filename=" + name  + "" + quote + " " + "http://b-lx0005.sbb.spk-berlin.de:8080/fcrepo/rest/amd_fo_japan/" + name_cut+"/xml";
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

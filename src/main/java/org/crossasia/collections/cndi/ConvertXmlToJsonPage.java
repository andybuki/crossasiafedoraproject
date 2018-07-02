package org.crossasia.collections.cndi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ConvertXmlToJsonPage {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\CNDI\\cnki3\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CNDI\\pages2.json"));
        PrintStream out2 = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CNDI\\no_genetiv.json"));
        String bookName = "";
        String page = "";
        String text = "";
        //String quote = "\u005c\u0022";
        String quote = "§§§";
        int year = 0;
        int i;


        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);
            JSONParser parser = new JSONParser();

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString().replaceAll(quote+quote+quote,"\"");
                String fileName = file.toString();
                String book_id =fileName.replace("D:\\SOLR-COLLECTIONS\\CNDI\\cnki3\\","").replace(".txt","").split("_")[0];
                int position = Integer.parseInt(fileName.replace("D:\\SOLR-COLLECTIONS\\CNDI\\cnki3\\","").replace(".txt","").split("_")[1]);
                //if (everything.contains("的") || everything.contains("之")){
                String id = fileName.replace("D:\\SOLR-COLLECTIONS\\CNDI\\cnki3\\","").replace(".txt","")+"cnki";

                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" + quote + "Page"  + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" +  quote + book_id +  quote + "," + '\n'
                            + quote + "position" + quote + ":" +  quote + position +  quote + "," + '\n'
                            + quote + "language" + quote + ":" +  quote + "chi"  + quote +"," + '\n'
                            + quote + "collection" + quote + ":" + quote+  "CNKI_eBooks"  + quote+ "," + '\n'
                            + quote + "text" + quote + ":" + quote+  everything  + quote+ "" + '\n'
                            +"},"
                    );





            } finally {
                br.close();
            }
        }

    }
}

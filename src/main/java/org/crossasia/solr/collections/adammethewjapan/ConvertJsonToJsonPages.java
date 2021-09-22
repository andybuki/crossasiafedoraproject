package org.crossasia.solr.collections.adammethewjapan;

import org.json.simple.parser.JSONParser;

import java.io.*;

public class ConvertJsonToJsonPages {
    public static void main(String[] args) throws Exception{

        File dir = new File("C:\\TEMP\\fedora\\splited_pages\\");
        PrintStream out = new PrintStream(new FileOutputStream("C:\\TEMP\\fedora\\pages.json"));
        String bookName = "";
        String page = "";

        String quote = "\u005c\u0022";
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
                String everything = sb.toString();
                //String textReplace =  everything.replace("\r\n"," ").replace("\f","");
                String fileName = file.toString();
                //String fileName1 = fileName.replace("/Users/andreybuchmann/Downloads/JOBIK/xml2/", "");
                Object obj = parser.parse(new FileReader(file));
                org.json.simple.JSONArray object = (org.json.simple.JSONArray) obj;

                for (int k=0; k<object.size();k++) {
                    org.json.simple.JSONObject book = (org.json.simple.JSONObject) object.get(k);
                    String text = "";
                    String id = (String) book.get("id").toString();
                    String hasModel = (String) book.get("hasModel");
                    String position = (String) book.get("position").toString();
                    String book_id = (String) book.get("book_id");
                    String image_file = (String) book.get("image_file");
                    String image_url = (String) book.get("image_url").toString();

                    if (book.containsKey("text")) {
                        text = (String) book.get("text").toString().replaceAll("\\r\\n"," ").replaceAll("\"","");
                    }

                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +  quote+  hasModel  +  quote+"," + '\n'
                            + quote + "position" + quote + ":" +  quote+  position + quote+ "," + '\n'
                            + quote + "book_id" + quote + ":" + quote +  book_id  + quote + "," + '\n'
                            + quote + "collection" + quote + ":" + quote+  "Adam Matthew – FO Japan"  + quote+ "," + '\n'
                            + quote + "image_file" + quote + ":" +   quote+ image_file  + quote+ "," + '\n'
                            + quote + "language" + quote + ":" +  quote+ "eng"  +quote+ "," + '\n'
                            + quote + "image_url" + quote + ":" +   quote+ image_url + quote + "," + '\n'
                            + quote + "text" + quote + ":" + quote+  text  +quote+ "" + '\n'
                            +"},"
                    );
                }

            } finally {
                br.close();
            }
        }

    }
}

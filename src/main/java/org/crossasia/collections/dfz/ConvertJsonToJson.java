package org.crossasia.collections.dfz;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;

public class ConvertJsonToJson {
    public static void main(String[] args) throws Exception{

        File dir = new File("D:\\SOLR-COLLECTIONS\\dfz_dev\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\dfz_dev\\solr_books.json"));
        String bookName = "";
        String page = "";
        String text = "";
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

                    String id = (String) book.get("id").toString();
                    org.json.simple.JSONArray contained_in = (org.json.simple.JSONArray) book.get("contained_in");
                    org.json.simple.JSONArray creator = (org.json.simple.JSONArray) book.get("creator");
                    org.json.simple.JSONArray creator_transcription = (org.json.simple.JSONArray) book.get("creator_transcription");
                    org.json.simple.JSONArray edition = (org.json.simple.JSONArray) book.get("edition");
                    org.json.simple.JSONArray temporal = (org.json.simple.JSONArray) book.get("temporal");
                    org.json.simple.JSONArray hasModel = (org.json.simple.JSONArray) book.get("hasModel");
                    String collection = (String) book.get( "collection" ).toString();
                    org.json.simple.JSONArray identifier = (org.json.simple.JSONArray) book.get("identifier");
                    String book_id ="";
                    if (identifier.get(0).toString().contains("dfz")) {
                        book_id  = identifier.get(0).toString();
                    } else if (identifier.get(1).toString().contains("dfz")) {
                        book_id  = identifier.get(1).toString();
                    }


                    boolean book_id2 = book_id.startsWith("type=");
                    String book_id3="";

                    if (book_id2==true) {
                        String ind0 = identifier.get(0).toString();
                        String ind1 = identifier.get(1).toString();
                        if (ind0.startsWith("type=\"Diaolong")) {
                            book_id3=ind0.replace("type=\"Diaolong","");
                        } else {
                            book_id3=ind1.replace("type=\"Diaolong","");
                        }

                    }else {
                        book_id3 = book_id;
                    }

                    String book_id4 = book_id3.replace("\" ", "");
                    org.json.simple.JSONArray language = (org.json.simple.JSONArray) book.get("language");
                    org.json.simple.JSONArray issued = (org.json.simple.JSONArray) book.get("issued");
                    org.json.simple.JSONArray note = (org.json.simple.JSONArray) book.get("note");
                    org.json.simple.JSONArray medium = (org.json.simple.JSONArray) book.get("medium");
                    org.json.simple.JSONArray spatial = (org.json.simple.JSONArray) book.get("spatial");
                    org.json.simple.JSONArray publisher = (org.json.simple.JSONArray) book.get("publisher");
                    org.json.simple.JSONArray series_title = (org.json.simple.JSONArray) book.get("series_title");
                    org.json.simple.JSONArray series_title_transcription = (org.json.simple.JSONArray) book.get("series_title_transcription");
                    org.json.simple.JSONArray subject = (org.json.simple.JSONArray) book.get("subject");
                    String thumbnail_path = (String) book.get( "thumbnail_path" ).toString();
                    org.json.simple.JSONArray title = (org.json.simple.JSONArray) book.get("title");
                    org.json.simple.JSONArray title_responsibility = (org.json.simple.JSONArray) book.get("title_responsibility");
                    org.json.simple.JSONArray title_transcription = (org.json.simple.JSONArray) book.get("title_transcription");


                    out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                            //+ quote + "contained_in" + quote + ":" +  contained_in  + "," + '\n'
                            + quote + "creator" + quote + ":" +   creator +   "," + '\n'
                            //+ quote + "creator_transcription" + quote + ":" +    creator_transcription    + "," + '\n'
                            + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                            //+ quote + "temporal" + quote + ":" +   temporal  + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   hasModel  + "," + '\n'
                            + quote + "collection" + quote + ":" + quote+  collection  + quote+ "," + '\n'
                            + quote + "book_id" + quote + ":" +   quote+ book_id4  + quote+ "," + '\n'
                            + quote + "identifier" + quote + ":" +   identifier  + "," + '\n'
                            + quote + "language" + quote + ":" +  quote+ "chi"  +quote+ "," + '\n'
                            + quote + "issued" + quote + ":" +   issued  + "," + '\n'
                            //+ quote + "note" + quote + ":" +   note  + "," + '\n'
                            //+ quote + "medium" + quote + ":" +   medium  + "," + '\n'
                            + quote + "spatial" + quote + ":" +   spatial  + "," + '\n'
                            //+ quote + "publisher" + quote + ":" +   publisher  + "," + '\n'
                            + quote + "series_title" + quote + ":" +   series_title  + "," + '\n'
                            //+ quote + "series_title_transcription" + quote + ":" +   series_title_transcription  + "," + '\n'
                            //+ quote + "subject" + quote + ":" +   subject  + "," + '\n'
                            + quote + "thumbnail_path" + quote + ":" +   quote+ thumbnail_path + quote + "," + '\n'
                            + quote + "title" + quote + ":" +   title  + "," + '\n'
                            + quote + "title_responsibility" + quote + ":" +   title_responsibility  + "" + '\n'
                            //+ quote + "title_transcription" + quote + ":" +   title_transcription  + "" + '\n'
                            //'\n'
                            +"},"
                    );
                }

            } finally {
                br.close();
            }
        }

    }
}

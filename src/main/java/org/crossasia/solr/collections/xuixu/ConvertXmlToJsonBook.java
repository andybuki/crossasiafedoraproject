package org.crossasia.solr.collections.xuixu;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ConvertXmlToJsonBook {
    public static void main( String[] args ) throws Exception {

        File dir = new File("/data3/solr/Xuixu\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\RAW-COLLECTIONS\\Xuixu\\solr_books.json"));
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
                JSONArray object = (JSONArray) obj;

                for (int k=0; k<object.size();k++) {
                    JSONObject book = (JSONObject) object.get(k);

                    String id = (String) book.get("id").toString();
                    JSONArray contained_in = (JSONArray) book.get("contained_in");
                    JSONArray creator = (JSONArray) book.get("creator");
                    JSONArray creator_transcription = (JSONArray) book.get("creator_transcription");
                    JSONArray edition = (JSONArray) book.get("edition");
                    JSONArray genre = (JSONArray) book.get("genre");
                    JSONArray hasModel = (JSONArray) book.get("hasModel");
                    String collection = (String) book.get( "collection" ).toString();
                    JSONArray identifier = (JSONArray) book.get("identifier");
                    String book_id  = (String) book.get( "book_id" ).toString();
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
                    JSONArray language = (JSONArray) book.get("language");
                    JSONArray issued = (JSONArray) book.get("issued");
                    JSONArray note = (JSONArray) book.get("note");
                    JSONArray medium = (JSONArray) book.get("medium");
                    JSONArray spatial = (JSONArray) book.get("spatial");
                    JSONArray publisher = (JSONArray) book.get("publisher");
                    JSONArray series_title = (JSONArray) book.get("series_title");
                    JSONArray series_title_transcription = (JSONArray) book.get("series_title_transcription");
                    JSONArray subject = (JSONArray) book.get("subject");
                    String thumbnail_path = (String) book.get( "thumbnail_path" ).toString();
                    JSONArray title = (JSONArray) book.get("title");
                    JSONArray title_transcription = (JSONArray) book.get("title_transcription");


                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "contained_in" + quote + ":" +  contained_in  + "," + '\n'
                        + quote + "creator" + quote + ":" +   creator +   "," + '\n'
                        + quote + "creator_transcription" + quote + ":" +    creator_transcription    + "," + '\n'
                        + quote + "edition" + quote + ":" +   edition  + "," + '\n'
                        + quote + "genre" + quote + ":" +   genre  + "," + '\n'
                        + quote + "hasModel" + quote + ":" +   hasModel  + "," + '\n'
                        + quote + "collection" + quote + ":" + quote+  collection  + quote+ "," + '\n'
                        + quote + "book_id" + quote + ":" +   quote+ book_id4  + quote+ "," + '\n'
                        + quote + "identifier" + quote + ":" +   identifier  + "," + '\n'
                        + quote + "language" + quote + ":" +   language  + "," + '\n'
                        + quote + "issued" + quote + ":" +   issued  + "," + '\n'
                        + quote + "note" + quote + ":" +   note  + "," + '\n'
                        + quote + "medium" + quote + ":" +   medium  + "," + '\n'
                        + quote + "spatial" + quote + ":" +   spatial  + "," + '\n'
                        + quote + "publisher" + quote + ":" +   publisher  + "," + '\n'
                        + quote + "series_title" + quote + ":" +   series_title  + "," + '\n'
                        + quote + "series_title_transcription" + quote + ":" +   series_title_transcription  + "," + '\n'
                        + quote + "subject" + quote + ":" +   subject  + "," + '\n'
                        + quote + "thumbnail_path" + quote + ":" +   quote+ thumbnail_path + quote + "," + '\n'
                        + quote + "title" + quote + ":" +   title  + "," + '\n'
                        + quote + "title_transcription" + quote + ":" +   title_transcription  + "" + '\n'
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

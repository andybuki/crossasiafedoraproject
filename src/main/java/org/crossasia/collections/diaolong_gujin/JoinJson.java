package org.crossasia.collections.diaolong_gujin;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJson {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            JSONObject jsonObject;
            String books = "D:\\SOLR-COLLECTIONS\\diaolong-jiyao\\books.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\diaolong-jiyao\\books_new.json"));
            JSONArray bookObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

            String id="";
            String citation="";
            String creator_transcription="";
            String edition="";
            String hasModel ="";
            String collection ="";
            String identifier="";
            String issued ="";
            String language ="";
            String physical_description ="";
            String publication_place ="";
            String publisher ="";
            String series_title ="";
            String subject ="";
            String thumbnail_path ="";
            String title_responsibility ="";
            String title ="";
            String title_transcription ="";
            String book_id="";
            String author ="";
            String note ="";
            String series_title_transcription="";



            for (int i=0; i<bookObject.length(); i++) {
                JSONObject numerObj = (JSONObject) bookObject.get(i);
                id = (String) numerObj.get("id").toString();
                citation = (String) numerObj.get("citation").toString();
                if (numerObj.has("creator_transcription"))
                creator_transcription = (String) numerObj.get("creator_transcription").toString();
                if (numerObj.has("edition"))
                edition = (String) numerObj.get("edition").toString();
                hasModel = (String) numerObj.get("hasModel").toString();
                collection = (String) numerObj.get("collection").toString();
                identifier = (String) numerObj.get("identifier").toString();
                String[] spliter = identifier.replaceAll("","").replaceAll("]","").split(",");
                //JSONObject indentify = (JSONObject) numerObj.get(identifier);
                String ident1 = spliter[0];
                String ident2 = spliter[1];


                if (ident1.contains("Diaolong_DaoZangJiYao")){
                    book_id = ident1;
                } else if (ident2.contains("Diaolong_DaoZangJiYao")) {
                    book_id = ident2;
                }



                issued = (String) numerObj.get("issued").toString();
                language =(String) numerObj.get("language").toString();
                physical_description = (String) numerObj.get("physical_description").toString();
                publication_place = (String) numerObj.get("publication_place").toString();
                publisher = (String) numerObj.get("publisher").toString();
                series_title = (String) numerObj.get("series_title").toString();
                if (numerObj.has("subject"))
                subject = (String) numerObj.get("subject").toString();
                thumbnail_path = (String) numerObj.get("thumbnail_path").toString();
                if (numerObj.has("title_responsibility"))
                title_responsibility = (String) numerObj.get("title_responsibility").toString();
                title = (String) numerObj.get("title").toString();
                title_transcription=(String) numerObj.get("title_transcription").toString();
                if (numerObj.has("author"))
                author=(String) numerObj.get("author").toString();
                note=(String) numerObj.get("note").toString();
                series_title_transcription=(String) numerObj.get("series_title_transcription").toString();



                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + book_id+  "," + '\n'
                                + quote + "citation" + quote + ":"     +citation+   "," + '\n'
                                + quote + "creator_transcription" + quote + ":" + creator_transcription +   "," + '\n'
                                + quote + "edition" + quote + ":" +   edition +  ","+ '\n'

                                + quote + "hasModel" + quote + ":" + quote+ hasModel+ quote + "," + '\n'
                                + quote + "collection" + quote + ":" + quote+ collection+ quote + "," + '\n'
                                + quote + "identifier" + quote + ":" +   identifier +  ","+ '\n'
                                + quote + "issued" + quote + ":" +   issued +  ","+ '\n'
                                + quote + "language" + quote + ":" +   language +  ","+ '\n'
                                + quote + "physical_description" + quote + ":" +   physical_description +  ","+ '\n'

                                + quote + "publication_place" + quote + ":" +   publication_place +  ","+ '\n'
                                + quote + "publisher" + quote + ":" +   publisher +  ","+ '\n'
                                + quote + "series_title" + quote + ":" +   series_title +  ","+ '\n'
                                + quote + "subject" + quote + ":" +   subject +  ","+ '\n'
                                + quote + "thumbnail_path" + quote + ":" + quote+ thumbnail_path+ quote + "," + '\n'
                                + quote + "title_responsibility" + quote + ":" +   title_responsibility +  ","+ '\n'
                                + quote + "title" + quote + ":" +   title +  ","+ '\n'
                                + quote + "title_transcription" + quote + ":" +   title_transcription + ","+ '\n'
                                + quote + "author" + quote + ":" +   author + ","+ '\n'
                                + quote + "note" + quote + ":" +   note + ","+ '\n'
                                + quote + "series_title_transcription" + quote + ":" +   series_title_transcription + ""+ '\n'
                                +"},"
                        );


            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

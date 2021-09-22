package org.crossasia.solr.collections.xuixu;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TransformBooks {
    public static void main(String[] args) throws FileNotFoundException {


        String books = "/data3/solr/xuixu/books.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/xuixu/books_new.json"));

        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        String line = "\u007C";

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String responsibility ="";
            String url ="";
            String id ="";
            String ids = "";

            JSONArray book_id = null;
            int page = 0;
            String position = "";

            String text = "";

            JSONArray identifier = null;
            JSONArray note = null;
            JSONArray author = null;
            JSONArray date = null;
            JSONArray series_title_transcription= null;

            JSONArray subject= null;
            JSONArray edition= null;
            JSONArray title_transcription= null;
            JSONArray title= null;
            JSONArray publication_place= null;
            JSONArray series_title= null;
            String thumbnail_path= "";
            JSONArray creator_transcription= null;

            JSONArray publisher= null;
            JSONArray temporal= null;
            JSONArray physical_description= null;
            JSONArray bibliographic_citation= null;




            JSONObject booksObj = (JSONObject) booksObject.get(i);


            id = (String) booksObj.get("id");

            book_id =  (JSONArray) booksObj.get("identifier");

            String books_id = (String) book_id.get(1).toString();

            String books_id2 = (String) book_id.get(0).toString();
            String bk="";

            if (books_id.contains("type=\"Diaolong\"")) {
                books_id = (String) book_id.get(1).toString().replace("type=\"Diaolong\" ","").replaceAll("\"","");
                bk = books_id;
            } else if (books_id2.contains("type=\"Diaolong\"")){
                books_id2 = (String) book_id.get(0).toString().replace("type=\"Diaolong\" ","").replaceAll("\"","");

                bk =books_id2;
            }

            if (booksObj.has("identifier"))
                identifier  = (JSONArray) booksObj.get("identifier");
            if (booksObj.has("note"))
                note  = (JSONArray) booksObj.get("note");
            if (booksObj.has("creator"))
                author  = (JSONArray) booksObj.get("creator");
            if (booksObj.has("series_title_transcription"))
                series_title_transcription  = (JSONArray) booksObj.get("series_title_transcription");
            if (booksObj.has("date"))
                date  = (JSONArray) booksObj.get("date");
            if (booksObj.has("subject"))
                subject  = (JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition  = (JSONArray) booksObj.get("edition");
            if (booksObj.has("title_transcription"))
                title_transcription  = (JSONArray) booksObj.get("title_transcription");
            if (booksObj.has("title"))
                title  = (JSONArray) booksObj.get("title");
            if (booksObj.has("temporal"))
                temporal  = (JSONArray) booksObj.get("temporal");
            if (booksObj.has("publication_place"))
                publication_place  = (JSONArray) booksObj.get("publication_place");


            if (booksObj.has("series_title"))
                series_title  = (JSONArray) booksObj.get("series_title");
            if (booksObj.has("thumbnail_path"))
                thumbnail_path = (String) booksObj.get("thumbnail_path");
            if (booksObj.has("creator_transcription"))
                creator_transcription  = (JSONArray) booksObj.get("creator_transcription");
            if (booksObj.has("publisher"))
                publisher  = (JSONArray) booksObj.get("publisher");
            if (booksObj.has("physical_description"))
                physical_description  = (JSONArray) booksObj.get("physical_description");
            if (booksObj.has("bibliographic_citation"))
                bibliographic_citation  = (JSONArray) booksObj.get("bibliographic_citation");

            String book="Book";
            String lang ="chi";
            String collection ="Xuixu";

            out.println("{"

                    + quote + "id" + quote + ":" + quote + id + quote + "," +  '\n'
                    + quote + "book_id" + quote + ":" + quote + bk + quote + "," +  '\n'


                    + quote + "identifier" + quote + ":"  + identifier  + "," +  '\n'
                    + quote + "note" + quote + ":"  + note  + "," +  '\n'


                    + quote + "author" + quote + ":"  + author  + "," +  '\n'
                    + quote + "series_title_transcription" + quote + ":"  + series_title_transcription  + "," +  '\n'


                    + quote + "date" + quote + ":"  + date  + "," +  '\n'
                    + quote + "subject" + quote + ":"  + subject  + "," +  '\n'
                    + quote + "edition" + quote + ":"  + edition  + "," +  '\n'
                    + quote + "title_transcription" + quote + ":"  + title_transcription  + "," +  '\n'
                    + quote + "title" + quote + ":"  + title  + "," +  '\n'
                    + quote + "temporal" + quote + ":"  + temporal  + "," +  '\n'


                    + quote + "publication_place" + quote + ":"  + publication_place  + "," +  '\n'



                    + quote + "series_title" + quote + ":"  + series_title  + "," +  '\n'


                    + quote + "thumbnail_path" + quote + ":"  +quote +thumbnail_path +quote + "," +  '\n'



                    + quote + "creator_transcription" + quote + ":"  + creator_transcription  + "," +  '\n'



                    + quote + "publisher" + quote + ":"  + publisher  + "," +  '\n'


                    + quote + "physical_description" + quote + ":"  + physical_description  + "," +  '\n'
                    + quote + "bibliographic_citation" + quote + ":"  + bibliographic_citation  + "," +  '\n'
                    + quote + "hasModel" + quote + ":" + quote + "Book" + quote + "," +  '\n'
                    + quote + "language" + quote + ":" + quote + lang + quote + "," + '\n'
                    + quote + "collection" + quote + ":" + quote + "Xuixu" + quote + "" +  '\n'

                    +"},"
            );







        }
        //out.println(sb);
    }
}

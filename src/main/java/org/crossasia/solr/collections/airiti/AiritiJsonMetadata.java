package org.crossasia.solr.collections.airiti;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AiritiJsonMetadata {

    public static void main( String[] args ) throws Exception {

        String journal = "/data1/solr/Airiti/books2.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/Airiti/books3.json"));
        String quote = "\u005c\u0022";
        JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(journal)));
        String bookName = "";

        StringBuilder sb = new StringBuilder();

        for (int k=0; k<jsonArray.length();k++) {
            String title ="";
            String title_transcription ="";
            String creator_transcription ="";
            String author ="";
            String medium ="";
            String keywords ="[]";
            String publication_place ="";
            String publisher ="";
            String subject_xsi_type="";
            String series_title="";
            String series_title_transcription="";
            String alternative="";
            String description="";
            String mods_genre="";
            String subject="";
            String identifier="";
            String identifier_xsi_type_CrossAsia_Link="";
            String source="";
            String publication_id="";

            JSONObject book = (JSONObject) jsonArray.get(k);
            String id = (String) book.get("id");
            String book_id = (String) book.get("book_id");
            int date = (int) book.get("date");

            if (book.has("series_title_transcription")) {
                series_title_transcription = (String) book.get("series_title_transcription");
            }

            if (book.has("series_title")) {
                series_title = (String) book.get("series_title");
            }

            if (book.has("description")) {
                description = (String) book.get("description");
            }

            if (book.has("alternative")) {
                alternative = (String) book.get("alternative");
            }

            if (book.has("source")) {
                source = (String) book.get("source");
            }
            if (book.has("publication_id")) {
                publication_id = (String) book.get("publication_id");
            }
            if (book.has("identifier_xsi_type_CrossAsia_Link")) {
                identifier_xsi_type_CrossAsia_Link = (String) book.get("identifier_xsi_type_CrossAsia_Link");
            }
            if (book.has("identifier")) {
                identifier = (String) book.get("identifier");
            }
            if (book.has("subject")) {
                subject = (String) book.get("subject");
            }
            if (book.has("subject_xsi_type")) {
                subject_xsi_type = (String) book.get("subject_xsi_type").toString();
            }
            if (book.has("mods_genre")) {
                mods_genre = (String) book.get("mods_genre");
            }
            if (book.has("author")) {
                author = (String) book.get("author").toString();
            }
            if (book.has("publisher")) {
                publisher = (String) book.get("publisher");
            }
            if (book.has("publication_place")) {
                publication_place = (String) book.get("publication_place");
            }
            if (book.has("keywords")) {
                keywords = (String) book.get("keywords").toString();
            }
            if (book.has("title")) {
                title = (String) book.get("title");
            }

            if (book.has("medium")) {
                medium = (String) book.get("medium").toString();
            }

            if (book.has("title_transcription")) {
                title_transcription = (String) book.get("title_transcription").toString();
            }
            if (book.has("creator_transcription")) {
                creator_transcription = (String) book.get("creator_transcription").toString();
            }


            sb.append("{" + quote + "id" + quote + ":" + quote + id +  quote + "," + '\n'
                    + quote + "hasModel" + quote + ":" +  quote +"Book" + quote + "," + '\n'
                    + quote + "collection" + quote + ":" + quote + "Airiti" + quote + "," + '\n'
                    + quote + "title" + quote + ":" + quote + title + quote + "," + '\n'
                    + quote + "title_transcription" + quote + ":" +   title_transcription  + "," + '\n'
                    + quote + "creator_transcription" + quote + ":" +  creator_transcription  + "," + '\n'
                    + quote + "author" + quote + ":" +  author  + "," + '\n'
                    + quote + "language" + quote + ":" +  quote +"chi" + quote + "," + '\n'
                    + quote + "medium" + quote + ":" +  medium  + "," + '\n'
                    + quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n'
                    + quote + "date" + quote + ":" +  date  + "," + '\n'
                    + quote + "keywords" + quote + ":" +  keywords  + "," + '\n'
                    + quote + "series_title" + quote + ":" + quote + series_title + quote + "," + '\n'
                    + quote + "series_title_transcription" + quote + ":" + quote + series_title_transcription+ quote  + "," + '\n'
                    + quote + "alternative" + quote + ":" + quote + alternative + quote + "," + '\n'
                    + quote + "publication_place" + quote + ":" + quote + publication_place + quote + "," + '\n'
                    + quote + "publisher" + quote + ":" + quote + publisher + quote + "," + '\n'
                    + quote + "description" + quote + ":" + quote + description + quote + "," + '\n'
                    + quote + "mods_genre" + quote + ":" + quote + mods_genre + quote + "," + '\n'
                    + quote + "subject_xsi_type" + quote + ":" + quote + subject_xsi_type + quote + "," + '\n'
                    + quote + "subject" + quote + ":" + quote + subject + quote + "," + '\n'
                    + quote + "identifier" + quote + ":" + quote + identifier + quote + "," + '\n'
                    + quote + "identifier_xsi_type_CrossAsia_Link" + quote + ":" + quote + identifier_xsi_type_CrossAsia_Link + quote + "," + '\n'
                    + quote + "source" + quote + ":" + quote + source + quote + "," + '\n'
                    + quote + "publication_id" + quote + ":" + quote + publication_id + quote + "," + '\n'+
                     "},"
            );
        }
        out.println("["+sb.deleteCharAt(sb.length() - 1)+"]");
    }

}

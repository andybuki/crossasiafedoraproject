package org.crossasia.solr.collections.cnki;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BookErfLink {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/CNKI/books/books.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/CNKI/books2.json"));
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String edition ="";
            String responsibility ="";
            String url ="";
            String erflink ="";
            JSONArray title_transcription= null;
            String date = "";
            JSONArray identifier = null;
            String book_id = "";
            String id = "";
            String source = "";
            String publisher = "";
            String title = "";
            String thumbnail_path = "";


            String issued = "";
            String ISBN = "";

            //String series_title = "";
            JSONArray description = null;
            JSONArray medium = null;
            JSONArray subject = null;
            JSONArray citation = null;
            String language = "";
            String series_title = "";
            JSONArray series_title_transcription = null;
            JSONArray person = null;
            JSONArray author = null;
            JSONArray alternative = null;
            JSONArray creator_transcription= null;

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            if (booksObj.has("title_transcription")) {
                title_transcription = (JSONArray) booksObj.get("title_transcription");
            }
            book_id = (String) booksObj.get("book_id").toString();
            if (booksObj.has("ISBN"))
                ISBN = (String) booksObj.get("ISBN").toString();

            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();

            if (booksObj.has("responsibility"))
                responsibility = (String) booksObj.get("responsibility").toString();

            if (booksObj.has("publisher"))
                publisher = (String) booksObj.get("publisher").toString();

            if (booksObj.has("alternative"))
                alternative = (JSONArray) booksObj.get("alternative");

            if (booksObj.has("creator_transcription"))
                creator_transcription = (JSONArray) booksObj.get("creator_transcription");
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("thumbnail_path")) {
                thumbnail_path  = (String) booksObj.get("thumbnail_path");
            }

            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(String) booksObj.get("edition").toString();
            if (booksObj.has("series_title"))
                series_title =(String) booksObj.get("series_title");

            if (booksObj.has("series_title_transcription"))
                series_title_transcription =(JSONArray) booksObj.get("series_title_transcription");

            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");
            if (booksObj.has("citation"))
                citation =(JSONArray) booksObj.get("citation");
            if (identifier.get(0).toString().contains("http://")) {
                url = identifier.get(0).toString();
            } else if (identifier.get(1).toString().contains("http://")) {
                url = identifier.get(1).toString();
            }
            String url2 = url.replace("http://","");
            erflink =  "http://erf.sbb.spk-berlin.de/han/cnki-books/"+url2;

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (author!=null) {
                sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
            }

            if (citation!=null) {
                sb.append(quote + "citation" + quote + ":" +  citation  + "," + '\n');
            }

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

            if (creator_transcription!=null)
                sb.append(  quote + "creator_transcription" + quote + ":" +  creator_transcription+  "," + '\n');


            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n');

            if (thumbnail_path!=null)
                sb.append(  quote + "thumbnail_path" + quote + ":" + quote+ thumbnail_path+ quote + "," + '\n');

            if (publisher!=null)
                sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+ quote + "," + '\n');


            if (erflink!=null)
                sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n');

            if (date!=null)
                sb.append(  quote + "date" + quote + ":" +  date+  "," + '\n');
            if (issued!=null)
                sb.append(  quote + "issued" + quote + ":" +quote+  issued+ quote+ "," + '\n');

            if (responsibility!=null)
                sb.append(  quote + "responsibility" + quote + ":" +quote+  responsibility+ quote+ "," + '\n');

            if (ISBN!=null)
                sb.append(  quote + "ISBN" + quote + ":" + quote+ ISBN+ quote+ "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+title+ quote+"," + '\n');

            if (person!=null)
                sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');

            if (title_transcription!=null)
                sb.append(  quote + "title_transcription" + quote + ":" +  title_transcription+  "," + '\n');

            if (alternative!=null)
                sb.append(  quote + "alternative" + quote + ":" +  alternative+  "," + '\n');

            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" +  quote+series_title+ quote+ "," + '\n');

            if (series_title_transcription!=null)
                sb.append(  quote + "series_title_transcription" + quote + ":" +  series_title_transcription+  "," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

            if (language!=null)
                sb.append(  quote + "language" + quote + ":" + quote+ language+ quote+ "," + '\n');

            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Book"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "CNKI_eBooks"+ quote + "" + '\n' );

            sb.append("},");
        }

        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}

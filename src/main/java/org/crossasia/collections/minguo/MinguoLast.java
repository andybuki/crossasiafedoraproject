package org.crossasia.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MinguoLast {
    public static void main(String[] args) throws IOException {
        String encoding = "UTF-8";
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo/sections2.json"), Boolean.parseBoolean(encoding));
        String books = "/data3/solr/minguo/sections.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String id ="";
            String date = "";
            String book_id = "";

            String identifier = "";
            String identifiers [] = new String[0];

            String author = "";
            String authors [] = new String[0];
            String authors_all ="";

            String subjects [] = new String[0];
            String subjects_all ="";

            String position = "";
            String chapter_title ="";
            String text = "";

            String title = "";

            String publication_place = "";


            String url = "";

            JSONArray description = null;
            JSONArray temporal = null;
            String medium = "";
            String subject = "";
            JSONArray language = null;

            JSONArray person = null;
            JSONArray spatial = null;

            JSONArray keywords = null;

            JSONArray alternative = null;
            String  thumbnail_path= "";
            JSONArray note = null;
            String publisher = "";

            JSONArray creator_transcription = null;
            JSONArray physical_description = null;

            JSONObject booksObj = (JSONObject) booksObject.get(i);

            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("identifier")) {
                identifier = (String) booksObj.get("identifier").toString().replace("{", "").replace("}", "");
                identifiers = identifier.split(",");
            }

            if (booksObj.has("author")) {
                author = (String) booksObj.get("author").toString().replace("{", "").replace("}", "");
                authors = author.split(",");
                /*for (int au=0; au<authors.length; au++) {
                    authors[au];
                }*/
                String auto = "";
                for (String a : authors) {
                    auto +=quote+ a.replaceAll("\"","")+ quote+",";
                }
                String auto2 = auto.substring(0, (auto.length() - 1));
                authors_all +="["+auto2+"]";
            }
            String sub2 ="";
            String sub = "";
            if (booksObj.has("subject")) {
                subject = (String) booksObj.get("subject").toString().replace("{", "").replace("}", "");
                subjects = subject.split(",");
                /*for (int au=0; au<authors.length; au++) {
                    authors[au];
                }*/

                for (String b : subjects) {
                    sub +=quote+ b.replaceAll("\"","").replace(quote+quote,"")+ quote+",";
                }
                sub2 = sub.substring(0, (sub.length() - 1));
                subjects_all +="["+sub2+"]";
            }


            if (booksObj.has("position"))
                position = (String) booksObj.get("position").toString();

            if (booksObj.has("chapter_title"))
                chapter_title = (String) booksObj.get("chapter_title");

            if (booksObj.has("text"))
                text = (String) booksObj.get("text").toString();

            if (booksObj.has("date"))
                date = (String) booksObj.get("date").toString();

            if (booksObj.has("title"))
                title = (String) booksObj.get("title").toString();

            if (booksObj.has("publication_place"))
                publication_place = (String) booksObj.get("publication_place").toString();

            if (booksObj.has("url"))
                url = (String) booksObj.get("url").toString();

            String book="Page";
            String lang ="chi";
            String collection ="Early Twentieth Century Chinese Books (1912-1949)";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" + "["+ quote+ identifiers[0] +quote+","+ quote+ identifiers[1]+quote+"]" + "," + '\n');

            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +  authors_all+ "," + '\n');

            if (position!=null)
                sb.append(  quote + "position" + quote + ":" + quote+ position+quote+ "," + '\n');

            if (text!=null)
                sb.append(  quote + "text" + quote + ":" + quote+ text.replaceAll("\"","")+quote+ "," + '\n');

            if (date!=null&& date!="null")
                sb.append(  quote + "date" + quote + ":" + quote+ date+quote+ "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+ title.replaceAll("\"","")+quote+ "," + '\n');

            if (chapter_title!=null)
                sb.append(  quote + "chapter_title" + quote + ":" + quote+ chapter_title.replaceAll("\"","")+quote+ "," + '\n');

            if (publication_place!=null)
                sb.append(  quote + "publication_place" + quote + ":" + quote+publication_place+ quote+"," + '\n');

            if (subject!=null && subject!="" && sub2!="" && sub!="")
                sb.append(  quote + "subject" + quote + ":" + subjects_all+  "," + '\n');

            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url+ quote+"," + '\n');

            /*if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+  title+ quote+ "," + '\n');
            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" + quote+  series_title+ quote+ "," + '\n');
            if (responsibility!=null)
                sb.append(  quote + "responsibility" + quote + ":" + quote+ responsibility+ quote+"," + '\n');


            if (publisher!=null)
                sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+ quote+"," + '\n');
            if (date!=null)
                sb.append(  quote + "date" + quote + ":" + quote+ date+quote+ "," + '\n');
            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" + quote+ edition+ quote+"," + '\n');
            if (extent!=null)
                sb.append(  quote + "extent" + quote + ":" + quote+ extent+quote+ "," + '\n');

            if (description!=null)
                sb.append(  quote + "description" + quote + ":" +   description+  "," + '\n');
            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+  url.replace("\r\n","")+ quote+  "," + '\n');*/

            sb.append(  quote + "language" + quote + ":" + quote+ "chi"+ quote+ "," + '\n');

            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ collection+ quote + "" + '\n' );

            sb.append("},");


        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

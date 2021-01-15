package org.crossasia.collections.localgazetteer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JsonBook {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-loc-gaz/books_pagesNew5.json"));
        String books = "/mnt/b-isiprod-udl.pk.de/itr/archive/solr/ajax-loc-gaz/books_pages5.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String id ="";
            String collection ="";
            String hasModel ="";
            String url ="";
            String book_id = "";
            String title = "";
            JSONArray author =null;
            JSONArray title_transcription  =null;
            JSONArray  creator_transcription =null;
            JSONArray  medium =null;
            JSONArray  chapter_id =null;
            String issued ="";
            String date ="";
            String edition ="";
            String temporal ="";
            String admin_level_1 ="";
            String admin_level_2 ="";
            String admin_type ="";
            String spatial ="";
            String tgaz_api ="";
            String chgis = "";
            String latitude = "";
            String longitude = "";
            String language = "";
            String erflink ="";
            String responsibility = "";
            String comment ="";
            String page_id ="";
            String text ="";
            String position ="";


            JSONObject booksObj = (JSONObject) booksObject.get(i);

            id = (String) booksObj.get("id").toString();
            System.out.println(id);
            book_id = (String) booksObj.get("book_id").toString();
            position = (String) booksObj.get("position").toString();

            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("chapter_id"))
                chapter_id = (JSONArray) booksObj.get("chapter_id");

            if (booksObj.has("author"))
                author = (JSONArray) booksObj.get("author");

            if (booksObj.has("title_transcription"))
                title_transcription = (JSONArray) booksObj.get("title_transcription");

            if (booksObj.has("creator_transcription"))
                creator_transcription = (JSONArray) booksObj.get("creator_transcription");

            if (booksObj.has("medium"))
                medium = (JSONArray) booksObj.get("medium");

            if (booksObj.has("issued")) {
                issued  = (String) booksObj.get("issued").toString();
            }

            if (booksObj.has("date")) {
                date  = (String) booksObj.get("date").toString();
            }

            if (booksObj.has("page_id")) {
                page_id  = (String) booksObj.get("page_id").toString();
            }

            if (booksObj.has("text")) {
                text  = (String) booksObj.get("text").toString();
            }

            if (booksObj.has("edition")) {
                edition  = (String) booksObj.get("edition");
            }

            if (booksObj.has("temporal")) {
                temporal  = (String) booksObj.get("temporal");
            }

            if (booksObj.has("admin_level_1")) {
                admin_level_1  = (String) booksObj.get("admin_level_1");
            }

            if (booksObj.has("admin_level_2")) {
                admin_level_2  = (String) booksObj.get("admin_level_2");
            }

            if (booksObj.has("admin_type")) {
                admin_type  = (String) booksObj.get("admin_type");
            }

            if (booksObj.has("spatial"))
                spatial = (String) booksObj.get("spatial");

            if (booksObj.has("tgaz_api")) {
                tgaz_api  = (String) booksObj.get("tgaz_api");
            }

            if (booksObj.has("chgis")) {
                chgis  = (String) booksObj.get("chgis");
            }

            if (booksObj.has("latitude")) {
                latitude  = (String) booksObj.get("latitude").toString();
            }

            if (booksObj.has("longitude")) {
                longitude  = (String) booksObj.get("longitude").toString();
            }

            if (booksObj.has("url"))
                url = (String) booksObj.get("url");

            if (booksObj.has("erflink"))
                erflink = (String) booksObj.get("erflink");

            if (booksObj.has("responsibility"))
                responsibility = (String) booksObj.get("responsibility");

            if (booksObj.has("comment"))
                comment = (String) booksObj.get("comment");

            String book="Book";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

            if (title!="")
                sb.append(  quote + "title" + quote + ":" +   quote+ title+ quote+ "," + '\n');

            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +    author+ "," + '\n');
            if (title_transcription!=null)
                sb.append(  quote + "title_transcription" + quote + ":" +    title_transcription+ "," + '\n');
            if (creator_transcription!=null)
                sb.append(  quote + "creator_transcription" + quote + ":" +    creator_transcription+ "," + '\n');
            if (medium!=null)
                sb.append(  quote + "medium" + quote + ":" +    medium+ "," + '\n');
            if (chapter_id!=null)
                sb.append(  quote + "chapter_id" + quote + ":" +    chapter_id+ "," + '\n');
            if (date!="")
                sb.append(  quote + "date" + quote + ":" + quote+ date+ quote+ "," + '\n');

            if (issued!="")
                sb.append(  quote + "issued" + quote + ":" + quote+ issued+ quote+ "," + '\n');

            if (edition!="")
                sb.append(  quote + "edition" + quote + ":" + quote+ edition+ quote+ "," + '\n');

            if (temporal!="")
                sb.append(  quote + "temporal" + quote + ":" + quote+ temporal+ quote+ "," + '\n');

            if (admin_level_1!="")
                sb.append(  quote + "admin_level_1" + quote + ":" + quote+ admin_level_1+ quote+ "," + '\n');

            if (admin_level_2!="")
                sb.append(  quote + "admin_level_2" + quote + ":" + quote+ admin_level_2+ quote+ "," + '\n');
            if (admin_type!="")
                sb.append(  quote + "admin_type" + quote + ":" + quote+ admin_type+ quote+ "," + '\n');

            if (spatial!="")
                sb.append(  quote + "spatial" + quote + ":" +  "["+ quote+ spatial +quote+","+quote+ admin_level_1+quote +","+quote+ admin_level_2+quote+"]," + '\n');

            if (tgaz_api!="")
                sb.append(  quote + "tgaz_api" + quote + ":" + quote+ tgaz_api+ quote+ "," + '\n');

            if (chgis!="")
                sb.append(  quote + "chgis" + quote + ":" + quote+ chgis+ quote+ "," + '\n');

            if (latitude!="")
                sb.append(  quote + "latitude" + quote + ":" + quote+ latitude+ quote+ "," + '\n');

            if (longitude!="")
                sb.append(  quote + "longitude" + quote + ":" + quote+ longitude+ quote+ "," + '\n');

            if (responsibility!="")
                sb.append(  quote + "responsibility" + quote + ":" + quote+ responsibility+ quote+ "," + '\n');

            if (comment!="")
                sb.append(  quote + "comment" + quote + ":" + quote+ comment+ quote+ "," + '\n');

            if (page_id!="")
                sb.append(  quote + "page_id" + quote + ":" + quote+ page_id+ quote+ "," + '\n');

            if (text!="")
                sb.append(  quote + "text" + quote + ":" + quote+ text+ quote+ "," + '\n');


            sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n' );
            sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n' );
            sb.append(  quote + "position" + quote + ":" + quote+ position+ quote + "," + '\n' );

            sb.append(  quote + "language" + quote + ":" +   quote+ "chi"+ quote+ "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ "Local Gazetteer"+ quote + "" + '\n' );

            sb.append("},");

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

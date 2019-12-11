package org.crossasia.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MinguoPageErfLink {
    public static void main(String[] args) throws IOException {
        String encoding = "UTF-8";
        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/ajax-minguo/pages/sectionsErf.json"), Boolean.parseBoolean(encoding));
        String pages = "/data3/solr/ajax-minguo/pages/sections.json";
        String quote = "\u005c\u0022";
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        StringBuilder sb = new StringBuilder();


        for (int i=0; i<pagesObject.length(); i++) {
            String id ="";
            String book_id = "";
            String identifier = "";
            String[] identifiers = null;
            String position = "";
            String text = "";
            String date = "";
            String title = "";
            String author = "";
            String authors[] = null;
            String publication_place = "";
            String language = "";
            String subject = "";
            String subjects[] = null;
            String url = "";
            String section = "";
            String erflink = "";
            String erf = "";

            JSONObject pagesObj = (JSONObject) pagesObject.get(i);

            id = (String) pagesObj.get("id").toString();
            book_id = (String) pagesObj.get("book_id").toString();

            if (pagesObj.has("identifier")) {
                identifier = (String) pagesObj.get("identifier").toString().replaceAll("\\{","").replaceAll("\\}","");
                identifiers = identifier.split(",");
            }
            if (pagesObj.has("author")) {
                author = (String) pagesObj.get("author").toString()
                        .replaceAll("\\{","")
                        .replaceAll("}","")
                        .replaceAll(",","\",\"");

            }
            if (pagesObj.has("position"))
                position = (String) pagesObj.get("position").toString();
            if (pagesObj.has("text"))
                text = (String) pagesObj.get("text").toString().replaceAll("\",\"",  "");
            if (pagesObj.has("date"))
                date = (String) pagesObj.get("date").toString();
            if (pagesObj.has("title"))
                title = (String) pagesObj.get("title").toString();

            if (pagesObj.has("publication_place"))
                publication_place = (String) pagesObj.get("publication_place").toString();
            if (pagesObj.has("subject")) {
                subject = (String) pagesObj.get("subject").toString()
                        .replaceAll("\\{","")
                        .replaceAll("}","")
                        .replaceAll(",","\",\"");

            }
            if (pagesObj.has("url"))
                url = (String) pagesObj.get("url").toString();

            if (pagesObj.has("url")) {

                erf = (String) pagesObj.get("url").toString().replace("http://", "");
                erflink = "http://erf.sbb.spk-berlin.de/han/NLCminguo/" + erf;
            }

            section = (String) pagesObj.get("section").toString()
                    .replaceAll(":","\",\"")
                    .replaceAll(";","\",\"")
                    .replaceAll(" ","\",\"");

            if (pagesObj.has("language")) {
                language = (String) pagesObj.get("language").toString()
                        .replaceAll("\\{","")
                        .replaceAll("}","")
                        .replaceAll(",","\",\"");

            }

            String collection ="Early Twentieth Century Chinese Books (1912-1949)";

            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +"["+ quote + identifiers[0] + quote+ ","+ quote + identifiers[1] + quote+ "],"+'\n');

            if (author!=null)
                sb.append(  quote + "author" + quote + ":" +   "["+quote+ author+quote+ "]"+ "," + '\n');

            if (position!=null)
                sb.append(  quote + "position" + quote + ":" + quote+ position+quote+ "," + '\n');

            if (text!=null)
                sb.append(  quote + "text" + quote + ":" + quote+ text+quote+ "," + '\n');

            if (date!=null&& date!="null")
                sb.append(  quote + "date" + quote + ":" + quote+ date+quote+ "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + quote+ title+quote+ "," + '\n');

            if (publication_place!=null)
                sb.append(  quote + "publication_place" + quote + ":" + quote+publication_place+ quote+"," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" + "["+quote+ subject+quote+ "]"+   "," + '\n');

            if (section!=null)
                sb.append(  quote + "chapter_title" + quote + ":" + "["+quote+ section+quote+ "]"+   "," + '\n');


            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url+ quote+"," + '\n');

            if (erflink!=null)
                sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote+"," + '\n');

            sb.append(  quote + "language" + quote + ":" + "["+quote+ language+quote+ "]"+  "," + '\n');
            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+ collection+ quote + "" + '\n' );

            sb.append("},");


        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");



    }
}

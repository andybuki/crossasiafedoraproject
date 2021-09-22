package org.crossasia.solr.collections.brill_jpco;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class JpcoPagePosition {

    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/OLD/ajax-brill-jpco/NEW/books_pages2.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/OLD/ajax-brill-jpco/NEW/books_pages_p2.json"));
        String book_id="";
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<>();
        int count = 0;
        int iduk=0;
        String id ="";
        for (int i=0; i<jsonArrayPages.length();i++) {

            String date ="";
            String wholedate ="";
            String file_location ="";
            String  medium ="";
            String  subject ="";
            String publication_name ="";
            String publication_volume ="";
            String doi ="";
            String url ="";
            String title ="";
            String erflink ="";
            String collection ="";
            String bibliographicCitation ="";
            String description ="";
            String text ="";

            JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(i);
            int position =1;

            if (jsonObjPages.has("book_id")) {
                book_id = (String) jsonObjPages.get("book_id").toString();
            }

            if (jsonObjPages.has("id")) {
                id = (String) jsonObjPages.get("id").toString();//.split("_")[jsonObjPages.get("id").toString().split("_").length-1];
                //iduk = Integer.parseInt(id.replaceFirst("^0+(?!$)", ""));
            }

            if (jsonObjPages.has("date")) {
                date = (String) jsonObjPages.get("date").toString();
            }

            if (jsonObjPages.has("wholedate")) {
                wholedate = (String) jsonObjPages.get("wholedate").toString();
            }

            if (jsonObjPages.has("file_location")) {
                file_location = (String) jsonObjPages.get("file_location").toString();
            }

            if (jsonObjPages.has("medium")) {
                medium = (String) jsonObjPages.get("medium").toString();
            }

            if (jsonObjPages.has("subject")) {
                subject = (String) jsonObjPages.get("subject").toString();
            }

            if (jsonObjPages.has("publication_name")) {
                publication_name = (String) jsonObjPages.get("publication_name").toString();
            }

            if (jsonObjPages.has("publication_volume")) {
                publication_volume = (String) jsonObjPages.get("publication_volume").toString();
            }

            if (jsonObjPages.has("doi")) {
                doi = (String) jsonObjPages.get("doi").toString();
            }

            if (jsonObjPages.has("title")) {
                title = (String) jsonObjPages.get("title").toString();
            }

            if (jsonObjPages.has("url")) {
                url = (String) jsonObjPages.get("url").toString();
            }

            if (jsonObjPages.has("erflink")) {
                erflink = (String) jsonObjPages.get("erflink").toString();
            }

            if (jsonObjPages.has("bibliographicCitation")) {
                bibliographicCitation = (String) jsonObjPages.get("bibliographicCitation").toString();
            }

            if (jsonObjPages.has("description")) {
                description = (String) jsonObjPages.get("description");
            }
            if (jsonObjPages.has("text")) {
                text = (String) jsonObjPages.get("text");
            }
            

            arrayList.add((String) jsonObjPages.get("book_id"));
            count = Collections.frequency(arrayList, book_id);
            countList.add(count);

            //System.out.print(iduk +"**");

            sb.append("{"+ '\n');
            if (id!= "")
                sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');

            if (book_id!= "")
                sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

            if (position!= 0)
                sb.append(quote + "position" + quote + ":" + quote+ count +quote + "," + '\n');

            if (title!= "")
                sb.append(quote + "title" + quote + ":" + quote+ title +quote + "," + '\n');

            if (date!= "")
                sb.append(quote + "date" + quote + ":" + quote+ date +quote + "," + '\n');

            if (subject!= "")
                sb.append(quote + "subject" + quote + ":" + quote+ subject +quote + "," + '\n');

            if (medium!= "")
                sb.append(quote + "medium" + quote + ":" + quote+ medium +quote + "," + '\n');

            if (text!= "")
                sb.append(quote + "text" + quote + ":" + quote+ text +quote + "," + '\n');

            if (publication_name!= "")
                sb.append(quote + "publication_name" + quote + ":" + quote+ publication_name +quote + "," + '\n');

            if (publication_volume!= "")
                sb.append(quote + "publication_volume" + quote + ":" + quote+ publication_volume +quote + "," + '\n');

            if (url!= "")
                sb.append(quote + "url" + quote + ":" + quote+ url +quote + "," + '\n');

            if (erflink!= "")
                sb.append(quote + "erflink" + quote + ":" + quote+ erflink +quote + "," + '\n');

            if (doi!= "")
                sb.append(quote + "DOI" + quote + ":" + quote+ doi +quote + "," + '\n');

            sb.append(quote + "language" + quote + ":" +   quote+ "eng"+ quote+ "," + '\n');
            sb.append(quote + "hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n');
            sb.append(quote + "collection" + quote + ":" + quote + "Japan Chronicle Online" + quote + "" + '\n');

            sb.append("},");

        }
        //System.out.println();
        //System.out.println(arrayList );

        //System.out.println( countList);
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

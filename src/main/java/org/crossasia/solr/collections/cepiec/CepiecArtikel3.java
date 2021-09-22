package org.crossasia.solr.collections.cepiec;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CepiecArtikel3 {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/ajax-cepiec/articles.json";
        String books = "/data/solr/ajax-cepiec/authors.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayBooks = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-cepiec/articles2.json"));
        for (int i=0; i<jsonArrayBooks.length();i++){

            String id ="";
            String  author ="";

            JSONObject jsonObjBooks = (JSONObject) jsonArrayBooks.get(i);

            if (jsonObjBooks.has("id")) {
                id = (String) jsonObjBooks.get("id").toString();
            }

            if (jsonObjBooks.has("author")) {
                author = (String) jsonObjBooks.get("author").toString();
            }

            for (int j=0; j<jsonArrayPages.length(); j++) {

                JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(j);
                String page_id="";
                String position ="";
                String title ="";
                String date ="";
                String issued ="";
                String spatial ="";
                String text ="";
                JSONArray  subject =null;
                String author2 ="";
                String publication_name ="";

                String url ="";
                String erflink ="";


                if (jsonObjPages.has("id")) {
                    page_id = (String) jsonObjPages.get("id").toString();
                }

                if (jsonObjPages.has("position")) {
                    position = (String) jsonObjPages.get("position").toString();
                }
                if (jsonObjPages.has("title")) {
                    title = (String) jsonObjPages.get("title").toString();
                }

                if (jsonObjPages.has("date")) {
                    date = (String) jsonObjPages.get("date").toString();
                }
                if (jsonObjPages.has("issued")) {
                    issued = (String) jsonObjPages.get("issued").toString();
                }

                if (jsonObjPages.has("spatial")) {
                    spatial = (String) jsonObjPages.get("spatial").toString();
                }

                if (jsonObjPages.has("text")) {
                    text = (String) jsonObjPages.get("text").toString();
                }

                if (jsonObjPages.has("subject")) {
                    subject = (JSONArray) jsonObjPages.get("subject");
                }

                if (jsonObjPages.has("author")) {
                    author2 = (String) jsonObjPages.get("author").toString();
                }

                if (jsonObjPages.has("publication_name")) {
                    publication_name = (String) jsonObjPages.get("publication_name").toString();
                }

                if (jsonObjPages.has("url")) {
                    url = (String) jsonObjPages.get("url").toString();
                }

                if (jsonObjPages.has("erflink")) {
                    erflink = (String)  jsonObjPages.get("erflink").toString();
                }


                if (jsonObjPages.has("spatial")) {
                    spatial = (String) jsonObjPages.get("spatial").toString();
                }

                if (id.equals(page_id)){

                    sb.append("{"+ '\n');
                    if (id!= "")
                        sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');


                    sb.append(quote + "position" + quote + ":" + quote+ position+quote + "," + '\n');

                    if (title!= "")
                        sb.append(quote + "title" + quote + ":" + quote+ title +quote + "," + '\n');

                    if (date!= "")
                        sb.append(quote + "date" + quote + ":" + quote+ date +quote + "," + '\n');

                    if (issued!= "")
                        sb.append(quote + "issued" + quote + ":" + quote+ issued +quote + "," + '\n');

                    if (spatial!= "")
                        sb.append(quote + "spatial" + quote + ":" + quote+ spatial +quote + "," + '\n');

                    /*if (text!= "") {
                        sb.append(quote + "text" + quote + ":" + quote + text + quote + "," + '\n');
                        sb.append(quote + "subject" + quote + ":" + "["+quote+ "天津版" +quote +"]"  + "," + '\n');

                    } else {
                        sb.append(quote + "subject" + quote + ":" + "["+quote+ "天津版"+quote+","+quote+"advertisement" +quote +"]" + "," + '\n');
                    }*/
                    sb.append(quote + "text" + quote + ":" + quote+ text+quote + "," + '\n');
                    sb.append(quote + "subject" + quote + ":" + subject + "," + '\n');
                    if (author!="") {
                        sb.append(quote + "author" + quote + ":" + "[" +quote+ author +quote+","+quote+ author2+quote +"]" + "," + '\n');
                    } else {
                        sb.append(quote + "author" + quote + ":" + "[" +quote+ author2+quote +"]" + "," + '\n');
                    }


                    if (publication_name!= "")
                        sb.append(quote + "publication_name" + quote + ":" + quote+ publication_name +quote + "," + '\n');

                    if (url!= "")
                        sb.append(quote + "url" + quote + ":" + quote+ url +quote + "," + '\n');

                    if (erflink!= "")
                        sb.append(quote + "erflink" + quote + ":" + quote+ erflink +quote + "," + '\n');

                    sb.append(quote + "language" + quote + ":" +   quote+ "chi"+ quote+ "," + '\n');
                    sb.append(quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n');
                    sb.append(quote + "collection" + quote + ":" + quote + "Dagongbao (Tianjin ban)" + quote + "" + '\n');
                    sb.append("},");
                }
                else {
                    System.out.println("No" + id);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

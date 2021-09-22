package org.crossasia.solr.collections.cepiec;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CepiecArtikel {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/ajax-cepiec/tjimglist_NEW.json";
        String books = "/data/solr/ajax-cepiec/cepiec.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayBooks = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-cepiec/newBatch.json"));
        int k =jsonArrayBooks.length();
        int l =jsonArrayPages.length();
        for (int i=0; i<jsonArrayBooks.length();i++){


            String id ="";
            String small_id [];
            String id_new ="";
            String date ="";
            String issued ="";
            String publication_name ="";
            String title ="";
            String text ="";
            String position ="";
            String file_location ="";
            String  medium ="";
            String  subject ="";

            String publication_volume ="";
            String doi ="";

            String collection ="";
            String bibliographicCitation ="";
            JSONArray description =null;

            String book_id="";

            JSONObject jsonObjBooks = (JSONObject) jsonArrayBooks.get(i);

            if (jsonObjBooks.has("id")) {
                id = (String) jsonObjBooks.get("id").toString();
            }

            if (jsonObjBooks.has("id")) {
                small_id = jsonObjBooks.get("id").toString().split("_");
                id_new = small_id[0]+small_id[1]+small_id[2].substring(1,3);
            }

            if (jsonObjBooks.has("date")) {
                date = (String) jsonObjBooks.get("date").toString();
            }

            if (jsonObjBooks.has("issued")) {
                issued = (String) jsonObjBooks.get("issued").toString();
            }

            if (jsonObjBooks.has("position")) {
                position = (String) jsonObjBooks.get("position").toString();
            }

            if (jsonObjBooks.has("file_location")) {
                file_location = (String) jsonObjBooks.get("file_location").toString();
            }

            if (jsonObjBooks.has("text")) {
                text = (String) jsonObjBooks.get("text").toString();
            }

            if (jsonObjBooks.has("medium")) {
                medium = (String) jsonObjBooks.get("medium").toString();
            }

            if (jsonObjBooks.has("subject")) {
                subject = (String) jsonObjBooks.get("subject").toString();
            }

            if (jsonObjBooks.has("publication_name")) {
                publication_name = (String) jsonObjBooks.get("publication_name").toString();
            }

            if (jsonObjBooks.has("publication_volume")) {
                publication_volume = (String) jsonObjBooks.get("publication_volume").toString();
            }

            if (jsonObjBooks.has("doi")) {
                doi = (String) jsonObjBooks.get("doi").toString();
            }

            if (jsonObjBooks.has("title")) {
                title = (String) jsonObjBooks.get("title").toString();
            }

            if (jsonObjBooks.has("bibliographicCitation")) {
                bibliographicCitation = (String) jsonObjBooks.get("bibliographicCitation").toString();
            }

            if (jsonObjBooks.has("book_id")) {
                book_id = (String) jsonObjBooks.get("book_id").toString();
            }


            for (int j=0; j<jsonArrayPages.length(); j++) {

                JSONObject jsonObjPages = (JSONObject) jsonArrayPages.get(j);
                String page_id="";
                String pages_ids ="";
                int p =0;
                String book_page_id ="";
                String url ="";
                String erflink ="";
                String spatial ="";
                String author ="";
                String version ="";
                String title_id = "";
                String publication_title="";

                if (jsonObjPages.has("id")) {
                    pages_ids = (String) jsonObjPages.get("id").toString();
                }

                if (jsonObjPages.has("url")) {
                    url = (String) jsonObjPages.get("url").toString().replace("http:/","http://");
                }

                if (jsonObjPages.has("url")) {
                    erflink = (String)  "http://erf.sbb.spk-berlin.de/han/cepiec-tkp/"+jsonObjPages.get("url").toString().replace("http:/","");
                }

                if (jsonObjPages.has("author")) {
                    author = (String) jsonObjPages.get("author").toString();
                }
                if (jsonObjPages.has("publication_title")) {
                    publication_title = (String) jsonObjPages.get("publication_title").toString();
                }

                if (jsonObjPages.has("version")) {
                    //version = (String) jsonObjPages.get("version").toString();
                }

                if (jsonObjPages.has("spatial")) {
                    spatial = (String) jsonObjPages.get("spatial").toString();
                }

                if (jsonObjPages.has("title_id")) {
                    title_id = (String) jsonObjPages.get("title_id").toString();
                }

                if (jsonObjPages.has("id")) {
                    String x = String.valueOf(jsonObjPages.get("id").toString().charAt(jsonObjPages.get("id").toString().length()-1));
                    String result = StringUtils.substring(jsonObjPages.get("id").toString(), 0, jsonObjPages.get("id").toString().length() - 2);
                    page_id = result+x;
                }

                if (id.equals(pages_ids)){

                    sb.append("{"+ '\n');
                    if (id!= "")
                        sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');

                    if (book_id!= "")
                        sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

                    sb.append(quote + "position" + quote + ":" + quote+ position+quote + "," + '\n');

                    if (title!= "")
                        sb.append(quote + "title" + quote + ":" + quote+ title +quote + "," + '\n');

                    if (date!= "")
                        sb.append(quote + "date" + quote + ":" + quote+ date +quote + "," + '\n');

                    if (issued!= "")
                        sb.append(quote + "issued" + quote + ":" + quote+ issued +quote + "," + '\n');

                    if (spatial!= "")
                        sb.append(quote + "spatial" + quote + ":" + quote+ spatial +quote + "," + '\n');

                    if (medium!= "")
                        sb.append(quote + "medium" + quote + ":" + quote+ medium +quote + "," + '\n');

                    if (text!= "") {
                        sb.append(quote + "text" + quote + ":" + quote + text + quote + "," + '\n');
                        sb.append(quote + "subject" + quote + ":" + "["+quote+ "天津版" +quote +"]"  + "," + '\n');

                    } else {
                        sb.append(quote + "subject" + quote + ":" + "["+quote+ "天津版"+quote+","+quote+"advertisement" +quote +"]" + "," + '\n');
                    }

                    if (author!= "")
                        sb.append(quote + "author" + quote + ":" + quote+ author +quote + "," + '\n');

                    if (publication_title!= "")
                        sb.append(quote + "publication_title" + quote + ":" + quote+ publication_title +quote + "," + '\n');

                    if (publication_name!= "")
                        sb.append(quote + "publication_name" + quote + ":" + quote+ publication_name +quote + "," + '\n');

                    if (publication_volume!= "")
                        sb.append(quote + "publication_volume" + quote + ":" + quote+ publication_volume +quote + "," + '\n');

                    if (url!= "")
                        sb.append(quote + "url" + quote + ":" + quote+ url +quote + "," + '\n');

                    if (erflink!= "")
                        sb.append(quote + "erflink" + quote + ":" + quote+ erflink +quote + "," + '\n');

                    if (version!= "")
                        sb.append(quote + "version" + quote + ":" + quote+ version +quote + "," + '\n');


                    sb.append(quote + "language" + quote + ":" +   quote+ "chi"+ quote+ "," + '\n');
                    sb.append(quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n');
                    sb.append(quote + "collection" + quote + ":" + quote + "Dagongbao (Tianjin ban)" + quote + "" + '\n');
                    sb.append("},");
                    System.out.println("OK");
                }
                else {
                    System.out.println("No passed: " + id);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

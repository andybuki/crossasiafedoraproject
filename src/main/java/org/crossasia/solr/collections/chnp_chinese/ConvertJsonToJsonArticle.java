package org.crossasia.solr.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class ConvertJsonToJsonArticle {

    public static void main(String[] args) {

        //JSONParser parser = new JSONParser();
        //parser.Feature.ALLOW_UNQUOTED_FIELD_NAMES
        try {

            String journal = "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\articles\\metadatatext.json";
            PrintStream out = new PrintStream(new FileOutputStream( "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\articles\\\\article.json"));
            String quote = "\u005c\u0022";
            JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream(journal)));
            //JSONArray jsonArray = (JSONArray) obj;
            //JSONArray jsonArray = new JSONArray(new JSONTokener(new FileInputStream((File) obj)));

            for (int k=0; k<jsonArray.length();k++) {
                JSONObject book = (JSONObject) jsonArray.get(k);

                String id = (String) book.get("id").toString();
                String text="";
                String page_range="";
                String electronic_url ="";
                String title ="";
                String description ="";
                String author ="";
                String language ="";
                String article_id ="";


                if (book.has("text")) {
                    text = (String) book.get("text").toString();
                }

                if (book.has("page-range")) {
                    page_range = (String) book.get("page-range").toString();
                }

                if (book.has("electronic-url")) {
                    electronic_url = (String) book.get("electronic-url").toString();
                }
                if (book.has("title")) {
                    title = (String) book.get("title").toString();
                }
                if (book.has("author")) {
                    author = (String) book.get("author").toString();
                }
                if (book.has("description")) {
                    description = (String) book.get("description").toString();
                }
                if (book.has("language")) {
                    language = (String) book.get("language").toString();
                }

                if (book.has("asset-id-page")) {
                    article_id = (String) book.get("asset-id-page").toString();
                }

                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "text" + quote + ":" + quote+ text+ quote + "," + '\n'
                        + quote + "page_range" + quote + ":" + quote+ page_range+  quote + "," + '\n'
                        + quote + "title" + quote + ":" + quote+ title+ quote + "," + '\n'
                        + quote + "electronic_url" + quote + ":" + quote+ electronic_url+ quote + "," + '\n'
                        + quote + "author" + quote + ":" + quote+ author+ quote + "," + '\n'
                        + quote + "article_id" + quote + ":" + quote+ article_id+ quote + "," + '\n'
                        + quote + "language" + quote + ":" + quote+ language+ quote + "," + '\n'
                        + quote + "description" + quote + ":" + quote+ description+ quote + "," + '\n'
                        + quote + "medium" + quote + ":" + quote+ "Article"+ quote + "," + '\n'
                        + quote + "hasModel" + quote + ":" + quote + "Article"  + quote  + '\n'
                        +"},"
                );
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
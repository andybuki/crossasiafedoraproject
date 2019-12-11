package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJsonIssueFedoraText {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            String question ="\\u003F";
            String quote2 = "&#92;";
            JSONObject jsonObject;
            String journal = "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\journal.json";
            String article = "D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\article.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\FEDORA-COLLECTIONS\\chnp_2016_chinese\\result.json"));
            JSONArray journalObj = new JSONArray(new JSONTokener(new FileInputStream(journal)));
            JSONArray articleObj = new JSONArray(new JSONTokener(new FileInputStream(article)));

            String id="";
            String title="";
            String language ="";
            String link ="";
            String assetid_page ="";
            String volume_number ="";
            String author ="";
            String page_range ="";
            String asset_id="";
            String page="";
            String description="";
            String format="";
            String text="";
            String url="";
            String article_id="";
            String idShort="";
            String idShort2="";

            for (int i=0; i<articleObj.length(); i++) {
                JSONObject articleObjJSON = (JSONObject) articleObj.get(i);

                if (articleObjJSON.has("id")) {
                    id = (String) articleObjJSON.get("id").toString();
                    idShort = id.replaceAll("-[^-]*$","");
                    idShort2 = idShort.replaceAll("-[^-]*$","");
                }
                if (articleObjJSON.has("dc:title")) {
                    title = (String) articleObjJSON.get("dc:title").toString();
                }
                if (articleObjJSON.has("dc:language")) {
                    language =(String) articleObjJSON.get("dc:language").toString();
                }
                if (articleObjJSON.has("schema:text")) {
                    text =(String) articleObjJSON.get("schema:text").toString();
                }
                if (articleObjJSON.has("schema:position")) {
                    page = (String) articleObjJSON.get("schema:position").toString();
                }
                if (articleObjJSON.has("schema:url")) {
                    url = (String) articleObjJSON.get("schema:url").toString();
                }

                if (articleObjJSON.has("dc:creator")) {
                    author = (String) articleObjJSON.get("dc:creator").toString();
                }

                if (articleObjJSON.has("article_id")) {
                    article_id = (String) articleObjJSON.get("article_id").toString();
                }

                if (articleObjJSON.has("dc:description")) {
                    description = (String) articleObjJSON.get("dc:description").toString();
                }


                for (int j=0; j<journalObj.length();j++) {
                    JSONObject journalObjJSON = (JSONObject) journalObj.get(j);
                    String id_level1 ="";
                    String journal_id="";

                    id_level1 = (String) journalObjJSON.get("id_level1").toString();

                    if (journalObjJSON.has("journal_id")) {
                        journal_id = (String) journalObjJSON.get("journal_id").toString();
                    }



                    if (journal_id.equals(idShort2)){
                        out.println("{" + quote + "dc:language" + quote + ":" + quote + language + quote + "," + '\n'
                                + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                + quote + "dc:title" + quote + ":" + quote + title + quote + "," + '\n'
                                + quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "dc:creator" + quote + ":" +    author +  "," + '\n'
                                + quote + "schema:url" + quote + ":" + quote + url + quote + "," + '\n'
                                + quote + "article_id" + quote + ":" + quote + article_id + quote + "," + '\n'
                                + quote + "dc:description" + quote + ":" + quote + description + quote + "," + '\n'
                                + quote + "dc:medium" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "@id" + quote + ":" + quote + "" + quote + "," + '\n'
                                + quote + "@type" + quote + ":" + quote + "pcdm:Object" + quote + "," + '\n'
                                + quote + "id_level1" + quote + ":" + quote + id_level1 + quote + "," + '\n'
                                + quote + "journal_id" + quote + ":" + quote + journal_id + quote + "," + '\n'
                                + quote + "schema:position" + quote + ":" + quote + page + quote + "" + '\n'
                                + "},"
                        );
                    }else {
                        System.out.println("NO");
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

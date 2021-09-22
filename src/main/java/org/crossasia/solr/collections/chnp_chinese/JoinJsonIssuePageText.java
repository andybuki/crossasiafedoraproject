package org.crossasia.solr.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJsonIssuePageText {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            String question ="\\u003F";
            String quote2 = "&#92;";
            JSONObject jsonObject;
            String issue_pages = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_pages2.json";
            String text = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\textResult2.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\text_pages_issue4.json"));
            JSONArray issue_pagesObject = new JSONArray(new JSONTokener(new FileInputStream(issue_pages)));
            JSONArray textObject = new JSONArray(new JSONTokener(new FileInputStream(text)));

            String id="";
            String title="";
            String language ="";
            String link ="";
            String assetid_page ="";
            String volume_number ="";
            String author ="";
            String page_range ="";
            String asset_id="";
            String page_num="";
            String description="";
            String format="";

            for (int i=0; i<issue_pagesObject.length(); i++) {
                JSONObject numerObj = (JSONObject) issue_pagesObject.get(i);

                if (numerObj.has("id")) {
                    id = (String) numerObj.get("id").toString();
                }
                if (numerObj.has("title")) {
                    title = (String) numerObj.get("title").toString();
                }
                if (numerObj.has("language")) {
                    language =(String) numerObj.get("language").toString();
                }
                if (numerObj.has("volume_number")) {
                    volume_number =(String) numerObj.get("volume-number").toString();
                }
                if (numerObj.has("page_num")) {
                    page_num = (String) numerObj.get("page_num").toString();
                }
                if (numerObj.has("asset_id")) {
                    asset_id = (String) numerObj.get("asset_id").toString();
                }

                if (numerObj.has("author")) {
                    author = (String) numerObj.get("author").toString();
                }

                if (numerObj.has("assetid_page")) {
                    assetid_page = (String) numerObj.get("assetid_page").toString();
                }

                if (numerObj.has("description")) {
                    description = (String) numerObj.get("description").toString();
                }

                if (numerObj.has("page-range")) {
                    page_range = (String) numerObj.get("page-range").toString();
                }

                if (numerObj.has("format")) {
                    format = (String) numerObj.get("format").toString();
                }

                for (int j=0; j<textObject.length();j++) {
                    JSONObject numerObjName = (JSONObject) textObject.get(j);

                    id = (String) numerObjName.get("id").toString();
                    link = (String) numerObjName.get("link").toString();
                    text = (String) numerObjName.get("text").toString();
                    //String link_id = link.replaceAll("http://link.galegroup.com/apps/doc/","").replaceAll("CFER","").replaceAll("sid=dhxml","").replaceAll("/","").replaceAll(question,"");

                    if (numerObj.has("id") && numerObjName.get("id").equals(numerObj.get("id"))){
                        out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                                + quote + "assetid_page" + quote + ":" + quote + assetid_page + quote + "," + '\n'
                                + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                + quote + "format" + quote + ":" + quote + format + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "medium" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "journal-title" + quote + ":" + quote + title.replaceAll("\"","'").replaceAll(quote,"'") + quote + "," + '\n'
                                //+ quote + "author" + quote + ":" +  "["+  quote +author.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                + quote + "author" + quote + ":" +    author +  "," + '\n'
                                + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                + quote + "volume-number" + quote + ":" + quote + volume_number + quote + "," + '\n'
                                + quote + "description" + quote + ":" + quote + description + quote + "," + '\n'
                                + quote + "link" + quote + ":" + quote + link + quote + "," + '\n'
                                + quote + "text" + quote + ":" + quote + text + quote + "," + '\n'
                                + quote + "page-range" + quote + ":" + quote + page_range + quote + "" + '\n'
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

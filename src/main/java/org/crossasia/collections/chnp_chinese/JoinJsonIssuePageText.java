package org.crossasia.collections.chnp_chinese;

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
            String issue_pages = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_pages.json";
            String text = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\textResult.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\text_pages_issue2.json"));
            JSONArray issue_pagesObject = new JSONArray(new JSONTokener(new FileInputStream(issue_pages)));
            JSONArray textObject = new JSONArray(new JSONTokener(new FileInputStream(text)));

            String id="";
            String title="";
            String language ="";
            String link ="";
            String assetid_page ="";
            String ct ="";
            String author ="";

            String asset_id="";
            String page_num="";

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
                if (numerObj.has("ct")) {
                    ct =(String) numerObj.get("ct").toString();
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

                for (int j=0; j<textObject.length();j++) {
                    JSONObject numerObjName = (JSONObject) textObject.get(j);

                    link = (String) numerObjName.get("link").toString();
                    text = (String) numerObjName.get("text").toString();
                    String link_id = link.replaceAll("http://link.galegroup.com/apps/doc/","").replaceAll("CFER","").replaceAll("sid=dhxml","").replaceAll("/","").replaceAll(question,"");

                    if (numerObj.has("assetid_page") && assetid_page.equals(link_id)){
                        out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                                + quote + "title" + quote + ":" +   quote +title.replaceAll("'","")+  quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                                + quote + "language" + quote + ":" +   quote +language + quote + "," + '\n'
                                + quote + "ct" + quote + ":" +   quote +ct +  quote +"," + '\n'
                                + quote + "page" + quote + ":" +   quote +page_num+ quote +   "," + '\n'
                                + quote + "author" + quote + ":" +   quote +author+ quote +   "," + '\n'
                                + quote + "link" + quote + ":" +   quote +link+ quote +   "," + '\n'
                                + quote + "assetid_page" + quote + ":" +   quote +assetid_page+ quote +   "," + '\n'
                                + quote + "asset_id" + quote + ":" +   quote +asset_id+ quote +   "," + '\n'
                                + quote + "text" + quote + ":" +   quote +text +  quote +  '\n'
                                +"},"
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

package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJsonIssueMetadataPage {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            String question ="\\u003F";
            String quote2 = "&#92;";
            JSONObject jsonObject;
            String issue_pages = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_pagesSmall.json";
            //String metachina_issue = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_error.json";
            String metachina_issue = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_error.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_pages_FullSmall.json"));
            JSONArray issue_pagesObject = new JSONArray(new JSONTokener(new FileInputStream(issue_pages)));
            JSONArray metachina_issueObject = new JSONArray(new JSONTokener(new FileInputStream(metachina_issue)));


            for (int j=0; j<metachina_issueObject.length();j++) {

                String format2="";
                String journal_title ="";
                String publication_place ="";
                String series_title="";
                String issue_date="";
                String url="";
                String PSMID="";
                String date="";
                String date_original="";
                String volume_number ="";
                String publication_volume="";
                String description="";

                JSONObject numerObjName = (JSONObject) metachina_issueObject.get(j);

                /*url = (String) numerObjName.get("url").toString();
                date = (String) numerObjName.get("date").toString();
                date_original = (String) numerObjName.get("date_original").toString();
                PSMID = (String) numerObjName.get("PSMID").toString();*/

                if (numerObjName.has("description")) {
                    description = (String) numerObjName.get("description").toString();
                }

                if (numerObjName.has("title")) {
                    journal_title = (String) numerObjName.get("title").toString();
                }

                if (numerObjName.has("format")) {
                    format2 = (String) numerObjName.get("format").toString();
                }

                if (numerObjName.has("publication-place")) {
                    publication_place = (String) numerObjName.get("publication-place").toString();
                }

                if (numerObjName.has("series-title")) {
                    series_title = (String) numerObjName.get("series-title").toString();
                }
                if (numerObjName.has("issue-date")) {
                    issue_date = (String) numerObjName.get("issue-date").toString();
                }

                if (numerObjName.has("url")) {
                    url = (String) numerObjName.get("url").toString();
                }
                if (numerObjName.has("date")) {
                    date = (String) numerObjName.get("date").toString();
                }
                if (numerObjName.has("date_original")) {
                    date_original = (String) numerObjName.get("date_original").toString();
                }

                if (numerObjName.has("PSMID")) {
                    PSMID = (String) numerObjName.get("PSMID").toString();
                }
                if (numerObjName.has("file-name")) {
                    String filename = (String) numerObjName.get("file-name").toString();
                    String filenameShort =filename.replaceAll("_Issue.xml","");
                }


                if (numerObjName.has("volume-number")) {
                    volume_number =(String) numerObjName.get("volume-number").toString();
                }

                if (numerObjName.has("publication-volume")) {
                    publication_volume = (String) numerObjName.get("publication-volume").toString();
                }




                for (int i=0; i<issue_pagesObject.length(); i++) {
                    String id="";
                    String idShort="";
                    String idShort2="";
                    String title="";
                    String language ="";
                    String link ="";
                    String assetid_page ="";


                    String page_range ="";
                    String asset_id="";
                    String page_num="";

                    String format="";
                    String author ="";
                    String description2="";


                    JSONObject numerObj = (JSONObject) issue_pagesObject.get(i);

                    if (numerObj.has("id")) {
                        id = (String) numerObj.get("id").toString();
                        idShort = id.replaceAll("-[^-]*$","");
                        idShort2 = idShort.replaceAll("-[^-]*$","");
                    }
                    if (numerObj.has("title")) {
                        title = (String) numerObj.get("title").toString();
                    }
                    if (numerObj.has("language")) {
                        language =(String) numerObj.get("language").toString();
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

                    if (numerObj.has("journal-title")) {
                        journal_title = (String) numerObj.get("journal-title").toString();
                    }



                    if ((numerObj.has("id") && PSMID.equals(idShort2))){
                        out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                                + quote + "assetid_page" + quote + ":" + quote + assetid_page + quote + "," + '\n'
                                + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                + quote + "format" + quote + ":" + quote + format + quote + "," + '\n'
                                + quote + "date" + quote + ":" + quote + date + quote + "," + '\n'
                                + quote + "date-original" + quote + ":" + quote + date_original + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "medium" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                + quote + "journal-title" + quote + ":" + quote + journal_title + quote + "," + '\n'
                                + quote + "author" + quote + ":" +    author  +  "," + '\n'
                                + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                + quote + "volume-number" + quote + ":" + quote + volume_number + quote + "," + '\n'
                                + quote + "description" + quote + ":" + quote + description + quote + "," + '\n'
                                + quote + "publication-volume" + quote + ":" + quote + publication_volume + quote + "," + '\n'
                                + quote + "title" + quote + ":" + quote + title + quote + "," + '\n'
                                + quote + "url" + quote + ":" + quote + url + quote + "," + '\n'
                                + quote + "publication-place" + quote + ":" + quote + publication_place + quote + "," + '\n'
                                + quote + "series-title" + quote + ":" + quote + series_title + quote + "," + '\n'
                                //+ quote + "journal-title" + quote + ":" + quote + journal_title + quote + "," + '\n'
                                //+ quote + "issue-date" + quote + ":" + quote + issue_date + quote + "," + '\n'
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

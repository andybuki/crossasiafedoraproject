package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJsonIssue {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            String quote2 = "&#92;";
            JSONObject jsonObject;
            String meta_china = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\meta_china.json";
            String issue = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\metachina_issue.json"));
            JSONArray metachinaObject = new JSONArray(new JSONTokener(new FileInputStream(meta_china)));
            JSONArray issueObject = new JSONArray(new JSONTokener(new FileInputStream(issue)));

            String id="";
            String journal_title="";
            String code="";
            String title="";
            String language ="";
            String city ="";
            String country="";
            String PublicationTitle ="";
            String issue_date ="";
            String xml_name ="";

            String xml_location ="";

            String file_name ="";
            String image_name ="";
            String image_location ="";
            String file_name_check="";

            String libraryName ="";
            String libraryLocation ="";
            String publicationVolume ="";
            String issue_issue ="";
            String id_issue ="";
            String assetID ="";
            String dviCollectionID ="";
            String PSMID ="";

            String date_original ="";
            String date ="";
            String imageLocationId ="";

            for (int i=0; i<metachinaObject.length(); i++) {
                JSONObject numerObj = (JSONObject) metachinaObject.get(i);
                id = (String) numerObj.get("id").toString();
                code = (String) numerObj.get("code").toString();
                title = (String) numerObj.get("title").toString();
                journal_title =(String) numerObj.get("journal-title").toString();
                language =(String) numerObj.get("language").toString();
                city=(String) numerObj.get("city").toString();
                country=(String) numerObj.get("country").toString();
                issue_date = (String) numerObj.get("issue-date").toString();
                xml_location = (String) numerObj.get("xml-location").toString();
                xml_name = (String) numerObj.get("xml-name").toString();
                file_name = (String) numerObj.get("file-name").toString();

                if (numerObj.has("image-name")) {
                    image_name = (String) numerObj.get("image-name").toString();
                }
                if (numerObj.has("image-location")) {
                    image_location = (String) numerObj.get("image-location").toString();
                }
                file_name_check = file_name.replaceAll("_Issue.xml","");

                for (int j=0; j<issueObject.length();j++) {
                    JSONObject numerObjName = (JSONObject) issueObject.get(j);

                    libraryName = (String) numerObjName.get("libraryName").toString();
                    libraryLocation = (String) numerObjName.get("libraryLocation").toString();
                    publicationVolume = (String) numerObjName.get("publicationVolume").toString();
                    issue_issue = (String) numerObjName.get("issue").toString();
                    id_issue = (String) numerObjName.get("id").toString();
                    assetID = (String) numerObjName.get("assetID").toString();
                    dviCollectionID = (String) numerObjName.get("dviCollectionID").toString();
                    PSMID = (String) numerObjName.get("PSMID").toString();
                    date_original = (String) numerObjName.get("date_original").toString();
                    date = (String) numerObjName.get("date").toString();

                    if (file_name_check.equals(PSMID)){
                        out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                                + quote + "title" + quote + ":" +   quote +title+  quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Journal" +  quote + "," + '\n'
                                + quote + "journal-title" + quote + ":" +   quote +journal_title + quote + "," + '\n'
                                + quote + "code" + quote + ":" +   quote +code + "," + '\n'
                                + quote + "language" + quote + ":" +   quote +language+   "," + '\n'
                                + quote + "city" + quote + ":" +   quote +city+   "," + '\n'
                                + quote + "country" + quote + ":" +   quote +country + "," + '\n'
                                + quote + "series-title" + quote + ":" +   quote +"Gale - China from Empire to Republic: Missionary, Sinology and Literary Periodicals, 1817-1949" +  quote + "," + '\n'
                                + quote + "issue-date" + quote + ":" +   quote +issue_date +  quote + "," + '\n'
                                + quote + "xml-location" + quote + ":" +   quote +xml_location +  quote + "," + '\n'
                                + quote + "xml-name" + quote + ":" +   quote +xml_name +  quote + "," + '\n'
                                + quote + "file-name" + quote + ":" +   quote +file_name +  quote + "," + '\n'
                                + quote + "image-name" + quote + ":" +   quote +image_name +  quote + "," + '\n'
                                + quote + "image-location" + quote + ":" +   quote +image_location +  quote + ","  + '\n'

                                + quote + "date" + quote + ":" +   quote +date +  quote + ","  + '\n'
                                + quote + "date_original" + quote + ":" +   quote +date_original +  quote + ","  + '\n'
                                + quote + "issue" + quote + ":" +   quote +issue_issue +  quote + ","  + '\n'
                                + quote + "publication-volume" + quote + ":" +   quote +publicationVolume +  quote + ","  + '\n'
                                + quote + "library-location" + quote + ":" +   quote +libraryLocation +  quote + ","  + '\n'
                                + quote + "library-name" + quote + ":" +   quote +libraryName +  quote +  '\n'
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

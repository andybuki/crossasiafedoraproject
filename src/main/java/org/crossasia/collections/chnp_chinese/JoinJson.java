package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJson {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            JSONObject jsonObject;
            String metadata = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\metadata.json";
            String china = "D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\china.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\meta_china.json"));
            JSONArray metadataObject = new JSONArray(new JSONTokener(new FileInputStream(metadata)));
            JSONArray chinaObject = new JSONArray(new JSONTokener(new FileInputStream(china)));

            String id="";
            String journal_title="";
            String code="";
            String title="";
            String language ="";
            String city ="";
            String country="";
            String PublicationTitle ="";
            String IssueDate ="";
            String XMLDriveName ="";

            String XMLLocation ="";

            String Filename ="";
            String ImageDriveName ="";
            String ImageLocation ="";


            for (int i=0; i<metadataObject.length(); i++) {
                JSONObject numerObj = (JSONObject) metadataObject.get(i);
                id = (String) numerObj.get("id").toString();
                code = (String) numerObj.get("code").toString();
                title = (String) numerObj.get("title").toString();
                journal_title =(String) numerObj.get("journal-title").toString();
                language =(String) numerObj.get("language").toString();
                city=(String) numerObj.get("city").toString();
                country=(String) numerObj.get("country").toString();

                for (int j=0; j<chinaObject.length();j++) {
                    JSONObject numerObjName = (JSONObject) chinaObject.get(j);

                    PublicationTitle = (String) numerObjName.get("PublicationTitle").toString();
                    IssueDate = (String) numerObjName.get("IssueDate").toString();
                    XMLLocation = (String) numerObjName.get("XMLLocation").toString();
                    XMLDriveName = (String) numerObjName.get("XMLDriveName").toString();
                    Filename = (String) numerObjName.get("Filename").toString();
                    ImageDriveName = (String) numerObjName.get("ImageDriveName").toString();
                    ImageLocation = (String) numerObjName.get("ImageLocation").toString();

                    if (title.equals(PublicationTitle)){
                        out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                                + quote + "title" + quote + ":" +   quote +title+  quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Journal" +  quote + "," + '\n'
                                + quote + "journal-title" + quote + ":" +   quote +journal_title + quote + "," + '\n'
                                + quote + "code" + quote + ":" +   quote +code + quote+"," + '\n'
                                + quote + "language" + quote + ":" +   quote +language+ quote+  "," + '\n'
                                + quote + "city" + quote + ":" +   quote +city+ quote+  "," + '\n'
                                + quote + "country" + quote + ":" +   quote +country +quote+ "," + '\n'
                                + quote + "series-title" + quote + ":" +   quote +"Gale - China from Empire to Republic: Missionary, Sinology and Literary Periodicals, 1817-1949" +  quote + "," + '\n'
                                + quote + "issue-date" + quote + ":" +   quote +IssueDate +  quote + "," + '\n'
                                + quote + "xml-location" + quote + ":" +   quote +XMLLocation +  quote + "," + '\n'
                                + quote + "xml-name" + quote + ":" +   quote +XMLDriveName +  quote + "," + '\n'
                                + quote + "file-name" + quote + ":" +   quote +Filename +  quote + "," + '\n'
                                + quote + "image-name" + quote + ":" +   quote +ImageDriveName +  quote + "," + '\n'
                                + quote + "image-location" + quote + ":" +   quote +ImageLocation +  quote  + '\n'

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

package org.crossasia.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class JoinJsonMetadataText2 {

    public static void main(String[] args) {
        try {
            String quote = "\u005c\u0022";
            String question ="\\u003F";
            String quote2 = "&#92;";
            JSONObject jsonObject;
            String meta = "D:\\SOLR-COLLECTIONS\\CHNP2\\meta.json";
            String metadata = "D:\\SOLR-COLLECTIONS\\CHNP2\\metadata1.json";
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\\\metadatatext.json"));
            StringBuilder sb = new StringBuilder();
            JSONArray metaArray = new JSONArray(new JSONTokener(new FileInputStream(meta)));
            JSONArray metadataArray = new JSONArray(new JSONTokener(new FileInputStream(metadata)));

            for (int i=0; i<metaArray.length(); i++) {

                String id="";
                String idShort="";
                String idShort2="";
                String title="";
                String language ="";



                String page_range ="";
                String asset_id="";
                String medium="";

                String format="";
                String extent ="";
                String description="";

                String format2="";

                String publication_place ="";
                String series_title="";
                String issue_date="";
                String url="";
                String PSMID="";
                String date="";
                String date_original="";



                JSONObject numerObj = (JSONObject) metadataArray.get(i);

                if (numerObj.has("id")) {
                    id = (String) numerObj.get("id").toString();
                }
                if (numerObj.has("title")) {
                    title = (String) numerObj.get("title").toString();
                }
                if (numerObj.has("date")) {
                    date =(String) numerObj.get("date").toString();
                }
                if (numerObj.has("extent")) {
                    extent =(String) numerObj.get("extent").toString();
                }
                if (numerObj.has("medium")) {
                    medium = (String) numerObj.get("medium").toString();
                }
                if (numerObj.has("asset_id")) {
                    asset_id = (String) numerObj.get("asset_id").toString();
                }

                if (numerObj.has("series-title")) {
                    series_title = (String) numerObj.get("series-title").toString();
                }


                for (int j=0; j<metadataArray.length();j++) {
                    String electronic_url ="";
                    String identifier ="";
                    String publisher ="";
                    JSONObject numerObjName = (JSONObject) metaArray.get(j);

                    id = (String) numerObjName.get("id").toString();
                    if (numerObjName.has("electronic_url")){
                        electronic_url = (String) numerObjName.get("electronic_url").toString();
                    }
                    if (numerObjName.has("identifier")){
                        identifier = (String) numerObjName.get("identifier").toString();
                    }
                    if (numerObjName.has("publication_place")){
                        publication_place = (String) numerObjName.get("publication_place").toString();
                    }
                    if (numerObjName.has("format")){
                        format = (String) numerObjName.get("format").toString();
                    }
                    if (numerObjName.has("publisher")){
                        publisher = (String) numerObjName.get("publisher").toString();
                    }
                    if (numerObjName.has("description")){
                        description = (String) numerObjName.get("description").toString();
                    }
                    if (numerObjName.has("language")){
                        language = (String) numerObjName.get("language").toString();
                    }

                    if (numerObjName.get("id").equals(numerObj.get("id"))){

                        sb.append("{" + quote + "language" + quote + ":"   + language  + "," + '\n'
                                + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote + id + quote + "," + '\n'
                                + quote + "format" + quote + ":" + quote + format + quote + "," + '\n'
                                + quote + "date" + quote + ":" + quote + date + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Journal" + quote + "," + '\n'
                                + quote + "medium" + quote + ":" + quote + medium + quote + "," + '\n'
                                + quote + "description" + quote + ":" + quote + description + quote + "," + '\n'
                                + quote + "title" + quote + ":" + quote + title + quote + "," + '\n'
                                + quote + "publisher" + quote + ":" + quote + publisher + quote + "," + '\n'
                                + quote + "extent" + quote + ":" + quote + extent + quote + "," + '\n'
                                + quote + "collection" + quote + ":" + quote + "Gale CFER" + quote + "," + '\n'
                                + quote + "publication_place" + quote + ":" + quote + publication_place + quote + "," + '\n'
                                + quote + "series_title" + quote + ":" +  series_title +  "," + '\n'
                                + quote + "electronic_url" + quote + ":" + quote + electronic_url + quote + "," + '\n'
                                + quote + "identifier" + quote + ":"  + identifier  + "" + '\n'
                                + "},"
                        );
                    }else {
                        System.out.println("NO");
                    }


                }

            }
            sb.deleteCharAt(sb.length() - 1);
            out.println("["+sb.toString()+"]");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

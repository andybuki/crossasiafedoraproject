package org.crossasia.collections.chnp_chinese;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonMetadata {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\metadata2\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\metadata2.json"));
        String bookName = "";
        String page = "";
        String text = "";
        String quote = "\u005c\u0022";
        int year = 0;
        int i;


        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);

            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                //String textReplace =  everything.replace("\r\n"," ").replace("\f","");
                String fileName = file.toString();
                //String fileName1 = fileName.replace("/Users/andreybuchmann/Downloads/JOBIK/xml2/", "");

                JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                JSONObject dataExport = (JSONObject) jsonObject.get( "PubInfo" );
                String journal_title = (String) dataExport.get( "PublicationTitle" ).toString();
                String code = (String) dataExport.get( "mcode" ).toString();
                String city="";
                String title="";
                String id ="";
                String language ="";
                String country ="";
                JSONArray variantTitles = (JSONArray) dataExport.get("VariantTitles");
                //if ( ((JSONObject) dataExport.get("VariantTitles")).length()>=2) {
                    System.out.println("ok");
                    for (int k=0; k<variantTitles.length(); k++) {
                        JSONObject variantTitles2 = (JSONObject) variantTitles.get( k );
                        title = (String) variantTitles2.get("Title").toString();
                        id = (String) variantTitles2.get("NewspaperID").toString();
                        language = (String) variantTitles2.get("Language").toString();

                        if (variantTitles2.has("City")){
                            city = (String) variantTitles2.get("City").toString();
                        } else {
                            city="";
                        }
                        country = (String) variantTitles2.get("Country").toString();

                        out.println("{" + quote + "journal-title" + quote + ":" + quote+ journal_title + quote + "," + '\n'
                                + quote + "code" + quote + ":" +   quote +code +  quote + "," + '\n'
                                + quote + "id" + quote + ":" +   quote +id +  quote + "," + '\n'
                                + quote + "title" + quote + ":" +   quote +title +  quote + "," + '\n'
                                + quote + "series-title" + quote + ":" +   quote +"Gale - China from Empire to Republic: Missionary, Sinology and Literary Periodicals, 1817-1949" +  quote + "," + '\n'
                                + quote + "language" + quote + ":" +   quote +language +  quote + "," + '\n'
                                + quote + "city" + quote + ":" +   quote +city +  quote + "," + '\n'
                                + quote + "country" + quote + ":" +   quote +country +  quote + "" + '\n'
                                +"},"
                        );
                   // }
                //} else {

                     /*title = (String) variantTitles.get("Title").toString();
                     id = (String) variantTitles.get("NewspaperID").toString();
                     language = (String) variantTitles.get("Language").toString();
                     city="";
                    if (variantTitles.has("City")){
                        city = (String) variantTitles.get("City").toString();
                    } else {
                        city="";
                    }

                     country = (String) variantTitles.get("Country").toString();

                    out.println("{" + quote + "journal-title" + quote + ":" + quote+ journal_title + quote + "," + '\n'
                            + quote + "code" + quote + ":" +   quote +code +  quote + "," + '\n'
                            + quote + "id" + quote + ":" +   quote +id +  quote + "," + '\n'
                            + quote + "title" + quote + ":" +   quote +title +  quote + "," + '\n'
                            + quote + "series-title" + quote + ":" +   quote +"Gale - China from Empire to Republic: Missionary, Sinology and Literary Periodicals, 1817-1949" +  quote + "," + '\n'
                            + quote + "language" + quote + ":" +   quote +language +  quote + "," + '\n'
                            + quote + "city" + quote + ":" +   quote +city +  quote + "," + '\n'
                            + quote + "country" + quote + ":" +   quote +country +  quote + "" + '\n'
                            +"},"
                    );*/

                }





            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }
}

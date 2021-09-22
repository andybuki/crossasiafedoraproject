package org.crossasia.solr.collections.chnp_chinese;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonMetadata {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\CHNP2\\meta\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\meta.json"));
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
                StringBuilder sb2 = new StringBuilder();
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


                String publisher ="";
                String lang_content ="";

                JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));

                JSONObject dataExport = (JSONObject) jsonObject.get( "manuscript" );
                String type = (String) dataExport.get("type").toString();

                JSONObject msInfo = (JSONObject) dataExport.get("msInfo");
                String msNumber = (String) msInfo.get("msNumber").toString();
                String assetID = (String) msInfo.get("assetID").toString();
                String mcode = (String) msInfo.get("mcode").toString();
                String id = (String) msInfo.get("PSMID").toString();
                Object msLanguage =  msInfo.get("msLanguage");
                if (msLanguage instanceof JSONObject) {
                    JSONObject msLanguage2  = (JSONObject) msLanguage;
                    lang_content = (String) msLanguage2.get("content");
                    lang_content = quote+lang_content +quote;
                } else {
                    JSONArray msLanguage2 = (JSONArray) msLanguage;
                    for (int ln=0; ln<msLanguage2.length(); ln++) {
                        String language ="";
                        JSONObject lang = (JSONObject) msLanguage2.get(ln);
                        language = (String) lang.get("content");
                        lang_content +=quote+language+quote+" ,";
                    }
                    lang_content = lang_content.substring(0, lang_content.length() - 1);


                }


                if (msInfo.has("publisher"))
                { publisher = (String) msInfo.get("publisher").toString();}
                String publicationPlaceComposed ="";
                if (msInfo.has("publicationPlace")) {
                    JSONObject publicationPlace = (JSONObject) msInfo.get("publicationPlace");
                    publicationPlaceComposed = (String) publicationPlace.get("publicationPlaceComposed");
                }

                JSONObject sourceLibrary = (JSONObject) msInfo.get("sourceLibrary");
                String libraryName  = (String) sourceLibrary.get("libraryName").toString();
                String libraryLocation =(String) sourceLibrary.get("libraryLocation").toString();
                String ProductLink =(String) msInfo.get("ProductLink").toString();

                sb2.append("{"
                        + quote + "hasModel" + quote + ":" +   quote +"Journal" +  quote + "," + '\n'
                        + quote + "id" + quote + ":" +   quote +id +  quote + "," + '\n'
                        + quote + "electronic_url" + quote + ":" +   quote +ProductLink +  quote + "," + '\n'
                        + quote + "publisher" + quote + ":" +   quote +publisher +  quote + "," + '\n'
                        + quote + "language" + quote + ":" +   "[" +lang_content + "]"  + "," + '\n'
                        + quote + "format" + quote + ":" +   quote +type+ quote + "," + '\n'
                        + quote + "identifier" + quote + ":" +  "["+ quote +assetID+ quote +","+ quote +mcode+ quote+"]"+"," +'\n'
                        + quote + "description" + quote + ":" +   quote +libraryName+" ("+libraryLocation+ "): "+msNumber+quote + "," + '\n'
                        + quote + "publication_place" + quote + ":" +   quote +publicationPlaceComposed +  quote + "" + '\n'
                        +"},"
                );

                //sb2.deleteCharAt(sb2.length() - 1);
                out.println(sb2.toString());
            }catch(JSONException e){
                e.printStackTrace();
            }




        }

    }
}

package org.crossasia.collections.airiti_teps;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConverterXmlToJson {
    public static void main(String[] args) {
        String quote = "\u005c\u0022";
        String fileName = "D:\\SOLR-COLLECTIONS\\AL_Conferences_DocEName.xml";
        try {
            PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\Conference_Name.json"));
            JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
            JSONObject documents = (JSONObject) jsonObject.get( "Documents" );
            JSONObject docMetas = (JSONObject) documents.get( "DocMetas" );
            JSONArray docMeta = (JSONArray) docMetas.get( "DocMeta" );
            for (int i=1; i<docMeta.length(); i++){
                JSONObject numerObj = (JSONObject) docMeta.get(i);
                String id = (String) numerObj.get("DocID").toString();
                String name = (String) numerObj.get("DocEName").toString().replace(quote,"xaxaxa");
                out.println("{" + quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n'
                        + quote + "name" + quote + ":" +   quote +name.replaceAll("\"","'").replaceAll(quote,"'") +  quote + "," + '\n'
                        +"},");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

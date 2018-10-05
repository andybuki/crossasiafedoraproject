package org.crossasia.collections.chnp_chinese;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonText {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\text\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\text3.json"));


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

                JSONObject jsonObject = XML.toJSONObject(new String(Files.readAllBytes(Paths.get(fileName))));
                JSONObject articles = (JSONObject) jsonObject.get("articles");
                JSONArray article = (JSONArray) articles.get("artInfo");
                String text = "";
                String link = "";
                for (int ar=0; ar<article.length(); ar++) {
                    JSONObject artikul = (JSONObject) article.get(ar);
                    if (artikul.has("ProductLink")) {
                        link = (String) artikul.get("ProductLink");
                    }
                    if (artikul.has("ocrText")) {
                        text = (String) artikul.get("ocrText").toString().replaceAll("\"","'").replaceAll(quote,"'").replaceAll(quote,"\"");
                    }
                    System.out.println(text);
                    out.println("{"
                            + quote + "link" + quote + ":" + quote + link + quote + "," + '\n'
                            + quote + "text" + quote + ":" + quote + text + quote + "" + '\n'
                            + "},"
                    );
                }

            }catch(JSONException e){
                e.printStackTrace();
            } catch(NumberFormatException ex){ // handle your exception

            }

        }

    }
}

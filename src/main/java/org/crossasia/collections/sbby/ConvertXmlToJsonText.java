package org.crossasia.collections.sbby;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonText {
    public static void main( String[] args ) throws Exception {

        File dir = new File("/data1/sbb/");
        PrintStream out = new PrintStream(new FileOutputStream("/data1/sbb/json/text.json"));


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
                JSONObject articles = (JSONObject) jsonObject.get("page");

                Object article =  articles.get("page");
                if (article instanceof JSONArray) {
                    JSONArray article2 = (JSONArray) article;
                    String text = "";
                    String link = "";
                    String id = "";
                    for (int ar = 0; ar < article2.length(); ar++) {
                        String fileName2 = fileName.toString().replace("/data1/sbb/json/", "").replace("_PageText.xml", "");
                        JSONObject artikul = (JSONObject) article2.get(ar);
                        if (artikul.has("ProductLink")) {
                            link = (String) artikul.get("ProductLink");
                        }
                        if (artikul.has("id")) {
                            id = (String) artikul.get("id");
                        }
                        if (artikul.has("ocrText")) {
                            text = (String) artikul.get("ocrText").toString().replaceAll("\"", "'").replaceAll(quote, "'").replaceAll(quote, "\"").replaceAll("[\r\n]+", " ");
                        }
                        System.out.println(text);
                        out.println("{"
                                + quote + "id" + quote + ":" + quote + fileName2 + quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote + id + quote + "," + '\n'
                                + quote + "text" + quote + ":" + quote + text + quote + "" + '\n'
                                + "},"
                        );
                    }
                } else {
                    JSONObject article2 = (JSONObject) article;
                    String fileName2 = fileName.toString().replace("/data1/sbb/json/", "").replace("_PageText.xml", "");
                    String text = "";
                    String link = "";
                    String id = "";
                    if (article2.has("ProductLink")) {
                        link = (String) article2.get("ProductLink");
                    }
                    if (article2.has("id")) {
                        id = (String) article2.get("id");
                    }
                    if (article2.has("ocrText")) {
                        text = (String) article2.get("ocrText").toString().replaceAll("\"", "'").replaceAll(quote, "'").replaceAll(quote, "\"").replaceAll("[\r\n]+", " ");
                    }
                    //System.out.println(text);
                    out.println("{"
                            + quote + "id" + quote + ":" + quote + fileName2 + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote + id + quote + "," + '\n'
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

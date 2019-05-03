package org.crossasia.collections.chnp_chinese;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonPages {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\CHNP2\\meta\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\pages.json"));
        String bookName = "";

        String text = "";
        String quote = "\u005c\u0022";
        int year = 0;
        int i;

        StringBuilder sb = new StringBuilder();
        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";
            Reader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), encoding));
            BufferedReader br = new BufferedReader(reader);

            try {

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

                JSONObject dataExport = (JSONObject) jsonObject.get("manuscript");
                Object pages =  dataExport.get("page");

                if (pages instanceof JSONArray) {
                    JSONArray pages2 = (JSONArray) pages;
                    for (int p = 0; p < pages2.length(); p++) {
                        JSONObject page = (JSONObject) pages2.get(p);
                        JSONObject pageInfo = (JSONObject) page.get("pageInfo");
                        String pageID = (String) pageInfo.get("pageID");
                        String assetID = (String) pageInfo.get("assetID");
                        JSONObject msImage = (JSONObject) pageInfo.get("msImage");
                        String content = (String) msImage.get("content").toString().replace(".jpg", "");

                        out.println("{"
                                + quote + "id" + quote + ":" + quote + content + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" + quote + "Journal" + quote + "," + '\n'
                                + quote + "position" + quote + ":" + quote + pageID + quote + "," + '\n'
                                + quote + "identifier" + quote + ":" + quote + assetID + quote + "" + '\n'
                                + "},"
                        );

                    }
                } else {
                    JSONObject pages2 = (JSONObject) pages;
                    JSONObject pageInfo = (JSONObject) pages2.get("pageInfo");
                    String pageID = (String) pageInfo.get("pageID");
                    String assetID = (String) pageInfo.get("assetID");
                    JSONObject msImage = (JSONObject) pageInfo.get("msImage");
                    String content = (String) msImage.get("content").toString().replace(".jpg", "");
                    out.println("{"
                            + quote + "id" + quote + ":" + quote + content + quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" + quote + "Journal" + quote + "," + '\n'
                            + quote + "position" + quote + ":" + quote + pageID + quote + "," + '\n'
                            + quote + "identifier" + quote + ":" + quote + assetID + quote + "" + '\n'
                            + "},"
                    );

                }
            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }
}

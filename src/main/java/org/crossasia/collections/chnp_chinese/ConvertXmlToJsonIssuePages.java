package org.crossasia.collections.chnp_chinese;
import org.json.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonIssuePages {
    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\chnp_2016_chinese\\issue_pages.json"));
        String bookName = "";
        //String page = "";
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

                JSONObject jsonObject = XML.toJSONObject(new String(Files.readAllBytes(Paths.get(fileName))));
                JSONObject dataExport = (JSONObject) jsonObject.get("issue");
                JSONArray page = (JSONArray) dataExport.get("page");
                String page_num = "";
                String asset_id = "";
                String title = "";
                String assetid_page = "";
                String language = "";
                String id = "";
                String ct = "";


                for (int ar = 0; ar < page.length(); ar++) {
                    JSONObject page_description = (JSONObject) page.get(ar);
                    if (page_description.has("pa")) {
                        page_num = (String) page_description.get("pa").toString();
                    }

                    asset_id = (String) page_description.get("assetID").toString();

                    if (page_description.has("article")) {
                        Object intervention = page_description.get("article");
                        String author = "";
                        String author2 = "";

                        StringBuffer sbf = new StringBuffer();
                        StringBuffer sbf2 = new StringBuffer();
                        if (intervention instanceof JSONObject) {
                           JSONObject articles = (JSONObject) page_description.get("article");
                            title = (String) articles.get("ti").toString().replaceAll("\"","'").replaceAll(quote,"'");
                            assetid_page = (String) articles.get("assetID").toString();
                            language = (String) articles.get("ocrLanguage").toString();
                            id = (String) articles.get("id").toString();
                            ct = (String) articles.get("ct").toString();

                            if (articles.has("detailed_au")) {
                                Object art = articles.get("detailed_au");
                                if (art instanceof JSONObject) {
                                    JSONObject authors = (JSONObject) articles.get("detailed_au");
                                    author = (String) authors.get("composed").toString();
                                    //sbf.append(author);

                                } else if (art instanceof JSONArray) {
                                    JSONArray authors = (JSONArray) articles.get("detailed_au");
                                    String[] authors_array;
                                    String sum_author =author;
                                    for (int auth = 0; auth < authors.length(); auth++) {
                                        JSONObject authoren = (JSONObject) authors.get(auth);
                                        author = (String) authoren.get("composed").toString()+";";
                                        sum_author =sum_author.concat(author);
                                    }

                                    authors_array =sum_author.split(";");
                                    if (authors_array.length>=1) {
                                        sbf.append(authors_array[0]);
                                        for (int key=1; key<authors_array.length; key ++) {
                                            sbf.append("\","+quote).append(authors_array[key] ).append("");
                                        }
                                    }
                                }
                            }

                            out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                                    + quote + "assetid_page" + quote + ":" + quote + assetid_page + quote + "," + '\n'
                                    + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                    + quote + "ct" + quote + ":" + quote + ct + quote + "," + '\n'
                                    + quote + "title" + quote + ":" + quote + title.replaceAll("\"","'").replaceAll(quote,"'") + quote + "," + '\n'
                                    + quote + "author" + quote + ":" +  "["+  quote +author.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                    + quote + "author2" + quote + ":" +  "["+  quote +sbf.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                    + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                    + quote + "page_num" + quote + ":" + quote + page_num + quote + "" + '\n'
                                    + "},"
                            );

                        } else if (intervention instanceof JSONArray) {
                            JSONArray articles = (JSONArray) page_description.get("article");
                            for (int art = 0; art < articles.length(); art++) {
                                JSONObject article2 = (JSONObject) articles.get(art);
                                title = (String) article2.get("ti").toString().replaceAll("\"","'").replaceAll(quote,"'");
                                assetid_page = (String) article2.get("assetID").toString();
                                language = (String) article2.get("ocrLanguage").toString();
                                id = (String) article2.get("id").toString();
                                ct = (String) article2.get("ct").toString();

                                if (article2.has("detailed_au")) {
                                    Object art22 = article2.get("detailed_au");
                                    if (art22 instanceof JSONObject) {
                                        JSONObject authors2 = (JSONObject) article2.get("detailed_au");
                                        author2 = (String) authors2.get("composed").toString();
                                        //sbf2.append(author2);

                                    } else if (art22 instanceof JSONArray) {
                                        JSONArray authors = (JSONArray) article2.get("detailed_au");
                                        String[] authors_array2;
                                        String sum_author =author2;
                                        for (int auth = 0; auth < authors.length(); auth++) {
                                            JSONObject authoren = (JSONObject) authors.get(auth);
                                            author = (String) authoren.get("composed").toString()+";";
                                            sum_author =sum_author.concat(author2);
                                        }

                                        authors_array2 =sum_author.split(";");
                                        if (authors_array2.length>=0) {
                                            sbf2.append(authors_array2[0]);
                                            for (int key=1; key<authors_array2.length; key ++) {
                                                sbf2.append("\","+quote).append(authors_array2[key] ).append("");
                                            }
                                        }


                                    }

                                }
                            }
                            out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                                    + quote + "assetid_page" + quote + ":" + quote + assetid_page + quote + "," + '\n'
                                    + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                    + quote + "ct" + quote + ":" + quote + ct + quote + "," + '\n'
                                    + quote + "author" + quote + ":" +  "["+  quote +author2.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]"  + "," + '\n'
                                    + quote + "author2" + quote + ":" +  "["+  quote +sbf2.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]"  + "," + '\n'
                                    + quote + "title" + quote + ":" + quote + title.replaceAll("\"","'").replaceAll(quote,"'") + quote + "," + '\n'
                                    + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                    + quote + "page_num" + quote + ":" + quote + page_num + quote + "" + '\n'
                                    + "},"
                            );

                        }
                    } else {
                        out.println("{"
                                + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                + quote + "page_num" + quote + ":" + quote + page_num + quote + "" + '\n'
                                + "},"
                        );
                    }
                }
            }catch(JSONException e){
                e.printStackTrace();
            }

        }

    }
}

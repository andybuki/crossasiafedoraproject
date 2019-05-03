package org.crossasia.collections.chnp_chinese;

import org.crossasia.converter.Converter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonIssuePages {
    public static int parseStrToInt(String str) {
        if (str.matches("\\d+")) {
            return Integer.parseInt(str);
        } else {
            return 0;
        }
    }

    public static void main( String[] args ) throws Exception {

        File dir = new File("D:\\SOLR-COLLECTIONS\\CHNP2\\meta\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CHNP2\\issue.json"));
        Converter converter = new Converter();
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
                int page_num = 0;
                String asset_id = "";

                String assetid_page = "";
                String language = "";
                String id = "";
                String ct = "";
                String descriptionPic = "";
                String descriptionPic2 = "";
                String page_range = "";
                String type="";
                String colorImage ="";
                String content ="";
                String ocr ="";
                double ocrs=0.0;
                int clipref =0;
                int real_page=0;
                //int pc =0;
                String sum_descriptionPic ="";

                for (int ar = 0; ar < page.length(); ar++) {
                    JSONObject page_description = (JSONObject) page.get(ar);
                    if (page_description.has("pa")) {
                        if (page_description.get("pa").toString().matches("-?\\d+")){
                            page_num = (int) page_description.get("pa");
                        } else {
                            page_num =converter.toNumerical(page_description.get("pa").toString());
                        }
                    }else {
                        page_num =0;
                    }

                    asset_id = (String) page_description.get("assetID").toString();

                    if (page_description.has("article")) {
                        Object intervention = page_description.get("article");
                        String author = "";



                       // StringBuffer sbf2 = new StringBuffer();
                        if (intervention instanceof JSONObject) {
                           JSONObject articles = (JSONObject) page_description.get("article");
                            String title = "";
                            title = (String) articles.get("ti").toString().replaceAll("\"","'").replaceAll(quote,"'");
                            assetid_page = (String) articles.get("assetID").toString();

                            if (articles.has("ocr")) {
                                ocr = (String) articles.get("ocr").toString();
                                if (ocr.equals("0.0")) {
                                    descriptionPic="No fulltext";
                                }
                            }
                            ocrs = (double) articles.get("ocr");

                            if (articles.has("il")) {
                                Object arttikul = articles.get("il");
                                if (arttikul instanceof JSONObject) {
                                    JSONObject descriptions = (JSONObject) articles.get("il");
                                    colorImage = (String) descriptions.get("colorimage");
                                    type = (String) descriptions.get("type");
                                    clipref =((int) descriptions.get("clipref"));
                                    if (descriptions.has("content")) {
                                        content = (String) descriptions.get("content").toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","").replaceAll(quote,"'");
                                    }else {
                                        content ="";
                                    }
                                    if (ocrs>0) {
                                        real_page = page_num;
                                        int sum= real_page+clipref-1;
                                        descriptionPic2 = type+"("+ colorImage+"): "+content +"p."+sum;
                                        sum_descriptionPic ="Article contains images. "+descriptionPic2;
                                    }
                                } else {
                                    JSONArray descriptions = (JSONArray) articles.get("il");
                                    String sum_content =content;
                                    sum_descriptionPic ="Article contains images."+descriptionPic+" ";
                                    for (int de =0; de<descriptions.length(); de++) {
                                        JSONObject descriptions2 = (JSONObject) descriptions.get(de);
                                        colorImage = (String) descriptions2.get("colorimage");
                                        type = (String) descriptions2.get("type");
                                        clipref =((int) descriptions2.get("clipref"));
                                        if (descriptions2.has("content")) {
                                            content = (String) descriptions2.get("content").toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","").replaceAll(quote,"'");
                                        }
                                        else {
                                            content ="";
                                        }
                                        if (ocrs>0) {
                                            real_page = page_num;
                                            int sum= real_page+clipref-1;
                                            sum_content =sum_content.concat(content);
                                            descriptionPic = type+"("+ colorImage+"): "+content +" p."+sum+"; ";
                                            sum_descriptionPic =sum_descriptionPic.concat(descriptionPic);
                                        }
                                    }
                                }
                            }else {
                                sum_descriptionPic="";
                            }

                            language = (String) articles.get("ocrLanguage").toString();
                            id = (String) articles.get("id").toString();
                            ct = (String) articles.get("ct").toString();

                            StringBuffer sbf = new StringBuffer();
                            if (articles.has("detailed_au")) {
                                Object art = articles.get("detailed_au");
                                if (art instanceof JSONObject) {
                                    JSONObject authors = (JSONObject) articles.get("detailed_au");
                                    author = (String) authors.get("composed").toString();
                                    sbf.append(author);

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
                                            sbf.append("\","+quote).append(authors_array[key]).append("");
                                        }
                                    }
                                }
                            }
                            int pc;
                            pc = (int) articles.get("pc")-1;
                            pc = page_num+pc;

                            out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                                    + quote + "assetid_page" + quote + ":" + quote + assetid_page + quote + "," + '\n'
                                    + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                    + quote + "format" + quote + ":" + quote + ct + quote + "," + '\n'
                                    + quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                    + quote + "medium" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                    + quote + "journal-title" + quote + ":" + quote + title.replaceAll("\"","'").replaceAll(quote,"'") + quote + "," + '\n'
                                    //+ quote + "author" + quote + ":" +  "["+  quote +author.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                    + quote + "author" + quote + ":" +  "["+  quote +sbf.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                    + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                    + quote + "volume-number" + quote + ":" + quote + ct + quote + "," + '\n'
                                    + quote + "description" + quote + ":" + quote + sum_descriptionPic + quote + "," + '\n'
                                    + quote + "page-range" + quote + ":" + quote + page_num+"-"+pc + quote + "" + '\n'
                                    + "},"
                            );

                        }  if (intervention instanceof JSONArray) {
                                JSONArray articles = (JSONArray) page_description.get("article");
                                for (int art = 0; art < articles.length(); art++) {
                                    JSONObject article2 = (JSONObject) articles.get(art);
                                    String title="";
                                    title = (String) article2.get("ti").toString().replaceAll("\"","'").replaceAll(quote,"'");
                                    assetid_page = (String) article2.get("assetID").toString();
                                    language = (String) article2.get("ocrLanguage").toString();

                                    if (article2.has("ocr")) {
                                        ocr = (String) article2.get("ocr").toString();
                                        if (ocr.equals("0.0")) {
                                            descriptionPic="No fulltext";
                                        }
                                    }
                                    ocrs = (double) article2.get("ocr");

                                    if (article2.has("il")) {
                                        Object arttikul = article2.get("il");
                                        if (arttikul instanceof JSONObject) {
                                            JSONObject descriptions = (JSONObject) article2.get("il");
                                            colorImage = (String) descriptions.get("colorimage");
                                            type = (String) descriptions.get("type");
                                            clipref =((int) descriptions.get("clipref"));
                                            if (descriptions.has("content")) {
                                                content = (String) descriptions.get("content").toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","").replaceAll(quote,"'");
                                            }else {
                                                content ="";
                                            }
                                            if (ocrs>0) {
                                                real_page = page_num;
                                                int sum= real_page+clipref-1;
                                                descriptionPic2 = type+"("+ colorImage+"): "+content +"p."+sum;
                                                sum_descriptionPic ="Article contains images. "+descriptionPic2;
                                            }
                                        } else {
                                            JSONArray descriptions = (JSONArray) article2.get("il");
                                            String sum_content =content;
                                            sum_descriptionPic ="Article contains images."+descriptionPic+" ";
                                            for (int de =0; de<descriptions.length(); de++) {
                                                JSONObject descriptions2 = (JSONObject) descriptions.get(de);
                                                colorImage = (String) descriptions2.get("colorimage");
                                                type = (String) descriptions2.get("type");
                                                clipref =((int) descriptions2.get("clipref"));
                                                if (descriptions2.has("content")) {
                                                    content = (String) descriptions2.get("content").toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","").replaceAll(quote,"'");
                                                }
                                                else {
                                                    content ="";
                                                }
                                                if (ocrs>0) {
                                                    real_page = page_num;
                                                    int sum= real_page+clipref-1;
                                                    sum_content =sum_content.concat(content);
                                                    descriptionPic = type+"("+ colorImage+"): "+content +" p."+sum+"; ";
                                                    sum_descriptionPic =sum_descriptionPic.concat(descriptionPic);
                                                }
                                            }
                                        }
                                    }else {
                                        sum_descriptionPic="";
                                    }

                                    id = (String) article2.get("id").toString();
                                    ct = (String) article2.get("ct").toString();
                                    StringBuffer sbf2 = new StringBuffer();
                                    String author2 = "";
                                    String author3 = "";
                                    if (article2.has("detailed_au")) {
                                        Object art22 = article2.get("detailed_au");
                                        if (art22 instanceof JSONObject) {
                                            JSONObject authors2 = (JSONObject) article2.get("detailed_au");
                                            author3 = (String) authors2.get("composed").toString();
                                            sbf2.append(author3);

                                        }else if (art22 instanceof JSONArray) {
                                            JSONArray authors = (JSONArray) article2.get("detailed_au");
                                            String[] authors_array2;
                                            String sum_author =author2;
                                            for (int auth = 0; auth < authors.length(); auth++) {
                                                JSONObject authoren = (JSONObject) authors.get(auth);
                                                author2 = (String) authoren.get("composed").toString()+";";
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
                                    int pc;
                                    pc = (int) article2.get("pc")-1;
                                    pc = page_num+pc;

                                    out.println("{" + quote + "language" + quote + ":" + quote + language + quote + "," + '\n'
                                            + quote + "assetid_page" + quote + ":" + quote + assetid_page + quote + "," + '\n'
                                            + quote + "id" + quote + ":" + quote + id + quote + "," + '\n'
                                            + quote + "format" + quote + ":" + quote + ct + quote + "," + '\n'
                                            + quote + "hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                            + quote + "medium" + quote + ":" + quote + "Article" + quote + "," + '\n'
                                            + quote + "journal-title" + quote + ":" + quote + title.replaceAll("\"","'").replaceAll(quote,"'") + quote + "," + '\n'
                                            //+ quote + "author" + quote + ":" +  "["+  quote +author.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                            + quote + "author" + quote + ":" +  "["+  quote +sbf2.toString().replaceAll( " \" ","" ).replaceAll("“","").replaceAll("”","") +  quote +"]" +  "," + '\n'
                                            + quote + "asset_id" + quote + ":" + quote + asset_id + quote + "," + '\n'
                                            + quote + "volume-number" + quote + ":" + quote + ct + quote + "," + '\n'
                                            + quote + "description" + quote + ":" + quote + sum_descriptionPic + quote + "," + '\n'
                                            + quote + "page-range" + quote + ":" + quote + page_num+"-"+pc + quote + "" + '\n'
                                            + "},"
                                    );
                            }
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

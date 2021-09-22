package org.crossasia.solr.collections.ccg;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonSection {

    public static void main( String[] args ) throws Exception {

        File dir = new File("F:\\\\Sections\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\section.json"));
        String bookName = "";

        String quote = "\u005c\u0022";
        int year = 0;

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
                String fileName = file.toString();
                String page_id = fileName.replace("F:\\\\Sections\\","").replace(".xml","");
                String book_id = page_id.substring(4,8);

                if (page_id.contains("-")
                        ){
                    count("xa");
                } else {
                    JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                    JSONObject head = (JSONObject) jsonObject.get( "head" );
                    String page ="";
                    String content_text ="";
                    JSONObject contents = (JSONObject) head.get( "contents" );
                    String title = (String) contents.get("title");
                    if (contents.has("content")){
                        Object content = contents.get( "content" );
                        if (content instanceof JSONObject) {
                            JSONObject content2 = (JSONObject) content;
                            page = (String) content2.get("page_id").toString();
                            content_text =(String) content2.get("content");

                            out.println("{"
                                    + quote + "id" + quote + ":" + quote+ page_id.replace("SZFZ","")+"_"+page + quote + "," + '\n'
                                    //+ quote + "hasModel" + quote + ":" +   quote +"Section" +  quote + "," + '\n'
                                    //+ quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                                    //+ quote + "title" + quote + ":" + quote+ title + quote + "," + '\n'

                                    + quote + "position" + quote + ":" + quote+ page + quote + "," + '\n'
                                    + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                    + quote + "text" + quote + ":" +   quote +content_text +  quote + "" + '\n'
                                    +"},"
                            );


                        } else if (content instanceof JSONArray)
                        {
                            JSONArray content2 = (JSONArray) content;
                            for (int i=0; i<content2.length(); i++) {
                                JSONObject content_line = (JSONObject) content2.get(i);
                                page = (String) content_line.get("page_id").toString();
                                if (content_line.has("content")) {
                                    content_text =(String) content_line.get("content");
                                }

                                out.println("{"
                                        + quote + "id" + quote + ":" + quote+ page_id.replace("SZFZ","")+"_"+page + quote + "," + '\n'
                                        //+ quote + "hasModel" + quote + ":" +   quote +"Section" +  quote + "," + '\n'
                                        //+ quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                                        //+ quote + "title" + quote + ":" + quote+ title + quote + "," + '\n'

                                        + quote + "position" + quote + ":" + quote+ page + quote + "," + '\n'
                                        + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                        + quote + "text" + quote + ":" +   quote +content_text +  quote + "" + '\n'
                                        +"},"
                                );
                            }
                        }
                    } else  {
                        System.out.println("xa");
                    }



                    /*JSONObject text = (JSONObject) data.get( "text" );
                    String text_content="";
                    int volume = Integer.parseInt(page_id.substring(4,7));
                    int position = Integer.parseInt(page_id.substring(7,10));

                    if (text.has("line")) {
                        Object line_text = text.get("line");
                        if (line_text instanceof JSONArray) {
                            JSONArray line2 = (JSONArray) text.get("line");

                            for (int itr=0; itr<line2.length();itr++ ) {
                                JSONObject txt = (JSONObject) line2.get(itr);
                                String oneline="";
                                if (txt.length()>0){
                                    if (!txt.isNull("content")){
                                        oneline = txt.getString("content").replace("Ｍ",":").replace("┳","(").replace("┻",")").replace("∈","").replace("┉","/").toString();
                                    } else {
                                        oneline = null;
                                    }
                                }
                                text_content += " "+ oneline;
                            }

                            count("2");
                        } else if (line_text instanceof JSONObject) {
                            JSONObject line2 = (JSONObject) text.get("line");
                            count("1");

                            for (int itr=0; itr<line2.toString().length();itr++ ) {
                                JSONObject txt = (JSONObject) line2;
                                String oneline="";
                                if (txt.length()>0){
                                    oneline = txt.getString("content").replace("Ｍ",":").replace("┳","(").replace("┻",")").replace("∈","").replace("┉","/");
                                }
                                text_content += " "+ oneline;
                            }

                        }else {
                            count("xa");
                        }
                    }

                    JSONObject setting = (JSONObject) info.get( "setting" );
                    JSONArray modulus = (JSONArray) setting.get( "modulus" );

                    JSONObject title = modulus.getJSONObject(8);
                    String content="";

                    if (title.has("content")) {
                        content = (String) title.get("content").toString().replace("Ｍ",": ").replace("┳","(").replace("┻",")").replace("∈","").replace("┉","");
                    }

                    out.println("{"
                            + quote + "id" + quote + ":" + quote+ page_id + quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                            + quote + "running_title" + quote + ":" + quote+ content + quote + "," + '\n'
                            + quote + "volume" + quote + ":" + quote+ volume + quote + "," + '\n'
                            + quote + "position" + quote + ":" + quote+ position + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                            + quote + "text" + quote + ":" +   quote +text_content +  quote + "" + '\n'
                            +"},"
                    );*/

                    }

            } finally {
                br.close();
            }
        }

    }

    private static void count(String x) {
        System.out.println(x);
    }

}

package org.crossasia.collections.ccg;


import org.json.JSONObject;
import org.json.JSONArray;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonPage {

    public static void main( String[] args ) throws Exception {

        File dir = new File("F:\\DONE\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages.json"));
        String bookName = "";
        String page = "";

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
                String fileName = file.toString();
                String page_id = fileName.replace("F:\\DONE\\","").replace(".xml","");
                String book_id = page_id.substring(0,4);

                if (book_id.equals("2242") ||
                        book_id.equals("2918") ||
                        book_id.equals("5037") ||
                        book_id.equals("5059") ||
                        book_id.equals("5068") ||
                        book_id.equals("5089") ||
                        book_id.equals("5100") ||
                        book_id.equals("5122") ||
                        book_id.equals("5268") ||
                        book_id.equals("5347") ||
                        book_id.equals("5404") ||
                        book_id.equals("5410") ||
                        book_id.equals("5420") ||
                        book_id.equals("5426") ||
                        book_id.equals("5440") ||
                        book_id.equals("5442") ||
                        book_id.equals("5453") ||
                        book_id.equals("5460") ||
                        book_id.equals("5468") ||
                        book_id.equals("5490") ||
                        book_id.equals("5509") ||
                        book_id.equals("5515") ||
                        book_id.equals("5528") ||
                        book_id.equals("5566") ||
                        book_id.equals("5605") ||
                        book_id.equals("5626") ||
                        book_id.equals("5674") ||
                        book_id.equals("5686") ||
                        book_id.equals("5689") ||
                        book_id.equals("5690") ||
                        book_id.equals("5694") ||
                        book_id.equals("5709") ||
                        book_id.equals("5719") ||
                        book_id.equals("5724") ||
                        book_id.equals("5725") ||
                        book_id.equals("5727") ||
                        book_id.equals("5981") ||
                        book_id.equals("5968") ||
                        book_id.equals("5967") ||
                        book_id.equals("5959") ||
                        book_id.equals("5950") ||
                        book_id.equals("5945") ||
                        book_id.equals("5935") ||
                        book_id.equals("5933") ||
                        book_id.equals("5930") ||
                        book_id.equals("5925") ||
                        book_id.equals("5917") ||
                        book_id.equals("5914") ||
                        book_id.equals("5908") ||
                        book_id.equals("5904") ||
                        book_id.equals("5752") ||
                        book_id.equals("5762") ||
                        book_id.equals("5770") ||
                        book_id.equals("5781") ||
                        book_id.equals("5782") ||
                        book_id.equals("5785") ||
                        book_id.equals("5790") ||
                        book_id.equals("5790") ||
                        book_id.equals("5819") ||
                        book_id.equals("5820") ||
                        book_id.equals("5823") ||
                        book_id.equals("5836") ||
                        book_id.equals("5844") ||
                        book_id.equals("5851") ||
                        book_id.equals("5860") ||
                        book_id.equals("5867") ||
                        book_id.equals("5879") ||
                        book_id.equals("5890") ||
                        book_id.equals("5893") ||
                        book_id.equals("5894") ||
                        book_id.equals("5895") ||
                        book_id.equals("5903")
                        ){
                    count("xa");
                } else {

                    JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                    JSONObject dataExport = (JSONObject) jsonObject.get( "page" );

                    JSONObject info = (JSONObject) dataExport.get( "info" );
                    JSONObject data = (JSONObject) dataExport.get( "data" );
                    JSONObject text = (JSONObject) data.get( "text" );
                    String text_content="";

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
                            + quote + "title" + quote + ":" + quote+ content + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                            + quote + "text" + quote + ":" +   quote +text_content +  quote + "" + '\n'
                            +"},"
                    );

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

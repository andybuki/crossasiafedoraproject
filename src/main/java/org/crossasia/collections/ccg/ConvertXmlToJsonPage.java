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
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_last.json"));
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
                int book_id = Integer.parseInt(page_id.substring(0,4));

                String books_id = (page_id.substring(0,4));

                if (book_id==(2242) ||
                        book_id==(2918) ||
                        book_id==(5037) ||
                        book_id==(5059) ||
                        book_id==(5068) ||
                        book_id==(5089) ||
                        book_id==(5100) ||
                        book_id==(5122) ||
                        book_id==(5268) ||
                        book_id==(5347) ||
                        book_id==(5404) ||
                        book_id==(5410) ||
                        book_id==(5420) ||
                        book_id==(5426) ||
                        book_id==(5440) ||
                        book_id==(5442) ||
                        book_id==(5453) ||
                        book_id==(5460) ||
                        book_id==(5468) ||
                        book_id==(5490) ||
                        book_id==(5509) ||
                        book_id==(5515) ||
                        book_id==(5528) ||
                        book_id==(5566) ||
                        book_id==(5605) ||
                        book_id==(5626) ||
                        book_id==(5674) ||
                        book_id==(5686) ||
                        book_id==(5689) ||
                        book_id==(5690) ||
                        book_id==(5694) ||
                        book_id==(5709) ||
                        book_id==(5719) ||
                        book_id==(5724) ||
                        book_id==(5725) ||
                        book_id==(5727) ||
                        book_id==(5981) ||
                        book_id==(5968) ||
                        book_id==(5967) ||
                        book_id==(5959) ||
                        book_id==(5950) ||
                        book_id==(5945) ||
                        book_id==(5935) ||
                        book_id==(5933) ||
                        book_id==(5930) ||
                        book_id==(5925) ||
                        book_id==(5917) ||
                        book_id==(5914) ||
                        book_id==(5908) ||
                        book_id==(5904) ||
                        book_id==(5752) ||
                        book_id==(5762) ||
                        book_id==(5770) ||
                        book_id==(5781) ||
                        book_id==(5782) ||
                        book_id==(5785) ||
                        book_id==(5790) ||
                        book_id==(5790) ||
                        book_id==(5819) ||
                        book_id==(5820) ||
                        book_id==(5823) ||
                        book_id==(5836) ||
                        book_id==(5844) ||
                        book_id==(5851) ||
                        book_id==(5860) ||
                        book_id==(5867) ||
                        book_id==(5879) ||
                        book_id==(5890) ||
                        book_id==(5893) ||
                        book_id==(5894) ||
                        book_id==(5895) ||
                        book_id==(5903)
                        ){
                    count("xa");
                } else {

                    //out.print(books_id+",");

                    JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                    JSONObject dataExport = (JSONObject) jsonObject.get( "page" );

                    JSONObject info = (JSONObject) dataExport.get( "info" );
                    JSONObject data = (JSONObject) dataExport.get( "data" );
                    JSONObject text = (JSONObject) data.get( "text" );
                    String text_content="";
                    int volume = Integer.parseInt(page_id.substring(4,7));
                    int position = Integer.parseInt(page_id.substring(7,10));
                    int position2 = 0;



                    if (text.has("line")) {
                        Object line_text = text.get("line");
                        if (line_text instanceof JSONArray) {
                            JSONArray line2 = (JSONArray) text.get("line");

                            for (int itr=0; itr<line2.length();itr++ ) {
                                JSONObject txt = (JSONObject) line2.get(itr);
                                String oneline="";
                                if (txt.length()>0){
                                    if (!txt.isNull("content")){

                                        oneline = txt.getString("content")
                                                .replace("Ｍ",":")
                                                .replace("Ｅ","")
                                                .replace("Ｌ","")
                                                .replace("╩","")
                                                .replace("@","")
                                                .replace("&","")
                                                .replace("Ｎ","、")
                                                .replace("\r\n","")
                                                .replace("≮","[")
                                                .replace("≯","]")
                                                .replace("D",",")
                                                .replace("J","。")
                                                .replace("F",";")
                                                .replace("┳"," (")
                                                .replace("┻",") ")
                                                .replace("∈","")
                                                .replaceAll("┉┉┉┉","/")
                                                .replaceAll("┉┉┉","/")
                                                .replaceAll("┉┉","/")
                                                .replaceAll("┉","").toString();
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
                                    oneline = txt.getString("content")
                                            .replace("Ｍ",":")
                                            .replace("Ｅ","")
                                            .replace("Ｌ","")
                                            .replace("╩","")
                                            .replace("@","")
                                            .replace("&","")
                                            .replace("Ｎ","、")
                                            .replace("\r\n","")
                                            .replace("≮","[")
                                            .replace("≯","]")
                                            .replace("D",",")
                                            .replace("J","。")
                                            .replace("F",";")
                                            .replace("┳"," (")
                                            .replace("┻",") ")
                                            .replace("∈","")
                                            .replaceAll("┉┉┉┉","/")
                                            .replaceAll("┉┉┉","/")
                                            .replaceAll("┉┉","/")
                                            .replaceAll("┉","").toString();
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
                        content = (String) title.get("content").toString()
                                .replace("Ｍ",":")
                                .replace("Ｅ","")
                                .replace("Ｌ","")
                                .replace("╩","")
                                .replace("@","")
                                .replace("&","")
                                .replace("\r\n","")
                                .replace("Ｎ","、")
                                .replace("≮","[")
                                .replace("≯","]")
                                .replace("D",",")
                                .replace("J","。")
                                .replace("F",";")
                                .replace("┳"," (")
                                .replace("┻",") ")
                                .replace("∈","")
                                .replaceAll("┉","").toString();
                    }

                    out.println("{"
                            + quote + "id" + quote + ":" + quote+ page_id + quote + "," + '\n'
                            + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            + quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                            + quote + "running_title" + quote + ":" + quote+ content + quote + "," + '\n'
                            + quote + "volume" + quote + ":" + quote+ volume + quote + "," + '\n'
                            + quote + "position_vol" + quote + ":" + quote+ position + quote + "," + '\n'
                            //+ quote + "position" + quote + ":" + quote+ position2 + quote + "," + '\n'
                            + quote + "book_id" + quote + ":" + quote+ books_id + quote + "," + '\n'
                            + quote + "text" + quote + ":" +   quote +text_content +  quote + "" + '\n'
                            +"},"
                    );

                    //out.println(
                             //quote + "id" + quote + ":" + quote+ page_id + quote + "," + '\n'
                            //+ quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                            //+ quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                            //+ quote + "running_title" + quote + ":" + quote+ content + quote + "," + '\n'
                            //+ quote + "volume" + quote + ":" + quote+ volume + quote + "," + '\n'
                            //+ quote + "position_vol" + quote + ":" + quote+ position + quote + "," + '\n'
                            //+ quote + "position" + quote + ":" + quote+ position2 + quote + "," + '\n'
                             //quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                            //+ quote + "text" + quote + ":" +   quote +text_content +  quote + "" + '\n'
                            //+""
                    //);

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

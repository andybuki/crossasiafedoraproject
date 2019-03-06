package org.crossasia.collections.ccg;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJsonPage2 {

    public static void main( String[] args ) throws Exception {

        File dir = new File("F:\\a\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_SZFZ.json"));
        String bookName = "";

        String quote = "\u005c\u0022";

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
                String page_id = fileName.replace("F:\\a\\","").replace(".xml","");
                String book_id = page_id.split("-")[0].replace("SZFZ","");
                int volume = Integer.parseInt(page_id.split("-")[1]);
                int page = Integer.parseInt(page_id.split("-")[2]);
                JSONObject jsonObject = XML.toJSONObject(new String( Files.readAllBytes( Paths.get(fileName))));
                JSONObject main_page = (JSONObject) jsonObject.get("page");

                if (main_page.has("text_line")) {
                    Object text_line = main_page.get("text_line");
                    if (text_line instanceof JSONObject) {
                        String content= "";
                        String title ="";
                        JSONObject text_line_new = (JSONObject) text_line;
                        String column_no = (String) text_line_new.get("column_no").toString();
                        if (text_line_new.has("multi_text")){
                            System.out.println("JSONObject multi text");
                        } else {
                            System.out.println("JSONObject no multi text");
                        }
                        /*if (text_line2.has("text")) {
                            Object text = text_line2.get("text");
                            if (text instanceof JSONObject) {
                                JSONObject text2 = (JSONObject) text;
                                if (text2.has("content")) {
                                    if (column_no.equals("1")) {
                                        title =  (String) text2.get("content");
                                    }else {
                                        content = (String) text2.get("content");
                                    }
                                }
                            } else if (text instanceof JSONArray) {
                                JSONArray text2 = (JSONArray) text;
                                System.out.println("test");
                                for (int x =0; x<text2.length(); x++) {
                                    JSONObject full_occupy = (JSONObject) text2.get(x);
                                    if (full_occupy.has("content")){
                                        if (column_no.equals("1")) {
                                            title =  (String) full_occupy.get("content");
                                        }else {
                                            content = (String) full_occupy.get("content");
                                        }
                                    }
                                }
                            }
                            out.println("{"
                                    + quote + "id" + quote + ":" + quote+ page_id + quote + "," + '\n'
                                    + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                                    + quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                                    + quote + "running_title" + quote + ":" + quote+ title + quote + "," + '\n'
                                    + quote + "volume" + quote + ":" + quote+ volume + quote + "," + '\n'
                                    + quote + "position" + quote + ":" + quote+ page + quote + "," + '\n'
                                    + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                    + quote + "text" + quote + ":" +   quote +content +  quote + "" + '\n'
                                    +"},"
                            );

                        } else {
                            System.out.println("no text");
                        }*/

                    } else if (text_line instanceof JSONArray) {
                        JSONArray text_line_new = (JSONArray) text_line;
                        String text= "";
                        String title ="";

                        for (int i = 0; i<text_line_new.length(); i++) {
                            JSONObject text_line_new_object = (JSONObject) text_line_new.get(i);
                            if (text_line_new_object.has("multi_text")) {
                                System.out.println(text_line_new_object.get("text"));
                                JSONObject multi_text = (JSONObject)  text_line_new_object.get("multi_text");
                                JSONArray only_text = (JSONArray)  text_line_new_object.get("text");
                                if (multi_text.has("text")){
                                    JSONArray multi_text_array = (JSONArray)  multi_text.get("text");
                                    for (int k =0; k<multi_text_array.length(); k++) {
                                        JSONObject multi_text_object = (JSONObject) multi_text_array.get(k);
                                        String column_no = (String) multi_text_object.get("column_no").toString();
                                        if (column_no.equals("1")){
                                            title = (String) multi_text_object.get("content");
                                        }
                                    }
                                }
                                for (int s=0; s<only_text.length(); s++){
                                    JSONObject only_text_obj = (JSONObject) only_text.get(s);
//                                    String column_no = (String) only_text_obj.get("column_no").toString();
                                    if (only_text_obj.has("content")){
                                        String oneline2="";
                                        oneline2 = (String) only_text_obj.get("content").toString();
                                        title +=oneline2;
                                    }

                                }
                                System.out.println(title);



                                /*for (int k =0; k<multi_text_array.length(); k++) {

                                    JSONObject multi_text_object = (JSONObject) multi_text_array.get(k);
                                    String column_no = (String) multi_text_object.get("column_no").toString();
                                    if (column_no.equals("1")){
                                        title = (String) multi_text_object.get("content");
                                    }

                                }*/


                                /*String column_no = (String) text_line_new_object.get("column_no").toString();
                                if (text_line_new_object.has("text")){
                                    Object text_object =  text_line_new_object.get("text");
                                    if (text_object instanceof JSONObject){
                                        JSONObject text_object_new = (JSONObject) text_object;
                                        if (text_object_new.has("content")) {
                                            if (column_no.equals("1")) {
                                                String oneline2="";
                                                oneline2 = (String) text_object_new.get("content").toString();
                                                title += oneline2;
                                            }else {
                                                String oneline="";
                                                oneline = (String) text_object_new.get("content").toString();
                                                text += " "+ oneline;
                                            }
                                        }

                                    } else if (text_object instanceof  JSONArray){
                                        JSONArray text_object_new = (JSONArray) text_object;

                                        String title_line="";
                                        String title_lineWithoutSpaces="";
                                        String colon="";
                                        for (int j = 0; j<text_object_new.length(); j++) {
                                            JSONObject con = (JSONObject) text_object_new.get(j);

                                            if (con.has("content")) {
                                                if (column_no.equals("1")) {
                                                    title_line = (String) con.get("content").toString();
                                                    title_lineWithoutSpaces = title_line.replaceAll("　","");
                                                }
                                            }

                                            if (con.has("full_occupy")){
                                                title_lineWithoutSpaces = (String) con.get("full_occupy").toString().replace("\uE002"," : ");
                                            }
                                            title += title_lineWithoutSpaces;

                                            /*if (con.has("content")) {
                                                if (column_no.equals("1")) {
                                                    title_line = (String) con.get("content").toString();
                                                    String title_lineWithoutSpaces = title_line.replaceAll("　","");
                                                    title += title_lineWithoutSpaces;
                                                }else {
                                                    String oneline="";
                                                    oneline = (String) con.get("content").toString();
                                                    text += " "+ oneline;
                                                }
                                            }
                                            //System.out.println(title+colon);

                                        }
                                        System.out.println("Json Array multi_text");
                                    }
                                } else {
                                    System.out.println("Json Array no text");
                                }*/
                            } else if (text_line_new_object.has("text")) {
                                String column_no = (String) text_line_new_object.get("column_no").toString();
                                System.out.println("T"+column_no);
                                Object text_line_object =  text_line_new_object.get("text");
                                if (text_line_object instanceof JSONObject) {
                                    JSONObject text4 = (JSONObject) text_line_object;
                                    if (text4.has("content")) {
                                        if (column_no.equals("1")) {
                                            String oneline2="";
                                            oneline2 =  (String) text4.get("content").toString();
                                            title +=  oneline2;
                                        }else {
                                            String oneline="";
                                            oneline = (String) text4.get("content").toString();
                                            text += " "+ oneline;
                                        }
                                    }
                                } else if ( text_line_object instanceof JSONArray) {
                                    JSONArray text4 = (JSONArray) text_line_object;
                                    for (int y=0; y<text4.length(); y++) {
                                        JSONObject image_position = (JSONObject) text4.get(y);
                                        if (image_position.has("content")){
                                            if (column_no.equals("1")) {
                                                String oneline2="";
                                                oneline2 =  (String) image_position.get("content").toString();
                                                title +=  oneline2;
                                            }else {
                                                String oneline="";
                                                oneline = (String) image_position.get("content").toString();
                                                text += " "+ oneline;
                                            }
                                        }
                                    }
                                    System.out.println(page_id);
                                }

                            }

                            /*else if (text2.has("text")) {


                                if (text3 instanceof JSONObject) {
                                    JSONObject text4 = (JSONObject) text3;
                                    if (text4.has("content")) {
                                        if (column_no.equals("1")) {
                                            String oneline2="";
                                            oneline2 =  (String) text4.get("content").toString();
                                            title +=  oneline2;
                                        }else {
                                            String oneline="";
                                            oneline = (String) text4.get("content").toString();
                                            text += " "+ oneline;
                                        }
                                    }
                                } else if ( text3 instanceof JSONArray) {
                                    JSONArray text4 = (JSONArray) text3;
                                    for (int y=0; y<text4.length(); y++) {
                                        JSONObject image_position = (JSONObject) text4.get(y);
                                        if (image_position.has("content")){
                                            if (column_no.equals("1")) {
                                                String oneline2="";
                                                oneline2 =  (String) image_position.get("content").toString();
                                                title +=  oneline2;
                                            }else {
                                                String oneline="";
                                                oneline = (String) image_position.get("content").toString();
                                                text += " "+ oneline;
                                            }
                                        }
                                    }
                                    System.out.println(page_id);
                                }
                            }*/
                        }
                        out.println("{"
                                + quote + "id" + quote + ":" + quote+ page_id + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                                + quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                                + quote + "running_title" + quote + ":" + quote+ title + quote + "," + '\n'
                                + quote + "volume" + quote + ":" + quote+ volume + quote + "," + '\n'
                                + quote + "position" + quote + ":" + quote+ page + quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                + quote + "text" + quote + ":" +   quote +text +  quote + "" + '\n'
                                +"},"
                        );
                    }
                } else {
                    System.out.println(page_id);
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

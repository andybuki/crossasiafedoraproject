package org.crossasia.collections.ccg;


import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConvertXmlToJsonPage3 {

    public static void main( String[] args ) throws Exception {
        String encoding = "UTF-8";
        File dir = new File("F:\\SZFZ_OLD\\");
        //PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_SZFZ.json"));
        PrintStream out = new PrintStream("D:\\SOLR-COLLECTIONS\\CCG\\pages_FINAL.json",encoding);
        String bookName = "";

        String quote = "\u005c\u0022";

        for (File file : dir.listFiles()) {

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

                String page_id = fileName.replace("F:\\SZFZ_OLD\\", "").replace(".xml", "");
                String book_id = page_id.split("-")[0].replace("SZFZ", "");
                String image_text ="";
                String chapter_title ="";
                int volume = Integer.parseInt(page_id.split("-")[1]);
                int page = Integer.parseInt(page_id.split("-")[2]);
                Map<String,String> myLinkedHashMap = new LinkedHashMap<String, String>();
                Gson gson = new Gson();
                String json = gson.toJson(myLinkedHashMap, LinkedHashMap.class);

                JSONObject jsonObject = XML.toJSONObject(new String(Files.readAllBytes(Paths.get(fileName))));
                JSONObject main_page = (JSONObject) jsonObject.get("page");

                if (main_page.has("image")){
                    Object image =  main_page.get("image");
                    //JSONObject image = (JSONObject) main_page.get("image");
                    if (image instanceof JSONArray){
                        JSONArray image_arr = (JSONArray) image;
                        for (int ii=0; ii<image_arr.length();ii++){
                            image_text="Page contains " +image_arr.length()+ " images";
                        }
                    } else {
                        JSONObject image_obj = (JSONObject) image;
                        if (image_obj.has("base64_data")) {
                            image_text="Page contains 1 image";
                        }
                    }


                }
                if (main_page.has("text_line")) {
                    Object text_line = main_page.get("text_line");
                    if (text_line instanceof JSONObject) {
                        String text= "";
                        String title ="";
                        System.out.println("text_line Object");
                        JSONObject text_line_object = (JSONObject) text_line;
                        if (text_line_object.has("column_no")){
                            String column_no = (String) text_line_object.get("column_no").toString();
                            if (column_no.equals("1")){
                                System.out.println("ERROR");
                            }

                            if (text_line_object.has("text")){
                                Object text_obj = text_line_object.get("text");
                                if (text_obj instanceof JSONArray) {
                                    JSONArray text_obj_array = (JSONArray) text_obj;
                                }
                                else if (text_obj instanceof JSONObject) {
                                    JSONObject text_obj_obj = (JSONObject) text_obj;
                                    if (text_obj_obj.has("content")){
                                        title = (String) text_obj_obj.get("content");
                                    }

                                }
                                else {

                                    String text_obj_object = (String) text_obj;
                                    title = (String) text_obj_object;
                                    System.out.println("test");
                                    /*if (text_obj_object.has("content")){
                                        text = (String) text_obj_object.get("content");
                                    }*/
                                }

                            }
                        }

                        /*
                        *
                        *
                        * TO DO
                        *
                        *
                        * */

                        out.println("{"
                                + quote + "id" + quote + ":" + quote+ page_id + quote + "," + '\n'
                                + quote + "hasModel" + quote + ":" +   quote +"Page" +  quote + "," + '\n'
                                + quote + "collection" + quote + ":" +   quote +"China Comprehensive Gazetteers : 中國綜合方誌庫" +  quote + "," + '\n'
                                + quote + "running_title" + quote + ":" + quote+ title + quote + "," + '\n'
                                + quote + "volume" + quote + ":" + quote+ volume + quote + "," + '\n'
                                + quote + "position" + quote + ":" + quote+ page + quote + "," + '\n'
                                + quote + "position_vol" + quote + ":" + quote+ page + quote + "," + '\n'
                                + quote + "image_info" + quote + ":" + quote+ image_text + quote + "," + '\n'
                                + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                + quote + "text" + quote + ":" +   quote +text +  quote + "" + '\n'
                                +"},"
                        );
                    } else {
                        String text= "";
                        String title ="";
                        String title2 ="";
                        System.out.println("text_line Array");
                        JSONArray text_line_array = (JSONArray) text_line;

                        for (int i=0; i<text_line_array.length(); i++){
                            JSONObject text_line_obj = (JSONObject) text_line_array.get(i);
                            if (text_line_obj.has("column_no")){
                                String column_no = (String) text_line_obj.get("column_no").toString();
                                if (column_no.equals("1")){
                                    if (text_line_obj.has("text")){
                                        Object text_obj = text_line_obj.get("text");
                                        if (text_obj instanceof JSONArray) {
                                            JSONArray text_obj_array = (JSONArray) text_obj;
                                            for (int j=0; j<text_obj_array.length(); j++) {
                                                if (text_obj_array.get(j) instanceof JSONObject) {
                                                    JSONObject text_object = (JSONObject) text_obj_array.get(j);
                                                    String colon="";
                                                    if (text_object.has("content")){
                                                        String txt ="";

                                                        if (text_object.has("column_no")){
                                                            txt =  (String) text_object.get("content").toString().replaceAll("　","");
                                                            String line_txt = "("+txt+")";
                                                            title +=  line_txt;

                                                        }else {
                                                            txt =  (String) text_object.get("content").toString().replaceAll("　","");
                                                            title +=  txt;
                                                        }

                                                    }
                                                    if (text_object.has("full_occupy")){
                                                        colon = (String) text_object.get("full_occupy").toString().replace("\uE002"," : ");
                                                    }

                                                    title += colon;
                                                }else {
                                                    String text_object = (String) text_obj_array.get(j);
                                                    title +=text_object;
                                                }




                                            }
                                        }
                                        else {
                                            if (text_obj instanceof JSONObject) {
                                                JSONObject text_obj_object = (JSONObject) text_obj;
                                                if (text_obj_object.has("content")){
                                                    title = (String) text_obj_object.get("content");
                                                }
                                            } else {
                                                String text_obj_object = (String) text_obj;
                                                title =  text_obj_object;
                                            }

                                        }
                                    }
                                    if (text_line_obj.has("multi_text")){
                                        Object multi_text_obj = text_line_obj.get("multi_text");
                                        if (multi_text_obj instanceof JSONObject){
                                            JSONObject multitext = (JSONObject) multi_text_obj;
                                            if (multitext.has("text")){
                                                Object multi_text_ob = multitext;
                                                if (multi_text_ob instanceof JSONArray) {
                                                    JSONArray multitextarray = (JSONArray) multi_text_ob;
                                                    String colon="";
                                                    for (int x=0; x< multitextarray.length(); x++){
                                                        JSONObject mult_text = (JSONObject) multitextarray.get(x);
                                                        if (mult_text.has("content")){
                                                            String txt ="";
                                                            txt =  (String) mult_text.get("content").toString().replaceAll("　","")+"/";
                                                            title +=  txt;
                                                        }
                                                        if (mult_text.has("full_occupy")){
                                                            colon = (String) mult_text.get("full_occupy").toString().replace("\uE002"," : ");
                                                        }

                                                        title += colon;
                                                    }
                                                } else {
                                                    JSONObject multitextobj = (JSONObject) multi_text_ob;
                                                    if (multitextobj.has("text")){
                                                        Object multi_text_ob2 = multitextobj;
                                                        if (multi_text_ob2 instanceof JSONArray) {
                                                            JSONArray multitextarray = (JSONArray) multi_text_ob;
                                                            for (int x=0; x< multitextarray.length(); x++){
                                                                if (multitextarray.length()<=1){
                                                                    JSONObject mult_text = (JSONObject) multitextarray.get(x);
                                                                    if (mult_text.has("content")){
                                                                        String txt ="";
                                                                        txt =  (String) mult_text.get("content").toString().replaceAll("　","");
                                                                        title +=  " ("+txt+") ";
                                                                    }
                                                                }else {
                                                                    JSONObject mult_text = (JSONObject) multitextarray.get(x);
                                                                    if (mult_text.has("content")){
                                                                        String txt ="";
                                                                        txt =  (String) mult_text.get("content").toString().replaceAll("　","")+"/";
                                                                        title2 +=  txt;
                                                                        title = title+" ("+title2+") ";
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            JSONObject multitextobj2 = (JSONObject) multi_text_ob;
                                                            if (multitextobj2.has("text")){
                                                                JSONArray multitextarray2 = (JSONArray) multitextobj2.get("text");
                                                                String txt ="";
                                                                for (int x=0; x< multitextarray2.length(); x++){
                                                                    if (multitextarray2.length()<=1){
                                                                        JSONObject mult_text = (JSONObject) multitextarray2.get(x);
                                                                        if (mult_text.has("content")){
                                                                            txt =  (String) mult_text.get("content").toString().replaceAll("　","");
                                                                            title += " ("+txt+") ";
                                                                        }
                                                                    } else {
                                                                        JSONObject mult_text = (JSONObject) multitextarray2.get(x);
                                                                        if (mult_text.has("content")){
                                                                            txt =  (String) mult_text.get("content").toString().replaceAll("","")+"/";
                                                                            title2 +=  txt;
                                                                        }
                                                                    }
                                                                }
                                                                title = title+" ("+title2+") ";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            //TO DO
                                        }
                                    }
                                } else {
                                    //TO DO
                                    if (text_line_obj.has("text")){
                                        Object text_obj = text_line_obj.get("text");
                                        if (text_obj instanceof JSONArray) {
                                            JSONArray text_obj_array = (JSONArray) text_obj;
                                            for (int j=0; j<text_obj_array.length(); j++) {
                                                if (text_obj_array.get(j)instanceof JSONObject) {
                                                    JSONObject text_object = (JSONObject) text_obj_array.get(j);
                                                    if (text_object.has("content")){
                                                        String txt ="";
                                                        if (text_object.has("column_no")){
                                                            txt =  (String) text_object.get("content").toString().replaceAll("　","");
                                                            String line_txt = "("+txt+")";
                                                            text +=  line_txt;
                                                        }else {
                                                            txt =  (String) text_object.get("content").toString().replaceAll("　","");
                                                            text +=  txt;
                                                        }

                                                        //text +=  txt;
                                                    }
                                                } else {
                                                    String text_object = (String) text_obj_array.get(j).toString();
                                                    text +=text_object;
                                                }

                                            }
                                        }
                                        else{
                                            System.out.println("test2");
                                            if (text_obj instanceof JSONObject) {
                                                JSONObject text_obj_object = (JSONObject) text_obj;
                                                if (text_obj_object.has("content")){
                                                    String txt ="";
                                                    txt = (String) text_obj_object.get("content").toString();
                                                    text +=  txt;
                                                }
                                            }else {
                                                String text_obj_object = (String) text_obj.toString();
                                                text +=text_obj_object;
                                            }


                                        }
                                    }

                                    if (text_line_obj.has("multi_text")){
                                        Object multi_text_obj = text_line_obj.get("multi_text");
                                        if (multi_text_obj instanceof JSONObject){
                                            JSONObject multitext = (JSONObject) multi_text_obj;
                                            if (multitext.has("text")){
                                                Object multi_text_ob = multitext;
                                                if (multi_text_ob instanceof JSONArray) {
                                                    JSONArray multitextarray = (JSONArray) multi_text_ob;
                                                    for (int x=0; x< multitextarray.length(); x++){
                                                        JSONObject mult_text = (JSONObject) multitextarray.get(x);
                                                        if (mult_text.has("content")){
                                                            String txt ="";
                                                            txt =  (String) mult_text.get("content").toString();//.replaceAll("　","")+"/";
                                                            text +=  txt;
                                                        }
                                                    }
                                                } else {
                                                    JSONObject multitextobj = (JSONObject) multi_text_ob;
                                                    if (multitextobj.has("text")){
                                                        Object multi_text_ob2 = multitextobj;
                                                        if (multi_text_ob2 instanceof JSONArray) {
                                                            JSONArray multitextarray = (JSONArray) multi_text_ob;
                                                            for (int x=0; x< multitextarray.length(); x++){
                                                                if (multitextarray.length()<=1){
                                                                    JSONObject mult_text = (JSONObject) multitextarray.get(x);
                                                                    if (mult_text.has("content")){
                                                                        String txt ="";
                                                                        txt =  (String) mult_text.get("content").toString();//.replaceAll("　","");
                                                                        text +=  " ("+txt+") ";
                                                                    }
                                                                }else {
                                                                    JSONObject mult_text = (JSONObject) multitextarray.get(x);
                                                                    if (mult_text.has("content")){
                                                                        String txt ="";
                                                                        txt =  (String) mult_text.get("content").toString();//.replaceAll("　","")+"/";
                                                                        text +=  txt;
                                                                        //title = title+" ("+title2+") ";
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            JSONObject multitextobj2 = (JSONObject) multi_text_ob;
                                                            if (multitextobj2.has("text")) {
                                                                if (multitextobj2.get("text") instanceof JSONArray) {
                                                                    JSONArray multitextarray2 = (JSONArray) multitextobj2.get("text");
                                                                    String txt = "";
                                                                    for (int x = 0; x < multitextarray2.length(); x++) {
                                                                        if (multitextarray2.length() <= 1) {
                                                                            JSONObject mult_text = (JSONObject) multitextarray2.get(x);
                                                                            if (mult_text.has("content")) {
                                                                                txt = (String) mult_text.get("content").toString();//.replaceAll("　","");
                                                                                text += " (" + txt + ") ";
                                                                            }
                                                                        } else {
                                                                            JSONObject mult_text = (JSONObject) multitextarray2.get(x);
                                                                            if (mult_text.has("content")) {
                                                                                txt = (String) mult_text.get("content").toString().replaceAll("", "") + "/";
                                                                                text += txt;
                                                                            }
                                                                        }
                                                                    }
                                                            }
                                                                //text = title+" ("+title2+") ";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            //TO DO
                                        }
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
                                + quote + "position_vol" + quote + ":" + quote+ page + quote + "," + '\n'
                                + quote + "image_info" + quote + ":" + quote+ image_text + quote + "," + '\n'
                                + quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "," + '\n'
                                + quote + "book_id" + quote + ":" + quote+ book_id + quote + "," + '\n'
                                + quote + "text" + quote + ":" +   quote +text +  quote + "" + '\n'
                                +"},"
                        );

                    }
                }
            }finally {
                br.close();
            }
        }
    }

    private static void count(String x) {
        System.out.println(x);
    }

}

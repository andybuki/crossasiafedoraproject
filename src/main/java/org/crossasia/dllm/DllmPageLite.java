package org.crossasia.dllm;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class DllmPageLite {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException {
        File absolutePath = new File("/data1/dllm/manifest/page_splitted/");
        String quote = "\u005c\u0022";
        String encoding = "UTF-8";

            File dir = new File(String.valueOf(absolutePath));
            File[] filesInDir = dir.listFiles();

            for (File file : filesInDir) {
                StringBuilder sb = new StringBuilder();
                JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

                String id = "";
                JSONArray page =null;


                if (jsonObj.has("id")) {
                    id = (String) jsonObj.get("id").toString();
                }
                if (jsonObj.has("pages"))
                    page = (JSONArray) jsonObj.get("pages");




                if (id!= "")
                    sb.append(quote + "id" + quote + ":" +quote+ id  + quote+"," + '\n');


                if (page != null)
                    sb.append(quote + "page" + quote + ":" + page + "" + '\n');


                /*i //sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

            /*if (position != "")
                sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');


            if (book_id != "")
                sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

            if (text != "") {
                sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');
            }

            if (value != "") {
                sb.append(quote + "schema:value" + quote + ":" + quote + value + quote + "," + '\n');
            }

            if (note != "") {
                sb.append(quote + "mods:note" + quote + ":" + quote + note.replace("type=\"statement of responsibility\" ","") + quote + "," + '\n');
            }


            if (extent != "") {
                sb.append(quote + "dcterms:extent" + quote + ":" + quote + extent + quote + "," + '\n');
            }*/

            /*if (isPartOf != "")
                sb.append(quote + "schema:isPartOf" + quote + ":" + quote + isPartOf + quote + "," + '\n');

            if (image != "")
                sb.append(quote + "schema:image" + quote + ":" + quote + image + quote + "," + '\n');*/

            /*if (url != "")
                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

            if (edition != "")
                sb.append(quote + "dc:edition" + quote + ":" + quote +edition + quote +"," + '\n');*/

            /*if (chapter != null)
                sb.append(quote + "dcndl:seriesTitle" + quote + ":" + chapter + "," + '\n');

            if (seriesTitle != "")
                sb.append(quote + "dcndl:seriesTitle" + quote + ":" + quote+ seriesTitle + quote+ "," + '\n');

            if (responsibility != null)
                sb.append(quote + "mods:responsibility" + quote + ":" +  quote +responsibility + quote +"," + '\n');

            if (author != null)
                sb.append(quote + "dc:creator" + quote + ":" + author + "," + '\n');

            if (description != null)
                sb.append(quote + "dc:description" + quote + ":" + description +"," + '\n');

            if (publisher != null)
                sb.append(quote + "dc:publisher" + quote + ":" + quote +publisher + quote + "," + '\n');*/

            /*if (titleTranscription != null)
                sb.append(quote + "dcndl:titleTranscription" + quote + ":" + titleTranscription + "," + '\n');

            if (citation != null)
                sb.append(quote + "schema:citation" + quote + ":" + citation + "," + '\n');

            if (spatial != "")
                sb.append(quote + "dcterms:spatial" + quote + ":" + quote+spatial +quote + "," + '\n');

            if (medium != null)
                sb.append(quote + "dcterms:medium" + quote + ":" + medium + "," + '\n');

            if (lizenz != "")
                sb.append(quote + "CrossAsia_Lizenz" + quote + ":" + quote + lizenz.replace("type=\"CrossAsia Lizenz\" ","") + quote + "," + '\n');*/


                sb.append("}");
                sb.append("]}");

                sb.deleteCharAt(sb.length() - 1);
                //PrintStream out = new PrintStream(new FileOutputStream(file));
                //out.write("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
                PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/manifest/pages/"+id+"_page.json"));
                //out = new FileWriter("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
                out.println("["+sb.toString()+"}]");
                Thread.sleep(1);

            }

        }
    }


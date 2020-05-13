package org.crossasia.dllm;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class DllmFedoraPage {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException {
        File absolutePath = new File("/data1/dllm/pages_split/");
        String quote = "\u005c\u0022";
        String encoding = "UTF-8";

            File dir = new File(String.valueOf(absolutePath));
            File[] filesInDir = dir.listFiles();

            for (File file : filesInDir) {
                StringBuilder sb = new StringBuilder();
                JSONObject jsonObj = new JSONObject(new JSONTokener(new FileInputStream(file)));

                String id = "";
                String document_id ="";
                String image_file = "";
                int position =0;

                if (jsonObj.has("id")) {
                    id = (String) jsonObj.get("id").toString();
                }
                if (jsonObj.has("document_id"))
                    document_id = (String) jsonObj.get("document_id").toString();

                if (jsonObj.has("image_file"))
                    image_file = (String) jsonObj.get("image_file").toString();

                if (jsonObj.has("position"))
                    position = (int) jsonObj.get("position");


                sb.append("{\n");
                sb.append("  \"@context\": {\n");
                sb.append("    \"fedora\": \"https://fedora.info/definitions/v4/2016/10/18/repository#\",\n");
                sb.append("    \"crossasia\": \"http://crossasia.org/schema/v1#\",\n");
                sb.append("    \"pcdm\": \"http://pcdm.org/models#\",\n");
                sb.append("    \"mods\": \"http://www.loc.gov/mods/modsrdf/v1#\",\n");
                sb.append("    \"book_id\": \"http://schema.org/identifier\",\n");
                sb.append("    \"dcndl\": \"http://ndl.go.jp/dcndl/\",\n");

                sb.append("    \"dc\": \"http://purl.org/dc/elements/1.1/\",\n");
                sb.append("    \"seriesTitle\": \"http://ndl.go.jp/dcndl/terms/seriesTitle\",\n");
                sb.append("    \"schema\": \"http://schema.org/\",\n");
                sb.append("    \"person\": \"http://schema.org/Person\",\t\n");
                sb.append("    \"dcterms\": \"http://purl.org/dc/terms/\",\n");

                sb.append("    \"dllm\": \"http://dllm.org/schema/v1#\",\n");

                sb.append("    \"CHGIS\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#CHGIS\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"TGAZ API\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#TGAZ_API\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");


                sb.append("    \"CrossAsia_Lizenz\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#CrossAsia_Lizenz\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"uri\": {\n");
                sb.append("      \"@id\": \"http://purl.org/dc/terms/uri\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"url\": {\n");
                sb.append("      \"@id\": \"http://schema.org/url\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("    },\n");

                sb.append("    \"solr\": {\n");
                sb.append("      \"@id\": \"http://crossasia.org/schema/v1#solr\",\n");
                sb.append("      \"@type\": \"@id\"\n");
                sb.append("   }\n\t");
                sb.append(" },\n\n");
                sb.append("\"@id\": \"urn:x-arq:DefaultGraphNode\",\n");

                sb.append("\"@graph\": [" + '\n');

                sb.append("{" + '\n');

                sb.append("\"@type\": \"pcdm:Object\",\n");
                sb.append("\"@id\": \"\",\n");


                if (id!= "")
                    sb.append(quote + "id" + quote + ":" +quote+ "dllm_"+ document_id+"_"+id  + quote+"," + '\n');

                if (document_id!= "")
                    sb.append(quote + "schema:identifier" + quote + ":" + quote+ document_id +quote + "," + '\n');

                if (image_file!= "")
                    sb.append(quote + "schema:image" + quote + ":" + quote+ image_file +quote + "," + '\n');

                if (position != 0)
                    sb.append(quote + "schema:position" + quote + ":" + position + "," + '\n');


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
                sb.append(quote + "dc:source" + quote + ":" + quote + "Digital Library of Lao Manuscripts" + quote + "," + '\n');
                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Page" + quote + "" + '\n');

                sb.append("}");
                sb.append("]}");

                sb.deleteCharAt(sb.length() - 1);
                //PrintStream out = new PrintStream(new FileOutputStream(file));
                //out.write("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
                PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/fedora_pages/"+id+".json"));
                //out = new FileWriter("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
                out.println("["+sb.toString()+"}]");
                Thread.sleep(1);

            }

        }
    }


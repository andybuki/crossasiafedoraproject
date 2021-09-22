package org.crossasia.fedora.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class MinguoFedoraBook {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException , IOException {
        File absolutePath = new File("/data1/fedora/ajax-minguo/p/pages3/");
        String quote = "\u005c\u0022";
        String encoding = "UTF-8";

        File dir = new File(String.valueOf(absolutePath));
        File[] filesInDir = dir.listFiles();

        for (File file : filesInDir) {
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObject = new JSONObject(new JSONTokener(new FileInputStream(file)));
            //JSONObject jsonObject = new JSONObject(file);
            String id = "";
            String book_id = "";
            JSONArray identifier = null;
            String title = "";
            String seriesTitle = "";
            String responsibility = "";
            JSONArray author = null;
            String publication_place = "";
            String publisher = "";
            String date = "";
            String edition = "";
            String extent ="";
            JSONArray subject = null;
            JSONArray chapter = null;
            String url = "";
            String text = "";
            String position ="";
            //JSONArray language = null;
            JSONArray description = null;

            if (jsonObject.has("id")) {
                id = (String) jsonObject.get("id").toString();
            }

            if (jsonObject.has("book_id")) {
                book_id = (String) jsonObject.get("book_id").toString();
            }

            if (jsonObject.has("identifier")) {
                identifier = (JSONArray) jsonObject.get("identifier");
            }

            if (jsonObject.has("description")) {
                description = (JSONArray) jsonObject.get("description");
            }

            if (jsonObject.has("chapter_title")) {
                chapter = (JSONArray) jsonObject.get("chapter_title");
            }

            if (jsonObject.has("title")) {
                title = (String) jsonObject.get("title").toString();
            }


            if (jsonObject.has("series_title")) {
                seriesTitle = (String) jsonObject.get("series_title");
            }

            if (jsonObject.has("responsibility")) {
                responsibility = (String) jsonObject.get("responsibility");
            }

            if (jsonObject.has("position")) {
                position = (String) jsonObject.get("position");
            }

            if (jsonObject.has("text")) {
                text = (String) jsonObject.get("text").toString().replace("\u001F","").replace("\t"," ");
            }

            if (jsonObject.has("author")) {
                try {
                    author = (JSONArray) jsonObject.get("author");
                } catch (ClassCastException e) {
                    System.out.println("JSON Problem " );
                }

            }

            if (jsonObject.has("publication_place")) {
                publication_place = (String) jsonObject.get("publication_place").toString();
            }

            if (jsonObject.has("publisher")) {
                publisher = (String) jsonObject.get("publisher");
            }

            if (jsonObject.has("date")) {
                date = (String) jsonObject.get("date").toString();
            }

            if (jsonObject.has("edition")) {
                try {
                    edition = (String) jsonObject.get("edition");
                } catch (ClassCastException e) {
                    System.out.println("JSON Problem3 ");
                }
            }

            if (jsonObject.has("extent")) {
                extent = (String) jsonObject.get("extent").toString();
            }

            if (jsonObject.has("subject")) {
                subject = (JSONArray) jsonObject.get("subject");
            }

            if (jsonObject.has("url")) {
                url = (String) jsonObject.get("url").toString();
            }

            if (jsonObject.has("language")) {
                //language = (JSONArray) jsonObject.get("language");
            }


            String solr = "http://solr-master-prod:8995/solr/ajax-minguo/select?q=id:" + id;

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


            if (identifier != null)
                sb.append(quote + "dc:identifier" + quote + ":" +  identifier  + "," + '\n');


            /*if (language != null)
                sb.append(quote + "dc:language" + quote + ":" +  language  + "," + '\n');*/

            if (title != "")
                sb.append(quote + "dc:title" + quote + ":" + quote + title + quote + "," + '\n');

            /*if (date != "")
                sb.append(quote + "dc:date" + quote + ":" + quote + date + quote + "," + '\n');*/

            sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

            if (position != "")
                sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');


            if (book_id != "")
                sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

            if (text != "") {
                sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');
            }

            /*if (value != "") {
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

            if (url != "")
                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

            /*if (edition != "")
                sb.append(quote + "dc:edition" + quote + ":" + quote +edition + quote +"," + '\n');*/

            if (chapter != null)
                sb.append(quote + "dcndl:seriesTitle" + quote + ":" + chapter + "," + '\n');

            /*if (seriesTitle != "")
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

            sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Page" + quote + "" + '\n');

            sb.append("}");
            sb.append("]}");

            sb.deleteCharAt(sb.length() - 1);
            //PrintStream out = new PrintStream(new FileOutputStream(file));
            //out.write("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
            PrintStream out = new PrintStream(new FileOutputStream("/data1/dllm/ajax-minguo/p/pages_json3/"+id+".json"));
            //out = new FileWriter("/data1/fedora/ajax-minguo/test2/"+book_id+".json");
            out.println("["+sb.toString()+"}]");

            //out = new PrintStream (new FileOutputStream("/data1/fedora/ajax-minguo/books3/"+book_id+".json"));

            //BufferedWriter out2 = out.("/data1/fedora/ajax-minguo/test2/"+book_id+".json"));
        }



        /*String books = "/data1/fedora/ajax-minguo/books_language_solr.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/fedora/ajax-minguo/books_language_solr2.json"));

        JSONArray bookArray = new JSONArray(new JSONTokener(new FileInputStream(books)));*/




        }
    }


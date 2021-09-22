package org.crossasia.fedora.dfz;

import com.google.gson.JsonParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class DfzFedoraBook {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File dir = new File("/data1/fedora/ajax-dfz/pages/");
        String quote = "\u005c\u0022";

        for (File file : dir.listFiles()) {
            String verify, putData;
            String encoding = "UTF-8";

            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));

            //timer(10);
            StringBuilder sb = new StringBuilder();
            //while (!file.exists()) {
            JSONParser parser = new JSONParser();
            try {

                //Object articles = parser.parse(new FileReader(file));
                //Object articles = (new FileReader(file));
                //if (articles instanceof JSONObject) {
                JSONObject art = new JSONObject(new JSONTokener(new FileInputStream(file)));
                //JSONObject art = (JSONObject) parser.parse(new FileReader(file));
                JSONObject context = (JSONObject) art.get(("@context"));
                String _id = (String) art.get(("@id"));

                JSONArray graph = (JSONArray) art.get("@graph");

                String id = "";
                String book_id = "";
                String description = "";
                String hasModel = "";
                String language = "";
                String type = "";
                String thumbnail = "";
                //String creator = "";
                String date = "";
                String title = "";
                String issued = "";
                String position = "";
                String format = "";
                String text = "";
                JSONArray edition = null;
                JSONArray creator = null;
                JSONArray temporal = null;
                JSONArray spatial = null;
                JSONArray identifier = null;
                JSONArray citation = null;
                JSONArray responsibility = null;

                JSONArray seriesTitle = null;
                JSONArray titleTranscription = null;

                String isPartOf = "";

                JSONArray medium = null;

                JSONObject booksObj = (JSONObject) graph.get(0);
                id = (String) booksObj.get("id").toString();

                //description = (String) booksObj.get("dc:description").toString();
                if (booksObj.has("fedora:hasModel")) {
                    hasModel = (String) booksObj.get("fedora:hasModel").toString();
                } else {
                    hasModel = (String) booksObj.get("crossasia:hasModel").toString();
                }
                if (booksObj.has("dc:language")) {
                    language = (String) booksObj.get("dc:language").toString();
                }

                if (booksObj.has("dc:date")) {
                    date = (String) booksObj.get("dc:date").toString();
                }

                if (booksObj.has("mods:title_responsibility")) {
                    responsibility = (JSONArray) booksObj.get("mods:title_responsibility");
                }

                if (booksObj.has("book_id")) {
                    book_id = (String) booksObj.get("book_id").toString();
                }

                if (booksObj.has("dc:title")) {
                    title = (String) booksObj.get("dc:title").toString();
                }

                if (booksObj.has("dcterms:issued")) {
                    issued = (String) booksObj.get("dcterms:issued").toString();
                }

                if (booksObj.has("schema:fileFormat")) {
                    format = (String) booksObj.get("schema:fileFormat").toString();
                }

                if (booksObj.has("schema:position")) {
                    position = (String) booksObj.get("schema:position").toString();
                }

                if (booksObj.has("schema:text")) {

                    text = (String) booksObj.get("schema:text").toString().replaceAll("\"","");
                }

                if (booksObj.has("schema:thumbnail")) {
                    thumbnail = (String) booksObj.get("schema:thumbnail").toString();
                }

                if (booksObj.has("schema:isPartOf")) {
                    isPartOf = (String) booksObj.get("schema:isPartOf").toString();
                }

                if (booksObj.has("dcterms:medium")) {
                    medium = (JSONArray) booksObj.get("dcterms:medium");
                }

                if (booksObj.has("dcndl:seriesTitle")) {
                    seriesTitle = (JSONArray) booksObj.get("dcndl:seriesTitle");
                }

                if (booksObj.has("dcndl:titleTranscription")) {
                    titleTranscription = (JSONArray) booksObj.get("dcndl:titleTranscription");
                }

                if (booksObj.has("dc:edition")) {
                    try {
                    edition = (JSONArray) booksObj.get("dc:edition");
                    }catch (ClassCastException e) {
                        System.out.println("JSON Problem3 "+file.getName());
                    }
                }

                if (booksObj.has("dcterms:spatial")) {
                    spatial = (JSONArray) booksObj.get("dcterms:spatial");
                }

                if (booksObj.has("dcterms:temporal")) {
                    try {
                    temporal = (JSONArray) booksObj.get("dcterms:temporal");
                    }catch (ClassCastException e) {
                        System.out.println("JSON Problem2 "+file.getName());
                    }
                }

                if (booksObj.has("dc:creator")) {
                    try {
                        creator = (JSONArray) booksObj.get("dc:creator");
                    } catch (ClassCastException e) {
                        System.out.println("JSON Problem "+file.getName());
                    }

                }

                if (booksObj.has("schema:citation")) {
                    citation = (JSONArray) booksObj.get("schema:citation");
                }

                if (booksObj.has("dc:identifier")) {
                    identifier = (JSONArray) booksObj.get("dc:identifier");
                }

                //type = (String) booksObj.get("pcdm:Object").toString();

                String solr = "http://b-app69:8995/solr/ajax-dfz/select?q=id:" + id;

                sb.append("{\n");
                sb.append("  \"@context\": {\n");
                sb.append("    \"fedora\": \"https://fedora.info/definitions/v4/2016/10/18/repository#\",\n");
                sb.append("    \"crossasia\": \"http://crossasia.org/schema/v1#\",\n");
                sb.append("    \"pcdm\": \"http://pcdm.org/models#\",\n");
                sb.append("    \"mods\": \"http://www.loc.gov/mods/modsrdf/v1#\",\n");
                sb.append("    \"book_id\": \"http://schema.org/identifier\",\n");
                sb.append("    \"position\": \"http://schema.org/position\",\n");
                sb.append("    \"dcndl\": \"http://ndl.go.jp/dcndl/\",\n");
                sb.append("    \"text\": \"http://schema.org/text\",\n");
                sb.append("    \"dc\": \"http://purl.org/dc/elements/1.1/\",\n");
                sb.append("    \"seriesTitle\": \"http://ndl.go.jp/dcndl/terms/seriesTitle\",\n");
                sb.append("    \"schema\": \"http://schema.org/\",\n");
                sb.append("    \"person\": \"http://schema.org/Person\",\t\n");
                sb.append("    \"dcterms\": \"http://purl.org/dc/terms/\",\n");
                sb.append("    \"uri\": {\n");
                sb.append("      \"@id\": \"http://purl.org/dc/terms/uri\",\n");
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
                sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Page" + quote + "," + '\n');
                if (language != "")
                    sb.append(quote + "dc:language" + quote + ":" + quote + language + quote + "," + '\n');

                if (title != "")
                    sb.append(quote + "dc:title" + quote + ":" + quote + title +quote  + "," + '\n');

                if (date != "")
                    sb.append(quote + "dc:date" + quote + ":" + quote + date + quote + "," + '\n');

                if (issued != "")
                    sb.append(quote + "dcterms:issued" + quote + ":" + quote + issued + quote + "," + '\n');

                sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

                if (position != "")
                    sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');

                if (book_id != null)
                    sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                if (text != "") {
                    sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');
                }

                if (isPartOf != "")
                    sb.append(quote + "schema:isPartOf" + quote + ":" + quote + isPartOf + quote + "," + '\n');

                if (format != "")
                    sb.append(quote + "schema:fileFormat" + quote + ":" + quote + format + quote + "" + '\n');

                if (thumbnail != "")
                    sb.append(quote + "schema:thumbnail" + quote + ":" + quote + thumbnail + quote + "," + '\n');

                if (edition != null)
                    sb.append(quote + "dc:edition" + quote + ":" + edition + "," + '\n');

                if (seriesTitle != null)
                    sb.append(quote + "dcndl:seriesTitle" + quote + ":" + seriesTitle + "," + '\n');

                if (responsibility != null)
                    sb.append(quote + "mods:responsibility" + quote + ":" + responsibility + "," + '\n');

                if (creator != null)
                    sb.append(quote + "dc:creator" + quote + ":" + creator + "," + '\n');

                if (temporal != null)
                    sb.append(quote + "dcterms:temporal" + quote + ":" + temporal + "," + '\n');

                if (titleTranscription != null)
                    sb.append(quote + "dcndl:titleTranscription" + quote + ":" + titleTranscription + "," + '\n');

                if (citation != null)
                    sb.append(quote + "schema:citation" + quote + ":" + citation + "," + '\n');

                if (spatial != null)
                    sb.append(quote + "dcterms:spatial" + quote + ":" + spatial + "," + '\n');

                if (identifier != null)
                    sb.append(quote + "dc:identifier" + quote + ":" + identifier + "" + '\n');

                if (medium != null)
                    sb.append(quote + "dcterms:medium" + quote + ":" + medium + "" + '\n');

                sb.append("}");
                sb.append("]}");
                Writer writer = new BufferedWriter(new FileWriter(file));
                try {
                    writer.write(sb.toString());
                    Thread.sleep(20);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        //reader.close();
                        writer.close();
                    } catch (IOException ex) {
                        System.out.println("Cast" + file.getName());
                        // Log error writing file and bail out.
                    }

                }
                    /*} else {
                        System.out.println("test" + file.getName());
                    }*/
                // Valid.
            } catch (JsonParseException e) {
                System.out.println("no json" + file.getName());
            } catch (JSONException e) {
                System.out.println("problem with file" + file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Object articles = new JSONObject(new JSONTokener(new FileInputStream(file)));


            //}
        }
    }
}

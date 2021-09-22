package org.crossasia.fedora.reminrebao;

import com.google.gson.JsonParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ChangeFedoraJsonLd {
    public static void main(String[] args) throws IOException {
        File dir = new File("/data1/fedora/rmrb/articles");
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
                        String description = "";
                        String hasModel = "";
                        String language = "";
                        String type = "";
                        String creator = "";
                        String date = "";
                        String title = "";
                        String issued = "";
                        String position = "";
                        String text = "";

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

                        language = (String) booksObj.get("dc:language").toString();

                        if (booksObj.has("dc:date")) {
                            date = (String) booksObj.get("dc:date").toString();
                        }
                        if (booksObj.has("dc:title")) {
                            title = (String) booksObj.get("dc:title").toString();
                        }

                        if (booksObj.has("dcterms:issued")) {
                            issued = (String) booksObj.get("dcterms:issued").toString();
                        }

                        if (booksObj.has("schema:position")) {
                            position = (String) booksObj.get("schema:position").toString();
                        }

                        if (booksObj.has("schema:text")) {

                            text = (String) booksObj.get("schema:text").toString();
                        }

                        if (booksObj.has("schema:isPartOf")) {
                            isPartOf = (String) booksObj.get("schema:isPartOf").toString();
                        }

                        if (booksObj.has("dcterms:medium")) {
                            medium = (JSONArray) booksObj.get("dcterms:medium");
                        }

                        //type = (String) booksObj.get("pcdm:Object").toString();

                        String solr = "http://b-app69:8995/solr/ajax-rmrb/select?q=id:" + id;

                        sb.append("{\n");
                        sb.append("  \"@context\": {\n");
                        sb.append("    \"fedora\": \"https://fedora.info/definitions/v4/2016/10/18/repository#\",\n");
                        sb.append("    \"crossasia\": \"http://crossasia.org/schema/v1#\",\n");
                        sb.append("    \"pcdm\": \"http://pcdm.org/models#\",\n");
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
                        sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Article" + quote + "," + '\n');
                        if (language != null)
                            sb.append(quote + "dc:language" + quote + ":" + quote + language + quote + "," + '\n');

                        if (title != null)
                            sb.append(quote + "dc:title" + quote + ":" + quote + title + quote + "," + '\n');

                        if (date != null)
                            sb.append(quote + "dc:date" + quote + ":" + quote + date + quote + "," + '\n');

                        if (issued != null)
                            sb.append(quote + "dcterms:issued" + quote + ":" + quote + issued + quote + "," + '\n');

                        sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

                        if (position != null)
                            sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');

                        if (text != null)
                            sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');

                        if (isPartOf != null)
                            sb.append(quote + "schema:isPartOf" + quote + ":" + quote + isPartOf + quote + "," + '\n');

                        if (medium != null)
                            sb.append(quote + "dcterms:medium" + quote + ":" + medium + "" + '\n');

                        sb.append("}");
                        sb.append("]}");
                        Writer writer = new BufferedWriter(new FileWriter(file));
                        try {
                            writer.write(sb.toString());
                            Thread.sleep(20);

                        } finally {
                            try {
                                //reader.close();
                                writer.close();
                            } catch (IOException ex) {
                                // Log error writing file and bail out.
                            }

                        }
                    /*} else {
                        System.out.println("test" + file.getName());
                    }*/
                    // Valid.
                } catch (JsonParseException e) {
                    System.out.println("no json" + file.getName());
                } /*catch (ParseException e) {
                e.printStackTrace();
            }*/ catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //Object articles = new JSONObject(new JSONTokener(new FileInputStream(file)));


            //}
        }
    }
}
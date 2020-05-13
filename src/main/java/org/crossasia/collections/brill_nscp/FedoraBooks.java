package org.crossasia.collections.brill_nscp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class FedoraBooks {
    public static void main(String[] args) {
        createJSONLD();
    }

    private static void createJSONLD() {
        try {
            String quote = "\u005c\u0022";
            String absolutePath = "/data1/fedora/ajax-brill-ncdn/books/";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            for (File file : filesInDir) {
                StringBuilder sb = new StringBuilder();
                JSONObject jsonObject = new JSONObject(new JSONTokener(new FileInputStream(file)));

                String url = "";
                JSONArray description = null;
                String language = "";
                String medium = "";
                String book_id = "";
                String bibliographicCitation ="";
                String identifier = "";
                String title = "";
                String date = "";
                String issued = "";
                String file_location="";
                String url_erf = "";
                String identifier_dc = "";
                String publisher = "";
                String subject = "";
                String publicationVolume= "";


                if (jsonObject.has("schema:url")) {
                    url = (String) jsonObject.get("schema:url").toString();
                }

                if (jsonObject.has("dc:description")) {
                    description = (JSONArray) jsonObject.get("dc:description");
                }

                if (jsonObject.has("dc:language")) {
                    language = (String) jsonObject.get("dc:language").toString();
                }

                if (jsonObject.has("dc:medium")) {
                    medium = (String) jsonObject.get("dc:medium").toString();
                }

                if (jsonObject.has("book_id")) {
                    book_id = (String) jsonObject.get("book_id").toString();
                }

                if (jsonObject.has("dcterms:bibliographicCitation")) {
                    bibliographicCitation = (String) jsonObject.get("dcterms:bibliographicCitation").toString();
                }

                if (jsonObject.has("schema:identifier")) {
                    identifier = (String) jsonObject.get("schema:identifier").toString();
                }

                if (jsonObject.has("dc:title")) {
                    title = (String) jsonObject.get("dc:title").toString();
                }

                if (jsonObject.has("dc:date")) {
                    date = (String) jsonObject.get("dc:date").toString();
                }

                if (jsonObject.has("dcterms:issued")) {
                    issued = (String) jsonObject.get("dcterms:issued").toString();
                }

                if (jsonObject.has("dcterms:issued")) {
                    issued = (String) jsonObject.get("dcterms:issued").toString();
                }

                if (jsonObject.has("crossasia:file_location")) {
                    file_location = (String) jsonObject.get("crossasia:file_location").toString();
                }

                if (jsonObject.has("crossasia:url_erf")) {
                    url_erf = (String) jsonObject.get("crossasia:url_erf").toString();
                }

                if (jsonObject.has("dc:identifier")) {
                    identifier_dc = (String) jsonObject.get("dc:identifier").toString();
                }

                if (jsonObject.has("dc:publisher")) {
                    publisher = (String) jsonObject.get("dc:publisher").toString();
                }

                if (jsonObject.has("dc:subject")) {
                    subject = (String) jsonObject.get("dc:subject").toString();
                }

                if (jsonObject.has("dcndl:publicationVolume")) {
                    publicationVolume = (String) jsonObject.get("dcndl:publicationVolume").toString();
                }

                String solr = "http://solr-master-prod:8995/solr/ajax-brill-ncdn/select?q=id:" + identifier_dc;

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


                if (identifier != "")
                    sb.append(quote + "dc:identifier" + quote + ":" +  identifier  + "," + '\n');

                if (language != null)
                    sb.append(quote + "dc:language" + quote + ":" +  language  + "," + '\n');

                if (title != "")
                    sb.append(quote + "dc:title" + quote + ":" + quote + title + quote + "," + '\n');

                if (date != "")
                sb.append(quote + "dc:date" + quote + ":" + quote + date + quote + "," + '\n');

                sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

                if (book_id != "")
                    sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                if (url != "")
                    sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');


                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Book" + quote + "" + '\n');

                sb.append("}");
                sb.append("]}");

                sb.deleteCharAt(sb.length() - 1);
                PrintStream out = new PrintStream(new FileOutputStream("/data1/fedora/ajax-minguo/p/pages_json3/"+identifier_dc+".json"));
                out.println("["+sb.toString()+"}]");
            }

        } catch (IOException e) {
            System.out.println("Exception ");
        }

    }
}

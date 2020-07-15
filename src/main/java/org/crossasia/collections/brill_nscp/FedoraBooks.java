package org.crossasia.collections.brill_nscp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class FedoraBooks {




    public static void main(String[] args) {
        FedoraBooks fedoraBooks = new FedoraBooks();
        //fedoraBooks.createJSONLD();
        //fedoraBooks.createSH();
        fedoraBooks.createSHPdfs();
    }

    private void createSHPdfs() {
        BufferedWriter bufferedWriter = null;
        try {
            String absolutePath = "/data1/fedora/ajax-brill-ncdn/pages/";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            bufferedWriter = new BufferedWriter(new FileWriter(absolutePath+"file.sh"));
            String cURLink = "";
            String book_id="";
            String id="";
            String id_new="";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"file.sh")) {
                    System.out.println("text file");
                } else {
                    String name = file.getName();
                    //String shortName = file.getName().substring(0,3);
                    //String name_cut = name.replace(".xml","");

                    JSONObject jsonObject = new JSONObject(new JSONTokener(new FileInputStream(file)));

                    if (jsonObject.has("book_id")) {
                        book_id = (String) jsonObject.get("book_id").toString();
                    }

                    if (jsonObject.has("id")) {
                        id = (String) jsonObject.get("id").toString();
                        String ids [] = id.split("/");
                        id_new = ids[ids.length-1];
                    }

                    System.out.println(book_id);

                    cURLink = "curl -u fedoraAdmin:fedoraAdmin -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + id.replace("/","_") +".json"+ " " + "http://b-lx0005.sbb.spk-berlin.de:8081/fcrepo/rest/ajax-brill-ncdn/" + book_id+"/"+id_new;

                    bufferedWriter.write(cURLink + "\r\n");

                }
            }
            System.out.println("conversion is done");
        } catch (IOException e) {
            System.out.println("Exception ");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createSH() {
        BufferedWriter bufferedWriter = null;
        try {
            String absolutePath = "/data1/fedora/ajax-brill-ncdn/pages/";
            File dir = new File(absolutePath);
            File[] filesInDir = dir.listFiles();
            int i = 0;
            String quote = "\u005c\u0022";
            bufferedWriter = new BufferedWriter(new FileWriter(absolutePath+"file.sh"));
            String cURLink = "";
            String book_id="";
            String id="";
            String id_new="";

            for (File file : filesInDir) {
                i++;
                JSONParser parser = new JSONParser();
                ObjectMapper mapper = new ObjectMapper();
                String fileName = file.toString();
                if (fileName.equals(absolutePath+"file.sh")) {
                    System.out.println("text file");
                } else {
                    String name = file.getName();
                    //String shortName = file.getName().substring(0,3);
                    //String name_cut = name.replace(".xml","");

                    JSONObject jsonObject = new JSONObject(new JSONTokener(new FileInputStream(file)));

                    if (jsonObject.has("book_id")) {
                        book_id = (String) jsonObject.get("book_id").toString();
                    }

                    if (jsonObject.has("id")) {
                        id = (String) jsonObject.get("id").toString();
                        String ids [] = id.split("/");
                        id_new = ids[ids.length-1];
                    }

                    System.out.println(book_id);

                    cURLink = "curl -u fedoraAdmin:fedoraAdmin -i -X PUT -H" + quote + "Content-Type: application/ld+json" + quote + " " + "--data-binary @" + id.replace("/","_") +".json"+ " " + "http://b-lx0005.sbb.spk-berlin.de:8081/fcrepo/rest/ajax-brill-ncdn/" + book_id+"/"+id_new;

                    bufferedWriter.write(cURLink + "\r\n");

                }
            }
            System.out.println("conversion is done");
        } catch (IOException e) {
            System.out.println("Exception ");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createJSONLD() {
        String quote = "\u005c\u0022";
        String absolutePath = "/data1/fedora/ajax-brill-ncdn/pages/";
        File dir = new File(absolutePath);
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {
            StringBuilder sb = new StringBuilder();
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(new JSONTokener(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

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
            String hasModel = "";
            String publicationVolume= "";

            String text= "";
            String position= "";

            String url_id = "";
            String new_id = "";


            if (jsonObject.has("url")) {
                url = (String) jsonObject.get("url").toString();
            }

            if (jsonObject.has("description")) {
                description = (JSONArray) jsonObject.get("description");
            }

            if (jsonObject.has("language")) {
                language = (String) jsonObject.get("language").toString();
            }

            if (jsonObject.has("hasModel")) {
                hasModel = (String) jsonObject.get("hasModel").toString();
            }

            if (jsonObject.has("medium")) {
                medium = (String) jsonObject.get("medium").toString();
            }

            if (jsonObject.has("position")) {
                position = (String) jsonObject.get("position").toString();
            }

            if (jsonObject.has("text")) {
                text = (String) jsonObject.get("text").toString();
            }

            if (jsonObject.has("book_id")) {
                book_id = (String) jsonObject.get("book_id").toString();
            }

            if (jsonObject.has("bibliographicCitation")) {
                bibliographicCitation = (String) jsonObject.get("bibliographicCitation").toString();
            }

            if (jsonObject.has("doi")) {
                identifier = (String) jsonObject.get("doi").toString();
            }

            if (jsonObject.has("title")) {
                title = (String) jsonObject.get("title").toString();
            }

            if (jsonObject.has("date")) {
                date = (String) jsonObject.get("date").toString();
            }

            if (jsonObject.has("wholedate")) {
                issued = (String) jsonObject.get("wholedate").toString();
            }


            if (jsonObject.has("file_location")) {
                file_location = (String) jsonObject.get("file_location").toString();
            }

            if (jsonObject.has("erflink")) {
                url_erf = (String) jsonObject.get("erflink").toString();
            }

            if (jsonObject.has("id")) {
                identifier_dc = (String) jsonObject.get("id").toString();
                String [] a = identifier_dc.split("/");
                new_id = identifier_dc.replace("/","_");
                url_id = a[a.length-1];
            }

            if (jsonObject.has("publication_name")) {
                publisher = (String) jsonObject.get("publication_name").toString();
            }

            if (jsonObject.has("subject")) {
                subject = (String) jsonObject.get("subject").toString();
            }

            if (jsonObject.has("publicationVolume")) {
                publicationVolume = (String) jsonObject.get("publicationVolume").toString();
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

            if (hasModel=="Book") {
                if (url != "")
                    sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

                if (description != null)
                    sb.append(quote + "dc:description" + quote + ":" + description +"," + '\n');

                if (language != "")
                    sb.append(quote + "dc:language" + quote + ":" + quote + "eng" + quote + "," + '\n');

                if (medium != "")
                    sb.append(quote + "dc:medium" + quote + ":" + quote + medium + quote + "," + '\n');

                if (book_id != "")
                    sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                if (bibliographicCitation != "")
                    sb.append(quote + "dcterms:bibliographicCitation" + quote + ":" + quote + bibliographicCitation + quote + "," + '\n');

                if (identifier != "")
                    sb.append(quote + "schema:identifier" + quote + ":" + quote + identifier + quote  + "," + '\n');

                if (title != "")
                    sb.append(quote + "dc:title" + quote + ":" + quote + title + quote + "," + '\n');

                if (date != "")
                    sb.append(quote + "dc:date" + quote + ":" + quote + date + quote + "," + '\n');

                if (issued != "")
                    sb.append(quote + "dcterms:issued" + quote + ":" + quote + issued + quote + "," + '\n');

                if (file_location != "")
                    sb.append(quote + "crossasia:file_location" + quote + ":" + quote + file_location + quote + "," + '\n');

                if (url_erf != "")
                    sb.append(quote + "crossasia:url_erf" + quote + ":" + quote + url_erf + quote + "," + '\n');

                if (identifier_dc != "")
                    sb.append(quote + "dc:identifier" + quote + ":" + quote + identifier_dc + quote + "," + '\n');

                if (publisher != "")
                    sb.append(quote + "dc:publisher" + quote + ":" + quote + publisher + quote + "," + '\n');

                if (subject != "")
                    sb.append(quote + "dc:subject" + quote + ":" + quote + subject + quote + "," + '\n');

                if (publicationVolume != "")
                    sb.append(quote + "dcndl:publicationVolume" + quote + ":" + quote + publicationVolume + quote + "," + '\n');


                sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Book" + quote + "" + '\n');
            } else {

                if (identifier_dc != "")
                    sb.append(quote + "dc:identifier" + quote + ":" + quote + identifier_dc + quote + "," + '\n');

                if (book_id != "")
                    sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                if (position != "")
                    sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');

                if (text != "")
                    sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');

                sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Page" + quote + "" + '\n');
            }



            sb.append("}");
            sb.append("]}");

            sb.deleteCharAt(sb.length() - 1);
            PrintStream out = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("/data1/fedora/ajax-brill-ncdn/fedora-pages/"+new_id+".json",true);
                //out = new PrintStream(new FileOutputStream("/fedora/ajax-brill-ncdn/books-fedora/"+identifier_dc+".json", true));
                out = new PrintStream(fileOutputStream, true, "UTF-8");
                out.println("["+sb.toString()+"}]");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }


}

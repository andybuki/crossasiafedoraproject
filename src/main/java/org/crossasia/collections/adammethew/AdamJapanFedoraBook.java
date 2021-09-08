package org.crossasia.collections.adammethew;

import com.google.gson.JsonParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class AdamJapanFedoraBook {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File dir = new File("/data/fedora/ajax-fo-china-japan/");
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
                String note = "";
                String publicationVolume="";
                String pageStart = "";
                String pageEnd = "";
                String value = "";
                String url = "";
                JSONArray urlFull=null;
                String thumbnail = "";
                String image = "";
                String date = "";
                String datePublished = "";
                JSONArray title = null;
                String issued = "";
                String issue = "";
                String position = "";
                String format = "";
                String journal_id = "";
                String formatDC = "";
                String rightsHolder = "";
                String journalTitle = "";
                String admin_level_2 ="";
                String admin_level_1 ="";
                String text = "";
                JSONArray edition = null;
                JSONArray subject = null;
                JSONArray creator = null;
                String temporal = "";
                JSONArray spatial = null;
                String article_id="";
                String nodeId = "";
                String publisher = "";
                JSONArray keywords = null;
                String identifier = "";
                JSONArray citation = null;
                JSONArray person = null;
                String responsibility = "";
                String responsibility_title = "";
                JSONArray creatorTranscription = null;
                String longitude="";
                String latitude="";
                String genre ="";
                String extent ="";
                String admin_type="";
                String TGAZ_API ="";
                String CHGIS="";
                String ISBN="";
                String physicalDescription ="";
                JSONArray isMemberOf =null;
                JSONArray seriesTitle = null;
                JSONArray titleTranscription = null;
                String source="";

                String isPartOf = "";
                String lizenz ="";
                JSONArray medium = null;

                JSONObject booksObj = (JSONObject) graph.get(0);
                if (booksObj.has("dc:identifier")) {
                    id = (String) booksObj.get("dc:identifier").toString();
                }

                if (booksObj.has("id")) {
                    id = (String) booksObj.get("id").toString();
                }

                if (booksObj.has("article_id")) {
                    article_id = (String) booksObj.get("article_id").toString();
                }

                //description = (String) booksObj.get("dc:description").toString();
                if (booksObj.has("hasModel")) {
                    hasModel = (String) booksObj.get("hasModel").toString();
                } else {
                    hasModel = (String) booksObj.get("fedora:hasModel").toString();
                }

                if (booksObj.has("pageStart")) {
                    pageStart = (String) booksObj.get("pageStart").toString();
                }

                if (booksObj.has("dc:source")) {
                    source = (String) booksObj.get("dc:source").toString();
                }

                if (booksObj.has("schema:ISBN")) {
                    ISBN = (String) booksObj.get("schema:ISBN").toString();
                }

                if (booksObj.has("pageEnd")) {
                    pageEnd = (String) booksObj.get("pageEnd").toString();
                }

                if (booksObj.has("nodeId")) {
                    nodeId = (String) booksObj.get("nodeId").toString();
                }

                if (booksObj.has("nodeId")) {
                    nodeId = (String) booksObj.get("nodeId").toString();
                }

                if (booksObj.has("dc:format")) {
                    formatDC = (String) booksObj.get("dc:format").toString();
                }

                if (booksObj.has("dcndl:publicationVolume")) {
                    publicationVolume = (String) booksObj.get("dcndl:publicationVolume").toString();
                }

                if (booksObj.has("dcndl:journalTitle")) {
                    journalTitle = (String) booksObj.get("dcndl:journalTitle").toString();
                }

                if (booksObj.has("value")) {
                    value = (String) booksObj.get("value").toString();
                }

                /*if (booksObj.has("dcterms:identifier")) {
                    urlFull = (JSONArray) booksObj.get("dcterms:identifier");
                    if (urlFull.get(0).toString().contains("http://")){
                        url = urlFull.get(0).toString();
                    } else {
                        url = urlFull.get(1).toString();
                    }

                }*/

                if (booksObj.has("dcterms:identifier")) {
                    url = (String) booksObj.get("dcterms:identifier");
                }


                /*if (booksObj.has("schema:url")) {
                    url = (String) booksObj.get("schema:url").toString();
                }*/

                if (booksObj.has("dc:language")) {
                    language = (String) booksObj.get("dc:language");
                }

                if (booksObj.has("note")) {
                    note = (String) booksObj.get("note").toString();
                }

                if (booksObj.has("CrossAsia Lizenz")) {
                    lizenz = (String) booksObj.get("CrossAsia Lizenz").toString();
                }

                if (booksObj.has("mods:genre")) {
                    genre = (String) booksObj.get("mods:genre").toString();
                }

                if (booksObj.has("longitude")) {
                    longitude = (String) booksObj.get("longitude").toString();
                }

                if (booksObj.has("mods:physicalDescription")) {
                    physicalDescription = (String) booksObj.get("mods:physicalDescription");
                }

                if (booksObj.has("dcterms:extent")) {
                    extent = (String) booksObj.get("dcterms:extent").toString();
                }

                if (booksObj.has("TGAZ API")) {
                    TGAZ_API = (String) booksObj.get("TGAZ API").toString();
                }

                if (booksObj.has("CHGIS")) {
                    CHGIS = (String) booksObj.get("CHGIS").toString();
                }

                if (booksObj.has("latitude")) {
                    latitude = (String) booksObj.get("latitude").toString();
                }

                if (booksObj.has("crossasia:admin_type")) {
                    admin_type = (String) booksObj.get("crossasia:admin_type").toString();
                }

                if (booksObj.has("crossasia:admin_level_2")) {
                    admin_level_2 = (String) booksObj.get("crossasia:admin_level_2").toString();
                }

                if (booksObj.has("crossasia:admin_level_1")) {
                    admin_level_1 = (String) booksObj.get("crossasia:admin_level_1").toString();
                }

                if (booksObj.has("dc:date")) {
                    date = (String) booksObj.get("dc:date").toString();
                }

                if (booksObj.has("schema:datePublished")) {
                    datePublished = (String) booksObj.get("schema:datePublished").toString();
                }

                if (booksObj.has("schema:image")) {
                    image = (String) booksObj.get("schema:image").toString();
                }

                if (booksObj.has("dcterms:rightsHolder")) {
                    rightsHolder = (String) booksObj.get("dcterms:rightsHolder").toString();
                }

                if (booksObj.has("mods:title_responsibility")) {
                    responsibility_title = (String) booksObj.get("mods:title_responsibility");
                }

                if (booksObj.has("mods:responsibility")) {
                    responsibility = (String) booksObj.get("mods:responsibility");
                }

                if (booksObj.has("dc:subject")) {
                    subject = (JSONArray) booksObj.get("dc:subject");
                }

                if (booksObj.has("dc:description")) {
                    description = (String) booksObj.get("dc:description");
                }

                if (booksObj.has("fedora:isMemberOf")) {
                    isMemberOf = (JSONArray) booksObj.get("fedora:isMemberOf");
                }

                if (booksObj.has("schema:keywords")) {
                    keywords = (JSONArray) booksObj.get("schema:keywords");
                }

                if (booksObj.has("dc:publisher")) {
                    publisher = (String) booksObj.get("dc:publisher");
                }

                if (booksObj.has("schema:person")) {
                    person = (JSONArray) booksObj.get("schema:person");
                }

                if (booksObj.has("dcndl:creatorTranscription")) {
                    creatorTranscription = (JSONArray) booksObj.get("dcndl:creatorTranscription");
                }

                if (booksObj.has("book_id")) {
                    book_id = (String) booksObj.get("book_id").toString();
                }

                if (booksObj.has("dc:title")) {
                    title = (JSONArray) booksObj.get("dc:title");
                }

                if (booksObj.has("dcterms:issued")) {
                    issued = (String) booksObj.get("dcterms:issued").toString();
                }

                if (booksObj.has("dcndl:issue")) {
                    issue = (String) booksObj.get("dcndl:issue").toString();
                }

                if (booksObj.has("schema:fileFormat")) {
                    format = (String) booksObj.get("schema:fileFormat").toString();
                }

                if (booksObj.has("schema:position")) {
                    position = (String) booksObj.get("schema:position").toString();
                }

                if (booksObj.has("schema:text")) {
                    text = (String) booksObj.get("schema:text").toString()
                            .replaceAll("\"", "");
                            //.replaceAll(" ","")
                            //.replaceAll("\uE010\f","")
                    //.replaceAll("\f","")
                     //       .replaceAll("\u0002","")
                       //     .replaceAll("\u0091","")
                         //   .replaceAll("\u0090","");
                }

                if (booksObj.has("schema:thumbnail")) {
                    thumbnail = (String) booksObj.get("schema:thumbnail").toString();
                }

                if (booksObj.has("dcterms:isPartOf")) {
                    isPartOf = (String) booksObj.get("dcterms:isPartOf").toString();
                }

                if (booksObj.has("dc:medium")) {
                    medium = (JSONArray) booksObj.get("dc:medium");
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
                    } catch (ClassCastException e) {
                        System.out.println("JSON Problem3 " + file.getName());
                    }
                }

                if (booksObj.has("dcterms:spatial")) {
                    spatial = (JSONArray) booksObj.get("dcterms:spatial");
                }

                if (booksObj.has("dcterms:temporal")) {
                    try {
                        temporal = (String) booksObj.get("dcterms:temporal").toString();
                    } catch (ClassCastException e) {
                        System.out.println("JSON Problem2 " + file.getName());
                    }
                }

                if (booksObj.has("dc:creator")) {
                    try {
                        creator = (JSONArray) booksObj.get("dc:creator");
                    } catch (ClassCastException e) {
                        System.out.println("JSON Problem " + file.getName());
                    }

                }

                if (booksObj.has("schema:citation")) {
                    citation = (JSONArray) booksObj.get("schema:citation");
                }

                if (booksObj.has("Erudition LocGaz")) {
                    identifier = (String) booksObj.get("Erudition LocGaz");
                }

                //type = (String) booksObj.get("pcdm:Object").toString();

                String solr = "http://solr-master-prod.sbb.spk-berlin.de:8995/solr/ajax-fo-china-japan/select?q=id:" + id;

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
                if (id != "")
                    sb.append(quote + "dc:identifier" + quote + ":" + quote + id + quote + "," + '\n');


                if (language != "")
                    sb.append(quote + "dc:language" + quote + ":" + quote+ language+ quote + "," + '\n');

                if (title != null)
                    sb.append(quote + "dc:title" + quote + ":" +  title +  "," + '\n');

                if (date != "")
                    sb.append(quote + "dc:date" + quote + ":" + quote + date + quote + "," + '\n');

                if (datePublished != "")
                    sb.append(quote + "schema:datePublished" + quote + ":" + quote + datePublished + quote + "," + '\n');

                if (publicationVolume != "")
                    sb.append(quote + "dcndl:publicationVolume" + quote + ":" + quote + publicationVolume + quote + "," + '\n');

                if (ISBN != "")
                    sb.append(quote + "schema:ISBN" + quote + ":" + quote + ISBN + quote + "," + '\n');

                if (longitude != "")
                    sb.append(quote + "schema:longitude" + quote + ":" + quote + longitude + quote + "," + '\n');

                if (latitude != "")
                    sb.append(quote + "schema:latitude" + quote + ":" + quote + latitude + quote + "," + '\n');

                if (admin_level_1 != "")
                    sb.append(quote + "crossasia:admin_level_1" + quote + ":" + quote + admin_level_1 + quote + "," + '\n');

                if (admin_level_2 != "")
                    sb.append(quote + "crossasia:admin_level_2" + quote + ":" + quote + admin_level_2 + quote + "," + '\n');

                if (admin_type != "")
                    sb.append(quote + "crossasia:admin_type" + quote + ":" + quote + admin_type + quote + "," + '\n');

                if (issued != "")
                    sb.append(quote + "dcterms:issued" + quote + ":" + quote + issued + quote + "," + '\n');

                if (issue != "")
                    sb.append(quote + "dcndl:issue" + quote + ":" + quote + issue + quote + "," + '\n');

                sb.append(quote + "solr" + quote + ":" + quote + solr + quote + "," + '\n');

                if (position != "")
                    sb.append(quote + "schema:position" + quote + ":" + quote + position + quote + "," + '\n');

                if (rightsHolder != "")
                    sb.append(quote + "dcterms:rightsHolder" + quote + ":" +  rightsHolder + "," + '\n');

                if (book_id != "")
                    sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                if (text != "") {
                    sb.append(quote + "schema:text" + quote + ":" + quote + text + quote + "," + '\n');
                }

                if (pageStart != "") {
                    sb.append(quote + "schema:pageStart" + quote + ":" + quote + pageStart + quote + "," + '\n');
                }

                if (pageEnd != "") {
                    sb.append(quote + "schema:pageEnd" + quote + ":" + quote + pageEnd + quote + "," + '\n');
                }

                if (article_id != "") {
                    sb.append(quote + "schema:identifier" + quote + ":" + quote + article_id + quote + "," + '\n');
                }

                if (journalTitle != "") {
                    sb.append(quote + "dcndl:journalTitle" + quote + ":" + quote + journalTitle + quote + "," + '\n');
                }

                if (value != "") {
                    sb.append(quote + "schema:value" + quote + ":" + quote + value + quote + "," + '\n');
                }


                if (note != "") {
                    sb.append(quote + "mods:note" + quote + ":" + quote + note.replace("type=\"statement of responsibility\" ","") + quote + "," + '\n');
                }

                if (identifier != "") {
                    sb.append(quote + "dcterms:identifier" + quote + ":" + quote + identifier.replace("type=\"Erudition LocGaz\" ","") + quote + "," + '\n');
                }

                if (extent != "") {
                    sb.append(quote + "dcterms:extent" + quote + ":" + quote + extent + quote + "," + '\n');
                }

                if (TGAZ_API != "") {
                    sb.append(quote + "TGAZ API" + quote + ":" + quote + TGAZ_API.replace("type=\"TGAZ API\" ","") + quote + "," + '\n');
                }

                if (CHGIS != "") {
                    sb.append(quote + "crossasia:CHGIS" + quote + ":" + quote + CHGIS.replace("type=\"CHGIS\" ","") + quote + "," + '\n');
                }

                if (genre != "") {
                    sb.append(quote + "mods:genre" + quote + ":" + quote + genre + quote + "," + '\n');
                }

                if (formatDC != "") {
                    sb.append(quote + "dc:format" + quote + ":" + quote + formatDC + quote + "," + '\n');
                }

                if (isPartOf != "")
                    sb.append(quote + "schema:isPartOf" + quote + ":" + quote + isPartOf + quote + "," + '\n');

                if (format != "")
                    sb.append(quote + "schema:fileFormat" + quote + ":" + quote + format + quote + "," + '\n');

                if (thumbnail != "")
                    sb.append(quote + "schema:thumbnail" + quote + ":" + quote + thumbnail + quote + "," + '\n');

                if (image != "")
                    sb.append(quote + "schema:image" + quote + ":" + quote + image + quote + "," + '\n');

                if (url != "")
                    sb.append(quote + "url" + quote + ":" + quote+ url +quote+ "," + '\n');

                if (edition != null)
                    sb.append(quote + "dc:edition" + quote + ":" + edition + "," + '\n');

                if (isMemberOf != null)
                    sb.append(quote + "crossasia:isMemberOf" + quote + ":" + isMemberOf + "," + '\n');

                if (physicalDescription != "")
                    sb.append(quote + "mods:physicalDescription" + quote + ":" +quote+ physicalDescription +quote+ "," + '\n');

                if (source != "")
                    sb.append(quote + "dc:source" + quote + ":" +quote+ source +quote+ "," + '\n');

                if (creatorTranscription != null)
                    sb.append(quote + "dcndl:creatorTranscription" + quote + ":" + creatorTranscription + "," + '\n');

                if (subject != null)
                    sb.append(quote + "dc:subject" + quote + ":" + subject + "," + '\n');

                if (person != null)
                    sb.append(quote + "schema:Person" + quote + ":" + person + "," + '\n');

                if (description != "")
                    sb.append(quote + "dc:description" + quote + ":" + quote+ description +quote+ "," + '\n');

                if (seriesTitle != null)
                    sb.append(quote + "dcndl:seriesTitle" + quote + ":" +  seriesTitle + "," + '\n');

                if (keywords != null)
                    sb.append(quote + "schema:keywords" + quote + ":" + keywords + "," + '\n');

                if (responsibility != "")
                    sb.append(quote + "mods:responsibility" + quote + ":" + quote+responsibility +quote+ "," + '\n');

                if (creator != null)
                    sb.append(quote + "dc:creator" + quote + ":" + creator + "," + '\n');

                if (publisher != "")
                    sb.append(quote + "dc:publisher" + quote + ":" + quote+ publisher + quote+"," + '\n');

                if (temporal != "")
                    sb.append(quote + "dcterms:temporal" + quote + ":" + quote+ temporal+quote + "," + '\n');

                if (titleTranscription != null)
                    sb.append(quote + "dcndl:titleTranscription" + quote + ":" + titleTranscription + "," + '\n');

                if (citation != null)
                    sb.append(quote + "schema:citation" + quote + ":" + citation + "," + '\n');

                if (spatial != null)
                    sb.append(quote + "dcterms:spatial" + quote + ":" + spatial  + "," + '\n');

                if (medium != null)
                    sb.append(quote + "dcterms:medium" + quote + ":" + medium + "," + '\n');

                if (lizenz != "")
                    sb.append(quote + "CrossAsia_Lizenz" + quote + ":" + quote + lizenz.replace("type=\"CrossAsia Lizenz\" ","") + quote + "," + '\n');

                sb.append(quote + "crossasia:hasModel" + quote + ":" + quote + "Page" + quote + "" + '\n');



                sb.append("}");
                sb.append("]}");
                Writer writer = new BufferedWriter(new FileWriter(file));
                try {
                    writer.write(sb.toString());
                    Thread.sleep(2);

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
            } catch (ClassCastException e) {
                System.out.println("cannot be cast to org.json.JSONArray -SPATIAL: " + file.getName());
            } catch (JsonParseException e) {
                System.out.println("no json" + file.getName());
            } catch (JSONException e) {
                System.out.println("problem with file: " + file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Object articles = new JSONObject(new JSONTokener(new FileInputStream(file)));


            //}
        }
    }
}

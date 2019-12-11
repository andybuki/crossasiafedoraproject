package org.crossasia.collections.meijijapan;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MeijiJapanFedoraJsonLd {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/fedora/ajax-meiji-japan/books.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/fedora/ajax-meiji-japan/books_ld.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));

        StringBuilder sb = new StringBuilder();


        sb.append("{\n");
        sb.append("  \"@context\": {\n");
        sb.append("    \"fedora\": \"https://fedora.info/definitions/v4/2016/10/18/repository#\",\n");
        sb.append("    \"crossasia\": \"http://crossasia.org/schema/v1#\",\n");
        sb.append("    \"pcdm\": \"http://pcdm.org/models#\",\n");
        sb.append("    \"book_id\": \"http://schema.org/identifier\",\n");
        sb.append("    \"position\": \"http://schema.org/position\",\n");
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
        sb.append("      \"@id\": \"http://crossasia.org/schema/v1#/solr\",\n");
        sb.append("      \"@type\": \"@id\"\n");
        sb.append("   }\n\t");
        sb.append(" },\n\n");
        sb.append("\"@id\": \"urn:x-arq:DefaultGraphNode\",\n");

        sb.append("\"@graph\": ["+ '\n');

        for (int i=0; i<booksObject.length(); i++) {

            String id="";
            String url ="";
            String date = null;
            String title = null;
            JSONArray edition = null;
            JSONArray medium = null;
            JSONArray subject = null;

            JSONArray person = null;
            String language = null;
            String spatial = null;


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();

            if (booksObj.has("url"))
                url =(String) booksObj.get("url");

            if (booksObj.has("title")) {
                title = "";
                title = (String) booksObj.get("title").toString().replace("[","").replace("]","");
            }

            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");

            if (booksObj.has("medium"))
                medium =(JSONArray) booksObj.get("medium");

            if (booksObj.has("date")) {
                date = "";
                date = (String) booksObj.get("date").toString();
            }

            if (booksObj.has("person"))
                person =(JSONArray) booksObj.get("person");

            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }

            if (booksObj.has("spatial"))
                spatial =(String) booksObj.get("spatial").toString().replaceAll(",","\",\"");


            String solr = "http://b-app69:8995/solr/ajax-meiji-japan/select?q=id:"+id;

            sb.append("{"+ '\n');
            sb.append("\"@type\": \"pcdm:Object\",\n");
            sb.append("\"@id\": \"\",\n");
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );

            if (url!=null)
                sb.append(  quote + "uri" + quote + ":" + quote+ url+ quote + "," + '\n');

            sb.append(  quote + "solr" + quote + ":" + quote+ solr+ quote + "," + '\n' );

            if (title!=null)
                sb.append(  quote + "dc:title" + quote + ":" +  quote+  title+ quote+ "," + '\n');

            if (edition!=null)
                sb.append(  quote + "dc:edition" + quote + ":" +  edition+  "," + '\n');

            if (medium!=null)
                sb.append(  quote + "dc:medium" + quote + ":" +  medium+  "," + '\n');

            if (date!=null)
                sb.append(  quote + "dc:date" + quote + ":" + quote+ date+ quote+ "," + '\n');

            if (person!=null)
                sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');

            if (language!=null)
                sb.append(  quote + "dc:language" + quote + ":" + quote+ language+ quote+ "," + '\n');

            if (spatial!=null)
                sb.append(  quote + "dcterms:spatial" + quote + ":" + "[" +quote+ spatial+ quote+"]" +"," + '\n');

            sb.append(  quote + "crossasia:hasModel" + quote + ":" + quote+ "Book"+ quote + "" + '\n' );


            sb.append("},");
        }



        sb.deleteCharAt(sb.length() - 1);
        out.println(""+sb.toString()+"]}");

        }
    }


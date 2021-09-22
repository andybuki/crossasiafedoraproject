package org.crossasia.solr.collections.ead_digital;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class BooksSolr {
    public BooksSolr() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        BooksSolr booksSolr = new BooksSolr();
        booksSolr.createJSONLD();
    }
    PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-ead-digital/books.json"));

    StringBuilder sb = new StringBuilder();
    private void createJSONLD() throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String absolutePath = "/data1/solr/ajax-ead-digital/books";
        File dir = new File(absolutePath);
        File[] filesInDir = dir.listFiles();
        for (File file : filesInDir) {

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(new JSONTokener(new FileInputStream(file)));
            } catch (FileNotFoundException e) {
                file.getName();
            }

            String url = "";
            JSONArray description = null;
            JSONArray language = null;
            String medium = "";
            String book_id = "";
            String id = "";
            String bibliographicCitation ="";
            String identifier = "";
            String title = "";
            String date = "";
            String issued = "";
            String edition = "";
            String file_location="";
            JSONArray erflink = null;
            String identifier_dc = "";
            String publisher = "";
            String subject = "";
            String hasModel = "";
            String publicationVolume= "";
            JSONArray extent= null;
            JSONArray originalLocation= null;

            JSONArray alternative= null;

            String text= "";
            String position= "";
            String dateOriginal= "";

            String segment= "";

            JSONArray creator= null;
            JSONArray creator2= null;

            JSONArray title_index= null;
            JSONArray seriesTitle= null;
            String url_id = "";
            String new_id = "";


            if (jsonObject.has("url")) {
                url = (String) jsonObject.get("url").toString();
            }

            if (jsonObject.has("id")) {
                id = (String) jsonObject.get("id").toString();
            }

            if (jsonObject.has("dateOriginal")) {
                dateOriginal = (String) jsonObject.get("dateOriginal").toString();
            }

            if (jsonObject.has("segment")) {
                segment = (String) jsonObject.get("segment").toString();
            }

            if (jsonObject.has("description")) {
                description = (JSONArray) jsonObject.get("description");
            }

            if (jsonObject.has("alternative")) {
                alternative = (JSONArray) jsonObject.get("alternative");
            }

            if (jsonObject.has("originalLocation")) {
                originalLocation = (JSONArray) jsonObject.get("originalLocation");
            }

            if (jsonObject.has("seriesTitle")) {
                seriesTitle = (JSONArray) jsonObject.get("seriesTitle");
            }

            if (jsonObject.has("creator")) {
                creator = (JSONArray) jsonObject.get("creator");
            }

            if (jsonObject.has("creator2")) {
                creator2 = (JSONArray) jsonObject.get("creator2");
            }

            if (jsonObject.has("identifier")) {
                identifier = (String) jsonObject.get("identifier");
            }

            if (jsonObject.has("extent")) {
                extent = (JSONArray) jsonObject.get("extent");
            }

            if (jsonObject.has("edition")) {
                edition = (String) jsonObject.get("edition");
            }

            if (jsonObject.has("language")) {
                language = (JSONArray) jsonObject.get("language");
            }

            if (jsonObject.has("title_index")) {
                title_index = (JSONArray) jsonObject.get("title_index");
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

            if (jsonObject.has("issued")) {
                date = (String) jsonObject.get("issued").toString();
            }

            if (jsonObject.has("wholedate")) {
                issued = (String) jsonObject.get("wholedate").toString();
            }

            if (jsonObject.has("file_location")) {
                file_location = (String) jsonObject.get("file_location").toString();
            }

            if (jsonObject.has("erflink")) {
                erflink = (JSONArray) jsonObject.get("erflink");
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


            sb.append("{" + '\n');


                if (url != "")
                    sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

                if (dateOriginal != "")
                    sb.append(quote + "dateOriginal" + quote + ":" + quote + dateOriginal + quote + "," + '\n');

                if (segment != "")
                    sb.append(quote + "segment" + quote + ":" + quote + segment + quote + "," + '\n');

                if (description != null)
                    sb.append(quote + "description" + quote + ":" + description +"," + '\n');

                if (language != null)
                    sb.append(quote + "language" + quote + ":" +  language +  "," + '\n');

                if (extent != null)
                    sb.append(quote + "extent" + quote + ":" +  extent +  "," + '\n');

                if (medium != "")
                    sb.append(quote + "medium" + quote + ":" + quote + medium + quote + "," + '\n');

                if (title_index != null)
                    sb.append(quote + "title_index" + quote + ":" +  title_index  + "," + '\n');

                if (creator != null)
                    sb.append(quote + "creator" + quote + ":" +  creator  + "," + '\n');

                if (creator2 != null)
                    sb.append(quote + "creator2" + quote + ":" +  creator2  + "," + '\n');

                if (alternative != null)
                    sb.append(quote + "alternative" + quote + ":" +  alternative  + "," + '\n');

                if (book_id != "")
                    sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                if (originalLocation != null)
                    sb.append(quote + "originalLocation" + quote + ":"  + originalLocation  + "," + '\n');

                if (seriesTitle != null)
                    sb.append(quote + "seriesTitle" + quote + ":"  + seriesTitle  + "," + '\n');

                if (bibliographicCitation != "")
                    sb.append(quote + "bibliographicCitation" + quote + ":" + quote + bibliographicCitation + quote + "," + '\n');

                if (identifier != "")
                    sb.append(quote + "identifier" + quote + ":" + quote + identifier + quote  + "," + '\n');

                 if (id != "")
                    sb.append(quote + "id" + quote + ":" + quote + id + quote  + "," + '\n');

                if (title != "")
                    sb.append(quote + "title" + quote + ":" + quote + title + quote + "," + '\n');

                if (edition != "")
                    sb.append(quote + "edition" + quote + ":" + quote + edition + quote + "," + '\n');

                if (date != "")
                    sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');

                if (issued != "")
                    sb.append(quote + "issued" + quote + ":" + quote + issued + quote + "," + '\n');

                if (file_location != "")
                    sb.append(quote + "file_location" + quote + ":" + quote + file_location + quote + "," + '\n');

                if (erflink != null)
                    sb.append(quote + "erflink" + quote + ":" +  erflink +  "," + '\n');

                if (identifier_dc != "")
                    sb.append(quote + "identifier" + quote + ":" + quote + identifier_dc + quote + "," + '\n');

                if (publisher != "")
                    sb.append(quote + "publisher" + quote + ":" + quote + publisher + quote + "," + '\n');

                if (subject != "")
                    sb.append(quote + "subject" + quote + ":" + quote + subject + quote + "," + '\n');

                if (publicationVolume != "")
                    sb.append(quote + "publicationVolume" + quote + ":" + quote + publicationVolume + quote + "," + '\n');


                sb.append(quote + "hasModel" + quote + ":" + quote + "Book" + quote + "" + '\n');

                sb.append("},");


            //sb.deleteCharAt(sb.length() - 1);


        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}

package org.crossasia.collections.dfz;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Book2ErfLink {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ajax-dfz/books_pages1.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-dfz/books_pages1_NEW.json"));
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            JSONArray edition =null;
            JSONArray responsibility =null;
            JSONArray urls =null;
            String erflink ="";
            JSONArray title_transcription= null;
            String date = "";
            JSONArray identifier = null;
            String book_id = "";
            String id = "";
            String source = "";
            JSONArray publisher = null;
            JSONArray title_responsibility  = null;
            JSONArray title = null;
            JSONArray spatial = null;
            String thumbnail_path = "";

            String idShort="";
            String idShort2="";
            String chapter_title ="";
            String language ="";
            String xml_file ="";
            String assetid_page ="";
            String volume_number ="";

            String page_range ="";
            String asset_id="";
            String page_num="";
            String extent="";

            String format="";
            JSONArray author =null;
            String description="";

            String format2="";
            String journal_title ="";
            String journal_title2 ="";
            JSONArray publication_place =null;
            JSONArray series_title=null;
            String issue_date="";
            String text ="";

            String PSMID="";
            String url ="";
            String position ="";
            String date_original="";
            String publication_volume ="";
            String issued = "";
            String ISBN = "";

            //String series_title = "";

            String medium = "";
            JSONArray subject = null;
            JSONArray citation = null;

            JSONArray series_title_transcription = null;
            JSONArray person = null;

            JSONArray alternative = null;
            JSONArray creator_transcription= null;

            JSONObject booksObj = (JSONObject) booksObject.get(i);
            id = (String) booksObj.get("id").toString();
            if (booksObj.has("title_transcription")) {
                title_transcription = (JSONArray) booksObj.get("title_transcription");
            }

            if (booksObj.has("ISBN"))
                ISBN = (String) booksObj.get("ISBN").toString();

            if (booksObj.has("chapter_title"))
                chapter_title = (String) booksObj.get("chapter_title").toString();

            if (booksObj.has("xml_file"))
                xml_file = (String) booksObj.get("xml_file").toString();

            if (booksObj.has("extent"))
                extent = (String) booksObj.get("extent").toString();

            if (booksObj.has("book_id"))
                book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("title"))
                title = (JSONArray) booksObj.get("title");

            if (booksObj.has("spatial"))
                spatial = (JSONArray) booksObj.get("spatial");

            if (booksObj.has("responsibility"))
                responsibility = (JSONArray) booksObj.get("responsibility");

            if (booksObj.has("position"))
                position = (String) booksObj.get("position").toString();

            if (booksObj.has("publisher"))
                publisher = (JSONArray) booksObj.get("publisher");

            if (booksObj.has("medium"))
                medium = (String) booksObj.get("medium").toString();

            if (booksObj.has("alternative"))
                alternative = (JSONArray) booksObj.get("alternative");

            if (booksObj.has("creator_transcription"))
                creator_transcription = (JSONArray) booksObj.get("creator_transcription");
            if (booksObj.has("issued"))
                issued = (String) booksObj.get("issued").toString();
            if (booksObj.has("thumbnail_path")) {
                thumbnail_path  = (String) booksObj.get("thumbnail_path");
            }

            if (booksObj.has("language")) {
                language  = (String) booksObj.get("language");
            }

            if (booksObj.has("title_responsibility")) {
                title_responsibility  = (JSONArray) booksObj.get("title_responsibility");
            }

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");
            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");
            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");
            if (booksObj.has("series_title"))
                series_title =(JSONArray) booksObj.get("series_title");

            if (booksObj.has("series_title_transcription"))
                series_title_transcription =(JSONArray) booksObj.get("series_title_transcription");

            if (booksObj.has("identifier"))
                identifier =(JSONArray) booksObj.get("identifier");

            if (booksObj.has("citation"))
                citation =(JSONArray) booksObj.get("citation");


            if (booksObj.has("volume-number")) {
                volume_number =(String) booksObj.get("volume-number").toString();
            }
            if (booksObj.has("page_num")) {
                page_num = (String) booksObj.get("page_num").toString();
            }
            if (booksObj.has("asset_id")) {
                asset_id = (String) booksObj.get("asset_id").toString();
            }


            if (booksObj.has("assetid_page")) {
                assetid_page = (String) booksObj.get("assetid_page").toString();
            }

            if (booksObj.has("description")) {
                description = (String) booksObj.get("description").toString();
            }

            if (booksObj.has("page-range")) {
                page_range = (String) booksObj.get("page-range").toString();
            }

            if (booksObj.has("format")) {
                format = (String) booksObj.get("format").toString();
            }

            if (booksObj.has("format2")) {
                format2 = (String) booksObj.get("format2").toString();
            }

            if (booksObj.has("date")) {
                if (booksObj.get("date").toString().length()==8){
                    date = (String) booksObj.get("date").toString().substring(0,4);
                }else {
                    date = (String) booksObj.get("date").toString();
                }
            }

            if (booksObj.has("date-original")) {
                date_original = (String) booksObj.get("date-original").toString();
            }

            if (booksObj.has("journal-title")) {
                journal_title = (String) booksObj.get("journal-title").toString();
            }

                /*if (numerObj.has("journal-title2")) {
                    journal_title2 = (String) numerObj.get("journal-title2").toString();
                }*/

            if (booksObj.has("publication_place")) {
                publication_place = (JSONArray) booksObj.get("publication_place");
            }

            if (booksObj.has("text")) {
                text = (String) booksObj.get("text").toString();
            }

            if (booksObj.has("publication-volume")) {
                publication_volume = (String) booksObj.get("publication-volume").toString();
            }

            if (booksObj.has("series-title")) {
                series_title = (JSONArray) booksObj.get("series-title");
            }

            if (booksObj.has("issue-date")) {
                issue_date = (String) booksObj.get("issue-date").toString();
            }

            if (booksObj.has("identifier")) {
               urls = (JSONArray) booksObj.get("identifier");
               if (urls.get(0).toString().startsWith("http")){
                   url = (String) urls.get(0);
               } else if (urls.get(1).toString().startsWith("http")) {
                   url = (String) urls.get(1);
               }

            }

            if (booksObj.has("identifier")) {
               String url2 = url.replace("http://","");
               erflink = "http://erf.sbb.spk-berlin.de/han/zhongguodifangzhiyiji/"+url2;

            }


            sb.append("{"+ '\n');
            sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
            sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
            if (author!=null) {
                sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');
            }

            if (position!=null) {
                sb.append(quote + "position" + quote + ":" + quote+ position+ quote + "," + '\n');
            }

            if (citation!=null) {
                sb.append(quote + "citation" + quote + ":" +  citation  + "," + '\n');
            }

            if (identifier!=null)
                sb.append(  quote + "identifier" + quote + ":" +  identifier+  "," + '\n');

            if (title_responsibility!=null)
                sb.append(  quote + "title_responsibility" + quote + ":" +  title_responsibility+  "," + '\n');

            if (creator_transcription!=null)
                sb.append(  quote + "creator_transcription" + quote + ":" +  creator_transcription+  "," + '\n');

            if (edition!=null)
                sb.append(  quote + "edition" + quote + ":" +  edition+  "," + '\n');

            if (spatial!=null)
                sb.append(  quote + "spatial" + quote + ":" +  spatial+  "," + '\n');

            if (xml_file!=null)
                sb.append(  quote + "xml_file" + quote + ":" + quote+ xml_file+ quote + "," + '\n');

            if (url!=null)
                sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n');

            if (chapter_title!=null)
                sb.append(  quote + "chapter_title" + quote + ":" + quote+ chapter_title+ quote + "," + '\n');

            if (extent!=null)
                sb.append(  quote + "extent" + quote + ":" + quote+ extent+ quote + "," + '\n');

            if (thumbnail_path!=null)
                sb.append(  quote + "thumbnail_path" + quote + ":" + quote+ thumbnail_path+ quote + "," + '\n');

            if (publisher!=null)
                sb.append(  quote + "publisher" + quote + ":" +  publisher+  "," + '\n');

            if (medium!=null)
                sb.append(  quote + "medium" + quote + ":" + quote+ medium+ quote + "," + '\n');


            if (erflink!=null)
                sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n');

            if (date!=null)
                sb.append(  quote + "date" + quote + ":" +    date+    "," + '\n');


            if (responsibility!=null)
                sb.append(  quote + "responsibility" + quote + ":" +  responsibility+  "," + '\n');

            if (ISBN!=null)
                sb.append(  quote + "ISBN" + quote + ":" + quote+ ISBN+ quote+ "," + '\n');

            if (title!=null)
                sb.append(  quote + "title" + quote + ":" + title+ "," + '\n');

            if (person!=null)
                sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');

            if (title_transcription!=null)
                sb.append(  quote + "title_transcription" + quote + ":" +  title_transcription+  "," + '\n');

            if (alternative!=null)
                sb.append(  quote + "alternative" + quote + ":" +  alternative+  "," + '\n');

            if (series_title!=null)
                sb.append(  quote + "series_title" + quote + ":" +  series_title+  "," + '\n');

            if (series_title_transcription!=null)
                sb.append(  quote + "series_title_transcription" + quote + ":" +  series_title_transcription+  "," + '\n');

            if (subject!=null)
                sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

            if (language!=null)
                sb.append(  quote + "language" + quote + ":" +  quote +language+ quote + "," + '\n');

            if (assetid_page!=null)
                sb.append(  quote + "asset-id-object" + quote + ":" + quote+ assetid_page+ quote+ "," + '\n');

            if (format!=null)
                sb.append(  quote + "format" + quote + ":" + quote+ format+ quote+ "," + '\n');

            if (date_original!=null)
                sb.append(  quote + "date-original" + quote + ":" + quote+ date_original+ quote+ "," + '\n');

            if (journal_title!=null)
                sb.append(  quote + "journal-title" + quote + ":" + quote+ journal_title+ quote+ "," + '\n');

            if (asset_id!=null)
                sb.append(  quote + "asset-id-page" + quote + ":" + quote+ asset_id+ quote+ "," + '\n');

            if (volume_number!=null)
                sb.append(  quote + "volume-number" + quote + ":" + quote+ volume_number+ quote+ "," + '\n');

            if (description!=null)
                sb.append(  quote + "description" + quote + ":" + quote+ description+ quote+ "," + '\n');

            if (publication_place!=null)
                sb.append(  quote + "publication_place" + quote + ":" +  publication_place+  "," + '\n');

            if (publication_volume!=null)
                sb.append(  quote + "publication-volume" + quote + ":" + quote+ publication_volume+ quote+ "," + '\n');

            if (page_range!=null)
                sb.append(  quote + "page-range" + quote + ":" + quote+ page_range+ quote+ "," + '\n');

            if (text!=null)
                sb.append(  quote + "text" + quote + ":" + quote+ text+ quote+ "," + '\n');

            sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
            //sb.append(  quote + "physical_description" + quote + ":" + "["+quote+"electronic"+quote +"]"+ "," + '\n' );
            sb.append(  quote + "collection" + quote + ":" + quote+  "Local Gazetteer (Diaolong)" +quote + '\n' );

            sb.append("},");
        }

        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}

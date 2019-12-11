package org.crossasia.collections.adammethewjapan;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class AddPersonToBook {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ajax-fo-china-japan/books2_NEW.json";
        String books_WithPersons = "/data1/solr/ajax-fo-china-japan/books2.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-fo-china-japan/books2_LAST.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray booksWithPersonsObject = new JSONArray(new JSONTokener(new FileInputStream(books_WithPersons)));

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<booksObject.length(); i++) {
            String id = "";
            String book_id = "";
            String identifier = "";
            JSONArray keywords = null;
            JSONArray edition =null;
            JSONArray spatial = null;
            String url ="";
            String publisher = "";
            JSONArray medium = null;
            String erflink ="";
            String date = "";
            String title = "";
            JSONArray series_title=null;
            JSONArray subject = null;
            String language ="";
            JSONArray description=null;

            String id_person = "";
            JSONObject booksObj = (JSONObject) booksObject.get(i);

            id = (String) booksObj.get("id").toString();
            book_id = (String) booksObj.get("book_id").toString();
            identifier = (String) booksObj.get("identifier").toString();

            if (booksObj.has("keywords"))
                keywords = (JSONArray) booksObj.get("keywords");

            if (booksObj.has("edition"))
                edition = (JSONArray) booksObj.get("edition");

            if (booksObj.has("spatial"))
                spatial = (JSONArray) booksObj.get("spatial");

            url = (String) booksObj.get("url").toString();

            if (booksObj.has("publisher"))
                publisher = (String) booksObj.get("publisher").toString();

            if (booksObj.has("medium"))
                medium = (JSONArray) booksObj.get("medium");

            erflink = (String) booksObj.get("erflink").toString();

            if (booksObj.has("date")) {
                if (booksObj.get("date").toString().length()==8){
                    date = (String) booksObj.get("date").toString().substring(0,4);
                }else {
                    date = (String) booksObj.get("date").toString();
                }
            }

            if (booksObj.has("title"))
                title = (String) booksObj.get("title");

            if (booksObj.has("series_title"))
                series_title =(JSONArray) booksObj.get("series_title");

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("description"))
                description =(JSONArray) booksObj.get("description");

            if (booksObj.has("language"))
                language  = (String) booksObj.get("language");

            for (int j=0; j<booksWithPersonsObject.length(); j++) {
                JSONObject booksObjWithPerson = (JSONObject) booksWithPersonsObject.get(j);
                id_person = (String) booksObjWithPerson.get("id").toString();

                JSONArray person = null;
                if (booksObjWithPerson.has("person"))
                    person = (JSONArray) booksObjWithPerson.get("person");

                if (id.equals(id_person)){
                    sb.append("{"+ '\n');
                    sb.append(  quote + "id" + quote + ":" + quote+ id+ quote + "," + '\n' );
                    sb.append(  quote + "book_id" + quote + ":" + quote+ book_id+ quote + "," + '\n' );
                    if (identifier!=null)
                        sb.append(  quote + "identifier" + quote + ":" + quote+ identifier+ quote+  "," + '\n');

                    if (keywords!=null)
                        sb.append(  quote + "keywords" + quote + ":" +  keywords+  "," + '\n');

                    if (edition!=null)
                        sb.append(  quote + "edition" + quote + ":" +  edition+  "," + '\n');

                    if (spatial!=null)
                        sb.append(  quote + "spatial" + quote + ":" +  spatial+  "," + '\n');

                    if (url!=null)
                        sb.append(  quote + "url" + quote + ":" + quote+ url+ quote + "," + '\n');

                    if (publisher!=null)
                        sb.append(  quote + "publisher" + quote + ":" + quote+ publisher+ quote+ "," + '\n');

                    if (medium!=null)
                        sb.append(  quote + "medium" + quote + ":" +  medium+ "," + '\n');

                    if (erflink!=null)
                        sb.append(  quote + "erflink" + quote + ":" + quote+ erflink+ quote + "," + '\n');

                    if (date!=null)
                        sb.append(  quote + "date" + quote + ":" +   quote+ date+  quote+  "," + '\n');

                    if (title!=null)
                        sb.append(  quote + "title" + quote + ":" + quote+title+ quote+"," + '\n');

                    if (series_title!=null)
                        sb.append(  quote + "series_title" + quote + ":" +  series_title+  "," + '\n');

                    if (subject!=null)
                        sb.append(  quote + "subject" + quote + ":" +  subject+  "," + '\n');

                    if (language!=null)
                        sb.append(  quote + "language" + quote + ":" +  quote +language+ quote + "," + '\n');

                    if (person!=null)
                        sb.append(  quote + "person" + quote + ":" +  person+  "," + '\n');

                    if (description!=null)
                        sb.append(  quote + "description" + quote + ":" +  description+  "," + '\n');

                    sb.append(  quote + "hasModel" + quote + ":" + quote+ "Page"+ quote + "," + '\n' );
                    sb.append(  quote + "collection" + quote + ":" + quote+  "Adam Matthew - Foreign Office Files China & Japan" +quote + '\n' );

                    sb.append("},");
                }

            }

        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

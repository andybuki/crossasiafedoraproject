package org.crossasia.solr.collections.sbby;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BookPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data1/solr/ajax-sbby/books_new.json";
        String pages = "/data1/solr/ajax-sbby/pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-sbby/books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String url ="";
            String erflink = "";
            String book_id = "";
            JSONArray title = null;
            String date = "";
            String language = "";
            String publisher ="";

            JSONArray author=null;
            JSONArray edition=null;
            JSONArray subject=null;


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();


            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();


            if (booksObj.has("title"))
                title =(JSONArray) booksObj.get("title");

            if (booksObj.has("author"))
                author =(JSONArray) booksObj.get("author");

            if (booksObj.has("edition"))
                edition =(JSONArray) booksObj.get("edition");

            if (booksObj.has("subject"))
                subject =(JSONArray) booksObj.get("subject");

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("language"))
                language =(String) booksObj.get("language").toString();

            if (booksObj.has("publisher"))
                publisher =(String) booksObj.get("publisher").toString();

            int position=0;
            for (int j=0; j<pagesObject.length();j++) {

                String book_id_page="";
                String id ="";

                String text="";
                String xml_file="";
                String chapter_title="";

                JSONObject pagesObj = (JSONObject) pagesObject.get(j);

                try {

                    if (pagesObj.has("text")) {
                        text = (String) pagesObj.get("text");
                    }

                    id = (String) pagesObj.get("id").toString().replace(".xml","").replace("/","-");
                    book_id_page = (String) pagesObj.get("book_id").toString();

                    if (pagesObj.has("position"))
                        position =(Integer) pagesObj.get("position");

                    if (pagesObj.has("chapter_title"))
                        chapter_title =(String) pagesObj.get("chapter_title").toString();

                    if (pagesObj.has("xml_file"))
                        xml_file =(String) pagesObj.get("xml_file").toString();



                    if (text.equals("")){
                        System.out.println("NO text"+ id);
                    }
                    else  {
                        if (book_id.equals(book_id_page)) {
                            sb.append("{" + '\n');
                            sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                            sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');

                            if (title != null)
                                sb.append(quote + "title" + quote + ":" + title +  "," + '\n');

                            if (author != null)
                                sb.append(quote + "author" + quote + ":" + author  + "," + '\n');

                            if (edition != null)
                                sb.append(quote + "edition" + quote + ":" + edition  + "," + '\n');

                            if (subject != null)
                                sb.append(quote + "subject" + quote + ":" + subject  + "," + '\n');

                            if (publisher != "")
                                sb.append(quote + "publisher" + quote + ":" + quote + publisher + quote + "," + '\n');

                            if (date != "")
                                sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');

                            if (position != 0)
                                sb.append(quote + "position" + quote + ":" + quote + position + quote + "," + '\n');

                            if (text != "")
                                sb.append(quote + "text" + quote + ":" + quote + text + quote + "," + '\n');

                            if (chapter_title != "")
                                sb.append(quote + "chapter_title" + quote + ":" + quote + chapter_title + quote + "," + '\n');

                            if (xml_file != "")
                                sb.append(quote + "xml_file" + quote + ":" + quote + xml_file + quote + "," + '\n');

                            if (url != "")
                                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

                            if (erflink != "")
                                sb.append(quote + "erflink" + quote + ":" + quote + erflink + quote + "," + '\n');

                            if (language != "")
                                sb.append(quote + "language" + quote + ":" +  language + "," + '\n');


                            sb.append(quote + "hasModel" + quote + ":" +  quote + "Page" +  quote +  "," + '\n');
                            sb.append(quote + "collection" + quote + ":" + quote +  "Sibu beiyao" +quote + '\n');

                            sb.append("},");
                        } else {
                            //System.out.println("NO: "+book_id);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(book_id_page+"NOT WORKING");
                }

                //System.out.println(booksObj);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");
    }
}

package org.crossasia.solr.collections.iseas;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class IseasBookPage {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String books = "/data/solr/ajax-iseas/books2.json";
        String pages = "/data/solr/ajax-iseas/pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/ajax-iseas/books_pages.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            String url ="";
            String erflink = "";
            String book_id = "";
            String collection = "";
            JSONArray title = null;
            JSONArray date = null;
            JSONArray language = null;
            JSONArray description = null;
            JSONArray author =null;
            JSONArray edition =null;
            JSONArray publisher =null;
            JSONArray subject =null;
            JSONArray responsibility =null;


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("book_id").toString();

            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();

            if (booksObj.has("collection"))
                collection =(String) booksObj.get("collection").toString();

            if (booksObj.has("title"))
                title = (JSONArray) booksObj.get("title");

            if (booksObj.has("responsibility"))
                responsibility = (JSONArray) booksObj.get("responsibility");

            if (booksObj.has("date"))
                date =(JSONArray) booksObj.get("date");

            if (booksObj.has("language"))
                language =(JSONArray) booksObj.get("language");

            if (booksObj.has("publisher"))
                publisher =(JSONArray) booksObj.get("publisher");

            if (booksObj.has("description"))
                description =(JSONArray) booksObj.get("description");
            if (booksObj.has("author")) {
                author  = (JSONArray) booksObj.get("author");
            }
            if (booksObj.has("edition")) {
                edition  = (JSONArray) booksObj.get("edition");
            }
            if (booksObj.has("subject")) {
                subject  = (JSONArray) booksObj.get("subject");
            }

            for (int j=0; j<pagesObject.length();j++) {
                String publisher2 = "";
                String book_id_page="";
                String id ="";
                String identifier="";

                String volume="";
                String position="";
                String page_id="";
                JSONArray text=null;
                String image_url="";
                String xml_file="";




                String issued = "";

                String medium = "";




                String publication_place = "";


                JSONObject pagesObj = (JSONObject) pagesObject.get(j);

                try {

                    if (pagesObj.has("text")) {
                        text = (JSONArray) pagesObj.get("text");
                    }

                    id = (String) pagesObj.get("id").toString().replace("/","_").replace(".xml","");

                    position = (String) pagesObj.get("position").toString();

                    book_id_page = (String) pagesObj.get("book_id").toString();

                    if (pagesObj.has("xml_file")) {
                        xml_file  = (String) pagesObj.get("xml_file");
                    }


                    if (text.equals("")){
                        System.out.println("NO text");
                    }
                    else  {
                        if (book_id.equals(book_id_page)) {
                            sb.append("{" + '\n');
                            sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                            sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');


                            if (title != null)
                                sb.append(quote + "title" + quote + ":" +  title  + "," + '\n');

                            if (publisher != null)
                                sb.append(quote + "publisher" + quote + ":" +  publisher  + "," + '\n');

                            if (medium != "")
                                sb.append(quote + "medium" + quote + ":" + quote + medium + quote + "," + '\n');

                            if (xml_file != "")
                                sb.append(quote + "xml_file" + quote + ":" + quote + xml_file + quote + "," + '\n');

                            if (date != null)
                                sb.append(quote + "date" + quote + ":" +  date +  "," + '\n');

                            if (responsibility != null)
                                sb.append(quote + "responsibility" + quote + ":" +  responsibility +  "," + '\n');

                            if (position != "")
                                sb.append(quote + "position" + quote + ":" + quote + position + quote + "," + '\n');

                            if (description != null)
                                //sb.append(quote + "description" + quote + ":" +  description  + "," + '\n');

                            if (author != null)
                                sb.append(quote + "author" + quote + ":" +  author  + "," + '\n');

                            if (edition != null)
                                sb.append(quote + "edition" + quote + ":" +  edition  + "," + '\n');

                            if (subject != null)
                                sb.append(quote + "subject" + quote + ":" +  subject  + "," + '\n');

                            if (text != null)
                                sb.append(quote + "text" + quote + ":" +  text +  "," + '\n');

                            if (url != "")
                                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

                            if (erflink != "")
                                sb.append(quote + "erflink" + quote + ":" + quote + erflink + quote + "," + '\n');


                            if (language != null)
                                sb.append(quote + "language" + quote + ":" +  language +  "," + '\n');

                            sb.append(quote + "hasModel" + quote + ":" + quote + "Page" + quote  + "," + '\n');
                            sb.append(quote + "collection" + quote + ":" + quote + collection + quote + "" + '\n');

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

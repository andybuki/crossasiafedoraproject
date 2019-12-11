package org.crossasia.collections.brill_meao;

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
        String books = "/data1/solr/ajax-brill-meao/books.json";
        String pages = "/data1/solr/ajax-brill-meao/pages.json";
        PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-brill-meao/books_pages2.json"));

        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {

            //String author ="";


            String url ="";
            String erflink = "";
            String book_id = "";
            String collection = "";
            String title = "";
            String date = "";
            String language = "";
            String description = "";


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            book_id = (String) booksObj.get("source").toString();
            String segments[] = book_id.split("/");
            int len = segments.length;

            if (segments.length==3) {
                book_id = (segments[segments.length - 2]) +"_"+(segments[segments.length - 1]);
            } else if (segments.length==2) {
                book_id = (segments[segments.length - 2]) +"_"+(segments[segments.length - 1]);
            } else if (segments.length==4) {
                book_id = (segments[segments.length - 3]) +"_"+(segments[segments.length - 2])+"_"+(segments[segments.length - 1]);
            }
            else {
                System.out.println("Length is not right: "+ book_id);
            }


            if (booksObj.has("url"))
                url =(String) booksObj.get("url").toString();

            if (booksObj.has("erflink"))
                erflink =(String) booksObj.get("erflink").toString();

            if (booksObj.has("collection"))
                collection =(String) booksObj.get("collection").toString();

            if (booksObj.has("title"))
                title =(String) booksObj.get("title").toString();

            if (booksObj.has("date"))
                date =(String) booksObj.get("date").toString();

            if (booksObj.has("language"))
                language =(String) booksObj.get("language").toString();

            if (booksObj.has("description"))
                description =(String) booksObj.get("description").toString();


            for (int j=0; j<pagesObject.length();j++) {
                String publisher = "";
                String book_id_page="";
                String id ="";
                String identifier="";

                String volume="";
                String position="";
                String page_id="";
                String text="";
                String image_url="";
                String image="";

                String edition ="";


                String issued = "";

                String medium = "";
                JSONArray subject = null;

                JSONArray person = null;
                JSONArray spatial = null;
                JSONArray keywords = null;
                JSONArray author = null;
                JSONArray alternative = null;

                String publication_place = "";


                JSONObject pagesObj = (JSONObject) pagesObject.get(j);

                try {

                    if (pagesObj.has("text")) {
                        text = (String) pagesObj.get("text");
                    }

                    id = (String) pagesObj.get("id").toString();

                    String segments_id[] = id.split("/");
                    id = segments_id[segments_id.length - 1];

                    String segments_position [] = id.split("_");
                    position = (segments_position[segments_position.length-1]).replaceFirst("^0+(?!$)","");

                    book_id_page = (String) pagesObj.get("id").toString();
                    String segments_page[] = book_id_page.split("/");

                    if (segments_page.length==4) {
                        book_id_page = (segments_page[segments_page.length - 4])+"_"+(segments_page[segments_page.length - 3])+"_"+(segments_page[segments_page.length - 2]);
                    } else if (segments_page.length==3) {
                        book_id_page = (segments_page[segments_page.length - 3])+"_"+(segments_page[segments_page.length - 2]);
                    } else {
                        System.out.println("ERROR Segments length: " + book_id_page);
                    }





                    if (text.equals("")){
                        //System.out.println("NO text");
                    }
                    else  {
                        if (book_id.equals(book_id_page)) {
                            sb.append("{" + '\n');
                            sb.append(quote + "id" + quote + ":" + quote + id + quote + "," + '\n');
                            sb.append(quote + "book_id" + quote + ":" + quote + book_id + quote + "," + '\n');


                            if (title != "")
                                sb.append(quote + "title" + quote + ":" + quote + title + quote + "," + '\n');

                            if (publisher != "")
                                sb.append(quote + "publisher" + quote + ":" + quote + publisher + quote + "," + '\n');

                            if (medium != "")
                                sb.append(quote + "medium" + quote + ":" + quote + medium + quote + "," + '\n');

                            if (date != "")
                                sb.append(quote + "date" + quote + ":" + quote + date + quote + "," + '\n');

                            if (position != "")
                                sb.append(quote + "position" + quote + ":" + quote + position + quote + "," + '\n');

                            if (description != "")
                                sb.append(quote + "description" + quote + ":" + quote + description + quote + "," + '\n');

                            if (text != "")
                                sb.append(quote + "text" + quote + ":" + quote + text + quote + "," + '\n');

                            if (url != "")
                                sb.append(quote + "url" + quote + ":" + quote + url + quote + "," + '\n');

                            if (erflink != "")
                                sb.append(quote + "erflink" + quote + ":" + quote + erflink + quote + "," + '\n');


                            if (language != "")
                                sb.append(quote + "language" + quote + ":" + quote + language + quote + "," + '\n');

                            sb.append(quote + "hasModel" + quote + ":" + "[" + quote + "Page" + "," + "Issue" + quote + "]" + "," + '\n');
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

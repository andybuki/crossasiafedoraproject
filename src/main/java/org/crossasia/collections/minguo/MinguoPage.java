package org.crossasia.collections.minguo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MinguoPage {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream out = new PrintStream(new FileOutputStream("/data3/solr/minguo/Minguo_Nachlieferung.txt"));
        String books = "/data3/solr/minguo/Minguo_Nachlieferung.json";
        String quote = "\u005c\u0022";
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        String line = "\u007C";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            String edition ="";
            String responsibility ="";
            String url ="";
            String id ="";
            String ids = "";

            int book_id = 0;
            int page = 0;
            String position = "";
            String title = "";
            String text = "";

            String identifier = "";


            JSONObject booksObj = (JSONObject) booksObject.get(i);
            page = (int) Integer.parseInt((String) booksObj.get("position"));
            ids = (String) booksObj.get("book_id");
            id = ids+"_"+page;
            book_id = (int) Integer.parseInt((String) booksObj.get("book_id"));
            position = (String) booksObj.get("position");

            identifier  = (String) booksObj.get("id").toString();

            if (booksObj.has("text")) {
                text  = (String) booksObj.get("text").toString().replaceAll("||","").replaceAll("\"","").replaceAll(line,"");
            }

            String book="Page";
            String lang ="chi";
            String collection ="Early Twentieth Century Chinese Books (1912-1949)";

            sb.append( id + "€" );
            sb.append( book_id + "€");
            sb.append( identifier + "€");
            sb.append( position + "€");

            if (text!=null)
                sb.append( text + "€");
            else
                sb.append("€");
            sb.append(book + "€");
            sb.append(collection  + '\n');


        }
        out.println(sb);
    }
    }


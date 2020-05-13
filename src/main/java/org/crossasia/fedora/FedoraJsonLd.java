package org.crossasia.fedora;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FedoraJsonLd {
    public static void main(String[] args) throws FileNotFoundException {

        //String quote = "\u005c\u0022";
        //String books = "/data1/solr/ajax-diaolong-yldd/books_new.json";
        //String pages = "/data1/solr/ajax-diaolong-yldd/pages.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FedoraTypes[] fedoraTypes = objectMapper.readValue(new File("/data1/solr/ajax-diaolong-yldd/test.json"), FedoraTypes[].class);
            printParsedBooks();
            //PrintStream out = new PrintStream(new FileOutputStream("/data1/solr/ajax-diaolong-yldd/books_pages.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        /*JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONArray pagesObject = new JSONArray(new JSONTokener(new FileInputStream(pages)));


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<booksObject.length(); i++) {
            JSONObject booksObj = (JSONObject) booksObject.get(i);
            FedoraTypes fedoraTypes = new FedoraTypes();



            if (booksObj.has(fedoraTypes.getBook_id()))
                System.out.println(fedoraTypes.getBook_id());
            else {
                System.out.println("NO");
            }

        }*/

    }

    private static void printParsedBooks() throws FileNotFoundException {
        String books = "/data1/solr/ajax-diaolong-yldd/books.json";
        System.out.println();
        StringBuilder sb = new StringBuilder();
        JSONArray booksObject = new JSONArray(new JSONTokener(new FileInputStream(books)));
        JSONObject booksObj = (JSONObject) booksObject.get(1);
        FedoraTypes fedoraTypes = new FedoraTypes();
        System.out.println(fedoraTypes.getBook_id());

    }
}

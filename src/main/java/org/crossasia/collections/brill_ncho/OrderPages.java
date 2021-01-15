package org.crossasia.collections.brill_ncho;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderPages {
    public static void main(String[] args) throws FileNotFoundException {
        String quote = "\u005c\u0022";
        String pages = "/data/solr/OLD/ajax-brill-ncho/pages4.json";
        StringBuilder sb = new StringBuilder();
        JSONArray jsonArrayPages = new JSONArray(new JSONTokener(new FileInputStream(pages)));
        JSONArray sortedArray = new JSONArray();
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/OLD/ajax-brill-ncho/pages_sort4.json"));

        List list = new ArrayList();
        for (int i = 0; i< jsonArrayPages.length(); i++) {
            list.add(jsonArrayPages.getJSONObject(i));
        }

        //System.out.println(jsonArrayPages);

        Collections.sort(list, new Comparator<JSONObject>() {

            private static final String ID = "id";

            @Override
            public int compare (JSONObject a, JSONObject b) {
                String str1 = new String();
                String str2 = new String();

                try {
                    str1 = (String) a.get(ID);
                    str2 = (String) b.get(ID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return str1.compareTo(str2);
            }
        });
        for (int i = 0; i< jsonArrayPages.length(); i++) {
            sortedArray.put(list.get(i));

        }
        //System.out.println(sortedArray);
        out.println(sortedArray);
    }
}

package org.crossasia.collections.airiti;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

public class AiritiNestedAgregation {
    public static void main( String[] args ) throws Exception {
        //File dir = new File("D:\\SOLR-COLLECTIONS\\AIRITI\\Nested\\");
        PrintStream out = new PrintStream(new FileOutputStream("D:\\SOLR-COLLECTIONS\\AIRITI\\Nested\\metadata_new.json"));
        String bookName = "";

        String text = "";
        String quote = "\u005c\u0022";

        File metadata = new File("D:\\SOLR-COLLECTIONS\\AIRITI\\Nested\\metadata.json");
        File page = new File("D:\\SOLR-COLLECTIONS\\AIRITI\\Nested\\page2.json");

        if (metadata.exists()&& page.exists()){
            InputStream meta = new FileInputStream("D:\\SOLR-COLLECTIONS\\AIRITI\\Nested\\metadata.json");
            InputStream pages = new FileInputStream("D:\\SOLR-COLLECTIONS\\AIRITI\\Nested\\page2.json");
            String jsonMeta = IOUtils.toString(meta, "UTF-8");
            String jsonPages = IOUtils.toString(pages, "UTF-8");

            //System.out.println(jsonTxt);
            JSONObject jsonMetaObject = new JSONObject(jsonMeta);
            JSONObject jsonPagesObject = new JSONObject(jsonPages);

            JSONObject mergedJSON = mergeJSONObjects(jsonMetaObject, jsonPagesObject);

            System.out.println(mergedJSON);
            out.println(mergedJSON);

        }
    }

    public static JSONObject mergeJSONObjects(JSONObject jsonMetaObject, JSONObject jsonPagesObject) {
        JSONObject mergedJSON = new JSONObject();
        JSONObject mergedJSON2 = new JSONObject();
        try {
            mergedJSON = new JSONObject(jsonMetaObject, JSONObject.getNames(jsonMetaObject));
            mergedJSON2 = new JSONObject(jsonPagesObject, JSONObject.getNames(jsonPagesObject));

            String metadata_book_id = (String) mergedJSON.get("book_id");
            String page_book_id = (String) mergedJSON2.get("book_id");

            if (metadata_book_id.equals(page_book_id)) {
                for (String book_id : JSONObject.getNames(jsonPagesObject)) {

                    mergedJSON.put(book_id,  jsonPagesObject.get(book_id));
                    mergedJSON.put("_childNodes_",mergedJSON2);
                }

            }



        } catch (JSONException e) {
            throw new RuntimeException("JSON Exception" + e);
        }
        return mergedJSON;
    }
}

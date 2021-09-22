package org.crossasia.solr.types;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.solr.constants.Constants.QUOTE;
import static org.crossasia.solr.main.CreateBookSolr.jsonObj;

public class KeywordImpl implements Edition{

    public static StringBuilder addDescriptions() throws FileNotFoundException {
        JSONArray keywords = null;
        String keyword ="";
        StringBuilder keywordBuilder = new StringBuilder();

        if (jsonObj.has("keyword")) {

            if ((jsonObj.get("keyword")) instanceof JSONArray) {
                keywords = (JSONArray) jsonObj.get("keyword");

                if (keywords != null) {
                    keywordBuilder.append(QUOTE + "keyword" + QUOTE + ":" +  keywords +  "," + '\n');
                    return keywordBuilder;
                } else {
                    return new StringBuilder();
                }
            } else {
                keyword = (String) jsonObj.get("keyword");
                if (keyword != "") {
                    keywordBuilder.append(QUOTE + "keyword" + QUOTE + ":" + QUOTE+  keyword + QUOTE+ "," + '\n');
                    return keywordBuilder;
                } else {
                    return new StringBuilder();
                }

            }
        } else {
                return new StringBuilder();
        }
    }
}

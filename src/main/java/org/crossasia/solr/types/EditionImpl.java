package org.crossasia.solr.types;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.solr.constants.Constants.QUOTE;
import static org.crossasia.solr.main.CreateBookSolr.jsonObj;

public class EditionImpl implements Edition{

    public static StringBuilder addEditions() throws FileNotFoundException {
        JSONArray editions = null;
        String edition ="";
        StringBuilder editionBuilder = new StringBuilder();

        if (jsonObj.has("edition")) {

            if ((jsonObj.get("edition")) instanceof JSONArray) {
                editions = (JSONArray) jsonObj.get("edition");

                if (editions != null) {
                    editionBuilder.append(QUOTE + "edition" + QUOTE + ":" +  editions +  "," + '\n');
                    return editionBuilder;
                } else {
                    return new StringBuilder();
                }
            } else {
                edition = (String) jsonObj.get("edition");
                if (edition != "") {
                    editionBuilder.append(QUOTE + "edition" + QUOTE + ":" + QUOTE+  edition + QUOTE+ "," + '\n');
                    return editionBuilder;
                } else {
                    return new StringBuilder();
                }

            }
        } else {
                return new StringBuilder();
        }
    }
}

package org.crossasia.solr.types;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.solr.constants.Constants.QUOTE;
import static org.crossasia.solr.main.CreateBookSolr.jsonObj;

public class MediumImpl implements Medium {
    public static StringBuilder addMedium() throws FileNotFoundException {
        JSONArray mediums = null;
        String medium ="";
        StringBuilder mediumsBuilder = new StringBuilder();

        if (jsonObj.has("medium")) {

            if ((jsonObj.get("medium")) instanceof JSONArray) {
                mediums = (JSONArray) jsonObj.get("medium");

                if (mediums != null) {
                    mediumsBuilder.append(QUOTE + "medium" + QUOTE + ":" +  mediums +  "," + '\n');
                    return mediumsBuilder;
                } else {
                    return new StringBuilder();
                }
            } else {
                medium = (String) jsonObj.get("medium");
                if (medium != "") {
                    mediumsBuilder.append(QUOTE + "medium" + QUOTE + ":" + QUOTE+  medium + QUOTE+ "," + '\n');
                    return mediumsBuilder;
                } else {
                    return new StringBuilder();
                }

            }
        } else {
            return new StringBuilder();
        }
    }
}

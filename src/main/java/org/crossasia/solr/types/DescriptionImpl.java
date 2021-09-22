package org.crossasia.solr.types;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.solr.constants.Constants.QUOTE;
import static org.crossasia.solr.main.CreateBookSolr.jsonObj;

public class DescriptionImpl implements Edition{

    public static StringBuilder addDescriptions() throws FileNotFoundException {
        JSONArray descriptions = null;
        String description ="";
        StringBuilder descriptionBuilder = new StringBuilder();

        if (jsonObj.has("description")) {

            if ((jsonObj.get("description")) instanceof JSONArray) {
                descriptions = (JSONArray) jsonObj.get("description");

                if (descriptions != null) {
                    descriptionBuilder.append(QUOTE + "description" + QUOTE + ":" +  descriptions +  "," + '\n');
                    return descriptionBuilder;
                } else {
                    return new StringBuilder();
                }
            } else {
                description = (String) jsonObj.get("description");
                if (description != "") {
                    descriptionBuilder.append(QUOTE + "description" + QUOTE + ":" + QUOTE+  description + QUOTE+ "," + '\n');
                    return descriptionBuilder;
                } else {
                    return new StringBuilder();
                }

            }
        } else {
                return new StringBuilder();
        }
    }
}

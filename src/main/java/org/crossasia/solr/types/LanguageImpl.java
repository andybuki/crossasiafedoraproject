package org.crossasia.solr.types;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.solr.main.CreateBookSolr.jsonObj;
import static org.crossasia.solr.constants.Constants.QUOTE;

public class LanguageImpl implements Language{

    public static StringBuilder addLanguages() throws FileNotFoundException {
        JSONArray languages = null;
        String language ="";
        StringBuilder languageBuilder = new StringBuilder();

        if (jsonObj.has("language")) {

            if ((jsonObj.get("language")) instanceof JSONArray) {
                languages = (JSONArray) jsonObj.get("language");

                if (languages != null) {
                    languageBuilder.append(QUOTE + "language" + QUOTE + ":" +  languages +  "," + '\n');
                    return languageBuilder;
                } else {
                    return new StringBuilder();
                }
            } else {
                language = (String) jsonObj.get("language");
                if (language != "") {
                    languageBuilder.append(QUOTE + "language" + QUOTE + ":" + QUOTE+  language + QUOTE+ "," + '\n');
                    return languageBuilder;
                } else {
                    return new StringBuilder();
                }

            }
        } else {
                return new StringBuilder();
        }
    }
}

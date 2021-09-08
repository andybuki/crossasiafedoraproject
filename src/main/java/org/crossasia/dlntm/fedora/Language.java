package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Language {
    public static StringBuilder addLanguages() throws FileNotFoundException {

        JSONArray languages = null;
        JSONArray languages_lao = null;
        JSONArray languagesList = new JSONArray();

        StringBuilder languageBuilder = new StringBuilder();

        if (jsonObj.has("language")) {
            languages = (JSONArray) jsonObj.get("language");
        }

        if (jsonObj.has("language_th")) {
            languages_lao = (JSONArray) jsonObj.get("language_th");
        }

        if (languages!=null) {
            for (int k = 0;  k< languages.length(); k++ ){
                for (int l =0; l<languages_lao.length(); l++) {
                    languagesList.put(languages.get(k));
                    languagesList.put(languages_lao.get(l));
                }
            }
        }

        if (languages != null || languages_lao!=null) {
            languageBuilder.append(QUOTE + "dc:language" + QUOTE + ":" +  languagesList+  "," + '\n');
            return languageBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

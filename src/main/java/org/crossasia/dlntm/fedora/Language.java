package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Language {
    public static StringBuilder addLanguages() throws FileNotFoundException {

        JSONArray languages = null;
        JSONArray languages_lao = null;


        StringBuilder languageBuilder = new StringBuilder();

        if (jsonObj.has("language")) {
            languages = (JSONArray) jsonObj.get("language");
        }

        if (jsonObj.has("language_th")) {
            languages_lao = (JSONArray) jsonObj.get("language_th");
        }

        if (languages != null ) {
            languageBuilder.append(QUOTE + "dc:language" + QUOTE + ":" +  languages+  "," + '\n');
        }

        if (languages_lao!=null) {
            languageBuilder.append(QUOTE + "dllm:language_th" + QUOTE + ":" +  languages_lao+  "," + '\n');
        }
    return languageBuilder;
    }
}

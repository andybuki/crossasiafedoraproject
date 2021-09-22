package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Keywords {
    public static StringBuilder addKeywords() throws FileNotFoundException {

        JSONArray term_roman = null;
        JSONArray term_leo = null;

        StringBuilder keywordsBuilder = new StringBuilder();

        if (jsonObj.has("ancillary_term")) {
            term_roman = (JSONArray) jsonObj.get("ancillary_term");
        }

        if (jsonObj.has("ancillary_term_th")) {
            term_leo = (JSONArray) jsonObj.get("ancillary_term_th");
        }

        if (term_roman != null ) {
                keywordsBuilder.append(QUOTE + "schema:keywords" + QUOTE + ":" +  term_roman+  "," + '\n');
        } if (term_leo!=null) {
            keywordsBuilder.append(QUOTE + "dllm:keywords_th" + QUOTE + ":" +  term_leo+  "," + '\n');
        }
        return keywordsBuilder;
    }
}

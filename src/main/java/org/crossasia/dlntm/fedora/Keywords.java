package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Keywords {
    public static StringBuilder addKeywords() throws FileNotFoundException {

        JSONArray term_roman = null;
        JSONArray term_leo = null;
        JSONArray terms = new JSONArray();

        StringBuilder keywordsBuilder = new StringBuilder();

        if (jsonObj.has("ancillary_term")) {
            term_roman = (JSONArray) jsonObj.get("ancillary_term");
        }

        if (jsonObj.has("ancillary_term_th")) {
            term_leo = (JSONArray) jsonObj.get("ancillary_term_th");
        }

        if (term_roman!=null) {
            for (int k = 0;  k< term_leo.length(); k++ ){
                for (int l =0; l<term_leo.length(); l++) {
                    terms.put(term_roman.get(k));
                    terms.put(term_leo.get(l));
                }
            }
        }

        if (term_roman != null || term_leo!=null) {
                keywordsBuilder.append(QUOTE + "schema:keywords" + QUOTE + ":" +  terms+  "," + '\n');
            return keywordsBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

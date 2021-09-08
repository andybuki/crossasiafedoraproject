package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Alternative {
    public static StringBuilder addAlternatives() throws FileNotFoundException {

        JSONArray alternative_label_ro  = null;
        JSONArray alternative_label_th = null;
        JSONArray alternatives = new JSONArray();

        StringBuilder alternativeBuilder = new StringBuilder();

        if (jsonObj.has("alternative_label_ro")) {
            alternative_label_ro = (JSONArray) jsonObj.get("alternative_label_ro");
        }

        if (jsonObj.has("alternative_label_th")) {
            alternative_label_th = (JSONArray) jsonObj.get("alternative_label_th");
        }

        if (alternative_label_ro!=null) {
            for (int k = 0; k < alternative_label_ro.length(); k++) {
                alternatives.put(alternative_label_ro.get(k));
            }
        } else alternatives = null;
        if (alternative_label_th!=null) {
            for (int l =0; l<alternative_label_th.length(); l++) {
                alternatives.put(alternative_label_th.get(l));
            }
        } else alternatives = null;

        if (alternatives!=null) {
            alternativeBuilder.append(QUOTE + "dc:alternative" + QUOTE + ":" +  alternatives+  "," + '\n');
            return alternativeBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

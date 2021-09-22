package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Alternative {
    public static StringBuilder addAlternatives() throws FileNotFoundException {

        JSONArray alternative_label_ro  = null;
        JSONArray alternative_label_th = null;

        StringBuilder alternativeBuilder = new StringBuilder();

        if (jsonObj.has("alternative_label_ro")) {
            alternative_label_ro = (JSONArray) jsonObj.get("alternative_label_ro");
        }

        if (jsonObj.has("alternative_label_th")) {
            alternative_label_th = (JSONArray) jsonObj.get("alternative_label_th");
        }


        if (alternative_label_ro!=null) {
            alternativeBuilder.append(QUOTE + "dc:alternative" + QUOTE + ":" +  alternative_label_ro+  "," + '\n');

        }  if (alternative_label_th!=null) {
            alternativeBuilder.append(QUOTE + "dllm:alternative_th" + QUOTE + ":" +  alternative_label_th+  "," + '\n');
        }
        return alternativeBuilder;
    }
}

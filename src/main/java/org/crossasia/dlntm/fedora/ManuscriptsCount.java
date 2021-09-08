package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class ManuscriptsCount {
    public static StringBuilder addManuscriptsCount() throws FileNotFoundException {
        JSONArray manuscripts_count = null;
        StringBuilder manuscriptsCountBuilder = new StringBuilder();

        if (jsonObj.has("manuscripts_count")) {
            manuscripts_count = (JSONArray) jsonObj.get("manuscripts_count");
        }
        if (manuscripts_count!= null) {
            manuscriptsCountBuilder.append(QUOTE + "dllm:manuscripts_count" + QUOTE + ":" +  manuscripts_count  + "," + '\n');
            return manuscriptsCountBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

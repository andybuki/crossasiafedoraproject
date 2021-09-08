package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Exact {
    public static StringBuilder addExact() throws FileNotFoundException {
        JSONArray exact = null;
        JSONArray exactList = new JSONArray();
        StringBuilder exactBuilder = new StringBuilder();

        if (jsonObj.has("exact")) {
            exact = (JSONArray) jsonObj.get("exact");
        }


        if (exact!=null&&exactList!=null) {
            for (int k = 0; k < exact.length(); k++) {
                exactList.put(exact.get(k));
            }
        } else exactList = null;

        if (exactList!= null) {
            exactBuilder.append(QUOTE + "dllm:exact_coordinates" + QUOTE + ":" +  exactList + "," + '\n');
            return exactBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

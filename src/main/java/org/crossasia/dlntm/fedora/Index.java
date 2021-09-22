package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Index {
    public static StringBuilder addIndexes() throws FileNotFoundException {

        JSONArray label = null;
        JSONArray label_ro = null;
        JSONArray pntmp_label = null;
        JSONArray indexList = new JSONArray();

        StringBuilder indexBuilder = new StringBuilder();

        if (jsonObj.has("label")) {
            label = (JSONArray) jsonObj.get("label");
        }

        if (jsonObj.has("label_ro")) {
            label_ro = (JSONArray) jsonObj.get("label_ro");
        }

        if (jsonObj.has("pntmp_label")) {
            pntmp_label = (JSONArray) jsonObj.get("pntmp_label");
        }

        if (label!=null) {
            for (int k = 0; k < label.length(); k++) {
                indexList.put(label.get(k));
            }
        }

        if (pntmp_label!=null) {
            for (int m = 0; m < pntmp_label.length(); m++) {
                indexList.put(pntmp_label.get(m));
            }
        }


        if (label_ro != null ) {
            indexBuilder.append(QUOTE + "dllm:index" + QUOTE + ":" + label_ro + "," + '\n');
        }

        if (indexList != null) {
            indexBuilder.append(QUOTE + "dllm:index_th" + QUOTE + ":" + indexList + "," + '\n');
        }

        return indexBuilder;

    }
}

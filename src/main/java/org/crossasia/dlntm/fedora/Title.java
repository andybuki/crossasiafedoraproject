package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Title {

    public static StringBuilder addTitles() throws FileNotFoundException {

        JSONArray dlntm_label_th = null;
        JSONArray dlntm_label_ro = null;
        JSONArray titleList = new JSONArray();

        StringBuilder titleBuilder = new StringBuilder();

        if (jsonObj.has("dlntm_label_th")) {
            dlntm_label_th = (JSONArray) jsonObj.get("dlntm_label_th");
        }

        if (jsonObj.has("dlntm_label_ro")) {
            dlntm_label_ro = (JSONArray) jsonObj.get("dlntm_label_ro");
        }

        if (dlntm_label_th!=null) {
            for (int k = 0; k < dlntm_label_th.length(); k++) {
                titleList.put(dlntm_label_th.get(k));
            }
        } else titleList = null;

        if (dlntm_label_ro!=null) {
            for (int l =0; l<dlntm_label_ro.length(); l++) {
                titleList.put(dlntm_label_ro.get(l));
            }
        } else titleList = null;

        if (titleList != null ) {
            titleBuilder.append(QUOTE + "dllm:title" + QUOTE + ":" +  titleList+  "," + '\n');
            return titleBuilder;
        } else {
            titleBuilder.append(QUOTE + "dllm:title" + QUOTE + ":" + QUOTE+  "No title" + QUOTE+  "," + '\n');
            return titleBuilder;
        }
    }
}

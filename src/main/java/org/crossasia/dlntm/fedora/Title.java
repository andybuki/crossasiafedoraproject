package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Title {

    public static StringBuilder addTitles() throws FileNotFoundException {

        JSONArray dlntm_label_th = null;
        JSONArray dlntm_label_ro = null;

        StringBuilder titleBuilder = new StringBuilder();

        if (jsonObj.has("dlntm_label_th")) {
            dlntm_label_th = (JSONArray) jsonObj.get("dlntm_label_th");
        }

        if (jsonObj.has("dlntm_label_ro")) {
            dlntm_label_ro = (JSONArray) jsonObj.get("dlntm_label_ro");
        }


        if (dlntm_label_ro != null ) {
            titleBuilder.append(QUOTE + "dc:title" + QUOTE + ":" + dlntm_label_ro + "," + '\n');
        }

        if (dlntm_label_th != null ) {
            titleBuilder.append(QUOTE + "dllm:title_th" + QUOTE + ":" +  dlntm_label_th+  "," + '\n');
        }

        if (dlntm_label_ro == null ) {
            titleBuilder.append(QUOTE + "dc:title" + QUOTE + ":" + QUOTE + "No title" + QUOTE + "," + '\n');
        }
        return titleBuilder;

    }
}

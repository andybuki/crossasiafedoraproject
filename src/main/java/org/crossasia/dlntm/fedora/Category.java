package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Category {
    public static StringBuilder addCategories() throws FileNotFoundException {

        JSONArray categories = null;
        JSONArray categories_lao = null;
        StringBuilder categoryBuilder = new StringBuilder();

        if (jsonObj.has("category")) {
            categories = (JSONArray) jsonObj.get("category");
        }

        if (jsonObj.has("category_th")) {
            categories_lao = (JSONArray) jsonObj.get("category_th");
        }


        if (categories != null ) {
            categoryBuilder.append(QUOTE + "dc:subject" + QUOTE + ":" +  categories+  "," + '\n');

        } if ( categories_lao!=null) {
            categoryBuilder.append(QUOTE + "dllm:subject_th" + QUOTE + ":" +  categories_lao+  "," + '\n');
        }
        return categoryBuilder;
    }
}

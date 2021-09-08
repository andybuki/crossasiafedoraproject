package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Category {
    public static StringBuilder addCategories() throws FileNotFoundException {

        JSONArray categories = null;
        JSONArray categories_lao = null;
        JSONArray categoriesList = new JSONArray();

        StringBuilder categoryBuilder = new StringBuilder();

        if (jsonObj.has("category")) {
            categories = (JSONArray) jsonObj.get("category");
        }

        if (jsonObj.has("category_th")) {
            categories_lao = (JSONArray) jsonObj.get("category_th");
        }

        if (categories!=null) {
            for (int k = 0; k < categories.length(); k++) {
                categoriesList.put(categories.get(k));
            }
        } else categoriesList = null;
        if (categories_lao!=null) {
                for (int l =0; l<categories_lao.length(); l++) {
                    categoriesList.put(categories_lao.get(l));
                }
        } else categoriesList = null;

        if (categories != null || categories_lao!=null) {
            categoryBuilder.append(QUOTE + "dc:subject" + QUOTE + ":" +  categoriesList+  "," + '\n');
            return categoryBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Website {
    public static StringBuilder addWebsite() throws FileNotFoundException {
        JSONArray website = null;
        StringBuilder websiteBuilder = new StringBuilder();

        if (jsonObj.has("website")) {
            website = (JSONArray) jsonObj.get("website");
        }
        if (website!= null) {
            websiteBuilder.append(QUOTE + "schema:url" + QUOTE + ":" +  website +  "," + '\n');
            return websiteBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

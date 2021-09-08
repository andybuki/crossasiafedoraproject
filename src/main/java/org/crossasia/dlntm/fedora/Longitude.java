package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Longitude {
    public static StringBuilder addLongitude() throws FileNotFoundException {
        JSONArray longitude = null;
        StringBuilder longitudeBuilder = new StringBuilder();

        if (jsonObj.has("longitude"))
            longitude = (JSONArray) jsonObj.get("longitude");

        if (longitude!= null) {
            longitudeBuilder.append(QUOTE + "schema:longitude" + QUOTE + ":" +  longitude  + "," + '\n');
            return longitudeBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

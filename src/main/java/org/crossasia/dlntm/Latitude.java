package org.crossasia.dlntm;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Latitude {
    public static StringBuilder addLatitude() throws FileNotFoundException {
        JSONArray latitude = null;
        StringBuilder latitudeBuilder = new StringBuilder();

        if (jsonObj.has("latitude"))
            latitude = (JSONArray) jsonObj.get("latitude");

        if (latitude!= null) {
            latitudeBuilder.append(QUOTE + "schema:latitude" + QUOTE + ":" +  latitude  + "," + '\n');
            return latitudeBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

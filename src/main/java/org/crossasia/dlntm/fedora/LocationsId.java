package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class LocationsId {
    public static StringBuilder addLocationsId() throws FileNotFoundException {
        int location_id = 0;
        StringBuilder locationsIdBuilder = new StringBuilder();

        if (jsonObj.has("location_id")) {
            location_id = (int) jsonObj.get("location_id");
        }
        if (location_id!= 0) {
            locationsIdBuilder.append(QUOTE + "dllm:location_id" + QUOTE + ":" +  location_id  + "," + '\n');
            return locationsIdBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

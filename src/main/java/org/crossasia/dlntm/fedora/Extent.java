package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Extent {
    public static StringBuilder addExtent() throws FileNotFoundException {
        int number_of_digital_images = 0;
        int number_of_fascicles = 0;
        int number_of_folios = 0;

        StringBuilder extentBuilder = new StringBuilder();

        if (jsonObj.has("number_of_digital_images")) {
            number_of_digital_images = (int) jsonObj.get("number_of_digital_images");
        }

        if (jsonObj.has("number_of_fascicles")) {
            number_of_fascicles = (int) jsonObj.get("number_of_fascicles");
        }

        if (jsonObj.has("number_of_folios")) {
            number_of_folios = (int) jsonObj.get("number_of_folios");
        }
                                                                                                        //16 fascicle(s), 342 folio(s)(99 img.)
        if (number_of_fascicles!=0 || number_of_digital_images!=0 || number_of_folios!=0) {
            extentBuilder.append(QUOTE + "dcterms:extent" + QUOTE + ":" + QUOTE+ number_of_fascicles + " fascicle(s), " + number_of_folios +" folio(s) " +"(" +number_of_digital_images+" img.)"+QUOTE+"," + '\n');
            return extentBuilder;
        } else {
            return new StringBuilder("");
        }
    }
}

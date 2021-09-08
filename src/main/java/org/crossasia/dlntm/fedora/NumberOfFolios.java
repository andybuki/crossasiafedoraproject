package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class NumberOfFolios {
    public static StringBuilder addNumberOfFolios() throws FileNotFoundException {
        int number_of_digital_images = 0;
        StringBuilder numberOfFasciclesBuilder = new StringBuilder();

        if (jsonObj.has("number_of_digital_images")) {
            number_of_digital_images = (int) jsonObj.get("number_of_digital_images");
        }
        if (number_of_digital_images!= 0) {
            numberOfFasciclesBuilder.append(QUOTE + "dllm:documents_number_of_folios" + QUOTE + ":" +  number_of_digital_images +  "," + '\n');
            return numberOfFasciclesBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class NumberOfFascicles {
    public static StringBuilder addNumberOfFascicles() throws FileNotFoundException {
        int number_of_fascicles = 0;
        StringBuilder numberOfFasciclesBuilder = new StringBuilder();

        if (jsonObj.has("number_of_fascicles")) {
            number_of_fascicles = (int) jsonObj.get("number_of_fascicles");
        }
        if (number_of_fascicles!= 0) {
            numberOfFasciclesBuilder.append(QUOTE + "dllm:documents_number_of_fascicles" + QUOTE + ":" +  number_of_fascicles +  "," + '\n');
            return numberOfFasciclesBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

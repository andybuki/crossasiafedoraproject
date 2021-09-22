package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class NumberOfFolios {
    public static StringBuilder addNumberOfFolios() throws FileNotFoundException {
        int number_of_folios = 0;
        StringBuilder numberOfFoliosBuilder = new StringBuilder();

        if (jsonObj.has("number_of_folios")) {
            number_of_folios = (int) jsonObj.get("number_of_folios");
        }
        if (number_of_folios!= 0) {
            numberOfFoliosBuilder.append(QUOTE + "dllm:documents_number_of_folios" + QUOTE + ":" +  number_of_folios +  "," + '\n');
            return numberOfFoliosBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Year {
    public static StringBuilder addYear() throws FileNotFoundException {
        int year = 0;
        StringBuilder yearBuilder = new StringBuilder();

        if (jsonObj.has("year")) {
            year = (int) jsonObj.get("year");
        }
        if (year!= 0) {
            yearBuilder.append(QUOTE + "dllm:year" + QUOTE + ":" +  year  + "," + '\n');
            return yearBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

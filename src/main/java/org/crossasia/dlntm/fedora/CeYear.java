package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class CeYear {
    public static StringBuilder addCeYear() throws FileNotFoundException {
        int ce_year = 0;
        StringBuilder ceYearBuilder = new StringBuilder();

        if (jsonObj.has("ce_year")) {
            ce_year = (int) jsonObj.get("ce_year");
        }
        if (ce_year!= 0) {
            ceYearBuilder.append(QUOTE + "dc:date" + QUOTE + ":" +  ce_year  + "," + '\n');
            return ceYearBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Description {
    public static StringBuilder addDescriptions() throws FileNotFoundException {

        String remarks = "";
        String thai_remarks = "";
        StringBuilder remarksBuilder = new StringBuilder();

        if (jsonObj.has("remarks")) {
            remarks = (String) jsonObj.get("remarks");
        }

        if (jsonObj.has("thai_remarks")) {
            thai_remarks = (String) jsonObj.get("thai_remarks");
        }

        if (remarks != "" ) {
            remarksBuilder.append(QUOTE + "dc:description" + QUOTE + ":" + QUOTE+ remarks+ QUOTE+ "," + '\n');

        } if (thai_remarks != "" ) {
            remarksBuilder.append(QUOTE + "dllm:description_th" + QUOTE + ":" + QUOTE+ thai_remarks+ QUOTE+ "," + '\n');
        }
        return remarksBuilder;
    }
}

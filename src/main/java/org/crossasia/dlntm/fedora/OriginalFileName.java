package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraPagesModify.jsonObjPage;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class OriginalFileName {
    public static StringBuilder addOriginalFileName() throws FileNotFoundException {
        String original_file_name = "";
        StringBuilder originalFileNameBuilder = new StringBuilder();

        if (jsonObjPage.has("original_file_name")) {
            original_file_name = (String) jsonObjPage.get("original_file_name").toString();
        }
        if (original_file_name!= "") {
            originalFileNameBuilder.append(QUOTE + "schema:image" + QUOTE + ":" + QUOTE + original_file_name + QUOTE + "," + '\n');
            return originalFileNameBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

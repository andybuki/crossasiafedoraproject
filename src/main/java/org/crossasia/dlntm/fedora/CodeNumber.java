package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class CodeNumber {
    public static StringBuilder addCodeNumber() throws FileNotFoundException {
            String code_number = "";
            StringBuilder fedoraId = new StringBuilder();

            if (jsonObj.has("code_number")) {
                code_number = (String) jsonObj.get("code_number").toString();
            }
            if (code_number!= "") {
                fedoraId.append(QUOTE + "schema:identifier" + QUOTE + ":" + QUOTE + code_number + QUOTE + "," + '\n');
                return fedoraId;
            } else {
                return new StringBuilder();
            }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Illustration {
    public static StringBuilder addIllustration() throws FileNotFoundException {

        boolean is_illustrated=false;
        String is_illustrated_str ="";
        StringBuilder illustrationBuilder = new StringBuilder();

        if (jsonObj.has("illustrated")) {
            is_illustrated = (boolean) jsonObj.get("illustrated");
            if (is_illustrated==false) {
                is_illustrated_str="No";
            }else {
                is_illustrated_str="Yes";
            }
        }

        if (is_illustrated_str!= "") {
            illustrationBuilder.append(QUOTE + "dllm:is_illustrated" + QUOTE + ":" + QUOTE+ is_illustrated_str+ QUOTE  + "," + '\n');
            return illustrationBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

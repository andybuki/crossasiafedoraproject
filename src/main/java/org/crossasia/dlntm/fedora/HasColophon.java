package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class HasColophon {
    public static StringBuilder addHasColophon() throws FileNotFoundException {

        boolean has_colophon=false;
        String has_colophon_str ="";
        StringBuilder hasColophonBuilder = new StringBuilder();

        if (jsonObj.has("has_colophon")) {
            has_colophon = (boolean) jsonObj.get("has_colophon");
            if (has_colophon==false) {
                has_colophon_str="No";
            }else {
                has_colophon_str="Yes";
            }
        }

        if (has_colophon_str!= "") {
            hasColophonBuilder.append(QUOTE + "dllm:has_colophon" + QUOTE + ":" + QUOTE+ has_colophon_str+ QUOTE  + "," + '\n');
            return hasColophonBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

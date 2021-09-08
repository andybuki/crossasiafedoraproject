package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraPagesModify.jsonObjPage;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Position {
    public static StringBuilder addPosition() throws FileNotFoundException {
        String position = "";
        StringBuilder positionBuilder = new StringBuilder();

        if (jsonObjPage.has("position")) {
            position = (String) jsonObjPage.get("position");
        }
        if (position!= "") {
            positionBuilder.append(QUOTE + "schema:position" + QUOTE + ":" +  position  + "," + '\n');
            return positionBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Legibility {
    public static StringBuilder addLegibility() throws FileNotFoundException {
        String legibility = "";
        String legibility_th = "";
        StringBuilder legibilityBuilder = new StringBuilder();
        List<String> legibilities = new ArrayList<>();

        if (jsonObj.has("legibility")) {
            legibility = (String) jsonObj.get("legibility").toString();
        }
        if (jsonObj.has("legibility_th")) {
            legibility_th = (String) jsonObj.get("legibility_th").toString();
        }

        legibilities.add(QUOTE+legibility+QUOTE);
        legibilities.add(QUOTE+legibility_th+QUOTE);

        if (legibility!= "") {
            legibilityBuilder.append(QUOTE + "dllm:legibilities" + QUOTE + ":" +  legibilities  + "," + '\n');
            return legibilityBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

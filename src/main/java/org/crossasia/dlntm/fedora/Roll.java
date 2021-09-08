package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Roll {
    public static StringBuilder addRoll() throws FileNotFoundException {
        String roll = "";
        StringBuilder rollBuilder = new StringBuilder();

        if (jsonObj.has("microfilm_roll_number")) {
            roll = (String) jsonObj.get("microfilm_roll_number").toString();
        }
        if (roll!= "") {
            rollBuilder.append(QUOTE + "dllm:roll" + QUOTE + ":" + QUOTE + roll + QUOTE + "," + '\n');
            return rollBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class DirectlyDigitised {
    public static StringBuilder addDirectlyDigitised() throws FileNotFoundException {

        boolean directly_digitised=false;
        String directly_digitised_str="";
        StringBuilder directlyDigitisedBuilder = new StringBuilder();

        if (jsonObj.has("directly_digitised")) {
            directly_digitised = (boolean) jsonObj.get("directly_digitised");
            if (directly_digitised==false){
                directly_digitised_str="No";
            }else{
                directly_digitised_str="Yes";
            }
        }

        if (directly_digitised_str!= "") {
            directlyDigitisedBuilder.append(QUOTE + "dllm:is_color" + QUOTE + ":" + QUOTE+ directly_digitised_str+ QUOTE  + "," + '\n');
            return directlyDigitisedBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Complete {
    public static StringBuilder addComplete() throws FileNotFoundException {

        boolean is_complete=false;
        String is_complete_str="";
        StringBuilder completeBuilder = new StringBuilder();

        if (jsonObj.has("complete")) {
            is_complete = (boolean) jsonObj.get("complete");
            if (is_complete==false){
                is_complete_str="No";
            }else{
                is_complete_str="Yes";
            }
        }

        if (is_complete_str!= "") {
            completeBuilder.append(QUOTE + "dllm:is_complete" + QUOTE + ":" + QUOTE+ is_complete_str+ QUOTE  + "," + '\n');
            return completeBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

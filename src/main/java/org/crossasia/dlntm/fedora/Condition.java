package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Condition {
    public static StringBuilder addCondition() throws FileNotFoundException {
        String condition = "";
        String condition_th = "";
        StringBuilder conditionBuilder = new StringBuilder();
        List<String> conditions = new ArrayList<>();

        if (jsonObj.has("condition")) {
            condition = (String) jsonObj.get("condition").toString();
        }
        if (jsonObj.has("condition_th")) {
            condition_th = (String) jsonObj.get("condition_th").toString();
        }

        if (condition!= "") {
            conditionBuilder.append(QUOTE + "dllm:conditions" + QUOTE + ":" + QUOTE+  condition +QUOTE + "," + '\n');
        }
        if (condition_th!="") {
            conditionBuilder.append(QUOTE + "dllm:conditions_th" + QUOTE + ":" + QUOTE+ condition_th +QUOTE + "," + '\n');
        }
        return conditionBuilder;
    }
}

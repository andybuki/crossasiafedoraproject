package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Code {
    public static StringBuilder addCodes() throws FileNotFoundException {

        JSONArray code = null;
        JSONArray codes = new JSONArray();

        StringBuilder codeBuilder = new StringBuilder();

        if (jsonObj.has("code")) {
            code = (JSONArray) jsonObj.get("code");
        }


        if (code!=null) {
            for (int k = 0;  k< code.length(); k++ ){
                codes.put(code.get(k));
            }
        }

        if (code!=null) {
            codeBuilder.append(QUOTE + "dllm:code" + QUOTE + ":" +  codes+  "," + '\n');
            return codeBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

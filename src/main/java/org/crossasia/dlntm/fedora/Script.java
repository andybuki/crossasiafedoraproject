package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Script {
    public static StringBuilder addScripts() throws FileNotFoundException {

        JSONArray scripts = null;
        JSONArray scripts_lao = null;
        JSONArray allScripts = new JSONArray();

        StringBuilder scriptsBuilder = new StringBuilder();

        if (jsonObj.has("script")) {
            scripts = (JSONArray) jsonObj.get("script");
        }

        if (jsonObj.has("script_th")) {
            scripts_lao = (JSONArray) jsonObj.get("script_th");
        }


        if (scripts != null ) {
            scriptsBuilder.append(QUOTE + "dllm:script" + QUOTE + ":" + scripts + "," + '\n');
        }

        if (scripts_lao!=null)
            scriptsBuilder.append(QUOTE + "dllm:script_th" + QUOTE + ":" +  scripts_lao+  "," + '\n');

        return scriptsBuilder;

    }
}

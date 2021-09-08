package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Description {
    public static StringBuilder addDescriptions() throws FileNotFoundException {

        String remarks = "";
        String thai_remarks = "";
        JSONArray remarksList = new JSONArray();

        StringBuilder remarksBuilder = new StringBuilder();

        if (jsonObj.has("remarks")) {
            remarks = (String) jsonObj.get("remarks");
        }

        if (jsonObj.has("thai_remarks")) {
            thai_remarks = (String) jsonObj.get("thai_remarks");
        }

        if (remarks!="") {
                remarksList.put(remarks);
        } else  {
            remarksList = null;}

        if (thai_remarks!="" && remarksList!=null) {
                remarksList.put(thai_remarks);
        } else {
            remarksList = null;}

        if (remarksList != null ) {
            remarksBuilder.append(QUOTE + "dc:description" + QUOTE + ":" +  remarksList+  "," + '\n');
            return remarksBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

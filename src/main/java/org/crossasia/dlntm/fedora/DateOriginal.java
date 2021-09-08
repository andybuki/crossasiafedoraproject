package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class DateOriginal {

    public static StringBuilder addDateOriginal() throws FileNotFoundException {
        String date_system = "";
        String date_system_th = "";
        int year = 0;
        StringBuilder dateOriginalBuilder = new StringBuilder();
        List<String> dates = new ArrayList<>();
        StringBuilder nameBuilder = new StringBuilder();
        StringBuilder nameBuilder_th = new StringBuilder();

        if (jsonObj.has("date_system")) {
            date_system = (String) jsonObj.get("date_system").toString();
        }
        if (jsonObj.has("date_system_th")) {
            date_system_th = (String) jsonObj.get("date_system_th").toString();
        }
        if (jsonObj.has("year")) {
            year = (int) jsonObj.get("year");
        }

        nameBuilder.append(year + " ");
        nameBuilder.append(date_system);

        nameBuilder_th.append(year + " ");
        nameBuilder_th.append(date_system_th);

        dates.add(QUOTE+nameBuilder+QUOTE);
        dates.add(QUOTE+nameBuilder_th+QUOTE);

        if (dates!= null) {
            dateOriginalBuilder.append(QUOTE + "dllm:date_original" + QUOTE + ":" +  dates  + "," + '\n');
            return dateOriginalBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

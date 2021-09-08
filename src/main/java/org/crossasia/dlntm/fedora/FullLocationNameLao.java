package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class FullLocationNameLao {
    public static StringBuilder addFullLocationNameLao() throws FileNotFoundException {

        JSONArray province_th = null;
        JSONArray district_th = null;
        JSONArray address_th = null;
        StringBuilder nameBuilder = new StringBuilder();
        JSONArray full_location_name_lao = new JSONArray();
        StringBuilder fullLocationNameLaoBuilder = new StringBuilder();

        if (jsonObj.has("province_th")) {
            province_th = (JSONArray) jsonObj.get("province_th");
        }

        if (jsonObj.has("district_th")) {
            district_th = (JSONArray) jsonObj.get("district_th");
        }

        if (jsonObj.has("address_th")) {
            address_th = (JSONArray) jsonObj.get("address_th");
        }

        if (province_th!=null) {
            for (int k = 0;  k< province_th.length(); k++ ) {
                full_location_name_lao.put(province_th.get(k));
            }
        } else {full_location_name_lao = null;}

        if (district_th!=null) {
            for (int l =0; l<district_th.length(); l++) {
                full_location_name_lao.put(district_th.get(l));
            }
        } else {full_location_name_lao = null;}

        if (address_th!=null) {
            for (int m =0; m<address_th.length(); m++) {
                full_location_name_lao.put(address_th.get(m));
            }
        } else {full_location_name_lao = null;}


        if (full_location_name_lao!=null) {
            for (int i=0; i<full_location_name_lao.length(); i++) {
                nameBuilder.append(full_location_name_lao.get(i) + ", ");
            }
            nameBuilder.deleteCharAt(nameBuilder.length() - 2);
        }

        if (full_location_name_lao != null) {
            fullLocationNameLaoBuilder.append(QUOTE + "dllm:full_location_name_th" + QUOTE + ":" +
                    QUOTE+ nameBuilder+ QUOTE+   "," + '\n');
            return fullLocationNameLaoBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

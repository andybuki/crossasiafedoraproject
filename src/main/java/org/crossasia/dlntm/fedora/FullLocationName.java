package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class FullLocationName {
    public static StringBuilder addFullLocationName() throws FileNotFoundException {

        JSONArray province_ro = null;
        JSONArray district_ro = null;
        JSONArray address_ro = null;
        boolean in_private_collection =false;
        JSONArray full_location_name  = new JSONArray();
        StringBuilder fullLocationNameBuilder = new StringBuilder();
        StringBuilder nameBuilder = new StringBuilder();

        if (jsonObj.has("province_ro")) {
            province_ro = (JSONArray) jsonObj.get("province_ro");
        }

        if (jsonObj.has("in_private_collection")) {
            in_private_collection = (boolean) jsonObj.get("in_private_collection");
        }

        if (jsonObj.has("district_ro")) {
            district_ro = (JSONArray) jsonObj.get("district_ro");
        }

        if (jsonObj.has("address_ro")) {
            address_ro = (JSONArray) jsonObj.get("address_ro");
        }

        if (province_ro!=null) {
            for (int k = 0;  k< province_ro.length(); k++ ){
                full_location_name.put(province_ro.get(k));
            }
        } else {
            full_location_name = null;
        }
        if (district_ro!=null) {
            for (int l =0; l<district_ro.length(); l++) {
                full_location_name.put(district_ro.get(l));
            }
        } else {
            full_location_name = null;
        }
        if (address_ro!=null) {
            for (int m =0; m<address_ro.length(); m++) {
                full_location_name.put(address_ro.get(m));
            }
        } else {
            full_location_name = null;
        }

        if (full_location_name!=null) {
            for (int i=0; i<full_location_name.length(); i++) {
                nameBuilder.append(full_location_name.get(i) + ", ");
            }
            nameBuilder.deleteCharAt(nameBuilder.length() - 2);
        }

        if (full_location_name != null) {
            fullLocationNameBuilder.append(QUOTE + "dllm:full_location_name" + QUOTE + ":" +
                    QUOTE+ nameBuilder+ QUOTE+ "," + '\n');
            return fullLocationNameBuilder;
        } else if (in_private_collection==true) {
            fullLocationNameBuilder.append(QUOTE + "dllm:full_location_name" + QUOTE + ":" + QUOTE + "In private possession" + QUOTE  +   "," + '\n');
            return fullLocationNameBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

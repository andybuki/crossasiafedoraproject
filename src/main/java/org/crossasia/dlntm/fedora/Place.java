package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Place {
    public static StringBuilder addPlaces() throws FileNotFoundException {

        JSONArray province_ro = null;
        JSONArray district_ro = null;
        JSONArray address_ro = null;
        JSONArray full_location_name = new JSONArray();
        JSONArray province_th = null;
        JSONArray district_th = null;
        JSONArray address_th = null;
        JSONArray full_location_name_lao = new JSONArray();
        StringBuilder placesBuilder = new StringBuilder();

        if (jsonObj.has("province_ro")) {
            province_ro = (JSONArray) jsonObj.get("province_ro");
        }

        if (jsonObj.has("province_th")) {
            province_th = (JSONArray) jsonObj.get("province_th");
        }

        if (jsonObj.has("district_ro")) {
            district_ro = (JSONArray) jsonObj.get("district_ro");
        }

        if (jsonObj.has("district_th")) {
            district_th = (JSONArray) jsonObj.get("district_th");
        }

        if (jsonObj.has("address_ro")) {
            address_ro = (JSONArray) jsonObj.get("address_ro");
        }

        if (jsonObj.has("address_th")) {
            address_th = (JSONArray) jsonObj.get("address_th");
        }

        if (province_ro!=null) {
            for (int k = 0; k < province_ro.length(); k++) {
                full_location_name.put(province_ro.get(k));
            }
        } else {full_location_name =null;}

        if (district_ro!=null) {
            for (int l =0; l<district_ro.length(); l++) {
                full_location_name.put(district_ro.get(l));
            }
        }   else {full_location_name =null;}

        if (address_ro!=null) {
            for (int m =0; m<address_ro.length(); m++) {
                full_location_name.put(address_ro.get(m));
            }
        } else {full_location_name =null;}


        if (province_th!=null) {
            for (int k = 0; k < province_th.length(); k++) {
                full_location_name_lao.put(province_th.get(k));
            }
        } else {full_location_name_lao =null;}

        if (district_th!=null) {
            for (int l = 0; l < district_th.length(); l++) {
                full_location_name_lao.put(district_th.get(l));
            }
        } else {full_location_name_lao =null;}
        if (address_th!=null) {
            for (int m =0; m<address_th.length(); m++) {
               full_location_name_lao.put(address_th.get(m));
            }
        } else {full_location_name_lao =null;}


        if (full_location_name != null ) {
            placesBuilder.append(QUOTE + "dc:place" + QUOTE + ":" +  full_location_name+  "," + '\n');
        }
        if (full_location_name_lao != null ) {
            placesBuilder.append(QUOTE + "dllm:place_th" + QUOTE + ":" +  full_location_name_lao+  "," + '\n');
        }
        if (full_location_name == null ) {
            placesBuilder.append(QUOTE + "dc:place" + QUOTE + ":" +QUOTE+"Private collection"+QUOTE +"," + '\n');
        }
        return placesBuilder;
    }
}

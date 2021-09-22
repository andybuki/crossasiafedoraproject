package org.crossasia.dlntm.fedora;

import org.json.JSONArray;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class Material {
    public static StringBuilder addMaterials() throws FileNotFoundException {

        JSONArray material =null;
        JSONArray material_th= null;
        JSONArray materials= new JSONArray();

        StringBuilder materialsBuilder = new StringBuilder();

        if (jsonObj.has("material"))
            material = (JSONArray) jsonObj.get("material");

        if (jsonObj.has("material_th"))
            material_th = (JSONArray) jsonObj.get("material_th");

        /*if (material!=null) {
            for (int k = 0;  k< material.length(); k++ ){
                for (int l =0; l<material_th.length(); l++) {
                    materials.put(material.get(k));
                    materials.put(material_th.get(l));
                }
            }
        }*/

        if (material != null || material_th!=null) {
            materialsBuilder.append(QUOTE + "dllm:material" + QUOTE + ":" +  material+  "," + '\n');
            materialsBuilder.append(QUOTE + "dllm:material_th" + QUOTE + ":" +  material_th+  "," + '\n');
            return materialsBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class InCollection {
    public static StringBuilder addCollection() throws FileNotFoundException {
        String collection = "";
        StringBuilder collectionBuilder = new StringBuilder();
        String collection_str = "";
        if (jsonObj.has("in_collection")) {
            collection = (String) jsonObj.get("in_collection");
        }
        switch (collection){
            case "pntmp":
                collection_str= "Preservation of Northern Thai Manuscripts Project (PNTMP)";
                break;
            case "dlntm":
                collection_str= "Digital Library of Northern Thai Manuscripts (DLNTM)";
                break;
            case "delmn":
                collection_str= "Dokumentarische Erfassung literarischer Materialien in den Nordprovinzen Thailands (DELMN)";
                break;
            case "hhhwc":
                collection_str= "Harald Hundius Handwritten Collection (HHHWC)";
                break;
        }

        if (collection!= "") {
            collectionBuilder.append(QUOTE + "dllm:in_collection" + QUOTE + ":" + QUOTE+ collection_str+QUOTE  + "," + '\n');
            return collectionBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

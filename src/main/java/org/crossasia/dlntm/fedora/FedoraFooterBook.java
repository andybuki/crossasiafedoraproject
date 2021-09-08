package org.crossasia.dlntm.fedora;

import static org.crossasia.dlntm.fedora.constants.Constants.BOOK;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class FedoraFooterBook {

    public static StringBuilder addFedoraFooter() {
        StringBuilder fedoraFooter = new StringBuilder();
        fedoraFooter.append(QUOTE + "dc:source" + QUOTE + ":" + QUOTE + "Digital Library of Lao Manuscripts" + QUOTE + "," + '\n');
        fedoraFooter.append(QUOTE + "crossasia:hasModel" + QUOTE + ":" + QUOTE + BOOK + QUOTE + "" + '\n');
        fedoraFooter.append("}");
        fedoraFooter.append("]}");

        return fedoraFooter;
    }
}

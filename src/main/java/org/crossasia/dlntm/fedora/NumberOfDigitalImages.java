package org.crossasia.dlntm.fedora;

import java.io.FileNotFoundException;

import static org.crossasia.dlntm.DlntmFedoraBook.jsonObj;
import static org.crossasia.dlntm.fedora.constants.Constants.QUOTE;

public class NumberOfDigitalImages {
    public static StringBuilder addNumberOfDigitalImages() throws FileNotFoundException {
        int number_of_digital_images = 0;
        StringBuilder numberOfDigitalImagesBuilder = new StringBuilder();

        if (jsonObj.has("number_of_digital_images")) {
            number_of_digital_images = (int) jsonObj.get("number_of_digital_images");
        }
        if (number_of_digital_images!= 0) {
            numberOfDigitalImagesBuilder.append(QUOTE + "dllm:number_of_digital_images" + QUOTE + ":" +  number_of_digital_images +  "," + '\n');
            return numberOfDigitalImagesBuilder;
        } else {
            return new StringBuilder();
        }
    }
}

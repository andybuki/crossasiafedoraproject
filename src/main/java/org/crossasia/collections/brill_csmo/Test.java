package org.crossasia.collections.brill_csmo;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        try {

            tesseract.setDatapath("/data/solr/ajax-brill-csmo/pdf/");

            // the path of your tess data folder
            // inside the extracted file
            String text
                    = tesseract.doOCR(new File("/data/solr/ajax-brill-csmo/pdf/1907.pdf"));

            // path of your image file
            System.out.print(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
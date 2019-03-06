package org.crossasia.collections.ccg;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class ModyfyXml2 {

    public static void main(String[] args) throws JDOMException, IOException {

        try {

            SAXBuilder sax = new SAXBuilder();
            Document doc = sax.build("F:\\c\\test.xml");

            XMLOutputter xmlOutput = new XMLOutputter();
            Format format = Format.getPrettyFormat();
            format.setEscapeStrategy((c) -> false);
            //format.setEncoding("UTF-8");
            xmlOutput.setFormat(format);
            xmlOutput.output(doc, (new FileOutputStream("F:\\c\\test2.xml")));

        }catch (IOException io) {
            io.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
    }

}
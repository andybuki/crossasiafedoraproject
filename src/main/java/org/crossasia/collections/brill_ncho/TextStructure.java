package org.crossasia.collections.brill_ncho;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TextStructure {

    public static void main(String[] args) {

        try {
            PrintStream out = new PrintStream(new FileOutputStream("/opt/IdeaProjects/crossasiafedoraproject/data/result.txt"));
            File xmlFile = new File("/opt/IdeaProjects/crossasiafedoraproject/data/test.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("word");
            ArrayList<String> textArray = new ArrayList<String>();
            String line ="";

            for (int temp = 0; temp < nList.getLength(); temp++) {
                String line1="";
                Node nNode =  nList.item(temp);
                Node nNode2 = nList.item(temp+1);
                Element eElement = (Element) nNode;
                Element eElement2 = (Element) nNode2;
                double top = Double.parseDouble(eElement.getAttribute("t"));
                double top2 = Double.parseDouble(eElement2.getAttribute("t"));
                line1= eElement.getTextContent();

                if (top==top2){

                    line +=line1;
                    System.out.println(line);
                    //textArray.add(line1);

                } else {
                    line = "";
                    line +=line1;
                    System.out.println(line);
                    //textArray.add(line1+"\n");
                }

                //textArray.add(line);

                //System.out.println(textArray);
                out.println(line);
            }
            //line +=line1;
            System.out.println(line);


        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}

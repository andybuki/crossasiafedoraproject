package org.crossasia.solr.collections.brill_ncso;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConvertXmlToJsonPages {
    public static void main( String[] args ) throws Exception {

        File dir = new File("/data/solr/OLD/ajax-brill-ncho/ncho2/");
        PrintStream out = new PrintStream(new FileOutputStream("/data/solr/OLD/ajax-brill-ncho/real_pages_SMALL3.json"));
        String text = "";
        String title ="";

        String quote = "\u005c\u0022";

        StringBuilder sb = new StringBuilder();
        for (File file : dir.listFiles()) {
            String encoding = "UTF-8";

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("field");
            System.out.println("----------------------------");
            //for (int temp = 0; temp < nList.getLength(); temp++) {

                //Node nNode = nList.item(temp);
                String id = nList.item(0).getFirstChild().getNodeValue().split(";")[1].replace(".pdf","").replace("/","_");
                String book_id="";
                if (nList.item(4).getFirstChild().getNodeValue().replace("/","_").contains("Book")) {
                    book_id = nList.item(4).getFirstChild().getNodeValue().replace("/","_").replace("NCH_","");
                } else {
                    book_id = nList.item(4).getFirstChild().getNodeValue().replace("/","_").replace("NCH_","");
                }

                System.out.println(id);
                String position="";
                if (nList.item(0).getFirstChild().getNodeValue().contains("CAM")) {
                  String [] p = id.split("-");
                  position = p[p.length-1];
                }else {
                    position = nList.item(0).getFirstChild().getNodeValue().split(";")[1].replace(".pdf","").split("_")[1];
                    String [] p =  position.split("/");
                    int post = (Integer.parseInt(p[0]));
                    position = post+"";
                }

                String pos = StringUtils.stripStart(position, "0");

                title = nList.item(5).getFirstChild().getNodeValue();
                if (nList.getLength()>14)
                    text = nList.item(15).getFirstChild().getNodeValue().replace("\"","").replace("\\","").replaceAll("\n","");
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                sb.append("{"+ '\n');
                if (id!= "")
                    sb.append(quote + "id" + quote + ":" +quote+  id  + quote+"," + '\n');

                if (book_id!= "")
                    sb.append(quote + "book_id" + quote + ":" + quote+ book_id +quote + "," + '\n');

                if (position!= "")
                    sb.append(quote + "position" + quote + ":" + quote+ pos +quote + "," + '\n');

                if (title!= "")
                    sb.append(quote + "title" + quote + ":" + quote+ title +quote + "," + '\n');


                if (text!= "")
                    sb.append(quote + "text" + quote + ":" + quote+ text.replaceAll("[\r\n]+", " ") +quote + "," + '\n');

                sb.append("},");

            }

        //}
        sb.deleteCharAt(sb.length() - 1);
        out.println("["+sb.toString()+"]");

    }
}

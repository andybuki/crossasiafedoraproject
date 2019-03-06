package org.crossasia.collections.ccg;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;


public class StripAttributes {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = null;
        NodeList nodes = null;
        Set<String> ids = null;
        try {
            doc = factory.newDocumentBuilder().parse(new File("F:\\a\\SZFZ2917-00000007-00027_NEW.xml"));

            XPathExpression expr = XPathFactory.newInstance().newXPath().compile("//@siteKey");
            ids = new HashSet<String>();
            nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < nodes.getLength(); i++) {
            String id = nodes.item(i).getNodeValue();
            if (id.equals("siteKey")) {
                Element el = ((Attr) nodes.item(i)).getOwnerElement();
                el.removeAttribute(id);
            }
        }

        int dupes = 0;
        for (int i = 0; i < nodes.getLength(); i++) {
            String id = nodes.item(i).getNodeValue();
            if (ids.contains(id)) {
                System.out.format("%s is duplicate\n\n", id);
                dupes++;
            } else {
                ids.add(id);
            }
        }

        System.out.format("Total ids = %d\n Total Duplicates = %d\n", ids.size(), dupes);

        Transformer transformer;
        StreamResult result = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);

    }
}

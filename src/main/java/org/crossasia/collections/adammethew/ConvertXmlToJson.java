package org.crossasia.collections.adammethew;

import org.apache.camel.Exchange;
import org.apache.camel.component.solr.SolrConstants;
import org.crossasia.utils.Utils;
import org.json.JSONObject;
import org.json.XML;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.domain.Products;
import org.fcrepo.client.FcrepoClient;
import org.w3c.dom.Document;

import javax.jms.ConnectionFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertXmlToJson {

    private static final String INDEXING_URI = "CamelIndexingUri";

    private String userID = "bypassAdmin";

    public static void main(String[] args) throws Exception {
        /*try {
            String filePathFolder = "H:\\fedora\\FO China\\FO China\\Data\\json\\";
            String directoryPath = "H:\\fedora\\FO China\\FO China\\Data\\Default";
            File folder = new File(filePathFolder);
            folder.mkdir();
            String absolutePath = filePathFolder;
            File dir = new File(directoryPath);
            FileFilter filter = (File file) -> file.isFile() && file.getName().endsWith(".xml");

            File[] paths = dir.listFiles(filter);
            String filePath = "";
            for (File path : paths) {
                filePath = path.toString();
                JSONObject jsonObject = XML.toJSONObject(new String(Files.readAllBytes(Paths.get(filePath))));
                String fileName = filePath.replace(directoryPath, "").replace(".xml", "");
                //out = new BufferedWriter(new FileWriter(folder+"\\"+fileName+".json"));
                String jsonString = jsonObject.toString().replace(",\"name\":\"AD\"", "");
                //out.write(jsonString);

                FileWriter fileWriter = new FileWriter(folder + "\\" + fileName + ".json");
                try {
                    fileWriter.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();

                } finally {
                    fileWriter.flush();
                    fileWriter.close();
                    //out.close();
                }

            }
        }   catch (IOException e) {
            e.printStackTrace();

        }*/

        CamelContext context = new DefaultCamelContext();

        final GsonDataFormat gsonDataFormat = new GsonDataFormat();

        gsonDataFormat.setUnmarshalType(Products.class);
        XPathBuilder xpath = new XPathBuilder("/rdf:RDF/rdf:Description/rdf:type[@rdf:resource='http://fedora.info/definitions/v4/indexing#Indexable']");
        xpath.namespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        context.setTracing(true);
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://10.46.3.100:61616"));
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(120000);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");
        context.addComponent("jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.stopRoute("nonAuto");

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                                /*from("file:H:\\fedora\\FO China\\FO China\\Data\\json")
                                        .process(Utils.javascript("convertAdamMethewSolr.js"))
                                        .to("file:data/solr");*/

                                  from("file:data/solr")
                                          .unmarshal(gsonDataFormat)
                                          .setBody().simple("${body.products}")
                                          .split(body())
                                          .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                                          .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                                          .to("solr://10.46.3.100:8980/solr/AD");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
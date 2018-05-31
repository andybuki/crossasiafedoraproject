package org.crossasia.collections.adammethew;

import org.apache.camel.Exchange;
import org.apache.camel.component.solr.SolrConstants;
import org.crossasia.splitter.adammetthew.JsonSplitterPages;
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

public class ConvertJsonToFedora {

    private static final String INDEXING_URI = "CamelIndexingUri";

    private String userID = "bypassAdmin";

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        final GsonDataFormat gsonDataFormat = new GsonDataFormat();

        gsonDataFormat.setUnmarshalType(Products.class);
        XPathBuilder xpath = new XPathBuilder("/rdf:RDF/rdf:Description/rdf:type[@rdf:resource='http://fedora.info/definitions/v4/indexing#Indexable']");
        xpath.namespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        context.setTracing(true);
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://10.46.3.100:61616"));
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(1200000);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");
        context.addComponent("jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.stopRoute("nonAuto");

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                /*from("file:C:\\TEMP\\solrFinal5")
                        .process(Utils.javascript("convertAdamMethewFedora.js"))
                        .to("file:C:\\TEMP\\solrFinal7");*/


                /*from("file:D:\\FEDORA-COLLECTIONS\\ADM_METH\\pageNew+")
                                        .process(Utils.javascript("convertAdamMethewFedoraImages.js"))
                                        .to("file:D:\\FEDORA-COLLECTIONS\\ADM_METH\\pages_fedora");*/

                from("file:D:\\FEDORA-COLLECTIONS\\ADM_METH\\pages_fedora2")
                        //.delay(10)
                        .split(method(JsonSplitterPages.class))
                        .to("file:D:\\FEDORA-COLLECTIONS\\ADM_METH\\pages_fedora_split2?fileName=${header.id}");

                /*from("file:data/solr2")
                        .unmarshal(gsonDataFormat)
                        .setBody().simple("${body.products}")
                        .split(body())
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                        .to("solr://10.46.3.100:8980/solr/AD");*/
            }
        });

        context.start();
        Thread.sleep(100000000);
        context.stop();
    }
}
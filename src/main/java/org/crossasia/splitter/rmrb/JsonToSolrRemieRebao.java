package org.crossasia.splitter.rmrb;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.domain.Products;

import org.crossasia.utils.Utils;

import javax.jms.ConnectionFactory;

public class JsonToSolrRemieRebao {

    private static final String INDEXING_URI = "CamelIndexingUri";

    private String userID = "bypassAdmin";

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        GsonDataFormat gsonDataFormat = new GsonDataFormat();

        gsonDataFormat.setDateFormatPattern("yyyy.mm.dd");
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


                    from("file:D:\\SOLR-COLLECTIONS\\REM_REB\\articles")
                            .process(Utils.javascript("reminrebao/convertRMRBSolr.js"))
                            .to("file:D:\\SOLR-COLLECTIONS\\REM_REB\\articles\\json");


                /*from("file:D:\\SOLR-COLLECTIONS\\REM_REB\\articles")
                        .unmarshal(gsonDataFormat)
                        //.unmarshal().json(JsonLibrary.Gson)
                        //.marshal().json(JsonLibrary.Gson)

                        .setBody().simple("${body.products}")
                        .split(body())
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                        .to("solr://10.46.3.100:8982/solr/RMRB");*/
            }
        });

        context.start();
        Thread.sleep(1000000);
        context.stop();
    }
}




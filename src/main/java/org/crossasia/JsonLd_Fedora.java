package org.crossasia;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ShutdownRunningTask;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.model.solr.Products;
import org.fcrepo.client.FcrepoClient;
import org.fcrepo.client.FedoraHeaderConstants;

import javax.jms.ConnectionFactory;

/**
 * A Camel Application
 */
public class JsonLd_Fedora {
    private static final String INDEXING_URI = "CamelIndexingUri";
    private String userID = "bypassAdmin";
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);
        context.setTracing(true);
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(120000);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                from("file:data2")
                        .setHeader(INDEXING_URI).simple("${header.CamelFcrepoUri}")
                        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/ld+json"))
                        .setHeader(Exchange.HTTP_URI, constant(FedoraHeaderConstants.CONTENT_TYPE))
                        .shutdownRunningTask(ShutdownRunningTask.CompleteAllTasks)
                        .delay(1000)
                        .to("fcrepo:10.46.3.100:8080/fcrepo/rest/test");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}


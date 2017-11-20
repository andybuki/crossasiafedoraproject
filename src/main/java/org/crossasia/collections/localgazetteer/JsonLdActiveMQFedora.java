package org.crossasia.collections.localgazetteer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ShutdownRunningTask;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.domain.Products;
import org.fcrepo.client.FcrepoClient;
import org.fcrepo.client.FedoraHeaderConstants;

import javax.jms.ConnectionFactory;

/**
 * A Camel Application
 */
public class JsonLdActiveMQFedora {
    private static final String INDEXING_URI = "CamelIndexingUri";

    private String userID = "bypassAdmin";
    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        FcrepoClient client = FcrepoClient.client().build();
        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);
        context.setTracing(true);
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://10.46.3.100:61616"));
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(120000);

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://10.46.3.100:61616");
        context.addComponent("jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.stopRoute("nonAuto");

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {



                /*from("file:data/solr3")
                        .shutdownRunningTask(ShutdownRunningTask.CompleteAllTasks)
                        .delay(10)
                        .split(method(JsonSplitter.class))
                        //.split().tokenize("},", 1)
                        .to("jms:queue/fedora2");*/

                from("jms:queue/fedora2")
                        .to("file:data/solr4?fileName=${header.books_id}");

                /*from("jms:queue/fedora")
                      .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                      .setHeader(Exchange.CONTENT_TYPE, constant("application/ld+json"))
                      .setHeader(Exchange.HTTP_URI, constant(FedoraHeaderConstants.CONTENT_TYPE))
                      .shutdownRunningTask(ShutdownRunningTask.CompleteAllTasks)
                      .delay(100)
                      .to("fcrepo:10.46.3.100:8080/fcrepo/rest");*/

            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}


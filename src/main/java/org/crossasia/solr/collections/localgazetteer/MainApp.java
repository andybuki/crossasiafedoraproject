package org.crossasia.solr.collections.localgazetteer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.jsonpath.JsonPathExpression;
import org.crossasia.domain.Products;
import org.fcrepo.client.FcrepoClient;

import javax.jms.ConnectionFactory;
import java.net.URI;

/**
 * A Camel Application
 */
public class MainApp {
    private static final String INDEXING_URI = "CamelIndexingUri";

    private String userID = "bypassAdmin";
    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        FcrepoClient client = FcrepoClient.client().build();
        URI uri = URI.create("http://10.46.3.100:8080/fcrepo/rest/book4");


        

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
            public void configure() throws Exception
            {
                /*from("file:data/solr?noop=true")
                        .process(Utils.javascript("convertBooks.js"))
                        .to("file:data/solr2");

                from("file:data2")
                       .unmarshal(gsonDataFormat)
                        .setBody().simple("${body.products}")
                        .split(body())
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                        .to("solr://10.46.3.100:8980/solr/loc_gaz");*/

                from("file:data?noop=true")
                .split(new JsonPathExpression("$.@context")).process(new Processor() {
                    public void process(Exchange exchange) throws Exception {

                        String s = exchange.getIn().getBody(String.class);
                        System.out.println(s);
                    }
                })
                .to("jms:queue:activemq/queue");

                /*from("file:data2")

                        /*.setHeader(INDEXING_URI).simple("${header.CamelFcrepoUri}")
                        .setHeader(Exchange.HTTP_METHOD, constant("POST"))

                        .setHeader(Exchange.CONTENT_TYPE, constant("application/ld+json"))
                        .setHeader(Exchange.HTTP_URI, constant(FedoraHeaderConstants.CONTENT_TYPE))
                        .shutdownRunningTask(ShutdownRunningTask.CompleteAllTasks)
                        .transacted()
                        .delay(1000)
                        .to("fcrepo:10.46.3.100:8080/fcrepo/rest/test");

                        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/rdf+xml"))
                        .setHeader("Content-Disposition", constant("container"))
                        //.setHeader("Slug", constant("book"))

                        .delay(10000)
                        .to("fcrepo:10.46.3.100:8080/fcrepo/rest/book");*/

            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}


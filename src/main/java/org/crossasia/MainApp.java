package org.crossasia;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ShutdownRunningTask;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.XPathBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.model.solr.Products;
import org.crossasia.model.solr.Sections;
import org.crossasia.utils.Utils;
import org.fcrepo.camel.processor.SparqlUpdateProcessor;
import org.springframework.jms.support.JmsHeaders;



/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();

        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);
        XPathBuilder xpath = new XPathBuilder("/rdf:RDF/rdf:Description/rdf:type[@rdf:resource='http://fedora.info/definitions/v4/indexing#Indexable']");
        xpath.namespace("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        context.setTracing(true);
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://127.0.0.1:37384"));
        //context.getShutdownStrategy().setLogInflightExchangesOnTimeout(false);
        context.getShutdownStrategy().setTimeout(200000);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                from("file:data/solr?noop=true")
                        .process(Utils.javascript("convert.js"))
                        .to("file:data2");

                from("direct:data2")
                        .unmarshal(gsonDataFormat)
                        .setBody().simple("${body.products}")
                        .split().body()
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        //.to("solrCloud://10.46.3.100:8983/solr/loc_gaz?zkHost=10.46.3.100:9983&collection=loc_gaz");
                        //.to("solr://10.46.3.100:8983/solr/gaz5");
                        .filter(xpath)
                .to("fcrepo:10.46.3.100:8080/fcrepo-webapp-4.7.4/rest?transform=default");

            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}


package org.crossasia;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.domain.Products;
import org.fcrepo.client.FcrepoClient;

public class AiritiMetadata {

    public static void main( String[] args ) throws Exception  {
        CamelContext context = new DefaultCamelContext();
        FcrepoClient client = FcrepoClient.client().build();

        final GsonDataFormat gsonDataFormat = new GsonDataFormat();

        gsonDataFormat.setUnmarshalType(Products.class);
        context.setTracing(true);
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(120000);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                /*from("file:data3?noop=true")
                        .process(Utils.javascript("convertAiritiMetadata.js"))
                        .to("file:data3/test");*/

                from("file:data3/test")
                        .unmarshal(gsonDataFormat)
                        .setBody().simple("${body.products}")
                        .split(body())
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                        .to("solr://10.46.3.100:8980/solr/airiti");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}

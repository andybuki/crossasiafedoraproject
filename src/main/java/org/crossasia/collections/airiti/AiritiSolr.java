package org.crossasia.collections.airiti;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.domain.Products;

/**
 * A Camel Application
 */
public class AiritiSolr {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();

        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);
        context.setTracing(true);
        context.getShutdownStrategy().setTimeout(20000);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                from("file:D:\\SOLR-COLLECTIONS\\AMD-JAPAN\\test")
                        .unmarshal(gsonDataFormat)
                        .setBody().simple("${body.products}")
                        .split().body()
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                        .to("solr://10.46.3.100:8982/solr/AMD_FOChina");
                //.to("solr://b-app66.sbb.spk-berlin.de:8985/solr/rep-airiti");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}


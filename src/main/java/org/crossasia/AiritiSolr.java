package org.crossasia;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.solr.SolrConstants;
import org.apache.camel.impl.DefaultCamelContext;
import org.crossasia.model.solr.Products;

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
        context.getShutdownStrategy().setTimeout(2000000);

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                from("file:data2/solr/contents?noop=true")
                        .unmarshal(gsonDataFormat)
                        .setBody().simple("${body.products}")
                        .split().body()
                        .setHeader(SolrConstants.OPERATION, constant(SolrConstants.OPERATION_ADD_BEAN))
                        .to("solr://10.46.3.100:8980/solr/airiti");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}


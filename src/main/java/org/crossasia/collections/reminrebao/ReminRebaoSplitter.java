package org.crossasia.collections.reminrebao;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.vocabulary.RDF;
import org.crossasia.domain.Products;
import org.crossasia.splitter.localgazetteer.JsonSplitterPages;
import org.crossasia.splitter.reminrebao.JsonSplitterArticles;
import org.crossasia.utils.Utils;

public class ReminRebaoSplitter {
    private static final String REPOSITORY = "http://fedora.info/definitions/v4/repository#";
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);

        context.getShutdownStrategy().setTimeout(50000);
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {

                final Namespaces ns = new Namespaces("rdf", RDF.uri);
                ns.add("premis", "http://www.loc.gov/premis/rdf/v1#");
                from("file:D:\\FEDORA-COLLECTIONS\\REM_REB\\jsonDone")
                        //.delay(10)
                        .split(method(JsonSplitterArticles.class))
                        .to("file:D:\\FEDORA-COLLECTIONS\\REM_REB\\articles3?fileName=${header.id}");


                /*from("file:D:\\FEDORA-COLLECTIONS\\REM_REB\\json\\example")
                 .process(Utils.javascript("convertReminRebaoFedoraMetadata.js"))
                        .to("file:D:\\FEDORA-COLLECTIONS\\REM_REB\\jsonDone");*/


            }
        });

        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}

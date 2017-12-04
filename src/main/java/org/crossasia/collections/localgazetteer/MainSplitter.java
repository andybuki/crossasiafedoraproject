package org.crossasia.collections.localgazetteer;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.vocabulary.RDF;
import org.crossasia.domain.Products;
import org.crossasia.splitter.localgazetteer.JsonFedoraSplitterPages;

public class MainSplitter
{

    private static final String REPOSITORY = "http://fedora.info/definitions/v4/repository#";
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);

        context.getShutdownStrategy().setTimeout(20000);
          context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {

                final Namespaces ns = new Namespaces("rdf", RDF.uri);
                ns.add("premis", "http://www.loc.gov/premis/rdf/v1#");
                from("file:C:\\TEMP\\fedora\\f1\\a")
                        //.delay(10)
                        .split(method(JsonFedoraSplitterPages.class))
                        .to("file:C:\\TEMP\\fedora\\files8?fileName=${header.books_id}");


                /*from("file:H:\\fedora\\text\\data")
                 .process(Utils.javascript("convertPagesFedora.js"))
                        .to("file:H:\\fedora\\text\\data\\text");*/


            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}

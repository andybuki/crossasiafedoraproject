package org.crossasia.splitter;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.vocabulary.RDF;
import org.crossasia.domain.Products;
import org.crossasia.splitter.dllm.DllmSplitter;
//import org.crossasia.splitter.localgazetteer.JsonSplitterPages;

public class MainSplitter
{

    private static final String REPOSITORY = "http://fedora.info/definitions/v4/repository#";
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);

        context.getShutdownStrategy().setTimeout(300000);
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {

                final Namespaces ns = new Namespaces("rdf", RDF.uri);
                ns.add("premis", "http://www.loc.gov/premis/rdf/v1#");
                from("file:/data/dlmnt/fedora")
                        //.delay(10)
                        .split(method(DllmSplitter.class))
                        .to("file:/data/dlmnt/fedora/books_raw?fileName=${header.books_id}");


                /*from("file:D:\\RAW-COLLECTIONS\\Xuxiu\\json")
                 .process(Utils.javascript("convertBooksXixiu.js"))
                        .to("file:D:\\RAW-COLLECTIONS\\Xuxiu\\json2");*/


            }
        });

        context.start();
        Thread.sleep(100000);
        context.stop();
    }
}

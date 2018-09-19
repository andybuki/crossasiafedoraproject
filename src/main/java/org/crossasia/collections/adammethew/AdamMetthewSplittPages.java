package org.crossasia.collections.adammethew;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.vocabulary.RDF;
import org.crossasia.splitter.adammetthew.JsonSplitterPages;

public class AdamMetthewSplittPages {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.getShutdownStrategy().setTimeout(20000);
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {
                final Namespaces ns = new Namespaces("rdf", RDF.uri);
                ns.add("premis", "http://www.loc.gov/premis/rdf/v1#");
                from("file:D:\\FEDORA-COLLECTIONS\\CNKI\\pages")
                        .split(method(JsonSplitterPages.class))
                        .to("file:D:\\FEDORA-COLLECTIONS\\CNKI\\pages\\splited_pages?fileName=${header.books_id}");
            }
        });

        context.start();
        Thread.sleep(10000000);
        context.stop();
    }
}

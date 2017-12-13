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
                from("file:C:\\Users\\b-ab107\\IdeaProjects\\crossasiafedoraproject\\data\\fedora2")
                        .split(method(JsonSplitterPages.class))
                        .to("file:C:\\Users\\b-ab107\\IdeaProjects\\crossasiafedoraproject\\data\\fedora2\\pages?fileName=${header.books_id}");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}

package org.crossasia.solr.collections.meijijapan;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.vocabulary.RDF;
import org.crossasia.domain.Products;
import org.crossasia.splitter.mejijapan.JsonSplitterPages;


public class MeijiJapanConvertToSolr {

    private static final String REPOSITORY = "http://fedora.info/definitions/v4/repository#";
    public static void main( String[] args ) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
        final GsonDataFormat gsonDataFormat = new GsonDataFormat();
        gsonDataFormat.setUnmarshalType(Products.class);

        context.getShutdownStrategy().setTimeout(100000);
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception
            {

                final Namespaces ns = new Namespaces("rdf", RDF.uri);
                ns.add("premis", "http://www.loc.gov/premis/rdf/v1#");
                from("file:D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\fedora")
                        //.delay(10)
                        .split(method(JsonSplitterPages.class))
                        .to("file:D:\\RAW-COLLECTIONS\\ChinaAmericaPacific\\fedora\\splited_page?fileName=${header.id}");

                /*from("file:D:\\RAW-COLLECTIONS\\MeijiJapan\\meta")
                    .process(Utils.javascript("convertmeijijapanSolr_Meta.js"))
                    .to("file:D:\\RAW-COLLECTIONS\\MeijiJapan\\meta2");*/

                /*from("file:D:\\RAW-COLLECTIONS\\MeijiJapan\\meta2")
                        .process(Utils.javascript("convertMeijiJapanFedora.js"))
                        .to("file:D:\\RAW-COLLECTIONS\\MeijiJapan\\meta_fedora");*/

                /*from("file:D:\\RAW-COLLECTIONS\\MeijiJapan\\images")
                        .process(Utils.javascript("convertMeijiJapanFedoraImages.js"))
                        .to("file:D:\\RAW-COLLECTIONS\\MeijiJapan\\images_fedora");*/


            }
        });

        context.start();
        Thread.sleep(1000000);
        context.stop();
    }
}

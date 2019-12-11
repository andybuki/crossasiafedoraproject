package org.crossasia.converter;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.xml.Namespaces;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.jena.vocabulary.RDF;
import org.crossasia.domain.Products;
import org.crossasia.utils.Utils;

public class convertGB2312ToUTF {
    public static void main(String[] args) throws Exception {
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


                from("file:D:\\RAW-COLLECTIONS\\REMIN_REBAO\\Volltexte 1946-2009\\2009\\txt.gb2312")
                        .process(Utils.javascript("entcoding.js"))
                        .to("file:D:\\RAW-COLLECTIONS\\REMIN_REBAO\\Volltexte 1946-2009\\2009\\utf-8");


            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }

    }



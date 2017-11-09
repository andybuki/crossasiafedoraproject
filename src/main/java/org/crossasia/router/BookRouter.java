package org.crossasia.router;

import org.apache.camel.builder.RouteBuilder;

public class BookRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:select").to("sqlComponent:{{sql.getAllBooks}}")
            .beanRef("bookMapper", "readBooks").log("${body}")
                //from("sqlComponent:{{sql.getAllBooks}}")
                //.to("activemq:queue:activemq/queue")
                        .split().body()
                .to("file:data3/test?fileName=data.txt");

    }

}
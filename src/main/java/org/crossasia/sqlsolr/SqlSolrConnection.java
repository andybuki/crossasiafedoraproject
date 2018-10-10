package org.crossasia.sqlsolr;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.crossasia.domain.Book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.camel.component.jms.JmsComponent;

import javax.jms.ConnectionFactory;
import java.util.List;


public class SqlSolrConnection {
    public static void main(String[] args) throws Exception {
        ApplicationContext springCtx = new ClassPathXmlApplicationContext("database-context.xml");
        CamelContext context = springCtx.getBean("bookContext", CamelContext.class);
        context.setTracing(true);
        //context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://10.46.3.100:61616"));
        context.getShutdownStrategy().setLogInflightExchangesOnTimeout(true);
        context.getShutdownStrategy().setTimeout(120000);
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");

        context.stopRoute("nonAuto");

        context.start();
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        List<Book> books = producerTemplate.requestBody("direct:select", null, List.class);
        System.out.println("books:" + books);

    }

}

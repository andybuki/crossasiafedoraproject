package org.crossasia.jsonld;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import ioinformarics.oss.jackson.module.jsonld.JsonldResource;

import java.io.Console;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FedoraMainPoint {
    private static Console objectMapper;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        PrintStream out = new PrintStream(new FileOutputStream("/data/dlmnt/fedora/test.json"));

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.registerModule(new JsonldModule(() -> objectMapper.createObjectNode()));
        //objectMapper.registerModule(new JsonldModule(""));

        Fedora alex = new Fedora();
        alex.id = "";
        alex.name = "Alex De Leon";
        alex.jobtitle = "Software Developer";
        alex.url = "http://alexdeleon.name";
        alex.sourceid ="xa";

        DublinCore dublinCore =new DublinCore();
        dublinCore.sourceid ="test";

        //sb.append(JsonldResource.Builder.create().build(alex));
        //sb.append(objectMapper.writeValueAsBytes(JsonldResource.Builder.create().build(alex));

        //objectMapper.writer().writeValue(out, JsonldResource.Builder.create().build(alex));
        String personJsonLd = objectMapper.writer().writeValueAsString(JsonldResource.Builder.create().build(alex));
        sb.append(personJsonLd);
        sb.append(dublinCore);
        out.println(sb);

    }
}

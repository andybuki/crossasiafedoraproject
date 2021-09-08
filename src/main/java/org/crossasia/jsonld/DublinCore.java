package org.crossasia.jsonld;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldType("http://purl.org/dc/elements/1.1/")
public class DublinCore {

    @JsonldId
    public  String id;

    @JsonldProperty("http://purl.org/dc/elements/1.1/dc")
    public  String sourceid;
}

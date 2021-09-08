package org.crossasia.jsonld;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;

@JsonldType("pcdm:Object")
public class Fedora {
    @JsonldId
    public  String id;

    @JsonldProperty("http://schema.org/name")
    public String name;

    @JsonldProperty("http://schema.org/jobTitle")
    public String jobtitle;

    @JsonldProperty("http://schema.org/url")
    public String url;

    @JsonldProperty("http://purl.org/dc/elements/1.1/dc")
    public String sourceid;
}
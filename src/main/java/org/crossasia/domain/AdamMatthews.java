package org.crossasia.domain;

import org.apache.solr.client.solrj.beans.Field;

import static java.awt.SystemColor.text;

public class AdamMatthews {

    @Field
    private String collex_genre;

    @Field
    private String dc_title;

    @Field
    private int dc_date;

    @Field
    private int collex_date;

    @Field
    private String role_PBL;

    @Field
    private String collex_fulltext;

    @Field
    private String rdf_about;

    @Field
    private String dc_source;

    public String getCollex_genre() {
        return collex_genre;
    }

    public void setCollex_genre(String collex_genre) {
        this.collex_genre = collex_genre;
    }

    public String getDc_title() {
        return dc_title;
    }

    public void setDc_title(String dc_title) {
        this.dc_title = dc_title;
    }

    public int getDc_date() {
        return dc_date;
    }

    public void setDc_date(int dc_date) {
        this.dc_date = dc_date;
    }

    public int getCollex_date() {
        return collex_date;
    }

    public void setCollex_date(int collex_date) {
        this.collex_date = collex_date;
    }

    public String getRole_PBL() {
        return role_PBL;
    }

    public void setRole_PBL(String role_PBL) {
        this.role_PBL = role_PBL;
    }

    public String getCollex_fulltext() {
        return collex_fulltext;
    }

    public void setCollex_fulltext(String collex_fulltext) {
        this.collex_fulltext = collex_fulltext;
    }

    public String getRdf_about() {
        return rdf_about;
    }

    public void setRdf_about(String rdf_about) {
        this.rdf_about = rdf_about;
    }

    public String getDc_source() {
        return dc_source;
    }

    public void setDc_source(String dc_source) {
        this.dc_source = dc_source;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");
        sb.append("collex_genre='").append(collex_genre).append('\'');
        sb.append(",  dc_title='").append(dc_title).append('\'');
        sb.append(", dc_date='").append(dc_date).append('\'');
        sb.append(", collex_date='").append(collex_date).append('\'');
        sb.append(", role_PBL='").append(role_PBL).append('\'');
        sb.append(", collex_fulltext='").append(collex_fulltext).append('\'');
        sb.append(", rdf_about='").append(rdf_about).append('\'');
        sb.append(", dc_source='").append(dc_source).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

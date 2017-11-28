package org.crossasia.domain.adammatthews;

import org.apache.solr.client.solrj.beans.Field;

import static java.awt.SystemColor.text;

public class AdamMatthews {

    @Field
    private String id;

    @Field
    private String hasModel;

    @Field
    private int nodeId;

    @Field
    private int ID;

    @Field
    private String identifier;

    @Field
    private String title;

    @Field
    private int date;

    @Field
    private String[] publication_name;

    @Field
    private String [] description;

    @Field
    private String [] medium;

    @Field
    private String [] subject;

    @Field
    private String [] keywords;

    @Field
    private String [] series_title;

    @Field
    private String publisher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHasModel() {
        return hasModel;
    }

    public void setHasModel(String hasModel) {
        this.hasModel = hasModel;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String[] getPublication_name() {
        return publication_name;
    }

    public void setPublication_name(String[] publication_name) {
        this.publication_name = publication_name;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String[] getMedium() {
        return medium;
    }

    public void setMedium(String[] medium) {
        this.medium = medium;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String[] series_title) {
        this.series_title = series_title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");

        sb.append("id='").append(id).append('\'');
        sb.append(",  hasModel='").append(hasModel).append('\'');
        sb.append(",   nodeId='").append(nodeId).append('\'');
        sb.append(",  ID='").append(ID).append('\'');
        sb.append(", identifier='").append(identifier).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", publication_name='").append(publication_name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", medium='").append(medium).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", keywords='").append(keywords).append('\'');
        sb.append(", series_title='").append(series_title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');

        sb.append('}');
        return sb.toString();
    }
}

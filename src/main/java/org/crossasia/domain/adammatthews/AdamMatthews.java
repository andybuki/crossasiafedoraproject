package org.crossasia.domain.adammatthews;

import org.apache.solr.client.solrj.beans.Field;

public class AdamMatthews {

    @Field
    private String id;

    @Field
    private String hasModel;

    @Field
    private String identifier;

    @Field
    private String [] title;

    @Field
    private int nodeId;

    @Field
    private String book_id;


    @Field
    private String date;

    @Field
    private String[] publication_name;

    @Field
    private String publication_place;

    @Field
    private String[] edition;

    @Field
    private String []  description;

    @Field
    private String [] medium;

    @Field
    private String [] subject;

    @Field
    private String  organization;

    @Field
    private String [] keywords;

    @Field
    private String [] author;

    @Field
    private String source;

    @Field
    private String []  series_title;

    @Field
    private String [] person;

    @Field
    private String [] spatial;

    @Field
    private String publisher;

    @Field
    private String language;

    @Field
    private String volume_number;

    @Field
    private String issue_number;

    @Field
    private String publication_volume;

    @Field
    private String collection;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String[] getPublication_name() {
        return publication_name;
    }

    public void setPublication_name(String[] publication_name) {
        this.publication_name = publication_name;
    }

    public String getPublication_place() {
        return publication_place;
    }

    public void setPublication_place(String publication_place) {
        this.publication_place = publication_place;
    }

    public String[] getEdition() {
        return edition;
    }

    public void setEdition(String[] edition) {
        this.edition = edition;
    }

    public String [] getDescription() {
        return description;
    }

    public void setDescription(String [] description) {
        this.description = description;
    }

    public String[] getMedium() {
        return medium;
    }

    public void setMedium(String[] medium) {
        this.medium = medium;
    }

    public String [] getSubject() {
        return subject;
    }

    public void setSubject(String [] subject) {
        this.subject = subject;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String [] author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String [] getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String [] series_title) {
        this.series_title = series_title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVolume_number() {
        return volume_number;
    }

    public void setVolume_number(String volume_number) {
        this.volume_number = volume_number;
    }

    public String getIssue_number() {
        return issue_number;
    }

    public void setIssue_number(String issue_number) {
        this.issue_number = issue_number;
    }

    public String getPublication_volume() {
        return publication_volume;
    }

    public void setPublication_volume(String publication_volume) {
        this.publication_volume = publication_volume;
    }


    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getPerson() {
        return person;
    }

    public void setPerson(String[] person) {
        this.person = person;
    }

    public String[] getSpatial() {
        return spatial;
    }

    public void setSpatial(String[] spatial) {
        this.spatial = spatial;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");

        sb.append("id='").append(id).append('\'');
        sb.append(",  hasModel='").append(hasModel).append('\'');
        sb.append(",  language='").append(language).append('\'');
        sb.append(",   nodeId='").append(nodeId).append('\'');
        sb.append(",  book_id='").append(book_id).append('\'');
        sb.append(",  collection='").append(collection).append('\'');
        sb.append(",  person='").append(person).append('\'');
        sb.append(", identifier='").append(identifier).append('\'');
        sb.append(", spatial='").append(spatial).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", volume_number='").append(volume_number).append('\'');
        sb.append(", issue_number='").append(issue_number).append('\'');
        sb.append(", source='").append(source).append('\'');
        sb.append(", organization='").append(organization).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", publication_name='").append(publication_name).append('\'');
        sb.append(", publication_place='").append(publication_place).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", medium='").append(medium).append('\'');
        sb.append(", edition='").append(edition).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", keywords='").append(keywords).append('\'');
        sb.append(", series_title='").append(series_title).append('\'');
        sb.append(", publication_volume='").append(publication_volume).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');

        sb.append('}');
        return sb.toString();
    }
}

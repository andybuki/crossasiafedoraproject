package org.crossasia.domain.reminrebao;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

public class Pages {
    @Field
    private String id;

    @Field
    private String title;

    @Field
    private String hasModel;

    @Field
    private int date;

    @Field
    private int page;

    @Field
    private String[] medium;

    @Field
    private String language;

    @Field
    private Date wholeDate;

    @Field
    private String text;

    @Field
    private String author;

    @Field
    private String journal_title;

    @Field
    private String collection;

    @Field
    private String [] description;

    public String getJournal_title() {
        return journal_title;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHasModel() {
        return hasModel;
    }

    public void setHasModel(String hasModel) {
        this.hasModel = hasModel;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Date getWholeDate() {
        return wholeDate;
    }

    public void setWholeDate(Date wholeDate) {
        this.wholeDate = wholeDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String[] getMedium() {
        return medium;
    }

    public void setMedium(String[] medium) {
        this.medium = medium;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Page{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", hasModel='").append("Article").append('\'');
        sb.append(", collection='").append(collection).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", wholeDate='").append(wholeDate).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", page='").append(page).append('\'');
        sb.append(", medium='").append(medium).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", journal_title='").append(journal_title).append('\'');
        sb.append(", language='").append("chi").append('\'');

        sb.append('}');
        return sb.toString();
    }
}


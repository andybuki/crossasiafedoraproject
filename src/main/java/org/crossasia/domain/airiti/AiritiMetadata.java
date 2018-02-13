package org.crossasia.domain.airiti;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Arrays;

public class AiritiMetadata {

    @Field
    private String id;

    @Field
    private String hasModel;

    @Field
    private String book_id;

    @Field
    private String title;

    @Field
    private String []author;

    @Field
    private String [] title_transcription;

    @Field
    private String series_title;

    @Field
    private String [] creator_transcription;

    @Field
    private String[] medium;

    @Field
    private int date;

    @Field
    private String language;

    @Field
    private String[] keywords;

    @Field
    private String series_title_transcription;

    @Field
    private String alternative;

    @Field
    private String publication_place;

    @Field
    private String publisher;

    @Field
    private String description;

    @Field
    private String mods_genre;

    @Field
    private String identifier_type_ISSN;

    @Field
    private String extent;

    @Field
    private String subject_xsi_type;

    @Field
    private String subject;

    @Field
    private String identifier;

    @Field
    private String identifier_xsi_type_CrossAsia_Link;

    @Field
    private String source;

    @Field
    private String collection;

    @Field
    private String publication_id;

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

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String[] getTitle_transcription() {
        return title_transcription;
    }

    public void setTitle_transcription(String[] title_transcription) {
        this.title_transcription = title_transcription;
    }

    public String getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String series_title) {
        this.series_title = series_title;
    }

    public String[] getCreator_transcription() {
        return creator_transcription;
    }

    public void setCreator_transcription(String[] creator_transcription) {
        this.creator_transcription = creator_transcription;
    }

    public String[] getMedium() {
        return medium;
    }

    public void setMedium(String[] medium) {
        this.medium = medium;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getSeries_title_transcription() {
        return series_title_transcription;
    }

    public void setSeries_title_transcription(String series_title_transcription) {
        this.series_title_transcription = series_title_transcription;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPublication_place() {
        return publication_place;
    }

    public void setPublication_place(String publication_place) {
        this.publication_place = publication_place;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMods_genre() {
        return mods_genre;
    }

    public void setMods_genre(String mods_genre) {
        this.mods_genre = mods_genre;
    }

    public String getIdentifier_type_ISSN() {
        return identifier_type_ISSN;
    }

    public void setIdentifier_type_ISSN(String identifier_type_ISSN) {
        this.identifier_type_ISSN = identifier_type_ISSN;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public String getSubject_xsi_type() {
        return subject_xsi_type;
    }

    public void setSubject_xsi_type(String subject_xsi_type) {
        this.subject_xsi_type = subject_xsi_type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier_xsi_type_CrossAsia_Link() {
        return identifier_xsi_type_CrossAsia_Link;
    }

    public void setIdentifier_xsi_type_CrossAsia_Link(String identifier_xsi_type_CrossAsia_Link) {
        this.identifier_xsi_type_CrossAsia_Link = identifier_xsi_type_CrossAsia_Link;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "AiritiMetadata{" +
                "id='" + id + '\'' +
                ", hasModel='" + hasModel + '\'' +
                ", book_id='" + book_id + '\'' +
                ", title='" + title + '\'' +
                ", author=" + Arrays.toString(author) +
                ", title_transcription=" + Arrays.toString(title_transcription) +
                ", series_title='" + series_title + '\'' +
                ", creator_transcription=" + Arrays.toString(creator_transcription) +
                ", medium=" + Arrays.toString(medium) +
                ", date='" + date + '\'' +
                ", language='" + language + '\'' +
                ", keywords=" + Arrays.toString(keywords) +
                ", series_title_transcription='" + series_title_transcription + '\'' +
                ", alternative='" + alternative + '\'' +
                ", publication_place='" + publication_place + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", mods_genre='" + mods_genre + '\'' +
                ", identifier_type_ISSN='" + identifier_type_ISSN + '\'' +
                ", collection='" + collection + '\'' +
                ", extent='" + extent + '\'' +
                ", subject_xsi_type='" + subject_xsi_type + '\'' +
                ", subject='" + subject + '\'' +
                ", identifier='" + identifier + '\'' +
                ", identifier_xsi_type_CrossAsia_Link='" + identifier_xsi_type_CrossAsia_Link + '\'' +
                ", source='" + source + '\'' +
                ", publication_id='" + publication_id + '\'' +
                '}';
    }
}

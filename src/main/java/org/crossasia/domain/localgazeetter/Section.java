package org.crossasia.domain.localgazeetter;

import org.apache.solr.client.solrj.beans.Field;

public class Section {

    @Field
    private String id;

    @Field
    private int chapter_id;

    @Field
    private String title;

    @Field
    private String hasModel;

    @Field
    private String book_id;

    @Field
    private String collection;

    @Field
    private int pageStart;

    @Field
    private int pageEnd;

    @Field
    private int value;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
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



    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Section{");
        sb.append("id='").append(id).append('\'');
        sb.append("chapter_id='").append(chapter_id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", hasModel='").append("Chapter").append('\'');
        sb.append(", book_id='").append(book_id).append('\'');
        sb.append(", pageStart='").append(pageStart).append('\'');
        sb.append(", pageEnd='").append(pageEnd).append('\'');
        sb.append(", collection='").append(collection).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

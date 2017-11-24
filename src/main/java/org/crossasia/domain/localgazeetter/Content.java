package org.crossasia.domain.localgazeetter;

import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;

import static org.apache.commons.lang3.StringUtils.split;

public class Content {


    @Field
    private String id;

    @Field
    private int page_id;

    @Field
    private String hasModel;

    @Field
    private int book_id;

    @Field
    private int position;

    @Field
    private String text;

    @Field
    private String[] chapter_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }


    public String[] getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String[] chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getHasModel() {
        return hasModel;
    }

    public void setHasModel(String hasModel) {
        this.hasModel = hasModel;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");

        sb.append("id='").append(id).append('\'');
        sb.append("page_id='").append(page_id).append('\'');
        sb.append(", hasModel='").append("Page").append('\'');
        sb.append(", book_id='").append(book_id).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", chapter_id='").append(chapter_id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

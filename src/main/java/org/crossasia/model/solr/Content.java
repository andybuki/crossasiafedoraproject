package org.crossasia.model.solr;

import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;

public class Content {

    @Field
    private int id;

    @Field
    private String books_id;

    @Field
    private int line;

    @Field
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooks_id() {
        return books_id;
    }

    public void setBooks_id(String books_id) {
        this.books_id = books_id;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");

        sb.append("id='").append(id).append('\'');
        sb.append(", books_id='").append(books_id).append('\'');
        sb.append(", line='").append(line).append('\'');
        sb.append(", text='").append(content).append('\'');

        sb.append('}');
        return sb.toString();
    }
}

package org.crossasia.domain.airiti;

import org.apache.solr.client.solrj.beans.Field;

public class Airiti {

    @Field
    private String id;

    @Field
    private String book_id;

    @Field
    private int position;

    @Field
    private String text;

    @Field
    private String hasModel;

    @Field
    private String collection;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");
        sb.append("id='").append(id).append('\'');
        sb.append(",  book_id='").append(book_id).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", hasModel='").append(hasModel).append('\'');
        sb.append(", collection='").append(collection).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

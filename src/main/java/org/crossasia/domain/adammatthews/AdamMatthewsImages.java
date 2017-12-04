package org.crossasia.domain.adammatthews;

import org.apache.solr.client.solrj.beans.Field;

public class AdamMatthewsImages {

    @Field
    private String id;

    @Field
    private String hasModel;

    @Field
    private String image_url;

    @Field
    private String image_file;

    @Field
    private String image_text;

    @Field
    private int book_id;

    @Field
    private int position;

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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_file() {
        return image_file;
    }

    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }

    public String getImage_text() {
        return image_text;
    }

    public void setImage_text(String image_text) {
        this.image_text = image_text;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");

        sb.append("id='").append(id).append('\'');
        sb.append(",  hasModel='").append(hasModel).append('\'');
        sb.append(",   image_url='").append(image_url).append('\'');
        sb.append(",  image_text='").append(image_text).append('\'');
        sb.append(", image_file='").append(image_file).append('\'');
        sb.append(", position='").append(position).append('\'');
        sb.append(", book_id='").append(book_id).append('\'');

        sb.append('}');
        return sb.toString();
    }
}

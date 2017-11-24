package org.crossasia.domain.airiti;

import org.apache.solr.client.solrj.beans.Field;

public class Airiti {

    @Field
    private String id;

    @Field
    private String book_id;

    @Field
    private int position_isi;

    @Field
    private String text_tcsi;

    @Field
    private String has_model_ssim;

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

    public int getPosition_isi() {
        return position_isi;
    }

    public void setPosition_isi(int position_isi) {
        this.position_isi = position_isi;
    }

    public String getText_tcsi() {
        return text_tcsi;
    }

    public void setText_tcsi(String text_tcsi) {
        this.text_tcsi = text_tcsi;
    }

    public String getHas_model_ssim() {
        return has_model_ssim;
    }

    public void setHas_model_ssim(String has_model_ssim) {
        this.has_model_ssim = has_model_ssim;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Content{");
        sb.append("id='").append(id).append('\'');
        sb.append(",  book_id='").append(book_id).append('\'');
        sb.append(", position_isi='").append(position_isi).append('\'');
        sb.append(", has_model_ssim='").append(has_model_ssim).append('\'');
        sb.append(", text_tcsi='").append(text_tcsi).append('\'');
        sb.append('}');
        return sb.toString();
    }

}

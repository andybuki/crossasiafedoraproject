package org.crossasia.model.solr;
import com.google.gson.Gson;
import org.apache.solr.client.solrj.beans.Field;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static com.google.gson.internal.bind.util.ISO8601Utils.format;

public class Product {

    @Field
    private int books_id;

    @Field
    private String title;

    @Field
    private String title_transcription;

    @Field
    private String series_titles;

    @Field
    private String creator;

    @Field
    private String creator_transcription;

    @Field
    private String physical_description;

    @Field
    private String issued;

    @Field
    private String date;

    @Field
    private String edition;

    @Field
    private String temporal;

    @Field
    private String admin_level_1;

    @Field
    private String admin_level_2;

    @Field
    private String admin_type;

    @Field
    private String spatial;

    @Field
    private String tgaz_api;

    @Field
    private String chgis;

    @Field
    private float latitude;

    @Field
    private float longitude;

    @Field
    private String language;

    @Field
    private String url;

    @Field
    private String responsibility;

    @Field
    private String comment;


    public int getBooks_id() {
        return books_id;
    }

    public void setBooks_id(int books_id) {
        this.books_id = books_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_transcription() {
        return title_transcription;
    }

    public void setTitle_transcription(String title_transcription) {
        this.title_transcription = title_transcription;
    }

    public String getSeries_titles() {
        return series_titles;
    }

    public void setSeries_titles(String series_titles) {
        this.series_titles = series_titles;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator_transcription() {
        return creator_transcription;
    }

    public void setCreator_transcription(String creator_transcription) {
        this.creator_transcription = creator_transcription;
    }

    public String getPhysical_description() {
        return physical_description;
    }

    public void setPhysical_description(String physical_description) {
        this.physical_description = physical_description;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getTemporal() {
        return temporal;
    }

    public void setTemporal(String temporal) {
        this.temporal = temporal;
    }

    public String getAdmin_level_1() {
        return admin_level_1;
    }

    public void setAdmin_level_1(String admin_level_1) {
        this.admin_level_1 = admin_level_1;
    }

    public String getAdmin_level_2() {
        return admin_level_2;
    }

    public void setAdmin_level_2(String admin_level_2) {
        this.admin_level_2 = admin_level_2;
    }

    public String getAdmin_type() {
        return admin_type;
    }

    public void setAdmin_type(String admin_type) {
        this.admin_type = admin_type;
    }

    public String getSpatial() {
        return spatial;
    }

    public void setSpatial(String spatial) {
        this.spatial = spatial;
    }

    public String getTgaz_api() {
        return tgaz_api;
    }

    public void setTgaz_api(String tgaz_api) {
        this.tgaz_api = tgaz_api;
    }

    public String getChgis() {
        return chgis;
    }

    public void setChgis(String chgis) {
        this.chgis = chgis;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Product{");

        sb.append("books_id='").append(books_id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", title_transcription='").append(title_transcription).append('\'');
        sb.append(", series_titles='").append(series_titles).append('\'');
        sb.append(", creator='").append(creator).append(",").append('\'');
        sb.append(", creator_transcription='").append(creator_transcription).append('\'');
        sb.append(", physical_description='").append(physical_description).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", issued='").append(issued).append('\'');
        sb.append(", edition='").append(edition).append('\'');
        sb.append(", temporal='").append(temporal).append('\'');
        sb.append(", admin_level_1='").append(admin_level_1).append('\'');
        sb.append(", admin_level_2='").append(admin_level_2).append('\'');
        sb.append(", admin_type='").append(admin_type).append('\'');
        sb.append(", spatial='").append(spatial).append('\'');
        sb.append(", tgaz_api='").append(tgaz_api).append('\'');
        sb.append(", chgis='").append(chgis).append('\'');
        sb.append(", latitude='").append(longitude).append('\'');
        sb.append(", longitude='").append(longitude).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", responsibility='").append(responsibility).append('\'');
        sb.append(", comment='").append(comment).append('\'');

        sb.append('}');
        return sb.toString();
    }
}

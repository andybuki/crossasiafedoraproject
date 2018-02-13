package org.crossasia.domain.localgazeetter;
import com.google.gson.Gson;
import org.apache.solr.client.solrj.beans.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.google.gson.internal.bind.util.ISO8601Utils.format;

public class Product {

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
    private int issued;

    @Field
    private int date;

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
    private String collection;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String series_title) {
        this.series_title = series_title;
    }

    @Field
    private String url;

    @Field
    private String responsibility;

    @Field
    private String comment;

    public String getHasModel() {
        return hasModel;
    }

    public void setHasModel(String hasModel) {
        this.hasModel = hasModel;
    }

    public String[] getTitle_transcription() {
        return title_transcription;
    }

    public void setTitle_transcription(String[] title_transcription) {
        this.title_transcription = title_transcription;
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




    public String [] getCreator_transcription() {
        return creator_transcription;
    }

    public void setCreator_transcription(String []creator_transcription) {
        this.creator_transcription = creator_transcription;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String[] getMedium() {
        return medium;
    }

    public void setMedium(String[] medium) {
        this.medium = medium;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
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
        if (sb.toString().equals("")) {
            sb.append("id='").append(id).append('\'');
            sb.append(", title='").append(title).append('\'');
            sb.append(", hasModel='").append("Book").append('\'');
            sb.append(", title_transcription='").append(title_transcription).append('\'');
            sb.append(", series_title='").append(series_title).append('\'');
            sb.append(", book_id='").append(book_id).append('\'');
            sb.append(", collection='").append(collection).append('\'');
            sb.append(", author='").append(author).append('\'');
            sb.append(", creator_transcription='").append(creator_transcription).append('\'');
            sb.append(", medium='").append(medium).append('\'');
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
        }
        return sb.toString();
    }
}

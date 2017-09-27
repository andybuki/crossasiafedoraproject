package org.crossasia.model.solr;

import org.apache.solr.client.solrj.beans.Field;

public class Section {

    @Field
    private int id;

    @Field
    private String name;

    @Field
    private String books_id;

    @Field
    private int start_page;

    @Field
    private int end_page;

    @Field
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBooks_id() {
        return books_id;
    }

    public void setBooks_id(String books_id) {
        this.books_id = books_id;
    }

    public int getStart_page() {
        return start_page;
    }

    public void setStart_page(int start_page) {
        this.start_page = start_page;
    }

    public int getEnd_page() {
        return end_page;
    }

    public void setEnd_page(int end_page) {
        this.end_page = end_page;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Section{");

        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", books_id='").append(books_id).append('\'');
        sb.append(", start_page='").append(start_page).append('\'');
        sb.append(", end_page='").append(end_page).append('\'');
        sb.append(", level='").append(level).append('\'');

        sb.append('}');

        return sb.toString();
    }

}

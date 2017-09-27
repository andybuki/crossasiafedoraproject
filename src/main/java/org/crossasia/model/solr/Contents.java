package org.crossasia.model.solr;

import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;

public class Contents {

    private ArrayList<Content> content;

    public ArrayList<Content> getContent() {
        return content;
    }

    public void setContent(ArrayList<Content> content) {
        this.content = content;
    }
}

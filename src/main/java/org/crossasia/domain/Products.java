package org.crossasia.domain;

import org.crossasia.domain.adammatthews.AdamMatthews;
import org.crossasia.domain.adammatthews.AdamMatthewsImages;
import org.crossasia.domain.airiti.Airiti;
import org.crossasia.domain.airiti.AiritiMetadata;
import org.crossasia.domain.localgazeetter.Content;
import org.crossasia.domain.localgazeetter.Section;
import org.crossasia.domain.reminrebao.Pages;

import java.util.ArrayList;

public class Products {

    private ArrayList<Content> products;

    public ArrayList<Content> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Content> products) {
        this.products = products;
    }

}

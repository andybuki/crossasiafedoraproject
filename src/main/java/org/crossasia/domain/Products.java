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

    private ArrayList<AdamMatthews> products;

    public ArrayList<AdamMatthews> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<AdamMatthews> products) {
        this.products = products;
    }

}

package com.kazelin.dan.dnd_items_generator.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Item {

    private String itemName;

    private String itemRarity;

    private String itemUrl;

    public Item(String itemName, String itemRarity, String itemUrl) {
        this.itemName = itemName;
        this.itemRarity = itemRarity;
        this.itemUrl = itemUrl;
    }

    public Item() {
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemRarity() {
        return itemRarity;
    }

    public String getItemUrl() {
        return itemUrl;
    }
}

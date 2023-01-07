package com.kazelin.dan.dnd_items_generator.repository;

import com.kazelin.dan.dnd_items_generator.model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

@Component
public class DndItemsRepository {

    private ArrayList<Item> item = new ArrayList<Item>();

    private String baseUrl = "https://dnd.su/";

    private Integer counter = 0;

    public HashMap<String, String> getItems(String rarity) throws IOException {

        if(counter == 0) {
            getItemsList();
        }
        counter++;
        HashMap<String, String> result = new HashMap<>();
        ArrayList<Item> ar1 = itemOnRaritySorter(rarity);
        Integer randomNumber = new Random().nextInt(ar1.size());
        result.put("item_name", ar1.get(randomNumber).getItemName());
        result.put("item_rarity", ar1.get(randomNumber).getItemRarity());
        result.put("item_uri", ar1.get(randomNumber).getItemUrl());

       Document doc = Jsoup.connect(baseUrl + result.get("item_uri")).get();
        result.put("item_definition", doc.select("div.paper-1.card.coner-.active").toString());
        return result;
    }

    private void getItemsList() throws IOException {
        Document doc = Jsoup.connect(baseUrl + "items/").get();
        Elements el1 = doc.select("a.list-item-wrapper");
        for(Element el : el1) {
            item.add(new Item(el.select("div.list-item-title").text(), el.select(
                    "span.list-icon__quality").attr("title"), el.select("a").attr("href").toString()));
        }
        ArrayList<String> rt = new ArrayList<>();
        for(Item it : item){
            rt.add(it.getItemRarity());
        }
        var mySet = Set.of(rt);

        System.out.println(mySet);
    }

    private ArrayList<Item> itemOnRaritySorter(String rarity) {
        ArrayList<Item> result = new ArrayList<>();
        for(Item item1 : item) {
            if(item1.getItemRarity().equals(rarity)) {
                result.add(item1);
            }
        }
        return result;
    }
}

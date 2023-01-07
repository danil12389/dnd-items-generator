package com.kazelin.dan.dnd_items_generator.controller;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.kazelin.dan.dnd_items_generator.model.Item;
import com.kazelin.dan.dnd_items_generator.repository.DndItemsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RestController
@CrossOrigin("http://85.193.82.89:8080")
public class GenerationController {

    private DndItemsRepository dndItemsRepository;

    public GenerationController(DndItemsRepository dndItemsRepository) {
        this.dndItemsRepository = dndItemsRepository;
    }


    @GetMapping("/common")
    public String getCommonItem() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dndItemsRepository.getItems("Обычный"));
        return json;

    }

    @GetMapping("/uncommon")
    public String getUncommonItem() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dndItemsRepository.getItems("Необычный"));
        return json;
    }

    @GetMapping("/rare")
    public String getRareItem() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dndItemsRepository.getItems("Редкий"));
        return json;
    }

    @GetMapping("/ultra_rare")
    public String getUltraRareItem() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dndItemsRepository.getItems("Очень редкий"));
        return json;
    }

    @GetMapping("/legendary")
    public String getLegendaryItem() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dndItemsRepository.getItems("Легендарный"));
        return json;
    }

    @GetMapping("/artifact")
    public String getArtifactItem() throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(dndItemsRepository.getItems("Артефакт"));
        return json;
    }


}

package com.example.spring160.controllers;

import com.example.spring160.models.ItemModel;
import com.example.spring160.models.enums.Type;
import com.example.spring160.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/addItem")
public class AddItemController {

    private final ItemRepo itemRepo;

    public AddItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String getAddPage(){
        return "addItem";
    }

    @PostMapping
    public RedirectView setData(@RequestParam String name,
                                @RequestParam String disc,
                                @RequestParam int price,
                                @RequestParam int weight,
                                @RequestParam String url,
                                @RequestParam String type){

        ItemModel itemModel = new ItemModel();
        itemModel.setName(name);
        itemModel.setDisc(disc);
        itemModel.setPrice(price);
        itemModel.setUrl(url);
        itemModel.setWeight(weight);
        switch (type){
            case "Елка":
                itemModel.setType(Type.CHRISTMAS_TREES);
                break;
            case "Игрушка":
                itemModel.setType(Type.TOYS);
                break;
            case "Украшение":
                itemModel.setType(Type.DECORATIONS);
                break;
            case "Гирлянда":
                itemModel.setType(Type.LIGHTS);
                break;
            case "Подарок":
                itemModel.setType(Type.PRESENTS);
                break;
        }
        itemRepo.save(itemModel);
        return new RedirectView("/");
    }
}

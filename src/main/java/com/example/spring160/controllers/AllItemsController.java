package com.example.spring160.controllers;

import com.example.spring160.models.ItemModel;
import com.example.spring160.repos.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class AllItemsController {

    private final ItemRepo itemRepo;

    public AllItemsController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }


    @GetMapping
    public String getPage(Model model){
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("list", list);
        return "allItems";
    }
}

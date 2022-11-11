package com.example.spring160.controllers;

import com.example.spring160.models.ItemModel;
import com.example.spring160.repos.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class DetailItem {
    private final ItemRepo itemRepo;

    public DetailItem(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/{id}")
    public String getDetailItem(@PathVariable long id,
                                Model model){
        ItemModel itemModel = itemRepo.findItemModelById(id);
        model.addAttribute("model", itemModel);
        return "detailItem";
    }

}

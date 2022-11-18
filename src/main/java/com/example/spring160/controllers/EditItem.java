package com.example.spring160.controllers;

import com.example.spring160.repos.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/edit")
public class EditItem {
    private final ItemRepo itemRepo;

    public EditItem(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/del/{id}")
    public RedirectView delete(@PathVariable long id){
        itemRepo.deleteById(id);
        return new RedirectView("/items");
    }
}

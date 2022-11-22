package com.example.spring160.controllers;

import com.example.spring160.models.ItemModel;
import com.example.spring160.models.enums.Type;
import com.example.spring160.repos.ItemRepo;
import com.example.spring160.services.FirebaseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/items")
public class AllItemsController {

    private final ItemRepo itemRepo;

    @Autowired
    private FirebaseImageService firebaseImageService;

    public AllItemsController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }


    @GetMapping
    public String getPage(Model model){
        List<ItemModel> list = itemRepo.findAll();
        for (ItemModel i: list){
            i.setUrl(firebaseImageService.getPhotoUrl(i.getUrl()));
        }
        model.addAttribute("list", list);
        return "allItems";
    }
    @GetMapping("/tress")
    public String getTress(Model model){
        List<ItemModel> list = itemRepo.findAll();
        for (ItemModel i: list){
            i.setUrl(firebaseImageService.getPhotoUrl(i.getUrl()));
        }
        list = list.stream().filter(i -> i.getType().equals(Type.CHRISTMAS_TREES)).collect(Collectors.toList());
        model.addAttribute("list", list);
        return "allItems";
    }

    @GetMapping("/toys")
    public String getToys(Model model){
        List<ItemModel> list = itemRepo.findAll();
        for (ItemModel i: list){
            i.setUrl(firebaseImageService.getPhotoUrl(i.getUrl()));
        }
        list = list.stream().filter(i -> i.getType().equals(Type.TOYS)).collect(Collectors.toList());
        model.addAttribute("list", list);
        return "allItems";
    }

    @GetMapping("/decorations")
    public String getDec(Model model){
        List<ItemModel> list = itemRepo.findAll();
        for (ItemModel i: list){
            i.setUrl(firebaseImageService.getPhotoUrl(i.getUrl()));
        }
        list = list.stream().filter(i -> i.getType().equals(Type.DECORATIONS)).collect(Collectors.toList());
        model.addAttribute("list", list);
        return "allItems";
    }

    @GetMapping("/lights")
    public String getLights(Model model){
        List<ItemModel> list = itemRepo.findAll();
        for (ItemModel i: list){
            i.setUrl(firebaseImageService.getPhotoUrl(i.getUrl()));
        }
        list = list.stream().filter(i -> i.getType().equals(Type.LIGHTS)).collect(Collectors.toList());
        model.addAttribute("list", list);
        return "allItems";
    }
    @GetMapping("/presents")
    public String getPresents(Model model){
        List<ItemModel> list = itemRepo.findAll();
        for (ItemModel i: list){
            i.setUrl(firebaseImageService.getPhotoUrl(i.getUrl()));
        }
        list = list.stream().filter(i -> i.getType().equals(Type.PRESENTS)).collect(Collectors.toList());
        model.addAttribute("list", list);
        return "allItems";
    }
}

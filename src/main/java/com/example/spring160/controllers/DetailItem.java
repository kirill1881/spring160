package com.example.spring160.controllers;

import com.example.spring160.models.ItemModel;
import com.example.spring160.models.helpers.BufferItem;
import com.example.spring160.repos.ItemRepo;
import com.example.spring160.services.CurrencyService;
import com.example.spring160.services.FirebaseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail")
public class DetailItem {
    private final ItemRepo itemRepo;
    private final CurrencyService currencyService;

    @Autowired
    private FirebaseImageService firebaseImageService;

    public DetailItem(ItemRepo itemRepo, CurrencyService currencyService) {
        this.itemRepo = itemRepo;
        this.currencyService = currencyService;

    }

    @GetMapping("/{id}")
    public String getDetailItem(@PathVariable long id,
                                Model model){
        ItemModel itemModel = itemRepo.findItemModelById(id);
        BufferItem bufferItem = new BufferItem(itemModel);
        bufferItem.setUrl(firebaseImageService.getPhotoUrl(bufferItem.getUrl()));
        try {
            bufferItem.setEurPrice(round(currencyService.getEurPrice(itemModel.getPrice()), 2)+" eur");
            bufferItem.setUsdPrice(round(currencyService.getUsdPrice(itemModel.getPrice()), 2)+" usd");
        } catch (Exception e) {
            bufferItem.setUsdPrice("no data");
            bufferItem.setEurPrice("no data");
            e.printStackTrace();
        }
        model.addAttribute("model", bufferItem);

        return "detailItem";
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}

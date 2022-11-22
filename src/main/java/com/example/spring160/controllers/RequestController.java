package com.example.spring160.controllers;

import com.example.spring160.models.PurchaseRequest;
import com.example.spring160.repos.PurchaseRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/request")
public class RequestController {

    private final PurchaseRepo purchaseRepo;

    public RequestController(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @PostMapping("/{id}")
    public RedirectView sendRequest(@PathVariable long id,
                                    @RequestParam String name,
                                    @RequestParam String contact){
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setContact(contact);
        purchaseRequest.setFirstName(name);
        purchaseRequest.setIdProduct(id);
        purchaseRequest.setIfWorked(false);

        purchaseRepo.save(purchaseRequest);
        return new RedirectView("/items");
    }
}

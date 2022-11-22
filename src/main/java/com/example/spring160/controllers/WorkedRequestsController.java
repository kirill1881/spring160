package com.example.spring160.controllers;

import com.example.spring160.models.PurchaseRequest;
import com.example.spring160.repos.PurchaseRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/worked")
public class WorkedRequestsController {
    private final PurchaseRepo purchaseRepo;

    public WorkedRequestsController(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @GetMapping
    public String allRequests(Model model){
        List<PurchaseRequest> list = purchaseRepo.findAllByIfWorked(true);
        model.addAttribute("requests", list);
        return "worked";
    }
    @GetMapping("/worked/{id}")
    public RedirectView setWorked(@PathVariable long id){
        PurchaseRequest purchaseRequest = purchaseRepo.findById(id);
        purchaseRequest.setIfWorked(false);
        purchaseRepo.save(purchaseRequest);
        return new RedirectView("/worked");
    }
}

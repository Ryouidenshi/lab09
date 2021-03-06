package com.example.shoppinglist.controller;

import com.example.shoppinglist.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteController {

    final PurchaseService purchaseService;

    @Autowired
    public DeleteController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(path = "/items/{id}", method = RequestMethod.DELETE)
    private String delete(@PathVariable("id") Long id) {
        purchaseService.delete(id);
        return "redirect:/items";
    }
}

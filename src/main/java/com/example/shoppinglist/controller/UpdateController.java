package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Purchase;
import com.example.shoppinglist.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class UpdateController {

    final PurchaseService purchaseService;

    @Autowired
    public UpdateController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(path = "/items/{id}", method = RequestMethod.PUT)
    private String update(@PathVariable("id") Long id,
                          @ModelAttribute("text") String text) {
        purchaseService.update(new Purchase(id, text));
        return "redirect:/items";
    }
}

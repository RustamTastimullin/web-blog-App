package ru.springapp.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springapp.blog.model.Purchase;
import ru.springapp.blog.repo.PurchaseRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/purchase")
    public String purchaseMain(Model model) {
        Iterable<Purchase> purchases = purchaseRepository.findAll();
        model.addAttribute("purchases", purchases);
        return "purchaseTemplates/purchaseMain";
    }

    @GetMapping("/purchase/add")
    public String purchaseAddPage(Model model) {
        return "purchaseTemplates/purchaseAdd";
    }

    @PostMapping("/purchase/add")
    public String purchaseAdd (@RequestParam String inNumber, @RequestParam String outNumber, @RequestParam String link, @RequestParam String price, @RequestParam String status) {
        Purchase purchase = new Purchase(inNumber, outNumber, link, price, status);
        purchaseRepository.save(purchase);
        return "redirect:/purchase";
    }

    @GetMapping("/purchase/{id}/edit")
    public String purchaseEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!purchaseRepository.existsById(id)) {
            return "redirect:/purchase";
        }
        Optional<Purchase> purchases = purchaseRepository.findById(id);
        ArrayList<Purchase> res = new ArrayList<>();
        purchases.ifPresent(res::add);
        model.addAttribute("purchases", res);
        return "purchaseTemplates/purchaseEdit";
    }

    @PostMapping("/purchase/{id}/edit")
    public String purchaseUpdate(@PathVariable(value = "id") Long id, @RequestParam String inNumber, @RequestParam String outNumber, @RequestParam String link, @RequestParam String price, @RequestParam String status) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchase.setInNumber(inNumber);
        purchase.setOutNumber(outNumber);
        purchase.setLink(link);
        purchase.setPrice(price);
        purchase.setStatus(status);
        purchaseRepository.save(purchase);
        return "redirect:/purchase";
    }

    @PostMapping("/purchase/{id}/remove")
    public String purchaseDelete(@PathVariable(value = "id") Long id, Model model) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow();
        purchaseRepository.delete(purchase);
        return "redirect:/purchase";
    }

}

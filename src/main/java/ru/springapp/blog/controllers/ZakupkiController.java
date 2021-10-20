package ru.springapp.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springapp.blog.models.Zakupki;
import ru.springapp.blog.repo.ReestrZakupokRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ZakupkiController {
    @Autowired
    private ReestrZakupokRepository reestrZakupokRepository;

    @GetMapping("/zakupki")
    public String zakupkiMain(Model model) {
        Iterable<Zakupki> reestrZakupok = reestrZakupokRepository.findAll();
        model.addAttribute("reestrZakupok", reestrZakupok);
        return "zakupkiAppTemplates/zakupki-main";
    }

    @GetMapping("/zakupki/add")
    public String zakupkiAddPage(Model model) {
        return "zakupkiAppTemplates/zakupki-add";
    }

    @PostMapping("/zakupki/add")
    public String zakupkiAdd (@RequestParam String inNumber, @RequestParam String outNumber, @RequestParam String link, @RequestParam String price, @RequestParam String status) {
        Zakupki zakupki = new Zakupki(inNumber, outNumber, link, price, status);
        reestrZakupokRepository.save(zakupki);
        return "redirect:/zakupki";
    }

    @GetMapping("/zakupki/{id}/edit")
    public String zakupkiEdit(@PathVariable(value = "id") long id, Model model) {
        if (!reestrZakupokRepository.existsById(id)) {
            return "redirect:/zakupki";
        }
        Optional<Zakupki> zakupki = reestrZakupokRepository.findById(id);
        ArrayList<Zakupki> res = new ArrayList<>();
        zakupki.ifPresent(res::add);
        model.addAttribute("zakupki", res);
        return "zakupkiAppTemplates/zakupki-edit";
    }

    @PostMapping("/zakupki/{id}/edit")
    public String zakupkiUpdate(@PathVariable(value = "id") long id, @RequestParam String inNumber, @RequestParam String outNumber, @RequestParam String link, @RequestParam String price, @RequestParam String status) {
        Zakupki zakupki = reestrZakupokRepository.findById(id).orElseThrow();
        zakupki.setInNumber(inNumber);
        zakupki.setOutNumber(outNumber);
        zakupki.setLink(link);
        zakupki.setPrice(price);
        zakupki.setStatus(status);
        reestrZakupokRepository.save(zakupki);
        return "redirect:/zakupki";
    }

    @PostMapping("/zakupki/{id}/remove")
    public String zakupkiDelete(@PathVariable(value = "id") long id, Model model) {
        Zakupki zakupki = reestrZakupokRepository.findById(id).orElseThrow();
        reestrZakupokRepository.delete(zakupki);
        return "redirect:/zakupki";
    }

}

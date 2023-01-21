package com.example.website.website.controller;

import com.example.website.website.entity.Nasabah;
import com.example.website.website.entity.Provider;
import com.example.website.website.entity.Rekening;
import com.example.website.website.service.NasabahService;
import com.example.website.website.service.ProviderService;
import com.example.website.website.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tambahrekening")
public class NasabahController {

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private NasabahService nasabahService;

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String index(Model model) {
        List<Provider> providers = this.providerService.getAll();
        List<Rekening> rekening = this.rekeningService.getAll();
        model.addAttribute("rekening", rekening);
        model.addAttribute("providers", providers);
        model.addAttribute("rekeningModel", new Rekening());
        model.addAttribute("providerModel", new Provider());
        model.addAttribute("nasabahModel", new Nasabah());
        return "tambahrekening";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute("nasabahModel") Nasabah nasabah,
            @ModelAttribute("rekeningModel") Rekening rekening,
            @ModelAttribute("providerModel") Provider provider, Model model) {

        Provider p = this.providerService.findByName(provider.getName());
        this.rekeningService.save(rekening);
        rekening.setNasabah(nasabah);

        rekening.setProvider(p);
        /*rekening.setSaldo(1000000);*/
        /*this.providerService.save(provider);*/
        this.nasabahService.save(nasabah);
        return "redirect:/tambahrekening";


    }
}

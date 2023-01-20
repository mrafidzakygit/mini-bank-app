package com.example.website.website.controller;

import com.example.website.website.entity.Provider;
import com.example.website.website.entity.Rekening;
import com.example.website.website.service.NasabahService;
import com.example.website.website.service.ProviderService;
import com.example.website.website.service.RekeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bankprovider")
public class ProviderController {

    @Autowired
    private NasabahService nasabahService;

    @Autowired
    private RekeningService rekeningService;

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String index(Model model){
        List<Provider> providers = this.providerService.getAll();
        model.addAttribute("providerModel", new Provider());
        model.addAttribute("provider", providers);
        return "providerView";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("providerModel") Provider provider,
                       Model model, BindingResult result,
                       RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            return "providerView";
        }
      this.providerService.save(provider);
        redirectAttributes.addFlashAttribute("sukses", "Data Berhasil Dimasukan");
      return "redirect:/bankprovider";
    }




}

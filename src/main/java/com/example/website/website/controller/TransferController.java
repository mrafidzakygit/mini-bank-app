package com.example.website.website.controller;

import com.example.website.website.entity.Nasabah;
import com.example.website.website.entity.Provider;
import com.example.website.website.entity.Rekening;
import com.example.website.website.entity.Transfer;
import com.example.website.website.repository.RekeningRepo;
import com.example.website.website.service.NasabahService;
import com.example.website.website.service.ProviderService;
import com.example.website.website.service.RekeningService;
import com.example.website.website.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private RekeningService rekeningService;
    @Autowired
    private NasabahService nasabahService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private TransferService transferService;

    @Autowired
    private RekeningRepo rekeningRepo;



    @GetMapping
    public String index(Model model){
        List<Provider> providers = this.providerService.getAll();
        List<Rekening> rekenings = this.rekeningService.getAll();
        List<Transfer> transfers = this.transferService.getAll();
        model.addAttribute("transfers", transfers);
        model.addAttribute("rekenings", rekenings);
        model.addAttribute("providers", providers);

        model.addAttribute("transferModel", new Transfer());
        model.addAttribute("rekeningModel", new Rekening());
        model.addAttribute("providerModel", new Provider());
        model.addAttribute("nasabahModel", new Nasabah());
        return "transfer";
    }
    @PostMapping("/save")
    public String save(
            @ModelAttribute("transferModel")Transfer transfer,
            Model model){
        List<Rekening> rekenings = this.rekeningService.getAll();
        List<Transfer> transfers = this.transferService.getAll();
        Rekening rekeningPengirim = rekeningService.findByNoRek(transfer.getPengirim().getNoRekening());
        Rekening rekeningPenerima = rekeningService.findByNoRek(transfer.getPenerima().getNoRekening());
        Long idPengirim = rekeningPengirim.getId();
        Long idPenerima = rekeningPenerima.getId();

        Optional<Rekening> pengirim = this.rekeningService.getRekById(idPengirim);
        Optional<Rekening> penerima = this.rekeningService.getRekById(idPenerima);
        Rekening rekPengirim = pengirim.get();
        Rekening rekPenerima = penerima.get();
        double jumlah = transfer.getJumlah();
        this.transferService.save(transfer);
        return "redirect:/transfer";
    }
}

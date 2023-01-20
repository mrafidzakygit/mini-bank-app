package com.example.website.website.controller;

import com.example.website.website.entity.History;
import com.example.website.website.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private HistoryService historyService;

    public String index(Model model){
        List<History> histories = this.historyService.getAll();
        model.addAttribute("histories", histories);
        return "history";
    }

}

package com.example.website.website.controller;

import com.example.website.website.entity.History;
import com.example.website.website.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public String index(Model model){
        List<History> history = this.historyService.getAll();
        model.addAttribute("history", history);
        return "history";
    }

}

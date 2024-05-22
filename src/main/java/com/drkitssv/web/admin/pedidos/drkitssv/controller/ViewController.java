package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("Mainmessage", "Registros");
        model.addAttribute("message", "Recursos");
        return "home";
    }

    @GetMapping("/default")
    public String defaultPage(Model model) {
        model.addAttribute("message", "Default Page");
        return "layout/layout";
    }
}

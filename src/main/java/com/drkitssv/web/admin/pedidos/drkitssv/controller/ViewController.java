package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("registrosmessage", "Registros");
        model.addAttribute("recursosmessage", "Recursos");
        model.addAttribute("estadisticasmessage", "Estadisticas");
        return "home";
    }

    @GetMapping("/default")
    public String defaultPage(Model model) {
        model.addAttribute("message", "Default Page");
        return "layout/layout";
    }
}

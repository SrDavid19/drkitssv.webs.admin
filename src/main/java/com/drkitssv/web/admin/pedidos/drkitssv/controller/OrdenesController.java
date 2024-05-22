package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdenesController {

    @GetMapping("/ordenes")
    public String ordenes(Model model) {
        model.addAttribute("message", "Ordenes");
        model.addAttribute("title", "Ordenes");
        return "ordenes";
    }
}

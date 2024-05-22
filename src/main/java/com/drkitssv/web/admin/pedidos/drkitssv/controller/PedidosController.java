package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidosController {
    
    @GetMapping("/pedidos")
    public String pedidos(Model model) {
        model.addAttribute("message", "Pedidos");
        model.addAttribute("title", "Pedidos");
        return "pedidos";
    }
}

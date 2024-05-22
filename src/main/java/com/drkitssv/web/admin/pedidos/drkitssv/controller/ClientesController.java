package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("message", "Registro de clientes");
        model.addAttribute("title", "Clientes");
        return "clientes";
    }
}

package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Pedidos;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IOrdenesService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IPedidosService;

import org.springframework.ui.Model;


@Controller
public class ViewController {
    @Autowired
    private IPedidosService pedidosService;
    @Autowired 
    private IOrdenesService ordenesService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("registrosmessage", "Registros");
        model.addAttribute("recursosmessage", "Recursos");
        model.addAttribute("estadisticasmessage", "Estadisticas");

        //Dashboard content
        int cantidadpedidos = pedidosService.ObtenerCantidadPedidos();
        model.addAttribute("cantidadpedidos", cantidadpedidos);
        int cantidadordenes = ordenesService.ObtenerCantidadOrdenes();
        model.addAttribute("cantidadordenes", cantidadordenes);

        long pedidosRecibidos = pedidosService.contarPedidosPorEstado(4L);
        model.addAttribute("pedidosRecibidos", pedidosRecibidos);

        long pedidosEnviados = pedidosService.contarPedidosPorEstado(3L);
        model.addAttribute("pedidosEnviados", pedidosEnviados);

        Optional<Pedidos> ultimoPedido = pedidosService.obtenerUltimoPedido();
        if (ultimoPedido.isPresent()) {
            model.addAttribute("ultimoPedido", ultimoPedido.get());
        } else {
            model.addAttribute("ultimoPedido", null);
        }
        
        return "home";
    }

    @GetMapping("/default")
    public String defaultPage(Model model) {
        model.addAttribute("message", "Default Page");
        return "layout/layout";
    }
}

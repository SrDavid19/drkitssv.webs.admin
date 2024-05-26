package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Clientes;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Ordenes;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Pedidos;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Tallas;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoCalidad;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoLocalidad;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IClientesService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IOrdenesService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IPedidosService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITallasService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITipoCalidadService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITipoLocalidadService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrdenesController {
    Logger logger = LogManager.getLogger(OrdenesController.class);
    @Autowired
    private IOrdenesService ordenesService;
    @Autowired
    private IClientesService clientesService;
    @Autowired
    private ITipoCalidadService tipocalidadService;
    @Autowired
    private ITipoLocalidadService tipolocalidadService;
    @Autowired
    private ITallasService tallasService;
    @Autowired
    private IPedidosService pedidosService;

    @GetMapping("/ordenes")
    public String ordenes(@RequestParam Map<String, Object> params, Model model) {
        model.addAttribute("message", "Ordenes");
        model.addAttribute("title", "Ordenes");

        List<Clientes> listaClientes = clientesService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        List<TipoCalidad> listaTipoCalidad = tipocalidadService.listAll();
        model.addAttribute("listaTipoCalidad", listaTipoCalidad);

        List<TipoLocalidad> listaTipoLocalidad = tipolocalidadService.listAll();
        model.addAttribute("listaTipoLocalidad", listaTipoLocalidad);

        List<Tallas> listaTallas = tallasService.listAll();
        model.addAttribute("listaTallas", listaTallas);

        List<Pedidos> listaPedidos = pedidosService.listAll();
        model.addAttribute("listaPedidos", listaPedidos);

        // Pagination
        int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Ordenes> pageOrdenes = ordenesService.getAll(pageRequest);
        int totalPage = pageOrdenes.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        model.addAttribute("ordenes", pageOrdenes.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);

        return "ordenes";
    }

    @PostMapping("/ordenes/save")
    public String SaveOrder(@ModelAttribute Ordenes orden, RedirectAttributes redirectAttributes, Model model) {
        String equipo = orden.getEquipo();
        String temp = orden.getTemporada();
        String parches = orden.getParches();
        String dorsal = orden.getNombredorsal();
        Double costo = orden.getCosto();
        Double adelanto = orden.getAdelanto();
        Double preciocliente = orden.getPreciocliente();
        Double pendiente = orden.getPendiente();
        Clientes cliente = orden.getClientes();
        TipoCalidad tipocalidad = orden.getTipocalidad();
        TipoLocalidad tipolocalidad = orden.getTipolocalidad();
        Tallas talla = orden.getTallas();
        Pedidos pedido = orden.getPedidos();
        String image = "src\\main\\resources\\static\\images\\default.png";

        Ordenes newOrden = new Ordenes();
        newOrden.setEquipo(equipo);
        newOrden.setTemporada(temp);
        newOrden.setParches(parches);
        newOrden.setNombredorsal(dorsal);
        newOrden.setCosto(costo);
        newOrden.setAdelanto(adelanto);
        newOrden.setPreciocliente(preciocliente);
        newOrden.setPendiente(pendiente);
        newOrden.setClientes(cliente);
        newOrden.setTipocalidad(tipocalidad);
        newOrden.setTipolocalidad(tipolocalidad);
        newOrden.setTallas(talla);
        newOrden.setPedidos(pedido);
        newOrden.setImage(image);
        ordenesService.save(newOrden);
        logger.info("Orden agregada al pedido {} ", pedido.getFechapedido());
        redirectAttributes.addFlashAttribute("success", "Nuevo pedido creado"); 
        
        return "redirect:/ordenes";
    }
    
}

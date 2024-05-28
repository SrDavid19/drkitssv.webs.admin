package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.EstadoPedido;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Pedidos;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Proveedores;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IEstadoService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IPedidosService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IProveedoresService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PedidosController {
    Logger logger = LogManager.getLogger(PedidosController.class);

    @Autowired
    private IPedidosService pedidosService;
    @Autowired
    private IProveedoresService proveedoresService;
    @Autowired
    private IEstadoService estadoService;

    @GetMapping("/pedidos")
    public String pedidos(@RequestParam Map<String, Object> params, Model model) {
        model.addAttribute("message", "Pedidos");
        model.addAttribute("title", "Pedidos");

        List<Proveedores> listaProveedores = proveedoresService.listAll();
        model.addAttribute("listaProveedores", listaProveedores);

        List<EstadoPedido> listaEstados = estadoService.listAll();
        model.addAttribute("listaEstados", listaEstados);

        // Pagination
        int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString()) - 1 : 0;
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Pedidos> pagePedidos = pedidosService.getAll(pageRequest);
        int totalPage = pagePedidos.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pages", pages);
        }
        model.addAttribute("pedidos", pagePedidos.getContent());
        model.addAttribute("current", page + 1);
        model.addAttribute("next", page + 2);
        model.addAttribute("prev", page);
        model.addAttribute("last", totalPage);

        return "pedidos";
    }

    @GetMapping("/pedidosdetalle/{id}")
    public String detallesPedido(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Pedidos> pedido = pedidosService.findById(id);
        
        Date fechapedidoopt = pedido.get().getFechapedido();
        Double gananciaBrutatotal = pedido.get().getGananciabrutatotal();
        Double gananciaNetatotal = pedido.get().getGananciabrutatotal();
        Double inversionTotal = pedido.get().getInversiontotal();

        if (pedido.isPresent()) {
            model.addAttribute("pedido", pedido.get());
            model.addAttribute("fechapedido", fechapedidoopt);
            model.addAttribute("gananciaBrutaindividual", gananciaBrutatotal/2);
            model.addAttribute("gananciaNetaindividual", gananciaNetatotal/2);
            model.addAttribute("inversionindividual", inversionTotal/2);
            return "pedidosdetalle";
        } else {
            
            redirectAttributes.addFlashAttribute("error", "Pedido no encontrado"); 
            return "redirect:/pedidos";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/pedidos/save")
    public String SavePedido(@ModelAttribute Pedidos pedidos, RedirectAttributes redirectAttributes, Model model) {
        
        Date fechapedido = pedidos.getFechapedido();
        Proveedores proveedor = pedidos.getProveedor();
        EstadoPedido estado = pedidos.getEstadopedido();

        Pedidos newpedido = new Pedidos();
        newpedido.setFechapedido(fechapedido);
        newpedido.setProveedor(proveedor);
        newpedido.setEstadopedido(estado);
        newpedido.setCostototal(0.00);
        newpedido.setAdelantototal(0.00);
        newpedido.setCostoretiro(0.00);
        newpedido.setInversiontotal(0.00);
        newpedido.setIngresototal(0.00);
        newpedido.setPendientetotal(0.00);
        newpedido.setGananciabrutatotal(0.00);
        newpedido.setGanancianetatotal(0.00);
        newpedido.setCodigorastreo("-");
        pedidosService.save(newpedido);
        logger.info("Pedido agregado. Fecha: {}, Proveedor: {}, Estado: {}", fechapedido, proveedor.getNombre(), estado.getEstado());
        redirectAttributes.addFlashAttribute("success", "Nuevo pedido creado"); 
        
        return "redirect:/pedidos";
    }
    
}

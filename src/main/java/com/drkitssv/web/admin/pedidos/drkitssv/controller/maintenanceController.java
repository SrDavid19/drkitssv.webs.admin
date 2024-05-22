package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.EstadoPedido;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Proveedores;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Tallas;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoCalidad;
import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoLocalidad;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IEstadoService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IProveedoresService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITallasService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITipoCalidadService;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITipoLocalidadService;

@Controller
@RequestMapping("/maintenance/")
public class maintenanceController {

    @Autowired
    private IEstadoService estadoService;
    @Autowired
    private IProveedoresService proveedoresService;
    @Autowired
    private ITallasService tallasService;
    @Autowired
    private ITipoCalidadService tipocalidadservice;
	@Autowired
	private ITipoLocalidadService tipolocalidadService;

    @GetMapping("/estadopedido")
    public String mtoEstado(@RequestParam Map<String, Object> params, Model model){
        model.addAttribute("message", "Estado pedido");
        model.addAttribute("title", "Estado");

        //Pagination
        int page = params.get("page") !=null ? Integer.valueOf(params.get("page").toString()) -1 : 0;
	    PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("id").ascending());
	    Page<EstadoPedido> pageEstados = estadoService.getAll(pageRequest);
	    int totalPage = pageEstados.getTotalPages();
	    if(totalPage > 0) {
	        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	        model.addAttribute("pages", pages);
	    }
	    model.addAttribute("estados", pageEstados.getContent());
	    model.addAttribute("current", page + 1);
	    model.addAttribute("next", page + 2);
	    model.addAttribute("prev", page);
	    model.addAttribute("last", totalPage);
        return "estadopedido";
    }

    @GetMapping("/proveedores")
    public String mtoProveedores(@RequestParam Map<String, Object> params, Model model){
        model.addAttribute("message", "Proveedores");
        model.addAttribute("title", "Proveedores");

        //Pagination
        int page = params.get("page") !=null ? Integer.valueOf(params.get("page").toString()) -1 : 0;
	    PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("id").descending());
	    Page<Proveedores> pageProveedores = proveedoresService.getAll(pageRequest);
	    int totalPage = pageProveedores.getTotalPages();
	    if(totalPage > 0) {
	        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	        model.addAttribute("pages", pages);
	    }
	    model.addAttribute("proveedores", pageProveedores.getContent());
	    model.addAttribute("current", page + 1);
	    model.addAttribute("next", page + 2);
	    model.addAttribute("prev", page);
	    model.addAttribute("last", totalPage);

        return "proveedores";
    }

    @GetMapping("/tallas")
    public String mtoTallas(@RequestParam Map<String, Object> params, Model model){
        model.addAttribute("message", "Tallas");
        model.addAttribute("title", "Tallas");

        //Pagination
        int page = params.get("page") !=null ? Integer.valueOf(params.get("page").toString()) -1 : 0;
	    PageRequest pageRequest = PageRequest.of(page, 5, Sort.by("id").ascending());
	    Page<Tallas> pageTallas = tallasService.getAll(pageRequest);
	    int totalPage = pageTallas.getTotalPages();
	    if(totalPage > 0) {
	        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	        model.addAttribute("pages", pages);
	    }
	    model.addAttribute("tallas", pageTallas.getContent());
	    model.addAttribute("current", page + 1);
	    model.addAttribute("next", page + 2);
	    model.addAttribute("prev", page);
	    model.addAttribute("last", totalPage);

        return "tallas";
    }

    @GetMapping("/tipocalidad")
    public String mtoTipoCalidad(@RequestParam Map<String, Object> params, Model model){
        model.addAttribute("message", "Tipo Calidad");
        model.addAttribute("title", "Tipo Calidad");

        //Pagination
        int page = params.get("page") !=null ? Integer.valueOf(params.get("page").toString()) -1 : 0;
	    PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").ascending());
	    Page<TipoCalidad> pageTipoCalidad = tipocalidadservice.getAll(pageRequest);
	    int totalPage = pageTipoCalidad.getTotalPages();
	    if(totalPage > 0) {
	        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	        model.addAttribute("pages", pages);
	    }
	    model.addAttribute("tiposcalidad", pageTipoCalidad.getContent());
	    model.addAttribute("current", page + 1);
	    model.addAttribute("next", page + 2);
	    model.addAttribute("prev", page);
	    model.addAttribute("last", totalPage);

        return "tipocalidad";
    }  
    
    @GetMapping("/tipolocalidad")
    public String mtoTipoLocalidad(@RequestParam Map<String, Object> params, Model model){
        model.addAttribute("message", "Tipo Localidad");
        model.addAttribute("title", "Tipo Localidad");

		//Pagination
        int page = params.get("page") !=null ? Integer.valueOf(params.get("page").toString()) -1 : 0;
	    PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").ascending());
	    Page<TipoLocalidad> pageTipoLocalidad = tipolocalidadService.getAll(pageRequest);
	    int totalPage = pageTipoLocalidad.getTotalPages();
	    if(totalPage > 0) {
	        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	        model.addAttribute("pages", pages);
	    }
	    model.addAttribute("tiposlocalidad", pageTipoLocalidad.getContent());
	    model.addAttribute("current", page + 1);
	    model.addAttribute("next", page + 2);
	    model.addAttribute("prev", page);
	    model.addAttribute("last", totalPage);

        return "tipolocalidad";
    }  
}

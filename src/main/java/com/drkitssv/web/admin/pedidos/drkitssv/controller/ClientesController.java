package com.drkitssv.web.admin.pedidos.drkitssv.controller;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Clientes;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IClientesService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClientesController {
	Logger logger = LogManager.getLogger(ClientesController.class);

    @Autowired
    private IClientesService clientesService;

    @GetMapping("/clientes")
    public String clientes(@RequestParam Map<String, Object> params, Model model) {
        model.addAttribute("message", "Registro de clientes");
        model.addAttribute("title", "Clientes");

        //Pagination
        int page = params.get("page") !=null ? Integer.valueOf(params.get("page").toString()) -1 : 0;
	    PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("id").ascending());
	    Page<Clientes> pageClientes = clientesService.getAll(pageRequest);
	    int totalPage = pageClientes.getTotalPages();
	    if(totalPage > 0) {
	        List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
	        model.addAttribute("pages", pages);
	    }
	    model.addAttribute("clientes", pageClientes.getContent());
	    model.addAttribute("current", page + 1);
	    model.addAttribute("next", page + 2);
	    model.addAttribute("prev", page);
	    model.addAttribute("last", totalPage);

        return "clientes";
    }

	@PostMapping("/clientes/save")
	public String saveClient(@ModelAttribute Clientes cliente, RedirectAttributes redirectAttributes, Model model) {
		String name = cliente.getNombres();
		String lastname = cliente.getApellidos();
		String contacto = cliente.getContacto();
	
		if (!name.isEmpty() && !lastname.isEmpty()) {
			if (!contacto.isEmpty()) {
				Clientes existingClient = cliente.getId() != null ? clientesService.findById(cliente.getId()) : null;
				if (existingClient != null) {
					// Actualizar cliente existente
					existingClient.setNombres(name);
					existingClient.setApellidos(lastname);
					existingClient.setContacto(contacto);
					existingClient.setCantidad(cliente.getCantidad());
					clientesService.save(existingClient);
					logger.info("Cliente actualizado. Nombre: {}, Apellido: {}, Contacto: {}", name, lastname, contacto);
					redirectAttributes.addFlashAttribute("success", "Cliente actualizado");
				} else {
					// Crear nuevo cliente
					Clientes newClient = new Clientes();
					newClient.setNombres(name);
					newClient.setApellidos(lastname);
					newClient.setContacto(contacto);
					newClient.setCantidad(0);
	
					clientesService.save(newClient);
					logger.info("Cliente agregado. Nombre: {}, Apellido: {}, Contacto: {}", name, lastname, contacto);
					redirectAttributes.addFlashAttribute("success", "Cliente agregado");
				}
			} else {
				redirectAttributes.addFlashAttribute("error", "El contacto del cliente está vacío");
			}
		} else {
			redirectAttributes.addFlashAttribute("error", "El nombre y/o apellido están vacíos");
		}
	
		return "redirect:/clientes";
	}
	
	
	@GetMapping("/clientes/{id}")
    @ResponseBody
    public Clientes getClientById(@PathVariable Long id) {
        return clientesService.findById(id);
    }
}

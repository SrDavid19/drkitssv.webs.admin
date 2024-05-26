package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Clientes;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.ClientesRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IClientesService;

@Service
public class ClientesService implements IClientesService{
    
    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public Page<Clientes> getAll(Pageable pageable){
        return clientesRepository.findAll(pageable);
    }

    @Override
    public List<Clientes> listAll(){
        return clientesRepository.findAll();
    }

    @Override
    public Clientes save(Clientes cliente){
        return clientesRepository.save(cliente);
    }

    @Override
    public Clientes findById(Long id) {
        return clientesRepository.findById(id).orElse(null);
    }
}

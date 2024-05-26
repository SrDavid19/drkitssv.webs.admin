package com.drkitssv.web.admin.pedidos.drkitssv.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Clientes;

@Service
public interface IClientesService {
    public Page<Clientes> getAll(Pageable pageable);
    public List<Clientes> listAll();
    public Clientes save(Clientes cliente);
    public Clientes findById(Long id);
}

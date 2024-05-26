package com.drkitssv.web.admin.pedidos.drkitssv.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Ordenes;

@Service
public interface IOrdenesService {
    public Page<Ordenes> getAll(Pageable pageable);
    public List<Ordenes> listAll();
    public Ordenes save(Ordenes ordenes);
}

package com.drkitssv.web.admin.pedidos.drkitssv.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Proveedores;

@Service
public interface IProveedoresService {
    public Page<Proveedores> getAll(Pageable pageable);
}

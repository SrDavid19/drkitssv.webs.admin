package com.drkitssv.web.admin.pedidos.drkitssv.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Tallas;

@Service
public interface ITallasService {
    public Page<Tallas> getAll(Pageable pageable);
}

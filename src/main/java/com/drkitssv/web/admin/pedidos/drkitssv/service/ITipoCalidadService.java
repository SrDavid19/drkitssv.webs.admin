package com.drkitssv.web.admin.pedidos.drkitssv.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoCalidad;

@Service
public interface ITipoCalidadService {
    public Page<TipoCalidad> getAll(Pageable pageable);
}

package com.drkitssv.web.admin.pedidos.drkitssv.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoLocalidad;

@Service
public interface ITipoLocalidadService {
    public Page<TipoLocalidad> getAll(Pageable pageable);
}

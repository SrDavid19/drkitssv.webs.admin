package com.drkitssv.web.admin.pedidos.drkitssv.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.EstadoPedido;

@Service
public interface IEstadoService {
    Page<EstadoPedido> getAll(Pageable pageable);
}

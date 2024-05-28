package com.drkitssv.web.admin.pedidos.drkitssv.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Pedidos;

@Service
public interface IPedidosService {
    public Page<Pedidos> getAll(Pageable pageable);
    public List<Pedidos> listAll();
    public Pedidos save(Pedidos pedidos);
    public int ObtenerCantidadPedidos();
    public long contarPedidosPorEstado(Long estadoId);
    public Optional<Pedidos> obtenerUltimoPedido();
    public Optional<Pedidos> findById(Long id);
}

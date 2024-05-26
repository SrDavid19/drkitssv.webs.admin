package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Pedidos;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.PedidoRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IPedidosService;

@Service
public class PedidosService implements IPedidosService{
    
    @Autowired
    private PedidoRepository pedidosRepository;

    @Override
    public Page<Pedidos> getAll(Pageable pageable){
        return pedidosRepository.findAll(pageable);
    }

    @Override
    public Pedidos save(Pedidos pedidos){
        return pedidosRepository.save(pedidos);
    }

    @Override
    public List<Pedidos> listAll(){
        return pedidosRepository.findAll();
    }

}

package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.EstadoPedido;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.EstadoRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IEstadoService;

@Service
public class EstadoService implements IEstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
	public Page<EstadoPedido> getAll(Pageable pageable) {
		return estadoRepository.findAll(pageable);
	}

}

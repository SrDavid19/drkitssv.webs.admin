package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Proveedores;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.ProveedoresRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IProveedoresService;

@Service
public class ProveedoresService implements IProveedoresService{
    
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Override
    public Page<Proveedores> getAll(Pageable pageable){
        return proveedoresRepository.findAll(pageable);
    }
}

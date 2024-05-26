package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Ordenes;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.OrdenesRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.IOrdenesService;

@Service
public class OrdenesService implements IOrdenesService{
    @Autowired
    private OrdenesRepository ordenesRepository;

    @Override
    public Page<Ordenes> getAll(Pageable pageable){
        return ordenesRepository.findAll(pageable);
    }

    @Override
    public List<Ordenes> listAll(){
        return ordenesRepository.findAll();
    }

    @Override
    public Ordenes save(Ordenes ordenes){
        return ordenesRepository.save(ordenes);
    }
}

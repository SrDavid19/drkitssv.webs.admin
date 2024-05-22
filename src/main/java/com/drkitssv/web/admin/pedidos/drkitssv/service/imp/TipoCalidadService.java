package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoCalidad;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.TipoCalidadRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITipoCalidadService;

@Service
public class TipoCalidadService implements ITipoCalidadService{
    @Autowired
    private TipoCalidadRepository tipoCalidadRepository;

    @Override
    public Page<TipoCalidad> getAll(Pageable pageable){
        return tipoCalidadRepository.findAll(pageable);
    }
}

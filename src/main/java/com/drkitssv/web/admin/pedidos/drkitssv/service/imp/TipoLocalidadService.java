package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.TipoLocalidad;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.TipoLocalidadRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITipoLocalidadService;

@Service
public class TipoLocalidadService implements ITipoLocalidadService{
    @Autowired
    private TipoLocalidadRepository tipoLocalidadRepository;
    
    @Override
    public Page<TipoLocalidad> getAll(Pageable pageable){
        return tipoLocalidadRepository.findAll(pageable);
    }
}

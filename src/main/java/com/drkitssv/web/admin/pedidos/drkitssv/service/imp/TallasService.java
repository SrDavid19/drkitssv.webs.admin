package com.drkitssv.web.admin.pedidos.drkitssv.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Tallas;
import com.drkitssv.web.admin.pedidos.drkitssv.repository.TallasRepository;
import com.drkitssv.web.admin.pedidos.drkitssv.service.ITallasService;

@Service
public class TallasService implements ITallasService{
    
    @Autowired
    private TallasRepository tallasRepository;

    @Override
    public Page<Tallas> getAll(Pageable pageable){
        return tallasRepository.findAll(pageable);
    }

    @Override
    public List<Tallas> listAll(){
        return tallasRepository.findAll();
    }
}

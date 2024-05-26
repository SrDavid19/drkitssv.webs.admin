package com.drkitssv.web.admin.pedidos.drkitssv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Ordenes;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes,Long>{

}

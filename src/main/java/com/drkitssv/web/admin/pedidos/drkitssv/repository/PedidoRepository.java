package com.drkitssv.web.admin.pedidos.drkitssv.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drkitssv.web.admin.pedidos.drkitssv.model.Entity.Pedidos;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos,Long>{
    @Query("SELECT COUNT(p) FROM Pedidos p WHERE p.estadopedido.id = :estadoId")
    long countByEstadoPedido(@Param("estadoId") Long estadoId);

    List<Pedidos> findTopByOrderByFechapedidoDesc(PageRequest pageRequest);
}

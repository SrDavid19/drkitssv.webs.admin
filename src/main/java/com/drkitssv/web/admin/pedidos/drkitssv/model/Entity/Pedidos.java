package com.drkitssv.web.admin.pedidos.drkitssv.model.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LocalDateTime fechaPedido;
    private Double costoTotal;
    private Double adelantoTotal;
    private Double costoRetiro;
    private Double inversionTotal;
    private Double ingresoTotal;
    private Double pendienteTotal;
    private Double gananciaBrutaTotal;
    private Double gananciaNetaTotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstado")
    private EstadoPedido estadoPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor")
    private Proveedores proveedor;
}

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
    @Column(name = "fechapedido")
    private LocalDateTime fechapedido;
    @Column(name = "costototal")
    private Double costototal;
    @Column(name = "adelantototal")
    private Double adelantototal;
    @Column(name = "costoretiro")
    private Double costoretiro;
    @Column(name = "inversiontotal")
    private Double inversiontotal;
    @Column(name = "ingresototal")
    private Double ingresototal;
    @Column(name = "pendientetotal")
    private Double pendientetotal;
    @Column(name = "gananciabrutatotal")
    private Double gananciabrutatotal;
    @Column(name = "ganancianetatotal")
    private Double ganancianetatotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestado")
    private EstadoPedido estadopedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor")
    private Proveedores proveedor;
}

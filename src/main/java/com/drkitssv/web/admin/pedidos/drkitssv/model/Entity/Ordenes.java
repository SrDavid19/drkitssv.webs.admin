package com.drkitssv.web.admin.pedidos.drkitssv.model.Entity;

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
@Table(name = "ordenes")
@Data
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String equipo;
    private String temporada;
    private String parches;
    private String nombreDorsal;
    private Double costo;
    private Double adelanto;
    private Double precioCliente;
    private Double pendiente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Clientes clientes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoLocalidad")
    private TipoLocalidad tipoLocalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoCalidad")
    private TipoCalidad tipoCalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTalla")
    private Tallas tallas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPedido")
    private Pedidos pedidos;
}

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
    @Column(name = "equipo")
    private String equipo;
    @Column(name = "temporada")
    private String temporada;
    @Column(name = "parches")
    private String parches;
    @Column(name = "nombredorsal")
    private String nombredorsal;
    @Column(name = "costo")
    private Double costo;
    @Column(name = "adelanto")
    private Double adelanto;
    @Column(name = "preciocliente")
    private Double preciocliente;
    @Column(name = "pendiente")
    private Double pendiente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente")
    private Clientes clientes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipolocalidad")
    private TipoLocalidad tipolocalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipocalidad")
    private TipoCalidad tipocalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtalla")
    private Tallas tallas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpedido")
    private Pedidos pedidos;
}

package com.avasot.tiendaVirtual.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "PRODUCTS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "BRAND")
    private String marca;

    @Column(name = "REFERENCE")
    private String referencia;

    @Column(name = "SALE_PRICE")
    private double precioVenta;

    public Producto(String marca, String referencia, double precioVenta) {
        this.marca = marca;
        this.referencia = referencia;
        this.precioVenta = precioVenta;
    }
}

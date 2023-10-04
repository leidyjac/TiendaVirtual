package com.avasot.tiendaVirtual.dto.salida.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoSalidaDto {

    private Long id;
    private String marca;
    private String referencia;
    private double precioVenta;


    @Override
    public String toString() {
        return "Id: " + id + " - Marca " + marca + " - Referencia: " + referencia + " - PrecioDeVenta: " + precioVenta;
    }
}

package com.avasot.tiendaVirtual.service;

import com.avasot.tiendaVirtual.dto.entrada.modificacion.ProductoModificacionEntradaDto;
import com.avasot.tiendaVirtual.dto.entrada.producto.ProductoEntradaDto;
import com.avasot.tiendaVirtual.dto.salida.producto.ProductoSalidaDto;

import java.util.List;

public interface IProductoService {

    ProductoSalidaDto registrarProducto(ProductoEntradaDto producto);

    ProductoSalidaDto buscarProductoPorId(Long id);

    List<ProductoSalidaDto> listarProductos();

    ProductoSalidaDto modificarProducto(ProductoModificacionEntradaDto productoModificado);

    void eliminarProducto (Long id); // Excepciòn?

    List<ProductoSalidaDto> listarProductosPorMarca(String marca);

    ProductoSalidaDto buscarProductoPorReferencia(String referencia);

}

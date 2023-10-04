package com.avasot.tiendaVirtual.service.impl;

import com.avasot.tiendaVirtual.dto.entrada.modificacion.ProductoModificacionEntradaDto;
import com.avasot.tiendaVirtual.dto.entrada.producto.ProductoEntradaDto;
import com.avasot.tiendaVirtual.dto.salida.producto.ProductoSalidaDto;
import com.avasot.tiendaVirtual.entity.Producto;
import com.avasot.tiendaVirtual.repository.ProductoRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements com.avasot.tiendaVirtual.service.IProductoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    private final ProductoRepository productoRepository;

    private final ModelMapper modelMapper;


    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductoSalidaDto registrarProducto(ProductoEntradaDto producto) {
        Producto productoRegistrado = productoRepository.save(mapDtoEntradaToEntity(producto));
        ProductoSalidaDto productoSalidaDto = mapEntityToDtoSalida(productoRegistrado);
        LOGGER.info("Producto guardado: {}", productoSalidaDto);
        return productoSalidaDto;
    }
    @Override
    public ProductoSalidaDto buscarProductoPorId(Long id){
        Producto productoABuscar = productoRepository.findById(id).orElse(null);

        ProductoSalidaDto productoSalidaDto = null;

        if(productoABuscar != null){
            productoSalidaDto = mapEntityToDtoSalida(productoABuscar);
            LOGGER.info("Producto encontrado: {}", productoSalidaDto);
        }else{
            LOGGER.info("Producto no encontrado");
        }
        return productoSalidaDto;
    }

    @Override
    public List<ProductoSalidaDto> listarProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        LOGGER.info("Listado de Productos: {}", listaProductos);
        return listaProductos.stream().map(this::mapEntityToDtoSalida).toList();
    }

    @Override
    public ProductoSalidaDto modificarProducto(ProductoModificacionEntradaDto productoModificado) {

        ProductoSalidaDto productoSalidaDto= null;

        if(buscarProductoPorId(productoModificado.getId()) != null){
            Producto productoRegistrado = productoRepository.save(mapDtoModificadoToEntity(productoModificado));
            productoSalidaDto = mapEntityToDtoSalida(productoRegistrado);
            LOGGER.info("El producto: ¨{}, fue modificado exitosamente", productoModificado);
        }else{
            LOGGER.error("El producto: ¨{}, no pudo ser modificado porque no se encontró", productoModificado);
        }
        return productoSalidaDto;

    }

    @Override
    public void eliminarProducto(Long id) {
        Producto productoABuscar = productoRepository.findById(id).orElse(null);

        if(productoABuscar != null){
            productoRepository.deleteById(id);
            LOGGER.warn("Se elimino el producto con ID: {}", id);
        }else{
            LOGGER.error("Producto con id: {} no encontrado", id);
        }
        //exception
    }

    @Override
    public List<ProductoSalidaDto> listarProductosPorMarca(String marca){
        return null;
    }

    @Override
    public ProductoSalidaDto buscarProductoPorReferencia(String referencia) {
        return null;
    }

    public Producto mapDtoEntradaToEntity(ProductoEntradaDto productoEntradaDto){
        return modelMapper.map(productoEntradaDto, Producto.class);
    }

    public ProductoSalidaDto mapEntityToDtoSalida(Producto producto){
        return modelMapper.map(producto, ProductoSalidaDto.class);
    }

    public Producto mapDtoModificadoToEntity (ProductoModificacionEntradaDto productoModificado){
        return modelMapper.map(productoModificado, Producto.class);
    }
}

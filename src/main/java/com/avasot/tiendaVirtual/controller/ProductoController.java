package com.avasot.tiendaVirtual.controller;

import com.avasot.tiendaVirtual.dto.entrada.modificacion.ProductoModificacionEntradaDto;
import com.avasot.tiendaVirtual.dto.entrada.producto.ProductoEntradaDto;
import com.avasot.tiendaVirtual.dto.salida.producto.ProductoSalidaDto;
import com.avasot.tiendaVirtual.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private IProductoService productoService;

   @PostMapping("registrar")
    public ResponseEntity<ProductoSalidaDto> registrarProducto (@Valid @RequestBody ProductoEntradaDto producto){
       return new ResponseEntity<>(productoService.registrarProducto(producto), HttpStatus.CREATED);
   }

   @PutMapping("modificar")
    public ResponseEntity<ProductoSalidaDto> modificarProducto (@Valid @RequestBody ProductoModificacionEntradaDto productoModificado){
       return new ResponseEntity<>(productoService.modificarProducto(productoModificado), HttpStatus.OK);
   }

   @GetMapping("buscar/{id}")
    public ResponseEntity<ProductoSalidaDto> buscarPorId (@PathVariable Long id){
       return new ResponseEntity<>(productoService.buscarProductoPorId(id), HttpStatus.OK);
   }

   @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarPorId (@PathVariable Long id){
       productoService.eliminarProducto(id);
       return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.NO_CONTENT);
   }
   @GetMapping("listar")
       public ResponseEntity<List<ProductoSalidaDto>> listarProductos() {
           return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
     }
}


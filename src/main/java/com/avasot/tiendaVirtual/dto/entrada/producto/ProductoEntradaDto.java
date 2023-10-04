package com.avasot.tiendaVirtual.dto.entrada.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data // agrega getters, setters, toString,...
@AllArgsConstructor//agrega constructor con argumentos
@NoArgsConstructor // agrega constructor sin argumentos
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProductoEntradaDto {
    @NotNull(message = "La marca del producto no puede ser nula")
    @NotBlank(message = "Debe especificarse la marca del producto") // No sería mejor que la marcas fueran una tabla?
    @Pattern(regexp = "[A-Z]+", message="La marca del producto solo puede tener letras mayúsculas")
    private String marca;

    @NotNull(message = "La referencia del producto no puede ser nula")
    @NotBlank(message = "Debe especificarse la referencia del producto")
    private String referencia;
    @NotNull(message = "El precio de venta del producto no puede ser nulo")
    @Min(value = 1, message = "El precio de venta debe ser mayor a $0")
    private double precioVenta;

}

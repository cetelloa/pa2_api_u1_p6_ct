package uce.edu.ec.api.bodega;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Venta {

    private String cliente;

    private double total;

}

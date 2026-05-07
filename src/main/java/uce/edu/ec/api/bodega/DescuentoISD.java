package uce.edu.ec.api.bodega;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Priority(3)
public class DescuentoISD implements Descuento {

    @Override
    public double aplicarDescuento(double valor) {
        System.out.println("Aplicando ISD");

        return valor - (valor * 0.10);
    }

}

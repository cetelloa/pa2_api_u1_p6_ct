package uce.edu.ec.api.bodega;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Priority(2)
public class DescuentoIVA implements Descuento {

    @Override
    public double aplicarDescuento(double valor) {
        System.out.println("Aplicando iva ");

        double valorDescontar = valor * 0.15;

        return (valor - valorDescontar);
    }

}

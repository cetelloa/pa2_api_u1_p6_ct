package uce.edu.ec.api.bodega;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Priority(4)
public class DescuentoBfriday implements Descuento {

    @Override
    public double aplicarDescuento(double valor) {
        System.out.println("Aplicando Aplicando Black Friday");

        return valor - (valor * 0.12);
    }
}

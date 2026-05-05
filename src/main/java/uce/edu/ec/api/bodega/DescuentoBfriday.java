package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DescuentoBfriday implements Descuento {

    @Override
    public double aplicarDescuento(double valor) {
        System.out.println("Aplicando Aplicando Black Friday");

        return valor - (valor * 0.12);
    }
}

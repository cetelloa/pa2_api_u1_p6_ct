package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DescuentoSOLCA implements Descuento {

    @Override
    public double aplicarDescuento(double valor) {

        System.out.println("Aplicando SOLCA");

        return valor - (valor * 0.20);
    }

}

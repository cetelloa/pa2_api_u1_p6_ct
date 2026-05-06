package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImpuestoICE implements Impuesto {

    @Override
    public double aplicarImpuesto(double valor) {
        System.out.println("Aplicando Impuesto a Consumos Especiales (8%)");

        return valor + (valor * 0.08);
    }

}

package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImpuestoRenta implements Impuesto {

    @Override
    public double aplicarImpuesto(double valor) {
        System.out.println("Aplicando Impuesto a la Renta (10%)");

        return valor + (valor * 0.10);
    }

}

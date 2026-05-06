package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImpuestoMunicipal implements Impuesto {

    @Override
    public double aplicarImpuesto(double valor) {
        System.out.println("Aplicando Impuesto Municipal (2%)");

        return valor + (valor * 0.02);
    }

}

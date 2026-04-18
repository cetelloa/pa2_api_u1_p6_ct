package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComprobanteDigital implements TipoComprobante {

    @Override
    public void tipoFacutura(String destino) {
        System.out.println("La factura se enviara a su mail: "+destino + " con un formato PDF");
    }

}

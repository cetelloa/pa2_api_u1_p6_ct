package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ComprabanteSelector {

    @Inject
    private ComprobanteDigital comprobanteDigital;
    @Inject
    private ComprobanteFisico comprobanteFisico;

    public  TipoComprobante seleccionarComprobante(String destino) {
        if (destino != null) {
            //PDF
            return comprobanteDigital;
        } else {
            return comprobanteFisico;
        }
    }

}

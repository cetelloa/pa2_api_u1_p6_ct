package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComprobanteFisico implements TipoComprobante {

     
@Override
    public void tipoFacutura(String destino) {
        System.out.println("No se ha encontrado correo/ numero");
        System.out.println("Se imprimira el comprobante");
    }

}

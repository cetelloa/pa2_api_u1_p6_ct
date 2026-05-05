package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

//jackarta enterprice 
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesadorCompraService {

    // Aqui estan todas las implementaciones de descuento
    @Inject
    private Instance<Descuento> descuentos;

    public void procesar(Compra compra) {

         System.out.println("Procesando la venta.....");

         double total = compra.getSubTotal();

        for (Descuento des : descuentos) {

            total = des.aplicarDescuento(total);
        }
        compra.setTotal(total);

        System.out.println("Su valor a pagar es: " + compra.getTotal());
       

    }

}

package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesadorCompraService {

    // Aqui estan todas las implementaciones de descuento
    @Inject
    private Instance<Descuento> descuentos;

    // Aqui estan todas las implementaciones de impuestos
    @Inject
    private Instance<Impuesto> impuestos;

    public void procesar(Compra compra) {

         System.out.println("Procesando la venta.....");
         System.out.println("Subtotal: $" + compra.getSubTotal());

         double total = compra.getSubTotal();

         System.out.println("\n--- Aplicando Descuentos ---");
        for (Descuento des : descuentos) {

            total = des.aplicarDescuento(total);
        }
        
        System.out.println("Total después de descuentos: $" + total);

        System.out.println("\n--- Aplicando Impuestos ---");
        for (Impuesto imp : impuestos) {
            total = imp.aplicarImpuesto(total);
        }

        compra.setTotal(total);

        System.out.println("\nValor final a pagar: $" + compra.getTotal());
       

    }

}

package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class ProcesarVentaServiceTimepo {

    @Inject
    private EstadisticasVentasGlobales estadisticasVentasGlobales;


    @MedirTiempo
    public void procesar(Venta venta) {

        // Inicio Venta
        System.out.println("Procesando Venta");
        // consultando el stock de cada item
        // consulta en la base de datos
        // finalizacion venta

        // similar tiempo de demora

        try {

            Thread.sleep(100);

        } catch (Exception e) {

        }

        // registrar Estadisticas
        this.estadisticasVentasGlobales.resgistrarVenta(venta.getTotal());
        System.out.println("Final del pedido ");

    }


    @MedirTiempo
    public void reProcesar(Venta venta) {

        // Inicio Venta
        System.out.println("Reprocesando Venta");
        // consultando el stock de cada item
        // consulta en la base de datos
        // finalizacion venta

        // similar tiempo de demora

        try {

            Thread.sleep(250);

        } catch (Exception e) {

        }

        // registrar Estadisticas
        this.estadisticasVentasGlobales.resgistrarVenta(venta.getTotal());
        System.out.println("Finalizando el reproceso del pedido ");

    }

}

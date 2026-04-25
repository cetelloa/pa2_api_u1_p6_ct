package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesadorVentaService1 {

     @Inject
    private EstadisticasVentasGlobales estadisticasVentasGlobales;

    // Aqui como injecto el traking venta se crea un objecto 
    @Inject
    private TrakingVenta trakingVenta;

    // los beans de negocio tienen al final service

    public void procesar(Venta venta) {

        this.trakingVenta.iniciar();

        // Inicio Venta
        System.out.println("Procesando Venta");
        // consultando el stock de cada item
        // consulta en la base de datos
        // finalizacion venta

        //similar tiempo de demora

        try{

             Thread.sleep(100);

        }catch(Exception e){

        }
        

        this.trakingVenta.finalizar();

        //registrar Estadisticas 
        this.estadisticasVentasGlobales.resgistrarVenta(venta.getTotal());

    }

}

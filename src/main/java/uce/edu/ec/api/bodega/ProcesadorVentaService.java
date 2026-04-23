package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

//aqui se pone porque no guarda el estado 
//@ApplicationScoped
@Dependent
public class ProcesadorVentaService {

    @Inject
    private EstadisticasVentasGlobales estadisticasVentasGlobales;

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

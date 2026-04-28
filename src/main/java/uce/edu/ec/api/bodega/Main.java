package uce.edu.ec.api.bodega;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {

        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {
        @Inject
        private ProcesarVentaServiceTimepo procesadorVentaServiceTiempo;

        @Inject 
        private InventarioService inventarioService;


        @Override
        public int run(String... args) {

            Venta v1 = new Venta("Carlos Tello", 70);
            this.procesadorVentaServiceTiempo.procesar(v1);
            this.procesadorVentaServiceTiempo.reProcesar(v1);

            System.out.println("---------------------------------");
            System.out.println("---------------------------------");

            Inventario i1 = new Inventario("Coca Cola", 100);
            this.inventarioService.registrarInventario(i1);

        
    
            return 0;
        }

    }

}
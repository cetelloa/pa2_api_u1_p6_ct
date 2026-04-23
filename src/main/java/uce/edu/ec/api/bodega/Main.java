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
        private ProcesadorVentaService procesadorVentaService;
        @Inject
        private EstadisticasVentasGlobales estadisticasVentasGlobales;

        @Override
        public int run(String... args) {

            Venta v1 = new Venta("Carlos Tello", 70);
            this.procesadorVentaService.procesar(v1);


            Venta v2 = new Venta("Jennyfer Obando", 40);
            this.procesadorVentaService.procesar(v2);

            Venta v3 = new Venta("Milena Macas", 20);
            this.procesadorVentaService.procesar(v3);


            this.estadisticasVentasGlobales.mostrarEstadisticasGlobales();


            return 0;
        }

    }

}
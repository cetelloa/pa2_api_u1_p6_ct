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
        private ProcesadorVentaService1 procesadorVentaService1;


        @Inject
        private ProceadorVentaLineaService procesadorVentaLineaService;

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

            System.out.println("Este es otro bean de negocio trackinVenta");

            Venta v4 = new Venta("Adriana Rodriguez", 20);
            this.procesadorVentaService1.procesar(v4);

            Venta v5 = new Venta("Milena Villegas", 80);
            this.procesadorVentaService1.procesar(v5);

            System.out.println("Tercer Bean Procesador Venta linea Service");

            Venta v7 = new Venta("Veronica Alvarez", 80);
            this.procesadorVentaLineaService.procesar(v7);

            Venta v6 = new Venta("Milena Villegas", 80);
            this.procesadorVentaLineaService.procesar(v6);

            
            System.out.println("-----------------------------");

            this.estadisticasVentasGlobales.mostrarEstadisticasGlobales();

            return 0;
        }

    }

}
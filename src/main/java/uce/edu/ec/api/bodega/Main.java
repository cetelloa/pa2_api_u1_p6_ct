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


        //Modelos IoC
        //1. DI

        @Inject
        private PedidoService pedidoService;

        //2. Service Locator (Lookup)
        //private PedidoService pedidoService =CDI.current().select(PedidoService.class).get();


        @Inject
        private PagoTarjetaCredito pagoTc;
        @Inject
        private PagoEfectivo pagoE;

        @Override
        public int run(String... args) {

            //PedidoService pedidoService =CDI.current().select(PedidoService.class).get();

            // Caso1
            Pedido pedido1 = new Pedido("Carlos Tello", "Pilsener", 150, null);
            // PedidoService service = new PedidoService();
            pedidoService.registrar(pedido1, pagoTc);
            System.out.println("-------------------------------------------------------");


            // Caso2
            Pedido pedido2 = new Pedido("Carlos Tello", "PlayStation 5", 20, "cetelloa@uce.edu.ec");
            pedidoService.registrar(pedido2,pagoE);
            System.out.println("-------------------------------------------------------");

            // // Caso3
            // Pedido pedido3 = new Pedido("Carlos Tello", "PlayStation 5", 51, "cetelloa@uce.edu.ec");
            // pedidoService.registrar(pedido3,pagoTc);

            return 0;

        }

    }

}

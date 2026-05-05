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
        private ProcesadorCompraService procesadorCompraService;
       
        @Override
        public int run(String... args) {

            Compra compra = new Compra("Carlos Tello ", 100.00);
            procesadorCompraService.procesar(compra);

            return 0;
        }

    }

}
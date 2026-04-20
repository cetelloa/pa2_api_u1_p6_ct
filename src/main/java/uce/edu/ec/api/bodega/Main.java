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
        private AmbitoAplicacion ambitoAplicacion;

        @Override
        public int run(String... args) {

            this.ambitoAplicacion.incrementar();
            this.ambitoAplicacion.incrementar();
            this.ambitoAplicacion.incrementar();
            int valor = this.ambitoAplicacion.incrementar();
            System.out.println(valor);

            return 0;
        }

    }

}

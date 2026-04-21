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
        private ClaseIntermedia claseIntermedia;

        @Inject
        private AmbitoAplicacion ambitoAplicacion;

        @Inject
        private AmbitoRequest ambitoRequest;

        @Inject
        private AmbitoInject ambitoInject;

        @Inject
        private AmbitoSingleton ambitoSingleton;

        @Override
        public int run(String... args) {

            System.out.println(this.ambitoAplicacion);

            System.out.println(this.ambitoAplicacion.incrementar());
            System.out.println(this.ambitoAplicacion.incrementar());
            System.out.println(this.ambitoAplicacion.incrementar());

            // int valor = this.ambitoAplicacion.incrementar();

            this.claseIntermedia.imprimirObjectoValor();

            // System.out.println("**************************AMBITO
            // REQUEST******************");
            // System.out.println(this.ambitoRequest.incrementar());
            // System.out.println(this.ambitoRequest.incrementar());
            // System.out.println(this.ambitoRequest.incrementar());

            // RequestScoped solo funciona en una aplicacion web

            System.out.println("**************************AMBITO DEPENDENT******************");
            System.out.println(this.ambitoInject.incrementar());
            System.out.println(this.ambitoInject.incrementar());
            System.out.println(this.ambitoInject.incrementar());

            // Dependent solo vive en el tiempo en el que dura la injeccion
            this.claseIntermedia.imprimirObjectoValorInject();

        
            System.out.println("**************************AMBITO SINGLETON******************");
             this.claseIntermedia.imprimirObjectoValorSingleton();
            System.out.println(this.ambitoSingleton.incrementar());
            System.out.println(this.ambitoSingleton.incrementar());
            System.out.println(this.ambitoSingleton.incrementar());

            this.claseIntermedia.imprimirObjectoValorSingleton();
            return 0;
        }

    }

}

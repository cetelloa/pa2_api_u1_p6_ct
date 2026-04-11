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

    public static class App implements QuarkusApplication{
       
        @Inject 
        private PedidoService pedidoService;  
            
        @Override
        public int run(String... args){

        Pedido pedido1 = new Pedido("Carlos Tello", "Pilsener", 2.50 , "cetelloa@uce.edu.ec");
       // PedidoService service = new PedidoService();
        pedidoService.registrar(pedido1);
        return 0;

        }

    }

}

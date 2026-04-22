package uce.edu.ec.api.bodega;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.api.ejemplo_scopes.*;

@QuarkusMain
public class Main {

    public static void main(String[] args) {

        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        private SucursalDeVentas sucursalVentas;

        // ApplicactionScope
        @Inject
        private InventarioCentral inventarioCentral;

        // Dependent
        @Inject
        private TicketDeVenta ticketDeVenta;

        // Singleton
        @Inject
        private GeneradorIdsUtilitario generadorIdsUtilitario;

        @Override
        public int run(String... args) {

            System.out.println("1. ESTADO AL INICIO");
            System.out.println(" Local Principal Stock Global: " + inventarioCentral.obtenerStockActual());
            System.out.println(" LOcal Principal Ticket: " + ticketDeVenta.obtenerResumen());

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------");

            System.out.println("2. LA SUCURSAL REALIZA UNA VENTA");

            sucursalVentas.realizarOperacionVenta();

            // OTRA VENTA

            System.out.println("3. EL FLUJO PRINCIPAL REALIZA OTRA VENTA EXCLUSIVA");

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Objeto Generador Utilitario (SINGLETON) - Main");
            System.out.println(this.generadorIdsUtilitario);

            String codigo2 = generadorIdsUtilitario.generarNuevoCodigoTransaccion();
            System.out.println(" [Principal] Usando utilidad para ID: " + codigo2);

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Objeto Ticket de Venta (DEPENDENT) - Main");
            System.out.println(this.ticketDeVenta);
            ticketDeVenta.agregarAlTicket(100.00);
            ticketDeVenta.cerrarTicket();

            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Objeto Inventario Central (APPLICATION SCOPED) - Main");
            System.out.println(this.inventarioCentral);
            inventarioCentral.registrarVenta(3);

            System.out.println("Comprobacion");

            // Gracias al @ApplicationScoped el inventario cambia su estado globalmente
            System.out.println("Stock global despues de las ventas: " + inventarioCentral.obtenerStockActual());
            
            //El ticket es propio de solo principal por @Dependent
            System.out.println("Pincipal Ticket: "+ticketDeVenta.obtenerResumen());

            return 0;
        }


        
    }

}

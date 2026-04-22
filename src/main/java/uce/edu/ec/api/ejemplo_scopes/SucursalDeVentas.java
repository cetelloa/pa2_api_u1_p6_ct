package uce.edu.ec.api.ejemplo_scopes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SucursalDeVentas {

    @Inject
    InventarioCentral inventario;

    @Inject
    GeneradorIdsUtilitario utilitarioIds;

    @Inject
    TicketDeVenta ticketSucursal;

    public void realizarOperacionVenta() {

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Objeto GeneradorID (SINGLETON)");
        System.out.println(this.utilitarioIds);
        String codigoGenerado = utilitarioIds.generarNuevoCodigoTransaccion();
        System.out.println("   [Sucursal] Iniciando venta (ID Utilidad: " + codigoGenerado + ")");

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Objeto Ticket de Venta (DEPENDENT)");
        System.out.println(this.ticketSucursal);

        ticketSucursal.agregarAlTicket(25.50);
        ticketSucursal.cerrarTicket();

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Objeto Inventario Central (APPLICATION SCOPED)");
        System.out.println(this.inventario);
        inventario.registrarVenta(1);

        System.out.println("   [Sucursal] Resumen del Ticket: " + ticketSucursal.obtenerResumen());
    }
}
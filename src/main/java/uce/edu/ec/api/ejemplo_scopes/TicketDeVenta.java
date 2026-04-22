package uce.edu.ec.api.ejemplo_scopes;

import jakarta.enterprise.context.Dependent;


@Dependent
public class TicketDeVenta {

    private String estado = "PROCESANDO";
    private double montoTotal = 0.0;

    public void agregarAlTicket(double precio) {
        this.montoTotal += precio;
    }

    public void cerrarTicket() {
        this.estado = "FACTURADO";
    }

    public String obtenerResumen() {
        return "Estado: " + estado + " | Total: $" + montoTotal;
    }
}
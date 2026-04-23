package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadisticasVentasGlobales {

    private int totalVentas = 0;

    private double montoTotalVendido = 0;

    public void resgistrarVenta(double totalVentaIndividual) {

        totalVentas++;
        montoTotalVendido += totalVentaIndividual;

    }

    public void mostrarEstadisticasGlobales() {

        // uasr this para el uso de atributos "buena practica"

        System.out.println("Estadisticas Globales");
        System.out.println("Cantidad de Ventas: " + this.totalVentas);
        System.out.println("Valor total vendido: " + this.montoTotalVendido);

    }
}

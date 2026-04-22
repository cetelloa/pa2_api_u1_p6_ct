package uce.edu.ec.api.ejemplo_scopes;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventarioCentral {

    private int stockGlobal = 1000;

    public void registrarVenta(int cantidad) {
        this.stockGlobal -= cantidad;
    }

    public int obtenerStockActual() {
        return stockGlobal;
    }
}
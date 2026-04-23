package uce.edu.ec.api.bodega;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter
// @Setter
// @NoArgsConstructor
public class Venta {

    private String cliente;

    private double total;

    public Venta(String cliente, double total) {
    this.cliente = cliente;
    this.total = total;
    }

    public String getCliente() {
    return cliente;
    }

    public void setCliente(String cliente) {
    this.cliente = cliente;
    }

    public double getTotal() {
    return total;
    }

    public void setTotal(double total) {
    this.total = total;
    }

}

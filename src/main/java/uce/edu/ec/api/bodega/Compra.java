package uce.edu.ec.api.bodega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Compra {


    private String cliente;
    private double subTotal;
    private double total;

    public Compra(String cliente, double subTotal) {
        this.cliente = cliente;
        this.subTotal = subTotal;
    }



    

}

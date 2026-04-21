package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class AmbitoRequest {
     private int contador;

    public int incrementar(){

        return contador++;
        //return ++contador;
    }

}

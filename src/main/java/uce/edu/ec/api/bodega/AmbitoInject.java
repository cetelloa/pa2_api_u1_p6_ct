package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.Dependent;

@Dependent
public class AmbitoInject {
    private int contador;

    public int incrementar(){

        return contador++;
        //return ++contador;
    }


}

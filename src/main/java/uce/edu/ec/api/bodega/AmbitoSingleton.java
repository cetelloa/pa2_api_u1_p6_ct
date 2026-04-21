package uce.edu.ec.api.bodega;

import jakarta.inject.Singleton;

@Singleton
public class AmbitoSingleton {

    private int contador;

    public int incrementar(){

        return contador++;
        //return ++contador;
    }

}

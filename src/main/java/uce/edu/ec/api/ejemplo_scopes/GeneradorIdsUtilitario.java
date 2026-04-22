package uce.edu.ec.api.ejemplo_scopes;

import jakarta.inject.Singleton;

@Singleton
public class GeneradorIdsUtilitario {

    public String generarNuevoCodigoTransaccion() {
        int numeroAleatorio = (int) (Math.random() * 10000);
        return "TX-" + numeroAleatorio;
    }
    
}
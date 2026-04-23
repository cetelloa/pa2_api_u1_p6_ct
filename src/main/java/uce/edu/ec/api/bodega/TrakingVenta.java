package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.context.Dependent;

@ApplicationScoped
public class TrakingVenta {

    private long tiempoInicio = 0;

    private long tiempoFinal = 0;

    public void iniciar() {

        // currentTimeMilis te da el tiempo en segundos
        this.tiempoInicio = this.tiempoInicio + System.currentTimeMillis();

    }

    public void finalizar() {

        this.tiempoFinal = this.tiempoFinal + System.currentTimeMillis();

        long tiempoEjecucion = tiempoFinal - tiempoInicio;

        System.out.println("Tiempo ejecucion: " + tiempoEjecucion);

    }

}

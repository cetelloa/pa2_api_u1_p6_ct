package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;


// Si enjectas esto con @Depent se acumula solo de una intancia

//Aqui todod se acumula porque es un bean de aplicacion, si se inyecta con @Dependent se crea una nueva instancia cada vez y no se acumula el tiempo total ni el numero de operaciones
@ApplicationScoped
public class TrakingVenta {

    private long tiempoInicio = 0;

    private long tiempoFinal = 0;

    // Nuevas variables
    private long tiempoTotalAcumulado = 0;

    private int numeroOperaciones = 0;

    public void iniciar() {

        // currentTimeMilis te da el tiempo en segundos
        this.tiempoInicio = System.currentTimeMillis();

    }

    public void reinicar() {

        this.tiempoTotalAcumulado = 0;
        this.numeroOperaciones = 0;

    }

    public void finalizar() {

        this.tiempoFinal = System.currentTimeMillis();

        long tiempoEjecucion = tiempoFinal - tiempoInicio;

        //System.out.println("Tiempo ejecucion: " + tiempoEjecucion);

        // suma el timepo de ejecucion al acumulador
        this.tiempoTotalAcumulado += tiempoEjecucion;
        // incrementa el numero de operaciones
        this.numeroOperaciones++;

        System.out.println("Tiempo ejecucion: " + tiempoEjecucion);
        System.out.println("Tiempo acumualado: " + this.tiempoTotalAcumulado);
        System.out.println("Cantidad de Operaciones: " + this.numeroOperaciones);


    }

}

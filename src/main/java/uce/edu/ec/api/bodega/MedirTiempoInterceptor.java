package uce.edu.ec.api.bodega;

import jakarta.interceptor.AroundInvoke;

//DECLARACION DEL INTERCEPTOR

import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;


//Referencia a la anotacion que se creo para el interceptor
@MedirTiempo

//Esta es una clase que implementa al interceptor
@Interceptor


public class MedirTiempoInterceptor {


    // La anotacion @AroundInvoke dice que se va a ejecutar al rededor de la ejecucion del metodo, 
    // es decir antes y despues de la ejecucion del metodo
    @AroundInvoke


    public Object medir(InvocationContext context) throws Exception{

        System.out.println("Se ejecuto antes del metodo");

        long inicio = System.currentTimeMillis();

        //INICIA LA EJECUCION DEL METODO
        //SI NO SE LLAMA AL PROCEED EL METODO NO SE EJECUTA, 
        //SE QUEDA EN EL INTERCEPTOR
        Object resultado = context.proceed(); 
        //UNA VEZ QUE SE EJECUTA EL METODO DE NEGOCIO, 
        //SE CONTINUA A LA SIGUIENTE LINEA

        long fin = System.currentTimeMillis();

        long tiempoTranscurrido = fin - inicio;

        System.out.println("Tiempo transcurrido: " + tiempoTranscurrido);


        return resultado; 


    }



}

package uce.edu.ec.api.bodega;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

//DECLARACION DE LA ANOTACION PARA EL INTERCEPTOR

//con esta anotacion le indicamos que va a ser un interceptor 
@InterceptorBinding

// Se puede crear a nivel de metodo, constructor, campo y a nivel de clase.
// El objetivo
@Target({ElementType.METHOD, ElementType.TYPE}) // USAR ESTE CONFIGURACION PARA LA CREACION

// Ambito que va tener el interceptor, en este caso a nivel de metodo
// RUNTIME cuando se ejecute --> usamos este
// SOURCE cuando se compile
@Retention(RetentionPolicy.RUNTIME)

public @interface MedirTiempo {

    

}

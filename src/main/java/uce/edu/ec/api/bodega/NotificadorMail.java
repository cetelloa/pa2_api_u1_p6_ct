package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped //Esta anotacion dice que esta clase la va a gestionar un externo
@Default // Esta anotacion dice que esta clase es la implementacion por defecto de la interfaz Notificador
public class NotificadorMail implements Notificador {

    // public NotificadorMail() throws Exception {
    //     throw new Exception();
    // }

     public void enviar(String destino, String mensaje){

        System.out.println("Se envia el mail al correo : "+destino);
        System.out.println("Con el mensaje: "+ mensaje);
        
    }

}

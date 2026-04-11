package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped //Esta anotacion dice que esta clase la va a gestionar un externo
public class NotificadorMail {

     public void enviar(String correo, String mensaje){

        System.out.println("Se envia el mailal correo : "+correo);
        System.out.println("Con el mensaje: "+ mensaje);
        
    }

}

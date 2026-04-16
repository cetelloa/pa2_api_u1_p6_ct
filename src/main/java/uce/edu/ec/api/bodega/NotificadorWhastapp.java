package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificadorWhastapp implements Notificador {

     public void enviar(String destino, String mensaje){

        System.out.println("Se envia el mensaje al whatsapp con el numero: "+destino);
        System.out.println("Con el mensaje: "+ mensaje);
        
    }


}

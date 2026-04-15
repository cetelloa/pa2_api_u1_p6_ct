package uce.edu.ec.api.bodega;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificadorSMS implements Notificador {

    public void enviar(String destino, String mensaje){

        System.out.println("Se envia el SMS al numero : "+destino);
        System.out.println("Con el mensaje: "+ mensaje);
        
    }

}

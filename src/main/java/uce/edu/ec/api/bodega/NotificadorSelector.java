package uce.edu.ec.api.bodega;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NotificadorSelector {
    
    //se inyecta el mail y el sms para poder usarlos en el metodo seleccionar
    @Inject
    private NotificadorMail notificadorMail;
    @Inject
    private NotificadorSMS notificadorSMS;
    @Inject
    private NotificadorWhastapp notificadorWhastapp;

    public  Notificador seleccionar(double total) {
        if (total > 120) {
            //MAIL
            return notificadorMail;
        } else if(total >50) {
            //WHATSAPP
            return notificadorWhastapp;
        }else{
            //SMS
            return notificadorSMS;
        }
    }
}
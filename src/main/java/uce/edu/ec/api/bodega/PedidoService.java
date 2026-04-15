package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped // Siempre fuera de la clase
public class PedidoService {

    // DI por atributo
    // @Inject // Solo arriba de las variables
    //private NotificadorMail notificadorMail;
//---------------------------------------------------------------------
    //DI por constructor
    // private NotificadorMail notificadorMail;
    // @Inject
    // public PedidoService(NotificadorMail notificadorMail) {
    //     this.notificadorMail = notificadorMail;
    // }
//---------------------------------------------------------------------
    //DI por metodo
    // private NotificadorMail notificadorMail;
    // @Inject
    // public void setNotificador(NotificadorMail notificadorMail) {
    //     this.notificadorMail = notificadorMail;
    // }
//---------------------------------------------------------------------
    //private NotificadorMail notificadorMail = new NotificadorMail(); // Sin inyeccion


    @Inject
    private NotificadorSelector notificadorSelector;


    public void registrar(Pedido pedido) {

        System.out.println("Registrando pedido");
        System.out.println("cliente " + pedido.getCliente());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Guardando en la base de datos");

        // NotificadorMail nl = new NotificadorMail(); sin inyeccion

        // Con DI por el contenedor
        //notificadorMail.enviar(pedido.getCorreo(), "Se ha creado un pedido");

        Notificador notificador = this.notificadorSelector.seleccionar(pedido.getTotal());
        notificador.enviar(pedido.getDestino(), "Pedido registrado con exito");

    }

}

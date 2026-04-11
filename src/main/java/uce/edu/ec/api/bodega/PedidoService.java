package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
 
@ApplicationScoped //Siempre fuera de la clase 
public class PedidoService {

    
@Inject // Solo arriba de las variables 
    private NotificadorMail notificadorMail;


     public void  registrar(Pedido pedido){

        System.out.println("Registrando pedido");
        System.out.println("cliente "+ pedido.getCliente());
        System.out.println("Total: "+pedido.getTotal());
        System.out.println("Guardando en la base de datos");

        //NotificadorMail nl = new NotificadorMail(); sin inyeccion

        //Con DI por el contenedor
        notificadorMail.enviar(pedido.getCorreo(),  "Se ha creado un pedido");

    }



}

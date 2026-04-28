package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventarioService {

    @MedirTiempo
    public void registrarInventario(Inventario inventario) {

        System.out.println("Registrando Inventario");

        try {

            Thread.sleep(500);

        } catch (Exception e) {

        }

        System.out.println("Final del registro de inventario ");

    }

}

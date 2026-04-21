package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClaseIntermedia {

    @Inject

    private AmbitoAplicacion ambitoAplicacion;

    @Inject
    private AmbitoInject ambitoInject;

    @Inject
    private AmbitoSingleton ambitoSingleton;


    public void imprimirObjectoValor() {
        System.out.println(this.ambitoAplicacion);
        System.out.println(this.ambitoAplicacion.incrementar());
    }

    public void imprimirObjectoValorInject() {
        System.out.println(this.ambitoInject);
        System.out.println(this.ambitoInject.incrementar());
    }

     public void imprimirObjectoValorSingleton() {
        System.out.println(this.ambitoSingleton);
        System.out.println(this.ambitoSingleton.incrementar());
    }
}

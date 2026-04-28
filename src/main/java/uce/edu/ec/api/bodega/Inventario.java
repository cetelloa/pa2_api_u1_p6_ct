package uce.edu.ec.api.bodega;

public class Inventario {


    private String nombreProducto;
    private int cantidad;




    
    public Inventario(String nombreProducto, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   

}

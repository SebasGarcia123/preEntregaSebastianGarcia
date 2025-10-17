
package pre.entrega.sebastian.garcia;


public class Producto {
    
    private int id;
    private String nombreProducto;
    private float precio;
    private int cantStock;

    public Producto() {
    }

    public Producto(int id, String nombreProducto, float precio, int cantStock) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantStock = cantStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantStock() {
        return cantStock;
    }

    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }

    @Override
    public String toString() {
        return id + "\t" +  nombreProducto + "\t" + precio + "\t" + cantStock + "\t";
    }
    
    
}


package pre.entrega.sebastian.garcia;


public class ItemPedido {
    
    private Producto producto;
    private int cantidadProducto;

    public ItemPedido() {
    }

    public ItemPedido(Producto producto, int cantidadProducto) {
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

}

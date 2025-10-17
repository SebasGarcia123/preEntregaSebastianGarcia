
package pre.entrega.sebastian.garcia;

import java.util.ArrayList;

public class Pedido {
    
    public static int contadorId = 1;
    public int idPedido;
    private ArrayList<ItemPedido> itemsPedido;

    public Pedido(ArrayList<ItemPedido> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public ArrayList<ItemPedido> getItemsPedido() {
        return itemsPedido;
    }

    public void setItemsPedido(ArrayList<ItemPedido> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public StringBuilder imprimirPedido(Pedido pedido) {
        StringBuilder resumen = new StringBuilder();
        float total = 0;
        resumen.append("\nPedido nro " + pedido.getIdPedido() + "\n");
        for(ItemPedido item : pedido.getItemsPedido()){
            resumen.append(item.getIdItem() + " " +item.getProducto().getNombreProducto() + " \t" + item.getCantidadProducto() + " unidades.\n");
            total += item.getProducto().getPrecio() * item.getCantidadProducto();
        }
        resumen.append("Total: $" + total + "\n");

        return resumen;
    }
    
}

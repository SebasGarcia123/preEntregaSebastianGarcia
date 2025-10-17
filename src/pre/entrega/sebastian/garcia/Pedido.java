
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

    public StringBuilder imprimirPedido(ArrayList<ItemPedido> itemsPedido) {
        StringBuilder pedido = new StringBuilder();
        pedido.append("Pedido nro " + idPedido + "\n");
        for(ItemPedido item : itemsPedido){
            pedido.append(item.getIdItem() + " " +item.getProducto().getNombreProducto() + " " + item.getCantidadProducto() + "unidades");
        }
        return pedido;
    }
    
}

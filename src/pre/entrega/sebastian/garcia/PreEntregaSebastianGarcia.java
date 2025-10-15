
package pre.entrega.sebastian.garcia;

import java.util.ArrayList;
import java.util.Scanner;


public class PreEntregaSebastianGarcia {

    static int id = 0;
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    
    public static void main(String[] args) {
        
        mostrarMenu();
            
    }
    
    public static void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        int opcion = 1;
        while(opcion != 0){
            System.out.println("Bienvenido! Elija la opción que desea realizar"); 
            System.out.println("1) Crear un producto."); 
            System.out.println("2) Listar los productos disponibles."); 
            System.out.println("3) Modificar un producto."); 
            System.out.println("4) Borrar un producto"); 
            
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    crearProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    borrarProducto();
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");
                    break;
            }
        }
    }
    
    public static void crearProducto(){
        Scanner sc = new Scanner(System.in);
        int idProducto = id + 1;
        System.out.println("Ingrese el nombre del producto:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precio = sc.nextDouble();
        System.out.println("Ingrese la cantidad de producto:");
        int cantidad = sc.nextInt();
        Producto producto = new Producto(idProducto,nombre,precio,cantidad);
        listaProductos.add(producto);
        id = idProducto;
    }
    
    public static void listarProductos(){
        System.out.println("Id\t\tNombre\t\tPrecio\t\tCantidad");
        for(Producto producto : listaProductos){
            producto.toString();
        }
    }
    
    public static Producto obtenerProducto(int id){
        Producto producto = null;
        if(listaProductos.get(id))
        producto = listaProductos.get(id - 1);
        return producto;
    }
    
    public static Producto obtenerProducto(String nombre){
        Producto producto = null;
        listaProductos.
        return producto;
    }
    
    public static void modificarProducto(){
        System.out.println("Ingrese la opción que desea realizar: ");
        System.out.println("1) Modificar nombre. ");
        System.out.println("2) Modificar precio.");
        System.out.println("2) Modificar cantidad.");
    }
}

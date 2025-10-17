package pre.entrega.sebastian.garcia;

import java.util.ArrayList;
import java.util.Scanner;

public class PreEntregaSebastianGarcia {

    static int id = 5;
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Producto producto1 = new Producto(1,"Fideos Marolio",100,1000);
        Producto producto2 = new Producto(2,"Arroz Marolio",200,1000);
        Producto producto3 = new Producto(3,"Yerba Marolio",300,1000);
        Producto producto4 = new Producto(4,"Cafe Marolio",400,1000);
        Producto producto5 = new Producto(5,"Palmitos Marolio",500,1000);
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);
        listaProductos.add(producto4);
        listaProductos.add(producto5);
        
        mostrarMenu();

    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("\nBienvenido! Elija la opción que desea realizar");
            System.out.println("1) Crear un producto.");
            System.out.println("2) Listar los productos disponibles.");
            System.out.println("3) Modificar un producto.");
            System.out.println("4) Borrar un producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    modificarProducto(listaProductos);
                    break;
                case 4:
                    borrarProducto(listaProductos);
                    break;
                case 5:
                    cargarPedido(listaProductos,listaPedidos);
                    break;
                case 6:
                    listarPedidos(listaPedidos);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");
                    break;
            }
        }
    }

    public static void crearProducto() {
        Scanner sc = new Scanner(System.in);
        int idProducto = id + 1;
        System.out.println("Ingrese el nombre del producto:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio del producto:");
        float precio = sc.nextFloat();
        System.out.println("Ingrese la cantidad de producto:");
        int cantidad = sc.nextInt();
        Producto producto = new Producto(idProducto, nombre, precio, cantidad);
        listaProductos.add(producto);
        id = idProducto;
    }

    public static void listarProductos() {
        System.out.println("Id\tNombre\t\tPrecio\tCantidad");
        System.out.println("----------------------------------------");
        for (Producto producto : listaProductos) {
            System.out.println(producto.getId() + "\t" + producto.getNombreProducto() + "\t\t" + producto.getPrecio() + "\t" + producto.getCantStock() + "\t");;
        }
    }

    public static Producto obtenerProducto(int id) {
            
        if (listaProductos.get(id - 1) == null) {
            System.out.println("No se encontró un producto con ese id");
        }
        return listaProductos.get(id - 1);

    }

    public static Producto obtenerProducto(String nombre) {
        Producto productoEncontrado = null;
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().equals(nombre)) {
                productoEncontrado = producto;
            }
        }
        if (productoEncontrado == null) {
            System.out.println("No se encontró un producto con ese nombre");
        }
        return productoEncontrado;
    }

    public static void modificarProducto(ArrayList<Producto> listaProductos) {
        int opcion = 0;
        int opcion1 = 0;
        int opcion2 = 0;
        Producto producto = null;
        listarProductos();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese la opción que desea hacer: ");
        System.out.println("1 - Ingresar id de producto.");
        System.out.println("2 - Ingresar nombre de producto.");
        System.out.println("3 - Salir.");
        opcion = sc.nextInt();
        if (opcion != 3) {
            do {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el id");
                        int idElegido = sc.nextInt();
                        producto = obtenerProducto(idElegido);
                        System.out.println("El producto elegido es: ");
                        System.out.println(producto.toString());
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre");
                        Scanner sc1 = new Scanner(System.in);
                        String nombreElegido = sc1.nextLine();
                        System.out.println("El producto elegido es: ");
                        producto = obtenerProducto(nombreElegido);
                        System.out.println(producto.toString());
                        break;
                    default:
                        System.out.println("Opcion inválida");
                        break;
                }
            } while (opcion < 1 && opcion > 3);

            do {
                System.out.println("Ingrese la opción que desea realizar: ");
                System.out.println("1) Modificar nombre. ");
                System.out.println("2) Modificar precio.");
                System.out.println("3) Modificar cantidad.");
                System.out.println("4) Salir.");
                opcion1 = sc.nextInt();
                switch (opcion1) {
                    case 1:
                        System.out.println("Ingrese el nombre nuevo: ");
                        Scanner sc2 = new Scanner(System.in);
                        String nombreNuevo = sc2.nextLine();
                        producto.setNombreProducto(nombreNuevo);
                        System.out.println("El nombre se modificó con exito");
                        break;
                    case 2:
                        System.out.println("Ingrese el precio nuevo: ");
                        float precioNuevo = sc.nextFloat();
                        if(precioNuevo >= 0){
                        producto.setPrecio(precioNuevo);
                        System.out.println("El precio se modificó con exito");
                        }else{
                            System.out.println("El precio debe ser mayor que cero!");
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva cantidad: ");
                        int cantNueva = sc.nextInt();
                        if(cantNueva >= 0){
                        producto.setCantStock(cantNueva);
                        System.out.println("La cantidad se modificó con exito");
                        }else{
                            System.out.println("La cantidad no puede ser negativa!");
                        }
                        break;
                }
            } while (opcion1 != 4);
        }
    }
    
    public static void borrarProducto(ArrayList<Producto> listaProductos){
        int encontrado = -1;
        listarProductos();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el id del producto que desea eliminar o digite 0 para salir : ");
        int buscado = sc.nextInt();
        for(Producto producto : listaProductos){
            if(producto.getId() == buscado){
                encontrado = buscado;
            }
        }
        if(encontrado > 0){
            listaProductos.remove(encontrado - 1);
        }else{
            System.out.println("No se encontró el producto para eliminar");
        }
    }
    
        public static void listarPedidos( ArrayList<Pedido> listaPedidos){
            for(Pedido pedido : listaPedidos){
                pedido.imprimirPedido(pedido.getItemsPedido());
            }
        }
    
        public static void cargarPedido(ArrayList<Producto> listaProductos, ArrayList<Pedido> listaPedidos){
        int opcion = 1;
        ArrayList<ItemPedido> pedidoNuevo = new ArrayList<ItemPedido>();
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido();
        int contador = 1;
        while(opcion != 0){
        System.out.println("Ingrese el id del producto o digite 0 para salir");
        listarProductos();
        opcion = sc.nextInt();
        if(opcion!=0){
        Producto productoElegido = obtenerProducto(opcion);
        if(productoElegido == null){
            System.out.println("No hay un producto con ese id");
        }else{
            item.setId(contador);
            item.setProducto(productoElegido);
            System.out.println("Ingrese la cantidad deseada");
            int cant = sc.nextInt();
            item.setCantidadProducto(cant);
            pedidoNuevo.add(item);
            //Descuenta cantidad del stock
            int nuevoStock = listaProductos.get(opcion - 1).getCantStock() - cant;
            listaProductos.get(opcion - 1).setCantStock(nuevoStock);
            
        }
        contador += 1;
        }
        }
        pedido.setItemsPedido(pedidoNuevo); 
        pedido.setIdPedido(Pedido.contadorId);
                
        Pedido.contadorId += 1;
        listaPedidos.add(pedido);
        }
        

    
    
}

package pre.entrega.sebastian.garcia;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class PreEntregaSebastianGarcia {

    static int id = 0;
    static ArrayList<Producto> listaProductos = new ArrayList<>();

    public static void main(String[] args) {

        mostrarMenu();

    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        int opcion = 1;
        while (opcion != 0) {
            System.out.println("\nBienvenido! Elija la opción que desea realizar");
            System.out.println("1) Crear un producto.");
            System.out.println("2) Listar los productos disponibles.");
            System.out.println("3) Modificar un producto.");
            System.out.println("4) Borrar un producto");

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
        System.out.println("Id\tNombre\t\t\tPrecio\tCantidad");
        System.out.println("------------------------------------------------");
        for (Producto producto : listaProductos) {
            System.out.println(producto.getId() + "\t" + producto.getNombreProducto() + "\t\t" + producto.getPrecio() + "\t" + producto.getCantStock() + "\t");;
        }
    }

    public static Producto obtenerProducto(int id) {
        Producto productoEncontrado = null;
        if (listaProductos.get(id - 1) == null) {
            System.out.println("No se encontró un producto con ese id");
        }
        return productoEncontrado = listaProductos.get(id - 1);

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
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre");
                        String nombreElegido = sc.nextLine();
                        producto = obtenerProducto(nombreElegido);
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
                        Scanner sc1 = new Scanner(System.in);
                        String nombreNuevo = sc1.nextLine();
                        producto.setNombreProducto(nombreNuevo);
                        System.out.println("El nombre se modificó con exito");
                        break;
                    case 2:
                        System.out.println("Ingrese el precio nuevo: ");
                        float precioNuevo = sc.nextFloat();
                        producto.setPrecio(precioNuevo);
                        System.out.println("El precio se modificó con exito");
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva cantidad: ");
                        int cantNueva = sc.nextInt();
                        producto.setCantStock(cantNueva);
                        System.out.println("La cantidad se modificó con exito");
                        break;
                }
            } while (opcion1 != 4);
        }
    }
    
    public static void borrarProducto(ArrayList<Producto> listaProductos){
        Producto producto = null;
        listarProductos();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIngrese el id del producto que desea eliminar o digite 0 para salir : ");
        int opcion = sc.nextInt();
        while(opcion != 0){
            listaProductos.remove(opcion-1);
        }
    }
}

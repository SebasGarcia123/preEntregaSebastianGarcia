package pre.entrega.sebastian.garcia;

import java.util.ArrayList;
import java.util.Scanner;

public class PreEntregaSebastianGarcia {

    static int id = 5;
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Producto producto1 = new Producto(1, "Fideos Marolio", 100, 1000);
        Producto producto2 = new Producto(2, "Arroz Marolio", 200, 1000);
        Producto producto3 = new Producto(3, "Yerba Marolio", 300, 1000);
        Producto producto4 = new Producto(4, "Cafe Marolio", 400, 1000);
        Producto producto5 = new Producto(5, "Palmitos Marolio", 500, 1000);
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
        System.out.println("Bienvenido!");
        while (opcion != 0) {
            System.out.println("\nElija la opción que desea realizar");
            System.out.println("1) Crear un producto.");
            System.out.println("2) Listar los productos disponibles.");
            System.out.println("3) Modificar un producto.");
            System.out.println("4) Borrar un producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir\n");

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
                    cargarPedido(listaProductos, listaPedidos);
                    break;
                case 6:
                    listarPedidos(listaPedidos);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nLa opción ingresada es incorrecta\n");
                    break;
            }
        }
    }

    public static void crearProducto() {
        Scanner sc = new Scanner(System.in);
        int idProducto = id + 1;
        System.out.println("\nIngrese el nombre del producto:\n");
        String nombre = sc.nextLine();
        System.out.println("\nIngrese el precio del producto:\n");
        float precio = sc.nextFloat();
        System.out.println("\nIngrese la cantidad de producto:\n");
        int cantidad = sc.nextInt();
        Producto producto = new Producto(idProducto, nombre, precio, cantidad);
        listaProductos.add(producto);
        id = idProducto;
    }

    public static void listarProductos() {
        System.out.println("\nId\tNombre\t\tPrecio\tCantidad");
        System.out.println("----------------------------------------");
        for (Producto producto : listaProductos) {
            System.out.println(producto.getId() + "\t" + producto.getNombreProducto() + "\t\t" + producto.getPrecio() + "\t" + producto.getCantStock() + "\t");;
        }
        System.out.println("\n");
    }

    public static Producto obtenerProducto(int id, ArrayList<Producto> listaProductos) {
        Producto encontrado = null;
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                encontrado = listaProductos.get(id - 1);
            }
        }
        return encontrado;

    }

    public static Producto obtenerProducto(String nombre, ArrayList<Producto> listaProductos) {
        Producto productoEncontrado = null;
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                productoEncontrado = producto;
            }
        }
        if (productoEncontrado == null) {
            System.out.println("\nNo se encontró un producto con ese nombre\n");
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
        System.out.println("3 - Salir.\n");
        opcion = sc.nextInt();
        if (opcion != 3) {
            do {
                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese el id\n");
                        int idElegido = sc.nextInt();
                        producto = obtenerProducto(idElegido, listaProductos);
                        break;
                    case 2:
                        System.out.println("\nIngrese el nombre\n");
                        Scanner sc1 = new Scanner(System.in);
                        String nombreElegido = sc1.nextLine();
                        producto = obtenerProducto(nombreElegido, listaProductos);
                        break;
                    default:
                        System.out.println("\nOpcion inválida\n");
                        break;
                }
            } while (opcion < 1 && opcion > 3);
            if (producto != null) {
                System.out.println("\nEl producto elegido es: ");
                System.out.println(producto.toString());
                System.out.println("\n");
                do {
                    if (producto != null) {
                        System.out.println("\nIngrese la opción que desea realizar: ");
                        System.out.println("1) Modificar nombre. ");
                        System.out.println("2) Modificar precio.");
                        System.out.println("3) Modificar cantidad.");
                        System.out.println("4) Salir.\n");
                        opcion1 = sc.nextInt();
                        switch (opcion1) {
                            case 1:
                                System.out.println("\nIngrese el nombre nuevo: \n");
                                Scanner sc2 = new Scanner(System.in);
                                String nombreNuevo = sc2.nextLine();
                                producto.setNombreProducto(nombreNuevo);
                                System.out.println("\nEl nombre se modificó con exito\n");
                                break;
                            case 2:
                                System.out.println("\nIngrese el precio nuevo: \n");
                                float precioNuevo = sc.nextFloat();
                                if (precioNuevo >= 0) {
                                    producto.setPrecio(precioNuevo);
                                    System.out.println("\nEl precio se modificó con exito\n");
                                } else {
                                    System.out.println("\nEl precio debe ser mayor que cero!\n");
                                }
                                break;
                            case 3:
                                System.out.println("\nIngrese la nueva cantidad: \n");
                                int cantNueva = sc.nextInt();
                                if (cantNueva >= 0) {
                                    producto.setCantStock(cantNueva);
                                    System.out.println("\nLa cantidad se modificó con exito\n");
                                } else {
                                    System.out.println("\nLa cantidad no puede ser negativa!\n");
                                }
                                break;
                        }
                    } else {
                        System.out.println("\nNo se encontró un producto con ese dato.\n");
                    }
                } while (opcion1 != 4);
            } else {
                System.out.println("\nNo se encontró un producto con ese dato.\n");
            }
        }
    }

    public static void borrarProducto(ArrayList<Producto> listaProductos) {
        int encontrado = -1;
        Producto productoEncontrado = null;
        listarProductos();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("\nIngrese el id del producto que desea eliminar o digite 0 para salir : \n");
        int buscado = sc.nextInt();
        if (buscado != 0) {
            for (Producto producto : listaProductos) {
                if (producto.getId() == buscado) {
                    encontrado = buscado;
                }
            }
            if (encontrado > 0) {
                productoEncontrado = listaProductos.get(encontrado - 1);
                System.out.println("\nEsta por borrar el producto " + productoEncontrado.toString());
                System.out.println("Digite S para confirmar\n");
                String opcion1 = sc1.nextLine();
                if (opcion1.equalsIgnoreCase("s")) {
                    listaProductos.remove(encontrado - 1);
                    System.out.println("\nEl producto se borró con éxito.\n");
                }else{
                    return;
                }
                
            } else {
                System.out.println("\nNo se encontró el producto para eliminar\n");
            }
        }
    }

    public static void listarPedidos(ArrayList<Pedido> listaPedidos) {
        if (listaPedidos.isEmpty()) {
            System.out.println("\nNo hay pedidos cargados...\n");
        } else {
            for (Pedido pedido : listaPedidos) {
                System.out.println(pedido.imprimirPedido(pedido));
            }
        }

    }

    public static void cargarPedido(ArrayList<Producto> listaProductos, ArrayList<Pedido> listaPedidos) {
        int opcion = 1;
        ArrayList<ItemPedido> pedidoNuevo = new ArrayList<ItemPedido>();
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        int contador = 1;
        while (opcion != 0) {
            ItemPedido item = new ItemPedido();
            System.out.println("\nIngrese el id del producto para agregar al pedido...O digite 0 para salir\n");
            listarProductos();
            opcion = sc.nextInt();
            if (opcion != 0) {
                Producto productoElegido = obtenerProducto(opcion, listaProductos);
                if (productoElegido == null) {
                    System.out.println("\nNo hay un producto con ese id\n");
                } else {
                    item.setIdItem(contador);
                    item.setProducto(productoElegido);
                    System.out.println("\nIngrese la cantidad deseada\n");
                    int cant = sc.nextInt();
                    while (cant > listaProductos.get(opcion - 1).getCantStock()) {
                        System.out.println("\nLa cantidad no puede ser mayor al stock actual\n");
                        System.out.println("\nIngrese la cantidad deseada\n");
                        cant = sc.nextInt();
                    }
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
        System.out.println("\nEl pedido " + (pedido.getIdPedido()) + " se generó con éxito.\n");
        pedido.setIdPedido(Pedido.contadorId);
        Pedido.contadorId += 1;
        listaPedidos.add(pedido);
    }

}

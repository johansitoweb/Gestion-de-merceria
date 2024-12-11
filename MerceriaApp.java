import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

public class MerceriaApp {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    modificarProducto();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestión de Mercería ---");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Eliminar Producto");
        System.out.println("3. Modificar Producto");
        System.out.println("4. Listar Productos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        productos.add(new Producto(nombre, precio));
        System.out.println("Producto agregado exitosamente.");
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (id >= 0 && id < productos.size()) {
            productos.remove(id);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    private static void modificarProducto() {
        System.out.print("Ingrese el ID del producto a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (id >= 0 && id < productos.size()) {
            Producto producto = productos.get(id);
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            System.out.println("Producto modificado exitosamente.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    private static void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println("ID: " + i + " | Nombre: " + producto.getNombre() + " | Precio: " + producto.getPrecio());
        }
    }
}

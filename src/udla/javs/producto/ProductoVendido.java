package udla.javs.producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoVendido extends Producto{

    // Declaración de atributos
    private String nombreVendedor;
    private String nombreCliente;
    private String fechaVenta;
    private int cantidadVenta;
    private float margen_de_ganancia;

    // Creación de listas
    List<ProductoVendido> productosVendido = new ArrayList<>();

    // Creación de constructor
    public ProductoVendido() {}

    public ProductoVendido(String nombre, String categoria, String marca, String modelo, String sku, String sucursal, float precioCompra, float precioVenta, String nombreVendedor, String nombreCliente, String fechaVenta, int cantidadVenta, float margen_de_ganancia) {
        super(nombre, categoria, marca, modelo, sku, sucursal, 0, precioCompra, precioVenta); // Llamada al constructor de la clase padre
        this.nombreVendedor = nombreVendedor;
        this.nombreCliente = nombreCliente;
        this.fechaVenta = fechaVenta;
        this.cantidadVenta = cantidadVenta;
        this.margen_de_ganancia = margen_de_ganancia;
    }

    // Creación de getters y setters
    public String getNombreVendedor() { return nombreVendedor; }

    public void setNombreVendedor(String nombreVendedor) { this.nombreVendedor = nombreVendedor; }

    public String getNombreCliente() { return nombreCliente; }

    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getFechaVenta() { return fechaVenta; }

    public void setFechaVenta(String fechaVenta) { this.fechaVenta = fechaVenta; }

    public int getCantidadVenta() { return cantidadVenta; }

    public void setCantidadVenta(int cantidadVenta) { this.cantidadVenta = cantidadVenta; }

    public float getMargen_de_ganancia() { return margen_de_ganancia; }

    public void setMargen_de_ganancia(float margen_de_ganancia) { this.margen_de_ganancia = margen_de_ganancia; }

    // Metodo para agregar una nueva venta
    public void agregarVenta() {
        Producto buscar = new Producto();
        String sku = JOptionPane.showInputDialog(null, "Ingrese el SKU del objeto");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad vendida del objeto"));
        buscar.editarCantidadProducto(sku, cantidad);
        buscar.buscarVenta(sku, productosVendido, cantidad);
    }

    // Metodo para mostrar los detalles de la venta
    public void mostrarDetallesVenta() {
        if (productosVendido.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        // Encabezado de la tabla
        System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10s %-15s %-15s %-20s %-20s %-15s %-20s%n", "Nombre", "Categoría", "Marca", "Modelo", "SKU", "Sucursal", "Precio Compra", "Precio Venta", "Nombre Vendedor", "Nombre Cliente", "Fecha Venta", "Cantidad Venta", "Margen de ganancia");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Filas de la tabla con los datos de cada producto
        for (ProductoVendido productoVen : productosVendido) {
            System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10.2f %-15.2f %-15s %-20s %-20s %-15d %-20.2f%n",
                    productoVen.getNombre(),
                    productoVen.getCategoria(),
                    productoVen.getMarca(),
                    productoVen.getModelo(),
                    productoVen.getSku(),
                    productoVen.getSucursal(),
                    productoVen.getPrecioCompra(),
                    productoVen.getPrecioVenta(),
                    productoVen.getNombreVendedor(),
                    productoVen.getNombreCliente(),
                    productoVen.getFechaVenta(),
                    productoVen.getCantidadVenta(),
                    productoVen.getMargen_de_ganancia());
        }
    }
}
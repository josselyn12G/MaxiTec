package udla.javs.producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDevuelto extends Producto {
    private String motivo;
    private String fechaDevolucion;
    private Producto producto;

    static final List<ProductoDevuelto> productosDevueltos = new ArrayList<>();

    public ProductoDevuelto() {}

    public ProductoDevuelto(String motivo, String fechaDevolucion, Producto producto) {
        this.motivo = motivo;
        this.fechaDevolucion = fechaDevolucion;
        this.producto = producto;
    }

    // Getters y Setters (omitidos aquí por brevedad)


    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void registrarDevolucion() {
        Producto producto = new Producto();
        String sku = JOptionPane.showInputDialog(null, "Ingrese el SKU del objeto");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad devuelta del objeto"));
        producto.editarCantidadProducto2(sku, cantidad);
        producto.buscarDevolucion(sku, productosDevueltos, cantidad);
    }

    // Metodo para mostrar el historial de devoluciones
    public void mostrarHistorialDevoluciones() {
        if (productosDevueltos.isEmpty()) {
            System.out.println("No hay productos devueltos registrados.");
            return;
        }

        System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10s %-15s %-15s %-20s %-20s%n",
                "Nombre", "Categoría", "Marca", "Modelo", "SKU", "Sucursal", "Cantidad", "Precio Compra", "Precio Venta", "Motivo", "Fecha Devolución");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (ProductoDevuelto productoDev : productosDevueltos) {
            Producto producto = productoDev.getProducto();
            System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10d %-15.2f %-15.2f %-20s %-20s%n",
                    producto.getNombre(), producto.getCategoria(), producto.getMarca(), producto.getModelo(),
                    producto.getSku(), producto.getSucursal(), producto.getCantidad(), producto.getPrecioCompra(),
                    producto.getPrecioVenta(), productoDev.getMotivo(), productoDev.getFechaDevolucion());
        }
    }
}
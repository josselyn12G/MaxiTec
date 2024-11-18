package udla.javs.producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    // Declaracion de atributos
    private String nombre;
    private String categoria;
    private String marca;
    private String modelo;
    private String sku;
    private String sucursal;
    private int cantidad;
    private float precioCompra;
    private float precioVenta;
    private int stockmax;
    private int stockmin;

    // Creación de listas

    static final List<Producto> productos = new ArrayList<>();

    // Declaración de constructor
    public Producto(){

    }
    public Producto( String sku, String sucursal, int cantidad) {
        this.sku = sku;
        this.sucursal = sucursal;
        this.cantidad = cantidad;
    }


    public Producto(String nombre, String categoria, String marca, String modelo, String sku, String sucursal, int cantidad, float precioCompra, float precioVenta) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.sku = sku;
        this.sucursal = sucursal;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }



    //Declaración Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockmax() {
        return stockmax;
    }

    public void setStockmax(int stockmax) {
        this.stockmax = stockmax;

    }

    public int getStockmin() {
        return stockmin;
    }

    public void setStockmin(int stockmin) {
        this.stockmin = stockmin;

    }

    // Creación de métodos.

    // Metodo para crear producto

    public void crearProducto() {

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto:");
        String sku = JOptionPane.showInputDialog(null, "Ingrese el SKU del producto:");
        String categoria = JOptionPane.showInputDialog(null, "Ingrese la categoría del producto:");
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del producto:");
        String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del producto:");
        String sucursal = JOptionPane.showInputDialog(null, "Ingrese la sucursal:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad:"));
        float precioCompra = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio de compra:"));
        float precioVenta = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio de venta:"));

        Producto nuevoProducto = new Producto(nombre, categoria, marca, modelo, sku, sucursal, cantidad, precioCompra, precioVenta);

        // Agregar el nuevo producto a la lista de productos
        productos.add(nuevoProducto);
        JOptionPane.showMessageDialog(null, "Producto agregado exitosamente.");
    }



    // Metodo para mostrar todos los productos en forma de tabla
    public void mostrarStock() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        // Encabezado de la tabla
        System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10s %-15s %-15s%n", "Nombre", "Categoría", "Marca", "Modelo", "SKU", "Sucursal", "Cantidad", "Precio Compra", "Precio Venta");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        // Filas de la tabla con los datos de cada producto
        for (Producto producto : productos) {
            System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10d %-15.2f %-15.2f%n", producto.getNombre(), producto.getCategoria(), producto.getMarca(), producto.getModelo(), producto.getSku(), producto.getSucursal(), producto.getCantidad(), producto.getPrecioCompra(), producto.getPrecioVenta());
        }
    }

    // Metodo para configurar el umbral del stock

    public void configurarUmbralStock() {
        int stockMin;
        int stockMax;
        // Validar stock mínimo
        do {
            stockMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad mínima de productos:"));
            if (stockMin < 0) {
                JOptionPane.showMessageDialog(null, "El stock mínimo no puede ser menor que cero. Por favor, intente nuevamente.");
            }
        } while (stockMin < 0);
        // Validar stock máximo
        do {
            stockMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad máxima de productos:"));
            if (stockMax <= stockMin) {
                JOptionPane.showMessageDialog(null, "El stock máximo debe ser mayor que el stock mínimo. Por favor, intente nuevamente.");
            }
        } while (stockMax <= stockMin);
        // Asignar los valores con setters
        setStockmin(stockMin);
        setStockmax(stockMax);
        JOptionPane.showMessageDialog(null, "Configuración de umbral de stock realizada exitosamente:\n" + "Stock mínimo: " + getStockmin() + "\n" +  "Stock máximo: " + getStockmax());
    }

    // Metodo para buscar el producto y mostrarlo.
    public void buscarProducto(String sku){
        boolean encontrado = false;
        // Recorrer la lista de productos con un for.
        for (Producto producto : productos) {
            // Verificar si el SKU coincide con alguno de los productos ya almacenados en la lista
            if (producto.getSku().equalsIgnoreCase(sku)) {
                System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10s %-15s %-15s%n", "Nombre", "Categoría", "Marca", "Modelo", "SKU", "Sucursal", "Cantidad", "Precio Compra", "Precio Venta");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-20s %-15s %-15s %-15s %-10s %-15s %-10d %-15.2f %-15.2f%n", producto.getNombre(), producto.getCategoria(), producto.getMarca(), producto.getModelo(), producto.getSku(), producto.getSucursal(), producto.getCantidad(), producto.getPrecioCompra(), producto.getPrecioVenta());
                encontrado = true;
            }
        }
        // En caso de que no se encuentre el producto.
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.");
        }
    }

    // Metodo para editar producto
    public void editarProducto(String sku) {
        boolean encontrado = false;
        // Buscar el producto con el SKU proporcionado
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                encontrado = true;
                // Mostrar el producto actual antes de la edición
                String infoActual = String.format("Datos actuales del producto:\n" + "Nombre: %s\n" + "Categoría: %s\n" + "Marca: %s\n" + "Modelo: %s\n" + "SKU: %s\n" + "Sucursal: %s\n" + "Cantidad: %d\n" + "Precio Compra: %.2f\n" + "Precio Venta: %.2f", producto.getNombre(), producto.getCategoria(), producto.getMarca(), producto.getModelo(), producto.getSku(), producto.getSucursal(), producto.getCantidad(), producto.getPrecioCompra(), producto.getPrecioVenta());
                JOptionPane.showMessageDialog(null, infoActual, "Editar Producto", JOptionPane.INFORMATION_MESSAGE);
                // Solicitar nuevos valores y asignación con setters para actualizar los atributos.
                producto.setNombre(JOptionPane.showInputDialog(null, "Nuevo Nombre:", producto.getNombre()));
                producto.setCategoria(JOptionPane.showInputDialog(null, "Nueva Categoría:",producto.getCategoria()));
                producto.setMarca(JOptionPane.showInputDialog(null, "Nueva Marca:", producto.getMarca()));
                producto.setModelo(JOptionPane.showInputDialog(null, "Nuevo Modelo:", producto.getModelo()));
                producto.setSucursal(JOptionPane.showInputDialog(null, "Nueva Sucursal:", producto.getSucursal()));
                producto.setCantidad(Integer.parseInt(JOptionPane.showInputDialog(null, "Nueva Cantidad:", producto.getCantidad())));
                producto.setPrecioCompra(Float.parseFloat(JOptionPane.showInputDialog(null, "Nuevo Precio de Compra:", producto.getPrecioCompra())));
                producto.setPrecioVenta(Float.parseFloat(JOptionPane.showInputDialog(null, "Nuevo Precio de Venta:", producto.getPrecioVenta())));
                JOptionPane.showMessageDialog(null, "El producto ha sido actualizado exitosamente.");
                break;
            }
        }
        // Mensaje si no se encuentra el producto
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Metodo para editar la cantidad de un producto
    public void editarCantidadProducto(String sku, int cantidadVendida) {
        boolean encontrado = false;

        // Buscar el producto con el SKU proporcionado
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                encontrado = true;

                // Verificar que no se vendan más productos de los disponibles
                if (cantidadVendida > producto.getCantidad()) {
                    JOptionPane.showMessageDialog(null, "Error: No puedes vender más productos de los disponibles.", "Cantidad Insuficiente", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Actualizar la cantidad del producto
                    int nuevaCantidad = producto.getCantidad() - cantidadVendida;
                    producto.setCantidad(nuevaCantidad);

                    JOptionPane.showMessageDialog(null, "La venta se ha registrado exitosamente.\nNueva cantidad en inventario: " + nuevaCantidad);
                }
                break;
            }
        }

        // Mensaje si no se encuentra el producto
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Metodo para editar cantidad del producto
    public void editarCantidadProducto2(String sku, int cantidadDevuelta) {
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                encontrado = true;
                int nuevaCantidad = producto.getCantidad() + cantidadDevuelta;
                producto.setCantidad(nuevaCantidad);
                JOptionPane.showMessageDialog(null, "El producto ha sido actualizado exitosamente.\nNueva cantidad: " + nuevaCantidad);
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void buscarVenta(String sku, List<ProductoVendido> listaDestino, int cantidadVendida) {
        boolean encontrado = false;

        // Recorrer la lista de productos
        for (Producto producto : productos) {
            // Verificar si el SKU coincide
            if (producto.getSku().equalsIgnoreCase(sku)) {
                if (cantidadVendida > producto.getCantidad()) {
                    JOptionPane.showMessageDialog(null, "Error: No puedes vender más productos de los disponibles.", "Cantidad Insuficiente", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un nuevo objeto ProductoVendido basado en el producto original
                ProductoVendido productoVendido = new ProductoVendido(
                        producto.getNombre(),
                        producto.getCategoria(),
                        producto.getMarca(),
                        producto.getModelo(),
                        producto.getSku(),
                        producto.getSucursal(),
                        producto.getPrecioCompra(),
                        producto.getPrecioVenta(),
                        JOptionPane.showInputDialog(null, "Ingrese el nombre del vendedor:"),
                        JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:"),
                        JOptionPane.showInputDialog(null, "Ingrese la fecha de la venta (dd/mm/yyyy):"),
                        cantidadVendida,
                        producto.getPrecioVenta() - producto.getPrecioCompra() // Margen de ganancia
                );

                // Agregar el objeto ProductoVendido a la lista destino
                listaDestino.add(productoVendido);



                encontrado = true;
                break;
            }
        }

        // En caso de que no se encuentre el producto
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.");
        }
    }

    // Metodo para buscar y devolver un producto
    public void buscarDevolucion(String sku, List<ProductoDevuelto> listaDestino, int cantidadDevuelta) {
        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                ProductoDevuelto productoDevuelto = new ProductoDevuelto(JOptionPane.showInputDialog(null, "Ingrese el motivo de la devolución:"), JOptionPane.showInputDialog(null, "Ingrese la fecha de la devolución (dd/mm/yyyy):"), producto);

                listaDestino.add(productoDevuelto);

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.");
        }
    }



    // Metodo para eliminar el producto
    public void eliminarProducto(String sku) {
        boolean eliminado = false;

        // Buscar y eliminar el producto con el SKU proporcionado
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                // Confirmar la eliminación mostrando los datos del producto que se va a eliminar
                int confirmacion = JOptionPane.showConfirmDialog(null, String.format("¿Está seguro de que desea eliminar el producto?\n" + "Nombre: %s\n" + "Categoría: %s\n" + "Marca: %s\n" + "Modelo: %s\n" + "SKU: %s\n" + "Sucursal: %s\n" + "Cantidad: %d\n" + "Precio Compra: %.2f\n" + "Precio Venta: %.2f", producto.getNombre(), producto.getCategoria(), producto.getMarca(), producto.getModelo(), producto.getSku(), producto.getSucursal(), producto.getCantidad(), producto.getPrecioCompra(), producto.getPrecioVenta()), "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    productos.remove(producto); // Eliminar el producto
                    eliminado = true;
                    JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
                }
                break;
            }
        }
        // Mensaje si no se encuentra el producto
        if (!eliminado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el SKU proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo para verificar la disponibilidad de un producto en específico.
    public void verificarDisponibilidad(String sku) {
        boolean encontrado = false; // Bandera para verificar si el producto existe.

        // Mostrar encabezado de la tabla
        System.out.println("Stock mínimo: " + getStockmin() + "          Stock máximo: " + getStockmax());
        System.out.printf("%-20s %-15s %-15s %-10s %-20s%n", "Nombre", "SKU", "Modelo", "Cantidad", "Observación");
        System.out.println("--------------------------------------------------------------------------------------------");

        // Recorrer productos y verificar la disponibilidad
        for (Producto producto : productos) {
            String observacion;
            // Verificar si el SKU coincide (ignorando mayúsculas/minúsculas)
            if (producto.getSku().equalsIgnoreCase(sku)) {
                // Determinar la observación según los umbrales
                if (producto.getCantidad() < this.stockmin) {
                    observacion = "¡Stock crítico! Necesita reabastecimiento.";
                } else if (producto.getCantidad() > this.stockmax) {
                    observacion = "¡Exceso de stock! Revaluar inventario.";
                } else {
                    observacion = "En nivel óptimo.";
                }

                encontrado = true;
                // Imprimir los datos del producto en formato tabla
                System.out.printf("%-20s %-15s %-15s %-10d %-20s%n",
                        producto.getNombre(), producto.getSku(), producto.getModelo(),
                        producto.getCantidad(), observacion);
            }
        }

        // Mostrar mensaje si no se encontró el producto
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No hay un producto con ese SKU", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}



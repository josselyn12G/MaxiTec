package udla.javs.producto;

import javax.swing.*;

import java.util.ArrayList;

import java.util.List;


public class ProductoPedido extends Producto {
    // Declaración de atributos
    private String nombreEmpleado;
    private String idPedido;
    private String nombreProveedor;
    private String fechaSolicitud;
    private String fechaEntrega;
    private String estadoPedido; // "Pendiente", "Aprobado", "Rechazado"
    private String prioridad;    // "Alta", "Media", "Baja"

    // Lista para almacenar los pedidos
    private static List<ProductoPedido> historialPedidos = new ArrayList<>();

    // Constructor
    public ProductoPedido(String nombreEmpleado, String idPedido, String nombreProveedor, String fechaSolicitud, String fechaEntrega, String estadoPedido, String prioridad, String sku, String sucursal, int cantidad) {
        // Llamada al constructor de la clase padre Producto
        super(sku, sucursal, cantidad);
        // Inicialización de los atributos específicos de ProductoPedido
        this.nombreEmpleado = nombreEmpleado;
        this.idPedido = idPedido;
        this.nombreProveedor = nombreProveedor;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaEntrega = fechaEntrega;
        this.estadoPedido = estadoPedido;
        this.prioridad = prioridad;
    }


    public ProductoPedido() {

    }

    // Getters y Setters
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public static List<ProductoPedido> getHistorialPedidos() {
        return historialPedidos;
    }

    public static void setHistorialPedidos(List<ProductoPedido> historialPedidos) {
        ProductoPedido.historialPedidos = historialPedidos;
    }

    // Metodo para agregar una nueva solicitud de pedido
    public void agregarSolicitud() {
        // Solicitar datos mediante JOptionPane
        String nombreEmpleado = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        String idPedido = JOptionPane.showInputDialog("Ingrese el ID del pedido:");
        String nombreProveedor = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
        String fechaSolicitud = JOptionPane.showInputDialog("Ingrese la fecha de solicitud (dd/MM/aa):");
        String fechaEntrega = JOptionPane.showInputDialog("Ingrese la fecha de entrega (dd/MM/aa):");
        String prioridad = JOptionPane.showInputDialog("Ingrese la prioridad (Alta, Media, Baja):");

        // Solicitar los atributos de la clase Producto
        String sku = JOptionPane.showInputDialog("Ingrese el SKU del producto:");
        String sucursal = JOptionPane.showInputDialog("Ingrese la sucursal del producto:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto:"));

        // Crear un nuevo objeto de ProductoPedido con la información ingresada
        ProductoPedido nuevoPedido = new ProductoPedido(nombreEmpleado, idPedido, nombreProveedor, fechaSolicitud, fechaEntrega, "Pendiente", prioridad, sku, sucursal, cantidad);

        // Agregar el pedido al historial
        historialPedidos.add(nuevoPedido);

        // Mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Solicitud de pedido agregada con éxito.");
    }


    // Metodo para mostrar el historial de pedidos
    public void mostrarHistorialPedidos() {
        if (historialPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        // Imprimir los encabezados de la tabla, incluyendo solo los atributos relevantes de Producto
        System.out.printf("%-15s %-15s %-20s %-15s %-15s %-15s %-10s %-15s %-10s %-10s%n",
                "ID Pedido", "Empleado", "Proveedor", "Fecha Solicitud", "Fecha Entrega",
                "Estado", "Prioridad", "SKU", "Sucursal", "Cantidad");
        System.out.println("-------------------------------------------------------------------------------------------");

        // Imprimir cada pedido en la tabla, incluyendo los detalles relevantes de Producto
        for (ProductoPedido pedido : historialPedidos) {
            System.out.printf("%-15s %-15s %-20s %-15s %-15s %-15s %-10s %-15s %-10s %-10d%n",
                    pedido.getIdPedido(),
                    pedido.getNombreEmpleado(),
                    pedido.getNombreProveedor(),
                    pedido.getFechaSolicitud(),
                    pedido.getFechaEntrega(),
                    pedido.getEstadoPedido(),
                    pedido.getPrioridad(),
                    pedido.getSku(),      // Solo SKU
                    pedido.getSucursal(), // Solo Sucursal
                    pedido.getCantidad()); // Solo Cantidad
        }
    }



    // Metodo para buscar un pedido específico por ID

    public void buscarPedido(String idPedido) {
        // Buscar el pedido en el historial
        ProductoPedido pedidoEncontrado = null;

        for (ProductoPedido pedido : historialPedidos) {
            if (pedido.getIdPedido().equalsIgnoreCase(idPedido)) {
                pedidoEncontrado = pedido;
                break;
            }
        }

        // Verificar si se encontró el pedido
        if (pedidoEncontrado != null) {
            System.out.printf("%-15s %-15s %-20s %-15s %-15s %-15s %-10s %-15s %-15s %-10s%n", "ID Pedido", "Empleado", "Proveedor", "Fecha Solicitud", "Fecha Entrega", "Estado", "Prioridad", "SKU", "Sucursal", "Cantidad");
            System.out.println("-------------------------------------------------------------------------------------------");

            // Imprimir los datos del pedido junto con el SKU, Sucursal y Cantidad
            System.out.printf("%-15s %-15s %-20s %-15s %-15s %-15s %-10s %-15s %-15s %-10d%n", pedidoEncontrado.getIdPedido(), pedidoEncontrado.getNombreEmpleado(), pedidoEncontrado.getNombreProveedor(), pedidoEncontrado.getFechaSolicitud(), pedidoEncontrado.getFechaEntrega(), pedidoEncontrado.getEstadoPedido(), pedidoEncontrado.getPrioridad(), pedidoEncontrado.getSku(), pedidoEncontrado.getCantidad());
        } else {
            System.out.println("No se encontró ningún pedido con el ID: " + idPedido);
        }
    }



    // Metodo para aprobar o rechazar una solicitud de pedido
    public void aprobarSolicitud(String idPedido) {
        for (ProductoPedido pedido : historialPedidos) {
            if (pedido.getIdPedido().equalsIgnoreCase(idPedido)) {
                // Verificar si el pedido ya tiene un estado diferente de "Pendiente"
                if (!"Pendiente".equalsIgnoreCase(pedido.getEstadoPedido())) {
                    JOptionPane.showMessageDialog(null, "El pedido ya fue " + pedido.getEstadoPedido().toLowerCase() + ".", "Estado del Pedido", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea aprobar o rechazar el pedido con ID " + idPedido + "?", "Aprobar/Rechazar Pedido",JOptionPane.YES_NO_OPTION);

                // De acuerdo con la elección del usuario
                if (opcion == 0) { // Aprobar
                    pedido.setEstadoPedido("Aprobado");
                    JOptionPane.showMessageDialog(null, "La solicitud de pedido con ID " + idPedido + " ha sido aprobada.", "Pedido Aprobado", JOptionPane.INFORMATION_MESSAGE);
                } else if (opcion == 1) { // Rechazar
                    pedido.setEstadoPedido("Rechazado");
                    JOptionPane.showMessageDialog(null, "La solicitud de pedido con ID " + idPedido + " ha sido rechazada.", "Pedido Rechazado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se realizó ninguna acción.", "Acción Cancelada", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
        }
        // Si no se encuentra el pedido con el ID dado
        JOptionPane.showMessageDialog(null, "No se encontró un pedido con el ID: " + idPedido, "Pedido No Encontrado", JOptionPane.ERROR_MESSAGE);
    }


}
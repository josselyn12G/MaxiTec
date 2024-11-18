package udla.javs.usuario;

import udla.javs.producto.Producto;
import udla.javs.producto.ProductoDevuelto;
import udla.javs.producto.ProductoPedido;
import udla.javs.producto.ProductoVendido;
import udla.javs.proveedor.Proveedor;

import javax.swing.*;

public class Usuario {
    // Declaración de atributos.
    private String nombre;
    private String id;
    private String password;
    private Producto producto;
    private ProductoVendido productoVendido;
    private ProductoDevuelto productoDevuelto;
    private ProductoPedido productoPedido;
    private Proveedor proveedor;

    // Creación de constructor
    public Usuario(){

    }

    public Usuario(String nombre, String id, String password) {
        this.nombre = nombre;
        this.id = id;
        this.password = password;
        // Inicialización Instanciación de los objetos necesarios
        producto = new Producto();
        productoPedido = new ProductoPedido();
        productoDevuelto = new ProductoDevuelto();
        productoVendido = new ProductoVendido();
        proveedor = new Proveedor();
    }

    // Creación de getters y setters.

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoVendido getProductoVendido() {
        return productoVendido;
    }

    public void setProductoVendido(ProductoVendido productoVendido) {
        this.productoVendido = productoVendido;
    }

    public ProductoDevuelto getProductoDevuelto() {
        return productoDevuelto;
    }

    public void setProductoDevuelto(ProductoDevuelto productoDevuelto) {
        this.productoDevuelto = productoDevuelto;
    }

    public ProductoPedido getProductoPedido() {
        return productoPedido;
    }

    public void setProductoPedido(ProductoPedido productoPedido) {
        this.productoPedido = productoPedido;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    // Creación de metodos propios.

    // Metodo para mostrar el menu.
    public void mostrarMenu(Administrador admin1, Empleado empleado1){

    }


    // Metodo para visualizar el stock.
    public void visualizarStock(){
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Visualizar Stock.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) { // JoptionPane.YES_OPTION nos devuelve el valor de 0.
            producto.mostrarStock();
        }
    }

    // Metodo para buscar producto.
    public void buscarProducto(){
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Buscar Producto.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) { // JoptionPane.YES_OPTION nos devuelve el valor de 0 y ejecutamos la llamada a los métodos de otras clases.
            String sku = JOptionPane.showInputDialog(null, "Sku del Producto: ");
            producto.buscarProducto(sku);
        }
    }

    // Metodo para mostrar historial de pedidos
    public void mostrarHistorialPedidos() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Historial de Pedidos.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            productoPedido.mostrarHistorialPedidos();
        }
    }


    // Metodo para mostrar historial de devoluciones
    public void mostrarHistorialDevoluciones() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Historial de Devoluciones.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            productoDevuelto.mostrarHistorialDevoluciones();
        }
    }

    // Metodo para mostrar historial de devoluciones
    public void mostrarHistorialVentas() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Historial de Ventas.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            productoVendido.mostrarDetallesVenta();
        }
    }

    // Metodo para mostrar lista de proveedores
    public void mostrarListaProveedores() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Lista de Proveedores.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            proveedor.mostrarProveedores(); // Ya se instancio un objeto de ese tipo en el constructor.
        }
    }

    // Metodo para verificar la disponibilidad de todos los productos... es decir se va a mostrar una advertencia si la cantidad es menor que el umbral o un ok si es normal.
    public void revisarDisponibilidadProducto(){
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Verificar Disponibilidad.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) { // JoptionPane.YES_OPTION nos devuelve el valor de 0.
            String sku = JOptionPane.showInputDialog(null, "Sku del Producto: ");
            producto.verificarDisponibilidad(sku);
        }
    }


    // Metodo para validar el acceso.
    public boolean validarAcceso(String id, String password, Administrador admin1, Empleado empleado1) {
        return this.id.equals(id) && this.password.equals(password);
    }

    // Metodo para buscar pedido con id especifico
    public void buscarPedido(){
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Buscar pedido con ID.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) { // JoptionPane.YES_OPTION nos devuelve el valor de 0.
            String idPedido = JOptionPane.showInputDialog(null, "ID del pedido: ");
            productoPedido.buscarPedido(idPedido);
        }

    }



}

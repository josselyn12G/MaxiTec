package udla.javs.usuario;

import udla.javs.producto.Producto;
import udla.javs.producto.ProductoDevuelto;
import udla.javs.producto.ProductoPedido;
import udla.javs.producto.ProductoVendido;
import udla.javs.proveedor.Proveedor;
import javax.swing.*;
import static udla.javs.usuario.InventarioGeneral.autenticar; // Cuando son estáticos se puede llamar a esos métodos directamente sin necesidad de especificar la clase que los contiene

public class Empleado extends Usuario {

    // Declaración de atributos
    private String sucursal;
    private String rol;

    // Creación de constructor
    public Empleado(){

    }

    public Empleado(String nombre, String id, String password, String sucursal, String rol) {
        // Llamada al constructor de la clase padre Usuario
        super(nombre, id, password);
        this.sucursal = sucursal;
        this.rol = rol;
    }


    // Creación de getters y setters

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Métodos getter y setter para los atributos heredados de Usuario
    public Producto getProducto() {
        return super.getProducto(); // Llamando al getter de la clase Usuario
    }

    public void setProducto(Producto producto) {
        super.setProducto(producto);
    }

    public ProductoVendido getProductoVendido() {
        return super.getProductoVendido(); // Llamando al getter de la clase Usuario
    }

    public void setProductoVendido(ProductoVendido productoVendido) {
        super.setProductoVendido(productoVendido); // Llamando al setter de la clase Usuario
    }

    public ProductoDevuelto getProductoDevuelto() {
        return super.getProductoDevuelto();
    }

    public void setProductoDevuelto(ProductoDevuelto productoDevuelto) {
        super.setProductoDevuelto(productoDevuelto);
    }

    public ProductoPedido getProductoPedido() {
        return super.getProductoPedido();
    }

    public void setProductoPedido(ProductoPedido productoPedido) {
        super.setProductoPedido(productoPedido);
    }

    public Proveedor getProveedor() {
        return super.getProveedor();
    }

    public void setProveedor(Proveedor proveedor) {
        super.setProveedor(proveedor);
    }


    // Creación de metodos propios

    // Metodo para validar el acceso que utiliza polimorfismo.
    @Override
    public boolean validarAcceso(String id, String password, Administrador admin1, Empleado empleado1) {
        if (super.validarAcceso(id, password,admin1, empleado1)) {
            JOptionPane.showMessageDialog(null, "Bienvenido Empleado! \nNombre: " + getNombre() + "\nID: " +getId() + "\nSucursal: " +getSucursal() + "\nRol: "+getRol());
            mostrarMenu(admin1, empleado1);
            return true;
        }
        return false;
    }

    // Metodo para mostrar el menu para el empleado.
    @Override
    public void mostrarMenu(Administrador admin1, Empleado empleado1){
        do{
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, " 1. Visualizar Stock \n 2. Registrar Venta \n 3. Registrar Devolución \n 4. Buscar Producto \n 5. Solicitar Compra de Producto\n6. Mostrar Historial de Devoluciones \n 7. Mostrar Historial de Ventas \n 8. Mostrar Lista de Proveedores \n 9.Mostrar historial pedidos \n 10. Buscar Pedido con ID.\n 11. Cambiar de cuenta. \n 12. Salir"));
            switch (option){
                case 1:
                    // Metodo heredado de la clase padre usuario
                    visualizarStock();
                    break;
                case 2:
                    registrarVenta(); // ESTE
                    break;
                case 3:
                    registrarDevolucion();// ESTE
                    break;
                case 4:
                    // Metodo heredado de la clase padre usuario
                    buscarProducto();
                    break;
                case 5:
                    solicitarCompraProducto(); // ESTE
                    break;
                case 6:
                    mostrarHistorialDevoluciones();
                    break;
                case 7:
                    mostrarHistorialVentas(); // ESTE
                    break;
                case 8:
                    mostrarListaProveedores();
                    break;
                case 9:
                    mostrarHistorialPedidos();;
                    break;
                case 10:
                    buscarPedido();
                case 11:
                    autenticar(admin1, empleado1);
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida! Intenta de nuevo!");
                    break;
            }
        }while(true);
    }

    // Metodo para registrar una venta propio de la clase empleado.
    public void registrarVenta() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Registrar Venta.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProductoVendido().agregarVenta();
        }
    }

    // Metodo para registrar una devolución de producto propio de la clase empleado.
    public void registrarDevolucion() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Registrar Devolución de Producto.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProductoDevuelto().registrarDevolucion();
        }
    }

    // Metodo para solicitar la compra del producto.
    public void solicitarCompraProducto(){
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Solicitar Compra de Producto.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
                getProductoPedido().agregarSolicitud();
        }
    }



}


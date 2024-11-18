package udla.javs.usuario;

import udla.javs.producto.Producto;
import udla.javs.producto.ProductoDevuelto;
import udla.javs.producto.ProductoPedido;
import udla.javs.producto.ProductoVendido;
import udla.javs.proveedor.Proveedor;
import javax.swing.*;
import static udla.javs.usuario.InventarioGeneral.autenticar;

public class Administrador extends Usuario{

    // Declaración de atributos
    private String firmaDigital;

    // Creación de constructor.
    public Administrador(String nombre, String id, String password, String firmaDigital) {
        // Llamada al constructor de la clase base Usuario
        super(nombre, id, password);
        this.firmaDigital = firmaDigital;
    }

    // Creación de getters y setters

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
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





    // Creación de métodos propios

    // Metodo para validación de acceso.
    @Override
    public boolean validarAcceso(String id, String password, Administrador admin1, Empleado empleado1) {
        if (super.validarAcceso(id, password, admin1, empleado1)) {
            JOptionPane.showMessageDialog(null, "Bienvenido Administrador! \nNombre: "  + getNombre() + "\nID: " +getId() + "\nNivel: " +getFirmaDigital() );
            mostrarMenu(admin1,empleado1);
            return true;
        }
        return false;

    }

    // Metodo para mostrar menu
    @Override
    public void mostrarMenu(Administrador admin1, Empleado empleado1) {
        do{
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, " 1. Visualizar Stock \n 2. Aprobar Solicitud de Compra \n 3. Configurar Umbral del Stock \n 4. Buscar Producto \n 5. Crear Producto \n 6. Editar Producto \n 7. Eliminar Producto \n 8. Registrar Proveedor \n 9. Editar Proveedor \n 10. Eliminar Proveedor \n 11. Mostrar Historial de Devoluciones \n 12. Mostrar Historial de Ventas \n 13. Mostrar Lista de Proveedores. \n 14. Mostrar Historial Pedidos. \n 15. Verificar disponibilidad del producto \n 16. Buscar Pedido. \n 17. Cambiar de cuenta. \n 18. Salir"));

            switch (option) {
                case 1:
                    // Metodo heredado de la clase padre usuario
                    visualizarStock(); // La función devuelve un valor VERDADERO afirmando que la acción se ha completado.
                    break;
                case 2:
                    aprobarSolicitudPedido();
                    break;
                case 3:
                    configurarUmbralStock();
                    break;
                case 4:
                    // Metodo heredado de la clase padre usuario
                    buscarProducto();
                    break;
                case 5:
                    crearProducto();
                    break;
                case 6:
                    editarProducto();
                    break;
                case 7:
                    eliminarProducto();
                    break;
                case 8:
                    registrarProveedor();
                    break;
                case 9:
                    editarProveedor();
                    break;
                case 10:
                    eliminarProveedor();
                    break;
                case 11:
                    mostrarHistorialDevoluciones();
                    break;
                case 12:
                    mostrarHistorialVentas();
                    break;
                case 13:
                    mostrarListaProveedores();
                    break;
                case 14:
                    mostrarHistorialPedidos();
                    break;
                case 15:
                    revisarDisponibilidadProducto();
                    break;
                case 16:
                    buscarPedido();
                case 17:
                    autenticar(admin1, empleado1);
                    break;
                case 18:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida! Intenta de nuevo!");
                    break;
            }
        }while(true);

    }

    // Metodo visualizar stock en la clase usuario.

    // Metodo para aprobar solicitud de compra
    public void aprobarSolicitudPedido() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Aprobar Solicitud de Pedido.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            String idPedido = JOptionPane.showInputDialog(null, "ID del pedido: ");
            getProductoPedido().aprobarSolicitud(idPedido);
        }
    }


    // Metodo  para configurar el umbral del stock de productos.
    public void configurarUmbralStock() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Configurar Umbral de Stock.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProducto().configurarUmbralStock();
        }

    }

    // Metodo buscar producto en la clase Usuario

    // Metodo para editar producto
    public void editarProducto() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Editar Producto.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            String sku = JOptionPane.showInputDialog(null, "Sku del Producto: ");
            getProducto().editarProducto(sku);
        }

    }
    // Metodo para eliminar un producto
    public void eliminarProducto() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Eliminar Producto.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            String sku = JOptionPane.showInputDialog(null, "Sku del Producto: ");
            getProducto().eliminarProducto(sku);
        }

    }
    // Metodo para crear Producto
    public void crearProducto() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Crear Producto.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProducto().crearProducto();
        }
    }



    // Metodo para eliminar Proveedor
    public void eliminarProveedor() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Eliminar Proveedor.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProveedor().eliminarProveedor();
        }
    }

    // Metodo para editar el Proveedor
    public void editarProveedor() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Editar Proveedor.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProveedor().editarProveedor();
        }
    }

    // Metodo para registrar el Proveedor
    public void registrarProveedor() {
        int answer = JOptionPane.showConfirmDialog(null, "Opción: Registrar Proveedor.\n¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            getProveedor().agregarProveedor();
        }
    }








}

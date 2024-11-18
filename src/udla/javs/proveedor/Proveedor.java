package udla.javs.proveedor;

import javax.swing.*;
import java.util.ArrayList;

public class Proveedor {

    // Declaración de atributos
    private String nombreProveedor;
    private String idUnico;
    private String celular;
    private String direccion;

    // Lista de proveedores
    private static ArrayList<Proveedor> listaProveedores = new ArrayList<>();

    // Constructor
    public Proveedor(){

    }

    public Proveedor(String nombreProveedor, String idUnico, String celular, String direccion) {
        this.nombreProveedor = nombreProveedor;
        this.idUnico = idUnico;
        this.celular = celular;
        this.direccion = direccion;
    }

    // Creación de getters y setters.

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Creación de metodos propios.

    // Metodo para agregar un proveedor
    public void agregarProveedor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
        String id = JOptionPane.showInputDialog("Ingrese el ID único del proveedor:");
        String celular = JOptionPane.showInputDialog("Ingrese el número de celular del proveedor:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del proveedor:");

        Proveedor nuevoProveedor = new Proveedor(nombre, id, celular, direccion);
        listaProveedores.add(nuevoProveedor);

        JOptionPane.showMessageDialog(null, "Proveedor agregado con éxito.");
    }

    // Metodo para eliminar un proveedor
    public void eliminarProveedor() {
        String id = JOptionPane.showInputDialog("Ingrese el ID único del proveedor a eliminar:");
        Proveedor proveedorAEliminar = null;
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdUnico().equals(id)) {
                proveedorAEliminar = proveedor;
                break;
            }
        }
        if (proveedorAEliminar != null) {
            listaProveedores.remove(proveedorAEliminar);
            JOptionPane.showMessageDialog(null, "Proveedor eliminado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
        }
    }

    // Metodo para editar un proveedor
    public void editarProveedor() {
        String id = JOptionPane.showInputDialog("Ingrese el ID único del proveedor a editar:");

        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getIdUnico().equals(id)) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del proveedor:", proveedor.getNombreProveedor());
                String nuevoCelular = JOptionPane.showInputDialog("Ingrese el nuevo celular del proveedor:", proveedor.getCelular());
                String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección del proveedor:", proveedor.getDireccion());

                proveedor.setNombreProveedor(nuevoNombre);
                proveedor.setCelular(nuevoCelular);
                proveedor.setDireccion(nuevaDireccion);

                JOptionPane.showMessageDialog(null, "Proveedor editado con éxito.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
    }

    // Metodo para mostrar la lista de proveedores
    public void mostrarProveedores() {
        if (listaProveedores.isEmpty()) {
            System.out.println("No hay proveedores en la lista.");
        } else {
            // Imprimir encabezado de la tabla
            System.out.printf("%-15s %-20s %-15s %-30s%n", "ID", "Nombre", "Celular", "Dirección");
            System.out.println("---------------------------------------------------------------");

            // Recorrer la lista de proveedores e imprimir sus datos en formato tabla
            for (Proveedor proveedor : listaProveedores) {
                System.out.printf("%-15s %-20s %-15s %-30s%n", proveedor.getIdUnico(), proveedor.getNombreProveedor(), proveedor.getCelular(), proveedor.getDireccion());
            }
        }
    }


}
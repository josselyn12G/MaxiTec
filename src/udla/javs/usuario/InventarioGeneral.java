package udla.javs.usuario;

import javax.swing.*;

public class InventarioGeneral {
    public static void main(String[] args) {
        // Instanciar un administrador y empleado tipo base.
        Administrador admin1 = new Administrador("Marco Gómez", "321", "aqmdla12","1713728432001");
        Empleado empleado1 = new Empleado("Samuel Chalá", "123", "ganmg5", "Eloy Alfaro", "Vendedor");

        // Mostrar mensaje de ingreso.
        JOptionPane.showMessageDialog(null, "Sistema MaxiTec Inventario");

        // Llamar al metodo de autenticación y pasar las instancias de administrador y empleado
        autenticar(admin1, empleado1);

        // Finalización
        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema!");

    }


    // Creación de metodos propios.
    public static void autenticar(Administrador administrador, Empleado empleado) {

        // Variables para verificar el acceso
        boolean accesoAdmin = true;
        boolean accesoEmpleado = true;
        int intento;

        // Bucle de autenticación
        do {
            // Solicitar ID y contraseña al usuario
            String id = JOptionPane.showInputDialog(null, "Nombre de usuario: ");
            String password = JOptionPane.showInputDialog(null, "Contraseña: ");

            // Validar el acceso con el administrador y el empleado43
            accesoAdmin = administrador.validarAcceso(id, password, administrador, empleado);
            accesoEmpleado = empleado.validarAcceso(id, password, administrador,empleado);

            // Mostrar mensaje de acceso denegado si ambos intentos fallan
            if (!accesoAdmin && !accesoEmpleado) {
                JOptionPane.showMessageDialog(null, "Acceso denegado. Credenciales incorrectas.");
                intento = JOptionPane.showConfirmDialog(null, "¿Desea intentar de nuevo?", "Confirmación", JOptionPane.YES_NO_OPTION);
            } else {
                // Salir del bucle si el acceso es exitoso
                break;
            }
        } while (intento == 0);

    }


}

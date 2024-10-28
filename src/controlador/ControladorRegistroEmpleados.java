package controlador;

import modelo.Empleados;
import modelo.ArchivosEmpleados;
import vista.RegistroEmpleados;
import vista.LoginVista;
import javax.swing.*;

public class ControladorRegistroEmpleados {
    private RegistroEmpleados vista;

    public ControladorRegistroEmpleados(RegistroEmpleados vista) {
        this.vista = vista;

        // Asumiendo que la vista tiene métodos para agregar ActionListeners
        this.vista.setActionListeners(new RegistrarListener(), new IniciarListener());
    }

    private class RegistrarListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String nombres = vista.getNombre(); // Método que deberás crear en la vista
            String rols = vista.getRol(); // Método que deberás crear en la vista
            String users = vista.getUsuario(); // Método que deberás crear en la vista
            String contraseñas = vista.getContrasena(); // Método que deberás crear en la vista

            if (nombres.isEmpty() || rols.isEmpty() || users.isEmpty() || contraseñas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!Validaciones.noNum(nombres) || !Validaciones.noNum(rols)) {
                JOptionPane.showMessageDialog(null, "El nombre y rol solo deben contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!Validaciones.noEspacios(users) || !Validaciones.noEspacios(contraseñas)) {
                JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña no pueden contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Empleados nuevoEmpleado = new Empleados(nombres, rols, users, contraseñas);
                ArchivosEmpleados archivoEmpleados = new ArchivosEmpleados("empleados.txt");
                archivoEmpleados.guardarEmpleado(nuevoEmpleado);
                JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.");
                vista.limpiarCampos(); // Método que deberás crear en la vista para limpiar campos
            }
        }
    }

    private class IniciarListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            vista.dispose(); // Cerrar la vista
            LoginVista login = new LoginVista(); // Asumiendo que tienes una clase LoginVista
            login.setVisible(true);
        }
    }
}

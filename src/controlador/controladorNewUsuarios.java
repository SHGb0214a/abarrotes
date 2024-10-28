/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.ArchivosClientes;
import modelo.Usuario;
import vista.FormsUsuariosVista;
import vista.LoginVista;

/**
 *
 * @author Dania Lozano
 */
public class controladorNewUsuarios {
    private FormsUsuariosVista vista;

    public controladorNewUsuarios(FormsUsuariosVista vista) {
        this.vista = vista;
        this.vista.setActionListeners(new RegistrarListener());
    }

    private class RegistrarListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String nombres = vista.getNombre(); // Método que deberás crear en la vista
            String users = vista.getUsuario(); // Método que deberás crear en la vista
            String contraseñas = vista.getContrasena(); // Método que deberás crear en la vista

            if (nombres.isEmpty() || users.isEmpty() || contraseñas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!Validaciones.noNum(nombres)) {
                JOptionPane.showMessageDialog(null, "El nombre solo deben contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!Validaciones.noEspacios(users) || !Validaciones.noEspacios(contraseñas)) {
                JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña no pueden contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario nuevoUsuario = new Usuario(nombres, users, contraseñas);
                ArchivosClientes archivoClientes = new ArchivosClientes("clientes.txt");
                archivoClientes.guardarCliente(nuevoUsuario);
                JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
                vista.limpiarCampos(); 
            }
        }
    }
}

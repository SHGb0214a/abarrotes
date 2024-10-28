package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ArchivosEmpleados;
import modelo.Empleados;
import vista.LoginVista;
import vista.RegistroEmpleados;
import vista.MenuPrincipal;
import controlador.Validaciones;
import controlador.MenuController;
public class controladorLogin extends JFrame{
    private LoginVista vista;
    MenuController controller = new MenuController();
    public controladorLogin(LoginVista vista) {
        this.vista = vista;

        // Asumiendo que la vista tiene métodos para agregar ActionListeners
        this.vista.setActionListeners(new loginListener());
    }

    private class loginListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String usuarioIngresado = vista.getCorreo(); // Método que deberás crear en la vista
            String contraseniaIngresada = vista.getContrasenia(); // Método que deberás crear en la vista
            if (usuarioIngresado.isEmpty() || contraseniaIngresada.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!Validaciones.noEspacios(usuarioIngresado) || !Validaciones.noEspacios(contraseniaIngresada)) {
                JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña no pueden contener espacios en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ArchivosEmpleados archivoEmpleados = new ArchivosEmpleados("empleados.txt");
                boolean esValido = archivoEmpleados.validarEmpleado(usuarioIngresado, contraseniaIngresada);
                
                if (esValido) {
                    vista.dispose();
                    MenuPrincipal menuPrincipal = new MenuPrincipal(controller);
                    menuPrincipal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                vista.limpiarCampos(); // Método que deberás crear en la vista para limpiar campos
            }
        }
    }

}

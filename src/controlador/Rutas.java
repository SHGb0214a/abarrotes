package controlador;

import javax.swing.JFrame;
import vista.CrearProducto;
import vista.FormsUsuariosVista;
import vista.RegistroEmpleados;


import javax.swing.JOptionPane;
import vista.Inventario;
import vista.MenuPrincipal;
import vista.UsuariosInterfaz;

public class Rutas extends JFrame{
    public static void abrirVentana(String nombreVentana, MenuPrincipal menu) {
        menu.dispose();
        switch (nombreVentana) {
            case "Generar compra" -> new CrearProducto().setVisible(true);
            case "Inventario" -> new Inventario().setVisible(true);
            case "Empleados" -> new RegistroEmpleados().setVisible(true);
            case "Reportes" -> new CrearProducto().setVisible(true);
            case "Provedor" -> new CrearProducto().setVisible(true);
            case "Usuarios" -> new UsuariosInterfaz().setVisible(true);
            default -> JOptionPane.showMessageDialog(null, "Ventana no encontrada.");
        }
    }
}

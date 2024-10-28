package controlador;

import javax.swing.*;
import vista.LoginVista;
import vista.MenuPrincipal;

public class ControladorBotones extends JFrame{
    private JFrame vistaActual;
    private MenuController controller;

    public ControladorBotones(JFrame vistaActual, MenuController controller) {
        this.vistaActual = vistaActual;
        this.controller = controller;
    }

    // Método para configurar los listeners en los botones de cualquier ventana
    public void setActionListenersBotones(JButton regresarButton, JButton cerrarButton) {
        regresarButton.addActionListener(new RegresarListener());
        cerrarButton.addActionListener(new CerrarListener());
    }

    // Listener para el botón de "Regresar"
    private class RegresarListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            vistaActual.dispose();
            MenuPrincipal menu = new MenuPrincipal(controller);
            menu.setVisible(true);
        }
    }

    // Listener para el botón de "Cerrar"
    private class CerrarListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            vistaActual.dispose(); 
            LoginVista login = new LoginVista(); 
            login.setVisible(true);
        }
    }
}
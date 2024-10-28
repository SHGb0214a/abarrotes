package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vista.CrearProducto;
import vista.Inventario;
import vista.ModificarProducto;

public class ControladorBotonesInventario {
    private Inventario vista;
    
    public ControladorBotonesInventario(Inventario vista) {
        this.vista = vista;
    }

    public void setActionListenersBotones(JButton crea, JButton modifica) {
        crea.addActionListener(new crearListener());
        modifica.addActionListener(new modificarListener());
    }

    private class crearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose();
            CrearProducto crear = new CrearProducto();
            crear.setVisible(true);
        }
    }

    private class modificarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose(); 
            ModificarProducto modificar = new ModificarProducto();
            modificar.setVisible(true);
        }
    }
}


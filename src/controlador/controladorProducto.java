package controlador;

import javax.swing.JOptionPane;
import modelo.ArchivosClientes;
import modelo.ArchivosProductos;
import modelo.Producto;
import vista.LoginVista;
import vista.CrearProducto;

public class controladorProducto {
    private CrearProducto vista;

    public controladorProducto(CrearProducto vista) {
        this.vista = vista;

        // Asumiendo que la vista tiene métodos para agregar ActionListeners
        this.vista.setActionListeners(new crearListener(), new cancelarListener());
    }

    private class crearListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String codigos = vista.getCodigo(); // Método que deberás crear en la vista
            String nombres = vista.getNombre(); // Método que deberás crear en la vista
            String descripciones = vista.getDescripcion(); // Método que deberás crear en la vista
            double precios = vista.getPrecio(); // Método que deberás crear en la vista
            int stock = vista.getCantidad();
            if (nombres.isEmpty() || codigos.isEmpty() || descripciones.isEmpty()|| precios <= 0 || stock <= 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (!Validaciones.noNum(nombres) || !Validaciones.noNum(descripciones)) {
                JOptionPane.showMessageDialog(null, "El nombre y la descripción solo deben contener letras.", "Error", JOptionPane.ERROR_MESSAGE);            
            } else {
                Producto nuevoProducto = new Producto(codigos, nombres, descripciones, precios, stock);
                ArchivosProductos archivoProducto = new ArchivosProductos("productos.txt");
                archivoProducto.guardarProducto(nuevoProducto);
                JOptionPane.showMessageDialog(null, "Producto registrado correctamente.");
                vista.limpiarCampos(); // Método que deberás crear en la vista para limpiar campos
            }
        }
    }

    private class cancelarListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            vista.limpiarCampos();
        }
    }
}

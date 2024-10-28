/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorBotones;
import controlador.MenuController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import modelo.ArchivosProductos;
import modelo.Producto;

/**
 *
 * @author Dania Lozano
 */
public class EliminarProducto extends JFrame{
    private ArchivosProductos archivosProductos = new ArchivosProductos("productos.txt");
    MenuController controller = new MenuController();
    JPanel pantalla;
    JTextField tcodigo, tnombre, tdesc, tprecio, tcant;
    JLabel nombreLabel, descLabel, precioLabel,cantLabel;
    JButton cerrarButton, Inicio, eliminar, buscar;
    public EliminarProducto() {
        setTitle("Modificar Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        pantalla = new JPanel();
        pantalla.setLayout(new GridLayout(10, 1, 5, 10));
        pantalla.setBackground(new Color(190, 221, 231));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        JLabel titulo = new JLabel("Eliminar Producto", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);

        JLabel codigo = new JLabel("Código o Nombre del Producto: ");
        codigo.setFont(labelFont);
        tcodigo = new JTextField();
        tcodigo.setFont(fieldFont);

        JPanel searchPanel = new JPanel(new GridLayout(1, 2));
        searchPanel.add(codigo);
        searchPanel.add(tcodigo);
        
        pantalla.add(searchPanel);
        
        tnombre = new JTextField();
        tdesc = new JTextField();
        tprecio = new JTextField();
        tcant = new JTextField();

        tnombre.setVisible(false);
        tdesc.setVisible(false);
        tprecio.setVisible(false);
        tcant.setVisible(false);
        tnombre.setEditable(false);
        tdesc.setEditable(false);
        tprecio.setEditable(false);
        tcant.setEditable(false);
        nombreLabel = new JLabel("Nombre: ");
        descLabel = new JLabel("Descripción: ");
        precioLabel = new JLabel("Precio: "); 
        cantLabel = new JLabel("Cantidad: ");
        
        pantalla.add(tnombre);
        pantalla.add(tdesc);
        pantalla.add(tprecio);
        pantalla.add(tcant);
        pantalla.add(nombreLabel);
        pantalla.add(descLabel);
        pantalla.add(precioLabel);
        pantalla.add(cantLabel);
        buscar = new JButton("Buscar");
        buscar.setBackground(new Color(51, 51, 51));
        buscar.setForeground(new Color(255, 255, 255));
        buscar.setFont(labelFont);
        buscar.addActionListener(e -> buscarProducto()); 

        eliminar = new JButton("Eliminar");
        eliminar.setBackground(new Color(51, 51, 51));
        eliminar.setForeground(new Color(255, 255, 255));
        eliminar.setFont(labelFont);
        eliminar.addActionListener(e -> eliminarProducto());

        JPanel botone = new JPanel();
        botone.setLayout(new GridLayout(1, 3, 30, 10));
        botone.setBackground(new Color(190, 221, 231));
        botone.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        botone.add(buscar);
        botone.add(eliminar);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(190, 221, 231));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 250, 10, 250));

        mainpanel.add(pantalla, BorderLayout.CENTER);
        mainpanel.add(botone, BorderLayout.SOUTH);
        
        cerrarButton = new JButton("Cerrar sesión");
        cerrarButton.setBackground(new Color(255, 0, 0));
        cerrarButton.setForeground(new Color(255, 255, 255));
        cerrarButton.setPreferredSize(new Dimension(200, 40));
        cerrarButton.setFont(labelFont);
        
        JPanel Encabezado= new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(116, 136, 201));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(40, 380, 40, 75));

        Encabezado.add(titulo, BorderLayout.CENTER);
        Encabezado.add(cerrarButton, BorderLayout.EAST);

        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage(); 

        Image imagenRedimensionada = imagen.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenRedimensionada); 
        imagenLabel.setIcon(imagenIcon);

        JPanel Logopanel = new JPanel(); 
        Logopanel.setLayout(new BorderLayout());
        Logopanel.setBackground(new Color(116, 136, 201));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        Logopanel.add(imagenLabel);

        JPanel MenuBoton = new JPanel(); 
        MenuBoton.setLayout(new GridLayout(2, 1, 30, 10));
        MenuBoton.setBackground(new Color(116, 136, 201));
        MenuBoton.setBorder(BorderFactory.createEmptyBorder(110, 20, 20, 20));

        Inicio = new JButton("Regresar");
        Inicio.setBackground(new Color(51, 51, 51));
        Inicio.setForeground(new Color(255, 255, 255));
        Inicio.setFont(labelFont);
        Inicio.setPreferredSize(new Dimension(200, 40));

        MenuBoton.add(Inicio);

        JPanel MenuI = new JPanel();
        MenuI.setLayout(new BorderLayout(0, 5));
        MenuI.setBackground(new Color(116, 136, 201));
        MenuI.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        MenuI.add(MenuBoton, BorderLayout.SOUTH);
        MenuI.add(Logopanel, BorderLayout.CENTER);
        
        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(MenuI, BorderLayout.WEST);
        
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(Inicio, cerrarButton);
    }
    private void buscarProducto() {
        String criterio = tcodigo.getText().trim();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un código o nombre de producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        var productosEncontrados = archivosProductos.buscarProducto(criterio);
        if (productosEncontrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto producto = productosEncontrados.get(0); 
        JOptionPane.showMessageDialog(this, "Se encontró el producto, ingrese los datos a cambiar", "Información", JOptionPane.INFORMATION_MESSAGE);

        tnombre.setText(producto.getNombre());
        tdesc.setText(producto.getDescripcion());
        tprecio.setText(String.valueOf(producto.getPrecio()));
        tcant.setText(String.valueOf(producto.getCantidad()));
        
        tnombre.setVisible(true);
        tdesc.setVisible(true);
        tprecio.setVisible(true);
        tcant.setVisible(true);
        
        nombreLabel.setVisible(true);
        descLabel.setVisible(true);
        precioLabel.setVisible(true);
        cantLabel.setVisible(true);
        pantalla.revalidate();
        pantalla.repaint();
    }
    
    private void eliminarProducto() {
        String criterio = tcodigo.getText().trim();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un código o nombre de producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = archivosProductos.eliminarProducto(criterio);
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void limpiarCampos() {
        tcodigo.setText("");
        tnombre.setText("");
        tdesc.setText("");
        tprecio.setText("");
        tcant.setText("");
        tnombre.setVisible(false);
        tdesc.setVisible(false);
        tprecio.setVisible(false);
        tcant.setVisible(false);
    }
}
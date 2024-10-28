package vista;

import controlador.ControladorBotones;
import controlador.ControladorBotonesInventario;
import controlador.MenuController;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArchivosClientes;
import modelo.ArchivosEmpleados;
import modelo.ArchivosProductos;
import modelo.Empleados;
import modelo.Producto;
import modelo.Usuario;
import vista.EliminarProducto;
public class Inventario extends JFrame{
    DefaultTableModel modeloTabla;
    JScrollPane tablilla;
    JButton Inicio, cerrarButton, crea, modifica;
    MenuController controller = new MenuController();
    public Inventario(){
        //Ajustes de la ventana
        setTitle("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        //Panel del vista
        JPanel pantalla = new JPanel(); 
        pantalla.setLayout(new BorderLayout(10, 10));
        pantalla.setBackground(new Color(190, 221, 231));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 30));
 
        //Fuentes para etiquetas y cuadros
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        
        //Etiqueta del titulo 
        JLabel titulo = new JLabel("Productos", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);

        //Cuadro de busqueda
        JTextField buscar = new JTextField();
        buscar.setFont(fieldFont);
        
        JButton busca = new JButton("Buscar");
        busca.setBackground(new Color(51, 51, 51));
        busca.setForeground(new Color(255, 255, 255));
        busca.setPreferredSize(new Dimension(200, 40));
        busca.setFont(labelFont);
       
        //Añadir los componentes al panel de vista
        pantalla.add(buscar, BorderLayout.CENTER);
        pantalla.add(busca, BorderLayout.EAST);

        //Panel para la tabla
        JPanel tabla = new JPanel();
        tabla.setLayout(new GridLayout(1, 1, 30, 10));
        tabla.setBackground(new Color(255, 255, 255));
        tabla.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        String[] columnas = {"Codigo", "Nombre", "Descripcion", "Precio", "Cantidad"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tablaProductos = new JTable(modeloTabla);
        tablilla = new JScrollPane(tablaProductos);
        tabla.add(tablilla);
        //Panel principal del formulario)
        JButton mostrar = new JButton("Mostrar todos los productos");
        mostrar.setBackground(new Color(51, 51, 51));
        mostrar.setForeground(new Color(255, 255, 255));
        mostrar.setPreferredSize(new Dimension(200, 40));
        mostrar.setFont(labelFont);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(190, 221, 231));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        mainpanel.add(pantalla, BorderLayout.NORTH);
        mainpanel.add(tabla, BorderLayout.CENTER);
        mainpanel.add(mostrar, BorderLayout.SOUTH);
        //Boton de cerrar sesión
        cerrarButton = new JButton("Cerrar sesión");
        cerrarButton.setBackground(new Color(255, 0, 0));
        cerrarButton.setForeground(new Color(255, 255, 255));
        cerrarButton.setPreferredSize(new Dimension(200, 40));
        cerrarButton.setFont(labelFont);
        
        //Panel botones encabezado
        JPanel botone = new JPanel(); 
        botone.setLayout(new GridLayout(1, 4, 50, 10));
        botone.setBackground(new Color(116, 136, 201));
        botone.setBorder(BorderFactory.createEmptyBorder(20, 90, 20, 30));
        
        //Botones del encabezado
        crea = new JButton("+Crear Producto");
        crea.setBackground(new Color(51, 51, 51));
        crea.setForeground(new Color(255, 255, 255));
        crea.setPreferredSize(new Dimension(200, 40));
        crea.setFont(labelFont);
        
        modifica = new JButton("Modificar Producto");
        modifica.setBackground(new Color(51, 51, 51));
        modifica.setForeground(new Color(255, 255, 255));
        modifica.setPreferredSize(new Dimension(200, 40));
        modifica.setFont(labelFont);
        
        JButton borra = new JButton("Eliminar Producto");
        borra.setBackground(new Color(51, 51, 51));
        borra.setForeground(new Color(255, 255, 255));
        borra.setPreferredSize(new Dimension(200, 40));
        borra.setFont(labelFont);
        
        //Agregar botones a su panel
        botone.add(crea);
        botone.add(modifica);
        botone.add(borra);
        botone.add(cerrarButton);
        
        //Panel del encabezado 
        JPanel Encabezado= new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(116, 136, 201));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 40));
        
        //Añadir componentes del encabezado
        Encabezado.add(titulo, BorderLayout.WEST);
        Encabezado.add(botone, BorderLayout.CENTER);
        
        //Agregar el logo
        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage(); 

        //Redimensionar el Logo y colocarlo en la etiqueta
        Image imagenRedimensionada = imagen.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenRedimensionada); 
        imagenLabel.setIcon(imagenIcon);

        //Panel del Logo
        JPanel Logopanel = new JPanel(); 
        Logopanel.setLayout(new BorderLayout());
        Logopanel.setBackground(new Color(116, 136, 201));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        //Añadir el logo a su panel
        Logopanel.add(imagenLabel);

        //Panel de los botones del menu
        JPanel MenuBoton = new JPanel(); 
        MenuBoton.setLayout(new GridLayout(2, 1, 30, 10));
        MenuBoton.setBackground(new Color(116, 136, 201));
        MenuBoton.setBorder(BorderFactory.createEmptyBorder(120, 20, 20, 20));

        //Botones del Menu
        Inicio = new JButton("Regresar");
        Inicio.setBackground(new Color(51, 51, 51));
        Inicio.setForeground(new Color(255, 255, 255));
        Inicio.setFont(labelFont);
        Inicio.setPreferredSize(new Dimension(50, 40));

        //Añadir botones al panel de botones del menu
        MenuBoton.add(Inicio);

        //Panel del Menu
        JPanel MenuI = new JPanel();
        MenuI.setLayout(new BorderLayout(0, 5));
        MenuI.setBackground(new Color(116, 136, 201));
        MenuI.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        //Añadir los componentes al Panel del menu
        MenuI.add(MenuBoton, BorderLayout.SOUTH);
        MenuI.add(Logopanel, BorderLayout.CENTER);
        
        //Se añaden los tres paneles principales a la ventana
        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(MenuI, BorderLayout.WEST);
        cargarProductos();
        
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(Inicio, cerrarButton);
        ControladorBotonesInventario controlador = new ControladorBotonesInventario(this);
        controlador.setActionListenersBotones(crea, modifica);
        busca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscarTexto = buscar.getText().trim();
                if (buscarTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de búsqueda no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                ArchivosProductos archivoProductos = new ArchivosProductos("productos.txt");
                List<Producto> productosEncontrados = archivoProductos.buscarProducto(buscarTexto);
                
                if (productosEncontrados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún producto con el criterio: " + buscarTexto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    actualizarTabla(productosEncontrados);
            }
                }
        });
        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProductos();
            }
        });
        borra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual de Inventario
                EliminarProducto eliminar = new EliminarProducto();
                eliminar.setVisible(true);
            }
        });
    }
    
    private void cargarProductos() {
        ArchivosProductos archivoProducto = new ArchivosProductos("productos.txt");
        List<Producto> productos = archivoProducto.leerProductos();
        actualizarTabla(productos);
    }


    // Update employee table
    private void actualizarTabla(List<Producto> productos) {
        // Clear previous data
        modeloTabla.setRowCount(0);
        for (Producto producto : productos) {
            modeloTabla.addRow(new Object[]{producto.getCodigo(), producto.getNombre(),producto.getDescripcion(), producto.getPrecio(), producto.getCantidad()});
        }
    }
    
    public void setActionListenersBotones(ActionListener regresarListener, ActionListener cerrarListener){
        Inicio.addActionListener(regresarListener);
        cerrarButton.addActionListener(cerrarListener);
    }
}
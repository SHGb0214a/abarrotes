package vista;

import controlador.ControladorBotones;
import controlador.MenuController;
import controlador.controladorProducto;
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
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CrearProducto extends JFrame{
    JTextField tcodigo, tnombre, tdesc, tprecio, tcant;
    MenuController controller = new MenuController();
    JButton guardar, cancela, cerrarButton, Inicio;
    public CrearProducto(){

        //Ajustes de la ventana
        setTitle("Crear Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        //Panel del formulario
        JPanel pantalla = new JPanel(); 
        pantalla.setLayout(new GridLayout(10, 1, 5, 10));
        pantalla.setBackground(new Color(190, 221, 231));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
        //Fuentes para etiquetas y cuadros
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        
        //Etiqueta del titulo 
        JLabel titulo = new JLabel("Crear Producto", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);

        //Etiquetas y cuadros del formulario
        JLabel codigo = new JLabel("Código: ");
        codigo.setFont(labelFont);
        tcodigo = new JTextField();
        tcodigo.setFont(fieldFont);
        
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setFont(labelFont);
        tnombre = new JTextField();
        tnombre.setFont(fieldFont);

        JLabel desc = new JLabel("Descripción: ");
        desc.setFont(labelFont);
        tdesc = new JTextField();
        tdesc.setFont(fieldFont);

        JLabel precio = new JLabel("Precio: ");
        precio.setFont(labelFont);
        tprecio = new JTextField();
        tprecio.setFont(fieldFont);

        JLabel cant = new JLabel("Cantidad: ");
        cant.setFont(labelFont);
        tcant = new JTextField();
        tcant.setFont(fieldFont);

        //Añadir los componentes al panel del formulario
        pantalla.add(codigo);
        pantalla.add(tcodigo);
        pantalla.add(nombre);
        pantalla.add(tnombre);
        pantalla.add(desc);
        pantalla.add(tdesc);
        pantalla.add(precio);
        pantalla.add(tprecio);
        pantalla.add(cant);
        pantalla.add(tcant);

        //Creación de botones del formulario
        guardar = new JButton("Crear");
        guardar.setBackground(new Color(51, 51, 51));
        guardar.setForeground(new Color(255, 255, 255));
        guardar.setFont(labelFont);
        guardar.setPreferredSize(new Dimension(200, 40));
        cancela = new JButton("Cancelar");
        cancela.setBackground(new Color(51, 51, 51));
        cancela.setForeground(new Color(255, 255, 255));
        cancela.setFont(labelFont);
        cancela.setPreferredSize(new Dimension(200, 40));


        //Panel para los botones del formulario
        JPanel botone = new JPanel(); 
        botone.setLayout(new GridLayout(1, 1, 30, 10));
        botone.setBackground(new Color(190, 221, 231));
        botone.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));

        botone.add(guardar);
        botone.add(cancela);

        //Panel principal del formulario(donde se añaden los paneles de los componentes y botones)
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(190, 221, 231));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 250, 10, 250));

        mainpanel.add(pantalla, BorderLayout.CENTER);
        mainpanel.add(botone, BorderLayout.SOUTH);

        //Boton de cerrar sesión
        cerrarButton = new JButton("Cerrar sesión");
        cerrarButton.setBackground(new Color(255, 0, 0));
        cerrarButton.setForeground(new Color(255, 255, 255));
        cerrarButton.setPreferredSize(new Dimension(200, 40));
        cerrarButton.setFont(labelFont);

        //Panel del encabezado 
        JPanel Encabezado= new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(116, 136, 201));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(40, 380, 40, 75));
        
        //Añadir componentes del encabezado
        Encabezado.add(titulo, BorderLayout.CENTER);
        Encabezado.add(cerrarButton, BorderLayout.EAST);
        
        //Etiqueta del menu
        JLabel menu = new JLabel("MENÚ");
        menu.setFont(labelTiFont);
        menu.setBorder(BorderFactory.createEmptyBorder(20, 65, 10, 20));

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
        
        controladorProducto controlador = new controladorProducto(this);
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(Inicio, cerrarButton);
    }
    public String getNombre() {
        return tnombre.getText();
    }
    public String getCodigo(){
        return tcodigo.getText();
    }
    public String getDescripcion(){
        return tdesc.getText();
    }
    public double getPrecio() {
        try {
            return Double.parseDouble(tprecio.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un precio válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return 0.0; // Puedes cambiar este valor según tu lógica, como retornar -1 o un valor por defecto
        }
    }
    
    public void limpiarCampos() {
        tcodigo.setText("");
        tnombre.setText("");
        tdesc.setText("");
        tprecio.setText("");
        tcant.setText("");
    }
    public int getCantidad() {
        try {
            return Integer.parseInt(tcant.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad válida.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return 0; // Al igual que en el caso anterior, puedes cambiar este valor según tu lógica
        }
    }
    
    public void setActionListeners(ActionListener crearListener, ActionListener cancelarListener) {
        guardar.addActionListener(crearListener);
        cancela.addActionListener(cancelarListener); 
    }
    public void setActionListenersBotones(ActionListener regresarListener, ActionListener cerrarListener){
        Inicio.addActionListener(regresarListener);
        cerrarButton.addActionListener(cerrarListener);
    }
}

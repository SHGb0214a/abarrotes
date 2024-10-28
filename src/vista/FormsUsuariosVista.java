package vista;

import controlador.ControladorBotones;
import controlador.MenuController;
import controlador.controladorNewUsuarios;
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
import javax.swing.JPasswordField;

public class FormsUsuariosVista extends JFrame {
    JTextField tnombre, tusuario;
    JPasswordField tcontrasenia;
    JButton guardar, Inicio, cerrarButton;
    MenuController controller = new MenuController();
    public FormsUsuariosVista() {
        setTitle("Crear nuevo usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        //Panel del formulario
        JPanel pantalla = new JPanel(); 
        pantalla.setLayout(new GridLayout(10, 1, 5, 10));
        pantalla.setBackground(new Color(239, 231, 208));
        pantalla.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
 
        //Fuentes para etiquetas y cuadros
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        
        //Etiqueta del titulo 
        JLabel titulo = new JLabel("Crear nuevo usuario", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);

        //Etiquetas y cuadros del formulario
        
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setFont(labelFont);
        tnombre = new JTextField();
        tnombre.setFont(fieldFont);

        JLabel usuario = new JLabel("Usuario: ");
        usuario.setFont(labelFont);
        tusuario= new JTextField();
        tusuario.setFont(fieldFont);

        JLabel contrasenia = new JLabel("Contraseña: ");
        contrasenia.setFont(labelFont);
        tcontrasenia = new JPasswordField();
        tcontrasenia.setFont(fieldFont);


        //Añadir los componentes al panel del formulario
        pantalla.add(usuario);
        pantalla.add(tusuario);
        pantalla.add(nombre);
        pantalla.add(tnombre);
        pantalla.add(contrasenia);
        pantalla.add(tcontrasenia);

        //Creación de botones del formulario
        guardar = new JButton("Crear");
        guardar.setBackground(new Color(51, 51, 51));
        guardar.setForeground(new Color(255, 255, 255));
        guardar.setFont(labelFont);
        JButton cancela = new JButton("Cancelar");
        cancela.setBackground(new Color(51, 51, 51));
        cancela.setForeground(new Color(255, 255, 255));
        cancela.setFont(labelFont);
        cancela.setPreferredSize(new Dimension(200, 40));


        //Panel para los botones del formulario
        JPanel botone = new JPanel(); 
        botone.setLayout(new GridLayout(1, 1, 30, 10));
        botone.setBackground(new Color(239, 231, 208));
        botone.setBorder(BorderFactory.createEmptyBorder(0, 60, 30, 60));

        botone.add(guardar);
        botone.add(cancela);

        //Panel principal del formulario(donde se añaden los paneles de los componentes y botones)
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(239, 231, 208));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(100, 250, 100, 250));

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
        Encabezado.setBackground(new Color(242, 164, 139));
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
        Logopanel.setBackground(new Color(	242, 164, 139));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        //Añadir el logo a su panel
        Logopanel.add(imagenLabel);

        //Panel de los botones del menu
        JPanel MenuBoton = new JPanel(); 
        MenuBoton.setLayout(new GridLayout(2, 1, 30, 10));
        MenuBoton.setBackground(new Color(	242, 164, 139));
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
        MenuI.setBackground(new Color(	242, 164, 139));
        MenuI.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        //Añadir los componentes al Panel del menu
        MenuI.add(MenuBoton, BorderLayout.SOUTH);
        MenuI.add(Logopanel, BorderLayout.CENTER);

        //Se añaden los tres paneles principales a la ventana
        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(MenuI, BorderLayout.WEST);
        controladorNewUsuarios controlador = new controladorNewUsuarios(this);
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(Inicio, cerrarButton);
    }
    
    public String getNombre() {
        return tnombre.getText();
    }

    public String getUsuario() {
        return tusuario.getText().trim();
    }

    public String getContrasena() {
        return new String(tcontrasenia.getPassword()).trim(); 
    }
    public void limpiarCampos() {
        tnombre.setText("");
        tusuario.setText("");
        tcontrasenia.setText("");
    }
    
    public void setActionListeners(ActionListener registrarListener) {
        guardar.addActionListener(registrarListener); 
    }
    
    public void setActionListenersBotones(ActionListener regresarListener, ActionListener cerrarListener){
        Inicio.addActionListener(regresarListener);
        cerrarButton.addActionListener(cerrarListener);
    }
}
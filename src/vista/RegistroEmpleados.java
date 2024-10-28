package vista;
import controlador.ControladorBotones;
import controlador.ControladorRegistroEmpleados;
import controlador.Validaciones;
import controlador.controladorGeneral;
import modelo.Empleados;
import modelo.ArchivosEmpleados;
import javax.swing.*;
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
import java.io.File;
import controlador.MenuController;
public class RegistroEmpleados extends JFrame {
    private JPanel MenuI;
    MenuController controller = new MenuController();
    private JButton iniciar, registrar, regresar, cerrar;
    File archivoEmpleados = new File("empleados.txt");
    Font labelFont, fieldFont;
    JPanel Encabezado;
    private JTextField nombre; 
    private JTextField papel;
    private JTextField usuario;
    private JPasswordField contra;

    public RegistroEmpleados() {
        setTitle("Registro de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        
        regresar = new JButton("Regresar");
        cerrar = new JButton("Cerrar sesión");
        
        JPanel pantalla = new JPanel(); 
        pantalla.setLayout(new GridLayout(10, 1, 5, 10));
        pantalla.setBackground(new Color(224, 233, 225));
        pantalla.setBorder(BorderFactory.createEmptyBorder(75, 20, 10, 20));
        
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        labelFont = new Font("Arial", Font.PLAIN, 16);
        fieldFont = new Font("Arial", Font.PLAIN, 16);
        
        JLabel titulo = new JLabel("Registro de Empleados", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);

        JLabel name = new JLabel("Nombre: ");
        name.setFont(labelFont);
        nombre = new JTextField();
        nombre.setFont(fieldFont);
        
        JLabel rol = new JLabel("Rol: ");
        rol.setFont(labelFont);
        papel = new JTextField();
        papel.setFont(fieldFont);

        JLabel user = new JLabel("Usuario: ");
        user.setFont(labelFont);
        usuario = new JTextField();
        usuario.setFont(fieldFont);

        JLabel password = new JLabel("Contraseña: ");
        password.setFont(labelFont);
        contra = new JPasswordField();
        contra.setFont(fieldFont);

        pantalla.add(name);
        pantalla.add(nombre);
        pantalla.add(rol);
        pantalla.add(papel);
        pantalla.add(user);
        pantalla.add(usuario);
        pantalla.add(password);
        pantalla.add(contra);
        
        registrar = new JButton("Registrar");
        registrar.setBackground(new Color(51, 51, 51));
        registrar.setForeground(new Color(255, 255, 255));
        registrar.setFont(labelFont);
        
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBackground(new Color(51, 51, 51));
        cancelar.setForeground(new Color(255, 255, 255));
        cancelar.setFont(labelFont);

        JPanel botones = new JPanel(); 
        botones.setLayout(new GridLayout(1, 2, 30, 10));  // Cambiado a 1, 2 para que ambos botones aparezcan
        botones.setBackground(new Color(224, 233, 225));
        botones.setBorder(BorderFactory.createEmptyBorder(5, 60, 20, 60));

        botones.add(registrar);
        botones.add(cancelar);
        
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(224, 233, 225));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 250, 10, 250));

        mainpanel.add(pantalla, BorderLayout.CENTER);
        mainpanel.add(botones, BorderLayout.SOUTH);
        
        Encabezado = new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(174, 238, 120));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(40, 380, 40, 75));

        Encabezado.add(titulo, BorderLayout.CENTER);

        JLabel menu = new JLabel("MENÚ");
        menu.setFont(labelTiFont);
        menu.setBorder(BorderFactory.createEmptyBorder(20, 65, 10, 20));

        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage(); 

        Image imagenRedimensionada = imagen.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenRedimensionada); 
        imagenLabel.setIcon(imagenIcon);

        JPanel Logopanel = new JPanel(); 
        Logopanel.setLayout(new BorderLayout());
        Logopanel.setBackground(new Color(174, 238, 120));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        Logopanel.add(imagenLabel);
        iniciar = new JButton("Iniciar");
        MenuI = new JPanel();
        MenuI.setLayout(new BorderLayout(0, 5));
        MenuI.setBackground(new Color(174, 238, 120));
        MenuI.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        MenuI.add(Logopanel, BorderLayout.CENTER);

        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(MenuI, BorderLayout.WEST);
        
        verificarExistenciaEmpleados();
        // Controlador se inicializa después de crear la vista
        ControladorRegistroEmpleados controlador = new ControladorRegistroEmpleados(this);
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(regresar, cerrar);
    }

    // Métodos para obtener los datos de los campos
    public String getNombre() {
        return nombre.getText();
    }

    public String getRol() {
        return papel.getText();
    }

    public String getUsuario() {
        return usuario.getText().trim();
    }

    public String getContrasena() {
        return new String(contra.getPassword()).trim(); // Cambiado para obtener la contraseña correctamente
    }

    // Método para limpiar los campos
    public void limpiarCampos() {
        nombre.setText("");
        papel.setText("");
        usuario.setText("");
        contra.setText("");
    }

    // Método para establecer ActionListeners
    public void setActionListeners(ActionListener registrarListener, ActionListener iniciarListener) {
        registrar.addActionListener(registrarListener);
        iniciar.addActionListener(iniciarListener); 
    }
    
    public void setActionListenersBotones(ActionListener regresarListener, ActionListener cerrarListener){
        regresar.addActionListener(regresarListener);
        cerrar.addActionListener(cerrarListener);
    }
    public void verificarExistenciaEmpleados(){
        if (archivoEmpleados.exists() && archivoEmpleados.length() > 0) {
            JPanel MenuBoton = new JPanel(); 
            MenuBoton.setLayout(new GridLayout(2, 1, 30, 10));
            MenuBoton.setBackground(new Color(174, 238, 120));
            MenuBoton.setBorder(BorderFactory.createEmptyBorder(120, 20, 20, 20));

            regresar = new JButton("Regresar");
            regresar.setBackground(new Color(51, 51, 51));
            regresar.setForeground(new Color(255, 255, 255));
            regresar.setFont(labelFont);
            regresar.setPreferredSize(new Dimension(50, 30));

            MenuBoton.add(regresar);
            MenuI.add(MenuBoton, BorderLayout.SOUTH);
            cerrar = new JButton("Cerrar sesión");
            cerrar.setBackground(new Color(255, 0, 0));
            cerrar.setForeground(new Color(255, 255, 255));
            cerrar.setPreferredSize(new Dimension(200, 40));
            cerrar.setFont(labelFont);
            Encabezado.add(cerrar, BorderLayout.EAST);
        }else{
            iniciar = new JButton("Iniciar sesión");
            iniciar.setBackground(new Color(255, 0, 0));
            iniciar.setForeground(new Color(255, 255, 255));
            iniciar.setPreferredSize(new Dimension(200, 40));
            iniciar.setFont(labelFont);
            Encabezado.add(iniciar, BorderLayout.EAST);
        }
    }
}
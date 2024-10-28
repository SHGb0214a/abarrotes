package vista;
import controlador.ControladorBotones;
import controlador.MenuController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ArchivosClientes;
import modelo.ArchivosEmpleados;
import modelo.Empleados;
import modelo.Usuario;

public class ModificarUsuario extends JFrame {
    private JTextField usuario, nombre, contra, papel;
    private JLabel name, user, password, rol;
    private JButton ingresar, modificar, cerrar,Inicio;
    private JPanel pantalla;
    private String tipoUsuario;
    MenuController controller = new MenuController();
    public ModificarUsuario() {
        setTitle("Modificar Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        
        pantalla = new JPanel(); 
        pantalla.setLayout(new GridLayout(10, 1, 5, 10));
        pantalla.setBackground(new Color(255, 238, 227));
        pantalla.setBorder(BorderFactory.createEmptyBorder(80, 20, 5, 20));
 
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font sub = new Font("Arial", Font.ITALIC, 22);
        Font labelFont = new Font("Arial", Font.PLAIN, 25);
        Font fieldFont = new Font("Arial", Font.PLAIN, 25);
        
        JLabel titulo = new JLabel("Modificar Usuario", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);
        
        JPanel subtituloPanel = new JPanel(); 
        subtituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel subtitulo = new JLabel("Ingrese los datos");
        subtitulo.setFont(sub);
        subtituloPanel.add(subtitulo);
        subtituloPanel.setBackground(new Color(255, 238, 227));
        pantalla.add(subtituloPanel);
        
        name = new JLabel("Nombre: ");
        name.setFont(labelFont);
        name.setVisible(false);
        nombre = new JTextField();
        nombre.setFont(fieldFont);
        nombre.setVisible(false);
        
        user = new JLabel("Usuario: ");
        user.setFont(labelFont);
        usuario = new JTextField();
        usuario.setFont(fieldFont);
        
        password = new JLabel("Contraseña: ");
        password.setFont(labelFont);
        contra = new JPasswordField();
        contra.setFont(fieldFont);
        
        rol = new JLabel("Rol: ");
        rol.setFont(labelFont);
        rol.setVisible(false);
        papel = new JTextField();
        papel.setFont(fieldFont);
        papel.setVisible(false);
        
        ingresar = new JButton("Ingresar");
        ingresar.setFont(labelFont);
        ingresar.setBackground(new Color(51, 51, 51));
        ingresar.setForeground(new Color(255, 255, 255));
        ingresar.addActionListener(new VerificarActionListener());
        
        pantalla.add(user);
        pantalla.add(usuario);
        pantalla.add(password);
        pantalla.add(contra);
        pantalla.add(ingresar);
        pantalla.add(name);
        pantalla.add(nombre);
        pantalla.add(rol);
        pantalla.add(papel);

        modificar = new JButton("Modificar");
        modificar.setBackground(new Color(51, 51, 51));
        modificar.setForeground(new Color(255, 255, 255));
        modificar.setFont(labelFont);
        modificar.setPreferredSize(new Dimension(100, 40));
        modificar.addActionListener(new modificarActionListener());

        JPanel botones = new JPanel(); 
        botones.setLayout(new GridLayout(1, 1, 30, 10));
        botones.setBackground(new Color(255, 238, 227));
        botones.setBorder(BorderFactory.createEmptyBorder(20, 300, 110, 300));

        botones.add(modificar);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(255, 238, 227));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 250, 10, 250));

        mainpanel.add(pantalla, BorderLayout.CENTER);
        mainpanel.add(botones, BorderLayout.SOUTH);

        cerrar = new JButton("Cerrar sesión");
        cerrar.setBackground(new Color(255, 0, 0));
        cerrar.setForeground(new Color(255, 255, 255));
        cerrar.setPreferredSize(new Dimension(200, 40));
        cerrar.setFont(labelFont);

        JPanel Encabezado= new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(242, 181, 139));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(40, 380, 40, 75));

        Encabezado.add(titulo, BorderLayout.CENTER);
        Encabezado.add(cerrar, BorderLayout.EAST);

        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage(); 

        Image imagenRedimensionada = imagen.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenRedimensionada); 
        imagenLabel.setIcon(imagenIcon);

        JPanel Logopanel = new JPanel(); 
        Logopanel.setLayout(new BorderLayout());
        Logopanel.setBackground(new Color(242, 181, 139));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));

        Logopanel.add(imagenLabel);

        //Panel de los botones del menu
        JPanel MenuBoton = new JPanel(); 
        MenuBoton.setLayout(new GridLayout(2, 1, 30, 10));
        MenuBoton.setBackground(new Color(242, 181, 139));
        MenuBoton.setBorder(BorderFactory.createEmptyBorder(110, 20, 20, 20));

        Inicio = new JButton("Regresar");
        Inicio.setBackground(new Color(51, 51, 51));
        Inicio.setForeground(new Color(255, 255, 255));
        Inicio.setFont(labelFont);
        Inicio.setPreferredSize(new Dimension(200, 40));

        MenuBoton.add(Inicio);

        JPanel MenuI = new JPanel();
        MenuI.setLayout(new BorderLayout(0, 5));
        MenuI.setBackground(new Color(242, 181, 139));
        MenuI.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        MenuI.add(MenuBoton, BorderLayout.SOUTH);
        MenuI.add(Logopanel, BorderLayout.CENTER);
        
        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(MenuI, BorderLayout.WEST);
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(Inicio, cerrar);
    }
    private class VerificarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuarioIngresado = usuario.getText();
            String contrasenaIngresada = contra.getText();
            ArchivosEmpleados archivosEmpleados = new ArchivosEmpleados("empleados.txt");
            ArchivosClientes archivosClientes = new ArchivosClientes("clientes.txt");
            // Verificar si es empleado o cliente
            if (archivosEmpleados.validarEmpleado(usuarioIngresado, contrasenaIngresada)) {
                JOptionPane.showMessageDialog(null, "Empleado verificado.");
                tipoUsuario = "empleado";
                name.setVisible(true);
                nombre.setVisible(true);
                rol.setVisible(true);
                papel.setVisible(true);
                modificar.setVisible(true);
                ingresar.setVisible(false);

                pantalla.revalidate(); 
                pantalla.repaint();
            } else if (archivosClientes.validarCliente(usuarioIngresado, contrasenaIngresada)) {
                JOptionPane.showMessageDialog(null, "Cliente verificado.");
                tipoUsuario = "cliente";
                name.setVisible(true);
                nombre.setVisible(true);
                modificar.setVisible(true);
                pantalla.revalidate(); 
                pantalla.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class modificarActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("empleado".equals(tipoUsuario)) {
                String nombres = nombre.getText();
                String rols = papel.getText();
                String usuarios = usuario.getText();
                String contrasenas = contra.getText();
                ArchivosEmpleados archivosEmpleados = new ArchivosEmpleados("empleados.txt");
                if(nombres.isEmpty() || rols.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Empleados empleadoModificado = new Empleados(nombres, rols, usuarios, contrasenas);
                if (archivosEmpleados.modificarEmpleado(empleadoModificado)) {
                    JOptionPane.showMessageDialog(null, "Cliente modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    reseteo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el Empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if ("cliente".equals(tipoUsuario)) {
                String nombres = nombre.getText();
                String usuarios = usuario.getText();
                String contrasenas = contra.getText();
                ArchivosClientes archivosClientes = new ArchivosClientes("clientes.txt");
                if(nombres.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por favor, complete el campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Usuario usuarioModificado = new Usuario(nombres, usuarios, contrasenas);
                if (archivosClientes.modificarCliente(usuarioModificado)) {
                    JOptionPane.showMessageDialog(null, "Cliente modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    reseteo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de usuario no definido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    private void reseteo(){
        usuario.setText("");
        contra.setText("");
        name.setVisible(false);
                nombre.setVisible(false);
                rol.setVisible(false);
                papel.setVisible(false);
                modificar.setVisible(false);
    }
    
    public void setActionListenersBotones(ActionListener regresarListener, ActionListener cerrarListener){
        Inicio.addActionListener(regresarListener);
        cerrar.addActionListener(cerrarListener);
    }
}
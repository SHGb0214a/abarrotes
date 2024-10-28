package vista;

import controlador.controladorLogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginVista extends JFrame {
    private final JTextField correoField;
    private final JPasswordField contraseniaField;
    private final JButton loginButton;

    public LoginVista() {
        // Configuración de la ventana principal
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setLayout(new BorderLayout());

        // Panel para el logo
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(136, 197, 127));
        panelLogo.setBorder(BorderFactory.createEmptyBorder(150, 150, 0, 150));
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        JLabel logoLabel = new JLabel(logoIcon);
        panelLogo.add(logoLabel);

        // Panel de contenido principal (bienvenida, campos y botón)
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.setBackground(new Color(136, 197, 127));

        // Panel para el mensaje de bienvenida
        JPanel panelBienvenida = new JPanel();
        panelBienvenida.setBackground(new Color(136, 197, 127));
        JLabel titulo = new JLabel("Bienvenid@ a GROCERYNOOK");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel subtitulo = new JLabel("Por favor, Ingresa con correo y contraseña ya registrados.");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));

        panelBienvenida.setBorder(BorderFactory.createEmptyBorder(130, 0, 25, 50));
        panelBienvenida.add(titulo);
        panelBienvenida.add(subtitulo);

        // Panel para los campos de entrada
        JPanel panelCampos = new JPanel();
        panelCampos.setBackground(new Color(136, 197, 127));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(100, 180, 100, 180));
        panelCampos.setLayout(new GridLayout(2, 1, 0, 20)); // 2 filas y 1 columna

        // Subpanel para el campo de correo
        JPanel panelCorreo = new JPanel(new BorderLayout());
        panelCorreo.setBackground(new Color(136, 197, 127));
        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        correoField = new JTextField();
        correoField.setPreferredSize(new Dimension(300, 40));
        panelCorreo.add(correoLabel, BorderLayout.NORTH);
        panelCorreo.add(correoField, BorderLayout.SOUTH);

        // Subpanel para el campo de contraseña
        JPanel panelContrasenia = new JPanel(new BorderLayout());
        panelContrasenia.setBackground(new Color(136, 197, 127));
        JLabel contraseniaLabel = new JLabel("Contraseña:");
        contraseniaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        contraseniaField = new JPasswordField();
        contraseniaField.setPreferredSize(new Dimension(300, 40));
        panelContrasenia.add(contraseniaLabel, BorderLayout.NORTH);
        panelContrasenia.add(contraseniaField, BorderLayout.SOUTH);

        // Agregar los subpaneles al panel principal de campos
        panelCampos.add(panelCorreo);
        panelCampos.add(panelContrasenia);

        // Panel para el botón de login
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(136, 197, 127));
        loginButton = new JButton("Iniciar Sesión");
        loginButton.setPreferredSize(new Dimension(200, 50));
        loginButton.setBackground(new Color(0, 0, 0));
        loginButton.setForeground(Color.WHITE);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, 0, 200, 0));
        panelBoton.add(loginButton);

        // Añadir subpaneles al panel de contenido
        panelContenido.add(panelBienvenida, BorderLayout.NORTH);
        panelContenido.add(panelCampos, BorderLayout.CENTER);
        panelContenido.add(panelBoton, BorderLayout.SOUTH);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelLogo, BorderLayout.WEST);
        panelPrincipal.add(panelContenido, BorderLayout.CENTER);

        add(panelPrincipal);

        setVisible(true);
        controladorLogin controlador = new controladorLogin(this);
        
    }

    public String getCorreo() {
        return correoField.getText();
    }

    public String getContrasenia() {
        return new String(contraseniaField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }
    
    public void setActionListeners(ActionListener loginListener) {
        loginButton.addActionListener(loginListener); 
    }
    public void limpiarCampos() {
        correoField.setText("");
        contraseniaField.setText("");
    }
}

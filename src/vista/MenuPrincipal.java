package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import controlador.MenuController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {
    private MenuController controller;

    public MenuPrincipal(MenuController controller) {
        this.controller = controller;

        // Configuración de la ventana
        setTitle("Menú principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        // Fuentes y diseño del encabezado
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font labelFontSecciones = new Font("Arial", Font.PLAIN, 20);
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(new Color(116, 136, 201));
        encabezado.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Configurar logo
        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagenLabel.setIcon(new ImageIcon(imagenRedimensionada));
        encabezado.add(imagenLabel, BorderLayout.WEST);

        // Título
        JLabel titulo = new JLabel("Menú principal", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);
        encabezado.add(titulo, BorderLayout.CENTER);

        // Panel botón cerrar sesión
        JPanel panelCerrar = new JPanel();
        panelCerrar.setBackground(new Color(116, 136, 201));
        panelCerrar.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        // Botón cerrar sesión
        JButton cerrarButton = new JButton("Cerrar sesión");
        cerrarButton.setBackground(new Color(255, 0, 0));
        cerrarButton.setForeground(Color.WHITE);
        cerrarButton.setPreferredSize(new Dimension(200, 40));
        cerrarButton.setFont(labelFont);
        
        // Botón al panel de cierre
        panelCerrar.add(cerrarButton);
        encabezado.add(panelCerrar, BorderLayout.EAST);

        add(encabezado, BorderLayout.NORTH);

        // Panel general
        JPanel panelGeneral = new JPanel(new BorderLayout());
        panelGeneral.setBorder(BorderFactory.createEmptyBorder(100, 150, 100, 150));
        JPanel panelContenido = new JPanel(new GridLayout(2, 3, 70, 70));

        // crear cada seccion y enviar a PanelSeccionFactory
        panelContenido.add(PanelSeccionFactory.crearPanelSeccion("Generar compra", imagenRedimensionada, labelFontSecciones, controller, this));
        panelContenido.add(PanelSeccionFactory.crearPanelSeccion("Inventario", imagenRedimensionada, labelFontSecciones, controller, this));
        panelContenido.add(PanelSeccionFactory.crearPanelSeccion("Empleados", imagenRedimensionada, labelFontSecciones, controller, this));
        panelContenido.add(PanelSeccionFactory.crearPanelSeccion("Reportes", imagenRedimensionada, labelFontSecciones, controller, this));
        panelContenido.add(PanelSeccionFactory.crearPanelSeccion("Provedor", imagenRedimensionada, labelFontSecciones, controller,this));
        panelContenido.add(PanelSeccionFactory.crearPanelSeccion("Usuarios", imagenRedimensionada, labelFontSecciones, controller,this));

        panelGeneral.add(panelContenido, BorderLayout.CENTER);
        add(panelGeneral, BorderLayout.CENTER);
        
    }

    public static void main(String[] args) {
        MenuController controller = new MenuController();
        new MenuPrincipal(controller).setVisible(true);
    }

    public MenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
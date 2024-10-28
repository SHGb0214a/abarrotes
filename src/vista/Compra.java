package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Compra extends JFrame{
    public Compra(){
    //Ajustes de la ventana
        setTitle("Compra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        //Panel del vista
        JPanel pantalla = new JPanel(); 
        pantalla.setLayout(new BorderLayout(10, 10));
        pantalla.setBackground(new Color(192, 237, 190));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 30));
 
        //Fuentes para etiquetas y cuadros
        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        
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

        //Panel principal del formulario)
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(192, 237, 190));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        mainpanel.add(pantalla, BorderLayout.NORTH);
        mainpanel.add(tabla, BorderLayout.CENTER);

        //Boton de cerrar sesión
        JButton cerrarButton = new JButton("Cerrar sesión");
        cerrarButton.setBackground(new Color(255, 0, 0));
        cerrarButton.setForeground(new Color(255, 255, 255));
        cerrarButton.setPreferredSize(new Dimension(200, 40));
        cerrarButton.setFont(labelFont);
        
        //Panel botones cerrar sesion
        JPanel botone = new JPanel(); 
        botone.setLayout(new GridLayout(1, 1, 50, 10));
        botone.setBackground(new Color(103, 209,131));
        botone.setBorder(BorderFactory.createEmptyBorder(55, 30, 55, 0));
        
        botone.add(cerrarButton);
        
        //Panel del encabezado 
        JPanel Encabezado= new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(103, 209, 131));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 40));
        
        //Agregar el logo
        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage(); 

        //Redimensionar el Logo y colocarlo en la etiqueta
        Image imagenRedimensionada = imagen.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenRedimensionada); 
        imagenLabel.setIcon(imagenIcon);

        //Panel del Logo
        JPanel Logopanel = new JPanel(); 
        Logopanel.setLayout(new BorderLayout());
        Logopanel.setBackground(new Color(103, 209, 131));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //Añadir el logo a su panel
        Logopanel.add(imagenLabel);
           
        //Panel etiquetas encabezado
        JPanel cabe = new JPanel(); 
        cabe.setLayout(new GridLayout(2, 1, 50, 10));
        cabe.setBackground(new Color(103, 209, 131));
        cabe.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 30));
        
        //Etiquetas del encabezado 
        JLabel titulo = new JLabel("BIENVENIDO", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);
        
        JLabel intrs = new JLabel("Seleccione los productos que desea comprar",SwingConstants.CENTER);
        intrs.setFont(labelFont);
        
        cabe.add(titulo);
        cabe.add(intrs);
        
        
        //Añadir componentes del encabezado
        Encabezado.add(cabe, BorderLayout.CENTER);
        Encabezado.add(Logopanel, BorderLayout.WEST);
        Encabezado.add(botone, BorderLayout.EAST);
        
        //Panel Boton de compra
        JPanel comprar = new JPanel(); 
        comprar.setLayout(new BorderLayout());
        comprar.setBackground(new Color(192, 237, 190));
        comprar.setBorder(BorderFactory.createEmptyBorder(5, 520, 5, 520));
        
        //Boton de compra
        JButton crea = new JButton("Realizar Compra");
        crea.setBackground(new Color(51, 51, 51));
        crea.setForeground(new Color(255, 255, 255));
        crea.setPreferredSize(new Dimension(200, 40));
        crea.setFont(labelFont);
        
        comprar.add(crea, BorderLayout.CENTER);
        
        //Se añaden los tres paneles principales a la ventana
        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(comprar, BorderLayout.SOUTH);
    }
}

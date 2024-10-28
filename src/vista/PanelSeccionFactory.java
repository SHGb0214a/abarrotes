package vista;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controlador.MenuController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelSeccionFactory {

    public static JPanel crearPanelSeccion(String titulo, Image imagen, Font fuenteTexto, MenuController controller, MenuPrincipal menu) {
        JPanel panelSeccion = new JPanel(new BorderLayout());
        panelSeccion.setBackground(new Color(116, 136, 201));
        panelSeccion.setPreferredSize(new Dimension(150, 150));
        panelSeccion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        // Imagen y texto
        JLabel iconoLabel = new JLabel(new ImageIcon(imagen), SwingConstants.CENTER);
        JLabel textoLabel = new JLabel(titulo, SwingConstants.CENTER);
        textoLabel.setFont(fuenteTexto);
        textoLabel.setForeground(Color.WHITE);

        // Mouse listener para panel funcione como botón
        panelSeccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.abrirVentana(titulo, menu); // llamada del controlador
            }
        });

        panelSeccion.add(iconoLabel, BorderLayout.CENTER);
        panelSeccion.add(textoLabel, BorderLayout.SOUTH);

        return panelSeccion;
    }
}

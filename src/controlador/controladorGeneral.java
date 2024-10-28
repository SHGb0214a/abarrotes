
package controlador;

import javax.swing.JFrame;
import vista.MenuPrincipal;
import controlador.MenuController;
public class controladorGeneral {
    MenuController controller = new MenuController();
    public void regresar(JFrame ventanaActual) {
        ventanaActual.dispose();
        MenuPrincipal menuPrincipal = new MenuPrincipal(controller);
        menuPrincipal.setVisible(true);
    }
}

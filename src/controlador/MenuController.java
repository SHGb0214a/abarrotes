package controlador;

import controlador.Rutas;
import vista.MenuPrincipal;

public class MenuController {
    public void abrirVentana(String nombreVentana, MenuPrincipal menu) {
        Rutas.abrirVentana(nombreVentana, menu);
    }
}


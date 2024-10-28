package abarrotes;

import vista.FormsUsuariosVista;
import vista.CrearProducto;
import vista.LoginVista;
import vista.ModificarProducto;
import vista.RegistroEmpleados;
import vista.MenuPrincipal;
import controlador.MenuController;
import java.io.File;
import vista.ModificarUsuario;
import vista.Inventario;
import vista.UsuariosInterfaz;
import vista.Compra;

public class abarrotes {
    public static void main(String[] args) {
        File archivosEmpleados = new File("empleados.txt");

        if (archivosEmpleados.exists() && archivosEmpleados.length() > 0) {
            LoginVista login = new LoginVista();
            login.setVisible(true);
        } else {
            RegistroEmpleados empleados = new RegistroEmpleados();
            empleados.setVisible(true);
        }
        
        //CrearProducto prod = new CrearProducto();
        //prod.setVisible(true);
        ModificarProducto mod= new ModificarProducto();
        mod.setVisible(true);
    }
}
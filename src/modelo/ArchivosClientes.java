package modelo;
//IMPORTACION PARA USO DE ARCHIVOS
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//IMPORTACION DEL MODELO DE EMPLEADOS
public class ArchivosClientes{
    private File archivo;

    //CONSTRUCTOR PARA LOS ARCHIVOS
    public ArchivosClientes(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }
    
    //GUARDAR EMPLEADO
    public void guardarCliente(Usuario cliente) { //USA EL MODELO DE EMPLEADOS PARA LOS DATOS
        boolean archivoExiste = archivo.exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) { //Modo para escribir en el archivo
            //y que se escriba al final de este (sin sobreescribir si hay algo escrito)
           
            if (!archivoExiste) { //Si el archivo es nuevo, se escribe la forma en la que se va a dividir los archivos
                writer.write("Nombre,Usuario,Contraseña");
                writer.newLine(); //Salto de linea
            }
            
            //Escritura de datos a base de CSV (separado por comas)
            writer.write(cliente.getNombre() + "," + cliente.getUsuario() + "," + cliente.getContrasena());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//Esta funcion es llamada en REGISTROEMPLEADOS una vez que se aceptan los empleados
    
    public boolean buscarCliente(String aBuscar) { 
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) { //EN MODO LECTURA
            String linea;
            while ((linea = lector.readLine()) != null) { //SE LEEN TODAS LAS LINEAS
                String[] datos = linea.split(","); //SE DIVIDE ENTRE CADA COMA (DIVISION DE DATOS) Y SE GUARDAN EN UN ARREGLO
                if (datos.length >= 3 && (datos[0].equalsIgnoreCase(aBuscar) || datos[1].equalsIgnoreCase(aBuscar))) { //>=4 CHECAR SI ESTAN TODOS LOS DATOS
                    //luego se checa si ya sea el dato del nombre [0] o el de usuario [1]coincide con lo que se busca
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }//SI OCURRE ALGUN ERROR 
        return false; 
    }//FUNCION USADA EN USUARIOSINTERFAZ (PARA LAS TABLAS)
    
    public boolean validarCliente(String usuarioIngresado, String contraseniaIngresada) { //RECIBE LOS VALORES A COMPRAR
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) { //ABRE EL ARCHIVO EN MODO LECTURA
            String linea;
            while ((linea = lector.readLine()) != null) { //VA LINEA POR LINEA
                String[] datos = linea.split(",");  //DIVIDE LOS DATOS POR COMAS
                String usuario = datos[2].trim(); //GUARDA EL TERCER DATO (EL USUARIO)
                String contrasenia = datos[3].trim(); //GUARDA EL CUARTO DATO (LA CONTRASEÑA)

                if (usuario.equals(usuarioIngresado) && contrasenia.equals(contraseniaIngresada)) { //COMPARA QUE AMBOS SEAN IGUALES    
                    return true; //DEVUELVE VERDADERO
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); //POR SI HAY UN ERROR, IMPRIME EN LA CONSOLA
        }
        return false; 
    }//USADA PARA EL LOGIN ?
    
    
    public List<Usuario> leerClientes() { //SE CREA UNA LIST
        List<Usuario> clientes = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            lector.readLine(); //SE SALTA LA PRIMERA LINEA (ENCABEZADO)
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(","); 
                if (datos.length >= 3) {  //ALMACENA TODOS LOS DATOS
                    String nombre = datos[0];
                    String usuario = datos[1];
                    String contrasena = datos[2];
                    clientes.add(new Usuario(nombre, usuario, contrasena)); 
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }//FUNCION USADA PARA LAS TABLAS
    
    public List<Usuario> buscarClientePorNombreUsuario(String buscarTexto) {
        List<Usuario> clientesEncontrados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Skip header line
            reader.readLine();
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); 
                if (datos.length >= 3) {
                    String nombre = datos[0];
                    String rol = datos[1];
                    String usuario = datos[2];
                    if (nombre.equalsIgnoreCase(buscarTexto) || usuario.equalsIgnoreCase(buscarTexto)) {
                        clientesEncontrados.add(new Usuario(nombre, usuario, datos[2])); 
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return clientesEncontrados;
    } //FUNCION USADA PARA LAS TABLAS
    
    public boolean modificarCliente(Usuario clienteModificado) {
        List<Usuario> clientes = leerClientes(); 
        boolean modificado = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().equalsIgnoreCase(clienteModificado.getUsuario())) {
                clientes.set(i, clienteModificado); 
                modificado = true; 
                break;
            }
        }

        if (modificado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("Nombre,Usuario,Contraseña");
                writer.newLine();
                for (Usuario cliente : clientes) {
                    writer.write(cliente.getNombre() + "," + cliente.getUsuario() + "," + cliente.getContrasena());
                    writer.newLine();
                }
                return true; 
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        }
        return false;
    }
}

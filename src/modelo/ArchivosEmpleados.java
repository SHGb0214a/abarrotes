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
public class ArchivosEmpleados {
    private File archivo;

    //CONSTRUCTOR PARA LOS ARCHIVOS
    public ArchivosEmpleados(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }
    
    //GUARDAR EMPLEADO
    public void guardarEmpleado(Empleados empleado) { //USA EL MODELO DE EMPLEADOS PARA LOS DATOS
        boolean archivoExiste = archivo.exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) { //Modo para escribir en el archivo
            //y que se escriba al final de este (sin sobreescribir si hay algo escrito)
           
            if (!archivoExiste) { //Si el archivo es nuevo, se escribe la forma en la que se va a dividir los archivos
                writer.write("Nombre,Rol,Usuario,Contraseña");
                writer.newLine(); //Salto de linea
            }
            
            //Escritura de datos a base de CSV (separado por comas)
            writer.write(empleado.getNombre() + "," + empleado.getRol() + "," + empleado.getUsuario() + "," + empleado.getContrasena());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//Esta funcion es llamada en REGISTROEMPLEADOS una vez que se aceptan los empleados
    
    public boolean buscarEmpleado(String aBuscar) { 
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) { //EN MODO LECTURA
            String linea;
            while ((linea = lector.readLine()) != null) { //SE LEEN TODAS LAS LINEAS
                String[] datos = linea.split(","); //SE DIVIDE ENTRE CADA COMA (DIVISION DE DATOS) Y SE GUARDAN EN UN ARREGLO
                if (datos.length >= 4 && (datos[0].equalsIgnoreCase(aBuscar) || datos[2].equalsIgnoreCase(aBuscar))) { //>=4 CHECAR SI ESTAN TODOS LOS DATOS
                    //luego se checa si ya sea el dato del nombre [0] o el de usuario [2]coincide con lo que se busca
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }//SI OCURRE ALGUN ERROR 
        return false; 
    }//FUNCION USADA EN USUARIOSINTERFAZ (PARA LAS TABLAS)
    
    public boolean validarEmpleado(String usuarioIngresado, String contraseniaIngresada) { //RECIBE LOS VALORES A COMPRAR
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
    
    
    public List<Empleados> leerEmpleados() { //SE CREA UNA LIST
        List<Empleados> empleados = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            lector.readLine(); //SE SALTA LA PRIMERA LINEA (ENCABEZADO)
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(","); 
                if (datos.length >= 4) {  //ALMACENA TODOS LOS DATOS
                    String nombre = datos[0];
                    String rol = datos[1];
                    String usuario = datos[2];
                    String contrasena = datos[3];
                    empleados.add(new Empleados(nombre, rol, usuario, contrasena)); 
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return empleados;
    }//FUNCION USADA PARA LAS TABLAS
    
    public List<Empleados> buscarEmpleadosPorNombreUsuario(String buscarTexto) {
        List<Empleados> empleadosEncontrados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Skip header line
            reader.readLine();
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); 
                if (datos.length >= 4) {
                    String nombre = datos[0];
                    String rol = datos[1];
                    String usuario = datos[2];
                    if (nombre.equalsIgnoreCase(buscarTexto) || usuario.equalsIgnoreCase(buscarTexto)) {
                        empleadosEncontrados.add(new Empleados(nombre, rol, usuario, datos[3])); 
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return empleadosEncontrados;
    } //FUNCION USADA PARA LAS TABLAS

    public boolean modificarEmpleado(Empleados empleadoModificado) {
        List<Empleados> empleados = leerEmpleados(); 
        boolean modificado = false;

        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getUsuario().equalsIgnoreCase(empleadoModificado.getUsuario())) {
                empleados.set(i, empleadoModificado); 
                modificado = true; 
                break;
            }
        }

        if (modificado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("Nombre,Rol,Usuario,Contraseña");
                writer.newLine();
                for (Empleados empleado : empleados) {
                    writer.write(empleado.getNombre() + "," + empleado.getRol() + "," + empleado.getUsuario() + "," +
                                 empleado.getContrasena());
                    writer.newLine();
                }
                return true; 
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al modificar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        }
        return false;
    } 
}

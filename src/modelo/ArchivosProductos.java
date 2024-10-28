package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ArchivosProductos {
    private File archivo;

    // Constructor para inicializar el archivo
    public ArchivosProductos(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }
    
    // Método para guardar producto
    public void guardarProducto(Producto producto) {
        boolean archivoExiste = archivo.exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            if (!archivoExiste) {
                writer.write("Codigo,Nombre,Descripcion,Precio,Cantidad");
                writer.newLine();
            }
            writer.write(producto.getCodigo() + "," + producto.getNombre() + "," + producto.getDescripcion() + "," + 
                         producto.getPrecio() + "," + producto.getCantidad());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método para buscar un producto por código o nombre
    public List<Producto> buscarProducto(String criterio) { 
        List<Producto> productosEncontrados = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5 && (datos[0].equalsIgnoreCase(criterio) || datos[1].equalsIgnoreCase(criterio))) {
                    // Assuming you have a constructor in Producto that takes these arguments
                    Producto producto = new Producto(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]));
                    productosEncontrados.add(producto);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productosEncontrados; 
    }
    
    // Método para leer todos los productos
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            lector.readLine(); // Saltar encabezado
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    String codigo = datos[0];
                    String nombre = datos[1];
                    String descripcion = datos[2];
                    double precio = Double.parseDouble(datos[3]);
                    int cantidad = Integer.parseInt(datos[4]);
                    productos.add(new Producto(codigo, nombre, descripcion, precio, cantidad));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productos;
    }
    
    // Método para buscar productos por nombre o código
    public List<Producto> buscarProductosPorNombreOCodigo(String buscarTexto) {
        List<Producto> productosEncontrados = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            lector.readLine(); // Saltar encabezado
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    String codigo = datos[0];
                    String nombre = datos[1];
                    if (codigo.equalsIgnoreCase(buscarTexto) || nombre.equalsIgnoreCase(buscarTexto)) {
                        double precio = Double.parseDouble(datos[3]);
                        int cantidad = Integer.parseInt(datos[4]);
                        productosEncontrados.add(new Producto(codigo, nombre, datos[2], precio, cantidad));
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productosEncontrados;
    }
    public boolean modificarProducto(Producto productoModificado) {
        List<Producto> productos = leerProductos(); 
        boolean modificado = false;

        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equalsIgnoreCase(productoModificado.getCodigo())) {
                productos.set(i, productoModificado); 
                modificado = true; 
                break;
            }
        }

        if (modificado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write("Codigo,Nombre,Descripcion,Precio,Cantidad");
                writer.newLine();
                for (Producto p : productos) {
                    writer.write(p.getCodigo() + "," + p.getNombre() + "," + p.getDescripcion() + "," +
                                 p.getPrecio() + "," + p.getCantidad());
                    writer.newLine();
                }
                return true; 
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al modificar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        }
        return false;
    }
    
    public boolean eliminarProducto(String criterio) {
        List<Producto> productos = leerProductos(); // Cambiar cargarProductos() a leerProductos()
        boolean eliminado = productos.removeIf(p -> p.getCodigo().equalsIgnoreCase(criterio) || p.getNombre().equalsIgnoreCase(criterio));

        if (eliminado) {
            guardarProductos(productos); // Guardar la lista actualizada
        }

        return eliminado;
    }

    // Método para guardar la lista completa de productos en el archivo
    private void guardarProductos(List<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("Codigo,Nombre,Descripcion,Precio,Cantidad");
            writer.newLine();
            for (Producto producto : productos) {
                writer.write(producto.getCodigo() + "," + producto.getNombre() + "," + producto.getDescripcion() + "," +
                             producto.getPrecio() + "," + producto.getCantidad());
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


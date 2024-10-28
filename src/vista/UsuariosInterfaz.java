package vista;

import controlador.ControladorBotones;
import controlador.MenuController;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Empleados;
import modelo.Usuario;
import modelo.ArchivosClientes;
import modelo.ArchivosEmpleados;

public class UsuariosInterfaz extends JFrame {
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTablaClientes;
    JScrollPane tablilla, tablillaClientes;
    JButton cerrarButton, Inicio;
    MenuController controller = new MenuController();
    public UsuariosInterfaz() {
        setTitle("Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        JPanel pantalla = new JPanel();
        pantalla.setLayout(new BorderLayout(10, 10));
        pantalla.setBackground(new Color(239, 231, 208));
        pantalla.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 30));

        Font labelTiFont = new Font("Arial", Font.BOLD, 30);
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        JLabel titulo = new JLabel("Usuarios", SwingConstants.CENTER);
        titulo.setFont(labelTiFont);

        JTextField buscar = new JTextField();
        buscar.setFont(fieldFont);
        
        JButton busca = new JButton("Buscar");
        busca.setBackground(new Color(51, 51, 51));
        busca.setForeground(new Color(255, 255, 255));
        busca.setPreferredSize(new Dimension(200, 40));
        busca.setFont(labelFont);
        
        String[] items = {"Usuario", "Empleado"};
        JComboBox<String> cambio = new JComboBox<>(items);
        cambio.setPreferredSize(new Dimension(150, 40));
        cambio.setFont(fieldFont);
        
        pantalla.add(buscar, BorderLayout.CENTER);
        pantalla.add(busca, BorderLayout.EAST);
        pantalla.add(cambio, BorderLayout.WEST);

        JPanel tabla = new JPanel();
        tabla.setLayout(new GridLayout(1, 1, 30, 10));
        tabla.setBackground(new Color(255, 255, 255));
        tabla.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        String[] columnas = {"Nombre", "Rol", "Usuario"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tablaEmpleados = new JTable(modeloTabla);
        tablilla = new JScrollPane(tablaEmpleados);
        
        
        String[] columnasClientes = {"Nombre", "Usuario"};
        modeloTablaClientes = new DefaultTableModel(columnasClientes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable tablaClientes = new JTable(modeloTablaClientes);
        tablillaClientes = new JScrollPane(tablaClientes);
        
        tabla.add(tablilla, BorderLayout.CENTER); 
        tabla.add(tablillaClientes, BorderLayout.CENTER);
        tablilla.setVisible(false);
        tablillaClientes.setVisible(false);
       
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 20));
        mainpanel.setBackground(new Color(239, 231, 208));
        mainpanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        mainpanel.add(pantalla, BorderLayout.NORTH);
        mainpanel.add(tabla, BorderLayout.CENTER);
        
        cerrarButton = new JButton("Cerrar sesión");
        cerrarButton.setBackground(new Color(255, 0, 0));
        cerrarButton.setForeground(new Color(255, 255, 255));
        cerrarButton.setPreferredSize(new Dimension(200, 40));
        cerrarButton.setFont(labelFont);

        JPanel botone = new JPanel();
        botone.setLayout(new GridLayout(1, 4, 50, 10));
        botone.setBackground(new Color(242, 164, 139));
        botone.setBorder(BorderFactory.createEmptyBorder(20, 90, 20, 30));

        JButton crea = new JButton("+Crear Usuario");
        crea.setBackground(new Color(51, 51, 51));
        crea.setForeground(new Color(255, 255, 255));
        crea.setPreferredSize(new Dimension(200, 40));
        crea.setFont(labelFont);
        
        JButton modifica = new JButton("Modificar Usuario");
        modifica.setBackground(new Color(51, 51, 51));
        modifica.setForeground(new Color(255, 255, 255));
        modifica.setPreferredSize(new Dimension(200, 40));
        modifica.setFont(labelFont);
        
        JButton borra = new JButton("Eliminar Usuario");
        borra.setBackground(new Color(51, 51, 51));
        borra.setForeground(new Color(255, 255, 255));
        borra.setPreferredSize(new Dimension(200, 40));
        borra.setFont(labelFont);
        
        botone.add(crea);
        botone.add(modifica);
        botone.add(borra);
        botone.add(cerrarButton);

        JPanel Encabezado = new JPanel();
        Encabezado.setLayout(new BorderLayout(0, 5));
        Encabezado.setBackground(new Color(242, 164, 139));
        Encabezado.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 40));

        Encabezado.add(titulo, BorderLayout.WEST);
        Encabezado.add(botone, BorderLayout.CENTER);

        JLabel imagenLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icons/BolsaLogo.png"));
        Image imagen = imageIcon.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imagenIcon = new ImageIcon(imagenRedimensionada);
        imagenLabel.setIcon(imagenIcon);

        JPanel Logopanel = new JPanel();
        Logopanel.setLayout(new BorderLayout());
        Logopanel.setBackground(new Color(242, 164, 139));
        Logopanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        Logopanel.add(imagenLabel);

        JPanel MenuBoton = new JPanel();
        MenuBoton.setLayout(new GridLayout(2, 1, 30, 10));
        MenuBoton.setBackground(new Color(242, 164, 139));
        MenuBoton.setBorder(BorderFactory.createEmptyBorder(120, 20, 20, 20));

        Inicio = new JButton("Regresar");
        Inicio.setBackground(new Color(51, 51, 51));
        Inicio.setForeground(new Color(255, 255, 255));
        Inicio.setFont(labelFont);
        Inicio.setPreferredSize(new Dimension(50, 40));

        MenuBoton.add(Inicio);

        JPanel MenuI = new JPanel();
        MenuI.setLayout(new BorderLayout(0, 5));
        MenuI.setBackground(new Color(242, 164, 139));
        MenuI.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        MenuI.add(MenuBoton, BorderLayout.SOUTH);
        MenuI.add(Logopanel, BorderLayout.CENTER);

        add(mainpanel, BorderLayout.CENTER);
        add(Encabezado, BorderLayout.NORTH);
        add(MenuI, BorderLayout.WEST);
        
        ControladorBotones controladorBotones = new ControladorBotones(this, controller);
        controladorBotones.setActionListenersBotones(Inicio, cerrarButton);
        
        // Action listeners
        busca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscarTexto = buscar.getText().trim();
                if (buscarTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de búsqueda no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (tablillaClientes.isVisible()) {
                    ArchivosClientes archivoClientes = new ArchivosClientes("clientes.txt");
                    List<Usuario> clientesEncontrados = archivoClientes.buscarClientePorNombreUsuario(buscarTexto);
                    if (clientesEncontrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el criterio: " + buscarTexto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        actualizarTablaClientes(clientesEncontrados);
                    }
                } else {
                    // Search in employees
                    ArchivosEmpleados archivoEmpleados = new ArchivosEmpleados("empleados.txt");
                    List<Empleados> empleadosEncontrados = archivoEmpleados.buscarEmpleadosPorNombreUsuario(buscarTexto);
                    if (empleadosEncontrados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con el criterio: " + buscarTexto, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        actualizarTabla(empleadosEncontrados);
                    }
                }
                }
        });
        
        cambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cambio.getSelectedItem().equals("Usuario")) {
                    mostrarClientes();
                } else {
                    mostrarEmpleados();
                }
            }
        });
        
        crea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                FormsUsuariosVista crear = new FormsUsuariosVista();
                crear.setVisible(true);
            }
        });
        modifica.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                ModificarUsuario modificar = new ModificarUsuario();
                modificar.setVisible(true);
            }
        });
        cargarClientes();
        cargarEmpleados();
    }

    private void cargarEmpleados() {
        ArchivosEmpleados archivoEmpleados = new ArchivosEmpleados("empleados.txt");
        List<Empleados> empleados = archivoEmpleados.leerEmpleados();
        actualizarTabla(empleados);
    }

    private void cargarClientes() {
        ArchivosClientes archivoClientes = new ArchivosClientes("clientes.txt");
        List<Usuario> clientes = archivoClientes.leerClientes();
        actualizarTablaClientes(clientes);
    }

    private void actualizarTabla(List<Empleados> empleados) {
        modeloTabla.setRowCount(0);
        for (Empleados empleado : empleados) {
            modeloTabla.addRow(new Object[]{empleado.getNombre(), empleado.getRol(), empleado.getUsuario()});
        }
    }

    private void actualizarTablaClientes(List<Usuario> clientes) {
        // Clear previous data
        modeloTablaClientes.setRowCount(0);
        for (Usuario cliente : clientes) {
            modeloTablaClientes.addRow(new Object[]{cliente.getNombre(), cliente.getUsuario()});
        }
    }

    private void mostrarEmpleados() {
        tablilla.setVisible(true);
        tablillaClientes.setVisible(false);
        cargarEmpleados(); 
    }

    private void mostrarClientes() {
        tablilla.setVisible(false);
        tablillaClientes.setVisible(true);
        cargarClientes(); 
    }
    public void setActionListenersBotones(ActionListener regresarListener, ActionListener cerrarListener){
        Inicio.addActionListener(regresarListener);
        cerrarButton.addActionListener(cerrarListener);
    }
}
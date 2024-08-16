package HLUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class HLEcuaFaunaForm extends JFrame {

    // Componentes de la interfaz
    private JTextField txtCedula, txtNombres;
    private JButton btnCrearHormiga, btnEliminar, btnGuardar, btnAlimentarGeno, btnAlimentarIngesta;
    private JComboBox<String> comboGenoAlimento, comboIngestaNativa;
    private JPanel panelHormigas;
    private Connection connection;

    public HLEcuaFaunaForm() {
        setTitle("EcuaFauna 2K24A");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Establecer la conexión con la base de datos
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../DataBase/HLEcuaFauna2K24A.sqlite");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Panel superior para los datos de cédula y nombres
        JPanel panelDatos = new JPanel(new GridLayout(2, 2));
        panelDatos.add(new JLabel("Cédula:"));
        txtCedula = new JTextField("1751071943");
        panelDatos.add(txtCedula);
        panelDatos.add(new JLabel("Nombres:"));
        txtNombres = new JTextField("Lizeth Hernandez");
        panelDatos.add(txtNombres);
        add(panelDatos, BorderLayout.NORTH);

        // Panel central para la creación y alimentación de hormigas
        JPanel panelCentral = new JPanel(new BorderLayout());

        // Panel para hormigas con una cuadrícula 3x3
        panelHormigas = new JPanel(new GridLayout(3, 3, 5, 5)); // 3x3 grid with gaps
        panelCentral.add(panelHormigas, BorderLayout.CENTER);

        // Botón para crear hormiga larva
        btnCrearHormiga = new JButton("Crear hormiga larva");
        btnCrearHormiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearHormigaLarva();
            }
        });
        panelCentral.add(btnCrearHormiga, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior para las acciones de alimentación y guardado
        JPanel panelAcciones = new JPanel(new GridLayout(3, 2, 5, 5)); // Grid con gaps

        comboGenoAlimento = new JComboBox<>(new String[]{"<GenoAlimento1>", "<GenoAlimento2>"});
        panelAcciones.add(comboGenoAlimento);
        btnAlimentarGeno = new JButton("Alimentar con GenoAlimento");
        panelAcciones.add(btnAlimentarGeno);

        comboIngestaNativa = new JComboBox<>(new String[]{"<IngestaNativa1>", "<IngestaNativa2>"});
        panelAcciones.add(comboIngestaNativa);
        btnAlimentarIngesta = new JButton("Alimentar con Ingesta Nativa");
        panelAcciones.add(btnAlimentarIngesta);

        // Botones Eliminar y Guardar
        btnEliminar = new JButton("Eliminar");
        btnGuardar = new JButton("Guardar");
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnGuardar);
        
        add(panelAcciones, BorderLayout.SOUTH);

        // Configuración final de la ventana
        setVisible(true);
    }

    // Método para crear una hormiga larva
    private void crearHormigaLarva() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de crear una Hormiga larva?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Selecciona aleatoriamente una provincia
                String sqlSelect = "SELECT IdCatalogo, Nombre FROM HLCatalogo WHERE IdCatalogoTipo = 3 ORDER BY RANDOM() LIMIT 1";
                PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
                ResultSet rs = psSelect.executeQuery();
                int idProvincia = rs.getInt("IdCatalogo");
                String nombreProvincia = rs.getString("Nombre");

                // Inserta la nueva hormiga en la base de datos
                String sqlInsert = "INSERT INTO HLHormiga (IdCatalogoRegion, IdCatalogoProvincia, IdCatalogoSexo, IdCatalogoIngestaNativa, IdCatalogoGenoAlimento, TipoHormiga) " +
                                   "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement psInsert = connection.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
                psInsert.setInt(1, new Random().nextInt(4) + 2); // Región aleatoria entre 2 y 5
                psInsert.setInt(2, idProvincia); // Provincia aleatoria
                psInsert.setInt(3, 32); // Sexo Asexual
                psInsert.setInt(4, 33); // Ingesta Nativa predeterminada
                psInsert.setInt(5, 39); // GenoAlimento predeterminado
                psInsert.setString(6, "Larva");

                psInsert.executeUpdate();

                // Obtener el ID de la hormiga recién creada
                ResultSet generatedKeys = psInsert.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idHormiga = generatedKeys.getInt(1);

                    // Muestra el registro en la cuadrícula
                    JLabel labelHormiga = new JLabel("Nr(" + idHormiga + "), Hormiga(Larva), Ubicación(" + nombreProvincia + "), Sexo(Asexual), Estado(A)");
                    panelHormigas.add(labelHormiga);
                    panelHormigas.revalidate();
                    panelHormigas.repaint();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al crear la hormiga", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HLEcuaFaunaForm());
    }
    
}

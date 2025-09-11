package Vista;

import Modelo.Personal;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class AdminVista extends JFrame {

    private JPanel JPanelPrincipal;
    private JTabbedPane PestannaGlobal;
    private JPanel PanelMedico;
    private JPanel PanelFarmaceutico;
    private JPanel Pacientes;
    private JPanel Meidcamentos;
    private JPanel PanelDashboard;
    private JPanel Datos;
    private JLabel Desde;
    private JComboBox cmbDesdeAnnio;
    private JComboBox cmbDesdeMes;
    private JLabel Hasta;
    private JComboBox cmbHastaAnio;
    private JComboBox cmbHastaMes;
    private JComboBox cmbMedicamento;
    private JButton btnGenerarRango;
    private JButton btnLimpiar;
    private JPanel Medicamentos;
    private JButton medicamentosButton;
    private JPanel Recetas;
    private JButton recetasButton;
    private JButton btnAgregarMesButton;
    private JButton btnQuitarMesButton;
    private JTable tblDatos;
    private JPanel FormatoPanelMedico;
    private JButton BotonLimpiar;
    private JButton BotonGuardar;
    private JTextField CampoNombre;
    private JButton BotonBorrar;
    private JTable TablaListado;
    private JTextField CampoID;
    private JTextField textField3;
    private JTextField CampoNombre2;
    private JButton BuscarBoton;
    private JButton BotonReporte;
    private JLabel TextoMedico;
    private JLabel TextoNombre;
    private JLabel TextoBusqueda;
    private JLabel TextoListado;
    private JScrollPane ScrollTabla;
    private JLabel TextoId;
    private JLabel TextoEspecialidad;
    private JLabel TextoNombre2;
    private JLabel fotoHospital;
    private JPanel PanelAcercaDe;
    private DefaultTableModel modeloMedicos;

    public AdminVista(Personal u) {
        setContentPane(JPanelPrincipal);
        setTitle("Login");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(1000, 900);// tamanno de la ventana
        setLocationRelativeTo(null);
        inicializarTablaMedicos();
    }

    private void inicializarTablaMedicos() {
        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Especialidad"};

        // Modelo vacío
        modeloMedicos = new DefaultTableModel(null, columnas);

        TablaListado.setModel(modeloMedicos);
        JTableHeader header = TablaListado.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
    }

    //  Getters para que la controladora pueda acceder
    public JTable getTablaMedicos() {
        return TablaListado;
    }

    public DefaultTableModel getModeloMedicos() {
        return modeloMedicos;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminVista ventana = new AdminVista(null);
            ventana.setVisible(true);
        });
    }
}

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
    private JTable tableHistoricoRecetas;
    private JButton ButtonBuscarHistorico;
    private JComboBox cmbBuscarRecetasHistorico;
    private JTable tableHistoricoMedicamentos;
    private JPanel Historial;
    private JPanel FormatoFarmaceutico;
    private JTextField textField2;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTextField textField4;
    private JButton borrarButton;
    private JTextField textField1;
    private JTextField textField5;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTable TablaListadofarma;
    private DefaultTableModel modeloMedicos;
    private DefaultTableModel modeloFarmaceuticos;

    public AdminVista(Personal u) {
        setContentPane(JPanelPrincipal);
        setTitle("Login");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(1000, 900);// tamanno de la ventana
        setLocationRelativeTo(null);
        inicializarTablaMedicos();
        inicializarTablaFarmaceuticos();
    }

    private void inicializarTablaMedicos() {
        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Especialidad"};

        // Modelo vacío
        modeloMedicos = new DefaultTableModel(null, columnas);

        TablaListado.setModel(modeloMedicos);
        JTableHeader header = TablaListado.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 15));
    }

    private void inicializarTablaFarmaceuticos(){

        String[] columnas = {"ID", "Nombre", "Especialidad"};
        modeloFarmaceuticos = new DefaultTableModel(null, columnas);
        TablaListadofarma.setModel(modeloFarmaceuticos);
        JTableHeader header = TablaListadofarma.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 15));




    }

    //  Getters para que la controladora pueda acceder
    public JTable getTablaMedicos() {
        return TablaListado;
    }
    public DefaultTableModel getModeloMedicos() {
        return modeloMedicos;
    }

    public JTable getTablaFarmaceuticos() {return TablaListadofarma;}
    public DefaultTableModel getModeloFarmaceuticos() {return modeloFarmaceuticos;}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminVista ventana = new AdminVista(null);
            ventana.setVisible(true);
        });
    }
}

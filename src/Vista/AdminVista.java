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
    private JPanel Medicamentos1;
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
    private JTextField campoNombreFarma;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTextField campoEspecialidadFarma;
    private JButton borrarButton;
    private JTextField campoIdFarma;
    private JTextField textField5;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTable TablaListadofarma;
    private JPanel FormatoPacientes;
    private JSplitPane DivisorPantalla;
    private JPanel PanelTExto;
    private JPanel PanelTabla;
    private JTable TablaPacientes;
    private JScrollPane FormatoTabla;
    private JLabel TextoListadoPaciente;
    private JLabel TextoPacientes;
    private JLabel BuscarTexto;
    private JTextField textField6;
    private JButton BotonBuscar;
    private JPanel PanelInsertarFarma;
    private JPanel PanelBusquedaFarma;
    private JPanel PanelTablaFarma;
    private JPanel PanelPrincipalMedicamento;
    private JPanel PanelInsertar;
    private JPanel PanelBusqueda;
    private JPanel PanelTablaMedicamentos;
    private JLabel CodigoMedicamento;
    private JLabel Presentacion;
    private JLabel NombreMedicamento;
    private JTextField CampoNombreMedicamento;
    private JButton Boton_LimpiarMedicamento;
    private JButton BTNBorrarMedicamento;
    private JTextField CampoCodigoMedicamento;
    private JTextField CampoPresentacionMedicamento;
    private JButton btnGuardarMedicamento;
    private JLabel TextoBusquedaMedicamento;
    private JLabel NombreMedicamentoB;
    private JTextField CampoNombreMEdicamento;
    private JButton BotonBuscarMedicamento;
    private JButton ReporteMedicamento;
    private JLabel TXTListado;
    private JLabel MEdicamento;
    private JTable TablaMedicamento;
    private DefaultTableModel modeloMedicos;
    private DefaultTableModel modeloFarmaceuticos;
    private DefaultTableModel modeloPacientes;
    private DefaultTableModel modeloMedicamentos;

    public AdminVista(Personal u) {
        setContentPane(JPanelPrincipal);
        setTitle("Login");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(1000, 900);// tamanno de la ventana
        setLocationRelativeTo(null);
        inicializarTablaMedicos();
        inicializarTablaFarmaceuticos();
        inicializarTablaPacientes();
    }

    private void inicializarTablaMedicos() {
        // Columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Especialidad"};

        // Modelo vacío
        modeloMedicos = new DefaultTableModel(null, columnas);

        TablaListado.setModel(modeloMedicos);
        JTableHeader header1 = TablaListado.getTableHeader();
        header1.setFont(new Font("Arial", Font.BOLD, 17));
    }

    private void inicializarTablaFarmaceuticos(){

        String[] columnas = {"ID", "Nombre", "Especialidad"};
        modeloFarmaceuticos = new DefaultTableModel(null, columnas);
        TablaListadofarma.setModel(modeloFarmaceuticos);
        JTableHeader header2 = TablaListadofarma.getTableHeader();
        header2.setFont(new Font("Arial", Font.BOLD, 17));

    }

    private void inicializarTablaPacientes(){
        // Definir columnas (sin filas todavía)
        String[] columnas = {"ID", "Nombre", "Fecha Nacimiento", "Teléfono"};
        modeloPacientes = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //  evita edición directa en la vista
            }
        };
        TablaPacientes.setModel(modeloPacientes);

        // Personalizar encabezado
        JTableHeader header = TablaPacientes.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 17));
        header.setReorderingAllowed(false); //  evitar que arrastren columnas

        // Ajustes visuales de la tabla
        TablaPacientes.setRowHeight(25); // altura de filas
        TablaPacientes.setFont(new Font("Arial", Font.PLAIN, 15));
        TablaPacientes.setSelectionBackground(new Color(184, 207, 229)); // color al seleccionar
        TablaPacientes.setSelectionForeground(Color.BLACK); // color de texto al seleccionar
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

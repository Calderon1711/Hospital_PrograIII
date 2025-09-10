package Vista;

import Modelo.Personal;
import javax.swing.*;

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
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button3;
    private JTable table1;

    public AdminVista(Personal u) {
        setTitle("Login");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(4000, 3800);// tamanno de la ventana
        setLocationRelativeTo(null);
    }
}

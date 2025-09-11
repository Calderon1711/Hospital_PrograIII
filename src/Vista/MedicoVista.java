package Vista;
import Modelo.Usuario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import Modelo.Personal;

public class MedicoVista extends JFrame {

    //======================================================
    //Panel Principal y pestanas
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel panelPreescribir;

    //=====================================================
    public MedicoVista(Personal u) {
        setContentPane(panel1);
        setTitle("Medico");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(1000, 800);// tamanno de la ventana
        setLocationRelativeTo(null);

        //Iconos de las pestanas

        ImageIcon iconPrincipal = new ImageIcon(getClass().getResource("/Imagenes_Luis/preescribir.png"));
        tabbedPane1.setIconAt(0, iconPrincipal);

        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes_Luis/dashboard.png"));
        tabbedPane1.setIconAt(1, icon1);

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Imagenes_Luis/historico.png"));
        tabbedPane1.setIconAt(2, icon2);

        ImageIcon icon3 = new ImageIcon(getClass().getResource("/Imagenes_Luis/acerca-de.png"));
        tabbedPane1.setIconAt(3, icon3);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MedicoVista vista = new MedicoVista(null);
            vista.setVisible(true);
        });
    }


    //=============================================================================
    //Setters Y Getters


    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public void setTabbedPane1(JTabbedPane tabbedPane1) {
        this.tabbedPane1 = tabbedPane1;
    }

    public JPanel getDatos() {
        return Datos;
    }

    public void setDatos(JPanel datos) {
        Datos = datos;
    }

    public JComboBox getCmbDesdeAnnio() {
        return cmbDesdeAnnio;
    }

    public void setCmbDesdeAnnio(JComboBox cmbDesdeAnnio) {
        this.cmbDesdeAnnio = cmbDesdeAnnio;
    }

    public JComboBox getCmbDesdeMes() {
        return cmbDesdeMes;
    }

    public void setCmbDesdeMes(JComboBox cmbDesdeMes) {
        this.cmbDesdeMes = cmbDesdeMes;
    }

    public JLabel getDesde() {
        return Desde;
    }

    public void setDesde(JLabel desde) {
        Desde = desde;
    }

    public JLabel getHasta() {
        return Hasta;
    }

    public void setHasta(JLabel hasta) {
        Hasta = hasta;
    }

    public JComboBox getCmbHastaAnio() {
        return cmbHastaAnio;
    }

    public void setCmbHastaAnio(JComboBox cmbHastaAnio) {
        this.cmbHastaAnio = cmbHastaAnio;
    }

    public JComboBox getCmbHastaMes() {
        return cmbHastaMes;
    }

    public void setCmbHastaMes(JComboBox cmbHastaMes) {
        this.cmbHastaMes = cmbHastaMes;
    }

    public JComboBox getCmbMedicamento() {
        return cmbMedicamento;
    }

    public void setCmbMedicamento(JComboBox cmbMedicamento) {
        this.cmbMedicamento = cmbMedicamento;
    }

    public JButton getBtnGenerarRango() {
        return btnGenerarRango;
    }

    public void setBtnGenerarRango(JButton btnGenerarRango) {
        this.btnGenerarRango = btnGenerarRango;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public JPanel getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(JPanel medicamentos) {
        Medicamentos = medicamentos;
    }

    public JPanel getRecetas() {
        return Recetas;
    }

    public void setRecetas(JPanel recetas) {
        Recetas = recetas;
    }

    public JButton getMedicamentosButton() {
        return medicamentosButton;
    }

    public void setMedicamentosButton(JButton medicamentosButton) {
        this.medicamentosButton = medicamentosButton;
    }

    public JButton getRecetasButton() {
        return recetasButton;
    }

    public void setRecetasButton(JButton recetasButton) {
        this.recetasButton = recetasButton;
    }

    public JButton getBtnAgregarMesButton() {
        return btnAgregarMesButton;
    }

    public void setBtnAgregarMesButton(JButton btnAgregarMesButton) {
        this.btnAgregarMesButton = btnAgregarMesButton;
    }

    public JButton getBtnQuitarMesButton() {
        return btnQuitarMesButton;
    }

    public void setBtnQuitarMesButton(JButton btnQuitarMesButton) {
        this.btnQuitarMesButton = btnQuitarMesButton;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }

    public JButton getButtonBuscarHistorico() {
        return ButtonBuscarHistorico;
    }

    public void setButtonBuscarHistorico(JButton buttonBuscarHistorico) {
        ButtonBuscarHistorico = buttonBuscarHistorico;
    }

    public JComboBox getCmbBuscarRecetasHistorico() {
        return cmbBuscarRecetasHistorico;
    }

    public void setCmbBuscarRecetasHistorico(JComboBox cmbBuscarRecetasHistorico) {
        this.cmbBuscarRecetasHistorico = cmbBuscarRecetasHistorico;
    }

    public JLabel getFotoHospital() {
        return fotoHospital;
    }

    public void setFotoHospital(JLabel fotoHospital) {
        this.fotoHospital = fotoHospital;
    }

    public JPanel getGraficoMedicamentos() {
        return graficoMedicamentos;
    }

    public void setGraficoMedicamentos(JPanel graficoMedicamentos) {
        this.graficoMedicamentos = graficoMedicamentos;
    }

    public JPanel getControl() {
        return Control;
    }

    public void setControl(JPanel control) {
        Control = control;
    }

    public JButton getBuscarPacienteButton() {
        return buscarPacienteButton;
    }

    public void setBuscarPacienteButton(JButton buscarPacienteButton) {
        this.buscarPacienteButton = buscarPacienteButton;
    }

    public JButton getAgregarMedicamentoButton() {
        return agregarMedicamentoButton;
    }

    public void setAgregarMedicamentoButton(JButton agregarMedicamentoButton) {
        this.agregarMedicamentoButton = agregarMedicamentoButton;
    }

    public JLabel getControlLabel() {
        return controlLabel;
    }

    public void setControlLabel(JLabel controlLabel) {
        this.controlLabel = controlLabel;
    }

    public JComboBox getOpciones_Fecha_de_Retiro() {
        return Opciones_Fecha_de_Retiro;
    }

    public void setOpciones_Fecha_de_Retiro(JComboBox opciones_Fecha_de_Retiro) {
        Opciones_Fecha_de_Retiro = opciones_Fecha_de_Retiro;
    }

    public JTextField getFecha_de_Retiro() {
        return Fecha_de_Retiro;
    }

    public void setFecha_de_Retiro(JTextField fecha_de_Retiro) {
        Fecha_de_Retiro = fecha_de_Retiro;
    }

    public JLabel getNombre_del_doctor() {
        return Nombre_del_doctor;
    }

    public void setNombre_del_doctor(JLabel nombre_del_doctor) {
        Nombre_del_doctor = nombre_del_doctor;
    }

    public JButton getGuardarButton() {
        return guardarButton;
    }

    public void setGuardarButton(JButton guardarButton) {
        this.guardarButton = guardarButton;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }

    public void setLimpiarButton(JButton limpiarButton) {
        this.limpiarButton = limpiarButton;
    }

    public JButton getDescartarMedicamentoButton() {
        return descartarMedicamentoButton;
    }

    public void setDescartarMedicamentoButton(JButton descartarMedicamentoButton) {
        this.descartarMedicamentoButton = descartarMedicamentoButton;
    }

    public JButton getDetallesButton() {
        return detallesButton;
    }

    public void setDetallesButton(JButton detallesButton) {
        this.detallesButton = detallesButton;
    }

    public JTable getTablaMedicamentos() {
        return tablaMedicamentos;
    }

    public void setTablaMedicamentos(JTable tablaMedicamentos) {
        this.tablaMedicamentos = tablaMedicamentos;
    }

    //============================================================
    //Mejorados
    public void setPanelPreescribir(JPanel panelPreescribir) {
        this.panelPreescribir = panelPreescribir;
    }

    public JPanel getPanelPreescribir() {
        return panelPreescribir;
    }

    public void setScrollPaneMedicamentos(JScrollPane medi) {
        ScrollPaneMedicamentos = medi;
    }

    public JScrollPane getScrollPaneMedicamentos() {
        return ScrollPaneMedicamentos;
    }

    //============================================================================

    //Botones de la pestana dashboard
    private JPanel Datos;
    private JComboBox cmbDesdeAnnio;
    private JComboBox cmbDesdeMes;
    private JLabel Desde;
    private JLabel Hasta;
    private JComboBox cmbHastaAnio;
    private JComboBox cmbHastaMes;
    private JComboBox cmbMedicamento;
    private JButton btnGenerarRango;
    private JButton btnLimpiar;
    private JPanel Medicamentos;
    private JPanel Recetas;
    private JButton medicamentosButton;
    private JButton recetasButton;
    private JButton btnAgregarMesButton;
    private JButton btnQuitarMesButton;
    private JTable tblDatos;

    //===============================================================

    //===============================================================
    //Botones Historico
    private JButton ButtonBuscarHistorico;
    private JComboBox cmbBuscarRecetasHistorico;
    private JTable tableHistoricoRecetas;
    private JTable tableHistoricoMedicamentos;

    //==============================================================

    //Botones
    //Acerca de
    private JLabel fotoHospital;
    private JPanel graficoMedicamentos;
    //==============================================================


    private void createUIComponents() {
    }

//=======================================================================
//Pestaña Preescribir


    private JPanel Control;
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;
    private JLabel controlLabel;
    private JComboBox Opciones_Fecha_de_Retiro;
    private JTextField Fecha_de_Retiro;
    private JLabel Nombre_del_doctor;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton descartarMedicamentoButton;
    private JButton detallesButton;
    private JTable tablaMedicamentos;
    private JPanel PanelPreescribir;
    private JScrollPane ScrollPaneMedicamentos;

    public void ModificarTablaMedicamentos() {
        String[] columnas = {"Medicamento", "Presentación", "Cantidad", "Indicaciones", "Duración (días)"};

        // Crear modelo vacío con solo columnas
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Asignar el modelo a la tabla
        tablaMedicamentos.setModel(modelo);

        // Asegurarte de que la tabla esté dentro del JScrollPane
        ScrollPaneMedicamentos.setViewportView(tablaMedicamentos);
    }


//=======================================================================


    //=======================================================================
//Pestaña DashBoard
    private JPanel PanelDashboard;
    private JScrollPane ScrollPaneDashBoard;

    void setPanelDashboard(JPanel panelDashboard) {
        this.PanelDashboard = panelDashboard;
    }

    JPanel getPanelDashboard() {
        return PanelDashboard;
    }


    public void inicializarComponentesDashboard() {
        // Inicializar combobox con años (2020-2030)
        for (int i = 2020; i <= 2030; i++) {
            cmbDesdeAnnio.addItem(String.valueOf(i));
            cmbHastaAnio.addItem(String.valueOf(i));
        }

        // Inicializar combobox con meses
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (String mes : meses) {
            cmbDesdeMes.addItem(mes);
            cmbHastaMes.addItem(mes);
        }

        // Inicializar combobox de medicamentos
        String[] medicamentos = {"Acetaminofen", "Amoxicilina", "Ibuprofeno", "Paracetamol"};
        for (String med : medicamentos) {
            cmbMedicamento.addItem(med);
        }

        // Configurar año y mes actual por defecto
        Calendar cal = Calendar.getInstance();
        int añoActual = cal.get(Calendar.YEAR);
        int mesActual = cal.get(Calendar.MONTH); // 0-11

        cmbDesdeAnnio.setSelectedItem(String.valueOf(añoActual));
        cmbHastaAnio.setSelectedItem(String.valueOf(añoActual));
        cmbDesdeMes.setSelectedIndex(mesActual);
        cmbHastaMes.setSelectedIndex(mesActual);
    }

    public void ModificarTablaDashBoard() {
        String[] columnas = {"Medicamento"};

        // Crear modelo vacío con solo columnas
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Asignar el modelo a la tabla
        tblDatos.setModel(modelo);

        // Asegurarte de que la tabla esté dentro del JScrollPane
        ScrollPaneDashBoard.setViewportView(tblDatos);
    }


//=======================================================================
// Graficos de dashboard------------------------------------------------


//=======================================================================
//Pestaña Historico


//=======================================================================
//Pestana Acerca de

}
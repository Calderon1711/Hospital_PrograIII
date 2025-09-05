package Vista;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;


public class MedicoVista {

    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel Control;
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;
    private JLabel controlLabel;
    private JComboBox Opciones_Fecha_de_Retiro;
    private JTextField Fecha_de_Retiro;
    private JTextField Nombre_del_doctor;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton descartarMedicamentoButton;
    private JButton detallesButton;
    private JTable tablaMedicamentos;
    private JLabel DatosLabel;
    private JLabel DesdeLabel;
    private JLabel HastaButton;
    private JComboBox Año_desde;
    private JComboBox fecha_desde;
    private JComboBox año_desde;
    private JComboBox fecha_hasta;
    private JComboBox medicamentoscombobx;
    private JPanel graficoMedicamentos;
    private JPanel graficoRecetas;

    private void createUIComponents() {
    }

    public void ListaMedicamentos(){
        tablaMedicamentos.setPreferredScrollableViewportSize(tablaMedicamentos.getPreferredSize());
    }


    public void graficoMedicamentos(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("PROCESO", 4);
        dataset.setValue("LISTA", 4);
        dataset.setValue("ENTREGADA", 3);
        dataset.setValue("CONFECCIONADA", 3);

        JFreeChart chart = ChartFactory.createPieChart("Recetas", dataset, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);

// Limpia el panel y agrega el gráfico
        graficoMedicamentos.removeAll();
        graficoMedicamentos.setLayout(new BorderLayout());
        graficoMedicamentos.add(chartPanel, BorderLayout.CENTER);
        graficoMedicamentos.validate();
    }

}

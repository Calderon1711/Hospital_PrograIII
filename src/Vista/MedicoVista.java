package Vista;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
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
    private JPanel graficoMedicamentos;

    private void createUIComponents() {
    }

    public void ListaMedicamentos(){
        tablaMedicamentos.setPreferredScrollableViewportSize(tablaMedicamentos.getPreferredSize());
    }

// Graficos de dashboard------------------------------------------------

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


    public void graficoRecetas(JPanel graficoRecetas) {
            // Crear el dataset
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("PROCESO", 4);
            dataset.setValue("LISTA", 4);
            dataset.setValue("ENTREGADA", 3);
            dataset.setValue("CONFECCIONADA", 3);

            // Crear el gráfico
            JFreeChart chart = ChartFactory.createPieChart(
                    "Recetas", // Título
                    dataset,   // Datos
                    true,      // Leyenda
                    true,      // Tooltips
                    false      // URLs
            );

            // Personalizar colores
            PiePlot plot = (PiePlot) chart.getPlot();
            plot.setSectionPaint("PROCESO", Color.RED);
            plot.setSectionPaint("LISTA", Color.BLUE);
            plot.setSectionPaint("ENTREGADA", Color.GREEN);
            plot.setSectionPaint("CONFECCIONADA", Color.YELLOW);
            plot.setBackgroundPaint(Color.WHITE);

            // Insertar el gráfico en el JPanel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(graficoRecetas.getSize());
            graficoRecetas.removeAll(); // Limpiar contenido previo
            graficoRecetas.add(chartPanel);
            graficoRecetas.revalidate();
            graficoRecetas.repaint();
        }

//----------------------------------------------------------------------------------
}


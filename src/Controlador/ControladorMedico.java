package Controlador;


import Vista.Agregar_Medicamento;
import Vista.MedicoVista;
import Vista.Buscar_Paciente;
import Modelo.*;
import javafx.collections.ObservableList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;


public class ControladorMedico extends JFrame {

    private final MedicoVista vista;
    private static Hospital hospi=Hospital.getInstance();
    private ControladoraBuscarPaciente controladoraBuscarPaciente;
    static Personal personal;


    //Para controlador general
    public ControladorMedico(MedicoVista medicoVista, Personal personalMedico) {
        this.vista = medicoVista;
        this.personal = personalMedico;
        initController();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MedicoVista medicoVista = new MedicoVista(personal);
            new ControladorMedico(medicoVista,personal);
            medicoVista.setVisible(true);
        });
    }


    public void initController() {

        //Pestana preeescribir
        activarDatosPreescribir();
        configurarEventosPreescribir();

        //Pestana Dashboard
        activarDatosDashboard();
        configurarEventosDashboard();




    }


    //=============================================================
    //Pestana preescribir

    private void activarDatosPreescribir(){
        modificarTablaMedicamentosPreescribir();
    }

    private void configurarEventosPreescribir() {

        //Agregar Paciente

        vista.getBuscarPacienteButton().addActionListener(e -> buscarPaciente());
        vista.getNombre_del_doctor().setText("Chayanne");

        vista.getAgregarMedicamentoButton().addActionListener(e -> agregarMedicamento());

        vista.getGuardarButton().addActionListener(e -> guardarReceta());
        vista.getLimpiarButton().addActionListener(e -> limpiarCampos());
        vista.getDescartarMedicamentoButton().addActionListener(e -> descartarMedicamento());
        vista.getDetallesButton().addActionListener(e -> mostrarDetalles());

    }
    public void modificarTablaMedicamentosPreescribir() {
        String[] columnas = {"Medicamento", "Presentación", "Cantidad", "Indicaciones", "Duración (días)"};

        // Crear modelo vacío con solo columnas
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Asignar el modelo a la tabla
        vista.getTablaMedicamentos().setModel(modelo);

        // Asegurarte de que la tabla esté dentro del JScrollPane
        vista.getScrollPaneMedicamentos().setViewportView(vista.getTablaMedicamentos());
    }

    private void buscarPaciente() {
        if (controladoraBuscarPaciente == null) {
            controladoraBuscarPaciente = new ControladoraBuscarPaciente(Hospital.getInstance());
        }
        controladoraBuscarPaciente.mostrarVentana();
    }

    private void agregarMedicamento(){



        Medicamento m1=new Medicamento();
        hospi.getMedicamentos().insertarMedicamento(m1);
    }


    private void guardarReceta() {
        String fecha = vista.getFecha_de_Retiro().getText();
        String seleccion = vista.getOpciones_Fecha_de_Retiro().getSelectedItem().toString();


        Receta r1 = new Receta();
        hospi.getRecetas().insertarReceta(r1);


    }

    private void limpiarCampos() {
        // Verificar si el campo de texto está vacío o contiene solo espacios
        if (vista.getFecha_de_Retiro().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay nada que borrar", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            vista.getFecha_de_Retiro().setText("");
        }
    }

    private void descartarMedicamento() {
        int fila = vista.getTablaMedicamentos().getSelectedRow();
        if (fila != -1) {

        } else {
            JOptionPane.showMessageDialog(null, "No hay medicamento seleccionado", "Descartar Medicamento", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarDetalles() {
        JOptionPane.showMessageDialog(null, "No hay medicamentos", "Detalles", JOptionPane.WARNING_MESSAGE);
        //Logica para mostrar los detalles
    }




    //========================================================================
    //Pestana Dasboard


    public void activarDatosDashboard() {
        inicializarComponentesDashboard();
        modificarTablaDashBoard();
        crearGraficoMedicamentos(vista.getMedicamentos());
        crearGraficoRecetas(vista.getRecetas());
    }

    public void configurarEventosDashboard(){
        vista.getBtnGenerarRango().addActionListener(e -> generarRango());
        vista.getLimpiarButton().addActionListener(e -> limpiarCampos());
        vista.getBtnAgregarMesButton().addActionListener(e-> agregarMes());
        vista.getBtnQuitarMesButton().addActionListener(e-> quitarMes());
    }

    public void inicializarComponentesDashboard() {
        // Inicializar combobox con años (2020-2030)
        for (int i = 2020; i <= 2030; i++) {
            vista.getCmbDesdeAnnio().addItem(String.valueOf(i));
            vista.getCmbHastaAnio().addItem(String.valueOf(i));
        }

        // Inicializar combobox con meses
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (String mes : meses) {
            vista.getCmbDesdeMes().addItem(mes);
            vista.getCmbHastaMes().addItem(mes);
        }

        // Inicializar combobox de medicamentos

        List<Medicamento> lista = hospi.getMedicamentos().getMedicamentos();

        for (Medicamento med : lista) {
            vista.getCmbMedicamento().addItem(med.getNombre());
        }

        // Configurar año y mes actual por defecto
        Calendar cal = Calendar.getInstance();
        int añoActual = cal.get(Calendar.YEAR);
        int mesActual = cal.get(Calendar.MONTH); // 0-11

        vista.getCmbDesdeAnnio().setSelectedItem(String.valueOf(añoActual));
        vista.getCmbHastaAnio().setSelectedItem(String.valueOf(añoActual));
        vista.getCmbDesdeMes().setSelectedIndex(mesActual);
        vista.getCmbHastaMes().setSelectedIndex(mesActual);
    }

    public void modificarTablaDashBoard() {
        List<Medicamento> lista = hospi.getMedicamentos().getMedicamentos();
        String[] columnas = {"Medicamento"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    // Agregar cada medicamento al modelo
        for (Medicamento med : lista) {
            Object[] fila = {med.getNombre()};
            modelo.addRow(fila);
        }

    // Asignar modelo a la tabla
        vista.getTblDatos().setModel(modelo);
        vista.getScrollPaneMedicamentos().setViewportView(vista.getTblDatos());
    }


    //=======================================================================
// Graficos de dashboard------------------------------------------------
    public void crearGraficoMedicamentos(JPanel panel) {
        List<Medicamento> listaMedicamentos = hospi.getMedicamentos().getMedicamentos();

        // Contar medicamentos por nombre
        Map<String, Integer> conteoPorNombre = new HashMap<>();
        for (Medicamento med : listaMedicamentos) {
            String nombre = med.getNombre();
            conteoPorNombre.put(nombre, conteoPorNombre.getOrDefault(nombre, 0) + 1);
        }

        // Crear dataset para gráfico de pastel
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : conteoPorNombre.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Crear gráfico de pastel
        JFreeChart chart = ChartFactory.createPieChart(
                "Distribución de Medicamentos por Nombre",
                dataset,
                true,
                true,
                false
        );

        // Mostrar porcentaje en etiquetas
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {2}")); // Ej: Paracetamol: 25%

        chart.setBackgroundPaint(Color.WHITE);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 300));

        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public void crearGraficoRecetas(JPanel panel) {
        List<Receta> recetas = hospi.getRecetas().getRecetas();

        // Contar recetas por estado (usando nombre legible)
        Map<String, Integer> conteoPorEstado = new HashMap<>();
        for (Receta r1 : recetas) {
            int estadoInt = r1.getEstado(); // Suponiendo que esto devuelve el int
            String estadoNombre = obtenerNombreEstado(estadoInt);
            conteoPorEstado.put(estadoNombre, conteoPorEstado.getOrDefault(estadoNombre, 0) + 1);
        }

        // Crear dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : conteoPorEstado.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Crear gráfico
        JFreeChart chart = ChartFactory.createPieChart(
                "Distribución de Recetas por Estado",
                dataset,
                true,
                true,
                false
        );
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {2}"));



        chart.setBackgroundPaint(Color.WHITE);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 300));

        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    // Método auxiliar para traducir el int a nombre de estado
    private String obtenerNombreEstado(int estado) {
        switch (estado) {
            case 1: return "Confeccionada";
            case 2: return "En Proceso";
            case 3: return "Lista";
            case 4: return "Entregada";
            default: return "Desconocido";
        }
    }
    public void generarRango() {
        String desdeAño = (String) vista.getCmbDesdeAnnio().getSelectedItem();
        String desdeMes = (String) vista.getCmbDesdeMes().getSelectedItem();
        String hastaAño = (String) vista.getCmbHastaAnio().getSelectedItem();
        String hastaMes = (String) vista.getCmbHastaMes().getSelectedItem();
        String medicamento = (String) vista.getCmbMedicamento().getSelectedItem();

        // Validar que la fecha desde sea menor o igual que la fecha hasta
        if (!validarRangoFechas(desdeAño, desdeMes, hastaAño, hastaMes)) {
            JOptionPane.showMessageDialog(null,
                    "La fecha 'Desde' debe ser menor o igual que la fecha 'Hasta'",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí iría la lógica para generar el reporte con los parámetros seleccionados
        String mensaje = String.format(
                "Generando reporte:\nDesde: %s %s\nHasta: %s %s\nMedicamento: %s",
                desdeMes, desdeAño, hastaMes, hastaAño, medicamento
        );

        JOptionPane.showMessageDialog(null, mensaje, "Generar Reporte", JOptionPane.INFORMATION_MESSAGE);

        // Simular carga de datos (en una aplicación real, esto vendría de una base de datos)
//            actualizarTablaConDatos(datosEjemplo);
    }

    private boolean validarRangoFechas(String desdeAño, String desdeMes, String hastaAño, String hastaMes) {
        int añoDesde = Integer.parseInt(desdeAño);
        int añoHasta = Integer.parseInt(hastaAño);

        if (añoDesde > añoHasta) {
            return false;
        }

        if (añoDesde == añoHasta) {
            int mesDesde = vista.getCmbDesdeMes().getSelectedIndex();
            int mesHasta = vista.getCmbHastaMes().getSelectedIndex();
            return mesDesde <= mesHasta;
        }

        return true;
    }

    public void limpiarCamposDashboard() {
        // Restablecer a valores por defecto
        Calendar cal = Calendar.getInstance();
        int añoActual = cal.get(Calendar.YEAR);
        int mesActual = cal.get(Calendar.MONTH);

        vista.getCmbDesdeAnnio().setSelectedItem(String.valueOf(añoActual));
        vista.getCmbHastaAnio().setSelectedItem(String.valueOf(añoActual));
        vista.getCmbDesdeMes().setSelectedIndex(mesActual);
        vista.getCmbHastaMes().setSelectedIndex(mesActual);
        vista.getCmbMedicamento().setSelectedIndex(0);

        // Restablecer tabla a datos iniciales
//                actualizarTablaConDatos(datosEjemplo);

        JOptionPane.showMessageDialog(null, "Filtros limpiados correctamente", "Limpiar", JOptionPane.INFORMATION_MESSAGE);
    }

    private void agregarMes() {
        // Lógica para agregar un mes a la tabla
        DefaultTableModel model = (DefaultTableModel) vista.getTblDatos().getModel();
        Object[] nuevoMes = {"Nuevo Mes", 0.0, 0.0};
        model.addRow(nuevoMes);

        JOptionPane.showMessageDialog(vista, "Mes agregado a la tabla", "Agregar Mes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void quitarMes() {
        // Lógica para quitar el mes seleccionado de la tabla
        int selectedRow = vista.getTblDatos().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(vista,
                    "Por favor, seleccione un mes para quitar",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) vista.getTblDatos().getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(vista, "Mes quitado de la tabla", "Quitar Mes", JOptionPane.INFORMATION_MESSAGE);
    }

}









package Controlador;


import Modelo.Medicamento;
import Vista.Agregar_Medicamento;
import Vista.MedicoVista;
import Vista.Buscar_Paciente;


import javax.swing.*;
import java.util.Calendar;


public class ControladorMedico extends JFrame {

    private final MedicoVista medicoVista;
    private final ControladorGeneral controladorGeneral;
    private final Buscar_Paciente buscarPacienteVista;
    private final Agregar_Medicamento agregarMedicamentoVista;


    public ControladorMedico(MedicoVista medicoVista, ControladorGeneral controladorGeneral, Buscar_Paciente buscarPaciente, Agregar_Medicamento agregarMedicamentoVista) {
        this.medicoVista = medicoVista;
        this.controladorGeneral = controladorGeneral;
        this.buscarPacienteVista = buscarPaciente;
        this.agregarMedicamentoVista = agregarMedicamentoVista;
        initController();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MedicoVista medicoVista = new MedicoVista(null);
            Buscar_Paciente buscarPaciente = new Buscar_Paciente(null);
            ControladorGeneral controladorGeneral = new ControladorGeneral();
            Agregar_Medicamento medicamentoVista = new Agregar_Medicamento(null);

            new ControladorMedico(medicoVista, controladorGeneral, buscarPaciente, medicamentoVista);
            medicoVista.setVisible(true);
        });
    }


    public void initController() {
        //Pestana preeescribir
        configurarEventosPreescribir();
        //Pestana Dashboard
        configurarEventosDashBoard();

        //Pestana Historico

        //Pestana Acerca de
    }

    //==============================================================
    //Pestana preeescribir
    private void configurarEventosPreescribir() {
        medicoVista.ModificarTablaMedicamentos();
        medicoVista.getNombre_del_doctor().setText("Dr. Carlos Cornejo");
        medicoVista.getBuscarPacienteButton().addActionListener(e -> buscarPaciente());
        medicoVista.getAgregarMedicamentoButton().addActionListener(e -> agregarMedicamento());
        medicoVista.getGuardarButton().addActionListener(e -> guardarReceta());
        medicoVista.getLimpiarButton().addActionListener(e -> limpiarCampos());
        medicoVista.getDescartarMedicamentoButton().addActionListener(e -> descartarMedicamento());
        medicoVista.getDetallesButton().addActionListener(e -> mostrarDetalles());

    }

    private void buscarPaciente() {
        buscarPacienteVista.setVisible(true);
    }

    private void agregarMedicamento() {
        agregarMedicamentoVista.setVisible(true);
    }

    private void guardarReceta() {
        String fecha = medicoVista.getFecha_de_Retiro().getText();
        String seleccion = medicoVista.getOpciones_Fecha_de_Retiro().getSelectedItem().toString();

    }

    private void limpiarCampos() {
        // Verificar si el campo de texto está vacío o contiene solo espacios
        if (medicoVista.getFecha_de_Retiro().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay nada que borrar", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            medicoVista.getFecha_de_Retiro().setText("");
        }
    }

    private void descartarMedicamento() {
        int fila = medicoVista.getTablaMedicamentos().getSelectedRow();
        if (fila != -1) {

        } else {
            JOptionPane.showMessageDialog(null, "No hay medicamento seleccionado", "Descartar Medicamento", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarDetalles() {
        JOptionPane.showMessageDialog(null, "No hay medicamentos", "Detalles", JOptionPane.WARNING_MESSAGE);
        //Logica para mostrar los detalles
    }

    private void agregarMedicamentoalaTabla(Medicamento med) {
        //Logica para recibir el medicamento y agregarlo a la lista
    }

    ;

    //========================================================================
    //Pestana Dasboard

    private void configurarEventosDashBoard() {
        medicoVista.inicializarComponentesDashboard();
        medicoVista.ModificarTablaDashBoard();
        medicoVista.getBtnGenerarRango().addActionListener(e -> generarRango());
        medicoVista.getLimpiarButton().addActionListener(e -> limpiarCamposDashboard());
    }

    public void generarRango() {
        String desdeAño = (String) medicoVista.getCmbDesdeAnnio().getSelectedItem();
        String desdeMes = (String) medicoVista.getCmbDesdeMes().getSelectedItem();
        String hastaAño = (String) medicoVista.getCmbHastaAnio().getSelectedItem();
        String hastaMes = (String) medicoVista.getCmbHastaMes().getSelectedItem();
        String medicamento = (String) medicoVista.getCmbMedicamento().getSelectedItem();

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
            int mesDesde = medicoVista.getCmbDesdeMes().getSelectedIndex();
            int mesHasta = medicoVista.getCmbHastaMes().getSelectedIndex();
            return mesDesde <= mesHasta;
        }

        return true;
    }

    public void limpiarCamposDashboard() {
        // Restablecer a valores por defecto
        Calendar cal = Calendar.getInstance();
        int añoActual = cal.get(Calendar.YEAR);
        int mesActual = cal.get(Calendar.MONTH);

        medicoVista.getCmbDesdeAnnio().setSelectedItem(String.valueOf(añoActual));
        medicoVista.getCmbHastaAnio().setSelectedItem(String.valueOf(añoActual));
        medicoVista.getCmbDesdeMes().setSelectedIndex(mesActual);
        medicoVista.getCmbHastaMes().setSelectedIndex(mesActual);
        medicoVista.getCmbMedicamento().setSelectedIndex(0);

        // Restablecer tabla a datos iniciales
//                actualizarTablaConDatos(datosEjemplo);

        JOptionPane.showMessageDialog(null, "Filtros limpiados correctamente", "Limpiar", JOptionPane.INFORMATION_MESSAGE);
    }



        //====================================================================


}








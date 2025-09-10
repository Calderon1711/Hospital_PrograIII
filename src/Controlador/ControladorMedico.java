package Controlador;


import Modelo.Medicamento;
import Vista.Agregar_Medicamento;
import Vista.MedicoVista;
import Vista.Buscar_Paciente;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class ControladorMedico extends JFrame{

    private final MedicoVista medicoVista;
    private final ControladorGeneral controladorGeneral;
    private final Buscar_Paciente buscarPacienteVista;
    private final Agregar_Medicamento  agregarMedicamentoVista;



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
            Agregar_Medicamento medicamentoVista= new Agregar_Medicamento(null);

            new ControladorMedico(medicoVista, controladorGeneral, buscarPaciente,medicamentoVista);
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
            if(medicoVista.getFecha_de_Retiro().getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay nada que borrar", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                medicoVista.getFecha_de_Retiro().setText("");
            }
        }

        private void descartarMedicamento() {
            int fila = medicoVista.getTablaMedicamentos().getSelectedRow();
            if (fila != -1) {

            } else {
                JOptionPane.showMessageDialog(null,"No hay medicamento seleccionado","Descartar Medicamento",JOptionPane.WARNING_MESSAGE);
            }
        }

        private void mostrarDetalles() {
        JOptionPane.showMessageDialog(null, "No hay medicamentos", "Detalles", JOptionPane.WARNING_MESSAGE);
        //Logica para mostrar los detalles
        }

        private void agregarMedicamentoalaTabla(Medicamento med){
            //Logica para recibir el medicamento y agregarlo a la lista
        };

    //========================================================================
    //Pestana Dasboard

        private void configurarEventosDashBoard(){

        }








        //====================================================================


}








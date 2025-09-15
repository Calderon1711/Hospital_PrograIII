package Controlador;

import Modelo.*;
import Vista.AdminVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladoraAdmin implements ActionListener {
    private AdminVista vista;
    private Personal modelo;
    private static Hospital hospi=Hospital.getInstance();

    public ControladoraAdmin(AdminVista vista, Personal modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // ======= Asignar acciones a los botones =======
        vista.getBotonGuardar().addActionListener(this);
        vista.getBotonLimpiar().addActionListener(this);
        vista.getBotonBorrar().addActionListener(this);
        vista.getBuscarBoton().addActionListener(this);
        vista.getBotonReporte().addActionListener(this);

        vista.getGuardarButton().addActionListener(this);
        vista.getLimpiarButton().addActionListener(this);
        vista.getBorrarButton().addActionListener(this);
        vista.getBuscarButton().addActionListener(this);
        vista.getReporteButton().addActionListener(this);

        vista.getBtnGuardarMedicamento().addActionListener(this);
        vista.getBoton_LimpiarMedicamento().addActionListener(this);
        vista.getBTNBorrarMedicamento().addActionListener(this);
        vista.getBotonBuscarMedicamento().addActionListener(this);
        vista.getReporteMedicamento().addActionListener(this);

        vista.getBotonBuscar().addActionListener(this);

        actualizarTablaMedicos();
        actualizarTablaMedicos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // ==== Médicos ====
        if (source == vista.getBotonGuardar()) {
            guardarMedico();
            hospi.guradarPersonal();
        } else if (source == vista.getBotonLimpiar()) {
            limpiarMedico();
        } else if (source == vista.getBotonBorrar()) {
            borrarMedico();
            hospi.guradarPersonal();
        } else if (source == vista.getBuscarBoton()) {
            buscarMedico();
        } else if (source == vista.getBotonReporte()) {
            reporteMedico();
            actualizarTablaMedicos();
        }

        // ==== Farmacéuticos ====
        else if (source == vista.getGuardarButton()) {
            guardarFarma();
            hospi.guradarPersonal();
        } else if (source == vista.getLimpiarButton()) {
            limpiarFarma();
        } else if (source == vista.getBorrarButton()) {
            borrarFarma();
            hospi.guradarPersonal();
        } else if (source == vista.getBuscarButton()) {
            buscarFarma();
        } else if (source == vista.getReporteButton()) {
            reporteFarma();
            actualizarTablaMedicos();
        }
/*
        // ==== Medicamentos ====
        else if (source == vista.getBtnGuardarMedicamento()) {
            guardarMedicamento();
        } else if (source == vista.getBoton_LimpiarMedicamento()) {
            limpiarMedicamento();
        } else if (source == vista.getBTNBorrarMedicamento()) {
            borrarMedicamento();
        } else if (source == vista.getBotonBuscarMedicamento()) {
            buscarMedicamento();
        } else if (source == vista.getReporteMedicamento()) {
            reporteMedicamento();
        }

        // ==== Pacientes ====
        else if (source == vista.getBotonBuscar()) {
            buscarPaciente();
        }*/
    }

    private void guardarMedico() {
        String id = vista.getCampoIDMEdico().getText();
        String nombre = vista.getCampoNombreMedico().getText();
        String especialidad = vista.getCampoEspecialidadMEdico().getText();

        if (id.isEmpty() || nombre.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            return;
        }

        Medico medicoNuevo = new Medico(nombre,id,id,especialidad,Rol.MEDICO);
        boolean verificador = hospi.getPersonal().existePersonalConEseID(medicoNuevo.getId());
        if( hospi.getPersonal().insertarPersonal(medicoNuevo,verificador)==true) {
            JOptionPane.showMessageDialog(null, "Médico guardado correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Médico No se puede guardar.");
        }

        limpiarMedico();
        actualizarTablaMedicos();
    }

    private void limpiarMedico() {
        vista.getCampoIDMEdico().setText("");
        vista.getCampoNombreMedico().setText("");
        vista.getCampoEspecialidadMEdico().setText("");
        vista.getCampoNombreBusquedaMedico().setText("");
    }

    private void borrarMedico() {
        int fila = vista.getTablaListado().getSelectedRow();
        if (fila >= 0) {
            String id = (String) vista.getTablaListado().getValueAt(fila, 0);
            hospi.getPersonal().eliminar(id);
            actualizarTablaMedicos();
            JOptionPane.showMessageDialog(null, "Médico eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un médico para borrar.");
        }
    }

    private void actualizarTablaMedicos() {
        DefaultTableModel tableModel = vista.getModeloMedicos();
        tableModel.setRowCount(0);

        // Traemos solo los médicos de la lista general
        for (Personal p : hospi.getPersonal().obtenerPersonalPorTipo("Medico")) {
            if (p instanceof Medico) {
                Medico m = (Medico) p;
                tableModel.addRow(new Object[]{
                        m.getId(),
                        m.getNombre(),
                        m.getEspecialidad()
                });
            }
        }
    }

    private void buscarMedico() {
        String nombre = vista.getCampoNombreBusquedaMedico().getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para buscar.");
            return;
        }

        DefaultTableModel modelo = vista.getModeloMedicos();
        modelo.setRowCount(0); // limpiar tabla

        for (Personal p : hospi.getPersonal().obtenerPersonalPorTipo("Medico")) {
            if (p instanceof Medico) {
                Medico m = (Medico) p;
                if (m.getNombre().equalsIgnoreCase(nombre)) {
                    modelo.addRow(new Object[]{
                            m.getId(),
                            m.getNombre(),
                            m.getEspecialidad()
                    });
                }
            }
        }

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontró un médico con ese nombre.");
        }
    }

    private void reporteMedico() {
        int fila = vista.getTablaListado().getSelectedRow();
        if (fila >= 0) {
            String id = (String) vista.getTablaListado().getValueAt(fila, 0);
            Personal p = hospi.getPersonal().getPersonalPorID(id);

            if (p != null && p instanceof Medico) {
                JOptionPane.showMessageDialog(null, p.toString());
            } else {
                JOptionPane.showMessageDialog(null, "El elemento seleccionado no es un médico.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un médico de la tabla para generar reporte.");
        }
    }

    //=============================Logica Farma============================================//
    private void guardarFarma() {
        String idF = vista.getCampoIdFarma().getText();
        String nombreF = vista.getCampoNombreFarma().getText();


        if (idF.isEmpty() || nombreF.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            return;
        }

        Farmaceuta farmaNuevo = new Farmaceuta(nombreF,idF,idF,Rol.FARMACEUTICO);
        boolean verificador = hospi.getPersonal().existePersonalConEseID(farmaNuevo.getId());
        if( hospi.getPersonal().insertarPersonal(farmaNuevo,verificador)==true) {
            JOptionPane.showMessageDialog(null, "Farmaceuta guardado correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Farmaceuta No se puede guardar.");
        }

        limpiarFarma();
        actualizarTablaFarma();
    }

    private void limpiarFarma() {
       vista.getCampoIdFarma().setText("");
       vista.getCampoNombreFarma().setText("");
       vista.getCampoBusquedaFarma().setText("");
    }

    private void borrarFarma() {
        int fila = vista.getTablaFarmaceuticos().getSelectedRow();
        if (fila >= 0) {
            String id = (String) vista.getTablaFarmaceuticos().getValueAt(fila, 0);
            hospi.getPersonal().eliminar(id);
            actualizarTablaFarma();
            JOptionPane.showMessageDialog(null, "Farmacéutico eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Farmacéutico para borrar.");
        }
    }

    private void  actualizarTablaFarma() {
        DefaultTableModel tableModel = vista.getModeloFarmaceuticos();
        tableModel.setRowCount(0);

        // Traemos solo los médicos de la lista general
        for (Personal p : hospi.getPersonal().obtenerPersonalPorTipo("Farmaceuta")) {
            if (p instanceof Farmaceuta) {
                Farmaceuta f = (Farmaceuta) p;
                tableModel.addRow(new Object[]{
                        f.getId(),
                        f.getNombre()
                });
            }
        }
    }

    private void buscarFarma() {
        String nombre = vista.getCampoBusquedaFarma().getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para buscar.");
            return;
        }

        DefaultTableModel modelo = vista.getModeloFarmaceuticos();
        modelo.setRowCount(0); // limpiar tabla

        for (Personal p : hospi.getPersonal().obtenerPersonalPorTipo("Farmaceuta")) {
            if (p instanceof Farmaceuta) {
                Farmaceuta f = (Farmaceuta) p;
                if (f.getNombre().equalsIgnoreCase(nombre)) {
                    modelo.addRow(new Object[]{
                            f.getId(),
                            f.getNombre()
                    });
                }
            }
        }

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se encontró un farmacéutico con ese nombre.");
        }
    }

    private void reporteFarma() {
        int fila = vista.getTablaFarmaceuticos().getSelectedRow();
        if (fila >= 0) {
            String id = (String) vista.getTablaFarmaceuticos().getValueAt(fila, 0);
            Personal p = hospi.getPersonal().getPersonalPorID(id);

            if (p != null && p instanceof Farmaceuta) {
                JOptionPane.showMessageDialog(null, p.toString());
            } else {
                JOptionPane.showMessageDialog(null, "El elemento seleccionado no es un Farmaceuta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Farmaceuta de la tabla para generar reporte.");
        }
    }


}

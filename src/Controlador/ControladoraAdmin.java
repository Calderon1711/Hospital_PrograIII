package Controlador;

import Modelo.*;
import Vista.AdminVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        vista.getBtnGuardarPaciente().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);
        vista.getBorrarPAciente().addActionListener(this);

        actualizarTablaMedicos();
        actualizarTablaFarma();
        actualizarTablaPaciente();
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

        // ==== Pacientes ====
          else if (source == vista.getBtnGuardarPaciente()) {
            guardarPaciente();
            hospi.guardarPacientes();
        } else if (source == vista.getBtnLimpiarPaciente()) {
            limpiarPaciente();
        } else if (source == vista.getBorrarPAciente()) {
            borrarPaciente();
            hospi.guardarPacientes();
        } else if (source == vista.getBotonBuscarPaciente()) {
            buscarPaciente();
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
        */

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
//=============================================Logica PAciente============================

    private void guardarPaciente() {
        String id = vista.getCampoIdPAciente().getText();
        String nombre = vista.getCampoNombrePaciente().getText();
        String fechaStr = vista.getCampoFechaNacimiento().getText();
        LocalDate fechaNacimiento = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            fechaNacimiento = LocalDate.parse(fechaStr, formato);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null,
                    "La fecha debe tener formato yyyy-MM-dd",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return; // salir o manejar error
        }

        String telStr = vista.getCampoTelefonoPaciente().getText();
        int telefono = 0;
        try {
            telefono = Integer.parseInt(telStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El teléfono debe ser un número",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return; // salir o manejar error
        }


        if (id.isEmpty() || nombre.isEmpty() || fechaNacimiento==null||telefono==0) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            return;
        }

        Paciente paciente = new Paciente(telefono,fechaNacimiento,nombre,id);
        boolean verificador = hospi.getPacientes().existeAlguienConEseID(paciente.getId());
        if( hospi.getPacientes().insertarPaciente(paciente,verificador)==true) {
            JOptionPane.showMessageDialog(null, "Paciente guardado correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Paciente No se puede guardar.");
        }

        limpiarPaciente();
        actualizarTablaPaciente();
    }

    private void limpiarPaciente() {
    vista.getCampoIdPAciente().setText("");
    vista.getCampoNombrePaciente().setText("");
    vista.getCampoFechaNacimiento().setText("");
    vista.getCampoTelefonoPaciente().setText("");
    }

    private void borrarPaciente() {
        int fila = vista.getTablaPacientes().getSelectedRow();
        if (fila >= 0) {
            String id = (String) vista.getTablaPacientes().getValueAt(fila, 0);
            hospi.getPacientes().eliminar(id);
            actualizarTablaPaciente();
            JOptionPane.showMessageDialog(null, "Paciente eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente para borrar.");
        }
    }

    private void actualizarTablaPaciente() {
        DefaultTableModel tableModel = vista.getModeloPacientes();
        tableModel.setRowCount(0); // Limpiamos la tabla

        // Recorremos la lista de pacientes
        for (Paciente p : hospi.getPacientes().getPacientes()) {
            tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getFechaNacimiento(),
                    p.getTelefono()
            });
        }
    }


    private void buscarPaciente() {
        String nombre = vista.getCampoBuscarPaciente().getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para buscar.");
            return;
        }

        DefaultTableModel modelo = vista.getModeloPacientes();
        modelo.setRowCount(0); // limpiar tabla

        boolean encontrado = false;

        for (Paciente p : hospi.getPacientes().getPacientes()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                modelo.addRow(new Object[]{
                        p.getId(),
                        p.getNombre(),
                        p.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        p.getTelefono(),
                });
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un paciente con ese nombre.");
        }
    }




}

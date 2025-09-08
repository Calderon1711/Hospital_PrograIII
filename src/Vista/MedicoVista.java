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
import Modelo.Personal;

public class MedicoVista extends JFrame {

    //======================================================
    //Panel Principal y pestanas
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    //=====================================================
    public MedicoVista(Personal u){
        setContentPane(panel1);
        setTitle("Login");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(1000, 800);// tamanno de la ventana
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MedicoVista vista = new MedicoVista(null);
            vista.setVisible(true);
        });
    }
    //Falta hacer los metodos para llamar a la pestanas




    //========================================================

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

    public JTextField getNombre_del_doctor() {
        return Nombre_del_doctor;
    }

    public void setNombre_del_doctor(JTextField nombre_del_doctor) {
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

    public void ListaMedicamentos() {
        tablaMedicamentos.setPreferredScrollableViewportSize(tablaMedicamentos.getPreferredSize());
    }


//=======================================================================
//Pestaña Preescribir


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


    public class RecetaMedicaActions {

        // Constructor donde se configuran las acciones
        public RecetaMedicaActions() {
            configurarAcciones();
        }

        private void configurarAcciones() {
            // Acción para Buscar Paciente
            if (buscarPacienteButton != null) {
                buscarPacienteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        abrirVentanaBuscarPaciente();
                    }
                });
            }

            // Acción para Agregar Medicamento
            if (agregarMedicamentoButton != null) {
                agregarMedicamentoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        abrirVentanaAgregarMedicamento();
                    }
                });
            }

            // Acción para Guardar
            if (guardarButton != null) {
                guardarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        accionGuardar();
                    }
                });
            }

            // Acción para Limpiar
            if (limpiarButton != null) {
                limpiarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        accionLimpiar();
                    }
                });
            }

            // Acción para Descartar Medicamento
            if (descartarMedicamentoButton != null) {
                descartarMedicamentoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        accionDescartarMedicamento();
                    }
                });
            }

            // Acción para Detalles
            if (detallesButton != null) {
                detallesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        accionDetalles();
                    }
                });
            }

            // Acción para el ComboBox de Fecha de Retiro (si es necesario)
//            if (opcionesFechaDeRetiro != null) {
//                opcionesFechaDeRetiro.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        accionCambioFechaRetiro();
//                    }
//                });
//            }
        }

        // Métodos para las acciones (solo abren ventanas vacías como solicitaste)
        private void abrirVentanaBuscarPaciente() {
            JFrame ventanaBuscarPaciente = new JFrame("Buscar Paciente");
            ventanaBuscarPaciente.setSize(400, 300);
            ventanaBuscarPaciente.setLocationRelativeTo(null);
            ventanaBuscarPaciente.setVisible(true);
        }

        private void abrirVentanaAgregarMedicamento() {
            JFrame ventanaAgregarMedicamento = new JFrame("Agregar Medicamento");
            ventanaAgregarMedicamento.setSize(400, 300);
            ventanaAgregarMedicamento.setLocationRelativeTo(null);
            ventanaAgregarMedicamento.setVisible(true);
        }

        private void accionGuardar() {
            // Solo muestra mensaje (sin implementar lógica real)
            JOptionPane.showMessageDialog(null, "Función Guardar - Por implementar");
        }

        private void accionLimpiar() {
            // Solo muestra mensaje (sin implementar lógica real)
            JOptionPane.showMessageDialog(null, "Función Limpiar - Por implementar");
        }

        private void accionDescartarMedicamento() {
            // Solo muestra mensaje (sin implementar lógica real)
            JOptionPane.showMessageDialog(null, "Función Descartar Medicamento - Por implementar");
        }

        private void accionDetalles() {
            // Solo muestra mensaje (sin implementar lógica real)
            JOptionPane.showMessageDialog(null, "Función Detalles - Por implementar");
        }

//        private void accionCambioFechaRetiro() {
//            // Actualiza el campo de texto con la selección del ComboBox
//            if (fechaDeRetiro != null && opcionesFechaDeRetiro != null) {
//                String seleccion = (String) opcionesFechaDeRetiro.getSelectedItem();
//                fechaDeRetiro.setText(seleccion != null ? seleccion : "");
//            }
//        }

    }

//=======================================================================


//=======================================================================
//Pestaña DashBoard

    public class DashboardActions {


        // Constructor donde se configuran las acciones
        public DashboardActions() {
            configurarAcciones();
        }

        private void configurarAcciones() {
            // Acción para Generar Rango
            if (btnGenerarRango != null) {
                btnGenerarRango.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionGenerarRango();
                        } catch (Exception ex) {
                            manejarExcepcion("Error al generar rango", ex);
                        }
                    }
                });
            }

            // Acción para Limpiar
            if (btnLimpiar != null) {
                btnLimpiar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionLimpiar();
                        } catch (Exception ex) {
                            manejarExcepcion("Error al limpiar", ex);
                        }
                    }
                });
            }

            // Acción para Botón Medicamentos
            if (medicamentosButton != null) {
                medicamentosButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionMedicamentos();
                        } catch (Exception ex) {
                            manejarExcepcion("Error en botón medicamentos", ex);
                        }
                    }
                });
            }

            // Acción para Botón Recetas
            if (recetasButton != null) {
                recetasButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionRecetas();
                        } catch (Exception ex) {
                            manejarExcepcion("Error en botón recetas", ex);
                        }
                    }
                });
            }

            // Acción para Agregar Mes
            if (btnAgregarMesButton != null) {
                btnAgregarMesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionAgregarMes();
                        } catch (Exception ex) {
                            manejarExcepcion("Error al agregar mes", ex);
                        }
                    }
                });
            }

            // Acción para Quitar Mes
            if (btnQuitarMesButton != null) {
                btnQuitarMesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            accionQuitarMes();
                        } catch (Exception ex) {
                            manejarExcepcion("Error al quitar mes", ex);
                        }
                    }
                });
            }
        }

        // Método para manejar excepciones
        private void manejarExcepcion(String mensaje, Exception ex) {
            System.err.println(mensaje + ": " + ex.getMessage());
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    mensaje + "\nError: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Métodos para las acciones
        private void accionGenerarRango() {
            try {
                System.out.println("Botón Generar Rango presionado");
                // Aquí iría la lógica para cargar datos en la tabla tblDatos
                if (tblDatos != null) {
                    System.out.println("Actualizando tabla de datos...");
                    // Simulación de carga de datos
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Medicamento");
                    model.addColumn("Cantidad");
                    model.addRow(new Object[]{"Acetaminofen", 100});
                    model.addRow(new Object[]{"Amoxicilina", 75});
                    tblDatos.setModel(model);
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error en generar rango", ex);
            }
        }

        private void accionLimpiar() {
            try {
                System.out.println("Botón Limpiar presionado");
                // Limpiar combos
                if (cmbDesdeAnnio != null) cmbDesdeAnnio.setSelectedIndex(0);
                if (cmbDesdeMes != null) cmbDesdeMes.setSelectedIndex(0);
                if (cmbHastaAnio != null) cmbHastaAnio.setSelectedIndex(0);
                if (cmbHastaMes != null) cmbHastaMes.setSelectedIndex(0);
                if (cmbMedicamento != null) cmbMedicamento.setSelectedIndex(0);

                // Limpiar tabla
                if (tblDatos != null) {
                    DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();
                    model.setRowCount(0);
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error al limpiar", ex);
            }
        }

        private void accionMedicamentos() {
            try {
                System.out.println("Botón Medicamentos presionado");
                // Filtrar tabla para mostrar solo datos de medicamentos
                if (tblDatos != null) {
                    System.out.println("Filtrando por medicamentos...");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error en botón medicamentos", ex);
            }
        }

        private void accionRecetas() {
            try {
                System.out.println("Botón Recetas presionado");
                // Filtrar tabla para mostrar solo datos de recetas
                if (tblDatos != null) {
                    System.out.println("Filtrando por recetas...");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error en botón recetas", ex);
            }
        }

        private void accionAgregarMes() {
            try {
                System.out.println("Botón Agregar Mes presionado");
                // Agregar columna de mes a la tabla
                if (tblDatos != null) {
                    System.out.println("Agregando columna de mes...");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error al agregar mes", ex);
            }
        }

        private void accionQuitarMes() {
            try {
                System.out.println("Botón Quitar Mes presionado");
                // Quitar columna de mes de la tabla
                if (tblDatos != null) {
                    System.out.println("Quitando columna de mes...");
                }
            } catch (Exception ex) {
                throw new RuntimeException("Error al quitar mes", ex);
            }
        }


//=======================================================================
// Graficos de dashboard------------------------------------------------

        public void graficoMedicamentos() {
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


//=======================================================================
//Pestaña Historico


        public class HistoricoActions {


            // Constructor donde se configuran las acciones
            public HistoricoActions() {
                configurarAcciones();
            }

            private void configurarAcciones() {
                // Acción para Buscar Histórico
                if (ButtonBuscarHistorico != null) {
                    ButtonBuscarHistorico.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                accionBuscarHistorico();
                            } catch (Exception ex) {
                                manejarExcepcion("Error al buscar histórico", ex);
                            }
                        }
                    });
                }

                // Acción para el ComboBox de búsqueda
                if (cmbBuscarRecetasHistorico != null) {
                    cmbBuscarRecetasHistorico.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                accionCambioBusqueda();
                            } catch (Exception ex) {
                                manejarExcepcion("Error al cambiar búsqueda", ex);
                            }
                        }
                    });
                }
            }

            // Método para manejar excepciones
            private void manejarExcepcion(String mensaje, Exception ex) {
                System.err.println(mensaje + ": " + ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        mensaje + "\nError: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Métodos para las acciones
            private void accionBuscarHistorico() {
                try {
                    System.out.println("Botón Buscar Histórico presionado");

                    // Cargar datos en ambas tablas
                    cargarTablaMedicamentos();
                    cargarTablaRecetas();

                } catch (Exception ex) {
                    throw new RuntimeException("Error en buscar histórico", ex);
                }
            }

            private void accionCambioBusqueda() {
                try {
                    String criterio = (String) cmbBuscarRecetasHistorico.getSelectedItem();
                    System.out.println("Criterio de búsqueda cambiado: " + criterio);

                    // Filtrar las tablas según el criterio seleccionado
                    filtrarTablas(criterio);

                } catch (Exception ex) {
                    throw new RuntimeException("Error al cambiar búsqueda", ex);
                }
            }

            private void cargarTablaMedicamentos() {
                try {
                    if (tableHistoricoMedicamentos != null) {
                        // Datos de ejemplo para medicamentos
                        String[] columnasMedicamentos = {"Medicamento", "Cantidad", "Fecha", "Paciente"};
                        Object[][] datosMedicamentos = {
                                {"Acetaminofen", 100, "2025-08-15", "Juan Pérez"},
                                {"Amoxicilina", 75, "2025-08-16", "María García"},
                                {"Ibuprofeno", 50, "2025-08-17", "Carlos López"}
                        };

                        DefaultTableModel model = new DefaultTableModel(datosMedicamentos, columnasMedicamentos);
                        tableHistoricoMedicamentos.setModel(model);
                        System.out.println("Tabla de medicamentos cargada");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException("Error al cargar tabla de medicamentos", ex);
                }
            }

            private void cargarTablaRecetas() {
                try {
                    if (tableHistoricoRecetas != null) {
                        // Datos de ejemplo para recetas
                        String[] columnasRecetas = {"N° Receta", "Médico", "Fecha", "Estado", "Paciente"};
                        Object[][] datosRecetas = {
                                {"REC-001", "Dr. Rodríguez", "2025-08-15", "Entregada", "Juan Pérez"},
                                {"REC-002", "Dra. Martínez", "2025-08-16", "Proceso", "María García"},
                                {"REC-003", "Dr. González", "2025-08-17", "Confeccionada", "Carlos López"}
                        };

                        DefaultTableModel model = new DefaultTableModel(datosRecetas, columnasRecetas);
                        tableHistoricoRecetas.setModel(model);
                        System.out.println("Tabla de recetas cargada");
                    }
                } catch (Exception ex) {
                    throw new RuntimeException("Error al cargar tabla de recetas", ex);
                }
            }

            private void filtrarTablas(String criterio) {
                try {
                    System.out.println("Filtrando tablas con criterio: " + criterio);

                    // Aquí iría la lógica de filtrado según el criterio
                    // Por ahora solo mostramos mensajes
                    if (tableHistoricoMedicamentos != null) {
                        System.out.println("Filtrando tabla de medicamentos...");
                    }

                    if (tableHistoricoMedicamentos != null) {
                        System.out.println("Filtrando tabla de recetas...");
                    }

                } catch (Exception ex) {
                    throw new RuntimeException("Error al filtrar tablas", ex);
                }
            }

//=======================================================================






            //=================================================================================
//Pestaña Acerca de
            private void cargarImagenHospital() {
                try {
                    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Imagenes_Luis/hospital.png"));
                    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    fotoHospital.setIcon(new ImageIcon(imagenEscalada));
                } catch (Exception e) {
                    System.err.println("No se pudo cargar la imagen hospital.png");
                    e.printStackTrace();
                }
            }
        }
    }
}

//================================================================




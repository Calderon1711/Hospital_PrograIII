package Vista;

import Modelo.Personal;

import javax.swing.*;

public class Agregar_Medicamento extends JFrame{
    private JComboBox cmbNombreMedicamentos;
    private JTextField SugerenciasMedicamentos;
    private JButton cancelButton;
    private JButton btnOk;
    private JTable table1;
    private JScrollPane TableMedicamentos;
    private JPanel Agregar_Medicamento;


    //-------------------------------------------------------
    //Getters y Seterrs

    public Agregar_Medicamento(Personal u) {
        setContentPane(Agregar_Medicamento);
        setTitle("Agregar Medicamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Agregar_Medicamento vista = new Agregar_Medicamento(null);
            vista.setVisible(true);
        });
    }

}

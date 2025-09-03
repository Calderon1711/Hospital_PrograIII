package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginVista extends JFrame {
    private JPanel MainPanel;
    private JLabel TextoBienvenida;
    private JTextField CampoID;
    private JButton BotonPrueba;
    private JTextField CampoClave;
    private JLabel TextoID;
    private JLabel TextoClave;
    private JButton cancelarButton;
    private JButton cambiarContraseñaButton;
    private JButton ingresarButton;

    public LoginVista() {
        setContentPane(MainPanel);
        setTitle("Login"); //titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//al salir se cierra el programa
        setSize(1000, 800);//size
        setLocationRelativeTo(null);
        setVisible(true);
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String iD = CampoID.getText();
                JOptionPane.showMessageDialog(LoginVista.this, "Bienvenido "+ iD);
            }



        });
    }

    public static void main(String[] args) {
        new LoginVista();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

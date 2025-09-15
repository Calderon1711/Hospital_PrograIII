package app;
// App.java
import javax.swing.*;

import Controlador.ControladorGeneral;
import Controlador.ControladorLogin;
import Modelo.Hospital;
import Vista.FarmaceuticoVista;
import Vista.LoginVista1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Hospital hospi=Hospital.getInstance();
            //cargar datos
            hospi.cargarPersonal();
            hospi.cargarPacientes();
            hospi.cargarMedicamentos();
            hospi.cargarRecetas();
            LoginVista1 vista = new LoginVista1();
            ControladorGeneral controlGeneral = new ControladorGeneral();
            new ControladorLogin(vista, controlGeneral);// ← aquí está bien
            vista.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            vista.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Guardar TODO
                    hospi.guradarPersonal();
                    hospi.guardarRecetas();
                    hospi.guardarMedicamentos();
                    hospi.guardarPacientes();

                    System.out.println(" Datos guardados correctamente antes de cerrar.");
                    System.exit(0);
                }
            });


            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
        System.out.println("Vista Iniciada");
    }
}


package app;
// App.java
import javax.swing.SwingUtilities;
import Modelo.GestorUsuario;
import Controlador.ControladorGeneral;
import Controlador.ControladorLogin;
import Modelo.Hospital;
import Vista.LoginVista1;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Hospital.getInstance();
            LoginVista1 vista = new LoginVista1();
            ControladorGeneral controlGeneral = new ControladorGeneral();
            new ControladorLogin(vista, controlGeneral); // ← aquí está bien
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
        System.out.println("Vista Iniciada");
    }
}


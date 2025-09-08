package Vista;

import Modelo.Usuario;
import Modelo.Personal;
import javax.swing.*;

public class AdminVista extends JFrame {

    public AdminVista(Personal u) {
        setTitle("Login");// le pongo titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para q cuando la aplicacion cierre el programa tambnien
        setSize(1000, 800);// tamanno de la ventana
        setLocationRelativeTo(null);
    }
}

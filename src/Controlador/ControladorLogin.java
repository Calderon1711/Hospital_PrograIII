package Controlador;

// ControladorLogin.java
import Modelo.GestorUsuario;
import Modelo.Personal;
import Modelo.Usuario;
import Vista.LoginVista1;
import Modelo.Hospital;
import Modelo.Personal;

import javax.swing.*;
import java.util.Arrays;

public class ControladorLogin {
    private final LoginVista1 vista;

    private final ControladorGeneral appController;

    public ControladorLogin(LoginVista1 vista, ControladorGeneral appController) {
        this.vista = vista;

        this.appController = appController;
        initController();
    }

    private void initController() {
        vista.getBotonIngresar().addActionListener(e -> onIngresar());
        vista.getBotonCancelar().addActionListener(e -> onCancelar());
        vista.getBotonCambiarContra().addActionListener(e -> onCambiarContra());
        vista.getCampoClave().addActionListener(e -> onIngresar()); // Enter en contraseña
    }

    private void onIngresar() {
        String username = vista.getCampoUsuario().getText().trim();
        char[] passChars = vista.getCampoClave().getPassword();
        String password = new String(passChars);

        // limpiar array por seguridad
        Arrays.fill(passChars, '\0');

        vista.getMSJ_Error().setText(""); // limpiar mensaje previo

        if (username.isEmpty() || password.isEmpty()) {
            vista.getMSJ_Error().setText("Ingrese usuario y contraseña.");
            return;
        }

        Personal usuario =Hospital.getInstance().loginPersonal(username, password);

        if (usuario != null) {
            // autenticación OK -> delegar al controlador general
            appController.abrirVistaPorRol(usuario);
            vista.dispose(); // cerramos el login
        } else {
            vista.getMSJ_Error().setText("Usuario o contraseña incorrectos.");
            vista.getCampoClave().setText("");
            vista.getCampoUsuario().requestFocusInWindow();
        }
    }

    private void onCancelar() {
        vista.getCampoUsuario().setText("");
        vista.getCampoClave().setText("");
        vista.getMSJ_Error().setText("");
        vista.getCampoUsuario().requestFocusInWindow();
    }

    private void onCambiarContra() {
        // Implementación simple por ahora
        JOptionPane.showMessageDialog(vista, "Funcionalidad de cambiar contraseña (pendiente).");
    }
}


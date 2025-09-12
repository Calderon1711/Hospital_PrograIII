package Modelo;
import java.util.HashMap;
import java.util.Map;


public class GestorUsuario {

    private final Map<String, String> passwords = new HashMap<>();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public GestorUsuario() {
        // usuarios de prueba
        agregarUsuario("1","med1", "med123", "Dr. Juan Pérez", Rol.MEDICO);
        agregarUsuario("2","farm1", "farm123", "Ana Gómez", Rol.FARMACEUTICO);
        agregarUsuario("3","admin", "admin123", "Administrador", Rol.ADMINISTRADOR);
    }

    public void agregarUsuario(String id,String username, String password, String nombre, Rol rol) {
        passwords.put(username, password);
        usuarios.put(username, new Usuario(id,password, nombre, rol));
    }

    /**
     * Intenta autenticar; devuelve Usuario si OK o null si falla.
     */
    public Usuario login(String username, String password) {
        if (username == null || password == null) return null;
        String pw = passwords.get(username);
        if (pw != null && pw.equals(password)) {
            return usuarios.get(username);
        }
        return null;
    }
}

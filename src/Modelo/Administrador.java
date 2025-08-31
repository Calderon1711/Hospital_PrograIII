package Modelo;

public class Administrador extends Personal{
    public Administrador() {
    }

    public Administrador(String nombre, String id, String clave) {
        super(nombre, id, clave);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "clave='" + clave + '\'' +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}

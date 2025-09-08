package Modelo;

public class Administrador extends Personal {
    public Administrador(String nombre, String id, String clave) {
        super(nombre, id, clave);
        this.rol = Rol.ADMINISTRADOR;
    }

    public Administrador() {
    }


    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }

    @Override
    public String tipo() {
        return "Administrador";
    }
}
